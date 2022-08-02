package hylanda.server.feature;

import hylanda.HylandaMod;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class HylandaConfiguredFeatures {
	public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, HylandaMod.ID);

	public static final RegistryObject<ConfiguredFeature<?, ?>> BIOQUOIA_TREE = CONFIGURED_FEATURES.register("bioquoia_tree", () -> new ConfiguredFeature<>(new BioquoiaTreeFeature(NoneFeatureConfiguration.CODEC), FeatureConfiguration.NONE));
}
