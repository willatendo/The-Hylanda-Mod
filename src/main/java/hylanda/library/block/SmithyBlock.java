package hylanda.library.block;

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

public class SmithyBlock extends Block {
	private static final EnumProperty<SmithyParts> PARTS = EnumProperty.create("parts", SmithyParts.class);
	private static final DirectionProperty HORIZONTAL_FACING = HorizontalDirectionalBlock.FACING;

	public SmithyBlock(Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(HORIZONTAL_FACING, Direction.NORTH).setValue(PARTS, SmithyParts.LEFT));
	}

	@Nullable
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(HORIZONTAL_FACING, context.getHorizontalDirection().getOpposite());
	}

	@Override
	public void playerWillDestroy(Level world, BlockPos pos, BlockState state, Player entity) {
		if (!world.isClientSide) {
			SmithyParts parts = state.getValue(PARTS);
			if (parts == SmithyParts.LEFT) {
				BlockPos otherpos = pos.relative(state.getValue(HORIZONTAL_FACING).getCounterClockWise());
				BlockState otherstate = world.getBlockState(otherpos);
				if (otherstate.getBlock() == this) {
					world.setBlock(otherpos, Blocks.AIR.defaultBlockState(), 35);
					world.levelEvent(entity, 2001, otherpos, Block.getId(otherstate));
				}
			}

			if (parts == SmithyParts.RIGHT) {
				BlockPos otherpos = pos.relative(state.getValue(HORIZONTAL_FACING).getCounterClockWise());
				BlockState otherstate = world.getBlockState(otherpos);
				if (otherstate.getBlock() == this) {
					world.setBlock(otherpos, Blocks.AIR.defaultBlockState(), 35);
					world.levelEvent(entity, 2001, otherpos, Block.getId(otherstate));
				}
			}
		}

		super.playerWillDestroy(world, pos, state, entity);
	}

	@Override
	public void setPlacedBy(Level world, BlockPos pos, BlockState state, LivingEntity entity, ItemStack stack) {
		super.setPlacedBy(world, pos, state, entity, stack);
		if (!world.isClientSide) {
			BlockPos blockpos = pos.relative(state.getValue(HORIZONTAL_FACING).getCounterClockWise());
			world.setBlock(blockpos, state.setValue(PARTS, SmithyParts.RIGHT), 3);
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
		BlockPos otherpos = pos.relative(state.getValue(HORIZONTAL_FACING).getCounterClockWise());
		return reader.getBlockState(otherpos).getMaterial().isReplaceable();
	}

	@Override
	public float getShadeBrightness(BlockState state, BlockGetter reader, BlockPos pos) {
		return 1;
	}
}
