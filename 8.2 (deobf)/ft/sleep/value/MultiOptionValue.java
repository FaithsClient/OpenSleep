package ft.sleep.value;

import ft.sleep.Client;
import ft.sleep.api.value.Option;
import ft.sleep.api.value.Value;
import ft.sleep.module.modules.HUD;
import ft.sleep.ui.font.FontLoaders;
import java.awt.Color;

import ft.sleep.util.animation.Animation;
import ft.sleep.util.render.RenderUtil4;
import org.lwjgl.opengl.GL11;

public class MultiOptionValue extends Downward {
   public Animation housing$ = new EaseInOutQuad(250, 1.0D, Direction.posted$);
   public double anatomy$ = 3.0D;
   public double approval$ = 5.0D;
   public Option dispatch$;
   public boolean ballot$ = true;
   public float airplane$;
   public float alberta$;
   public float thats$;

   public MultiOptionValue(ft.sleep.api.value.MultiOptionValue snake, float occurred, float rendered, int drilling, int sweet, ModuleRender2 cartoons) {
      super((Value)snake, (float)occurred, (float)rendered, (int)drilling, (int)sweet, (ModuleRender2)cartoons);
   }

   public void __/* $FF was: */(int imezelal, int vucopivo) {
      ugasayom.airplane$ = Client.surround$.conflict$.();
      ugasayom.alberta$ = Client.surround$.conflict$.();
      ugasayom.thats$ = ugasayom..strength$ + (float)ugasayom.();

      for(Object mozafuve : ((ft.sleep.api.value.MultiOptionValue)ugasayom.).getBoolSettings()) {
         if (ugasayom.ballot$ && mozafuve.getValue().booleanValue()) {
            ugasayom.dispatch$ = mozafuve;
            ugasayom.ballot$ = false;
         }
      }

      if (!ugasayom._mexico()) {
         if (((Option)((ft.sleep.api.value.MultiOptionValue)ugasayom.).getBoolSettings().get(0)).getValue().booleanValue()) {
            ugasayom.dispatch$ = (Option)((ft.sleep.api.value.MultiOptionValue)ugasayom.).getBoolSettings().get(0);
         } else if (!ugasayom.dispatch$.getValue().booleanValue()) {
            ugasayom.ballot$ = true;
         }
      }

      FontLoaders.TahomaBold11.drawString(((ft.sleep.api.value.MultiOptionValue)ugasayom.).getName(), ugasayom.airplane$ + 5.0F + ugasayom..linking$ + 4.0F, ugasayom.alberta$ + 17.0F + ugasayom.thats$ + 13.0F, (new Color(200, 200, 200)).getRGB());
      RenderUtil4._knowing(ugasayom.airplane$ + 5.0F + ugasayom..linking$ + 80.0F, ugasayom.alberta$ + 17.0F + ugasayom.thats$ + 8.0F, 50.0F, 11.0F, 1.0F, (new Color(59, 63, 72)).getRGB(), 1.0F, (new Color(85, 90, 96)).getRGB());
      if (ugasayom._mexico()) {
         FontLoaders.TahomaBold11.drawString("...", ugasayom.airplane$ + 5.0F + ugasayom..linking$ + 82.0F, ugasayom.alberta$ + 17.0F + ugasayom.thats$ + 13.0F, (new Color(200, 200, 200)).getRGB());
      } else if (ugasayom.dispatch$ != null) {
         FontLoaders.TahomaBold11.drawString(ugasayom._marshall() > 1 ? ugasayom.dispatch$.getName() + "..." : ugasayom.dispatch$.getName(), ugasayom.airplane$ + 5.0F + ugasayom..linking$ + 82.0F, ugasayom.alberta$ + 17.0F + ugasayom.thats$ + 13.0F, (new Color(200, 200, 200)).getRGB());
      }

      if (ugasayom._railroad((int)imezelal, (int)vucopivo)) {
         RenderUtil4._knowing(ugasayom.airplane$ + 5.0F + ugasayom..linking$ + 80.0F, ugasayom.alberta$ + 17.0F + ugasayom.thats$ + 8.0F, 50.0F, 11.0F, 1.0F, (new Color(0, 0, 0, 0)).getRGB(), 1.0F, (new Color(HUD.during$.getValue().intValue())).getRGB());
      }

      ugasayom.housing$._kathy(((ft.sleep.api.value.MultiOptionValue)ugasayom.).openList ? Direction.verse$ : Direction.posted$);
      RenderUtil4._exhibit(ugasayom.airplane$ + 5.0F + ugasayom..linking$ + 123.5F, ugasayom.alberta$ + 17.0F + ugasayom.thats$ + 13.0F, 4.0F, ugasayom.housing$, (new Color(222, 224, 236)).getRGB());
      if (((ft.sleep.api.value.MultiOptionValue)ugasayom.).openList) {
         GL11.glTranslatef(Float.intBitsToFloat(0), Float.intBitsToFloat(0), 2.0F);
         RenderUtil4._avatar(ugasayom.airplane$ + 5.0F + ugasayom..linking$ + 80.0F, ugasayom.alberta$ + 17.0F + ugasayom.thats$ + 8.0F + 13.0F, ugasayom.airplane$ + 5.0F + ugasayom..linking$ + 80.0F + 50.0F, ugasayom.alberta$ + 17.0F + ugasayom.thats$ + 8.0F + 13.0F + (float)((ft.sleep.api.value.MultiOptionValue)ugasayom.).getBoolSettings().size() * 9.0F, 1.0F, (new Color(85, 90, 96)).getRGB(), (new Color(59, 63, 72)).getRGB());

         for(Object var6 : ((ft.sleep.api.value.MultiOptionValue)ugasayom.).getBoolSettings()) {
            FontLoaders.TahomaBold11.drawString(var6.getName(), ugasayom.airplane$ + 5.0F + ugasayom..linking$ + 82.0F, ugasayom.alberta$ + 17.0F + ugasayom.thats$ + 1.0F + 13.0F + 12.0F + (float)(((ft.sleep.api.value.MultiOptionValue)ugasayom.).getBoolSettings().indexOf(var6) * 9), var6.getValue().booleanValue() ? (new Color(HUD.during$.getValue().intValue())).getRGB() : (new Color(200, 200, 200)).getRGB());
         }

         GL11.glTranslatef(Float.intBitsToFloat(0), Float.intBitsToFloat(0), -2.0F);
      }

   }

   public boolean _mexico() {
      for(Object existing : ((ft.sleep.api.value.MultiOptionValue)intimate.).getBoolSettings()) {
         if (existing.getValue().booleanValue()) {
            return false;
         }
      }

      return true;
   }

   public int _marshall() {
      Object fixes = 0;

      for(Object blink : ((ft.sleep.api.value.MultiOptionValue)sympathy.).getBoolSettings()) {
         if (blink.getValue().booleanValue()) {
            ++fixes;
         }
      }

      return fixes;
   }

   public void __/* $FF was: */(int prior, int serial, int prairie) {
      if (prairie == 1 && serving._railroad((int)prior, (int)serial)) {
         ((ft.sleep.api.value.MultiOptionValue)serving.).openList = !((ft.sleep.api.value.MultiOptionValue)serving.).openList;
      }

      if (prairie == 0 && ((ft.sleep.api.value.MultiOptionValue)serving.).openList && (float)prior >= serving.airplane$ + 5.0F + serving..linking$ + 80.0F && (float)prior <= serving.airplane$ + 5.0F + serving..linking$ + 80.0F + 50.0F) {
         for(Object identity = 0; identity < ((ft.sleep.api.value.MultiOptionValue)serving.).getBoolSettings().size(); ++identity) {
            Object ratios = (int)(serving.alberta$ + 40.0F + serving.thats$ + (float)(identity * 9));
            if (serial >= ratios && serial <= ratios + 5) {
               if (!((Option)((ft.sleep.api.value.MultiOptionValue)serving.).getBoolSettings().get(identity)).getValue().booleanValue() && !((Option)((ft.sleep.api.value.MultiOptionValue)serving.).getBoolSettings().get(0)).getValue().booleanValue() && serving._mexico()) {
                  serving.dispatch$ = (Option)((ft.sleep.api.value.MultiOptionValue)serving.).getBoolSettings().get(identity);
               }

               ((Option)((ft.sleep.api.value.MultiOptionValue)serving.).getBoolSettings().get(identity)).toggle();
            }
         }
      }

   }

   public boolean _railroad(int edubudad, int sadetofu) {
      return (float)edubudad >= motosomo.airplane$ + 5.0F + motosomo..linking$ + 80.0F && (float)edubudad <= motosomo.airplane$ + 5.0F + motosomo..linking$ + 80.0F + 50.0F && (float)sadetofu >= motosomo.alberta$ + 17.0F + motosomo.thats$ + 8.0F && (float)sadetofu <= motosomo.alberta$ + 17.0F + motosomo.thats$ + 8.0F + 11.0F;
   }

   public void __/* $FF was: */(int var1, int var2, int var3) {
   }
}
