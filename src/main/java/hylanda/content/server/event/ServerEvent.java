package hylanda.content.server.event;

import hylanda.content.server.init.HylandaItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.items.ItemHandlerHelper;
import tyrannotitanlib.core.content.Util;

@EventBusSubscriber(modid = Util.HYLANDA_ID, bus = Bus.FORGE)
public class ServerEvent {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		CompoundTag playerData = event.getPlayer().getPersistentData();
		CompoundTag data = playerData.getCompound(Player.PERSISTED_NBT_TAG);
		if (data != null && !data.getBoolean("has_hylanda_book")) {
			ItemHandlerHelper.giveItemToPlayer(event.getPlayer(), HylandaItems.GUIDE_BOOK.get().getDefaultInstance());
			data.putBoolean("has_hylanda_book", true);
			playerData.put(Player.PERSISTED_NBT_TAG, data);
		}
	}
}
