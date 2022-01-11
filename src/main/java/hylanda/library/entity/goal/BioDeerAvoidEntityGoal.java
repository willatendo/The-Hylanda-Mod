package hylanda.library.entity.goal;

import hylanda.library.entity.BioDeerEntity;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;

public class BioDeerAvoidEntityGoal extends AvoidEntityGoal {
	private final BioDeerEntity entity;
	
	public BioDeerAvoidEntityGoal(BioDeerEntity entity, Class toAvoid, float maxDist, double walkSpeedModifier, double sprintSpeedModifier) {
		super(entity, toAvoid, maxDist, walkSpeedModifier, sprintSpeedModifier);
		this.entity = entity;
	}

	@Override
	public boolean canUse() {
		return entity.getSex() == 1 ? super.canUse() : false;
	}
}
