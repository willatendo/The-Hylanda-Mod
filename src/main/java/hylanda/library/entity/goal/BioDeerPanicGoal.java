package hylanda.library.entity.goal;

import hylanda.library.entity.BioDeerEntity;
import net.minecraft.world.entity.ai.goal.PanicGoal;

public class BioDeerPanicGoal extends PanicGoal {
	private final BioDeerEntity entity;
	
	public BioDeerPanicGoal(BioDeerEntity entity, double speedModifier) {
		super(entity, speedModifier);
		this.entity = entity;
	}

	@Override
	public boolean canUse() {
		return entity.getSex() == 1 ? super.canUse() : false;
	}
}
