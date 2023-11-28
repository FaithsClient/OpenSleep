package rip.sleep.injection.mixins;

import rip.sleep.event.EventBus;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import rip.sleep.injection.in.IMixinMinecraft;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.crash.CrashReport;
import net.minecraft.entity.Entity;
import net.minecraft.init.Bootstrap;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Session;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.Sys;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import rip.sleep.util.RenderUtilF;
import rip.sleep.event.events.AttackEvent;
import rip.sleep.module.modules.XRay;
import rip.sleep.Sleep;
import rip.sleep.management.ModuleManager;
import rip.sleep.util.MixinHelper;
import rip.sleep.event.events.ClickEvent;
import rip.sleep.event.events.TickEvent;

@SideOnly(Side.CLIENT)
@Mixin({Minecraft.class})
public abstract class MixinMinecraft implements IMixinMinecraft {
   @Shadow
   public GuiScreen field_71462_r;
   @Shadow
   private static final Logger field_147123_G = LogManager.getLogger();
   @Shadow
   public boolean field_71454_w;
   @Shadow
   public PlayerControllerMP field_71442_b;
   @Shadow
   private Entity field_175622_Z;
   @Shadow
   private boolean field_71431_Q;
   @Shadow
   private int field_71467_ac;
   @Shadow
   private MovingObjectPosition field_71476_x;
   @Shadow
   private String field_71475_ae;
   @Shadow
   private int field_71477_af;
   @Shadow
   @Mutable
   @Final
   private Session field_71449_j;
   @Shadow
   private int field_71429_W;
   private long lastFrame = this.getTime();

   public void setClickCounter(int var1) {
      this.field_71429_W = var1;
   }

   @Inject(
      method = {"startGame"},
      at = {@At(
   value = "FIELD",
   target = "Lnet/minecraft/client/Minecraft;ingameGUI:Lnet/minecraft/client/gui/GuiIngame;",
   shift = At.Shift.AFTER
)}
   )
   private void startGame(CallbackInfo var1) {
      MixinHelper.c63932();
   }

   @Inject(
      method = {"runGameLoop"},
      at = {@At("HEAD")}
   )
   private void onLoop(CallbackInfo var1) {
      MixinHelper.c61698();
   }

   @Inject(
      method = {"runTick"},
      at = {@At(
   value = "INVOKE",
   target = "Lnet/minecraft/client/Minecraft;dispatchKeypresses()V",
   shift = At.Shift.AFTER
)}
   )
   private void onKey(CallbackInfo var1) {
      MixinHelper.c70436();
   }

   @Inject(
      method = {"runTick"},
      at = {@At(
   value = "INVOKE",
   target = "Lnet/minecraft/profiler/Profiler;endStartSection(Ljava/lang/String;)V",
   ordinal = 2
)}
   )
   private void onRunTick(CallbackInfo var1) {
      MixinHelper.c48150();
   }

   @Inject(
      method = {"runTick"},
      at = {@At(
   value = "INVOKE",
   target = "Lnet/minecraft/client/options/GameOptions;keyBindAttack:Lnet/minecraft/client/options/KeyBinding;",
   ordinal = 1,
   shift = At.Shift.BEFORE
)}
   )
   private void onRunTick2(CallbackInfo var1) {
      MixinHelper.c59991();
   }

   @Inject(
      method = {"runTick"},
      at = {@At("RETURN")}
   )
   private void runTick(CallbackInfo var1) {
      EventBus.getInstance().call(new TickEvent());
   }

   @Inject(
      method = {"shutdownMinecraftApplet"},
      at = {@At("HEAD")}
   )
   public void shutdownMinecraftApplet(CallbackInfo var1) {
      MixinHelper.c5354();
   }

   @Inject(
      method = {"clickMouse"},
      at = {@At("HEAD")}
   )
   private void clickMouse(CallbackInfo var1) {
      EventBus.getInstance().call(new ClickEvent(ClickEvent.c35755.c21791));
      if (this.field_71476_x != null && this.field_71476_x.typeOfHit == MovingObjectType.ENTITY) {
         AttackEvent var2 = new AttackEvent(this.field_71476_x.entityHit);
         EventBus.getInstance().call(var2);
         if (var2.c58917()) {
            var1.cancel();
         }
      }

   }

   @Overwrite
   public void func_147121_ag() {
      EventBus.getInstance().call(new ClickEvent(ClickEvent.c35755.c46861));
      MixinHelper.c70586();
   }

   @Inject(
      method = {"middleClickMouse"},
      at = {@At("HEAD")}
   )
   private void middleClickMouse(CallbackInfo var1) {
      EventBus.getInstance().call(new ClickEvent(ClickEvent.c35755.c3449));
   }

   @Inject(
      method = {"loadWorld(Lnet/minecraft/client/multiplayer/WorldClient;Ljava/lang/String;)V"},
      at = {@At("HEAD")}
   )
   private void loadWorld(WorldClient var1, String var2, CallbackInfo var3) {
      MixinHelper.c7820(var1);
   }

   public long getTime() {
      return Sys.getTime() * 1000L / Sys.getTimerResolution();
   }

   @Inject(
      method = {"runGameLoop"},
      at = {@At("HEAD")}
   )
   private void runGameLoop(CallbackInfo var1) {
      long var2 = this.getTime();
      int var4 = (int)(var2 - this.lastFrame);
      this.lastFrame = var2;
      RenderUtilF.c75973 = (float)var4;
   }

   @Overwrite
   public void func_71377_b(CrashReport var1) {
      Minecraft var10002 = (Minecraft)this;
      File var2 = new File(Minecraft.getMinecraft().mcDataDir, "crash-reports");
      File var3 = new File(var2, "crash-" + (new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss")).format(new Date()) + "-client.txt");
      Bootstrap.printToSYSOUT(var1.getCompleteReport());
      if (XRay.c33034) {
         Sleep.c33759();
         ModuleManager.c25475(XRay.class).c19741();
      }

      Sleep.getInstance().c28024();
      byte var4;
      if (var1.getFile() != null) {
         Bootstrap.printToSYSOUT("#@!@# Game crashed! Crash report saved to: #@!@# " + var1.getFile());
         var4 = -1;
      } else if (var1.saveToFile(var3)) {
         Bootstrap.printToSYSOUT("#@!@# Game crashed! Crash report saved to: #@!@# " + var3.getAbsolutePath());
         var4 = -1;
      } else {
         Bootstrap.printToSYSOUT("#@?@# Game crashed! Crash report could not be saved. #@?@#");
         var4 = -2;
      }

      FMLCommonHandler.instance().handleExit(var4);
   }

   @Inject(
      method = {"run"},
      at = {@At("HEAD")}
   )
   private void run(CallbackInfo var1) {
      MixinHelper.c59931();
   }

   @Inject(
      method = {"startGame"},
      at = {@At("RETURN")}
   )
   private void run2(CallbackInfo var1) {
      MixinHelper.c42863();
   }

   public Session getSession() {
      return this.field_71449_j;
   }

   public void setSession(Session var1) {
      this.field_71449_j = var1;
   }
}
