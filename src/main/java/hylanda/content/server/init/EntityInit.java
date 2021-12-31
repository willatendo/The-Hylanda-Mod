package hylanda.content.server.init;

import hylanda.library.entity.BioDeerEntity;
import hylanda.library.entity.GojirasaurusEntity;
import hylanda.library.util.ModUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityType.IFactory;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ForgeRegistries;

@EventBusSubscriber(bus = Bus.MOD, modid = ModUtils.ID)
public class EntityInit {
	public static final EntityType<GojirasaurusEntity> GOJIRASAURUS = register("gojirasaurus", GojirasaurusEntity::new, EntityClassification.CREATURE, 1.5F, 3.0F);
	public static final EntityType<BioDeerEntity> BIO_DEER = register("bio_deer", BioDeerEntity::new, EntityClassification.CREATURE, 0.75F, 2.0F);

	@SubscribeEvent
	public static void initializeAttributes(EntityAttributeCreationEvent entity) {
		entity.put(GOJIRASAURUS, GojirasaurusEntity.makeAttributes().build());
		entity.put(BIO_DEER, BioDeerEntity.makeAttributes().build());
	}

	public static void init() {
	}
	
	public static <T extends Entity> EntityType<T> register(String id, IFactory<T> factory, EntityClassification classification, float width, float height) {
		EntityType<T> entityType = EntityType.Builder.of(factory, classification).sized(width, height).build(id);
		entityType.setRegistryName(ModUtils.rL(id));
		ForgeRegistries.ENTITIES.register(entityType);
		return entityType;
	}
}
