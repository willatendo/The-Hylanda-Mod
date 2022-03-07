package hylanda.library.tab;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import tyrannotitanlib.core.content.Util;
import tyrannotitanlib.library.itemgroup.BasicCreativeTab;

public class ModTab extends BasicCreativeTab {
	public ItemStack itemIcon;

	public ModTab(String tabId) {
		super(Util.HYLANDA_ID, tabId);
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
