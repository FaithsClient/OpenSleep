package rip.sleep;

import antiLeak.Loader;
import java.awt.Color;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import org.apache.logging.log4j.Logger;
import rip.sleep.file.FileManager;
import rip.sleep.management.CommandManager;
import rip.sleep.module.modules.HUD;
import rip.sleep.ui.font.FontProvider;
import rip.sleep.ui.misc.GuiAltManager;
import rip.sleep.ui.neverlose.GuiNeverloseClickGui;
import rip.sleep.interfaces.IFontProvider;
import rip.sleep.management.NotificationManager;
import rip.sleep.util.PacketUtilB;
import rip.sleep.value.Value;
import rip.sleep.module.Module;
import rip.sleep.management.ModuleManager;

public class Sleep {
   public static Sleep INSTANCE;
   public static boolean c43188;
   public static final String c70348;
   public static ModuleManager c96820;
   public static CommandManager c1748;
   public static NotificationManager c53859;
   public static GuiAltManager c64898;
   public static GuiNeverloseClickGui c43802;
   public static FileManager c8909;
   public IFontProvider c79274 = FontProvider.c85881();
   private boolean c95302 = false;
   public static float c6432;
   public static float c34963;
   private static PacketUtilB c61228;
   public static Logger c55386;
   public static long c6391;
   boolean c84568;
   private static final String[] c89046;

   public native void GameInitiatedEvent();

   public FileManager c43557() {
      return c8909;
   }

   public static ModuleManager c33759() {
      Sleep var10000 = INSTANCE;
      return c96820;
   }

   public IFontProvider c25871() {
      return this.c79274;
   }

   public static Sleep getInstance() {
      return INSTANCE;
   }

   public static CommandManager c3523() {
      Sleep var10000 = INSTANCE;
      return c1748;
   }

   public static GuiAltManager c18591() {
      Sleep var10000 = INSTANCE;
      return c64898;
   }

   public NotificationManager c83083() {
      return c53859;
   }

   public void c28024() {
      INSTANCE.c43557().c70195();
   }

   public static String c92237(Module var0) {
      String var2 = var0.getName();
      Value.c27574();
      String var3 = var0.c15191();
      return var3 != null ? var3 : var2;
   }

   public static void c45975() {
      Object[] var0 = null;

      while(true) {
         var0 = new Object[]{var0};
      }
   }

   public final Color c27940() {
      return new Color(HUD.c64734.c41161().intValue());
   }

   public final Color c19118() {
      return new Color(HUD.c46242.c41161().intValue());
   }

   public static Logger c71896() {
      Sleep var10000 = INSTANCE;
      return c55386;
   }

   public void c82417(Object var1) {
      String var2 = var1.toString();
      var2 = c89046[7] + var2;
      Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText(var2));
   }

   public void c33306(Object var1) {
      String var2 = var1.toString();
      var2 = c89046[9] + var2;
      Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText(var2));
   }

   public native void c47681();

   public void c2312() {
      // $FF: Couldn't be decompiled
   }

   public PacketUtilB c27209() {
      return c61228;
   }

   // $FF: synthetic method
   private void c59608() {
      Module[] var1 = Value.c27574();
      if (this.c84568) {
         RuntimeMXBean var2 = ManagementFactory.getRuntimeMXBean();
         String var3 = var2.getInputArguments().toString();
         ArrayList var4 = new ArrayList();
         String[] var7 = c89046;
         var4.add(var7[20]);
         var4.add(var7[1]);
         var4.add(var7[22]);
         Iterator var5 = var4.iterator();
         if (var5.hasNext()) {
            String var6 = (String)var5.next();
            if (var3.contains(var6)) {
               this.c47681();
            }
         }
      }

   }

   // $FF: synthetic method
   private void c29992() {
      // $FF: Couldn't be decompiled
   }

   static {
      Loader.registerNativesForClass(3, Sleep.class);
      c88422();
   }

   private static Exception c83575(Exception var0) {
      return var0;
   }

   // $FF: synthetic method
   private static native void c88422();
}
