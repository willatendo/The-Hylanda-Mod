package hylanda.library.block;

import java.util.Random;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.tags.FluidTags;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.lighting.LayerLightEngine;
import net.minecraft.server.level.ServerLevel;
import net.minecraftforge.common.IPlantable;

public class BioquoiaGrassBlock extends Block {
	public BioquoiaGrassBlock() {
		super(BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.DIRT).strength(0.5F).randomTicks().sound(SoundType.GRAVEL));
	}

	@Override
	public void tick(BlockState state, ServerLevel worldIn, BlockPos pos, Random random) {
		if (!worldIn.isClientSide()) {
			if (!worldIn.isAreaLoaded(pos, 3))
				return;
			if (!isLightEnough(state, worldIn, pos)) {
				worldIn.setBlockAndUpdate(pos, Blocks.DIRT.defaultBlockState());
			} else if (worldIn.getMaxLocalRawBrightness(pos.above()) >= 9) {
				BlockState blockstate = this.defaultBlockState();

				for (int i = 0; i < 4; ++i) {
					BlockPos blockpos = pos.offset(random.nextInt(3) - 1, random.nextInt(5) - 3, random.nextInt(3) - 1);
					if (worldIn.getBlockState(blockpos).getBlock() == Blocks.DIRT && isValidBonemealTargetGrass(blockstate, worldIn, blockpos)) {
						worldIn.setBlockAndUpdate(blockpos, blockstate);
					}
				}
			}
		}
	}

	private static boolean isLightEnough(BlockState state, LevelReader reader, BlockPos pos) {
		BlockPos blockpos = pos.above();
		BlockState blockstate = reader.getBlockState(blockpos);

		int i = LayerLightEngine.getLightBlockInto(reader, state, pos, blockstate, blockpos, Direction.UP, blockstate.getLightBlock(reader, blockpos));
		return i < reader.getMaxLightLevel();
	}

	private static boolean isValidBonemealTargetGrass(BlockState state, LevelReader reader, BlockPos pos) {
		BlockPos blockpos = pos.above();
		return isLightEnough(state, reader, pos) && !reader.getFluidState(blockpos).is(FluidTags.WATER);
	}

	@Override
	public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction facing, IPlantable plantable) {
		return true;
	}
}
