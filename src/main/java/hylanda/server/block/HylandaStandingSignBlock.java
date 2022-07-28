package hylanda.server.block;

import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.state.properties.WoodType;

public class HylandaStandingSignBlock extends StandingSignBlock {
	public HylandaStandingSignBlock(WoodType woodType, Properties properties) {
		super(properties, woodType);
	}
}
