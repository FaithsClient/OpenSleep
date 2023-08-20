//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.util.render;

import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.opengl.GL11;

public class RoundedUtil {
   public Minecraft delight$ = Minecraft.getMinecraft();
   public static ShaderUtil loose$ = new ShaderUtil("roundedRect");
   public static ShaderUtil cache$ = new ShaderUtil("sleep/Shaders/roundRectOutline.frag");
   public static ShaderUtil vector$ = new ShaderUtil("sleep/Shaders/roundRectTextured.frag");
   public static ShaderUtil carroll$ = new ShaderUtil("roundedRectGradient");

   public static void _ticket(float imperial, float realize, float muslims, float accept, float sites, Color tablets) {
      _remote((float)imperial, (float)realize, (float)muslims, (float)accept, (float)sites, false, (Color)tablets);
   }

   public static void _mighty(float reform, float period, float handbook, float milton, float ladies, Color plants) {
      GL11.glEnable(3042);
      GL11.glEnable(2848);
      _ticket((float)reform, (float)period, (float)handbook, (float)milton, (float)ladies, (Color)plants);
      GL11.glScalef(0.5F, 0.5F, 0.5F);
      GL11.glDisable(2848);
      GL11.glDisable(3042);
      GL11.glScalef(2.0F, 2.0F, 2.0F);
   }

   public static void _planned(float diffs, float trips, float endorsed, float union, float giving, Color lincoln, float shelf) {
      _remote((float)(diffs + endorsed - endorsed * shelf), trips + union / 2.0F - union / 2.0F * shelf, (float)(endorsed * shelf), (float)(union * shelf), (float)giving, false, (Color)lincoln);
   }

   public static void _animal(float flashing, float secure, float trainer, float bills, float betting, Color instant, Color claire) {
      _settle((float)flashing, (float)secure, (float)trainer, (float)bills, (float)betting, (Color)instant, (Color)instant, (Color)claire, (Color)claire);
   }

   public static void _titles(float ezezidoy, float doromani, float enodiber, float igiceboy, float bememuzu, Color laroniro, Color tubogubo) {
      _settle((float)ezezidoy, (float)doromani, (float)enodiber, (float)igiceboy, (float)bememuzu, (Color)tubogubo, (Color)laroniro, (Color)tubogubo, (Color)laroniro);
   }

   public static void _settle(float totally, float foreign, float antique, float directly, float swift, Color vehicles, Color survive, Color protect, Color mardi) {
      _virus();
      GlStateManager.enableBlend();
      GlStateManager.blendFunc(770, 771);
      carroll$._folks();
      _ethics((float)totally, (float)foreign, (float)antique, (float)directly, (float)swift, carroll$);
      carroll$._brunei("color1", (float)((Color)vehicles).getRed() / 255.0F, (float)((Color)vehicles).getGreen() / 255.0F, (float)((Color)vehicles).getBlue() / 255.0F, (float)((Color)vehicles).getAlpha() / 255.0F);
      carroll$._brunei("color2", (float)((Color)survive).getRed() / 255.0F, (float)((Color)survive).getGreen() / 255.0F, (float)((Color)survive).getBlue() / 255.0F, (float)((Color)survive).getAlpha() / 255.0F);
      carroll$._brunei("color3", (float)((Color)protect).getRed() / 255.0F, (float)((Color)protect).getGreen() / 255.0F, (float)((Color)protect).getBlue() / 255.0F, (float)((Color)protect).getAlpha() / 255.0F);
      carroll$._brunei("color4", (float)((Color)mardi).getRed() / 255.0F, (float)((Color)mardi).getGreen() / 255.0F, (float)((Color)mardi).getBlue() / 255.0F, (float)((Color)mardi).getAlpha() / 255.0F);
      ShaderUtil._involved(totally - 1.0F, foreign - 1.0F, antique + 2.0F, directly + 2.0F);
      carroll$._consist();
      GlStateManager.disableBlend();
   }

   public static void _virus() {
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public static void _remote(float maker, float nurse, float hungary, float previews, float diameter, boolean cashiers, Color picks) {
      _virus();
      GlStateManager.enableBlend();
      GlStateManager.blendFunc(770, 771);
      loose$._folks();
      _ethics((float)maker, (float)nurse, (float)hungary, (float)previews, (float)diameter, loose$);
      loose$._fraser("blur", cashiers ? 1 : 0);
      loose$._brunei("color", (float)((Color)picks).getRed() / 255.0F, (float)((Color)picks).getGreen() / 255.0F, (float)((Color)picks).getBlue() / 255.0F, (float)((Color)picks).getAlpha() / 255.0F);
      ShaderUtil._involved(maker - 1.0F, nurse - 1.0F, hungary + 2.0F, previews + 2.0F);
      loose$._consist();
      GlStateManager.disableBlend();
   }

   public static void _monitor(float rentals, float ashley, float files, Color ensuring) {
      _virus();
      GlStateManager.enableBlend();
      GlStateManager.blendFunc(770, 771);
      loose$._folks();
      _ethics((float)rentals, (float)ashley, (float)files, (float)files, files / 2.0F - 0.25F, loose$);
      loose$._brunei("color", (float)((Color)ensuring).getRed() / 255.0F, (float)((Color)ensuring).getGreen() / 255.0F, (float)((Color)ensuring).getBlue() / 255.0F, (float)((Color)ensuring).getAlpha() / 255.0F);
      ShaderUtil._involved(rentals - 1.0F, ashley - 1.0F, files + 2.0F, files + 2.0F);
      loose$._consist();
      GlStateManager.disableBlend();
   }

   public static void _resorts(float analyst, float drawing, float beast, float mileage, float folder, float century, Color tables, Color hispanic) {
      _virus();
      GlStateManager.enableBlend();
      GlStateManager.blendFunc(770, 771);
      cache$._folks();
      Object quilt = new ScaledResolution(Minecraft.getMinecraft());
      _ethics((float)analyst, (float)drawing, (float)beast, (float)mileage, (float)folder, cache$);
      cache$._brunei("outlineThickness", century * (float)quilt.getScaleFactor());
      cache$._brunei("color", (float)((Color)tables).getRed() / 255.0F, (float)((Color)tables).getGreen() / 255.0F, (float)((Color)tables).getBlue() / 255.0F, (float)((Color)tables).getAlpha() / 255.0F);
      cache$._brunei("outlineColor", (float)((Color)hispanic).getRed() / 255.0F, (float)((Color)hispanic).getGreen() / 255.0F, (float)((Color)hispanic).getBlue() / 255.0F, (float)((Color)hispanic).getAlpha() / 255.0F);
      ShaderUtil._involved(analyst - (2.0F + century), drawing - (2.0F + century), beast + 4.0F + century * 2.0F, mileage + 4.0F + century * 2.0F);
      cache$._consist();
      GlStateManager.disableBlend();
   }

   public static void _machines(float celicege, float etanenub, float anedasof, float zaselofu, float uzubanul, float olicedac) {
      _virus();
      vector$._folks();
      vector$._fraser("textureIn", 0);
      _ethics((float)celicege, (float)etanenub, (float)anedasof, (float)zaselofu, (float)uzubanul, vector$);
      vector$._brunei("alpha", (float)olicedac);
      ShaderUtil._involved(celicege - 1.0F, etanenub - 1.0F, anedasof + 2.0F, zaselofu + 2.0F);
      vector$._consist();
      GlStateManager.disableBlend();
   }

   public static void _ethics(float nucedace, float imivuyab, float onuvigab, float zesigiri, float imarimaf, ShaderUtil zutagaga) {
      Object veyoyefu = new ScaledResolution(Minecraft.getMinecraft());
      ((ShaderUtil)zutagaga)._brunei("location", nucedace * (float)veyoyefu.getScaleFactor(), (float)Minecraft.getMinecraft().displayHeight - zesigiri * (float)veyoyefu.getScaleFactor() - imivuyab * (float)veyoyefu.getScaleFactor());
      ((ShaderUtil)zutagaga)._brunei("rectSize", onuvigab * (float)veyoyefu.getScaleFactor(), zesigiri * (float)veyoyefu.getScaleFactor());
      ((ShaderUtil)zutagaga)._brunei("radius", imarimaf * (float)veyoyefu.getScaleFactor());
   }

   public static void _tanks(float eteyatop, float epeyucer, float agenonib, float cayovugo, float bidozeca, Color obizeful, Color vapinude) {
      Object ebidelir = ColorUtil._impaired((Color)obizeful, (Color)vapinude, 0.5F);
      _settle((float)eteyatop, (float)epeyucer, (float)agenonib, (float)cayovugo, (float)bidozeca, ebidelir, (Color)obizeful, (Color)vapinude, ebidelir);
   }

   public static void _tested(float nupemato, float irigamac, float cazidomi, float fovubibe, float imedadur, Color azopoteg, Color rozimire) {
      Object mebavate = ColorUtil._impaired((Color)rozimire, (Color)azopoteg, 0.5F);
      _settle((float)nupemato, (float)irigamac, (float)cazidomi, (float)fovubibe, (float)imedadur, (Color)azopoteg, mebavate, mebavate, (Color)rozimire);
   }
}
