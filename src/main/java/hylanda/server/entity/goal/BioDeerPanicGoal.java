package hylanda.server.entity.goal;

import hylanda.server.entity.BioDeer;
import net.minecraft.world.entity.ai.goal.PanicGoal;

public class BioDeerPanicGoal extends PanicGoal {
	private final BioDeer entity;

	public BioDeerPanicGoal(BioDeer entity, double speedModifier) {
		super(entity, speedModifier);
		this.entity = entity;
	}

	@Override
	public boolean canUse() {
		return entity.getSex() == 0 ? super.canUse() : false;
	}
}
