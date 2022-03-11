package hylanda.content.server.init;

import hylanda.library.entity.BioDeer;
import hylanda.library.entity.Gojirasaurus;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import tyrannotitanlib.core.content.Util;

@EventBusSubscriber(bus = Bus.MOD, modid = Util.HYLANDA_ID)
public class HylandaEntities {
	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, Util.HYLANDA_ID);

	public static final RegistryObject<EntityType<Gojirasaurus>> GOJIRASAURUS = ENTITIES.register("gojirasaurus", () -> EntityType.Builder.of(Gojirasaurus::new, MobCategory.CREATURE).sized(1.5F, 3.0F).build("gojirasaurus"));
	public static final RegistryObject<EntityType<BioDeer>> BIO_DEER = ENTITIES.register("bio_deer", () -> EntityType.Builder.of(BioDeer::new, MobCategory.CREATURE).sized(0.75F, 2.0F).build("bio_deer"));

	@SubscribeEvent
	public static void initializeAttributes(EntityAttributeCreationEvent entity) {
		entity.put(HylandaEntities.GOJIRASAURUS.get(), Gojirasaurus.makeAttributes());
		entity.put(HylandaEntities.BIO_DEER.get(), BioDeer.makeAttributes());
	}

	public static void init(IEventBus bus) {
		ENTITIES.register(bus);
	}
}
