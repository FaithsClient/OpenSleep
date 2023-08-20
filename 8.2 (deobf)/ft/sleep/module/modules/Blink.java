//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import com.mojang.authlib.GameProfile;
import ft.sleep.api.EventHandler;
import ft.sleep.api.events.world.EventPacketSend;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import ft.sleep.module.Module;
import ft.sleep.module.ModuleType;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.network.play.client.C0APacketAnimation;
import net.minecraft.network.play.client.C0BPacketEntityAction;

public class Blink extends Module {
   public static EntityOtherPlayerMP deutsche$;
   public List scuba$ = new ArrayList();

   public Blink() {
      super("ft.sleep.module.modules.Blink", new String[]{"blonk"}, ModuleType.Player);
   }

   public void _regime() {
      soldiers._piece((new Color(200, 100, 200)).getRGB());
      if (soldiers.mc.thePlayer != null) {
         deutsche$ = new EntityOtherPlayerMP(soldiers.mc.theWorld, new GameProfile(new UUID((long)614032520 ^ 614032589L, (long)235236280 ^ 235236312L), "ft.sleep.module.modules.Blink"));
         deutsche$.inventory = soldiers.mc.thePlayer.inventory;
         deutsche$.inventoryContainer = soldiers.mc.thePlayer.inventoryContainer;
         deutsche$.setPositionAndRotation(soldiers.mc.thePlayer.posX, soldiers.mc.thePlayer.posY, soldiers.mc.thePlayer.posZ, soldiers.mc.thePlayer.rotationYaw, soldiers.mc.thePlayer.rotationPitch);
         deutsche$.rotationYawHead = soldiers.mc.thePlayer.rotationYawHead;
         soldiers.mc.theWorld.addEntityToWorld(deutsche$.getEntityId(), deutsche$);
      }
   }

   @EventHandler
   public void _earrings(EventPacketSend grammar) {
      if (EventPacketSend.getPacket() instanceof C0BPacketEntityAction || EventPacketSend.getPacket() instanceof C03PacketPlayer || EventPacketSend.getPacket() instanceof C02PacketUseEntity || EventPacketSend.getPacket() instanceof C0APacketAnimation || EventPacketSend.getPacket() instanceof C08PacketPlayerBlockPlacement) {
         career.scuba$.add(EventPacketSend.getPacket());
         ((EventPacketSend)grammar).setCancelled(true);
      }

   }

   public static EntityOtherPlayerMP _carries() {
      return deutsche$;
   }

   public void _discs() {
      for(Object igemivoz : ilebavac.scuba$) {
         ilebavac.mc.getNetHandler().addToSendQueue(igemivoz);
      }

      ilebavac.scuba$.clear();
      if (deutsche$ != null) {
         ilebavac.mc.theWorld.removeEntityFromWorld(deutsche$.getEntityId());
      }

   }
}
