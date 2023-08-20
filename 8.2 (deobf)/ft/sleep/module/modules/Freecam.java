//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import com.mojang.authlib.GameProfile;
import ft.sleep.api.EventHandler;
import ft.sleep.api.events.misc.EventCollideWithBlock;
import ft.sleep.api.events.world.EventMove;
import ft.sleep.api.events.world.EventPacketSend;
import ft.sleep.api.events.world.EventPreUpdate;
import java.awt.Color;
import java.util.UUID;

import ft.sleep.module.Module;
import ft.sleep.module.ModuleType;
import ft.sleep.util.player.PlayerUtil;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.network.play.client.C03PacketPlayer;

public class Freecam extends Module {
   public EntityOtherPlayerMP behind$;

   public Freecam() {
      super("ft.sleep.module.modules.Freecam", new String[]{"ft.sleep.module.modules.Freecam"}, ModuleType.Player);
      bidodera._piece((new Color(221, 214, 51)).getRGB());
   }

   public void _regime() {
      if (eyavutid.mc.thePlayer != null) {
         eyavutid.behind$ = new EntityOtherPlayerMP(eyavutid.mc.theWorld, new GameProfile(new UUID((long)-652655310 ^ -652655241L, (long)-1297812406 ^ -1297812438L), "XDDD"));
         eyavutid.behind$.inventory = eyavutid.mc.thePlayer.inventory;
         eyavutid.behind$.inventoryContainer = eyavutid.mc.thePlayer.inventoryContainer;
         eyavutid.behind$.setPositionAndRotation(eyavutid.mc.thePlayer.posX, eyavutid.mc.thePlayer.posY, eyavutid.mc.thePlayer.posZ, eyavutid.mc.thePlayer.rotationYaw, eyavutid.mc.thePlayer.rotationPitch);
         eyavutid.behind$.rotationYawHead = eyavutid.mc.thePlayer.rotationYawHead;
         eyavutid.mc.theWorld.addEntityToWorld(eyavutid.behind$.getEntityId(), eyavutid.behind$);
         eyavutid.mc.renderGlobal.loadRenderers();
         super._regime();
      }
   }

   @EventHandler
   public void _tapes(EventPreUpdate var1) {
      handle.mc.thePlayer.motionY = handle.mc.gameSettings.keyBindJump.isKeyDown() ? 2.0D : (handle.mc.gameSettings.keyBindSneak.isKeyDown() ? -2.0D : Double.longBitsToDouble(0L));
   }

   @EventHandler
   public void _routines(EventPacketSend intro) {
      if (EventPacketSend.getPacket() instanceof C03PacketPlayer) {
         ((EventPacketSend)intro).setCancelled(true);
      }

   }

   @EventHandler
   public void _routine(EventMove var1) {
      nuyarupa.mc.thePlayer.noClip = true;
      PlayerUtil._opera(PlayerUtil._democrat() * 6.0D);
   }

   @EventHandler
   public void _pulled(EventCollideWithBlock utugedil) {
      ((EventCollideWithBlock)utugedil).setCancelled(true);
   }

   public void _discs() {
      dozamuvu.mc.thePlayer.setPositionAndRotation(dozamuvu.behind$.posX, dozamuvu.behind$.posY, dozamuvu.behind$.posZ, dozamuvu.behind$.rotationYaw, dozamuvu.behind$.rotationPitch);
      dozamuvu.mc.theWorld.removeEntityFromWorld(dozamuvu.behind$.getEntityId());
      dozamuvu.mc.renderGlobal.loadRenderers();
      dozamuvu.mc.thePlayer.noClip = false;
   }
}
