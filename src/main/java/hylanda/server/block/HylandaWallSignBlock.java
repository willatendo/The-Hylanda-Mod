package hylanda.server.block;

import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.state.properties.WoodType;

public class HylandaWallSignBlock extends WallSignBlock {
	public HylandaWallSignBlock(WoodType woodType, Properties properties) {
		super(properties, woodType);
	}
}
