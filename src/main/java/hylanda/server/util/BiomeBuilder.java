package hylanda.server.util;

import com.tterrag.registrate.AbstractRegistrate;
import com.tterrag.registrate.builders.AbstractBuilder;
import com.tterrag.registrate.builders.BuilderCallback;
import com.tterrag.registrate.providers.RegistrateLangProvider;
import com.tterrag.registrate.util.entry.RegistryEntry;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import com.tterrag.registrate.util.nullness.NonNullUnaryOperator;

import net.minecraft.Util;
import net.minecraft.core.Registry;
import net.minecraft.util.Mth;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BiomeBuilder<T extends Biome, P> extends AbstractBuilder<Biome, T, P, BiomeBuilder<T, P>> {
	public static <T extends Biome, P> BiomeBuilder<T, P> create(AbstractRegistrate<?> owner, P parent, String name, BuilderCallback callback, NonNullFunction<Biome.BiomeBuilder, T> factory) {
		return new BiomeBuilder(owner, parent, name, callback, factory, () -> new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).temperature(0.8F).downfall(0.4F).mobSpawnSettings(new MobSpawnSettings.Builder().build()).generationSettings(new BiomeGenerationSettings.Builder().build()).specialEffects(new BiomeSpecialEffects.Builder().waterColor(0x3F76E4).waterFogColor(0x50533).fogColor(0xC0D8FF).skyColor(calculateSkyColor(0.8F)).backgroundMusic(null).build())).defaultLang();
	}

	private final NonNullFunction<Biome.BiomeBuilder, T> factory;

	private NonNullSupplier<Biome.BiomeBuilder> initialProperties;
	private NonNullFunction<Biome.BiomeBuilder, Biome.BiomeBuilder> propertiesCallback = NonNullUnaryOperator.identity();

	public BiomeBuilder(AbstractRegistrate<?> owner, P parent, String name, BuilderCallback callback, NonNullFunction<Biome.BiomeBuilder, T> factory, NonNullSupplier<Biome.BiomeBuilder> initialProperties) {
		super(owner, parent, name, callback, Registry.BIOME_REGISTRY);
		this.factory = factory;
		this.initialProperties = initialProperties;
	}

	public static int calculateSkyColor(float temperature) {
		float $$1 = temperature / 3.0F;
		$$1 = Mth.clamp($$1, -1.0F, 1.0F);
		return Mth.hsvToRgb(0.62222224F - $$1 * 0.05F, 0.5F + $$1 * 0.1F, 1.0F);
	}

	public BiomeBuilder<T, P> properties(NonNullUnaryOperator<Biome.BiomeBuilder> func) {
		this.propertiesCallback = this.propertiesCallback.andThen(func);
		return this;
	}

	public BiomeBuilder<T, P> defaultLang() {
		return this.lang(RegistrateLangProvider.toEnglishName(this.getName()));
	}

	public BiomeBuilder<T, P> lang(String name) {
		return super.lang(biome -> Util.makeDescriptionId("biome", ForgeRegistries.BIOMES.getKey(biome)), name);
	}

	@Override
	protected T createEntry() {
		Biome.BiomeBuilder biomeBuilder = this.initialProperties.get();
		biomeBuilder = this.propertiesCallback.apply(biomeBuilder);
		return this.factory.apply(biomeBuilder);
	}

	@Override
	protected RegistryEntry<T> createEntryWrapper(RegistryObject<T> delegate) {
		return new BiomeEntry<>(this.getOwner(), delegate);
	}

	@Override
	public BiomeEntry<T> register() {
		return (BiomeEntry<T>) super.register();
	}
}
