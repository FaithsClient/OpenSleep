package rip.sleep.injection.mixins;

import rip.sleep.event.EventBus;
import rip.sleep.injection.in.INetHandlerPlayClient;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.Entity;
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
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import rip.sleep.module.modules.FBJump;
import rip.sleep.event.events.RotateEvent;
import rip.sleep.Sleep;
import rip.sleep.management.ModuleManager;

@Mixin({NetHandlerPlayClient.class})
public abstract class MixinNetHandlerPlayClient implements INetHandlerPlayClient {
   @Shadow
   private boolean field_147309_h;
   @Shadow
   private NetworkManager field_147302_e;
   @Shadow
   private Minecraft field_147299_f;

   public boolean getDoneLoadingTerrain() {
      return this.field_147309_h;
   }

   @Overwrite
   public void func_147283_a(S27PacketExplosion var1) {
      PacketThreadUtil.checkThreadAndEnqueue(var1, (NetHandlerPlayClient)this, this.field_147299_f);
      Explosion var2 = new Explosion(this.field_147299_f.theWorld, (Entity)null, var1.getX(), var1.getY(), var1.getZ(), var1.getStrength(), var1.getAffectedBlockPositions());
      var2.doExplosionB(true);
      this.field_147299_f.thePlayer.motionX += (double)var1.func_149149_c();
      this.field_147299_f.thePlayer.motionY += (double)var1.func_149144_d();
      this.field_147299_f.thePlayer.motionZ += (double)var1.func_149147_e();
      if (var1.func_149149_c() != 0.0F && var1.func_149144_d() != 0.0F && var1.func_149147_e() != 0.0F) {
         Sleep var10000 = Sleep.INSTANCE;
         Sleep.c33759();
         if (ModuleManager.c25475(FBJump.class).c24622()) {
            this.field_147299_f.thePlayer.ticksExisted = 0;
         }
      }

   }

   @ModifyArg(
      method = {"handleJoinGame", "handleRespawn"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/client/Minecraft;displayGuiScreen(Lnet/minecraft/client/gui/GuiScreen;)V"
)
   )
   private GuiScreen patcher$skipTerrainScreen(GuiScreen var1) {
      return null;
   }

   @Overwrite
   public void func_147258_a(S08PacketPlayerPosLook var1) {
      PacketThreadUtil.checkThreadAndEnqueue(var1, (NetHandlerPlayClient)this, this.field_147299_f);
      EntityPlayerSP var2 = this.field_147299_f.thePlayer;
      double var3 = var1.getX();
      double var5 = var1.getY();
      double var7 = var1.getZ();
      float var9 = var1.getYaw();
      float var10 = var1.getPitch();
      RotateEvent var11 = new RotateEvent(new C06PacketPlayerPosLook(var2.posX, var2.posY, var2.posZ, var2.rotationYaw, var2.rotationPitch, false), var3, var5, var7, var9, var10);
      EventBus.getInstance().call(var11);
      if (!var11.c58917()) {
         var3 = var11.c19049();
         var5 = var11.c10534();
         var7 = var11.c26301();
         var9 = var11.c74012();
         var10 = var11.c86825();
         if (var1.func_179834_f().contains(EnumFlags.X)) {
            var3 += var2.posX;
         } else {
            var2.motionX = 0.0D;
         }

         if (var1.func_179834_f().contains(EnumFlags.Y)) {
            var5 += var2.posY;
         } else {
            var2.motionY = 0.0D;
         }

         if (var1.func_179834_f().contains(EnumFlags.Z)) {
            var7 += var2.posZ;
         } else {
            var2.motionZ = 0.0D;
         }

         if (var1.func_179834_f().contains(EnumFlags.X_ROT)) {
            var10 += var2.rotationPitch;
         }

         if (var1.func_179834_f().contains(EnumFlags.Y_ROT)) {
            var9 += var2.rotationYaw;
         }

         var2.setPositionAndRotation(var3, var5, var7, var9, var10);
         this.field_147302_e.sendPacket(new C06PacketPlayerPosLook(var2.posX, var2.getEntityBoundingBox().minY, var2.posZ, var2.rotationYaw, var2.rotationPitch, false));
         if (!this.field_147309_h) {
            this.field_147299_f.thePlayer.prevPosX = this.field_147299_f.thePlayer.posX;
            this.field_147299_f.thePlayer.prevPosY = this.field_147299_f.thePlayer.posY;
            this.field_147299_f.thePlayer.prevPosZ = this.field_147299_f.thePlayer.posZ;
            this.field_147309_h = true;
            this.field_147299_f.displayGuiScreen((GuiScreen)null);
         }

      }
   }
}
