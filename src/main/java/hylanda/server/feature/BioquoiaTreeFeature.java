package hylanda.server.feature;

import com.mojang.serialization.Codec;

import hylanda.server.block.HylandaBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class BioquoiaTreeFeature extends Feature<NoneFeatureConfiguration> {
	public BioquoiaTreeFeature(Codec<NoneFeatureConfiguration> codec) {
		super(codec);
	}

	public boolean isAirOrLeaves(WorldGenLevel reader, BlockPos pos) {
		return reader.isStateAtPosition(pos, state -> state.isAir() || state.is(BlockTags.LEAVES));
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> featurePlaceContext) {
		BlockState log = HylandaBlocks.BIOQUOIA_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y);
		BlockState leaves = HylandaBlocks.BIOQUOIA_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 4).setValue(LeavesBlock.PERSISTENT, false);
		WorldGenLevel worldGenLevel = featurePlaceContext.level();
		BlockPos blockPos = featurePlaceContext.origin();
		RandomSource randomSource = featurePlaceContext.random();

		while (blockPos.getY() > 1 && this.isAirOrLeaves(worldGenLevel, blockPos)) {
			blockPos = blockPos.below();
		}

		int trunkHeight = 10 + randomSource.nextInt(4);

		for (int y = (blockPos.getY() - 1) + 1; y <= blockPos.getY() + trunkHeight; y++) {
			worldGenLevel.setBlock(new BlockPos(blockPos.getX(), y + 1, blockPos.getZ()), log, 3);
		}

		return true;
	}
}
