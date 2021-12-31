package hylanda.library.tab;

import hylanda.library.util.ModUtils;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ModTab extends ItemGroup {
	public ItemStack itemIcon;

	public ModTab(String tabId) {
		super(ModUtils.ID + "." + tabId);
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
		return itemIcon;
	}

	public void setIcon(ItemStack icon) {
		this.itemIcon = icon;
	}
}
