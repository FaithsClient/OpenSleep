package linxiu.utils;

import net.minecraft.client.Minecraft;

public class DimensionHelper {
	enum DIMENSIONS {
		NETHER(-1), OVERWORLD(0), END(1);

		private final int dimensionID;

		DIMENSIONS(int n) {
			this.dimensionID = n;
		}

		public int getDimensionID() {
			return dimensionID;
		}
	}

	public static boolean isPlayerInGame() {
		return (Minecraft.getMinecraft().thePlayer != null) && (Minecraft.getMinecraft().theWorld != null);
	}

	public static boolean isPlayerInNether() {
		if (!isPlayerInGame())
			return false;
		return (Minecraft.getMinecraft().thePlayer.dimension == DIMENSIONS.NETHER.getDimensionID());
	}

	public static boolean isPlayerInEnd() {
		if (!isPlayerInGame())
			return false;
		return (Minecraft.getMinecraft().thePlayer.dimension == DIMENSIONS.END.getDimensionID());
	}

	public static boolean isPlayerInOverworld() {
		if (!isPlayerInGame())
			return false;
		return (Minecraft.getMinecraft().thePlayer.dimension == DIMENSIONS.OVERWORLD.getDimensionID());
	}
}
