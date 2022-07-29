package hylanda.server.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.Level;

public class DetectedOreBlock extends Animal {
	private int lifetime = 100;

	public DetectedOreBlock(EntityType<? extends DetectedOreBlock> entityType, Level level) {
		super(entityType, level);
	}

	public static AttributeSupplier.Builder makeAttributes() {
		return Animal.createMobAttributes().add(Attributes.MAX_HEALTH, 1.0D);
	}

	@Override
	public void tick() {
		if (!this.level.isClientSide()) {
			this.lifetime--;
		}

		if (this.lifetime == 0) {
			this.discard();
		}
	}

	@Override
	public boolean canBeCollidedWith() {
		return false;
	}

	@Override
	public boolean isPushable() {
		return false;
	}

	@Override
	public boolean isCurrentlyGlowing() {
		return true;
	}

	@Override
	public boolean isDamageSourceBlocked(DamageSource damageSource) {
		return damageSource != DamageSource.OUT_OF_WORLD;
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compoundTag) {
		this.lifetime = compoundTag.getInt("Lifetime");
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compoundTag) {
		compoundTag.putInt("Lifetime", this.lifetime);
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
		return null;
	}
}
