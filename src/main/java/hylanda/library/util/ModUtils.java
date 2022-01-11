package hylanda.library.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import hylanda.library.tab.ModTab;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.TranslatableComponent;

public class ModUtils {
	public static final Logger LOGGER = LogManager.getLogger(ModUtils.ID);
	public static boolean DISABLE_IN_DEV = false;

	public static final ModTab ITEMS = new ModTab("items");
	public static final ModTab BLOCKS = new ModTab("blocks");
	public static final ModTab TOOLS = new ModTab("tools");
	public static final ModTab WEAPONS = new ModTab("weapons");
	public static final ModTab SPAWN_EGGS = new ModTab("spawn_eggs");

	public static final String ID = "hylanda";

	public static ResourceLocation rL(String location) {
		return new ResourceLocation(ID, location);
	}

	public static TranslatableComponent tTC(String type, String key) {
		return new TranslatableComponent(type + "." + ID + "." + key);
	}

	public static TranslatableComponent cTC(String type, String key, ChatFormatting colour) {
		TranslatableComponent text = tTC(type, key);
		text.withStyle(colour);
		return text;
	}

	public static TranslatableComponent gTC(String type, String key) {
		TranslatableComponent text = tTC(type, key);
		text.withStyle(ChatFormatting.GRAY);
		return text;
	}
}
