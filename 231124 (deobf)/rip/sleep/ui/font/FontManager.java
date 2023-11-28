package rip.sleep.ui.font;

import java.awt.Font;
import java.io.InputStream;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

public abstract class FontManager {
   public static FontRendererB c78217 = new FontRendererB(c93855(10), true, true);
   public static FontRendererB c60037 = new FontRendererB(c93855(18), true, true);
   public static FontRendererB c38324 = new FontRendererB(c93855(28), true, true);
   public static FontRendererB c63562 = new FontRendererB(c7227(16), true, true);
   public static FontRendererB c73795 = new FontRendererB(c7227(17), true, true);
   public static FontRendererB c89396 = new FontRendererB(c7227(18), true, true);
   public static FontRendererB c17724 = new FontRendererB(c7227(19), true, true);
   public static FontRendererB c93224 = new FontRendererB(c7227(20), true, true);
   public static FontRendererB c9311 = new FontRendererB(c7227(21), true, true);
   public static FontRendererB c21665 = new FontRendererB(c7227(22), true, true);
   public static FontRendererB c21309 = new FontRendererB(c7227(23), true, true);
   public static FontRendererB c10012 = new FontRendererB(c7227(24), true, true);
   public static FontRendererB c46837 = new FontRendererB(c69378(16), true, true);
   public static FontRendererB c65763 = new FontRendererB(c69378(17), true, true);
   public static FontRendererB c28664 = new FontRendererB(c69378(18), true, true);
   public static FontRendererB c15065 = new FontRendererB(c69378(19), true, true);
   public static FontRendererB c37948 = new FontRendererB(c69378(20), true, true);
   public static FontRendererB c317 = new FontRendererB(c69378(21), true, true);
   public static FontRendererB c4911 = new FontRendererB(c69378(22), true, true);
   public static FontRendererB c67803 = new FontRendererB(c69378(23), true, true);
   public static FontRendererB c15267 = new FontRendererB(c69378(24), true, true);
   public static FontRendererB c44442 = new FontRendererB(c10228(16), true, true);
   public static FontRendererB c60325 = new FontRendererB(c10228(17), true, true);
   public static FontRendererB c59902 = new FontRendererB(c10228(18), true, true);
   public static FontRendererB c73931 = new FontRendererB(c10228(19), true, true);
   public static FontRendererB c47231 = new FontRendererB(c10228(20), true, true);
   public static FontRendererB c56243 = new FontRendererB(c10228(21), true, true);
   public static FontRendererB c87696 = new FontRendererB(c10228(22), true, true);
   public static FontRendererB c18779 = new FontRendererB(c10228(23), true, true);
   public static FontRendererB c86753 = new FontRendererB(c10228(24), true, true);
   public static FontRendererB c95719 = new FontRendererB(c53545(9), true, true);
   public static FontRendererB c32567 = new FontRendererB(c53545(10), true, true);
   public static FontRendererB c74342 = new FontRendererB(c53545(11), true, true);
   public static FontRendererB c10736 = new FontRendererB(c53545(12), true, true);
   public static FontRendererB c51059 = new FontRendererB(c53545(13), true, true);
   public static FontRendererB c43464 = new FontRendererB(c53545(14), true, true);
   public static FontRendererB c28966 = new FontRendererB(c53545(16), true, true);
   public static FontRendererB c54334 = new FontRendererB(c53545(17), true, true);
   public static FontRendererB c2780 = new FontRendererB(c53545(18), true, true);
   public static FontRendererB c70503 = new FontRendererB(c53545(19), true, true);
   public static FontRendererB c61869 = new FontRendererB(c53545(20), true, true);
   public static FontRendererB c40838 = new FontRendererB(c53545(21), true, true);
   public static FontRendererB c28796 = new FontRendererB(c53545(23), true, true);
   public static FontRendererB c62616 = new FontRendererB(c53545(22), true, true);
   public static FontRendererB c53460 = new FontRendererB(c53545(24), true, true);
   public static FontRendererB c37683 = new FontRendererB(c53545(26), true, true);
   public static FontRendererB c12100 = new FontRendererB(c53545(28), true, true);
   public static FontRendererB c43958 = new FontRendererB(c23006(16), true, true);

   public static FontRendererB c45586 = new FontRendererB(c23006(35), true, true);
   public static FontRendererB c18993 = new FontRendererB(c10543(18), true, true);
   public static FontRendererB c49214 = new FontRendererB(c10543(36), true, true);
   public static FontRendererB c14651 = new FontRendererB(c10543(38), true, true);
   public static FontRendererB c98185 = new FontRendererB(c91522(9), false, false);
   public static FontRendererB c50882 = new FontRendererB(c91522(11), false, false);
   public static FontRendererB c58773 = new FontRendererB(c91522(13), true, true);
   public static FontRendererB c39896 = new FontRendererB(c91522(14), true, true);
   public static FontRendererB c14643 = new FontRendererB(c91522(16), true, true);
   public static FontRendererB c3535 = new FontRendererB(c91522(18), true, true);
   public static FontRendererB c92692 = new FontRendererB(c91522(17), true, true);
   public static FontRendererB c57999 = new FontRendererB(c91522(19), true, true);
   public static FontRendererB c92118 = new FontRendererB(c91522(21), true, true);
   public static FontRendererB c196 = new FontRendererB(c91522(22), true, true);
   public static FontRendererB c88095 = new FontRendererB(c91522(24), true, true);
   public static FontRendererB c71933 = new FontRendererB(c91522(23), true, true);
   public static FontRendererB c75252 = new FontRendererB(c91522(20), true, true);
   public static FontRendererB c38081 = new FontRendererB(c48270(8), true, true);
   public static FontRendererB c82496 = new FontRendererB(c48270(9), true, true);
   public static FontRendererB c65905 = new FontRendererB(c48270(10), true, true);
   public static FontRendererB c53569 = new FontRendererB(c48270(11), false, false);
   public static FontRendererB c36752 = new FontRendererB(c48270(12), true, true);
   public static FontRendererB c48288 = new FontRendererB(c48270(13), true, true);
   public static FontRendererB c64931 = new FontRendererB(c48270(14), true, true);
   public static FontRendererB c26685 = new FontRendererB(c48270(16), true, true);
   public static FontRendererB c2407 = new FontRendererB(c48270(17), true, true);
   public static FontRendererB c11121 = new FontRendererB(c48270(18), true, true);
   public static FontRendererB c23571 = new FontRendererB(c48270(19), true, true);
   public static FontRendererB c35003 = new FontRendererB(c48270(20), true, true);
   public static FontRendererB c79020 = new FontRendererB(c48270(21), true, true);
   public static FontRendererB c37419 = new FontRendererB(c48270(22), true, true);
   public static FontRendererB c39433 = new FontRendererB(c48270(23), true, true);
   public static FontRendererB c13658 = new FontRendererB(c48270(24), true, true);
   public static FontRendererB c75016 = new FontRendererB(c48270(30), true, true);
   public static FontRendererB c64420 = new FontRendererB(c48270(35), true, true);
   public static FontRendererB c3111 = new FontRendererB(c65856(35), true, true);
   public static FontRendererB c11477 = new FontRendererB(c8592(12), true, true);
   public static FontRendererB c64284 = new FontRendererB(c8592(14), true, true);
   public static FontRendererB c27293 = new FontRendererB(c8592(15), true, true);
   public static FontRendererB c27296 = new FontRendererB(c8592(16), true, true);
   public static FontRendererB c55508 = new FontRendererB(c8592(17), true, true);
   public static FontRendererB c17232 = new FontRendererB(c8592(18), true, true);
   public static FontRendererB c57450 = new FontRendererB(c8592(19), true, true);
   public static FontRendererB c95778 = new FontRendererB(c8592(20), true, true);
   public static FontRendererB c44915 = new FontRendererB(c8592(21), true, true);
   public static FontRendererB c28504 = new FontRendererB(c8592(22), true, true);
   public static FontRendererB c83050 = new FontRendererB(c8592(23), true, true);
   public static FontRendererB c23063 = new FontRendererB(c8592(24), true, true);
   public static FontRendererB c62700 = new FontRendererB(c8592(50), true, true);
   public static FontRendererB c84287 = new FontRendererB(c33167(15), true, true);
   public static FontRendererB c16578 = new FontRendererB(c44794(11), true, true);
   public static FontRendererB c18826 = new FontRendererB(c44794(14), true, true);
   public static FontRendererB c94176 = new FontRendererB(c44794(16), true, true);
   public static FontRendererB c2405 = new FontRendererB(c44794(17), true, true);
   public static FontRendererB c5274 = new FontRendererB(c44794(18), true, true);
   public static FontRendererB c46848 = new FontRendererB(c44794(19), true, true);
   public static FontRendererB c26446 = new FontRendererB(c44794(20), true, true);
   public static FontRendererB c10904 = new FontRendererB(c44794(21), true, true);
   public static FontRendererB c8623 = new FontRendererB(c44794(22), true, true);
   public static FontRendererB c61479 = new FontRendererB(c44794(23), true, true);
   public static FontRendererB c50065 = new FontRendererB(c44794(24), true, true);
   public static FontRendererB c30189 = new FontRendererB(c4704(16), true, true);
   public static FontRendererB c68373 = new FontRendererB(c4704(17), true, true);
   public static FontRendererB c3113 = new FontRendererB(c4704(18), true, true);
   public static FontRendererB c95413 = new FontRendererB(c4704(19), true, true);
   public static FontRendererB c47687 = new FontRendererB(c4704(20), true, true);
   public static FontRendererB c85360 = new FontRendererB(c4704(21), true, true);
   public static FontRendererB c65553 = new FontRendererB(c4704(22), true, true);
   public static FontRendererB c64753 = new FontRendererB(c4704(23), true, true);
   public static FontRendererB c9729 = new FontRendererB(c4704(24), true, true);

   private static Font c33167(int var0) {
      Font var1;
      try {
         InputStream var2 = Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation("sleep/ICONS.ttf")).getInputStream();
         var1 = Font.createFont(0, var2);
         var1 = var1.deriveFont(0, (float)var0);
      } catch (Exception var3) {
         var3.printStackTrace();
         System.out.println("Error loading font");
         var1 = new Font("default", 0, var0);
      }

      return var1;
   }

   private static Font c7227(int var0) {
      Font var1;
      try {
         InputStream var2 = Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation("sleep/3.ttf")).getInputStream();
         var1 = Font.createFont(0, var2);
         var1 = var1.deriveFont(0, (float)var0);
      } catch (Exception var3) {
         var3.printStackTrace();
         System.out.println("Error loading font");
         var1 = new Font("default", 0, var0);
      }

      return var1;
   }

   private static Font c44794(int var0) {
      Font var1;
      try {
         InputStream var2 = Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation("sleep/Lato-Bold.ttf")).getInputStream();
         var1 = Font.createFont(0, var2);
         var1 = var1.deriveFont(0, (float)var0);
      } catch (Exception var3) {
         var3.printStackTrace();
         System.out.println("Error loading font");
         var1 = new Font("default", 0, var0);
      }

      return var1;
   }

   private static Font c69378(int var0) {
      Font var1;
      try {
         InputStream var2 = Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation("sleep/proxima.ttf")).getInputStream();
         var1 = Font.createFont(0, var2);
         var1 = var1.deriveFont(0, (float)var0);
      } catch (Exception var3) {
         var3.printStackTrace();
         System.out.println("Error loading font");
         var1 = new Font("default", 0, var0);
      }

      return var1;
   }

   private static Font c4704(int var0) {
      Font var1;
      try {
         InputStream var2 = Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation("sleep/Zenith.ttf")).getInputStream();
         var1 = Font.createFont(0, var2);
         var1 = var1.deriveFont(0, (float)var0);
      } catch (Exception var3) {
         var3.printStackTrace();
         System.out.println("Error loading font");
         var1 = new Font("default", 0, var0);
      }

      return var1;
   }

   private static Font c8592(int var0) {
      Font var1;
      try {
         InputStream var2 = Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation("sleep/SF.ttf")).getInputStream();
         var1 = Font.createFont(0, var2);
         var1 = var1.deriveFont(0, (float)var0);
      } catch (Exception var3) {
         var3.printStackTrace();
         System.out.println("Error loading font");
         var1 = new Font("default", 0, var0);
      }

      return var1;
   }

   private static Font c65856(int var0) {
      Font var1;
      try {
         InputStream var2 = Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation("sleep/ICON.ttf")).getInputStream();
         var1 = Font.createFont(0, var2);
         var1 = var1.deriveFont(0, (float)var0);
      } catch (Exception var3) {
         var3.printStackTrace();
         System.out.println("Error loading font");
         var1 = new Font("default", 0, var0);
      }

      return var1;
   }

   private static Font c91522(int var0) {
      Font var1;
      try {
         InputStream var2 = Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation("sleep/Tahoma.ttf")).getInputStream();
         var1 = Font.createFont(0, var2);
         var1 = var1.deriveFont(0, (float)var0);
      } catch (Exception var3) {
         var3.printStackTrace();
         System.out.println("Error loading font");
         var1 = new Font("default", 0, var0);
      }

      return var1;
   }

   private static Font c48270(int var0) {
      Font var1;
      try {
         InputStream var2 = Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation("sleep/TahomaBold.ttf")).getInputStream();
         var1 = Font.createFont(0, var2);
         var1 = var1.deriveFont(0, (float)var0);
      } catch (Exception var3) {
         var3.printStackTrace();
         System.out.println("Error loading font");
         var1 = new Font("default", 0, var0);
      }

      return var1;
   }

   private static Font c23006(int var0) {
      Font var1;
      try {
         InputStream var2 = Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation("sleep/check.ttf")).getInputStream();
         var1 = Font.createFont(0, var2);
         var1 = var1.deriveFont(0, (float)var0);
      } catch (Exception var3) {
         var3.printStackTrace();
         System.out.println("Error loading font");
         var1 = new Font("default", 0, var0);
      }

      return var1;
   }

   private static Font c10543(int var0) {
      Font var1;
      try {
         InputStream var2 = Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation("sleep/NovICON.ttf")).getInputStream();
         var1 = Font.createFont(0, var2);
         var1 = var1.deriveFont(0, (float)var0);
      } catch (Exception var3) {
         var3.printStackTrace();
         System.out.println("Error loading font");
         var1 = new Font("default", 0, var0);
      }

      return var1;
   }

   private static Font c93855(int var0) {
      Font var1;
      try {
         InputStream var2 = Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation("sleep/other.ttf")).getInputStream();
         var1 = Font.createFont(0, var2);
         var1 = var1.deriveFont(0, (float)var0);
      } catch (Exception var3) {
         var3.printStackTrace();
         System.out.println("Error loading font");
         var1 = new Font("default", 0, var0);
      }

      return var1;
   }

   private static Font c10228(int var0) {
      Font var1;
      try {
         InputStream var2 = Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation("sleep/1.ttf")).getInputStream();
         var1 = Font.createFont(0, var2);
         var1 = var1.deriveFont(0, (float)var0);
      } catch (Exception var3) {
         var3.printStackTrace();
         System.out.println("Error loading font");
         var1 = new Font("default", 0, var0);
      }

      return var1;
   }

   private static Font c53545(int var0) {
      Font var1;
      try {
         InputStream var2 = Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation("sleep/raleway.ttf")).getInputStream();
         var1 = Font.createFont(0, var2);
         var1 = var1.deriveFont(0, (float)var0);
      } catch (Exception var3) {
         var3.printStackTrace();
         System.out.println("Error loading font");
         var1 = new Font("default", 0, var0);
      }

      return var1;
   }
}
