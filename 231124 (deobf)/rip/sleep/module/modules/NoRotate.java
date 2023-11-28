package rip.sleep.module.modules;

import java.awt.Color;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C03PacketPlayer.C06PacketPlayerPosLook;
import org.json.JSONException;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.PacketDispatchEvent;
import rip.sleep.event.events.RotateEvent;
import rip.sleep.module.Module;
import rip.sleep.value.Value;
import rip.sleep.module.ModuleType;

public class NoRotate extends Module {
   private float c6733;
   private float c79465;
   private boolean c16706;

   public NoRotate() {
      super("No Rotate", new String[]{"NoRotate"}, ModuleType.c31770, ModuleType.c21190.c55384);
      this.c36162((new Color(241, 175, 67)).getRGB());
   }

   @EventTarget
   private void c74013(RotateEvent var1) {
      this.c6733 = var1.c74012();
      this.c79465 = var1.c86825();
      var1.c6297(mc.thePlayer.rotationYaw);
      var1.c78602(mc.thePlayer.rotationPitch);
      this.c16706 = true;
   }

   @EventTarget
   private void c796(PacketDispatchEvent var1) {
      Value.c27574();
      Packet var3 = var1.c81894();
      if (var1.c94537() == PacketDispatchEvent.c23173.c81278 && this.c16706 && var3 instanceof C06PacketPlayerPosLook) {
         C06PacketPlayerPosLook var4 = (C06PacketPlayerPosLook)var3;
         var4.field_149476_e = this.c6733;
         var4.field_149473_f = this.c79465;
         var1.c48559(var4);
         this.c16706 = false;
      }

   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }
}
