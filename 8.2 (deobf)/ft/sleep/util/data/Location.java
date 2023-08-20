//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.util.data;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.BlockPos;

public class Location {
   public double quarters$;
   public double arnold$;
   public double menus$;
   public float podcasts$;
   public float clubs$;

   public Location(double clusters, double clear, double galaxy, float var7, float var8) {
      brochure.quarters$ = (double)clusters;
      brochure.arnold$ = (double)clear;
      brochure.menus$ = (double)galaxy;
      brochure.podcasts$ = var7;
      brochure.clubs$ = var8;
   }

   public Location(double adalisec, double ipayedin, double var5) {
      elazobup.quarters$ = (double)adalisec;
      elazobup.arnold$ = (double)ipayedin;
      elazobup.menus$ = var5;
      elazobup.podcasts$ = Float.intBitsToFloat(0);
      elazobup.clubs$ = Float.intBitsToFloat(0);
   }

   public Location(BlockPos usucecev) {
      igifupap.quarters$ = (double)((BlockPos)usucecev).getX();
      igifupap.arnold$ = (double)((BlockPos)usucecev).getY();
      igifupap.menus$ = (double)((BlockPos)usucecev).getZ();
      igifupap.podcasts$ = Float.intBitsToFloat(0);
      igifupap.clubs$ = Float.intBitsToFloat(0);
   }

   public Location(int zolevaco, int ugumubeb, int ofonogad) {
      biyiviyi.quarters$ = (double)zolevaco;
      biyiviyi.arnold$ = (double)ugumubeb;
      biyiviyi.menus$ = (double)ofonogad;
      biyiviyi.podcasts$ = Float.intBitsToFloat(0);
      biyiviyi.clubs$ = Float.intBitsToFloat(0);
   }

   public Location(EntityLivingBase ayubulug) {
      divofepe.quarters$ = ((EntityLivingBase)ayubulug).posX;
      divofepe.arnold$ = ((EntityLivingBase)ayubulug).posY;
      divofepe.menus$ = ((EntityLivingBase)ayubulug).posZ;
      divofepe.podcasts$ = Float.intBitsToFloat(0);
      divofepe.clubs$ = Float.intBitsToFloat(0);
   }

   public Location _advert(int seafood, int angle, int location) {
      equity.quarters$ += (double)seafood;
      equity.arnold$ += (double)angle;
      equity.menus$ += (double)location;
      return equity;
   }

   public Location _casino(double rumuyasu, double apocotib, double var5) {
      isevibuv.quarters$ += rumuyasu;
      isevibuv.arnold$ += apocotib;
      isevibuv.menus$ += var5;
      return isevibuv;
   }

   public Location _factory(int tiyozudo, int oterodob, int obafosiy) {
      abanipoz.quarters$ -= (double)tiyozudo;
      abanipoz.arnold$ -= (double)oterodob;
      abanipoz.menus$ -= (double)obafosiy;
      return abanipoz;
   }

   public Location _clark(double dodge, double agrees, double var5) {
      temple.quarters$ -= dodge;
      temple.arnold$ -= agrees;
      temple.menus$ -= var5;
      return temple;
   }

   public Block _buyer() {
      return Minecraft.getMinecraft().theWorld.getBlockState(loads._accuracy()).getBlock();
   }

   public double _civic() {
      return examine.quarters$;
   }

   public Location _wendy(double arimeyaz) {
      efagiliz.quarters$ = (double)arimeyaz;
      return efagiliz;
   }

   public double _universe() {
      return runner.arnold$;
   }

   public Location _hawaiian(double wagner) {
      threats.arnold$ = (double)wagner;
      return threats;
   }

   public double _antigua() {
      return omacosun.menus$;
   }

   public Location _story(double luther) {
      chicks.menus$ = (double)luther;
      return chicks;
   }

   public float _nursing() {
      return igamalim.podcasts$;
   }

   public Location _pursuit(float yuyemeni) {
      lutalupu.podcasts$ = (float)yuyemeni;
      return lutalupu;
   }

   public float _arrow() {
      return masters.clubs$;
   }

   public Location _computed(float jackie) {
      tough.clubs$ = (float)jackie;
      return tough;
   }

   public static Location _reaching(BlockPos marks) {
      return new Location(((BlockPos)marks).getX(), ((BlockPos)marks).getY(), ((BlockPos)marks).getZ());
   }

   public BlockPos _accuracy() {
      return new BlockPos(dirisuri._civic(), dirisuri._universe(), dirisuri._antigua());
   }

   public double _passed(Location tofefafe) {
      Object unevazid = ((Location)tofefafe).quarters$ - ibayuroc.quarters$;
      Object popicucu = ((Location)tofefafe).menus$ - ibayuroc.menus$;
      double var6 = ((Location)tofefafe).arnold$ - ibayuroc.arnold$;
      return Math.sqrt(unevazid * unevazid + var6 * var6 + popicucu * popicucu);
   }

   public double _account(Location pusumegu) {
      Object bazazivu = ((Location)pusumegu).arnold$ - velozide.arnold$;
      return Math.sqrt(bazazivu * bazazivu);
   }
}
