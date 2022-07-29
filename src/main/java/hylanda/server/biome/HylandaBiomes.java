package hylanda.server.biome;

import hylanda.HylandaMod;
import hylanda.server.util.BiomeEntry;
import hylanda.server.util.HylandaRegistrate;
import net.minecraft.world.level.biome.Biome;

public class HylandaBiomes {
	public static final HylandaRegistrate REGISTRATE = HylandaMod.getRegistrate();

	public static final BiomeEntry<Biome> KAIJAE_RIVERBANKS = REGISTRATE.biome("kaijae_riverbanks", b -> b.build()).register();
	public static final BiomeEntry<Biome> KAIJAE_WOODS = REGISTRATE.biome("kaijae_woods", b -> b.build()).register();
	public static final BiomeEntry<Biome> KAIJAE_PLAINS = REGISTRATE.biome("kaijae_plains", b -> b.build()).register();

	public static void init() {
	}
}
