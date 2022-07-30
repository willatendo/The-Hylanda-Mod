package hylanda.server.tab;

import hylanda.HylandaMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModTab extends CreativeModeTab {
	private final String tabId;
	public ItemStack itemIcon;

	public ModTab(String tabId) {
		super(HylandaMod.ID + "." + tabId);
		this.tabId = tabId;
	}

	@Override
	public ResourceLocation getBackgroundImage() {
		return new ResourceLocation("textures/gui/container/creative_inventory/tab_item_search.png");
	}

	@Override
	public String getRecipeFolderName() {
		return HylandaMod.ID + "/" + this.tabId;
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
