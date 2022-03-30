package hylanda.server.block;

import net.minecraft.util.StringRepresentable;

public enum SmithyParts implements StringRepresentable {
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
