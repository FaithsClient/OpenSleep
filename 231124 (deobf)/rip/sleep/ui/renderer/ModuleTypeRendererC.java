package rip.sleep.ui.renderer;

import Sleep.native0;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONException;
import rip.sleep.Sleep;
import rip.sleep.interfaces.IFontRenderer;
import rip.sleep.interfaces.IFontManager;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.ui.neverlose.components.CheckBoxComponent;
import rip.sleep.ui.neverlose.components.NeverLoseComponent;
import rip.sleep.ui.neverlose.components.PanelComponent;
import rip.sleep.ui.neverlose.components.SliderComponent;
import rip.sleep.struct.AnimationState;
import rip.sleep.util.RenderUtilE;
import rip.sleep.value.Value;

@native0
public class ModuleTypeRendererC {
   public ModuleType c95571;
   public int c65548;
   public int c49576;
   public int c85121;
   public int c9167;
   public int c51869;
   public List<PanelComponent> c37197 = new ArrayList();

   public ModuleTypeRendererC(ModuleType var1, int var2) {
      this.c95571 = var1;
      Value.c27574();
      this.c51869 = var2;
      int var4 = 0;
      ModuleType.c21190[] var5 = var1.c42698();
      int var6 = var5.length;
      int var7 = 0;
      if (var7 < var6) {
         ModuleType.c21190 var8 = var5[var7];
         this.c37197.add(new PanelComponent(var8, var2 + var4));
         var4 = var4 + 18;
         ++var7;
      }

   }

   public void c16074(int var1, int var2) {
      Module[] var3 = Value.c27574();
      IFontRenderer var10000 = IFontManager.NL_FONT.c16126.c55770;
      String var10001 = this.c95571.name();
      int var10002 = this.c65548 + 10;
      int var10003 = this.c49576 + this.c51869;
      Sleep var10004 = Sleep.INSTANCE;
      var10000.c48462(var10001, var10002, var10003, Sleep.c43802.c45529() ? (new Color(194, 196, 198)).getRGB() : (new Color(220, 220, 220)).getRGB());
      Iterator var4 = this.c37197.iterator();
      if (var4.hasNext()) {
         PanelComponent var5 = (PanelComponent)var4.next();
         var5.c48565 = this.c65548;
         var5.c57187 = this.c49576;
         var5.c46448 = this.c85121;
         var5.c72358 = this.c9167;
         if (!var5.c85844()) {
            Iterator var6 = var5.c35514.iterator();
            if (var6.hasNext()) {
               ComponentRenderer var7 = (ComponentRenderer)var6.next();
               Iterator var8 = var7.c66292.iterator();
               if (var8.hasNext()) {
                  NeverLoseComponent var9 = (NeverLoseComponent)var8.next();
                  if (var9 instanceof SliderComponent) {
                     ((SliderComponent)var9).c73564 = 0.0F;
                  }

                  if (var9 instanceof CheckBoxComponent && ((CheckBoxComponent)var9).c99475.c12335().equals(AnimationState.Forward)) {
                     ((CheckBoxComponent)var9).c99475.c6094();
                  }
               }

               if (var7.c8668.c12335().equals(AnimationState.Forward)) {
                  var7.c8668.c6094();
               }
            }
         }

         var5.c295(var1, var2);
      }

   }

   public void c5254(char var1, int var2) {
      this.c37197.forEach((var2x) -> {
         var2x.c45513(var1, var2);
      });
   }

   public void c21401(int var1, int var2, int var3) {
      this.c37197.forEach((var3x) -> {
         var3x.c39160(var1, var2, var3);
      });
   }

   public void c81437(int var1, int var2, int var3) {
      Module[] var4 = Value.c27574();
      this.c37197.forEach((var3x) -> {
         var3x.c5933(var1, var2, var3);
      });
      Iterator var5 = this.c37197.iterator();
      if (var5.hasNext()) {
         PanelComponent var6 = (PanelComponent)var5.next();
         if (RenderUtilE.c3863((float)(var6.c48565 + 7), (float)(var6.c57187 + var6.c8045 + 8), 76.0F, 15.0F, var1, var2)) {
            Sleep var10000 = Sleep.INSTANCE;
            Sleep.c43802.c48514 = var6.c94267;
         }
      }

   }

   private static JSONException c68980(JSONException var0) {
      return var0;
   }
}
