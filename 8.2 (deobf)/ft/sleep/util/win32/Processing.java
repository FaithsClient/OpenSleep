//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.util.win32;

import java.util.ArrayList;
import java.util.Collections;

import ft.sleep.util.block.BlockUtil;
import ft.sleep.util.patch.PathFinding;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockPos;

public class Processing {
   public ArrayList theater$ = new ArrayList();
   public ArrayList solved$ = new ArrayList();

   public ArrayList _miller(PathFinding becusiva) {
      Object enepebup = new ArrayList();
      Object fizuracu = ((PathFinding)becusiva)._locator();
      Object aluzecod = ((PathFinding)becusiva)._locator();
      fizuracu = fizuracu.add(1, 1, 1);
      fizuracu = fizuracu.add(0.8D, 0.8D, 0.8D);
      fizuracu = fizuracu.add(0.6D, 0.6D, 0.6D);
      fizuracu = fizuracu.add(0.4D, 0.4D, 0.4D);
      fizuracu = fizuracu.add(0.2D, 0.2D, 0.2D);
      fizuracu = fizuracu.add(0, 0, 0);
      aluzecod = aluzecod.add(0, 0, 0);
      aluzecod = aluzecod.add(-1, -1, -1);
      aluzecod = aluzecod.add(-2, -2, -2);
      aluzecod = aluzecod.add(-3, -3, -3);
      enepebup.add(enosovir._budget(fizuracu.up()));
      enepebup.add(enosovir._budget(fizuracu.down()));
      enepebup.add(enosovir._budget(fizuracu.east()));
      enepebup.add(enosovir._budget(fizuracu.west()));
      enepebup.add(enosovir._budget(fizuracu.north()));
      enepebup.add(enosovir._budget(fizuracu.south()));

      for(Object alumopud : BlockPos.getAllInBox(fizuracu, aluzecod)) {
         if (!alumopud.equals(((PathFinding)becusiva)._locator()) && (alumopud.getX() <= ((PathFinding)becusiva)._locator().getX() || alumopud.getZ() <= ((PathFinding)becusiva)._locator().getZ()) && (alumopud.getX() >= ((PathFinding)becusiva)._locator().getX() || alumopud.getZ() >= ((PathFinding)becusiva)._locator().getZ()) && (alumopud.getX() >= ((PathFinding)becusiva)._locator().getX() || alumopud.getZ() <= ((PathFinding)becusiva)._locator().getZ()) && (alumopud.getX() <= ((PathFinding)becusiva)._locator().getX() || alumopud.getZ() >= ((PathFinding)becusiva)._locator().getZ())) {
            enepebup.add(enosovir._budget(alumopud));
         }
      }

      return enepebup;
   }

   public void _campaign(BlockPos deledeza, BlockPos mabuteto) {
      Object fibeduyu = enugubad._budget((BlockPos)deledeza);
      Object gogufogi = enugubad._budget((BlockPos)mabuteto);
      Object yolofopo = new ArrayList();
      Object tacabibu = new ArrayList();
      yolofopo.clear();
      yolofopo.add(fibeduyu);
      Object oliyalen = false;

      while(yolofopo.size() > 0) {
         Object ozopayoy = (PathFinding)yolofopo.get(0);
         Object vezocani = 100000.0D;

         for(Object rutoruni = 1; rutoruni < yolofopo.size(); ++rutoruni) {
            double var12 = ((PathFinding)yolofopo.get(rutoruni))._knife(ozopayoy, gogufogi);
            if (var12 < vezocani) {
               vezocani = var12;
               ozopayoy = (PathFinding)yolofopo.get(rutoruni);
            }
         }

         yolofopo.clear();
         yolofopo.remove(ozopayoy);
         tacabibu.add(ozopayoy);
         enugubad.solved$.add(ozopayoy);
         if (ozopayoy._locator().equals(gogufogi._locator())) {
            gogufogi.whatever$ = ozopayoy;
            enugubad._treasury(fibeduyu, gogufogi);
            return;
         }

         for(PathFinding var13 : enugubad._miller(ozopayoy)) {
            if (var13._bouquet() && !enugubad._recently(var13, tacabibu) && (ozopayoy._gasoline(gogufogi) >= var13._gasoline(gogufogi) || !enugubad._recently(var13, yolofopo))) {
               var13.whatever$ = ozopayoy;
               if (!enugubad._recently(var13, yolofopo)) {
                  yolofopo.add(var13);
               }
            }
         }
      }

   }

   public boolean _recently(PathFinding notices, ArrayList cyber) {
      for(Object modular : cyber) {
         if (modular._locator().equals(((PathFinding)notices)._locator())) {
            return true;
         }
      }

      return false;
   }

   public void _treasury(PathFinding robegori, PathFinding ufayedod) {
      Object ezapilov = new ArrayList();

      for(Object olozoday = (PathFinding)ufayedod; !olozoday.equals(robegori); olozoday = olozoday.whatever$) {
         ezapilov.add(olozoday);
      }

      Collections.reverse(ezapilov);
      fedobelu.theater$ = ezapilov;
   }

   public PathFinding _budget(BlockPos gofulove) {
      return new PathFinding(BlockUtil._anywhere((BlockPos)gofulove).getMaterial() == Material.air && BlockUtil._anywhere(((BlockPos)gofulove).up()).getMaterial() == Material.air && BlockUtil._anywhere(((BlockPos)gofulove).up()).getMaterial() == Material.air, (BlockPos)gofulove);
   }
}
