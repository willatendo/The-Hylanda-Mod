package hylanda.library.entity.goal;

import hylanda.library.entity.BioDeerEntity;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;

public class BioDeerMeleeAttackGoal extends MeleeAttackGoal {
	private final BioDeerEntity entity;

	public BioDeerMeleeAttackGoal(BioDeerEntity entity, double speedModifier, boolean followingTargetEvenIfNotSeen) {
		super(entity, speedModifier, followingTargetEvenIfNotSeen);
		this.entity = entity;
	}

	@Override
	public boolean canUse() {
		return entity.getSex() == 1 ? super.canUse() : false;
	}
}
