package hylanda.library.entity.goal;

import hylanda.library.entity.Gojirasaurus;
import net.minecraft.world.entity.ai.goal.FloatGoal;

public class GojirasaurusSwimGoal extends FloatGoal {
	public final Gojirasaurus entity;

	public GojirasaurusSwimGoal(Gojirasaurus entity) {
		super(entity);
		this.entity = entity;
	}
	
	@Override
	public void start() {
		super.start();
		this.entity.setAnimation(Gojirasaurus.ANIMATION_SWIM);
	}
	
	@Override
	public void stop() {
		super.stop();
		this.entity.setAnimation(Gojirasaurus.ANIMATION_IDLE);
	}
}
