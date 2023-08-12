package linxiu.api;

public class Position {
	private final double posX;
    private final double posY;
    private final double posZ;

	public Position(double x, double y, double z) {
		posX = x;
		posY = y;
		posZ = z;
	}

	public double getPosX() {
		return posX;
	}

	public double getPosY() {
		return posY;
	}

	public double getPosZ() {
		return posZ;
	}
}