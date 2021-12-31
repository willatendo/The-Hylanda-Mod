package hylanda.library.block;

import net.minecraft.util.IStringSerializable;

public enum SmithyParts implements IStringSerializable {
	ANVIL,
	LEFT,
	RIGHT;

	public String toString() {
		return this.getSerializedName();
	}

	@Override
	public String getSerializedName() {
		return this == ANVIL ? "anvil" : this == LEFT ? "left" : "right";
	}
}
