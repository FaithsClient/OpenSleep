//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.util.wtf;

import java.awt.image.BufferedImage;
import net.minecraft.client.renderer.IImageBuffer;
import net.minecraft.client.renderer.ImageBufferDownload;
import net.minecraft.util.ResourceLocation;

public class Yarukon2 implements IImageBuffer {
   public ImageBufferDownload cubic$;
   public String shark$;
   public ResourceLocation heading$;
   public Yarukon pitch$;

   public Yarukon2(Yarukon dipurima, String zoritolo, ResourceLocation abozurul) {
      pedibinu.pitch$ = (Yarukon)dipurima;
      pedibinu.shark$ = (String)zoritolo;
      pedibinu.heading$ = (ResourceLocation)abozurul;
      super();
      pedibinu.cubic$ = new ImageBufferDownload();
   }

   public BufferedImage parseUserSkin(BufferedImage culture) {
      return (BufferedImage)culture;
   }

   public void skinAvailable() {
      royovoro.pitch$.passport$.put(royovoro.shark$, royovoro.heading$);
   }
}
