//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.injection.mixins;

import ft.sleep.api.EventBus;
import ft.sleep.api.events.world.PlayerTeleportEvent;
import ft.sleep.injection.interfaces.INetHandlerPlayClient;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.PacketThreadUtil;
import net.minecraft.network.play.client.C03PacketPlayer.C06PacketPlayerPosLook;
import net.minecraft.network.play.server.S08PacketPlayerPosLook;
import net.minecraft.network.play.server.S27PacketExplosion;
import net.minecraft.network.play.server.S08PacketPlayerPosLook.EnumFlags;
import net.minecraft.world.Explosion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin({NetHandlerPlayClient.class})
public abstract class MixinNetHandlerPlayClient implements INetHandlerPlayClient {
   @Shadow
   private boolean doneLoadingTerrain;
   @Shadow
   private NetworkManager netManager;
   @Shadow
   private Minecraft gameController;

   public boolean getDoneLoadingTerrain() {
      return this.doneLoadingTerrain;
   }

   @Overwrite
   public void handleExplosion(S27PacketExplosion packetIn) {
      PacketThreadUtil.checkThreadAndEnqueue(packetIn, (NetHandlerPlayClient)this, this.gameController);
      Explosion explosion = new Explosion(this.gameController.theWorld, (Entity)null, packetIn.getX(), packetIn.getY(), packetIn.getZ(), packetIn.getStrength(), packetIn.getAffectedBlockPositions());
      explosion.doExplosionB(true);
      this.gameController.thePlayer.motionX += (double)packetIn.func_149149_c();
      this.gameController.thePlayer.motionY += (double)packetIn.func_149144_d();
      this.gameController.thePlayer.motionZ += (double)packetIn.func_149147_e();
      if (packetIn.func_149149_c() != 0.0F && packetIn.func_149144_d() != 0.0F && packetIn.func_149147_e() != 0.0F) {
         �?.�?();
         if (.�?(.class).�?()) {
            this.gameController.thePlayer.ticksExisted = 0;
         }
      }

   }

   @Overwrite
   public void handlePlayerPosLook(S08PacketPlayerPosLook packetIn) {
      PacketThreadUtil.checkThreadAndEnqueue(packetIn, (NetHandlerPlayClient)this, this.gameController);
      EntityPlayer entityplayer = this.gameController.thePlayer;
      double d0 = packetIn.getX();
      double d1 = packetIn.getY();
      double d2 = packetIn.getZ();
      float f = packetIn.getYaw();
      float f1 = packetIn.getPitch();
      PlayerTeleportEvent event = new PlayerTeleportEvent(new C06PacketPlayerPosLook(entityplayer.posX, entityplayer.posY, entityplayer.posZ, entityplayer.rotationYaw, entityplayer.rotationPitch, false), d0, d1, d2, f, f1);
      EventBus.getInstance().call(event);
      if (!event.isCancelled()) {
         d0 = event.getPosX();
         d1 = event.getPosY();
         d2 = event.getPosZ();
         f = event.getYaw();
         f1 = event.getPitch();
         if (packetIn.func_179834_f().contains(EnumFlags.X)) {
            d0 += entityplayer.posX;
         } else {
            entityplayer.motionX = 0.0D;
         }

         if (packetIn.func_179834_f().contains(EnumFlags.Y)) {
            d1 += entityplayer.posY;
         } else {
            entityplayer.motionY = 0.0D;
         }

         if (packetIn.func_179834_f().contains(EnumFlags.Z)) {
            d2 += entityplayer.posZ;
         } else {
            entityplayer.motionZ = 0.0D;
         }

         if (packetIn.func_179834_f().contains(EnumFlags.X_ROT)) {
            f1 += entityplayer.rotationPitch;
         }

         if (packetIn.func_179834_f().contains(EnumFlags.Y_ROT)) {
            f += entityplayer.rotationYaw;
         }

         entityplayer.setPositionAndRotation(d0, d1, d2, f, f1);
         this.netManager.sendPacket(new C06PacketPlayerPosLook(entityplayer.posX, entityplayer.getEntityBoundingBox().minY, entityplayer.posZ, entityplayer.rotationYaw, entityplayer.rotationPitch, false));
         if (!this.doneLoadingTerrain) {
            this.gameController.thePlayer.prevPosX = this.gameController.thePlayer.posX;
            this.gameController.thePlayer.prevPosY = this.gameController.thePlayer.posY;
            this.gameController.thePlayer.prevPosZ = this.gameController.thePlayer.posZ;
            this.doneLoadingTerrain = true;
            this.gameController.displayGuiScreen((GuiScreen)null);
         }

      }
   }
}
