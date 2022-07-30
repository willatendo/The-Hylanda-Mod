package hylanda.server.entity;

import hylanda.server.entity.goal.AnimatedAttackGoal;
import hylanda.server.entity.goal.GojirasaurusSwimGoal;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class Gojirasaurus extends Animal implements IAnimatable, AttackAnimations {
	protected static final EntityDataAccessor<Byte> ANIMATION = SynchedEntityData.defineId(Gojirasaurus.class, EntityDataSerializers.BYTE);

	private AnimationFactory factory = new AnimationFactory(this);

	public static final byte ANIMATION_IDLE = 0;
	public static final byte ANIMATION_SLEEP = 1;
	public static final byte ANIMATION_LASER_ATTACK = 2;
	public static final byte ANIMATION_BITE_ATTACK = 3;
	public static final byte ANIMATION_WALK = 4;
	public static final byte ANIMATION_SWIM = 5;
	public static final byte ANIMATION_SWIPE_ATTACK = 6;

	public static final AnimationBuilder IDLE_ANIMATION = new AnimationBuilder().addAnimation("idle", true);
	public static final AnimationBuilder SLEEP_ANIMATION = new AnimationBuilder().addAnimation("sleep", true);
	public static final AnimationBuilder LASER_ATTACK_ANIMATION = new AnimationBuilder().addAnimation("threaten").addAnimation("laser.attack", true);
	public static final AnimationBuilder BITE_ATTACK_ANIMATION = new AnimationBuilder().addAnimation("threaten").addAnimation("bite.attack", true);
	public static final AnimationBuilder WALK_ANIMATION = new AnimationBuilder().addAnimation("walk", true);
	public static final AnimationBuilder SWIM_ANIMATION = new AnimationBuilder().addAnimation("swim", true);
	public static final AnimationBuilder SWIPE_ATTACK_ANIMATION = new AnimationBuilder().addAnimation("threaten").addAnimation("swipe.attack", true);

	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		float limbSwingAmount = event.getLimbSwingAmount();
		boolean isMoving = !(limbSwingAmount > -0.05F && limbSwingAmount < 0.05F);
		AnimationController controller = event.getController();

		byte currentAnimation = this.getAnimation();
		switch (currentAnimation) {
		case ANIMATION_SLEEP:
			controller.setAnimation(SLEEP_ANIMATION);
			break;
		case ANIMATION_LASER_ATTACK:
			controller.setAnimation(LASER_ATTACK_ANIMATION);
			break;
		case ANIMATION_BITE_ATTACK:
			controller.setAnimation(BITE_ATTACK_ANIMATION);
			break;
		case ANIMATION_SWIM:
			controller.setAnimation(SWIM_ANIMATION);
			break;
		case ANIMATION_SWIPE_ATTACK:
			controller.setAnimation(SWIPE_ATTACK_ANIMATION);
			break;
		default:
			controller.setAnimation(isMoving ? WALK_ANIMATION : IDLE_ANIMATION);
			break;
		}

		return PlayState.CONTINUE;
	}

	public Gojirasaurus(EntityType<? extends Gojirasaurus> entity, Level world) {
		super(entity, world);
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(ANIMATION, ANIMATION_IDLE);
	}

	public static AttributeSupplier.Builder makeAttributes() {
		return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 250.0D).add(Attributes.MOVEMENT_SPEED, 0.2F).add(Attributes.ATTACK_DAMAGE, 21.0D).add(Attributes.FOLLOW_RANGE, 35.0D);
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
		this.goalSelector.addGoal(0, new GojirasaurusSwimGoal(this));
		this.goalSelector.addGoal(1, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(5, new AnimatedAttackGoal(this, 1.2F, false));
		this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, BioDeer.class, false));
		this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, Player.class, true));
	}

	public byte getAnimation() {
		return this.entityData.get(ANIMATION);
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel world, AgeableMob entity) {
		return HylandaEntities.GOJIRASAURUS.get().create(world);
	}

	@Override
	public void setAnimation(byte animation) {
		this.entityData.set(ANIMATION, animation);
	}

	@Override
	public byte getAttackAnimation() {
		return ANIMATION_BITE_ATTACK;
	}

	@Override
	public byte getIdleAnimation() {
		return ANIMATION_IDLE;
	}
}