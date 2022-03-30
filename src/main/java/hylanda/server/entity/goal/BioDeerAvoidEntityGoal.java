package hylanda.server.entity.goal;

import hylanda.server.entity.BioDeer;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;

public class BioDeerAvoidEntityGoal extends AvoidEntityGoal {
	private final BioDeer entity;
	
	public BioDeerAvoidEntityGoal(BioDeer entity, Class toAvoid, float maxDist, double walkSpeedModifier, double sprintSpeedModifier) {
		super(entity, toAvoid, maxDist, walkSpeedModifier, sprintSpeedModifier);
		this.entity = entity;
	}

	@Override
	public boolean canUse() {
		return entity.getSex() == 1 ? super.canUse() : false;
	}
}
