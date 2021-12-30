package hylanda.library.entity;

import hylanda.content.server.init.EntityInit;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import tyrannotitanlib.library.tyrannomation.core.ITyrannomatable;
import tyrannotitanlib.library.tyrannomation.core.PlayState;
import tyrannotitanlib.library.tyrannomation.core.builder.TyrannomationBuilder;
import tyrannotitanlib.library.tyrannomation.core.controller.TyrannomationController;
import tyrannotitanlib.library.tyrannomation.core.event.predicate.TyrannomationEvent;
import tyrannotitanlib.library.tyrannomation.core.manager.TyrannomationData;
import tyrannotitanlib.library.tyrannomation.core.manager.TyrannomationFactory;

public class BioDeerEntity extends AnimalEntity implements ITyrannomatable
{
	protected static final DataParameter<Byte> SEX = EntityDataManager.defineId(BioDeerEntity.class, DataSerializers.BYTE);	
	private TyrannomationFactory factory = new TyrannomationFactory(this);
	
	public static final String SEX_TAG = "Sex";
	
	private <E extends ITyrannomatable> PlayState predicate(TyrannomationEvent<E> event) 
	{				
		if(event.isMoving())
		{
			event.getController().setAnimation(new TyrannomationBuilder().addAnimation("animation.bio_deer.walk", true));
		}
		else
		{
			event.getController().setAnimation(new TyrannomationBuilder().addAnimation("animation.bio_deer.idle", true));
		}
		
		return PlayState.CONTINUE;
	}
	
	public BioDeerEntity(EntityType<? extends BioDeerEntity> entity, World world) 
	{
		super(entity, world);
	}
	
	public static AttributeModifierMap.MutableAttribute makeAttributes() 
	{
		return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 42.0D).add(Attributes.MOVEMENT_SPEED, 0.4F).add(Attributes.ATTACK_DAMAGE, 5.0D).add(Attributes.FOLLOW_RANGE, 35.0D);
	} 
	
	@Override
	public void registerControllers(TyrannomationData data) 
	{
		data.addAnimationController(new TyrannomationController<ITyrannomatable>(this, "controller", 0, this::predicate));
	}
	
	@Override
	public TyrannomationFactory getFactory() 
	{
		return this.factory;
	}
	
	@Override
	protected void registerGoals() 
	{
		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.goalSelector.addGoal(1, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new LookAtGoal(this, PlayerEntity.class, 6.0F));
		this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
		if(this.getSex() == 1)
		{
			this.goalSelector.addGoal(5, new PanicGoal(this, 1.4D));
			this.goalSelector.addGoal(6, new AvoidEntityGoal<>(this, GojirasaurusEntity.class, 8.0F, 0.5D, 0.5D));
		}
		if(this.getSex() == 0)
		{
			this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.0D, false));
			this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, GojirasaurusEntity.class, false));
		}
	}
	
	@Override
	protected void defineSynchedData() 
	{
		super.defineSynchedData();
		byte sex = (byte) random.nextInt(2);
		this.entityData.define(SEX, sex);
	}
	
	@Override
	public void addAdditionalSaveData(CompoundNBT nbt) 
	{
		super.addAdditionalSaveData(nbt);
		nbt.putByte(SEX_TAG, getSex());
	}
	
	@Override
	public void readAdditionalSaveData(CompoundNBT nbt) 
	{
		super.readAdditionalSaveData(nbt);
		setSex(nbt.getByte(SEX_TAG));
	}
	
	public byte getSex() 
	{
		return entityData.get(SEX);
	}
	
	public void setSex(byte sex) 
	{
		entityData.set(SEX, sex);
	}
	
	@Override
	public AgeableEntity getBreedOffspring(ServerWorld world, AgeableEntity entity) 
	{
		return EntityInit.BIO_DEER.create(world);
	}
}