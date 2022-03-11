package hylanda.library.entity;

import hylanda.content.server.init.HylandaEntities;
import hylanda.library.entity.goal.BioDeerAvoidEntityGoal;
import hylanda.library.entity.goal.BioDeerMeleeAttackGoal;
import hylanda.library.entity.goal.BioDeerPanicGoal;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import tyrannotitanlib.tyrannimation.core.AnimationEndTypes;
import tyrannotitanlib.tyrannimation.core.IAnimated;
import tyrannotitanlib.tyrannimation.core.builder.AnimationBuilder;
import tyrannotitanlib.tyrannimation.core.controller.AnimationController;
import tyrannotitanlib.tyrannimation.core.event.predicate.AnimationEvent;
import tyrannotitanlib.tyrannimation.core.manager.AnimatedData;
import tyrannotitanlib.tyrannimation.core.manager.AnimatedFactory;

public class BioDeer extends Animal implements IAnimated {
	protected static final EntityDataAccessor<Byte> SEX = SynchedEntityData.defineId(BioDeer.class, EntityDataSerializers.BYTE);
	private AnimatedFactory factory = new AnimatedFactory(this);

	public static final String SEX_TAG = "Sex";

	private <E extends IAnimated> AnimationEndTypes predicate(AnimationEvent<E> event) {
		if (event.isMoving()) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.bio_deer.walk", true));
		} else {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.bio_deer.idle", true));
		}

		return AnimationEndTypes.CONTINUE;
	}

	public BioDeer(EntityType<? extends BioDeer> entity, Level world) {
		super(entity, world);
	}

	public static AttributeSupplier makeAttributes() {
		return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 42.0D).add(Attributes.MOVEMENT_SPEED, 0.4F).add(Attributes.ATTACK_DAMAGE, 5.0D).add(Attributes.FOLLOW_RANGE, 35.0D).build();
	}

	@Override
	public void registerAnimationControl(AnimatedData data) {
		data.addAnimatedController(new AnimationController<IAnimated>(this, "controller", 0, this::predicate));
	}

	@Override
	public AnimatedFactory getAnimationFactory() {
		return this.factory;
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(5, new BioDeerPanicGoal(this, 1.4D));
		this.goalSelector.addGoal(6, new BioDeerAvoidEntityGoal(this, Gojirasaurus.class, 8.0F, 0.5D, 0.5D));
		this.goalSelector.addGoal(5, new BioDeerMeleeAttackGoal(this, 1.0D, false));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Gojirasaurus.class, false));
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		byte sex = (byte) random.nextInt(2);
		this.entityData.define(SEX, sex);
	}

	@Override
	public void addAdditionalSaveData(CompoundTag nbt) {
		super.addAdditionalSaveData(nbt);
		nbt.putByte(SEX_TAG, getSex());
	}

	@Override
	public void readAdditionalSaveData(CompoundTag nbt) {
		super.readAdditionalSaveData(nbt);
		setSex(nbt.getByte(SEX_TAG));
	}

	public byte getSex() {
		return entityData.get(SEX);
	}

	public void setSex(byte sex) {
		entityData.set(SEX, sex);
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel world, AgeableMob entity) {
		return HylandaEntities.BIO_DEER.get().create(world);
	}
}
