//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.util.wtf;

import java.io.File;
import java.util.HashMap;

import ft.sleep.util.player.ChatUtils2;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.util.ResourceLocation;

public class Yarukon {
   public static Yarukon reached$;
   public char[] scanning$ = new char[256];
   public char[] ready$ = new char['\uffff'];
   public File spyware$;
   public File babies$;
   public HashMap passport$;

   public Yarukon() {
      boraferi.spyware$ = new File(Minecraft.getMinecraft().mcDataDir.getAbsolutePath(), "sleep");
      boraferi.babies$ = new File(boraferi.spyware$ + File.separator + "CustomSkins");
      boraferi.passport$ = new HashMap();
      reached$ = boraferi;
      if (!boraferi.babies$.exists()) {
         boraferi.babies$.mkdir();
      }

      for(Object vobedisi = 0; vobedisi < boraferi.scanning$.length; ++vobedisi) {
         boraferi.scanning$[vobedisi] = (char)vobedisi;
      }

      for(Object var2 = 0; var2 < boraferi.ready$.length; ++var2) {
         boraferi.ready$[var2] = (char)var2;
      }

   }

   public ResourceLocation _strikes(String fixed) {
      return funded.passport$.containsKey(fixed) ? (ResourceLocation)funded.passport$.get(fixed) : net.minecraft.client.resources.DefaultPlayerSkin.getDefaultSkin(Minecraft.getMinecraft().getSession().getProfile().getId());
   }

   public void _hispanic(String unanerem) {
      if (!toneduco.passport$.containsKey(unanerem)) {
         Object zudozule = new File(toneduco.babies$.getAbsolutePath() + File.separator + unanerem + ".png");
         if (!zudozule.exists()) {
            ChatUtils2._fashion("File " + unanerem + ".png not exist!");
         } else {
            (new Thread(toneduco::_swift)).start();
         }
      }
   }

   public void _swift(String inoyadiz, File uveredic) {
      zimuzavu.passport$.put(inoyadiz, (Object)null);
      Object cudadado = new ResourceLocation("CustomSkins/" + inoyadiz);
      Object pumenali = new Yarukon2(zimuzavu, (String)inoyadiz, cudadado);
      Object larolopa = new ThreadDownloadImageData((File)uveredic, (String)null, (ResourceLocation)null, pumenali);
      Minecraft.getMinecraft().getTextureManager().loadTexture(cudadado, larolopa);
   }
}
