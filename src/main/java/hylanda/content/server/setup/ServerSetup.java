package hylanda.content.server.setup;

import hylanda.content.server.init.EntityInit;
import hylanda.library.item.ModSpawnEggItem;
import hylanda.library.util.ModUtils;
import net.minecraft.entity.EntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = ModUtils.ID, bus = Bus.MOD)
public class ServerSetup 
{
	@SubscribeEvent
	public static void onRegisterEntities(final RegistryEvent.Register<EntityType<?>> event)
	{		
		EntityInit.initializeAttributes();
		ModSpawnEggItem.initSpawnEggs();
	}
}
