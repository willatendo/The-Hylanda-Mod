package hylanda.library.tab;

import hylanda.library.util.ModUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import tyrannotitanlib.library.base.itemgroup.TabBuilder;

public class ModTab extends TabBuilder {
	public ItemStack itemIcon;

	public ModTab(String tabId) {
		super(ModUtils.ID, tabId);
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
