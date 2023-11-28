package rip.sleep.module.modules;

import com.mojang.authlib.GameProfile;
import java.awt.Color;
import java.util.UUID;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.util.AxisAlignedBB;
import org.json.JSONException;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.EventCollideWithBlock;
import rip.sleep.event.events.MotionUpdateEvent;
import rip.sleep.event.events.MoveEvent;
import rip.sleep.event.events.PacketSendEvent;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.util.PlayerUtilD;
import rip.sleep.value.Value;
import rip.sleep.value.values.NumberValue;

public class Freecam extends Module {
   private EntityOtherPlayerMP c26602;
   public NumberValue<Number> c8907 = new NumberValue<Number>("Fly Speed", 3.0D, 0.0D, 6.0D, 0.1D);

   public Freecam() {
      super("Freecam", new String[]{"Freecam"}, ModuleType.c31770, ModuleType.c21190.c76367);
      this.c36162((new Color(221, 214, 51)).getRGB());
   }

   public void c83205() {
      Module[] var1 = Value.c27574();
      if (mc.thePlayer != null) {
         this.c26602 = new EntityOtherPlayerMP(mc.theWorld, new GameProfile(new UUID(69L, 96L), String.valueOf("Free Cam")));
         this.c26602.field_71071_by = mc.thePlayer.inventory;
         this.c26602.field_71069_bz = mc.thePlayer.inventoryContainer;
         this.c26602.setPositionAndRotation(mc.thePlayer.posX, mc.thePlayer.posY, mc.thePlayer.posZ, mc.thePlayer.rotationYaw, mc.thePlayer.rotationPitch);
         this.c26602.rotationYawHead = mc.thePlayer.rotationYawHead;
         mc.theWorld.addEntityToWorld(this.c26602.getEntityId(), this.c26602);
         mc.renderGlobal.loadRenderers();
         super.c83205();
      }
   }

   @EventTarget
   private void c24741(MotionUpdateEvent var1) {
      Module[] var2 = Value.c27574();
      mc.thePlayer.motionY = mc.gameSettings.keyBindJump.isKeyDown() ? 2.0D : (mc.gameSettings.keyBindSneak.isKeyDown() ? -2.0D : 0.0D);
   }

   @EventTarget
   private void c72864(PacketSendEvent var1) {
      Module[] var2 = Value.c27574();
      if (PacketSendEvent.c81894() instanceof C03PacketPlayer) {
         var1.c8253(true);
      }

   }

   @EventTarget
   private void c28198(MoveEvent var1) {
      mc.thePlayer.noClip = true;
      PlayerUtilD.c38080(PlayerUtilD.c34428() * this.c8907.c53968().doubleValue());
   }

   @EventTarget
   private void c21814(EventCollideWithBlock var1) {
      var1.c8664((AxisAlignedBB)null);
   }

   public void c71897() {
      mc.thePlayer.setPositionAndRotation(this.c26602.posX, this.c26602.posY, this.c26602.posZ, this.c26602.rotationYaw, this.c26602.rotationPitch);
      mc.theWorld.removeEntityFromWorld(this.c26602.getEntityId());
      mc.renderGlobal.loadRenderers();
      mc.thePlayer.noClip = false;
   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }
}
