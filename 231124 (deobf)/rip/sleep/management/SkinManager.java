package rip.sleep.management;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IImageBuffer;
import net.minecraft.client.renderer.ImageBufferDownload;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.client.resources.DefaultPlayerSkin;
import net.minecraft.util.ResourceLocation;
import org.json.JSONException;
import rip.sleep.module.Module;
import rip.sleep.value.Value;
import rip.sleep.wrapper.ChatWrapper;

public class SkinManager {
   public static SkinManager c19604;
   public final char[] c72327;
   public final char[] c79406;
   public final File c50305;
   public File c53890;
   public final HashMap<String, ResourceLocation> c97538;

   public SkinManager() {
      Value.c27574();
      super();
      this.c72327 = new char[256];
      this.c79406 = new char['\uffff'];
      this.c50305 = new File(Minecraft.getMinecraft().mcDataDir.getAbsolutePath(), "sleep");
      this.c53890 = new File(this.c50305 + File.separator + "CustomSkins");
      this.c97538 = new HashMap();
      c19604 = this;
      if (!this.c53890.exists()) {
         this.c53890.mkdir();
      }

      int var2 = 0;
      if (var2 < this.c72327.length) {
         this.c72327[var2] = (char)var2;
         ++var2;
      }

      var2 = 0;
      if (var2 < this.c79406.length) {
         this.c79406[var2] = (char)var2;
         ++var2;
      }

   }

   public ResourceLocation c56907(String var1) {
      Module[] var2 = Value.c27574();
      return this.c97538.containsKey(var1) ? (ResourceLocation)this.c97538.get(var1) : DefaultPlayerSkin.getDefaultSkin(Minecraft.getMinecraft().getSession().getProfile().getId());
   }

   public void c70663(String var1) {
      Module[] var2 = Value.c27574();
      if (!this.c97538.containsKey(var1)) {
         File var3 = new File(this.c53890.getAbsolutePath() + File.separator + var1 + ".png");
         if (!var3.exists()) {
            ChatWrapper.c82702("File " + var1 + ".png not exist!");
         } else {
            (new Thread(() -> {
               this.c97538.put(var1, (Object)null);
               final ResourceLocation var3x = new ResourceLocation("CustomSkins/" + var1);
               IImageBuffer var4 = new IImageBuffer() {
                  final ImageBufferDownload c20925 = new ImageBufferDownload();

                  public BufferedImage parseUserSkin(BufferedImage var1x) {
                     return var1x;
                  }

                  public void skinAvailable() {
                     SkinManager.this.c97538.put(var1, var3x);
                  }
               };
               ThreadDownloadImageData var5 = new ThreadDownloadImageData(var3, (String)null, (ResourceLocation)null, var4);
               Minecraft.getMinecraft().getTextureManager().loadTexture(var3x, var5);
            })).start();
         }
      }
   }

   private static JSONException c27226(JSONException var0) {
      return var0;
   }
}
