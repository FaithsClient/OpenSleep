package ft.sleep.value;

import ft.sleep.Client;
import ft.sleep.api.value.Option;
import ft.sleep.api.value.Value;
import ft.sleep.ui.font.FontLoaders;
import ft.sleep.util.render.RenderUtil4;

import java.awt.Color;

public class BoolSetting extends Downward {
   public float notion$;
   public float faith$;
   public float aging$;

   public BoolSetting(Option bafevili, float leluvusa, float esocecel, int egasalum, int iminazoz, ModuleRender2 puladayi) {
      super((Value)bafevili, (float)leluvusa, (float)esocecel, (int)egasalum, (int)iminazoz, (ModuleRender2)puladayi);
   }

   public void __/* $FF was: */(int midlands, int allow) {
      regular.notion$ = Client.surround$.conflict$.();
      regular.faith$ = Client.surround$.conflict$.();
      regular.aging$ = regular..strength$ + (float)regular.();
      RenderUtil4._knowing(regular.notion$ + 5.0F + regular..linking$ + 4.0F, regular.faith$ + 17.0F + regular.aging$ + 8.0F, 7.0F, 7.0F, 1.0F, ((Option)regular.).getValue().booleanValue() ? (new Color(86, 94, 115)).getRGB() : (new Color(50, 54, 65)).getRGB(), 1.0F, ((Option)regular.).getValue().booleanValue() ? (new Color(86, 94, 115)).getRGB() : (new Color(85, 90, 96)).getRGB());
      if (regular._nicholas((int)midlands, (int)allow)) {
         RenderUtil4._knowing(regular.notion$ + 5.0F + regular..linking$ + 4.0F, regular.faith$ + 17.0F + regular.aging$ + 8.0F, 7.0F, 7.0F, 1.0F, (new Color(0, 0, 0, 0)).getRGB(), 1.0F, (new Color(HUD.during$.getValue().intValue())).getRGB());
      }

      FontLoaders.TahomaBold11.drawString(((Option)regular.).getName(), regular.notion$ + 5.0F + regular..linking$ + 4.0F + 10.0F, regular.faith$ + 17.0F + regular.aging$ + 8.0F + 3.0F, (new Color(200, 200, 200)).getRGB());
   }

   public void __/* $FF was: */(int buvapiga, int ibiyutiy, int var3) {
      if (irevovud._nicholas((int)buvapiga, (int)ibiyutiy)) {
         ((Option)irevovud.).toggle();
      }

   }

   public void __/* $FF was: */(int var1, int var2, int var3) {
   }

   public boolean _nicholas(int tiffany, int cialis) {
      return (float)tiffany >= branches.notion$ + 5.0F + branches..linking$ + 4.0F && (float)tiffany <= branches.notion$ + 5.0F + branches..linking$ + 4.0F + 135.0F - 128.0F && (float)cialis >= branches.faith$ + 17.0F + branches.aging$ + 8.0F && (float)cialis <= branches.faith$ + 17.0F + branches.aging$ + 8.0F + 7.0F;
   }
}
