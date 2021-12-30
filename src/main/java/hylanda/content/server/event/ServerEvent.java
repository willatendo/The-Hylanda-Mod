package hylanda.content.server.event;

import hylanda.content.server.init.ItemInit;
import hylanda.library.util.ModUtils;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.items.ItemHandlerHelper;

@EventBusSubscriber(modid = ModUtils.ID, bus = Bus.FORGE)
public class ServerEvent 
{
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) 
	{
		CompoundNBT playerData = event.getPlayer().getPersistentData();
		CompoundNBT data = playerData.getCompound(PlayerEntity.PERSISTED_NBT_TAG);
		if(data != null && !data.getBoolean("has_hylanda_book")) 
		{
			ItemHandlerHelper.giveItemToPlayer(event.getPlayer(), new ItemStack(ItemInit.GUIDE_BOOK));
			data.putBoolean("has_hylanda_book", true);
			playerData.put(PlayerEntity.PERSISTED_NBT_TAG, data);
		}
	}
}