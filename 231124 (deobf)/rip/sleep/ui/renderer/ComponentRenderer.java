package rip.sleep.ui.renderer;

import Sleep.native0;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import org.json.JSONException;
import org.lwjgl.input.Keyboard;
import rip.sleep.Sleep;
import rip.sleep.interfaces.IFontRenderer;
import rip.sleep.interfaces.IFontManager;
import rip.sleep.module.Module;
import rip.sleep.module.modules.HUD;
import rip.sleep.ui.neverlose.components.*;
import rip.sleep.struct.AnimationState;
import rip.sleep.util.AnimationUtilA;
import rip.sleep.util.AnimationUtilD;
import rip.sleep.util.RenderUtilD;
import rip.sleep.util.RenderUtilE;
import rip.sleep.util.RenderUtilG;
import rip.sleep.util.ShaderUtilA;
import rip.sleep.value.Value;
import rip.sleep.value.values.*;

@native0
public class ComponentRenderer {
   public int c78871;
   public int c82746;
   public int c18377;
   public int c19740;
   public PanelComponent c51719;
   public Module c71729;
   public int c98781;
   public int c48510;
   public int c54510;
   public int c37437;
   public int c53648 = 0;
   public List<NeverLoseComponent> c66292 = new ArrayList();
   public int c9138;
   public AnimationUtilA c8668 = new AnimationUtilD(225, 1.0D, AnimationState.Backward);
   public AnimationUtilA c84838;
   public boolean c66202;
   public boolean c19591;

   public ComponentRenderer(PanelComponent var1, Module var2, boolean var3) {
      Value.c27574();
      this.c84838 = new AnimationUtilD(225, 1.0D, AnimationState.Backward);
      this.c51719 = var1;
      this.c71729 = var2;
      this.c66202 = var3;
      this.c54510 = var3 ? 0 : 170;
      Iterator var5 = var2.c22326().iterator();
      if (var5.hasNext()) {
         Value var6 = (Value)var5.next();
         if (var6 instanceof BooleanValue) {
            this.c66292.add(new CheckBoxComponent((BooleanValue)var6, this));
         }

         if (var6 instanceof NumberValue) {
            this.c66292.add(new SliderComponent((NumberValue)var6, this));
         }

         if (var6 instanceof ModeValue) {
            this.c66292.add(new ComboComponent((ModeValue)var6, this));
         }

         if (var6 instanceof StringValue) {
            this.c66292.add(new TextFieldComponent((StringValue)var6, this));
         }

         if (var6 instanceof IntValue) {
            this.c66292.add(new IntSliderComponent((IntValue)var6, this));
         }

         if (var6 instanceof MultiBooleanValue) {
            this.c66292.add(new MultiComboComponent((MultiBooleanValue)var6, this));
         }
      }

   }

   public int c18047() {
      Value.c27574();
      int var2 = 20;
      Iterator var3 = ((List)this.c71729.c22326().stream().filter(Value::c64597).collect(Collectors.toList())).iterator();
      if (var3.hasNext()) {
         Value var4 = (Value)var3.next();
         var2 += 20;
      }

      if (this.c71729.c22326().isEmpty()) {
         var2 += 20;
      }

      return var2;
   }

   public int c96924() {
      Value.c27574();
      this.c98781 = 0;
      this.c48510 = 0;
      Iterator var2 = this.c51719.c35514.iterator();
      if (var2.hasNext()) {
         ComponentRenderer var3 = (ComponentRenderer)var2.next();
         if (var3 == this) {
            ;
         }

         if (var3.c66202) {
            this.c98781 += var3.c18047() + 10;
         }

         this.c48510 += var3.c18047() + 10;
      }

      return this.c66202 ? this.c98781 : this.c48510;
   }

   public void c80771(int var1, int var2) {
      Value.c27574();
      this.c37437 = this.c96924();
      float var10000 = (float)(this.c78871 + 95 + this.c54510);
      float var10001 = (float)(this.c82746 + 50 + this.c37437 + this.c9138);
      float var10003 = (float)this.c18047();
      Sleep var10005 = Sleep.INSTANCE;
      ShaderUtilA.c76901(var10000, var10001, 160.0F, var10003, 4.0F, Sleep.c43802.c45529() ? new Color(245, 245, 245) : new Color(15, 15, 15, 30));
      Sleep var8 = Sleep.INSTANCE;
      if (!Sleep.c43802.c45529()) {
         RenderUtilD.c15402((float)(this.c78871 + 95 + this.c54510), (float)(this.c82746 + 50 + this.c37437 + this.c9138), 160.0F, (float)this.c18047(), 5, new Color(15, 15, 15, 40));
      }

      IFontRenderer var9 = IFontManager.NL_FONT.c41337.c17902;
      String var12 = this.c71729.getName();
      int var10002 = this.c78871 + 100 + this.c54510;
      int var17 = this.c82746 + this.c37437 + 55 + this.c9138;
      Sleep var10004 = Sleep.INSTANCE;
      var9.c48462(var12, var10002, var17, Sleep.c43802.c45529() ? (new Color(95, 95, 95)).getRGB() : -1);
      float var10 = (float)(this.c78871 + 100 + this.c54510);
      float var13 = (float)(this.c82746 + 65 + this.c37437 + this.c9138);
      var10005 = Sleep.INSTANCE;
      ShaderUtilA.c76901(var10, var13, 150.0F, 0.7F, 0.0F, Sleep.c43802.c45529() ? new Color(213, 213, 213) : new Color(9, 21, 34, 70));
      ShaderUtilA.c76901((float)(this.c78871 + 260) - 31.5F - (float) IFontManager.NL_FONT.c41337.c17902.c80174(this.c19591 ? "Binding..." : Keyboard.getKeyName(this.c71729.c93366()).toUpperCase()) + (float)this.c54510, (float)(this.c82746 + this.c37437 + this.c9138) + 55.5F - 1.0F, (float)(IFontManager.NL_FONT.c41337.c17902.c80174(this.c19591 ? "Binding..." : Keyboard.getKeyName(this.c71729.c93366()).toUpperCase()) + 2), 6.5F, 1.0F, new Color(10, 10, 10, 90));
      IFontRenderer var11 = IFontManager.NL_FONT.c41337.c17902;
      String var14 = this.c19591 ? "Binding..." : Keyboard.getKeyName(this.c71729.c93366()).toUpperCase();
      var10002 = this.c78871 + 229 - IFontManager.NL_FONT.c41337.c17902.c80174(this.c19591 ? "Binding..." : Keyboard.getKeyName(this.c71729.c93366()).toUpperCase()) + this.c54510;
      var17 = this.c82746 + this.c37437 + 55 + this.c9138;
      var10004 = Sleep.INSTANCE;
      var11.c48462(var14, var10002, var17, Sleep.c43802.c45529() ? (new Color(95, 95, 95)).getRGB() : -1);
      this.c84838.c96546(RenderUtilE.c3863((float)(this.c78871 + 265 - 32 + this.c54510), (float)(this.c82746 + this.c37437 + this.c9138 + 56), 16.0F, 4.5F, var1, var2) ? AnimationState.Forward : AnimationState.Backward);
      int var4 = 20;
      Iterator var5 = ((List)this.c66292.stream().filter((var0) -> {
         return var0.c93183.c64597().booleanValue();
      }).collect(Collectors.toList())).iterator();
      if (var5.hasNext()) {
         NeverLoseComponent var6 = (NeverLoseComponent)var5.next();
         var6.c91958(this.c54510);
         var6.c57589(this.c96924() + var4);
         var4 = var4 + 20;
         var6.c60551(var1, var2);
      }

      this.c79697();
      if (this.c71729.c22326().isEmpty()) {
         var10002 = this.c78871 + 100 + this.c54510;
         var17 = this.c82746 + this.c37437 + this.c9138 + 72;
         var10004 = Sleep.INSTANCE;
         IFontManager.NL_FONT.c30764.c58133.c48462("No Settings.", var10002, var17, Sleep.c43802.c45529() ? (new Color(95, 95, 95)).getRGB() : -1);
      }

   }

   public void c79697() {
      Color var2 = new Color(29, 29, 39, 255);
      Value.c27574();
      Color var3 = RenderUtilE.c14245(var2, 0.8F);
      Color var4 = RenderUtilE.c95489(new Color(HUD.c64734.c41161().intValue()), 0.9F);
      this.c8668.c96546(this.c71729.c24622() ? AnimationState.Forward : AnimationState.Backward);
      ShaderUtilA.c76901((float)(this.c78871 + 265 - 32 + this.c54510), (float)(this.c82746 + this.c37437 + this.c9138 + 54), 16.0F, 7.5F, 4.0F, RenderUtilG.c88833(RenderUtilG.c23588(var3, 0.1F), var4, (float)this.c8668.c53286()));
      RenderUtilE.c50903((float)((double)((float)(this.c78871 + 265) + 4.0F - 32.0F + (float)this.c54510) + 8.0D * this.c8668.c53286()), (float)(this.c82746 + this.c37437 + this.c9138 + 56 + 2), 6.0F, Color.BLACK, 0.3F);
      RenderUtilE.c80882();
      float var10000 = (float)((double)((float)(this.c78871 + 265) - 31.5F + (float)this.c54510) + 8.0D * this.c8668.c53286());
      float var10001 = (float)(this.c82746 + this.c37437 + this.c9138) + 55.5F - 1.0F;
      Color var10005;
      if (this.c71729.c24622()) {
         var10005 = new Color(HUD.c64734.c41161().intValue());
      } else {
         Sleep var5 = Sleep.INSTANCE;
         var10005 = Sleep.c43802.c45529() ? new Color(255, 255, 255) : new Color((int)(68.0D - 28.0D * this.c84838.c53286()), (int)(82.0D + 44.0D * this.c84838.c53286()), (int)(87.0D + 83.0D * this.c84838.c53286()));
      }

      ShaderUtilA.c76901(var10000, var10001, 6.5F, 6.5F, 3.0F, var10005);
   }

   public void c11226(char var1, int var2) {
      Value.c27574();
      this.c66292.forEach((var2x) -> {
         var2x.c91879(var1, var2);
      });
      if (this.c19591) {
         if (var2 == 211) {
            var2 = 0;
         }

         this.c71729.c32946(var2);
         this.c19591 = false;
      }

   }

   public void c3958(int var1, int var2, int var3) {
      this.c66292.stream().filter((var0) -> {
         return var0.c93183.c64597().booleanValue();
      }).forEach((var3x) -> {
         var3x.c66160(var1, var2, var3);
      });
   }

   public void c24639(int var1, int var2, int var3) {
      Value.c27574();
      this.c66292.stream().filter((var0) -> {
         return var0.c93183.c64597().booleanValue();
      }).forEach((var3x) -> {
         var3x.c80028(var1, var2, var3);
      });
      if (RenderUtilE.c3863((float)(this.c78871 + 265 - 32 + this.c54510), (float)(this.c82746 + this.c37437 + this.c9138 + 56), 16.0F, 4.5F, var1, var2) && var3 == 0) {
         this.c71729.c19741();
      }

      if (RenderUtilE.c3863((float)(this.c78871 + 260) - 31.5F - (float) IFontManager.NL_FONT.c41337.c17902.c80174(this.c19591 ? "Binding..." : Keyboard.getKeyName(this.c71729.c93366()).toUpperCase()) + (float)this.c54510, (float)(this.c82746 + this.c37437 + this.c9138) + 55.5F - 1.0F, (float)(IFontManager.NL_FONT.c41337.c17902.c80174(this.c19591 ? "Binding..." : Keyboard.getKeyName(this.c71729.c93366()).toUpperCase()) + 2), 6.5F, var1, var2) && var3 == 1) {
         this.c19591 = true;
      }

      if (!RenderUtilE.c3863((float)(this.c78871 + 260) - 31.5F - (float) IFontManager.NL_FONT.c41337.c17902.c80174(this.c19591 ? "Binding..." : Keyboard.getKeyName(this.c71729.c93366()).toUpperCase()) + (float)this.c54510, (float)(this.c82746 + this.c37437 + this.c9138) + 55.5F - 1.0F, (float)(IFontManager.NL_FONT.c41337.c17902.c80174(this.c19591 ? "Binding..." : Keyboard.getKeyName(this.c71729.c93366()).toUpperCase()) + 2), 6.5F, var1, var2) && var3 == 1 && this.c19591) {
         this.c19591 = false;
      }

      if (this.c19591 && var3 == 0) {
         this.c71729.c32946(0);
         this.c19591 = false;
      }

   }

   private static JSONException c23683(JSONException var0) {
      return var0;
   }
}
