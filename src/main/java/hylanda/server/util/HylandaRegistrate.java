package hylanda.server.util;

import com.tterrag.registrate.AbstractRegistrate;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import com.tterrag.registrate.util.nullness.NonNullSupplier;

import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class HylandaRegistrate extends AbstractRegistrate<HylandaRegistrate> {
	protected HylandaRegistrate(String modid) {
		super(modid);
	}

	public static NonNullSupplier<HylandaRegistrate> lazy(String modid) {
		return NonNullSupplier.lazy(() -> new HylandaRegistrate(modid).registerEventListeners(FMLJavaModLoadingContext.get().getModEventBus()));
	}

	public <T extends Biome> BiomeBuilder<T, HylandaRegistrate> biome(String id, NonNullFunction<Biome.BiomeBuilder, T> factory) {
		return this.entry(id, callback -> BiomeBuilder.create(this, this.self(), id, callback, factory));
	}
}
