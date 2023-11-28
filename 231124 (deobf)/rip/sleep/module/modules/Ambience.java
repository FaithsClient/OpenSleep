package rip.sleep.module.modules;

import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S03PacketTimeUpdate;
import org.json.JSONException;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.PacketReceiveEvent;
import rip.sleep.event.events.Render3DEvent;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.util.MathUtilC;
import rip.sleep.util.TimerUtilG;
import rip.sleep.value.Value;
import rip.sleep.value.values.ModeValue;
import rip.sleep.value.values.NumberValue;

public class Ambience extends Module {
   public ModeValue c26415 = new ModeValue("Mode", new String[]{"Day", "Night", "Custom", "Motion", "Smooth"}, "Motion");
   private final NumberValue<Number> c71610 = new NumberValue<Number>("TimeAmount", () -> {
      return this.c26415.c54460().equalsIgnoreCase("Custom");
   }, Integer.valueOf(13000), Integer.valueOf(0), Integer.valueOf(24000), 10.0D);
   private final NumberValue<Number> c85843 = new NumberValue<Number>("MotionSpeed", () -> {
      return this.c26415.c54460().equalsIgnoreCase("Motion");
   }, Integer.valueOf(10), Integer.valueOf(1), Integer.valueOf(50), 1.0D);
   private final TimerUtilG c28140 = new TimerUtilG();
   private int c71181;
   private int c99290;
   private int c46107;
   private float c81164;

   public Ambience() {
      super("Ambience", new String[]{"Ambience"}, ModuleType.c12482, ModuleType.c21190.c1301);
   }

   public void c83205() {
      this.c71181 = 0;
   }

   public void c71897() {
      mc.theWorld.setWorldTime(mc.theWorld.getWorldTime());
      mc.theWorld.setRainStrength(mc.theWorld.getRainStrength(0.0F));
   }

   @EventTarget
   public void c93300(PacketReceiveEvent var1) {
      Packet var2 = PacketReceiveEvent.getPacket();
      if (var2 instanceof S03PacketTimeUpdate) {
         var1.cancel();
      }

   }

   @EventTarget
   public void c41033(Render3DEvent var1) {
      Module[] var2 = Value.c27574();
      if (this.c28140.c13770(16L)) {
         String var3 = this.c26415.c54460().toLowerCase();
         byte var4 = -1;
         switch(var3.hashCode()) {
         case 99228:
            if (!var3.equals("day")) {
               break;
            }

            var4 = 0;
         case 104817688:
            if (!var3.equals("night")) {
               break;
            }

            var4 = 1;
         case -1349088399:
            if (!var3.equals("custom")) {
               break;
            }

            var4 = 2;
         case -1068318794:
            if (!var3.equals("motion")) {
               break;
            }

            var4 = 3;
         case -898533970:
            if (var3.equals("smooth")) {
               var4 = 4;
            }
         }

         switch(var4) {
         case 0:
            this.c71181 = 4000;
         case 1:
            this.c71181 = 16000;
         case 2:
            this.c71181 = this.c71610.c53968().intValue();
         case 3:
            ++this.c71181;
            if (this.c71181 < 24000) {
               this.c71181 += this.c85843.c53968().intValue();
            }

            if (this.c71181 < 24000) {
               break;
            }

            this.c71181 = 0;
         case 4:
            if (this.c71181 < 3000) {
               this.c99290 = 3000;
               this.c46107 = 1200;
            }

            if (this.c71181 < 9000) {
               this.c99290 = 9000;
               this.c46107 = 500;
            }

            if (this.c71181 < 16000) {
               this.c99290 = 16000;
               this.c46107 = 1200;
            }

            if (this.c71181 < 19000) {
               this.c99290 = 19000;
               this.c46107 = 500;
            }

            if (this.c71181 < 24000) {
               this.c99290 = 24000;
               this.c46107 = 1200;
            }

            if (this.c71181 >= 24000) {
               this.c71181 = 0;
            }

            this.c81164 = MathUtilC.c21701((float)this.c46107, this.c81164, 600.0F);
            this.c71181 = (int) MathUtilC.c21701((float)this.c71181, (float)this.c99290, this.c81164);
         }

         mc.theWorld.setWorldTime((long)this.c71181);
         this.c28140.c43667();
      }

   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }
}
