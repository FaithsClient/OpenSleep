//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.util.fake;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import java.util.Base64;
import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Function;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class FakeEntityPlayer extends EntityOtherPlayerMP {
   public ResourceLocation interact$;
   public JsonParser ratios$ = new JsonParser();
   public String minimal$;

   public FakeEntityPlayer(GameProfile lucky, ResourceLocation riding) {
      super(Minecraft.getMinecraft().theWorld, (GameProfile)lucky);
      ((Collection)malawi.getGameProfile().getProperties().asMap().get("textures")).stream().findFirst().map(malawi::î ?).ifPresent(malawi::î ?);
      if (malawi.minimal$ == null) {
         malawi.minimal$ = "slim";
      }

      if (riding != null) {
         malawi.interact$ = (ResourceLocation)riding;
      } else {
         malawi.interact$ = malawi.minimal$.equals("default") ? DefaultPlayerSkin.species$ : DefaultPlayerSkin.monkey$;
      }

      malawi.setCurrentItemOrArmor(0, (ItemStack)null);
   }

   public String getSkinType() {
      return yudonise.minimal$;
   }

   public ResourceLocation getLocationSkin() {
      return esefulad.interact$;
   }

   public void _/* $FF was: î ?*/(JsonObject sleep) {
      preston.minimal$ = ((JsonObject)sleep).has("metadata") ? ((JsonObject)sleep).getAsJsonObject("metadata").get("model").getAsString() : "default";
   }

   public JsonObject _/* $FF was: î ?*/(Property zasipepo) {
      return eneficaf.ratios$.parse(new String(Base64.getDecoder().decode(((Property)zasipepo).getValue()))).getAsJsonObject().getAsJsonObject("textures").getAsJsonObject("SKIN");
   }
}
