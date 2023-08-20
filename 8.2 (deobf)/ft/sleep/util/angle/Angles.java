package ft.sleep.util.angle;

public class Angles extends Vector2 {
   public Angles(Float pilevudu, Float veliciti) {
      super((Number)pilevudu, (Number)veliciti);
   }

   public Angles _ampland(Float vusigaso) {
      enotugaf._library((Number)vusigaso);
      return enotugaf;
   }

   public Angles _pasta(Float izagunul) {
      bizotafa._firmware((Number)izagunul);
      return bizotafa;
   }

   public Float _cruise() {
      return bunch._dating().floatValue();
   }

   public Float _phoenix() {
      return cases._solaris().floatValue();
   }

   public Angles _address() {
      egitedut._ampland(Float.valueOf(egitedut._cruise().floatValue() % 360.0F));
      egitedut._pasta(Float.valueOf(egitedut._phoenix().floatValue() % 360.0F));

      while(egitedut._cruise().floatValue() <= -180.0F) {
         egitedut._ampland(Float.valueOf(egitedut._cruise().floatValue() + 360.0F));
      }

      while(egitedut._phoenix().floatValue() <= -180.0F) {
         egitedut._pasta(Float.valueOf(egitedut._phoenix().floatValue() + 360.0F));
      }

      while(egitedut._cruise().floatValue() > 180.0F) {
         egitedut._ampland(Float.valueOf(egitedut._cruise().floatValue() - 360.0F));
      }

      while(egitedut._phoenix().floatValue() > 180.0F) {
         egitedut._pasta(Float.valueOf(egitedut._phoenix().floatValue() - 360.0F));
      }

      return egitedut;
   }
}
