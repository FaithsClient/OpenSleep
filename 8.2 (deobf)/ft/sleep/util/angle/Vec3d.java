//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.util.angle;

import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3i;

public class Vec3d {
   public static Vec3d poison$ = new Vec3d(Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), Double.longBitsToDouble(0L));
   public double skiing$;
   public double throat$;
   public double hamburg$;

   public Vec3d(double theory, double aging, double var5) {
      if (theory == -0.0D) {
         theory = Double.longBitsToDouble(0L);
      }

      if (aging == -0.0D) {
         aging = Double.longBitsToDouble(0L);
      }

      if (var5 == -0.0D) {
         var5 = Double.longBitsToDouble(0L);
      }

      differ.skiing$ = (double)theory;
      differ.throat$ = (double)aging;
      differ.hamburg$ = var5;
   }

   public Vec3d(Vec3i alulolit) {
      this((double)((Vec3i)alulolit).getX(), (double)((Vec3i)alulolit).getY(), (double)((Vec3i)alulolit).getZ());
   }

   public Vec3d _channels() {
      Object weekends = Math.sqrt(crown.skiing$ * crown.skiing$ + crown.throat$ * crown.throat$ + crown.hamburg$ * crown.hamburg$);
      return weekends < 1.0E-4D ? poison$ : new Vec3d(crown.skiing$ / weekends, crown.throat$ / weekends, crown.hamburg$ / weekends);
   }

   public Vec3d _victor(Vec3d bebucoga) {
      return loganetu._shaved(((Vec3d)bebucoga).skiing$, ((Vec3d)bebucoga).throat$, ((Vec3d)bebucoga).hamburg$);
   }

   public Vec3d _shaved(double pockets, double dryer, double var5) {
      return careful._requests((double)(-pockets), (double)(-dryer), -var5);
   }

   public Vec3d _darwin(Vec3d puppy) {
      return charm._requests(((Vec3d)puppy).skiing$, ((Vec3d)puppy).throat$, ((Vec3d)puppy).hamburg$);
   }

   public Vec3d _requests(double belts, double pickup, double var5) {
      return new Vec3d(somebody.skiing$ + belts, somebody.throat$ + pickup, somebody.hamburg$ + var5);
   }

   public double _reuters(Vec3d mirarude) {
      Object icirafiy = ((Vec3d)mirarude).skiing$ - itovuley.skiing$;
      Object lifupive = ((Vec3d)mirarude).throat$ - itovuley.throat$;
      double var6 = ((Vec3d)mirarude).hamburg$ - itovuley.hamburg$;
      return icirafiy * icirafiy + lifupive * lifupive + var6 * var6;
   }

   public double _printed(double ballet, double crafts, double remind) {
      double var7 = ballet - track.skiing$;
      double var9 = crafts - track.throat$;
      double var11 = remind - track.hamburg$;
      return var7 * var7 + var9 * var9 + var11 * var11;
   }

   public double _stops(Vec3d gobalico) {
      Object avenitus = ((Vec3d)gobalico).skiing$ - ipozilez.skiing$;
      Object iposuciz = ((Vec3d)gobalico).throat$ - ipozilez.throat$;
      double var6 = ((Vec3d)gobalico).hamburg$ - ipozilez.hamburg$;
      return (double)MathHelper.sqrt_double(avenitus * avenitus + iposuciz * iposuciz + var6 * var6);
   }

   public net.minecraft.util.Vec3 _danger(double uvofuyig) {
      return new net.minecraft.util.Vec3(cogaroda.skiing$ * uvofuyig, cogaroda.throat$ * uvofuyig, cogaroda.hamburg$ * uvofuyig);
   }

   public boolean equals(Object kenneth) {
      if (rapidly == kenneth) {
         return true;
      } else if (!(kenneth instanceof Vec3d)) {
         return false;
      } else {
         Object affects = (Vec3d)kenneth;
         return Double.compare(affects.skiing$, rapidly.skiing$) == 0 && Double.compare(affects.throat$, rapidly.throat$) == 0 && Double.compare(affects.hamburg$, rapidly.hamburg$) == 0;
      }
   }

   public int hashCode() {
      Object odatarim = Double.doubleToLongBits(iboluleg.skiing$);
      int var3 = (int)(odatarim ^ odatarim >>> 32);
      odatarim = Double.doubleToLongBits(iboluleg.throat$);
      var3 = 31 * var3 + (int)(odatarim ^ odatarim >>> 32);
      odatarim = Double.doubleToLongBits(iboluleg.hamburg$);
      var3 = 31 * var3 + (int)(odatarim ^ odatarim >>> 32);
      return var3;
   }

   public String toString() {
      return "(" + height.skiing$ + ", " + height.throat$ + ", " + height.hamburg$ + ")";
   }
}
