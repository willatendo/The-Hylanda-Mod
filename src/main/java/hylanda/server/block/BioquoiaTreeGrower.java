package hylanda.server.block;

import hylanda.server.feature.HylandaConfiguredFeatures;
import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class BioquoiaTreeGrower extends AbstractTreeGrower {
	@Override
	protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource randomSource, boolean big) {
		return Holder.direct(HylandaConfiguredFeatures.BIOQUOIA_TREE.get());
	}

}
