package ft.sleep.api;

public class Position {
   private final double posX;
   private final double posY;
   private final double posZ;

   public Position(double x, double y, double z) {
      this.posX = x;
      this.posY = y;
      this.posZ = z;
   }

   public double getPosX() {
      return this.posX;
   }

   public double getPosY() {
      return this.posY;
   }

   public double getPosZ() {
      return this.posZ;
   }
}
