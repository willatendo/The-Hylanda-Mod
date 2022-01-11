package hylanda.library.entity.goal;

import hylanda.library.entity.GojirasaurusEntity;
import net.minecraft.world.entity.ai.goal.FloatGoal;

public class GojirasaurusSwimGoal extends FloatGoal {
	public final GojirasaurusEntity entity;

	public GojirasaurusSwimGoal(GojirasaurusEntity entity) {
		super(entity);
		this.entity = entity;
	}
	
	@Override
	public void start() {
		super.start();
		this.entity.setAnimation(GojirasaurusEntity.ANIMATION_SWIM);
	}
	
	@Override
	public void stop() {
		super.stop();
		this.entity.setAnimation(GojirasaurusEntity.ANIMATION_IDLE);
	}
}
