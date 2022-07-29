package hylanda.server.util;

import com.tterrag.registrate.AbstractRegistrate;
import com.tterrag.registrate.util.entry.RegistryEntry;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.registries.RegistryObject;

public class BiomeEntry<T extends Biome> extends RegistryEntry<T> {
	public BiomeEntry(AbstractRegistrate<?> abstractRegistrate, RegistryObject<T> registryObject) {
		super(abstractRegistrate, registryObject);
	}

	public ResourceKey<Biome> getResourceKey() {
		return ResourceKey.create(Registry.BIOME_REGISTRY, this.getId());
	}
}
