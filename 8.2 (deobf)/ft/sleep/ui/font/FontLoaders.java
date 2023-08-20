//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.ui.font;

import java.awt.Font;
import java.io.InputStream;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

public abstract class FontLoaders {
   public static CFontRenderer logo10 = new CFontRenderer(getLogo(10), true, true);
   public static CFontRenderer logo18 = new CFontRenderer(getLogo(18), true, true);
   public static CFontRenderer logo28 = new CFontRenderer(getLogo(28), true, true);
   public static CFontRenderer digi16 = new CFontRenderer(getdigi(16), true, true);
   public static CFontRenderer digi17 = new CFontRenderer(getdigi(17), true, true);
   public static CFontRenderer digi18 = new CFontRenderer(getdigi(18), true, true);
   public static CFontRenderer digi19 = new CFontRenderer(getdigi(19), true, true);
   public static CFontRenderer digi20 = new CFontRenderer(getdigi(20), true, true);
   public static CFontRenderer digi21 = new CFontRenderer(getdigi(21), true, true);
   public static CFontRenderer digi22 = new CFontRenderer(getdigi(22), true, true);
   public static CFontRenderer digi23 = new CFontRenderer(getdigi(23), true, true);
   public static CFontRenderer digi24 = new CFontRenderer(getdigi(24), true, true);
   public static CFontRenderer edit16 = new CFontRenderer(getedit(16), true, true);
   public static CFontRenderer edit17 = new CFontRenderer(getedit(17), true, true);
   public static CFontRenderer edit18 = new CFontRenderer(getedit(18), true, true);
   public static CFontRenderer edit19 = new CFontRenderer(getedit(19), true, true);
   public static CFontRenderer edit20 = new CFontRenderer(getedit(20), true, true);
   public static CFontRenderer edit21 = new CFontRenderer(getedit(21), true, true);
   public static CFontRenderer edit22 = new CFontRenderer(getedit(22), true, true);
   public static CFontRenderer edit23 = new CFontRenderer(getedit(23), true, true);
   public static CFontRenderer edit24 = new CFontRenderer(getedit(24), true, true);
   public static CFontRenderer pixel16 = new CFontRenderer(getpixel(16), true, true);
   public static CFontRenderer pixel17 = new CFontRenderer(getpixel(17), true, true);
   public static CFontRenderer pixel18 = new CFontRenderer(getpixel(18), true, true);
   public static CFontRenderer pixel19 = new CFontRenderer(getpixel(19), true, true);
   public static CFontRenderer pixel20 = new CFontRenderer(getpixel(20), true, true);
   public static CFontRenderer pixel21 = new CFontRenderer(getpixel(21), true, true);
   public static CFontRenderer pixel22 = new CFontRenderer(getpixel(22), true, true);
   public static CFontRenderer pixel23 = new CFontRenderer(getpixel(23), true, true);
   public static CFontRenderer pixel24 = new CFontRenderer(getpixel(24), true, true);
   public static CFontRenderer kiona9 = new CFontRenderer(getKiona(9), true, true);
   public static CFontRenderer kiona10 = new CFontRenderer(getKiona(10), true, true);
   public static CFontRenderer kiona11 = new CFontRenderer(getKiona(11), true, true);
   public static CFontRenderer kiona12 = new CFontRenderer(getKiona(12), true, true);
   public static CFontRenderer kiona13 = new CFontRenderer(getKiona(13), true, true);
   public static CFontRenderer kiona14 = new CFontRenderer(getKiona(14), true, true);
   public static CFontRenderer kiona16 = new CFontRenderer(getKiona(16), true, true);
   public static CFontRenderer kiona17 = new CFontRenderer(getKiona(17), true, true);
   public static CFontRenderer kiona18 = new CFontRenderer(getKiona(18), true, true);
   public static CFontRenderer kiona19 = new CFontRenderer(getKiona(19), true, true);
   public static CFontRenderer kiona20 = new CFontRenderer(getKiona(20), true, true);
   public static CFontRenderer kiona21 = new CFontRenderer(getKiona(21), true, true);
   public static CFontRenderer kiona23 = new CFontRenderer(getKiona(23), true, true);
   public static CFontRenderer kiona22 = new CFontRenderer(getKiona(22), true, true);
   public static CFontRenderer kiona24 = new CFontRenderer(getKiona(24), true, true);
   public static CFontRenderer kiona26 = new CFontRenderer(getKiona(26), true, true);
   public static CFontRenderer kiona28 = new CFontRenderer(getKiona(28), true, true);
   public static CFontRenderer logos16 = new CFontRenderer(getLog2go(16), true, true);
   public static CFontRenderer logos35 = new CFontRenderer(getLog2go(35), true, true);
   public static CFontRenderer logog18 = new CFontRenderer(getLoggo(18), true, true);
   public static CFontRenderer logog36 = new CFontRenderer(getLoggo(36), true, true);
   public static CFontRenderer logog38 = new CFontRenderer(getLoggo(38), true, true);
   public static CFontRenderer Tahoma9 = new CFontRenderer(getTahoma(9), false, false);
   public static CFontRenderer Tahoma11 = new CFontRenderer(getTahoma(11), false, false);
   public static CFontRenderer Tahoma13 = new CFontRenderer(getTahoma(13), true, true);
   public static CFontRenderer Tahoma14 = new CFontRenderer(getTahoma(14), true, true);
   public static CFontRenderer Tahoma16 = new CFontRenderer(getTahoma(16), true, true);
   public static CFontRenderer Tahoma18 = new CFontRenderer(getTahoma(18), true, true);
   public static CFontRenderer Tahoma17 = new CFontRenderer(getTahoma(17), true, true);
   public static CFontRenderer Tahoma19 = new CFontRenderer(getTahoma(19), true, true);
   public static CFontRenderer Tahoma21 = new CFontRenderer(getTahoma(21), true, true);
   public static CFontRenderer Tahoma22 = new CFontRenderer(getTahoma(22), true, true);
   public static CFontRenderer Tahoma24 = new CFontRenderer(getTahoma(24), true, true);
   public static CFontRenderer Tahoma23 = new CFontRenderer(getTahoma(23), true, true);
   public static CFontRenderer Tahoma20 = new CFontRenderer(getTahoma(20), true, true);
   public static CFontRenderer TahomaBold8 = new CFontRenderer(getTahomaBold(8), true, true);
   public static CFontRenderer TahomaBold9 = new CFontRenderer(getTahomaBold(9), true, true);
   public static CFontRenderer TahomaBold10 = new CFontRenderer(getTahomaBold(10), true, true);
   public static CFontRenderer TahomaBold11 = new CFontRenderer(getTahomaBold(11), false, false);
   public static CFontRenderer TahomaBold12 = new CFontRenderer(getTahomaBold(12), true, true);
   public static CFontRenderer TahomaBold13 = new CFontRenderer(getTahomaBold(13), true, true);
   public static CFontRenderer TahomaBold14 = new CFontRenderer(getTahomaBold(14), true, true);
   public static CFontRenderer TahomaBold16 = new CFontRenderer(getTahomaBold(16), true, true);
   public static CFontRenderer TahomaBold17 = new CFontRenderer(getTahomaBold(17), true, true);
   public static CFontRenderer TahomaBold18 = new CFontRenderer(getTahomaBold(18), true, true);
   public static CFontRenderer TahomaBold19 = new CFontRenderer(getTahomaBold(19), true, true);
   public static CFontRenderer TahomaBold20 = new CFontRenderer(getTahomaBold(20), true, true);
   public static CFontRenderer TahomaBold21 = new CFontRenderer(getTahomaBold(21), true, true);
   public static CFontRenderer TahomaBold22 = new CFontRenderer(getTahomaBold(22), true, true);
   public static CFontRenderer TahomaBold23 = new CFontRenderer(getTahomaBold(23), true, true);
   public static CFontRenderer TahomaBold24 = new CFontRenderer(getTahomaBold(24), true, true);
   public static CFontRenderer TahomaBold30 = new CFontRenderer(getTahomaBold(30), true, true);
   public static CFontRenderer TahomaBold35 = new CFontRenderer(getTahomaBold(35), true, true);
   public static CFontRenderer icon35 = new CFontRenderer(getExhibition(35), true, true);
   public static CFontRenderer SF12 = new CFontRenderer(getSF(12), true, true);
   public static CFontRenderer SF14 = new CFontRenderer(getSF(14), true, true);
   public static CFontRenderer SF15 = new CFontRenderer(getSF(15), true, true);
   public static CFontRenderer SF16 = new CFontRenderer(getSF(16), true, true);
   public static CFontRenderer SF17 = new CFontRenderer(getSF(17), true, true);
   public static CFontRenderer SF18 = new CFontRenderer(getSF(18), true, true);
   public static CFontRenderer SF19 = new CFontRenderer(getSF(19), true, true);
   public static CFontRenderer SF20 = new CFontRenderer(getSF(20), true, true);
   public static CFontRenderer SF21 = new CFontRenderer(getSF(21), true, true);
   public static CFontRenderer SF22 = new CFontRenderer(getSF(22), true, true);
   public static CFontRenderer SF23 = new CFontRenderer(getSF(23), true, true);
   public static CFontRenderer SF24 = new CFontRenderer(getSF(24), true, true);
   public static CFontRenderer SF50 = new CFontRenderer(getSF(50), true, true);
   public static CFontRenderer ICON15 = new CFontRenderer(ICONFONT(15), true, true);
   public static CFontRenderer clickgui11 = new CFontRenderer(getClickgui(11), true, true);
   public static CFontRenderer clickgui14 = new CFontRenderer(getClickgui(14), true, true);
   public static CFontRenderer clickgui16 = new CFontRenderer(getClickgui(16), true, true);
   public static CFontRenderer clickgui17 = new CFontRenderer(getClickgui(17), true, true);
   public static CFontRenderer clickgui18 = new CFontRenderer(getClickgui(18), true, true);
   public static CFontRenderer clickgui19 = new CFontRenderer(getClickgui(19), true, true);
   public static CFontRenderer clickgui20 = new CFontRenderer(getClickgui(20), true, true);
   public static CFontRenderer clickgui21 = new CFontRenderer(getClickgui(21), true, true);
   public static CFontRenderer clickgui22 = new CFontRenderer(getClickgui(22), true, true);
   public static CFontRenderer clickgui23 = new CFontRenderer(getClickgui(23), true, true);
   public static CFontRenderer clickgui24 = new CFontRenderer(getClickgui(24), true, true);
   public static CFontRenderer Roboto16 = new CFontRenderer(getRoboto(16), true, true);
   public static CFontRenderer Roboto17 = new CFontRenderer(getRoboto(17), true, true);
   public static CFontRenderer Roboto18 = new CFontRenderer(getRoboto(18), true, true);
   public static CFontRenderer Roboto19 = new CFontRenderer(getRoboto(19), true, true);
   public static CFontRenderer Roboto20 = new CFontRenderer(getRoboto(20), true, true);
   public static CFontRenderer Roboto21 = new CFontRenderer(getRoboto(21), true, true);
   public static CFontRenderer Roboto22 = new CFontRenderer(getRoboto(22), true, true);
   public static CFontRenderer Roboto23 = new CFontRenderer(getRoboto(23), true, true);
   public static CFontRenderer Roboto24 = new CFontRenderer(getRoboto(24), true, true);

   private static Font ICONFONT(int size) {
      Font font;
      try {
         InputStream is = Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation("sleep/ICONS.ttf")).getInputStream();
         font = Font.createFont(0, is);
         font = font.deriveFont(0, (float)size);
      } catch (Exception var3) {
         var3.printStackTrace();
         System.out.println("Error loading font");
         font = new Font("default", 0, size);
      }

      return font;
   }

   private static Font getdigi(int size) {
      Font font;
      try {
         InputStream is = Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation("sleep/3.ttf")).getInputStream();
         font = Font.createFont(0, is);
         font = font.deriveFont(0, (float)size);
      } catch (Exception var3) {
         var3.printStackTrace();
         System.out.println("Error loading font");
         font = new Font("default", 0, size);
      }

      return font;
   }

   private static Font getClickgui(int size) {
      Font font;
      try {
         InputStream is = Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation("sleep/Lato-Bold.ttf")).getInputStream();
         font = Font.createFont(0, is);
         font = font.deriveFont(0, (float)size);
      } catch (Exception var3) {
         var3.printStackTrace();
         System.out.println("Error loading font");
         font = new Font("default", 0, size);
      }

      return font;
   }

   private static Font getedit(int size) {
      Font font;
      try {
         InputStream is = Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation("sleep/2.ttf")).getInputStream();
         font = Font.createFont(0, is);
         font = font.deriveFont(0, (float)size);
      } catch (Exception var3) {
         var3.printStackTrace();
         System.out.println("Error loading font");
         font = new Font("default", 0, size);
      }

      return font;
   }

   private static Font getRoboto(int size) {
      Font font;
      try {
         InputStream is = Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation("sleep/Zenith.ttf")).getInputStream();
         font = Font.createFont(0, is);
         font = font.deriveFont(0, (float)size);
      } catch (Exception var3) {
         var3.printStackTrace();
         System.out.println("Error loading font");
         font = new Font("default", 0, size);
      }

      return font;
   }

   private static Font getSF(int size) {
      Font font;
      try {
         InputStream is = Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation("sleep/SF.ttf")).getInputStream();
         font = Font.createFont(0, is);
         font = font.deriveFont(0, (float)size);
      } catch (Exception var3) {
         var3.printStackTrace();
         System.out.println("Error loading font");
         font = new Font("default", 0, size);
      }

      return font;
   }

   private static Font getExhibition(int size) {
      Font font;
      try {
         InputStream is = Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation("sleep/ICON.ttf")).getInputStream();
         font = Font.createFont(0, is);
         font = font.deriveFont(0, (float)size);
      } catch (Exception var3) {
         var3.printStackTrace();
         System.out.println("Error loading font");
         font = new Font("default", 0, size);
      }

      return font;
   }

   private static Font getTahoma(int size) {
      Font font;
      try {
         InputStream is = Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation("sleep/Tahoma.ttf")).getInputStream();
         font = Font.createFont(0, is);
         font = font.deriveFont(0, (float)size);
      } catch (Exception var3) {
         var3.printStackTrace();
         System.out.println("Error loading font");
         font = new Font("default", 0, size);
      }

      return font;
   }

   private static Font getTahomaBold(int size) {
      Font font;
      try {
         InputStream is = Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation("sleep/TahomaBold.ttf")).getInputStream();
         font = Font.createFont(0, is);
         font = font.deriveFont(0, (float)size);
      } catch (Exception var3) {
         var3.printStackTrace();
         System.out.println("Error loading font");
         font = new Font("default", 0, size);
      }

      return font;
   }

   private static Font getLog2go(int size) {
      Font font;
      try {
         InputStream is = Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation("sleep/check.ttf")).getInputStream();
         font = Font.createFont(0, is);
         font = font.deriveFont(0, (float)size);
      } catch (Exception var3) {
         var3.printStackTrace();
         System.out.println("Error loading font");
         font = new Font("default", 0, size);
      }

      return font;
   }

   private static Font getLoggo(int size) {
      Font font;
      try {
         InputStream is = Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation("sleep/NovICON.ttf")).getInputStream();
         font = Font.createFont(0, is);
         font = font.deriveFont(0, (float)size);
      } catch (Exception var3) {
         var3.printStackTrace();
         System.out.println("Error loading font");
         font = new Font("default", 0, size);
      }

      return font;
   }

   private static Font getLogo(int size) {
      Font font;
      try {
         InputStream is = Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation("sleep/other.ttf")).getInputStream();
         font = Font.createFont(0, is);
         font = font.deriveFont(0, (float)size);
      } catch (Exception var3) {
         var3.printStackTrace();
         System.out.println("Error loading font");
         font = new Font("default", 0, size);
      }

      return font;
   }

   private static Font getpixel(int size) {
      Font font;
      try {
         InputStream is = Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation("sleep/1.ttf")).getInputStream();
         font = Font.createFont(0, is);
         font = font.deriveFont(0, (float)size);
      } catch (Exception var3) {
         var3.printStackTrace();
         System.out.println("Error loading font");
         font = new Font("default", 0, size);
      }

      return font;
   }

   private static Font getKiona(int size) {
      Font font;
      try {
         InputStream is = Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation("sleep/raleway.ttf")).getInputStream();
         font = Font.createFont(0, is);
         font = font.deriveFont(0, (float)size);
      } catch (Exception var3) {
         var3.printStackTrace();
         System.out.println("Error loading font");
         font = new Font("default", 0, size);
      }

      return font;
   }
}
