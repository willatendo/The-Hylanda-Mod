package hylanda.server.util;

import com.tterrag.registrate.AbstractRegistrate;
import com.tterrag.registrate.util.nullness.NonNullSupplier;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class HylandaRegistrate extends AbstractRegistrate<HylandaRegistrate> {
	protected HylandaRegistrate(String modid) {
		super(modid);
	}

	public static NonNullSupplier<HylandaRegistrate> lazy(String modid) {
		return NonNullSupplier.of(() -> new HylandaRegistrate(modid).registerEventListeners(FMLJavaModLoadingContext.get().getModEventBus()));
	}
}
