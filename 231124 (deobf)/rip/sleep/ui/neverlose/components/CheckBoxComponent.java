package rip.sleep.ui.neverlose.components;

import java.awt.Color;
import org.json.JSONException;
import rip.sleep.interfaces.IFontRenderer;
import rip.sleep.interfaces.IFontManager;
import rip.sleep.module.modules.HUD;
import rip.sleep.struct.AnimationState;
import rip.sleep.util.AnimationUtilA;
import rip.sleep.util.AnimationUtilD;
import rip.sleep.util.RenderUtilE;
import rip.sleep.util.ShaderUtilA;
import rip.sleep.value.Value;
import rip.sleep.value.values.BooleanValue;
import rip.sleep.ui.renderer.ComponentRenderer;
import rip.sleep.module.Module;
import rip.sleep.Sleep;

public class CheckBoxComponent extends NeverLoseComponent<BooleanValue> {
   public AnimationUtilA c99475 = new AnimationUtilD(225, 1.0D, AnimationState.Backward);
   public AnimationUtilA c63996 = new AnimationUtilD(225, 1.0D, AnimationState.Backward);

   public CheckBoxComponent(BooleanValue var1, ComponentRenderer var2) {
      super(var1, var2);
   }

   public void c60551(int var1, int var2) {
      Sleep var10000 = Sleep.INSTANCE;
      int var4 = Sleep.c43802.c16525;
      var10000 = Sleep.INSTANCE;
      Value.c27574();
      int var5 = Sleep.c43802.c9435;
      int var6 = (int)(this.c49717() + (float)this.c51261());
      IFontRenderer var11 = IFontManager.NL_FONT.c39582.c9044;
      String var10001 = ((BooleanValue)this.c93183).getName();
      float var10002 = (float)(var4 + 100) + this.c9605();
      float var10003 = (float)(var5 + var6 + 60);
      Sleep var10004 = Sleep.INSTANCE;
      var11.c18223(var10001, var10002, var10003, Sleep.c43802.c45529() ? (new Color(95, 95, 95)).getRGB() : -1);
      Color var7 = new Color(29, 29, 39, 255);
      Color var8 = RenderUtilE.c14245(var7, 0.8F);
      Color var9 = RenderUtilE.c95489(new Color(HUD.c64734.c41161().intValue()), 0.9F);
      this.c99475.c96546(((BooleanValue)this.c93183).c1473().booleanValue() ? AnimationState.Forward : AnimationState.Backward);
      AnimationUtilA var12 = this.c63996;
      Sleep var15 = Sleep.INSTANCE;
      float var16 = (float)(Sleep.c43802.c16525 + 265 - 32) + this.c9605();
      Sleep var19 = Sleep.INSTANCE;
      var12.c96546(RenderUtilE.c3863(var16, (float)(Sleep.c43802.c9435 + (int)(this.c49717() + (float)this.c51261()) + 57), 16.0F, 4.5F, var1, var2) ? AnimationState.Forward : AnimationState.Backward);
      float var13 = (float)(var4 + 265 - 32) + this.c9605();
      var16 = (float)(var5 + var6) + 57.5F;
      Sleep var10005 = Sleep.INSTANCE;
      ShaderUtilA.c76901(var13, var16, 16.0F, 7.5F, 4.0F, Sleep.c43802.c45529() ? RenderUtilE.c58163(new Color(230, 230, 230), new Color(HUD.c64734.c41161().intValue()), (float)this.c99475.c53286()) : RenderUtilE.c58163(RenderUtilE.c7378(var8, 0.5F), var9, (float)this.c99475.c53286()));
      RenderUtilE.c50903((float)((double)((float)(var4 + 265 + 3) - 31.5F + this.c9605()) + 8.0D * this.c99475.c53286()), (float)(var5 + var6 + 57) + 4.0F, 6.0F, Color.BLACK, 0.3F);
      RenderUtilE.c80882();
      var13 = (float)((double)((float)(var4 + 265) - 31.5F + this.c9605()) + 8.0D * this.c99475.c53286());
      var16 = (float)(var5 + var6 + 57) + 1.0F;
      Color var20;
      if (((BooleanValue)this.c93183).c1473().booleanValue()) {
         var20 = new Color(HUD.c64734.c41161().intValue());
      } else {
         Sleep var21 = Sleep.INSTANCE;
         var20 = Sleep.c43802.c45529() ? new Color(255, 255, 255) : new Color((int)(68.0D - 28.0D * this.c63996.c53286()), (int)(82.0D + 44.0D * this.c63996.c53286()), (int)(87.0D + 83.0D * this.c63996.c53286()));
      }

      ShaderUtilA.c76901(var13, var16, 6.5F, 6.5F, 3.0F, var20);
   }

   public void c80028(int var1, int var2, int var3) {
      Module[] var4 = Value.c27574();
      if (var3 == 0) {
         Sleep var10000 = Sleep.INSTANCE;
         float var5 = (float)(Sleep.c43802.c16525 + 265 - 32) + this.c9605();
         Sleep var10001 = Sleep.INSTANCE;
         if (RenderUtilE.c3863(var5, (float)(Sleep.c43802.c9435 + (int)(this.c49717() + (float)this.c51261()) + 57), 16.0F, 4.5F, var1, var2)) {
            ((BooleanValue)this.c93183).c26405();
         }
      }

   }

   public void c66160(int var1, int var2, int var3) {
   }

   private static JSONException c99200(JSONException var0) {
      return var0;
   }
}
