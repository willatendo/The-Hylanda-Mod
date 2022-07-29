package hylanda.server.block;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SmithyBlock extends Block {
	public static final EnumProperty<SmithyParts> PARTS = EnumProperty.create("parts", SmithyParts.class);
	public static final DirectionProperty HORIZONTAL_FACING = HorizontalDirectionalBlock.FACING;
	public static final VoxelShape ANVIL = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D);

	public SmithyBlock(Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(HORIZONTAL_FACING, Direction.NORTH).setValue(PARTS, SmithyParts.LEFT));
	}

	@Override
	public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
		return blockState.getValue(PARTS) == SmithyParts.ANVIL ? ANVIL : super.getShape(blockState, blockGetter, blockPos, collisionContext);
	}

	@Nullable
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(HORIZONTAL_FACING, context.getHorizontalDirection().getOpposite());
	}

	@Override
	public void playerWillDestroy(Level level, BlockPos blockPos, BlockState blockState, Player player) {
		if (!level.isClientSide()) {
			SmithyParts parts = blockState.getValue(PARTS);
			if (parts == SmithyParts.LEFT) {
				BlockPos otherpos = blockPos.relative(blockState.getValue(HORIZONTAL_FACING).getCounterClockWise());
				BlockState otherstate = level.getBlockState(otherpos);
				if (otherstate.getBlock() == this) {
					level.destroyBlock(otherpos, !player.isCreative());
					level.destroyBlock(blockPos.above(), !player.isCreative());
				}
			}

			if (parts == SmithyParts.RIGHT) {
				BlockPos otherpos = blockPos.relative(blockState.getValue(HORIZONTAL_FACING).getClockWise());
				BlockState otherstate = level.getBlockState(otherpos);
				if (otherstate.getBlock() == this) {
					level.destroyBlock(otherpos, !player.isCreative());
					level.destroyBlock(otherpos.above(), !player.isCreative());
				}
			}

			if (parts == SmithyParts.ANVIL) {
				BlockPos otherpos = blockPos.below();
				BlockState otherstate = level.getBlockState(otherpos);
				if (otherstate.getBlock() == this) {
					level.destroyBlock(otherpos, !player.isCreative());
					BlockPos horizontal = otherpos.relative(blockState.getValue(HORIZONTAL_FACING).getCounterClockWise());
					level.destroyBlock(horizontal, !player.isCreative());
				}
			}
		}

		super.playerWillDestroy(level, blockPos, blockState, player);
	}

	@Override
	public void setPlacedBy(Level world, BlockPos pos, BlockState state, LivingEntity entity, ItemStack stack) {
		super.setPlacedBy(world, pos, state, entity, stack);
		if (!world.isClientSide) {
			BlockPos blockpos = pos.relative(state.getValue(HORIZONTAL_FACING).getCounterClockWise());
			world.setBlock(blockpos, state.setValue(PARTS, SmithyParts.RIGHT), 3);
			world.setBlock(pos.above(), state.setValue(PARTS, SmithyParts.ANVIL), 3);
			world.blockUpdated(pos, Blocks.AIR);
			state.updateNeighbourShapes(world, pos, 3);
		}
	}

	@Override
	public BlockState rotate(BlockState state, LevelAccessor world, BlockPos pos, Rotation direction) {
		return state.setValue(HORIZONTAL_FACING, direction.rotate(state.getValue(HORIZONTAL_FACING)));
	}

	@Override
	protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
		builder.add(PARTS, HORIZONTAL_FACING);
	}

	@Override
	public boolean canSurvive(BlockState state, LevelReader reader, BlockPos pos) {
		BlockPos horizontal = pos.relative(state.getValue(HORIZONTAL_FACING).getCounterClockWise());
		BlockPos above = pos.relative(Direction.UP);
		return reader.getBlockState(horizontal).getMaterial().isReplaceable() && reader.getBlockState(above).getMaterial().isReplaceable();
	}

	@Override
	public float getShadeBrightness(BlockState state, BlockGetter reader, BlockPos pos) {
		return 1;
	}
}
