package hylanda.server.feature;

import hylanda.HylandaMod;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class HylandaFeatures {
	public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, HylandaMod.ID);

	public static final RegistryObject<Feature<?>> BIOQUOIA_TREE = FEATURES.register("bioquoia_tree", () -> new BioquoiaTreeFeature(NoneFeatureConfiguration.CODEC));
}
