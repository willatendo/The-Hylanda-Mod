package hylanda.server.entity;

import java.util.UUID;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import hylanda.server.entity.goal.BioDeerAvoidEntityGoal;
import hylanda.server.entity.goal.BioDeerMeleeAttackGoal;
import hylanda.server.entity.goal.BioDeerPanicGoal;
import hylanda.server.entity.goal.ReasonedAttackableTargetGoal;
import hylanda.server.item.BioDeerArmourItem;
import hylanda.server.item.HylandaItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.Container;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.NeutralMob;
import net.minecraft.world.entity.SlotAccess;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RunAroundLikeCrazyGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class BioDeer extends AbstractHorse implements NeutralMob, IAnimatable, AttackAnimations {
	protected static final EntityDataAccessor<Integer> DATA_REMAINING_ANGER_TIME = SynchedEntityData.defineId(BioDeer.class, EntityDataSerializers.INT);
	protected static final EntityDataAccessor<Byte> SEX = SynchedEntityData.defineId(BioDeer.class, EntityDataSerializers.BYTE);
	protected static final EntityDataAccessor<Byte> ANIMATION = SynchedEntityData.defineId(BioDeer.class, EntityDataSerializers.BYTE);

	private static final UniformInt PERSISTENT_ANGER_TIME = TimeUtil.rangeOfSeconds(20, 39);
	private static final UUID ARMOR_MODIFIER_UUID = UUID.fromString("556E1665-8B10-40C8-8F9D-CF9B1667F295");

	private AnimationFactory factory = new AnimationFactory(this);

	public static final byte ANIMATION_IDLE = 0;
	public static final byte ANIMATION_GRAZE = 1;
	public static final byte ANIMATION_ATTACK = 2;
	public static final byte ANIMATION_CHARGE_ATTACK = 4;

	public static final AnimationBuilder IDLE_ANIMATION = new AnimationBuilder().addAnimation("idle", true);
	public static final AnimationBuilder GRAZE_ANIMATION = new AnimationBuilder().addAnimation("graze", true);
	public static final AnimationBuilder ATTACK_ANIMATION = new AnimationBuilder().addAnimation("attack", true);
	public static final AnimationBuilder WALK_ANIMATION = new AnimationBuilder().addAnimation("walk", true);
	public static final AnimationBuilder CHARGE_ATTACK_ANIMATION = new AnimationBuilder().addAnimation("charge_attack", true);

	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		boolean isMoving = event.isMoving();
		AnimationController controller = event.getController();

		byte currentAnimation = this.getAnimation();
		switch (currentAnimation) {
		case ANIMATION_GRAZE:
			controller.setAnimation(GRAZE_ANIMATION);
			break;
		case ANIMATION_ATTACK:
			controller.setAnimation(ATTACK_ANIMATION);
			break;
		case ANIMATION_CHARGE_ATTACK:
			controller.setAnimation(CHARGE_ATTACK_ANIMATION);
			break;
		default:
			controller.setAnimation(isMoving ? WALK_ANIMATION : IDLE_ANIMATION);
			break;
		}

		return PlayState.CONTINUE;
	}

	private UUID persistentAngerTarget;

	public BioDeer(EntityType<? extends BioDeer> entity, Level world) {
		super(entity, world);
	}

	public static AttributeSupplier.Builder makeAttributes() {
		return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 42.0D).add(Attributes.MOVEMENT_SPEED, 0.4F).add(Attributes.ATTACK_DAMAGE, 5.0D).add(Attributes.FOLLOW_RANGE, 35.0D).add(Attributes.JUMP_STRENGTH, 1.0D);
	}

	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController<IAnimatable>(this, "controller", 0, this::predicate));
	}

	@Override
	public AnimationFactory getFactory() {
		return this.factory;
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new RunAroundLikeCrazyGoal(this, 1.2D));
		this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(5, new BioDeerPanicGoal(this, 1.4D));
		this.goalSelector.addGoal(6, new BioDeerAvoidEntityGoal(this, Gojirasaurus.class, 8.0F, 0.5D, 0.5D));
		this.goalSelector.addGoal(5, new BioDeerMeleeAttackGoal(this, 1.0D, false));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Gojirasaurus.class, false));
		this.targetSelector.addGoal(1, new ReasonedAttackableTargetGoal<>(this, Player.class, this::isAngryAt));
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		byte sex = (byte) this.random.nextInt(2);
		this.entityData.define(SEX, sex);
		this.entityData.define(ANIMATION, ANIMATION_IDLE);
		this.entityData.define(DATA_REMAINING_ANGER_TIME, 0);
	}

	@Override
	public void setAnimation(byte animation) {
		this.entityData.set(ANIMATION, animation);
	}

	public byte getAnimation() {
		return this.entityData.get(ANIMATION);
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compoundTag) {
		super.addAdditionalSaveData(compoundTag);
		compoundTag.putByte("Sex", getSex());
		this.addPersistentAngerSaveData(compoundTag);
		if (!this.inventory.getItem(1).isEmpty()) {
			compoundTag.put("ArmorItem", this.inventory.getItem(1).save(new CompoundTag()));
		}
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compoundTag) {
		super.readAdditionalSaveData(compoundTag);
		this.setSex(compoundTag.getByte("Sex"));
		if (!this.level.isClientSide()) {
			this.readPersistentAngerSaveData((ServerLevel) this.level, compoundTag);
		}
		if (compoundTag.contains("ArmorItem", 10)) {
			ItemStack itemstack = ItemStack.of(compoundTag.getCompound("ArmorItem"));
			if (!itemstack.isEmpty() && this.isArmor(itemstack)) {
				this.inventory.setItem(1, itemstack);
			}
		}

		this.updateContainerEquipment();
	}

	@Override
	public void containerChanged(Container contaier) {
		ItemStack itemstack = this.getArmor();
		super.containerChanged(contaier);
		ItemStack itemstack1 = this.getArmor();
		if (this.tickCount > 20 && this.isArmor(itemstack1) && itemstack != itemstack1) {
			this.playSound(SoundEvents.HORSE_ARMOR, 0.5F, 1.0F);
		}
	}

	@Override
	protected void updateContainerEquipment() {
		if (!this.level.isClientSide) {
			super.updateContainerEquipment();
			this.setArmorEquipment(this.inventory.getItem(1));
			this.setDropChance(EquipmentSlot.CHEST, 0.0F);
		}
	}

	@Override
	public void equipSaddle(SoundSource soundSource) {
		this.inventory.setItem(0, new ItemStack(HylandaItems.BIO_DEER_SADDLE.get()));
		if (soundSource != null) {
			this.level.playSound((Player) null, this, SoundEvents.HORSE_SADDLE, soundSource, 0.5F, 1.0F);
		}
	}

	private void setArmor(ItemStack itemStack) {
		this.setItemSlot(EquipmentSlot.CHEST, itemStack);
		this.setDropChance(EquipmentSlot.CHEST, 0.0F);
	}

	private void setArmorEquipment(ItemStack itemStack) {
		this.setArmor(itemStack);
		if (!this.level.isClientSide) {
			this.getAttribute(Attributes.ARMOR).removeModifier(ARMOR_MODIFIER_UUID);
			if (this.isArmor(itemStack)) {
				int i = ((BioDeerArmourItem) itemStack.getItem()).getProtection();
				if (i != 0) {
					this.getAttribute(Attributes.ARMOR).addTransientModifier(new AttributeModifier(ARMOR_MODIFIER_UUID, "Horse armor bonus", (double) i, AttributeModifier.Operation.ADDITION));
				}
			}
		}

	}

	@Override
	public InteractionResult mobInteract(Player player, InteractionHand interactionHand) {
		ItemStack itemstack = player.getItemInHand(interactionHand);
		if (!this.isBaby()) {
			if (this.isTamed() && player.isSecondaryUseActive()) {
				this.openCustomInventoryScreen(player);
				return InteractionResult.sidedSuccess(this.level.isClientSide);
			}

			if (this.isVehicle()) {
				return super.mobInteract(player, interactionHand);
			}
		}

		if (!itemstack.isEmpty()) {
			if (this.isFood(itemstack)) {
				return this.fedFood(player, itemstack);
			}

			InteractionResult interactionresult = itemstack.interactLivingEntity(player, this, interactionHand);
			if (interactionresult.consumesAction()) {
				return interactionresult;
			}

			if (!this.isTamed()) {
				this.makeMad();
				return InteractionResult.sidedSuccess(this.level.isClientSide);
			}

			boolean flag = !this.isBaby() && !this.isSaddled() && itemstack.is(HylandaItems.BIO_DEER_SADDLE.get());
			if (this.isArmor(itemstack) || flag) {
				this.openCustomInventoryScreen(player);
				return InteractionResult.sidedSuccess(this.level.isClientSide);
			}
		}

		if (this.isBaby()) {
			return super.mobInteract(player, interactionHand);
		} else {
			this.doPlayerRide(player);
			return InteractionResult.sidedSuccess(this.level.isClientSide);
		}
	}

	private SlotAccess createEquipmentSlotAccess(int slot, Predicate<ItemStack> itemStackPredicate) {
		return new SlotAccess() {
			@Override
			public ItemStack get() {
				return BioDeer.this.inventory.getItem(slot);
			}

			@Override
			public boolean set(ItemStack itemStack) {
				if (!itemStackPredicate.test(itemStack)) {
					return false;
				} else {
					BioDeer.this.inventory.setItem(slot, itemStack);
					BioDeer.this.updateContainerEquipment();
					return true;
				}
			}
		};
	}

	@Override
	public SlotAccess getSlot(int slot) {
		int i = slot - 400;
		if (i >= 0 && i < 2 && i < this.inventory.getContainerSize()) {
			if (i == 0) {
				return this.createEquipmentSlotAccess(i, (itemStack) -> {
					return itemStack.isEmpty() || itemStack.is(HylandaItems.BIO_DEER_SADDLE.get());
				});
			}

			if (i == 1) {
				if (!this.canWearArmor()) {
					return SlotAccess.NULL;
				}

				return this.createEquipmentSlotAccess(i, (itemStack) -> {
					return itemStack.isEmpty() || this.isArmor(itemStack);
				});
			}
		}

		int j = slot - 500 + 2;
		return j >= 2 && j < this.inventory.getContainerSize() ? SlotAccess.forContainer(this.inventory, j) : super.getSlot(slot);
	}

	@Override
	public double getPassengersRidingOffset() {
		return 1.15D;
	}

	@Override
	public boolean canWearArmor() {
		return true;
	}

	@Override
	public boolean isArmor(ItemStack itemStack) {
		return itemStack.getItem() instanceof BioDeerArmourItem;
	}

	public ItemStack getArmor() {
		return this.getItemBySlot(EquipmentSlot.CHEST);
	}

	@Override
	protected void customServerAiStep() {
		super.customServerAiStep();

		if (!this.level.isClientSide()) {
			this.updatePersistentAnger((ServerLevel) this.level, true);
		}
	}

	@Override
	public int getRemainingPersistentAngerTime() {
		return this.entityData.get(DATA_REMAINING_ANGER_TIME);
	}

	@Override
	public void setRemainingPersistentAngerTime(int anger) {
		this.entityData.set(DATA_REMAINING_ANGER_TIME, anger);
	}

	@Override
	public UUID getPersistentAngerTarget() {
		return this.persistentAngerTarget;
	}

	@Override
	public void setPersistentAngerTarget(@Nullable UUID uuid) {
		this.persistentAngerTarget = uuid;
	}

	@Override
	public void startPersistentAngerTimer() {
		this.setRemainingPersistentAngerTime(PERSISTENT_ANGER_TIME.sample(this.random));
	}

	public byte getSex() {
		return this.entityData.get(SEX);
	}

	public void setSex(byte sex) {
		this.entityData.set(SEX, sex);
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel world, AgeableMob entity) {
		return HylandaEntities.BIO_DEER.get().create(world);
	}

	@Override
	public byte getAttackAnimation() {
		return ANIMATION_ATTACK;
	}

	@Override
	public byte getIdleAnimation() {
		return ANIMATION_IDLE;
	}
}
