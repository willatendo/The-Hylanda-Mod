package hylanda.server.block;

import hylanda.server.block.entity.HylandaBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class HylandaWallSignBlock extends WallSignBlock {
	public HylandaWallSignBlock(WoodType woodType, Properties properties) {
		super(properties, woodType);
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
		return HylandaBlockEntities.SIGN.create(blockPos, blockState);
	}
}
