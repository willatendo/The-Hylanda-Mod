package hylanda.library.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import hylanda.library.tab.ModTab;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;

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

	public static TranslationTextComponent tTC(String type, String key) {
		return new TranslationTextComponent(type + "." + ID + "." + key);
	}

	public static TranslationTextComponent cTC(String type, String key, TextFormatting colour) {
		TranslationTextComponent text = tTC(type, key);
		text.withStyle(colour);
		return text;
	}

	public static TranslationTextComponent gTC(String type, String key) {
		TranslationTextComponent text = tTC(type, key);
		text.withStyle(TextFormatting.GRAY);
		return text;
	}
}
