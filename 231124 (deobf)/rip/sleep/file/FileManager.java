package rip.sleep.file;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import rip.sleep.util.JsonUtilA;
import rip.sleep.module.Module;
import rip.sleep.Sleep;
import rip.sleep.value.Value;

@SideOnly(Side.CLIENT)
public class FileManager {
   public final File c88839;
   public final File c9470;
   public final FileStruct c94512;
   public final FriendFile c25756;
   public final JsonUtilA c36876;
   public AccountFile c93071;
   public boolean c97180;
   public static final Gson c69355 = (new GsonBuilder()).setPrettyPrinting().create();

   public FileManager() {
      this.c88839 = new File(Minecraft.getMinecraft().mcDataDir.getAbsolutePath(), "sleep");
      this.c9470 = new File(this.c88839, "configs");
      this.c94512 = new TargetFile(new File(this.c9470, "default.json"));
      this.c25756 = new FriendFile(new File(this.c88839, "friends.json"));
      this.c36876 = new JsonUtilA(new File(this.c88839, "targets.json"));
      this.c93071 = new AccountFile(new File(this.c88839, "alts.json"));
      this.c97180 = false;
      this.c10299();
   }

   public void c10299() {
      Module[] var1 = Value.c27574();
      if (!this.c88839.exists()) {
         this.c88839.mkdir();
         this.c97180 = true;
      }

      if (!this.c9470.exists()) {
         this.c9470.mkdir();
         this.c97180 = true;
      }

   }

   public void c82489() {
      // $FF: Couldn't be decompiled
   }

   public void c88873(FileStruct... var1) {
      Value.c27574();
      int var4 = var1.length;
      int var5 = 0;
      if (var5 < var4) {
         FileStruct var6 = var1[var5];
         this.c2789(var6);
         ++var5;
      }

   }

   public void c2789(FileStruct var1) {
      Module[] var2 = Value.c27574();
      if (!var1.c53181()) {
         Sleep.c71896().info("[FileManager] Skipped loading config: " + var1.c63704().getName() + ".");
         this.c37809(var1, true);
      } else {
         FileStruct var10000 = var1;

         try {
            var10000.c587();
            Sleep.c71896().info("[FileManager] Loaded config: " + var1.c63704().getName() + ".");
         } catch (Throwable var4) {
            Sleep.c71896().error("[FileManager] Failed to load config file: " + var1.c63704().getName() + ".", var4);
         }

      }
   }

   public void c70195() {
      // $FF: Couldn't be decompiled
   }

   public void c44758(FileStruct... var1) {
      Value.c27574();
      int var4 = var1.length;
      int var5 = 0;
      if (var5 < var4) {
         FileStruct var6 = var1[var5];
         this.c63824(var6);
         ++var5;
      }

   }

   public void c63824(FileStruct var1) {
      this.c37809(var1, false);
   }

   private void c37809(FileStruct param1, boolean param2) {
      // $FF: Couldn't be decompiled
   }

   private static Throwable c53822(Throwable var0) {
      return var0;
   }
}
