package rip.sleep.module;

import rip.sleep.Sleep;
import rip.sleep.command.ModuleCommand;
import rip.sleep.event.EventBus;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumChatFormatting;
import rip.sleep.management.ModuleManager;
import rip.sleep.module.modules.HUD;
import rip.sleep.util.TimerUtilI;
import rip.sleep.util.RenderUtilF;
import rip.sleep.value.Value;
import rip.sleep.value.values.ModeValue;
import rip.sleep.wrapper.EventBusWrapper;
import rip.sleep.ui.notification.Notification;
import rip.sleep.util.SoundPlayerA;

public class Module {
   public static final Minecraft mc = Minecraft.getMinecraft();
   public String c24432;
   private String c32510;
   private int c24934;
   private final String[] c992;
   private boolean c26290;
   public boolean c76880 = false;
   public int c30272;
   public List<Value> c79199;
   public ModuleType c95265;
   private boolean c79858;
   public TimerUtilI c43483 = new TimerUtilI();
   public static Random c72224 = new Random();
   private String c22936;
   public float c82995 = 0.0F;
   public float c32668 = 0.0F;
   public boolean c70993 = true;
   public float c66832 = 0.0F;
   public float c29731 = 0.0F;
   protected static final Random c65742 = new Random();
   public ModuleType.c21190 c46356;
   private static Module[] c39878;

   public Module(String var1, String[] var2, ModuleType var3, ModuleType.c21190 var4) {
      this.c24432 = var1;
      this.c992 = var2;
      this.c95265 = var3;
      this.c46356 = var4;
      this.c32510 = "";
      this.c30272 = 0;
      this.c79858 = false;
      this.c26290 = false;
      this.c22936 = null;
      this.c79199 = new ArrayList();
   }

   public void c41926() {
      Module[] var1 = Value.c27574();
      this.c43483.c37901(!this.c26290);
      this.c43483.c8498(0.2D);
      this.c43483.c49238(50);
      this.c43483.c8775();
   }

   public void c78177() {
      this.c43483.c21027();
   }

   public boolean c63183() {
      Module[] var1 = Value.c27574();
      return !this.c43483.c72231();
   }

   public String getName() {
      return HUD.c78668.c1473().booleanValue() ? this.c24432.toLowerCase() : this.c24432;
   }

   public ModuleType.c21190 c42672() {
      return this.c46356;
   }

   public void c9353() {
      Module[] var1 = Value.c27574();
      if (this.c79199.size() > 0) {
         String var2 = "";
         String var3 = "";

         for(Value var5 : this.c79199) {
            if (!(var5 instanceof ModeValue)) {
               if (var2.isEmpty()) {
                  var2 = var2 + var5.getName();
               }

               var2 = var2 + String.format(", %s", var5.getName());
               break;
            }
         }

         Iterator var8 = this.c79199.iterator();

         Value var9;
         while(true) {
            if (!var8.hasNext()) {
               Sleep.getInstance();
               Sleep.c3523().c84056(new ModuleCommand(this, this.c24432, this.c992, String.format("%s%s", var2.isEmpty() ? "" : String.format("%s,", var2), var3.isEmpty() ? "" : String.format("%s", var3)), "Setup this module"));
               return;
            }

            var9 = (Value)var8.next();
            if (var9 instanceof ModeValue) {
               break;
            }
         }

         ModeValue var6 = (ModeValue)var9;
         int var7 = 0;
         if (var7 < var6.c42690().length) {
            if (var3.isEmpty()) {
               var3 = var3 + var6.getName().toLowerCase();
            }

            (new StringBuilder()).append(String.valueOf(var3)).append(String.format(", %s", var6.getName().toLowerCase())).toString();
            ++var7;
         }
      }

   }

   public void c19741() {
      Module[] var1 = Value.c27574();
      if (this.c24622()) {
         this.c71897();
      }

      this.c83205();
      this.c23631(!this.c24622());
   }

   public String[] c53498() {
      return this.c992;
   }

   public ModuleType c78173() {
      return this.c95265;
   }

   public boolean c24622() {
      return this.c26290;
   }

   public boolean c41971() {
      return this.c79858;
   }

   public void c60705(Value<?> var1) {
      this.c79199.add(var1);
   }

   public void c68609(boolean var1) {
      this.c79858 = var1;
   }

   public String c80366() {
      return this.c32510;
   }

   public static Module c23171(Class<? extends Module> var0) {
      Value.c27574();
      Sleep var10001 = Sleep.INSTANCE;
      Sleep.c33759();
      Iterator var2 = ModuleManager.c50944.iterator();
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

   public void c2159(Object var1) {
      Value.c27574();
      String var3 = var1.toString();
      if (var3.isEmpty()) {
         this.c32510 = var3;
      }

      if (Objects.equals(HUD.c73213.c54460(), "Empty")) {
         this.c32510 = var3.isEmpty() ? var3 : "";
      }

      if (Objects.equals(HUD.c73213.c54460(), "Box")) {
         this.c32510 = var3.isEmpty() ? var3 : String.format("%s", EnumChatFormatting.GRAY + "[" + var3 + "]");
      }

      if (Objects.equals(HUD.c73213.c54460(), "None")) {
         this.c32510 = var3.isEmpty() ? var3 : String.format("%s", EnumChatFormatting.GRAY + var3);
      }

      if (Objects.equals(HUD.c73213.c54460(), "Null")) {
         this.c32510 = var3.isEmpty() ? var3 : String.format("%s", EnumChatFormatting.GRAY + "(" + var3 + ")");
      }

      if (Objects.equals(HUD.c73213.c54460(), "Hyphen")) {
         this.c32510 = var3.isEmpty() ? var3 : String.format("%s", EnumChatFormatting.GRAY + "- " + var3);
      }

   }

   public void c23631(boolean var1) {
      Value.c27574();
      this.c26290 = var1;
      if (this.c26290) {
         this.c11825();
      }

      this.c2138();
      if (Sleep.getInstance().c43557() != null) {
         Sleep.getInstance().c43557().c63824(Sleep.getInstance().c43557().c94512);
      }

   }

   public final void c11825() {
      Value.c27574();
      EventBus.getInstance().register(this);
      EventBusWrapper.c96604.c35372(this);
      Module var10000 = this;

      try {
         var10000.c83205();
      } catch (Exception var3) {
         if (mc.thePlayer != null) {
            var3.printStackTrace();
         }
      }

      if (mc.thePlayer != null) {
         if (!this.getName().equals("ClickGUI") && !this.getName().equals("HUD") && HUD.c75103.c1473().booleanValue()) {
            SoundPlayerA.c24997("on.wav", -9.0F);
         }

         if (HUD.c2442.c1473().booleanValue()) {
            Sleep.getInstance().c83083().c43114().add(new Notification(this.getName() + " was Enabled", 2000L));
         }
      }

   }

   public final void c2138() {
      Value.c27574();
      EventBus.getInstance().unregister(this);
      EventBusWrapper.c96604.c7287(this);
      Module var10000 = this;

      try {
         var10000.c71897();
      } catch (Exception var3) {
         if (mc.thePlayer != null) {
            var3.printStackTrace();
         }
      }

      if (mc.thePlayer != null) {
         if (!this.getName().equals("ClickGUI") && !this.getName().equals("HUD") && HUD.c75103.c1473().booleanValue()) {
            SoundPlayerA.c24997("off.wav", -9.0F);
         }

         if (HUD.c2442.c1473().booleanValue()) {
            Sleep.getInstance().c83083().c43114().add(new Notification(this.getName() + " was Disabled", 2000L));
         }
      }

   }

   public void c36162(int var1) {
      this.c24934 = var1;
   }

   public int c58078() {
      return this.c24934;
   }

   public void c61455(Value... var1) {
      int var3 = var1.length;
      this.c79199.addAll(Arrays.asList(var1).subList(0, var3));
   }

   public List<Value> c22326() {
      return this.c79199;
   }

   public int c93366() {
      return this.c30272;
   }

   public void c32946(int var1) {
      Value.c27574();
      this.c30272 = var1;
      if (Sleep.getInstance().c43557() != null) {
         Sleep.getInstance().c43557().c63824(Sleep.getInstance().c43557().c94512);
      }

   }

   public void c83205() {
   }

   public void c71897() {
   }

   public String c15191() {
      return this.c22936;
   }

   public void c45577(String var1) {
      Value.c27574();
      this.c22936 = var1;
      if (Sleep.getInstance().c43557() != null) {
         Sleep.getInstance().c43557().c63824(Sleep.getInstance().c43557().c94512);
      }

   }

   public void c47662(float var1) {
      this.c82995 = var1;
   }

   public float c37406() {
      return this.c32668;
   }

   public void c30853(float var1) {
      this.c32668 = var1;
   }

   public boolean c99480() {
      return this.c70993;
   }

   public void c74296(boolean var1) {
      this.c70993 = var1;
   }

   public static double c42770(double var0, double var2, double var4) {
      Value.c27574();
      float var7 = (float)((double) RenderUtilF.c75973 * var4);
      if (var0 < var2) {
         if (var0 + (double)var7 < var2) {
            double var10000 = var0 + (double)var7;
         }

         var0 = var2;
      }

      if (var0 - (double)var7 > var2) {
         double var8 = var0 - (double)var7;
      }

      return var2;
   }

   public float c41461() {
      return this.c82995;
   }

   static {
      c75539(new Module[3]);
   }

   public static void c75539(Module[] var0) {
      c39878 = var0;
   }

   public static Module[] c12876() {
      return c39878;
   }

   private static Exception c90310(Exception var0) {
      return var0;
   }
}
