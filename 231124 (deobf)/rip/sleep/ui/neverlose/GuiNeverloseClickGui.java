package rip.sleep.ui.neverlose;

import Sleep.native0;
import com.mojang.realmsclient.gui.ChatFormatting;
import java.awt.Color;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.imageio.ImageIO;
import rip.sleep.injection.MixinLoader;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import rip.sleep.Sleep;
import rip.sleep.interfaces.IFontRenderer;
import rip.sleep.interfaces.IFontManager;
import rip.sleep.module.ModuleType;
import rip.sleep.module.modules.HUD;
import rip.sleep.ui.notification.Notification;
import rip.sleep.ui.neverlose.components.PanelComponent;
import rip.sleep.ui.neverlose.components.UserInfoComponent;
import rip.sleep.ui.renderer.ModuleTypeRendererC;
import rip.sleep.struct.AnimationState;
import rip.sleep.util.AnimationUtilA;
import rip.sleep.util.AnimationUtilB;
import rip.sleep.util.RenderUtilD;
import rip.sleep.util.RenderUtilE;
import rip.sleep.util.ShaderUtilB;
import rip.sleep.value.Value;

@native0
public class GuiNeverloseClickGui extends GuiScreen {
   public int c16525;
   public int c9435;
   public int c28138;
   public int c85407;
   public AnimationUtilA c28403;
   public static Color c34105 = new Color(HUD.c64734.c41161().intValue());
   public ModuleType.c21190 c48514;
   public List<ModuleTypeRendererC> c63731;
   public boolean c95048;
   private int c89484;
   private int c1725;
   private boolean c19880;
   private boolean c26698;
   private boolean c63447;
   private boolean c49609;
   private UserInfoComponent c85375;
   private AnimationUtilA c95980;
   private Framebuffer c81728;

   public boolean doesGuiPauseGame() {
      return false;
   }

   public GuiNeverloseClickGui() {
      Value.c27574();
      super();
      this.c48514 = null;
      this.c63731 = new ArrayList();
      this.c95048 = true;
      this.c49609 = true;
      this.c95980 = new AnimationUtilB(400, 1.0D, AnimationState.Backward);
      this.c81728 = new Framebuffer(1, 1, false);
      this.c16525 = 100;
      this.c9435 = 100;
      this.c28138 = 430;
      this.c85407 = 300;
      int var2 = 0;
      int var3 = 0;
      ModuleType[] var4 = ModuleType.values();
      int var5 = var4.length;
      int var6 = 0;
      if (var6 < var5) {
         ModuleType var7 = var4[var6];
         this.c63731.add(new ModuleTypeRendererC(var7, var3 + var2 + 40));
         ModuleType.c21190[] var8 = var7.c42698();
         int var9 = var8.length;
         int var10 = 0;
         if (var10 < var9) {
            ModuleType.c21190 var10000 = var8[var10];
            var3 = var3 + 17;
            ++var10;
         }

         var2 = var2 + 14;
         ++var6;
      }

      this.c85375 = new UserInfoComponent();
      if (this.c49609) {
         try {
            Minecraft.getMinecraft().getTextureManager().loadTexture(new ResourceLocation("nb"), new DynamicTexture(ImageIO.read(new URL("https://q.qlogo.cn/headimg_dl?dst_uin=" + MixinLoader.Client_UserQQ + "&spec=100"))));
            this.c49609 = false;
         } catch (IOException var12) {
            throw new RuntimeException(var12);
         }
      }

   }

   public void initGui() {
      super.initGui();
      this.c28403 = new AnimationUtilB(300, 0.6D, AnimationState.Forward);
   }

   public void drawScreen(int var1, int var2, float var3) {
      Value.c27574();
      GL11.glPushMatrix();
      if (this.c95048 && !this.c63731.isEmpty()) {
         this.c48514 = ((PanelComponent)((ModuleTypeRendererC)this.c63731.get(0)).c37197.get(0)).c94267;
         this.c95048 = false;
      }

      if (this.c19880) {
         this.c16525 = this.c89484 + var1;
         this.c9435 = this.c1725 + var2;
      }

      ShaderUtilB.c25830((float)this.c16525, (float)this.c9435, (float)this.c28138, (float)this.c85407, 4.0F, this.c85375.c69684 ? new Color(255, 255, 255, 230) : new Color(15, 15, 15, 40));
      Sleep var10000 = Sleep.INSTANCE;
      if (!Sleep.c43802.c45529()) {
         RenderUtilD.c15402((float)this.c16525, (float)(this.c9435 - 2), (float)(this.c28138 + 5), (float)(this.c85407 + 7), 20, new Color(15, 15, 15, 80));
      }

      GL11.glEnable(3042);
      this.mc.getTextureManager().bindTexture(new ResourceLocation("nb"));
      ShaderUtilB.c66564((float)(this.c16525 + 4), (float)(this.c9435 + 274), 20.0F, 20.0F, 10.0F, 1.0F);
      IFontManager.NL_FONT.c41337.c17902.c48462("" + MixinLoader.Client_User, this.c16525 + 29, this.c9435 + 278, this.c85375.c69684 ? (new Color(51, 51, 51)).getRGB() : -1);
      IFontManager.NL_FONT.c16126.c55770.c48462(ChatFormatting.GRAY + "Till: " + ChatFormatting.RESET + (new SimpleDateFormat("dd:MM")).format(new Date()) + " " + (new SimpleDateFormat("HH:mm")).format(new Date()), this.c16525 + 29, this.c9435 + 289, (new Color(HUD.c64734.c41161().intValue())).getRGB());
      if (!this.c85375.c69684) {
         c86887("Neverlose", IFontManager.MUSEO_SANS.c23797.c38140, (float)(this.c16525 + 11), (float)(this.c9435 + 12), -1, (new Color(HUD.c64734.c41161().intValue())).getRGB(), 0.7F);
      }

      IFontManager.MUSEO_SANS.c23797.c38140.c8296("Neverlose", (float)(this.c16525 + 11), (float)(this.c9435 + 12), (new Color(51, 51, 51)).getRGB(), false);
      ShaderUtilB.c25830((float)this.c16525, (float)(this.c9435 + 265), 93.5F, 1.0F, 0.0F, this.c85375.c69684 ? new Color(213, 213, 213) : new Color(15, 15, 15, 80));
      Iterator var5 = this.c63731.iterator();
      if (var5.hasNext()) {
         ModuleTypeRendererC var6 = (ModuleTypeRendererC)var5.next();
         var6.c65548 = this.c16525;
         var6.c49576 = this.c9435;
         var6.c85121 = this.c28138;
         var6.c9167 = this.c85407;
         var6.c16074(var1, var2);
      }

      IFontRenderer var7 = IFontManager.NL_ICON.c59503.c46646;
      float var10002 = (float)((double)(this.c16525 + this.c28138 - 50) + (!this.c63447 && this.c95980.c44256() ? 0.0D : -83.0D * this.c95980.c53286()));
      float var10003 = (float)(this.c9435 + 17);
      int var10004;
      if (this.c26698) {
         var10004 = (new Color(HUD.c64734.c41161().intValue())).getRGB();
      } else {
         Sleep var19 = Sleep.INSTANCE;
         var10004 = Sleep.c43802.c45529() ? (new Color(95, 95, 95)).getRGB() : -1;
      }

      var7.c18223("x", var10002, var10003, var10004);
      var7 = IFontManager.NL_ICON.c42073.c88416;
      int var12 = this.c16525 + this.c28138 - 30;
      int var16 = this.c9435 + 18;
      if (this.c63447) {
         var10004 = (new Color(HUD.c64734.c41161().intValue())).getRGB();
      } else {
         Sleep var21 = Sleep.INSTANCE;
         var10004 = Sleep.c43802.c45529() ? (new Color(95, 95, 95)).getRGB() : -1;
      }

      var7.c48462("j", var12, var16, var10004);
      this.c95980.c96546(this.c63447 ? AnimationState.Forward : AnimationState.Backward);
      if (this.c63447 || !this.c95980.c44256()) {
         float var9 = (float)((double)(this.c16525 + this.c28138 - 30) - 85.0D * this.c95980.c53286());
         float var10001 = (float)(this.c9435 + 12);
         float var13 = (float)(80.0D * this.c95980.c53286());
         int var10005 = (new Color(3, 13, 26, 60)).getRGB();
         Sleep var10007 = Sleep.INSTANCE;
         RenderUtilE.c5737(var9, var10001, var13, 15.0F, 3.0F, var10005, 0.5F, Sleep.c43802.c45529() ? (new Color(95, 95, 95)).getRGB() : (new Color(HUD.c64734.c41161().intValue())).getRGB());
      }

      if (this.c26698) {
         this.c85375.c81897(var1, var2);
      }

      float var10 = (float)(this.c16525 + 105);
      float var11 = (float)this.c9435 + 10.5F;
      Sleep var10006 = Sleep.INSTANCE;
      ShaderUtilB.c35610(var10, var11, 55.0F, 21.0F, 4.0F, 0.1F, Sleep.c43802.c45529() ? new Color(245, 245, 245) : new Color(15, 15, 15, 70), RenderUtilE.c3863((float)(this.c16525 + 105), (float)(this.c9435 + 10), 55.0F, 21.0F, var1, var2) ? new Color(HUD.c64734.c41161().intValue()) : new Color(19, 19, 17, 0));
      var12 = this.c16525 + 128;
      var16 = this.c9435 + 18;
      Sleep var22 = Sleep.INSTANCE;
      IFontManager.NL_FONT.c86571.c16669.c48462("Save", var12, var16, Sleep.c43802.c45529() ? (new Color(18, 18, 19)).getRGB() : -1);
      var12 = this.c16525 + 110;
      var16 = this.c9435 + 19;
      var22 = Sleep.INSTANCE;
      IFontManager.NL_ICON.c42073.c88416.c48462("K", var12, var16, Sleep.c43802.c45529() ? (new Color(18, 18, 19)).getRGB() : -1);
      GL11.glPopMatrix();
      super.drawScreen(var1, var2, var3);
   }

   public static void c86887(String var0, IFontRenderer var1, float var2, float var3, int var4, int var5, float var6) {
      var1.c8296(var0, var2 + var6, var3, var5, false);
      var1.c8296(var0, var2, var3 - var6, var5, false);
      var1.c8296(var0, var2, var3, var4, false);
   }

   protected void mouseClicked(int var1, int var2, int var3) throws IOException {
      Value.c27574();
      this.c63731.forEach((var3x) -> {
         var3x.c81437(var1, var2, var3);
      });
      if (this.c26698) {
         this.c85375.c67641(var1, var2, var3);
      }

      if (var3 == 0) {
         if (RenderUtilE.c3863((float)(this.c16525 + 110), (float)this.c9435, (float)(this.c28138 - 110), (float)(this.c85407 - 260), var1, var2)) {
            this.c89484 = this.c16525 - var1;
            this.c1725 = this.c9435 - var2;
            this.c19880 = true;
         }

         if (RenderUtilE.c3863((float)(this.c16525 + 105), (float)(this.c9435 + 10), 55.0F, 21.0F, var1, var2)) {
            Sleep.INSTANCE.c43557().c63824(Sleep.INSTANCE.c43557().c94512);
            Sleep.INSTANCE.c83083().c43114().add(new Notification("Save Config"));
         }

         if (RenderUtilE.c3863((float)((double)(this.c16525 + this.c28138 - 50) + (!this.c63447 && this.c95980.c44256() ? 0.0D : -83.0D * this.c95980.c53286())), (float)(this.c9435 + 17), (float) IFontManager.NL_ICON.c59503.c46646.c80174("x"), (float) IFontManager.NL_ICON.c59503.c46646.c5397(), var1, var2)) {
            this.c26698 = !this.c26698;
            this.c19880 = false;
            this.c85375.c93412 = this.c16525 + this.c28138 + 20;
            this.c85375.c66084 = this.c9435;
         }

         if (RenderUtilE.c3863((float)(this.c16525 + this.c28138 - 30), (float)(this.c9435 + 18), (float) IFontManager.NL_ICON.c42073.c88416.c80174("j"), (float) IFontManager.NL_ICON.c42073.c88416.c5397(), var1, var2)) {
            this.c63447 = !this.c63447;
            this.c19880 = false;
         }
      }

      super.mouseClicked(var1, var2, var3);
   }

   protected void mouseReleased(int var1, int var2, int var3) {
      Value.c27574();
      this.c63731.forEach((var3x) -> {
         var3x.c21401(var1, var2, var3);
      });
      if (var3 == 0) {
         this.c19880 = false;
      }

      if (this.c26698) {
         this.c85375.c69158(var1, var2, var3);
      }

      super.mouseReleased(var1, var2, var3);
   }

   protected void keyTyped(char var1, int var2) throws IOException {
      this.c63731.forEach((var2x) -> {
         var2x.c5254(var1, var2);
      });
      super.keyTyped(var1, var2);
   }

   public boolean c45529() {
      return this.c85375.c69684;
   }

   private static Exception c21294(Exception var0) {
      return var0;
   }
}
