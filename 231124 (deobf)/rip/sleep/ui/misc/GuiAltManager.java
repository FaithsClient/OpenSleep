package rip.sleep.ui.misc;

import com.mojang.util.UUIDTypeAdapter;
import java.awt.Color;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiLabel;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Session;
import org.lwjgl.Sys;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import rip.sleep.Sleep;
import rip.sleep.account.LegacyAccount;
import rip.sleep.account.MicrosoftAccount;
import rip.sleep.interfaces.IAccount;
import rip.sleep.module.Module;
import rip.sleep.module.modules.HUD;
import rip.sleep.struct.AnimationState;
import rip.sleep.ui.element.Element;
import rip.sleep.ui.element.elements.ButtonA;
import rip.sleep.ui.element.elements.ButtonB;
import rip.sleep.ui.element.elements.LoginButton;
import rip.sleep.ui.notification.NotificationTypeA;
import rip.sleep.ui.font.FontManager;
import rip.sleep.ui.renderer.AccountRenderer;
import rip.sleep.unmap.*;
import rip.sleep.util.*;
import rip.sleep.value.Value;

public class GuiAltManager extends GuiScreen {
   private Minecraft c65117 = Minecraft.getMinecraft();
   private float c82545 = Float.MAX_VALUE;
   private float c76669 = 0.0F;
   private float c84417;
   private AnimationUtilA c1143 = new AnimationUtilC(0, 0.0D, AnimationState.Backward);
   private float c74277;
   public int c27410 = 65;
   public int c50329 = 70;
   public int c61354 = 0;
   private boolean c71869;
   private boolean c95026;
   private boolean c50279;
   private Element c33581;
   private ButtonB c82350;
   public boolean c98068;
   public boolean c43275;
   public boolean c77813;
   public ArrayList<NotificationTypeA> c38330 = new ArrayList();
   private String c52398;
   long c84589;

   public GuiAltManager() {
      Sleep.INSTANCE.c43557().c2789(Sleep.INSTANCE.c43557().c93071);
   }

   public void initGui() {
      ScaledResolution var1 = new ScaledResolution(this.c65117);
      this.buttonList.add(new LoginButton(1, (int)((float)this.c27410 * 1.3F), var1.getScaledHeight() - 50, 10, 10, "Login"));
      this.buttonList.add(new LoginButton(2, (int)((float)this.c27410 * 1.3F) + 110 + 5, var1.getScaledHeight() - 50, 10, 10, "Remove"));
      this.buttonList.add(new LoginButton(3, (int)((float)this.c27410 * 1.3F) + 235 + 5, var1.getScaledHeight() - 50, 10, 10, "Add Alt"));
      this.buttonList.add(new LoginButton(4, (int)((float)this.c27410 * 1.3F) + 360 + 10, var1.getScaledHeight() - 50, 10, 10, "Direct Login"));
      this.buttonList.add(new LoginButton(5, (int)((float)this.c27410 * 1.3F) + 510 + 10, var1.getScaledHeight() - 50, 10, 10, "Microsoft Login", new ResourceLocation("sleep/alts/microsoft.png")));
      this.buttonList.add(new LoginButton(6, (int)((float)this.c27410 * 1.3F) + 695 + 15, var1.getScaledHeight() - 50, 10, 10, "Cancel"));
      this.c33581 = new ButtonA(1, this.c65117.fontRendererObj, var1.getScaledWidth() / 2 - 65, var1.getScaledHeight() / 2 - 86, 150, 20, "");
      this.c82350 = new ButtonB(2, this.c65117.fontRendererObj, var1.getScaledWidth() / 2 - 65, var1.getScaledHeight() / 2 - 35 - 13, 150, 20, "");
      super.initGui();
   }

   protected void actionPerformed(GuiButton var1) throws IOException {
      Module[] var2 = Value.c27574();
      if (!this.c71869 && !this.c95026) {
         if (var1.id == 1 && this.c88759() != null) {
            this.c81100();
         }

         if (var1.id == 2) {
            if (this.c88759() != null) {
               this.c38330.add(new NotificationTypeA("Remove Alt | name : " + this.c88759().c13273.name(), "J", this.c38330.size()));
            }

            Sleep.INSTANCE.c43557().c93071.c30252(this.c88759());
         }

         if (var1.id == 3) {
            this.c71869 = true;
         }

         if (var1.id == 4) {
            this.c95026 = true;
         }

         if (var1.id == 6) {
            this.c65117.displayGuiScreen((GuiScreen)null);
         }

         if (var1.id == 5) {
            this.c65117.displayGuiScreen(new GuiLoginScreen(this, "Microsoft Login", (var0) -> {
               MicrosoftAccount var1 = (MicrosoftAccount)var0;
               Sleep.INSTANCE.c43557().c93071.c98074(var1.name(), var1.c75634(), var1.c35335(), var1.c97270());
            }));
         }

      }
   }

   private void c58502(String var1) {
      try {
         Desktop.getDesktop().browse(new URI(var1));
      } catch (Throwable var3) {
         Sys.openURL(var1);
      }

   }

   public void updateScreen() {
      super.updateScreen();
   }

   public void drawScreen(int var1, int var2, float var3) {
      Module[] var4 = Value.c27574();
      if (Sleep.INSTANCE.c43557().c93071.c35592.size() != Sleep.INSTANCE.c43557().c93071.c57149.size()) {
         IASShared.c95173.warn("Bug size");
      }

      this.c5476();
      ScaledResolution var5 = new ScaledResolution(this.c65117);
      this.drawBackground(0);
      FontManager.c64420.c59386("S" + EnumChatFormatting.WHITE + "leep", 10.0F, 10.0F, HUD.c64734.c41161().intValue());
      ShaderUtilB.c25830((float)(var5.getScaledWidth() - 80), (float)(this.c50329 - 59), (float)(FontManager.c37419.c65036("Buy Tools") + 10), 20.0F, 1.0F, new Color(0, 0, 0, 100));
      FontManager.c37419.c59386("Buy Tools", (float)(var5.getScaledWidth() - 75), (float)(this.c50329 - 54), -1);
      GL11.glPushMatrix();
      RenderUtilA.c4799((double)this.c27410, (double)this.c50329, 825.0D, 320.0D);
      GL11.glEnable(3089);
      double var6 = (double)this.c35214();

      for(AccountRenderer var9 : Sleep.INSTANCE.c43557().c93071.c35592) {
         if (!this.c71869) {
            if (this.c95026) {
               ;
            }

            var9.c47548(var1, var2);
            var9.c96090 = (int) MathUtilB.c11525(var6);
            break;
         }
      }

      this.c7920(120, var1, var2);
      this.c82545 = (float)Math.max(0, Sleep.INSTANCE.c43557().c93071.c35592.size() < 4 ? 0 : ((AccountRenderer) Sleep.INSTANCE.c43557().c93071.c35592.get(Sleep.INSTANCE.c43557().c93071.c35592.size() - 1)).c54801() + 2);
      GL11.glDisable(3089);
      GL11.glPopMatrix();
      ShaderUtilB.c7101((float)(this.c27410 - 60), (float)(this.c50329 + 130), 40.0F, 40.0F, 1.0F, true, new Color(0, 0, 0, 100));
      FontManager.c62700.c59386("<", (float)(this.c27410 - 47), (float)(this.c50329 + 140), -1);
      ShaderUtilB.c7101((float)(var5.getScaledWidth() - 50), (float)(this.c50329 + 130), 40.0F, 40.0F, 1.0F, true, new Color(0, 0, 0, 100));
      this.c65117.fontRendererObj.drawString("alts: (" + Sleep.INSTANCE.c43557().c93071.c57149.size() + ").", var5.getScaledWidth() - 42 - this.c65117.fontRendererObj.getStringWidth(Sleep.INSTANCE.c43557().c93071.c57149.size() + ""), this.c50329 + 120, -1);
      FontManager.c62700.c59386(">", (float)(var5.getScaledWidth() - 35), (float)(this.c50329 + 140), -1);
      if (this.c71869 || this.c95026) {
         GL11.glTranslatef(0.0F, 0.0F, 2.0F);
         RenderUtilA.c28773(0.0D, 0.0D, (double)var5.getScaledWidth(), (double)var5.getScaledHeight(), (new Color(0, 0, 0, 90)).getRGB());
         ShaderUtilB.c25830((float)(var5.getScaledWidth() / 2 - 70), (float)(var5.getScaledHeight() / 2 - 140), 170.0F, 220.0F, 1.0F, new Color(0, 0, 0, 120));
         FontManager.c13658.c59386(this.c71869 && !this.c95026 ? "Add Alt" : "Direct Login", (float)(var5.getScaledWidth() / 2 - 65), (float)(var5.getScaledHeight() / 2 - 135), -1);
         FontManager.c37419.c59386("Username / E-Mail", (float)(var5.getScaledWidth() / 2 - 65), (float)(var5.getScaledHeight() / 2 - 100), -1);
         this.c33581.c41720();
         FontManager.c37419.c59386("Password", (float)(var5.getScaledWidth() / 2 - 65), (float)(var5.getScaledHeight() / 2 - 62), -1);
         this.c82350.c41720();
         ShaderUtilB.c25830((float)(var5.getScaledWidth() / 2 - 63), (float)(var5.getScaledHeight() / 2 - 17), 150.0F, 20.0F, 1.0F, new Color(0, 0, 0, 130));
         FontManager.c37419.c59386(this.c71869 && !this.c95026 ? "Add" : "Login", this.c71869 && !this.c95026 ? (float)(var5.getScaledWidth() / 2 + 1) : (float)(var5.getScaledWidth() / 2 - 3), (float)(var5.getScaledHeight() / 2 - 11), -1);
         ShaderUtilB.c25830((float)(var5.getScaledWidth() / 2 - 63), (float)(var5.getScaledHeight() / 2 + 22), 150.0F, 20.0F, 1.0F, new Color(0, 0, 0, 130));
         FontManager.c37419.c59386("Import alt", (float)(var5.getScaledWidth() / 2 - 13), (float)(var5.getScaledHeight() / 2 + 28), -1);
         ShaderUtilB.c25830((float)(var5.getScaledWidth() / 2 - 63), (float)(var5.getScaledHeight() / 2 + 47), 150.0F, 20.0F, 1.0F, new Color(0, 0, 0, 130));
         FontManager.c37419.c59386("Back", (float)(var5.getScaledWidth() / 2 - 2), (float)(var5.getScaledHeight() / 2 + 53), -1);
         GL11.glTranslatef(0.0F, 0.0F, -2.0F);
      }

      this.c33581.c2942("");
      this.c82350.c2942("");
      ShaderUtilB.c25830(100.0F, 5.0F, 180.0F, 55.0F, 0.0F, new Color(0, 0, 0, 100));
      FontManager.c64284.c59386("logs", 104.0F, 8.0F, -1);
      GL11.glPushMatrix();
      RenderUtilA.c4799(100.0D, 5.0D, 180.0D, 55.0D);
      GL11.glEnable(3089);
      Iterator var11 = this.c38330.iterator();
      if (var11.hasNext()) {
         NotificationTypeA var18 = (NotificationTypeA)var11.next();
         var18.c26404();
      }

      GL11.glDisable(3089);
      GL11.glPopMatrix();
      if (this.c38330.size() > 5) {
         this.c38330.remove(this.c38330.get(0));
         int var12 = 0;
         Iterator var19 = this.c38330.iterator();
         if (var19.hasNext()) {
            NotificationTypeA var10 = (NotificationTypeA)var19.next();
            var10.c94372 = var12++;
         }
      }

      int var14 = 0;
      if (var14 < this.buttonList.size()) {
         if (!this.c71869) {
            if (this.c95026) {
               ;
            }

            ((GuiButton)this.buttonList.get(var14)).drawButton(this.c65117, var1, var2);
         }

         ++var14;
      }

      var14 = 0;
      if (var14 < this.labelList.size()) {
         if (!this.c71869) {
            if (this.c95026) {
               ;
            }

            ((GuiLabel)this.labelList.get(var14)).drawLabel(this.c65117, var1, var2);
         }

         ++var14;
      }

   }

   public void c5476() {
      Value.c27574();
      int var2 = 0;
      if (var2 < Sleep.INSTANCE.c43557().c93071.c35592.size()) {
         if (Sleep.INSTANCE.c43557().c93071.c35592.isEmpty()) {
            ;
         }

         ((AccountRenderer) Sleep.INSTANCE.c43557().c93071.c35592.get(var2)).c93133 = var2++;
      }

   }

   public void c7920(int var1, int var2, int var3) {
      Value.c27574();
      this.c74277 = (float)((double)this.c84417 - this.c1143.c53286());
      if (RenderUtilA.c58363((float)this.c27410, (float)this.c50329, 825.0F, 320.0F, var2, var3)) {
         this.c84417 += (float)Mouse.getDWheel() / 4.0F;
      }

      this.c84417 = Math.max(Math.min(this.c76669, this.c84417), -this.c82545);
      this.c1143 = new AnimationUtilC(var1, (double)(this.c84417 - this.c74277), AnimationState.Backward);
   }

   public float c35214() {
      this.c74277 = (float)((double)this.c84417 - this.c1143.c53286());
      return this.c74277;
   }

   protected void mouseClicked(int var1, int var2, int var3) throws IOException {
      Value.c27574();
      ScaledResolution var5 = new ScaledResolution(this.c65117);
      if (this.c71869 || this.c95026) {
         if (RenderUtilA.c58363((float)(var5.getScaledWidth() / 2 - 63), (float)(var5.getScaledHeight() / 2 + 47), 150.0F, 20.0F, var1, var2)) {
            this.c71869 = false;
            this.c95026 = false;
         }

         if (RenderUtilA.c58363((float)(var5.getScaledWidth() / 2 - 63), (float)(var5.getScaledHeight() / 2 + 22), 150.0F, 20.0F, var1, var2)) {
            c82424 var10 = this.c20849();
            return;
         }

         if (RenderUtilA.c58363((float)(var5.getScaledWidth() / 2 - 63), (float)(var5.getScaledHeight() / 2 - 17), 150.0F, 20.0F, var1, var2)) {
            if (!this.c95026) {
               if (this.c82350.c78567().isEmpty()) {
                  Sleep.INSTANCE.c43557().c93071.c45424(this.c33581.c78567());
                  this.c38330.add(new NotificationTypeA("Add Alt | Username: " + this.c33581.c78567() + " - offline", "K", this.c38330.size()));
               }

               Sleep.INSTANCE.c43557().c63824(Sleep.INSTANCE.c43557().c93071);
               this.c71869 = false;
            }

            LegacyAccount var6 = new LegacyAccount(this.c33581.c78567(), c25664.c68686(this.c33581.c78567()));
            var6.c59276((var1x, var2x) -> {
               this.c52398 = String.format(var1x, var2x);
            }).whenComplete((var1x, var2x) -> {
               Value.c27574();
               this.c52398 = null;
               this.c65117.addScheduledTask(() -> {
                  this.c65117.displayGuiScreen(new GuiCancellableScreen(() -> {
                     this.c65117.displayGuiScreen(this);
                  }, EnumChatFormatting.RED + I18n.format("ias.error", new Object[0]), String.valueOf(var2x)));
               });
            });
            Sleep.INSTANCE.c43557().c63824(Sleep.INSTANCE.c43557().c93071);
            this.c95026 = false;
         }

         this.c33581.c59167(var1, var2, var3);
         this.c82350.c59167(var1, var2, var3);
      }

      if (!Sleep.INSTANCE.c43557().c93071.c57149.isEmpty()) {
         if (RenderUtilA.c58363((float)(this.c27410 - 60), (float)(this.c50329 + 130), 40.0F, 40.0F, var1, var2)) {
            Iterator var8 = Sleep.INSTANCE.c43557().c93071.c35592.iterator();
            if (var8.hasNext()) {
               AccountRenderer var7 = (AccountRenderer)var8.next();
               this.c1143 = new AnimationUtilC(120, 35.0D, AnimationState.Backward);
               this.c74277 = (float)((double)this.c74277 - this.c1143.c53286());
            }
         }

         if (RenderUtilA.c58363((float)(var5.getScaledWidth() - 50), (float)(this.c50329 + 130), 40.0F, 40.0F, var1, var2)) {
            Iterator var9 = Sleep.INSTANCE.c43557().c93071.c35592.iterator();
            if (var9.hasNext()) {
               AccountRenderer var11 = (AccountRenderer)var9.next();
               this.c1143 = new AnimationUtilC(120, 35.0D, AnimationState.Backward);
               this.c74277 = (float)((double)this.c74277 + this.c1143.c53286());
            }
         }
      }

      label53: {
         if (Minecraft.getSystemTime() - this.c84589 < 250L) {
            if (this.c88759() == null) {
               break label53;
            }

            if (!this.c88759().c50241(var1, var2)) {
               return;
            }

            this.c81100();
         }

         this.c84178(var1, var2);
      }

      this.c84589 = Minecraft.getSystemTime();
      super.mouseClicked(var1, var2, var3);
   }

   public void c84178(int var1, int var2) {
      Value.c27574();
      Iterator var4 = Sleep.INSTANCE.c43557().c93071.c35592.iterator();
      if (var4.hasNext()) {
         AccountRenderer var5 = (AccountRenderer)var4.next();
         if (var5.c50241(var1, var2)) {
            Iterator var6 = Sleep.INSTANCE.c43557().c93071.c35592.iterator();
            if (var6.hasNext()) {
               AccountRenderer var7 = (AccountRenderer)var6.next();
               var7.c55914(false);
            }

            var5.c55914(true);
         }
      }

   }

   public void c81100() {
      AccountRenderer var1 = this.c88759();
      IAccount var2 = this.c88759().c13273;
      var2.c59276((var1x, var2x) -> {
         this.c52398 = String.format(var1x, var2x);
      }).whenComplete((var2x, var3) -> {
         Value.c27574();
         this.c52398 = null;
         this.c65117.addScheduledTask(() -> {
            this.c65117.displayGuiScreen(new GuiCancellableScreen(() -> {
               this.c65117.displayGuiScreen(this);
            }, EnumChatFormatting.RED + I18n.format("ias.error", new Object[0]), String.valueOf(var3)));
         });
      });
   }

   private c82424 c20849() {
      // $FF: Couldn't be decompiled
   }

   public AccountRenderer c46048(String var1) {
      Value.c27574();
      Iterator var3 = Sleep.INSTANCE.c43557().c93071.c35592.iterator();
      if (var3.hasNext()) {
         AccountRenderer var4 = (AccountRenderer)var3.next();
         if (!var4.c13273.name().equalsIgnoreCase(var1)) {
            ;
         }

         return var4;
      } else {
         return null;
      }
   }

   protected void keyTyped(char var1, int var2) throws IOException {
      this.c33581.c76381(var1, var2);
      Value.c27574();
      this.c82350.c76381(var1, var2);
      if (var2 == 1) {
         if (this.c71869 || this.c95026) {
            this.c71869 = false;
            this.c95026 = false;
         }

         this.c65117.displayGuiScreen((GuiScreen)null);
         Sleep.INSTANCE.c43557().c63824(Sleep.INSTANCE.c43557().c93071);
      }

   }

   public AccountRenderer c88759() {
      return (AccountRenderer) Sleep.INSTANCE.c43557().c93071.c35592.stream().filter(AccountRenderer::c34914).findAny().orElse((Object)null);
   }

   public void onGuiClosed() {
      Sleep.INSTANCE.c43557().c63824(Sleep.INSTANCE.c43557().c93071);
      super.onGuiClosed();
   }

   public void c52333(String var1, String var2) {
      this.c38330.add(new NotificationTypeA(var1, var2, this.c38330.size()));
   }

   public void c29319(boolean var1) {
      this.c43275 = var1;
   }

   public void c73990(boolean var1) {
      this.c98068 = var1;
   }

   public void c59463(boolean var1) {
      this.c77813 = var1;
   }

   // $FF: synthetic method
   private void c30542(IAccount.SessionData var1) {
      this.c65117.session = new Session(var1.name(), UUIDTypeAdapter.fromUUID(var1.c62581()), var1.c84432(), var1.c17308());
   }

   // $FF: synthetic method
   private void c62304(IAccount.SessionData var1) {
      this.c65117.session = new Session(var1.name(), UUIDTypeAdapter.fromUUID(var1.c62581()), var1.c84432(), var1.c17308());
   }

   private static Throwable c36482(Throwable var0) {
      return var0;
   }
}
