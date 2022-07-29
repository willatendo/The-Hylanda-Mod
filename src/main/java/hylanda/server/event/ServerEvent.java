package hylanda.server.event;

import hylanda.HylandaMod;
import hylanda.server.item.HylandaItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.items.ItemHandlerHelper;

@EventBusSubscriber(modid = HylandaMod.ID, bus = Bus.FORGE)
public class ServerEvent {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		CompoundTag playerData = event.getEntity().getPersistentData();
		CompoundTag data = playerData.getCompound(Player.PERSISTED_NBT_TAG);
		if (data != null && !data.getBoolean("HasHylandaBook")) {
			ItemHandlerHelper.giveItemToPlayer(event.getEntity(), HylandaItems.GUIDE_BOOK.get().getDefaultInstance());
			data.putBoolean("HasHylandaBook", true);
			playerData.put(Player.PERSISTED_NBT_TAG, data);
		}
	}
}
