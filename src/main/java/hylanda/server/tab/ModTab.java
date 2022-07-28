package hylanda.server.tab;

import hylanda.HylandaMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModTab extends CreativeModeTab {
	public ItemStack itemIcon;

	public ModTab(String tabId) {
		super(HylandaMod.ID + "." + tabId);
	}

	@Override
	public ResourceLocation getBackgroundImage() {
		return new ResourceLocation("textures/gui/container/creative_inventory/tab_item_search.png");
	}

	@Override
	public boolean hasSearchBar() {
		return true;
	}

	@Override
	public ItemStack makeIcon() {
		return this.itemIcon;
	}

	public void setIcon(ItemStack icon) {
		this.itemIcon = icon;
	}
}
