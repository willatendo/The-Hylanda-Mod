package hylanda.server.entity.goal;

import hylanda.server.entity.BioDeer;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;

public class BioDeerMeleeAttackGoal extends MeleeAttackGoal {
	private final BioDeer entity;

	public BioDeerMeleeAttackGoal(BioDeer entity, double speedModifier, boolean followingTargetEvenIfNotSeen) {
		super(entity, speedModifier, followingTargetEvenIfNotSeen);
		this.entity = entity;
	}

	@Override
	public boolean canUse() {
		return entity.getSex() == 1 ? super.canUse() : false;
	}
}
