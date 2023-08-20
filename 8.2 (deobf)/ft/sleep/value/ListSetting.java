package ft.sleep.value;

import ft.sleep.Client;
import ft.sleep.api.value.Mode;
import ft.sleep.api.value.Value;
import ft.sleep.module.modules.HUD;
import ft.sleep.ui.font.FontLoaders;
import java.awt.Color;

import ft.sleep.util.animation.Animation;
import ft.sleep.util.render.RenderUtil4;
import org.lwjgl.opengl.GL11;

public class ListSetting extends Downward {
   public Mode flame$;
   public Animation solid$ = new EaseInOutQuad(250, 1.0D, Direction.posted$);
   public float regions$;
   public float modify$;
   public float anger$;

   public ListSetting(Mode unolofid, float afumudig, float aculalop, int acofebuc, int adetiyin, ModuleRender2 ecibumec) {
      super((Value)unolofid, (float)afumudig, (float)aculalop, (int)acofebuc, (int)adetiyin, (ModuleRender2)ecibumec);
      izacomic.flame$ = (Mode)unolofid;
   }

   public void __/* $FF was: */(int soonest, int spine) {
      infant.regions$ = Client.surround$.conflict$.();
      infant.modify$ = Client.surround$.conflict$.();
      infant.anger$ = infant..strength$ + (float)infant.();
      FontLoaders.TahomaBold11.drawString(infant.flame$.getName(), infant.regions$ + 5.0F + infant..linking$ + 4.0F, infant.modify$ + 17.0F + infant.anger$ + 13.0F, (new Color(200, 200, 200)).getRGB());
      RenderUtil4._knowing(infant.regions$ + 5.0F + infant..linking$ + 80.0F, infant.modify$ + 17.0F + infant.anger$ + 8.0F, 50.0F, 11.0F, 1.0F, (new Color(59, 63, 72)).getRGB(), 1.0F, (new Color(85, 90, 96)).getRGB());
      if (infant._gabriel((int)soonest, (int)spine)) {
         RenderUtil4._knowing(infant.regions$ + 5.0F + infant..linking$ + 80.0F, infant.modify$ + 17.0F + infant.anger$ + 8.0F, 50.0F, 11.0F, 1.0F, (new Color(0, 0, 0, 0)).getRGB(), 1.0F, (new Color(HUD.during$.getValue().intValue())).getRGB());
      }

      FontLoaders.TahomaBold11.drawString(infant.flame$.getValue() + "", infant.regions$ + 5.0F + infant..linking$ + 82.0F, infant.modify$ + 17.0F + infant.anger$ + 13.0F, (new Color(200, 200, 200)).getRGB());
      infant.solid$._kathy(infant.flame$.openList ? Direction.verse$ : Direction.posted$);
      RenderUtil4._exhibit(infant.regions$ + 5.0F + infant..linking$ + 123.5F, infant.modify$ + 17.0F + infant.anger$ + 13.0F, 4.0F, infant.solid$, (new Color(222, 224, 236)).getRGB());
      if (infant.flame$.openList) {
         GL11.glTranslatef(Float.intBitsToFloat(0), Float.intBitsToFloat(0), 2.0F);
         RenderUtil4._avatar(infant.regions$ + 5.0F + infant..linking$ + 80.0F, infant.modify$ + 17.0F + infant.anger$ + 8.0F + 13.0F, infant.regions$ + 5.0F + infant..linking$ + 80.0F + 50.0F, infant.modify$ + 17.0F + infant.anger$ + 8.0F + 13.0F + (float)infant.flame$.getModes().length * 11.0F, 1.0F, (new Color(85, 90, 96)).getRGB(), (new Color(59, 63, 72)).getRGB());

         for(Object hacker : infant.flame$.getModes()) {
            FontLoaders.TahomaBold11.drawString(hacker, infant.regions$ + 5.0F + infant..linking$ + 82.0F, infant.modify$ + 17.0F + infant.anger$ + 1.0F + 13.0F + 12.0F + (float)(infant.flame$.getModeListinde(hacker) * 11), hacker.equals(infant.flame$.getValue()) ? (new Color(HUD.during$.getValue().intValue())).getRGB() : (new Color(200, 200, 200)).getRGB());
         }

         GL11.glTranslatef(Float.intBitsToFloat(0), Float.intBitsToFloat(0), -2.0F);
      }

   }

   public void __/* $FF was: */(int rayidimu, int oganuniz, int asurepeg) {
      if (asurepeg == 1 && pepemepa._gabriel((int)rayidimu, (int)oganuniz)) {
         pepemepa.flame$.openList = !pepemepa.flame$.openList;
      }

      if (asurepeg == 0 && pepemepa.flame$.openList && (float)rayidimu >= pepemepa.regions$ + 5.0F + pepemepa..linking$ + 80.0F && (float)rayidimu <= pepemepa.regions$ + 5.0F + pepemepa..linking$ + 80.0F + 50.0F) {
         for(Object itofegid = 0; itofegid < pepemepa.flame$.getModes().length; ++itofegid) {
            Object ecidedef = (int)(pepemepa.modify$ + 17.0F + pepemepa.anger$ + 8.0F + 13.0F + (float)(itofegid * 11));
            if (oganuniz >= ecidedef && oganuniz <= ecidedef + 11) {
               pepemepa.flame$.setValue(pepemepa.flame$.getModeGet(itofegid));
               pepemepa.flame$.openList = false;
            }
         }
      }

   }

   public boolean _gabriel(int alocurap, int urefurus) {
      return (float)alocurap >= dafotode.regions$ + 5.0F + dafotode..linking$ + 80.0F && (float)alocurap <= dafotode.regions$ + 5.0F + dafotode..linking$ + 80.0F + 50.0F && (float)urefurus >= dafotode.modify$ + 17.0F + dafotode.anger$ + 8.0F && (float)urefurus <= dafotode.modify$ + 17.0F + dafotode.anger$ + 8.0F + 11.0F;
   }

   public void __/* $FF was: */(int var1, int var2, int var3) {
   }
}
