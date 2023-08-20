//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.injection.mixins;

import ft.sleep.api.EventBus;
import ft.sleep.api.events.misc.EventMouse;
import ft.sleep.injection.interfaces.IMixinMinecraft;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.crash.CrashReport;
import net.minecraft.entity.Entity;
import net.minecraft.init.Bootstrap;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Session;
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

@SideOnly(Side.CLIENT)
@Mixin({Minecraft.class})
public abstract class MixinMinecraft implements IMixinMinecraft {
   @Shadow
   public GuiScreen currentScreen;
   @Shadow
   private static final Logger logger = LogManager.getLogger();
   @Shadow
   public boolean skipRenderWorld;
   @Shadow
   public PlayerControllerMP playerController;
   @Shadow
   private Entity renderViewEntity;
   @Shadow
   private boolean fullscreen;
   @Shadow
   private MovingObjectPosition objectMouseOver;
   @Shadow
   private String serverName;
   @Shadow
   private int serverPort;
   @Shadow
   @Mutable
   @Final
   private Session session;
   @Shadow
   private int leftClickCounter;
   private long lastFrame = this.getTime();

   public void setClickCounter(int a) {
      this.leftClickCounter = a;
   }

   @Inject(
      method = {"startGame"},
      at = {@At(
   value = "FIELD",
   target = "Lnet/minecraft/client/Minecraft;ingameGUI:Lnet/minecraft/client/gui/GuiIngame;",
   shift = At.Shift.AFTER
)}
   )
   private void startGame(CallbackInfo ci) {
      .�?();
   }

   @Inject(
      method = {"run"},
      at = {@At("HEAD")}
   )
   private void run(CallbackInfo ci) {
      .();
   }

   @Inject(
      method = {"runTick"},
      at = {@At("RETURN")}
   )
   private void runTick2(CallbackInfo ci) {
      .�?();
   }

   @Inject(
      method = {"runTick"},
      at = {@At(
   value = "FIELD",
   target = "Lnet/minecraft/client/Minecraft;joinPlayerCounter:I",
   shift = At.Shift.BEFORE
)}
   )
   private void runTick3(CallbackInfo ci) {
      .�?();
   }

   @Inject(
      method = {"runGameLoop"},
      at = {@At("HEAD")}
   )
   private void onLoop(CallbackInfo ci) {
      .�?();
   }

   @Inject(
      method = {"runTick"},
      at = {@At(
   value = "INVOKE",
   target = "Lnet/minecraft/client/Minecraft;dispatchKeypresses()V",
   shift = At.Shift.AFTER
)}
   )
   private void onKey(CallbackInfo ci) {
      .�?();
   }

   @Inject(
      method = {"shutdownMinecraftApplet"},
      at = {@At("HEAD")}
   )
   public void shutdownMinecraftApplet(CallbackInfo ci) {
      .�?();
   }

   @Inject(
      method = {"clickMouse"},
      at = {@At("HEAD")}
   )
   private void clickMouse(CallbackInfo callbackInfo) {
      EventBus.getInstance().call(new EventMouse(EventMouse.Button.Left));
   }

   @Inject(
      method = {"rightClickMouse"},
      at = {@At("HEAD")}
   )
   private void rightClickMouse(CallbackInfo callbackInfo) {
      EventBus.getInstance().call(new EventMouse(EventMouse.Button.Right));
   }

   @Inject(
      method = {"middleClickMouse"},
      at = {@At("HEAD")}
   )
   private void middleClickMouse(CallbackInfo callbackInfo) {
      EventBus.getInstance().call(new EventMouse(EventMouse.Button.Middle));
   }

   @Inject(
      method = {"loadWorld(Lnet/minecraft/client/multiplayer/WorldClient;Ljava/lang/String;)V"},
      at = {@At("HEAD")}
   )
   private void loadWorld(WorldClient p_loadWorld_1_, String p_loadWorld_2_, CallbackInfo callbackInfo) {
      .�?(p_loadWorld_1_);
   }

   public long getTime() {
      return Sys.getTime() * 1000L / Sys.getTimerResolution();
   }

   @Inject(
      method = {"runGameLoop"},
      at = {@At("HEAD")}
   )
   private void runGameLoop(CallbackInfo callbackInfo) {
      long currentTime = this.getTime();
      int deltaTime = (int)(currentTime - this.lastFrame);
      this.lastFrame = currentTime;
      �?. = (float)deltaTime;
   }

   @Overwrite
   public void displayCrashReport(CrashReport crashReportIn) {
      Minecraft.getMinecraft();
      File file1 = new File(Minecraft.getMinecraft().mcDataDir, "crash-reports");
      File file2 = new File(file1, "crash-" + (new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss")).format(new Date()) + "-client.txt");
      Bootstrap.printToSYSOUT(crashReportIn.getCompleteReport());
      if (.) {
         �?.�?();
         .�?(.class).toggle();
      }

      �?.�?().�?();
      int retVal;
      if (crashReportIn.getFile() != null) {
         Bootstrap.printToSYSOUT("#@!@# Game crashed! Crash report saved to: #@!@# " + crashReportIn.getFile());
         retVal = -1;
      } else if (crashReportIn.saveToFile(file2)) {
         Bootstrap.printToSYSOUT("#@!@# Game crashed! Crash report saved to: #@!@# " + file2.getAbsolutePath());
         retVal = -1;
      } else {
         Bootstrap.printToSYSOUT("#@?@# Game crashed! Crash report could not be saved. #@?@#");
         retVal = -2;
      }

      FMLCommonHandler.instance().handleExit(retVal);
   }

   public Session getSession() {
      return this.session;
   }

   public void setSession(Session session) {
      this.session = session;
   }
}
