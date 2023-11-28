package rip.sleep.management;

import rip.sleep.Sleep;
import rip.sleep.event.EventBus;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.minecraft.client.Minecraft;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.KeyPressEvent;
import rip.sleep.interfaces.IManager;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.module.modules.*;
import rip.sleep.ui.font.FontRendererB;
import rip.sleep.value.Value;
import rip.sleep.value.values.BooleanValue;
import rip.sleep.wrapper.EventBusWrapper;

public class ModuleManager implements IManager {
   static ArrayList<Module> c50944 = new ArrayList();

   public void c32199() {
      this.addModule(new StaffAnalyser());
      this.addModule(new HUD());
      this.addModule(new KillAura());
      this.addModule(new KeepSprint());
      this.addModule(new AutoTool());
      this.addModule(new Camera());
      this.addModule(new LegitSpeed());
      this.addModule(new UHCFind());
      this.addModule(new AntiFall());
      this.addModule(new Flight());
      this.addModule(new Ambience());
      this.addModule(new PartyHUD());
      this.addModule(new Phase());
      this.addModule(new BowAimBot());
      this.addModule(new SpeedMine());
      this.addModule(new ChestESP());
      this.addModule(new CPSRender());
      this.addModule(new UHCFastCraft());
      this.addModule(new Freecam());
      this.addModule(new FluidMove());
      this.addModule(new AntiDisplayFucker());
      this.addModule(new NoBlockParticle());
      this.addModule(new MiniMap());
      this.addModule(new HitBoxes());
      this.addModule(new ESP2D());
      this.addModule(new ChatTranslator());
      this.addModule(new BedNuker());
      this.addModule(new TargetList());
      this.addModule(new Scaffold());
      this.addModule(new ChestStealer());
      this.addModule(new GameSpeed());
      this.addModule(new FBJump());
      this.addModule(new Speed());
      this.addModule(new ESP3D());
      this.addModule(new SafeWalk());
      this.addModule(new AimAssist());
      this.addModule(new AutoTunnel());
      this.addModule(new Skeletal());
      this.addModule(new AutoQueue());
      this.addModule(new AutoArmor());
      this.addModule(new InvManager());
      this.addModule(new CustomTags());
      this.addModule(new RejoinGame());
      this.addModule(new AntiKB());
      this.addModule(new GhostHead());
      this.addModule(new ClickGui());
      this.addModule(new ItemESP());
      this.addModule(new NoRotate());
      this.addModule(new SpeedMine2());
      this.addModule(new Chams());
      this.addModule(new UnknownModule());
      this.addModule(new Criticals());
      this.addModule(new RageBot());
      this.addModule(new TargetHUD());
      this.addModule(new FastPlace());
      this.addModule(new AutoClicker());
      this.addModule(new SpeedMine3());
      this.addModule(new NoSlowdown());
      this.addModule(new NoJumpDelay());
      this.addModule(new Sprint());
      this.addModule(new AntiBot());
      this.addModule(new Friends());
      this.addModule(new NameTags());
      this.addModule(new Reach());
      this.addModule(new Velocity());
      Value.c27574();
      this.addModule(new AutoKill());
      this.addModule(new MWAddons());
      this.addModule(new ViewClip());
      this.addModule(new Blink());
      this.addModule(new XRay());
      this.addModule(new InvMove());
      this.addModule(new Teams());
      this.addModule(new AutoHead());
      this.addModule(new WaterBucket());
      this.addModule(new AntiTrap());
      this.addModule(new LightingTrack());
      Iterator var2 = c50944.iterator();
      if (var2.hasNext()) {
         Module var3 = (Module)var2.next();
         var3.c9353();
      }

      EventBus.getInstance().register(this);
      EventBusWrapper.c96604.c35372(this);
   }

   public static ArrayList<Module> c84590() {
      return c50944;
   }

   public Module c39099(String var1) {
      Value.c27574();
      Iterator var3 = c50944.iterator();
      if (var3.hasNext()) {
         Module var4 = (Module)var3.next();
         if (var4.getName().equalsIgnoreCase(var1)) {
            return var4;
         }
      }

      return null;
   }

   public void addModule(Module var1) {
      Field[] var3 = var1.getClass().getDeclaredFields();
      Value.c27574();
      int var4 = var3.length;
      int var5 = 0;
      if (var5 < var4) {
         Field var6 = var3[var5];
         if (!var6.isAccessible()) {
            var6.setAccessible(true);
         }

         Field var10000 = var6;
         Module var10001 = var1;

         try {
            Object var7;
            if ((var7 = var10000.get(var10001)) instanceof Value) {
               var1.c60705((Value)var7);
            }
         } catch (IllegalAccessException var9) {
            var9.printStackTrace();
         }

         ++var5;
      }

      c50944.add(var1);
   }

   public static Module c25475(Class<? extends Module> var0) {
      Value.c27574();
      Iterator var2 = c50944.iterator();
      if (var2.hasNext()) {
         Module var3 = (Module)var2.next();
         if (var3.getClass() != var0) {
            ;
         }

         return var3;
      } else {
         return null;
      }
   }

   public static Module c59260(String var0) {
      Value.c27574();
      Iterator var2 = c50944.iterator();
      if (var2.hasNext()) {
         Module var3 = (Module)var2.next();
         if (!var3.getName().equalsIgnoreCase(var0)) {
            ;
         }

         return var3;
      } else {
         return null;
      }
   }

   public Module c89891(String var1) {
      Value.c27574();
      Iterator var3 = c50944.iterator();
      if (var3.hasNext()) {
         Module var4 = (Module)var3.next();
         if (var4.getName().equalsIgnoreCase(var1)) {
            return var4;
         }

         String[] var5 = var4.c53498();
         int var6 = var5.length;
         int var7 = 0;
         if (var7 < var6) {
            String var8 = var5[var7];
            if (var8.equalsIgnoreCase(var1)) {
               return var4;
            }

            ++var7;
         }
      }

      return null;
   }

   public List<Module> c32910(ModuleType var1) {
      Value.c27574();
      ArrayList var3 = new ArrayList();
      Iterator var4 = c50944.iterator();
      if (var4.hasNext()) {
         Module var5 = (Module)var4.next();
         if (var5.c78173() != var1) {
            ;
         }

         var3.add(var5);
      }

      return var3;
   }

   @EventTarget
   private void c68249(KeyPressEvent var1) {
      Value.c27574();
      Iterator var3 = c50944.iterator();
      if (var3.hasNext()) {
         Module var4 = (Module)var3.next();
         if (var4.c93366() == var1.c32917()) {
            var4.c19741();
         }
      }

   }

   public ArrayList<Module> c47567(FontRendererB var1) {
      Value.c27574();
      ArrayList var3 = new ArrayList();
      Sleep.c33759();
      BooleanValue var10000 = HUD.c74288;

      try {
         if (var10000.c1473().booleanValue()) {
            var3.removeIf((var0) -> {
               return var0.c78173() == ModuleType.c12482;
            });
         }
      } catch (Exception var5) {
         ;
      }

      if (HUD.c27960.c1473().booleanValue()) {
         var3.sort((var1x, var2) -> {
            Module[] var3 = Value.c27574();
            return var1.c65036(var2.c80366().isEmpty() ? Sleep.c92237(var2) : String.format("%s %s", Sleep.c92237(var2), var2.c80366())) - var1.c65036(var1x.c80366().isEmpty() ? Sleep.c92237(var1x) : String.format("%s %s", Sleep.c92237(var1x), var1x.c80366()));
         });
      }

      var3.sort((var0, var1x) -> {
         Module[] var2 = Value.c27574();
         return Minecraft.getMinecraft().fontRendererObj.getStringWidth(var1x.c80366().isEmpty() ? Sleep.c92237(var1x) : String.format("%s %s", Sleep.c92237(var1x), var1x.c80366())) - Minecraft.getMinecraft().fontRendererObj.getStringWidth(var0.c80366().isEmpty() ? Sleep.c92237(var0) : String.format("%s %s", Sleep.c92237(var0), var0.c80366()));
      });
      return var3;
   }

   private static Exception c73519(Exception var0) {
      return var0;
   }
}
