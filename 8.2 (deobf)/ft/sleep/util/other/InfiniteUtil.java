//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.util.other;

import java.util.ArrayList;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

public class InfiniteUtil {
   public static ArrayList tokyo$ = new ArrayList();
   public static ArrayList burst$ = new ArrayList();
   public static boolean basket$ = false;
   public static boolean yamaha$ = false;
   public static int gregory$ = 15;
   public static double atlanta$ = 7.0D;
   public static boolean regarded$ = false;
   public static double superb$ = 8.0D;
   public static double confirm$ = 10.0D;

   public static boolean _global(Entity evebedol) {
      if (evebedol == null) {
         return false;
      } else {
         if (!tokyo$.isEmpty()) {
            for(Object mitubuvu : tokyo$) {
               if (mitubuvu != null && mitubuvu.isEntityEqual((Entity)evebedol)) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   public static boolean _lookup(Entity fayasobi) {
      if (fayasobi == null) {
         return false;
      } else {
         if (!burst$.isEmpty()) {
            for(Object popebora : burst$) {
               if (popebora != null && popebora.isEntityEqual((Entity)fayasobi)) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   public static boolean _stake() {
      return basket$;
   }

   public static void _excited(boolean ugesogos) {
      basket$ = (boolean)ugesogos;
   }

   public static boolean _united() {
      return yamaha$;
   }

   public static void _miracle(boolean irocanaz) {
      yamaha$ = (boolean)irocanaz;
   }

   public static double _spending() {
      return confirm$;
   }

   public static void _benefits(double edinilay) {
      confirm$ = (double)edinilay;
   }

   public static double _castle() {
      return atlanta$;
   }

   public static void _places(double eritipav) {
      atlanta$ = (double)eritipav;
   }

   public static boolean _mitchell() {
      return regarded$;
   }

   public static int _commands() {
      return gregory$;
   }

   public static void _cruises(int florist) {
      gregory$ = (int)florist;
   }

   public static void _provided(boolean iparulen) {
      regarded$ = (boolean)iparulen;
   }

   public static double _bottles() {
      return superb$;
   }

   public static void _drove(double doctrine) {
      superb$ = (double)doctrine;
   }

   public static double[] _contain(Entity disney) {
      Object toxic = Minecraft.getMinecraft().thePlayer.posX;
      Object durable = Minecraft.getMinecraft().thePlayer.posY + (double)Minecraft.getMinecraft().thePlayer.getEyeHeight();
      Object fathers = Minecraft.getMinecraft().thePlayer.posZ;
      Object headline = ((Entity)disney).posX;
      Object icons = ((Entity)disney).posY + (double)(((Entity)disney).height / 2.0F);
      Object spanish = ((Entity)disney).posZ;
      double var13 = toxic - headline;
      double var15 = durable - icons;
      double var17 = fathers - spanish;
      double var19 = Math.sqrt(Math.pow(var13, 2.0D) + Math.pow(var17, 2.0D));
      double var21 = Math.toDegrees(Math.atan2(var17, var13)) + 90.0D;
      double var23 = Math.toDegrees(Math.atan2(var19, var15));
      return new double[]{var21, 90.0D - var23};
   }

   public static double _fixed(double biyupevo, double var2) {
      return ((biyupevo - var2) % 360.0D + 540.0D) % 360.0D - 180.0D;
   }

   public static EntityLivingBase _october(float tuesday) {
      Object advocacy = null;
      Object human = (float)tuesday;
      Minecraft.getMinecraft();

      for(Object chains : Minecraft.getMinecraft().theWorld.loadedEntityList) {
         Object reaction = null;
         if (_would(chains) && !(chains instanceof EntityPlayerSP)) {
            Minecraft.getMinecraft();
            if (Minecraft.getMinecraft().thePlayer.getDistanceToEntity((Entity)reaction) < human) {
               Minecraft.getMinecraft();
               human = Minecraft.getMinecraft().thePlayer.getDistanceToEntity((Entity)reaction);
               advocacy = reaction;
            }
         }
      }

      return (EntityLivingBase)advocacy;
   }

   public static boolean _would(Object enlarge) {
      return enlarge instanceof EntityLivingBase;
   }
}
