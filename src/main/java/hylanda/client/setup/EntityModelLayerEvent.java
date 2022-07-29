package hylanda.client.setup;

import hylanda.HylandaMod;
import hylanda.client.entity.model.DetectedOreBlockModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(bus = Bus.MOD, modid = HylandaMod.ID, value = Dist.CLIENT)
public class EntityModelLayerEvent {
	@SubscribeEvent
	public static void onAddLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(DetectedOreBlockModel.LAYER_LOCATION, DetectedOreBlockModel::createBodyLayer);
	}
}
