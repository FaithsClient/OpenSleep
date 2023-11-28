package rip.sleep.ui.element;

import java.util.function.Predicate;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiPageButtonList.GuiResponder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ChatAllowedCharacters;
import net.minecraft.util.MathHelper;
import org.json.JSONException;
import rip.sleep.module.Module;
import rip.sleep.util.RenderUtilA;
import rip.sleep.value.Value;

public class Element extends Gui {
   protected final int c81288;
   protected final FontRenderer c36421;
   public float c46254;
   public float c98483;
   protected final int c73424;
   protected final int c51871;
   protected String c21086 = "";
   private int c1317 = 64;
   protected int c16665;
   protected boolean c67239 = true;
   protected boolean c75165 = true;
   protected boolean c64280;
   protected boolean c82534 = true;
   protected int c44417;
   protected int c31757;
   protected int c1701;
   protected int c84152 = 14737632;
   protected int c23099 = 7368816;
   protected boolean c41625 = true;
   protected GuiResponder c789;
   protected Predicate<String> c72425 = (var0) -> {
      return true;
   };

   public Element(int var1, FontRenderer var2, int var3, int var4, int var5, int var6) {
      this.c81288 = var1;
      this.c36421 = var2;
      this.c46254 = (float)var3;
      this.c98483 = (float)var4;
      this.c73424 = var5;
      this.c51871 = var6;
   }

   public void c56457(GuiResponder var1) {
      this.c789 = var1;
   }

   public void c7050() {
      ++this.c16665;
   }

   public String c78567() {
      return this.c21086;
   }

   public void c2942(String var1) {
      Module[] var2 = Value.c27574();
      if (this.c72425.test(var1)) {
         if (var1.length() > this.c1317) {
            this.c21086 = var1.substring(0, this.c1317);
         }

         this.c21086 = var1;
         this.c66722();
      }

   }

   public String c77864() {
      int var1 = Math.min(this.c31757, this.c1701);
      int var2 = Math.max(this.c31757, this.c1701);
      return this.c21086.substring(var1, var2);
   }

   public void c32774(Predicate<String> var1) {
      this.c72425 = var1;
   }

   public void c32979(String var1) {
      String var3 = "";
      String var4 = ChatAllowedCharacters.filterAllowedCharacters(var1);
      int var5 = Math.min(this.c31757, this.c1701);
      int var6 = Math.max(this.c31757, this.c1701);
      Value.c27574();
      int var7 = this.c1317 - this.c21086.length() - (var5 - var6);
      if (!this.c21086.isEmpty()) {
         var3 = var3 + this.c21086.substring(0, var5);
      }

      if (var7 < var4.length()) {
         var3 = var3 + var4.substring(0, var7);
      }

      var3 = var3 + var4;
      int var8 = var4.length();
      if (!this.c21086.isEmpty() && var6 < this.c21086.length()) {
         var3 = var3 + this.c21086.substring(var6);
      }

      if (this.c72425.test(var3)) {
         this.c21086 = var3;
         this.c40946(var5 - this.c1701 + var8);
         if (this.c789 != null) {
            this.c789.func_175319_a(this.c81288, this.c21086);
         }
      }

   }

   public void c49664(int var1) {
      Module[] var2 = Value.c27574();
      if (!this.c21086.isEmpty()) {
         if (this.c1701 != this.c31757) {
            this.c32979("");
         }

         this.c42792(this.c31545(var1) - this.c31757);
      }

   }

   public void c42792(int var1) {
      Module[] var2 = Value.c27574();
      if (!this.c21086.isEmpty()) {
         if (this.c1701 != this.c31757) {
            this.c32979("");
         }

         boolean var3 = var1 < 0;
         int var4 = var3 ? this.c31757 + var1 : this.c31757;
         int var5 = var3 ? this.c31757 : this.c31757 + var1;
         String var6 = "";
         if (var4 >= 0) {
            var6 = this.c21086.substring(0, var4);
         }

         if (var5 < this.c21086.length()) {
            var6 = var6 + this.c21086.substring(var5);
         }

         if (this.c72425.test(var6)) {
            this.c21086 = var6;
            if (var3) {
               this.c40946(var1);
            }

            if (this.c789 != null) {
               this.c789.func_175319_a(this.c81288, this.c21086);
            }
         }
      }

   }

   public int c80271() {
      return this.c81288;
   }

   public int c31545(int var1) {
      return this.c43037(var1, this.c75770());
   }

   public int c43037(int var1, int var2) {
      return this.c53401(var1, var2, true);
   }

   public int c53401(int var1, int var2, boolean var3) {
      Value.c27574();
      int var5 = var2;
      boolean var6 = var1 < 0;
      int var7 = Math.abs(var1);
      int var8 = 0;
      if (var8 < var7) {
         if (!var6) {
            int var9 = this.c21086.length();
            var5 = this.c21086.indexOf(32, var2);
            if (var5 == -1) {
               var5 = var9;
            }

            if (var3 && var5 < var9 && this.c21086.charAt(var5) == ' ') {
               ++var5;
            }
         }

         if (var3 && var5 > 0 && this.c21086.charAt(var5 - 1) == ' ') {
            --var5;
         }

         if (var5 > 0 && this.c21086.charAt(var5 - 1) != ' ') {
            --var5;
         }

         ++var8;
      }

      return var5;
   }

   public void c40946(int var1) {
      this.c12318(this.c1701 + var1);
   }

   public void c18404() {
      this.c12318(0);
   }

   public void c66722() {
      this.c12318(this.c21086.length());
   }

   public boolean c76381(char var1, int var2) {
      Module[] var3 = Value.c27574();
      if (!this.c64280) {
         return false;
      } else if (GuiScreen.isKeyComboCtrlA(var2)) {
         this.c66722();
         this.c45176(0);
         return true;
      } else if (GuiScreen.isKeyComboCtrlC(var2)) {
         GuiScreen.setClipboardString(this.c77864());
         return true;
      } else if (GuiScreen.isKeyComboCtrlV(var2)) {
         if (this.c82534) {
            this.c32979(GuiScreen.getClipboardString());
         }

         return true;
      } else if (GuiScreen.isKeyComboCtrlX(var2)) {
         GuiScreen.setClipboardString(this.c77864());
         if (this.c82534) {
            this.c32979("");
         }

         return true;
      } else {
         switch(var2) {
         case 14:
            if (GuiScreen.isCtrlKeyDown()) {
               if (!this.c82534) {
                  return true;
               }

               this.c49664(-1);
            }

            if (this.c82534) {
               this.c42792(-1);
            }

            return true;
         case 199:
            if (GuiScreen.isShiftKeyDown()) {
               this.c45176(0);
            }

            this.c18404();
            return true;
         case 203:
            if (GuiScreen.isShiftKeyDown()) {
               if (GuiScreen.isCtrlKeyDown()) {
                  this.c45176(this.c43037(-1, this.c26869()));
               }

               this.c45176(this.c26869() - 1);
            }

            if (GuiScreen.isCtrlKeyDown()) {
               this.c12318(this.c31545(-1));
            }

            this.c40946(-1);
            return true;
         case 205:
            if (GuiScreen.isShiftKeyDown()) {
               if (GuiScreen.isCtrlKeyDown()) {
                  this.c45176(this.c43037(1, this.c26869()));
               }

               this.c45176(this.c26869() + 1);
            }

            if (GuiScreen.isCtrlKeyDown()) {
               this.c12318(this.c31545(1));
            }

            this.c40946(1);
            return true;
         case 207:
            if (GuiScreen.isShiftKeyDown()) {
               this.c45176(this.c21086.length());
            }

            this.c66722();
            return true;
         case 211:
            if (this.c82534) {
               this.c42792(1);
            }

            if (GuiScreen.isCtrlKeyDown() && this.c82534) {
               this.c49664(1);
            }

            return true;
         default:
            if (ChatAllowedCharacters.isAllowedCharacter(var1)) {
               if (this.c82534) {
                  this.c32979(Character.toString(var1));
               }

               return true;
            } else {
               return false;
            }
         }
      }
   }

   public void c59167(int var1, int var2, int var3) {
      Module[] var4 = Value.c27574();
      boolean var5 = (float)var1 >= this.c46254 && (float)var1 < this.c46254 + (float)this.c73424 && (float)var2 >= this.c98483 && (float)var2 < this.c98483 + (float)this.c51871;
      if (this.c75165) {
         this.c99993(var5);
      }

      if (this.c64280 && var5 && var3 == 0) {
         int var6 = (int)((float)var1 - this.c46254);
         if (this.c67239) {
            var6 -= 4;
         }

         String var7 = this.c36421.trimStringToWidth(this.c21086.substring(this.c44417), this.c30505());
         this.c12318(this.c36421.trimStringToWidth(var7, var6).length() + this.c44417);
      }

   }

   public void c41720() {
      Module[] var1 = Value.c27574();
      if (this.c95043()) {
         if (this.c20575()) {
            RenderUtilA.c28773((double)(this.c46254 - 1.0F), (double)(this.c98483 - 1.0F), (double)(this.c46254 + (float)this.c73424 + 1.0F), (double)(this.c98483 + (float)this.c51871 + 1.0F), -6250336);
            RenderUtilA.c28773((double)this.c46254, (double)this.c98483, (double)(this.c46254 + (float)this.c73424), (double)(this.c98483 + (float)this.c51871), -16777216);
         }

         int var2 = this.c82534 ? this.c84152 : this.c23099;
         int var3 = this.c31757 - this.c44417;
         int var4 = this.c1701 - this.c44417;
         String var5 = this.c36421.trimStringToWidth(this.c21086.substring(this.c44417), this.c30505());
         boolean var6 = var3 >= 0 && var3 <= var5.length();
         boolean var7 = this.c64280 && this.c16665 / 6 % 2 == 0 && var6;
         int var8 = (int)(this.c67239 ? this.c46254 + 4.0F : this.c46254);
         int var9 = (int)(this.c67239 ? this.c98483 + (float)((this.c51871 - 8) / 2) : this.c98483);
         int var10 = var8;
         if (var4 > var5.length()) {
            var4 = var5.length();
         }

         if (!var5.isEmpty()) {
            String var11 = var5.substring(0, var3);
            var10 = this.c36421.drawStringWithShadow(var11, (float)var8, (float)var9, var2);
         }

         boolean var14 = this.c31757 < this.c21086.length() || this.c21086.length() >= this.c28002();
         int var12 = var10;
         if (!var6) {
            var12 = var3 > 0 ? var8 + this.c73424 : var8;
         }

         if (var14) {
            var12 = var10 - 1;
            --var10;
         }

         if (!var5.isEmpty() && var6 && var3 < var5.length()) {
            this.c36421.drawStringWithShadow(var5.substring(var3), (float)var10, (float)var9, var2);
         }

         if (var7) {
            if (var14) {
               drawRect(var12, var9 - 1, var12 + 1, var9 + 1 + this.c36421.FONT_HEIGHT, -3092272);
            }

            this.c36421.drawStringWithShadow("_", (float)var12, (float)var9, var2);
         }

         if (var4 != var3) {
            int var13 = var8 + this.c36421.getStringWidth(var5.substring(0, var4));
            this.c37578(var12, var9 - 1, var13 - 1, var9 + 1 + this.c36421.FONT_HEIGHT);
         }
      }

   }

   protected void c37578(int var1, int var2, int var3, int var4) {
      Module[] var5 = Value.c27574();
      if (var1 < var3) {
         int var6 = var1;
         var1 = var3;
         var3 = var6;
      }

      if (var2 < var4) {
         int var8 = var2;
         var2 = var4;
         var4 = var8;
      }

      if ((float)var3 > this.c46254 + (float)this.c73424) {
         var3 = (int)(this.c46254 + (float)this.c73424);
      }

      if ((float)var1 > this.c46254 + (float)this.c73424) {
         var1 = (int)(this.c46254 + (float)this.c73424);
      }

      Tessellator var9 = Tessellator.getInstance();
      WorldRenderer var7 = var9.getWorldRenderer();
      GlStateManager.color(0.0F, 0.0F, 255.0F, 255.0F);
      GlStateManager.disableTexture2D();
      GlStateManager.enableColorLogic();
      GlStateManager.colorLogicOp(5387);
      var7.begin(7, DefaultVertexFormats.POSITION);
      var7.pos((double)var1, (double)var4, 0.0D).endVertex();
      var7.pos((double)var3, (double)var4, 0.0D).endVertex();
      var7.pos((double)var3, (double)var2, 0.0D).endVertex();
      var7.pos((double)var1, (double)var2, 0.0D).endVertex();
      var9.draw();
      GlStateManager.disableColorLogic();
      GlStateManager.enableTexture2D();
   }

   public int c28002() {
      return this.c1317;
   }

   public void c49421(int var1) {
      Value.c27574();
      this.c1317 = var1;
      if (this.c21086.length() > var1) {
         this.c21086 = this.c21086.substring(0, var1);
      }

   }

   public int c75770() {
      return this.c31757;
   }

   public void c12318(int var1) {
      this.c31757 = var1;
      int var2 = this.c21086.length();
      this.c31757 = MathHelper.clamp_int(this.c31757, 0, var2);
      this.c45176(this.c31757);
   }

   public boolean c20575() {
      return this.c67239;
   }

   public void c68257(boolean var1) {
      this.c67239 = var1;
   }

   public void c76160(int var1) {
      this.c84152 = var1;
   }

   public void c78677(int var1) {
      this.c23099 = var1;
   }

   public boolean c98807() {
      return this.c64280;
   }

   public void c99993(boolean var1) {
      Module[] var2 = Value.c27574();
      if (!this.c64280) {
         this.c16665 = 0;
      }

      this.c64280 = var1;
   }

   public void c55840(boolean var1) {
      this.c82534 = var1;
   }

   public int c26869() {
      return this.c1701;
   }

   public int c30505() {
      Module[] var1 = Value.c27574();
      return this.c20575() ? this.c73424 - 8 : this.c73424;
   }

   public void c45176(int var1) {
      Value.c27574();
      int var3 = this.c21086.length();
      if (var1 > var3) {
         var1 = var3;
      }

      if (var1 < 0) {
         var1 = 0;
      }

      this.c1701 = var1;
      if (this.c36421 != null) {
         if (this.c44417 > var3) {
            this.c44417 = var3;
         }

         int var4 = this.c30505();
         String var5 = this.c36421.trimStringToWidth(this.c21086.substring(this.c44417), var4);
         int var6 = var5.length() + this.c44417;
         if (var1 == this.c44417) {
            this.c44417 -= this.c36421.trimStringToWidth(this.c21086, var4, true).length();
         }

         if (var1 > var6) {
            this.c44417 += var1 - var6;
         }

         if (var1 <= this.c44417) {
            this.c44417 -= this.c44417 - var1;
         }

         this.c44417 = MathHelper.clamp_int(this.c44417, 0, var3);
      }

   }

   public void c40629(boolean var1) {
      this.c75165 = var1;
   }

   public boolean c95043() {
      return this.c41625;
   }

   public void c16715(boolean var1) {
      this.c41625 = var1;
   }

   public boolean c37932() {
      return this.c82534;
   }

   private static JSONException c79457(JSONException var0) {
      return var0;
   }
}
