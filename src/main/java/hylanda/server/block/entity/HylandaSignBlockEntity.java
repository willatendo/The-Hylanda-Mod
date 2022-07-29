package hylanda.server.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class HylandaSignBlockEntity extends SignBlockEntity {
	private final BlockEntityType<?> blockEntityType;

	public HylandaSignBlockEntity(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
		super(blockPos, blockState);
		this.blockEntityType = blockEntityType;
	}

	@Override
	public BlockEntityType<?> getType() {
		return this.blockEntityType;
	}
}
