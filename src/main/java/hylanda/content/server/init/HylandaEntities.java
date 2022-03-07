package hylanda.content.server.init;

import hylanda.library.entity.BioDeerEntity;
import hylanda.library.entity.GojirasaurusEntity;
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

	public static final RegistryObject<EntityType<GojirasaurusEntity>> GOJIRASAURUS = ENTITIES.register("gojirasaurus", () -> EntityType.Builder.of(GojirasaurusEntity::new, MobCategory.CREATURE).sized(1.5F, 3.0F).build("gojirasaurus"));
	public static final RegistryObject<EntityType<BioDeerEntity>> BIO_DEER = ENTITIES.register("bio_deer", () -> EntityType.Builder.of(BioDeerEntity::new, MobCategory.CREATURE).sized(0.75F, 2.0F).build("bio_deer"));

	@SubscribeEvent
	public static void initializeAttributes(EntityAttributeCreationEvent entity) {
		entity.put(GOJIRASAURUS.get(), GojirasaurusEntity.makeAttributes());
		entity.put(BIO_DEER.get(), BioDeerEntity.makeAttributes());
	}

	public static void init(IEventBus bus) {
		ENTITIES.register(bus);
	}
}
