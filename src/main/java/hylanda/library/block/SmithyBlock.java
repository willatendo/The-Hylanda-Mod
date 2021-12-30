package hylanda.library.block;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.util.Direction;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public class SmithyBlock extends Block
{
	private static final EnumProperty<SmithyParts> PARTS = EnumProperty.create("parts", SmithyParts.class);
	private static final DirectionProperty HORIZONTAL_FACING = HorizontalBlock.FACING;
	
	public SmithyBlock(Properties properties) 
	{
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(HORIZONTAL_FACING, Direction.NORTH).setValue(PARTS, SmithyParts.LEFT));
	}
	
	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) 
	{
		return this.defaultBlockState().setValue(HORIZONTAL_FACING, context.getHorizontalDirection().getOpposite());
	}
	
	@Override
	public void playerWillDestroy(World world, BlockPos pos, BlockState state, PlayerEntity entity) 
	{
		if(!world.isClientSide) 
		{
			SmithyParts parts = state.getValue(PARTS);
			if(parts == SmithyParts.LEFT) 
			{
				BlockPos otherpos = pos.relative(state.getValue(HORIZONTAL_FACING).getCounterClockWise());
				BlockState otherstate = world.getBlockState(otherpos);
				if(otherstate.getBlock() == this) 
				{
					world.setBlock(otherpos, Blocks.AIR.defaultBlockState(), 35);
					world.levelEvent(entity, 2001, otherpos, Block.getId(otherstate));
				}
			}
			
			if(parts == SmithyParts.RIGHT) 
			{
				BlockPos otherpos = pos.relative(state.getValue(HORIZONTAL_FACING).getCounterClockWise());
				BlockState otherstate = world.getBlockState(otherpos);
				if(otherstate.getBlock() == this) 
				{
					world.setBlock(otherpos, Blocks.AIR.defaultBlockState(), 35);
					world.levelEvent(entity, 2001, otherpos, Block.getId(otherstate));
				}
			}
		}
		
		super.playerWillDestroy(world, pos, state, entity);
	}
	
	@Override
	public void setPlacedBy(World world, BlockPos pos, BlockState state, LivingEntity entity, ItemStack stack) 
	{
		super.setPlacedBy(world, pos, state, entity, stack);
		if(!world.isClientSide) 
		{
			BlockPos blockpos = pos.relative(state.getValue(HORIZONTAL_FACING).getCounterClockWise());
			world.setBlock(blockpos, state.setValue(PARTS, SmithyParts.RIGHT), 3);
			world.blockUpdated(pos, Blocks.AIR);
			state.updateNeighbourShapes(world, pos, 3);
		}
	}

	@Override
	public BlockState rotate(BlockState state, IWorld world, BlockPos pos, Rotation direction) 
	{
		return state.setValue(HORIZONTAL_FACING, direction.rotate(state.getValue(HORIZONTAL_FACING)));
	}
	
	@Override
	protected void createBlockStateDefinition(Builder<Block, BlockState> builder) 
	{
		builder.add(PARTS, HORIZONTAL_FACING);
	}
	
	@Override
	public boolean canSurvive(BlockState state, IWorldReader reader, BlockPos pos) 
	{
		BlockPos otherpos = pos.relative(state.getValue(HORIZONTAL_FACING).getCounterClockWise());
		return reader.getBlockState(otherpos).getMaterial().isReplaceable();
	}
	
	@Override
	public float getShadeBrightness(BlockState state, IBlockReader reader, BlockPos pos) 
	{
		return 1;
	}
}
