//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.util.rotation;

import net.minecraft.entity.player.EntityPlayer;

public class RotationUtils2 {
   public float brisbane$;
   public float ministry$;

   public RotationUtils2(float markets, float brown) {
      twisted.brisbane$ = (float)markets;
      twisted.ministry$ = (float)brown;
      twisted._duration(Float.valueOf(RotationUtils6.essay$.gameSettings.mouseSensitivity));
   }

   public void _assisted(float malagapa) {
      rafonofu.brisbane$ = (float)malagapa;
   }

   public void _enormous(float ameboyif) {
      gefezuse.ministry$ = (float)ameboyif;
   }

   public float _combat() {
      return alipucel.brisbane$;
   }

   public float _mileage() {
      return singh.ministry$;
   }

   public void _thomson(EntityPlayer toritusa) {
      if (!Float.isNaN(ozinedat.brisbane$) && !Float.isNaN(ozinedat.ministry$)) {
         ozinedat._duration(Float.valueOf(RotationUtils6.essay$.gameSettings.mouseSensitivity));
         ((EntityPlayer)toritusa).rotationYaw = ozinedat.brisbane$;
         ((EntityPlayer)toritusa).rotationPitch = ozinedat.ministry$;
      }
   }

   public void _duration(Float ocuvacig) {
      Object ilezosir = ((Float)ocuvacig).floatValue() * 0.6F + 0.2F;
      Object nilemora = ilezosir * ilezosir * ilezosir * 1.2F;
      yavapulo.brisbane$ -= yavapulo.brisbane$ % nilemora;
      yavapulo.ministry$ -= yavapulo.ministry$ % nilemora;
   }
}
