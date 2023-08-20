//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import net.minecraft.client.Minecraft;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3i;
import net.minecraft.util.EnumFacing.AxisDirection;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;

public class Scaffold3 {
   public net.minecraft.util.Vec3 homes$;
   public BlockPos learning$;
   public EnumFacing immune$;

   public Scaffold3(BlockPos utebogav, EnumFacing namovela) {
      vemobimu.learning$ = (BlockPos)utebogav;
      vemobimu.immune$ = (EnumFacing)namovela;
      Object abufeyat = ((EnumFacing)namovela).getDirectionVec();
      vemobimu.homes$ = (new net.minecraft.util.Vec3((Vec3i)utebogav)).addVector(0.5D, 0.5D, 0.5D).add(new net.minecraft.util.Vec3((double)abufeyat.getX() * 0.5D, (double)abufeyat.getY() * 0.5D, (double)abufeyat.getZ() * 0.5D));
   }

   public net.minecraft.util.Vec3 _manually() {
      Object vuridome = gagifage.immune$.getDirectionVec();
      Object fecanebo = (double)vuridome.getX() * 0.5D;
      Object idizebam = (double)vuridome.getZ() * 0.5D;
      if (gagifage.immune$.getAxisDirection() == AxisDirection.NEGATIVE) {
         fecanebo = -fecanebo;
         idizebam = -idizebam;
      }

      Object ogidomoc = (new net.minecraft.util.Vec3(gagifage.learning$)).addVector(fecanebo + idizebam, (double)vuridome.getY() * 0.5D, fecanebo + idizebam);
      net.minecraft.util.Vec3 var7 = Minecraft.getMinecraft().thePlayer.getPositionEyes(1.0F);
      MovingObjectPosition var8 = Minecraft.getMinecraft().theWorld.rayTraceBlocks(var7, ogidomoc, false, false, true);
      if (var8 != null && var8.hitVec != null && var8.typeOfHit == MovingObjectType.BLOCK) {
         if (gagifage.immune$ != EnumFacing.DOWN && gagifage.immune$ != EnumFacing.UP) {
            var8.hitVec = var8.hitVec.addVector(Double.longBitsToDouble(0L), -0.2D, Double.longBitsToDouble(0L));
         }

         return var8.hitVec;
      } else {
         return null;
      }
   }

   public net.minecraft.util.Vec3 _concert() {
      return rurigula.homes$;
   }

   public void _ranked(net.minecraft.util.Vec3 agovepal) {
      acubivoc.homes$ = (net.minecraft.util.Vec3)agovepal;
   }

   public BlockPos _train() {
      return aseyemal.learning$;
   }

   public EnumFacing _happen() {
      return bozuyote.immune$;
   }

   public static BlockPos _viking(Scaffold3 mefegipi) {
      return ((Scaffold3)mefegipi).learning$;
   }

   public static EnumFacing _narrow(Scaffold3 ufopadaf) {
      return ((Scaffold3)ufopadaf).immune$;
   }
}
