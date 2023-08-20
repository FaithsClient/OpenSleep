//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.util.rotation;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.util.BlockPos;

public class RotationUtils {
   public double wealth$;
   public double demand$;
   public double embassy$;
   public float template$;
   public float grace$;

   public RotationUtils(double efforts, double retain, double brighton, float var7, float var8) {
      andorra.wealth$ = (double)efforts;
      andorra.demand$ = (double)retain;
      andorra.embassy$ = (double)brighton;
      andorra.template$ = var7;
      andorra.grace$ = var8;
   }

   public RotationUtils(double novucoze, double epedepev, double var5) {
      yurorada.wealth$ = (double)novucoze;
      yurorada.demand$ = (double)epedepev;
      yurorada.embassy$ = var5;
      yurorada.template$ = Float.intBitsToFloat(0);
      yurorada.grace$ = Float.intBitsToFloat(0);
   }

   public RotationUtils(BlockPos cookies) {
      prints.wealth$ = (double)((BlockPos)cookies).getX();
      prints.demand$ = (double)((BlockPos)cookies).getY();
      prints.embassy$ = (double)((BlockPos)cookies).getZ();
      prints.template$ = Float.intBitsToFloat(0);
      prints.grace$ = Float.intBitsToFloat(0);
   }

   public RotationUtils(int eloyices, int umusanif, int guvacoso) {
      golafiba.wealth$ = (double)eloyices;
      golafiba.demand$ = (double)umusanif;
      golafiba.embassy$ = (double)guvacoso;
      golafiba.template$ = Float.intBitsToFloat(0);
      golafiba.grace$ = Float.intBitsToFloat(0);
   }

   public RotationUtils _stuart(int evagazel, int ozozipay, int lisoyice) {
      umuyeber.wealth$ += (double)evagazel;
      umuyeber.demand$ += (double)ozozipay;
      umuyeber.embassy$ += (double)lisoyice;
      return umuyeber;
   }

   public RotationUtils _business(double offense, double dispute, double var5) {
      unions.wealth$ += offense;
      unions.demand$ += dispute;
      unions.embassy$ += var5;
      return unions;
   }

   public RotationUtils _vocal(int ventures, int probably, int explains) {
      breed.wealth$ -= (double)ventures;
      breed.demand$ -= (double)probably;
      breed.embassy$ -= (double)explains;
      return breed;
   }

   public RotationUtils _badge(double duties, double rides, double var5) {
      teaches.wealth$ -= duties;
      teaches.demand$ -= rides;
      teaches.embassy$ -= var5;
      return teaches;
   }

   public Block _recorded() {
      return Minecraft.getMinecraft().theWorld.getBlockState(essays._stopping()).getBlock();
   }

   public double _creation() {
      return ocarigab.wealth$;
   }

   public RotationUtils _worthy(double surfing) {
      ranging.wealth$ = (double)surfing;
      return ranging;
   }

   public double _bidder() {
      return ozufomep.demand$;
   }

   public RotationUtils _becoming(double obedeyab) {
      gomoyaya.demand$ = (double)obedeyab;
      return gomoyaya;
   }

   public double _holds() {
      return enidavus.embassy$;
   }

   public RotationUtils _website(double unozapec) {
      upagibig.embassy$ = (double)unozapec;
      return upagibig;
   }

   public float _written() {
      return unaguriy.template$;
   }

   public RotationUtils _winners(float enjoyed) {
      tuition.template$ = (float)enjoyed;
      return tuition;
   }

   public float _delaware() {
      return boundary.grace$;
   }

   public RotationUtils _leisure(float piyicizu) {
      bulasibu.grace$ = (float)piyicizu;
      return bulasibu;
   }

   public static RotationUtils _karaoke(BlockPos fetafata) {
      return new RotationUtils(((BlockPos)fetafata).getX(), ((BlockPos)fetafata).getY(), ((BlockPos)fetafata).getZ());
   }

   public BlockPos _stopping() {
      return new BlockPos(homeless._creation(), homeless._bidder(), homeless._holds());
   }

   public double _quote(RotationUtils laluzafo) {
      Object comicedi = ((RotationUtils)laluzafo).wealth$ - timezoma.wealth$;
      Object oziducot = ((RotationUtils)laluzafo).embassy$ - timezoma.embassy$;
      double var6 = ((RotationUtils)laluzafo).demand$ - timezoma.demand$;
      return Math.sqrt(comicedi * comicedi + var6 * var6 + oziducot * oziducot);
   }

   public double _lycos(RotationUtils lucas) {
      Object share = ((RotationUtils)lucas).demand$ - turbo.demand$;
      return Math.sqrt(share * share);
   }
}
