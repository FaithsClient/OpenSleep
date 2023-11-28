package rip.sleep.util;

import com.google.gson.JsonParser;
import com.mojang.authlib.GameProfile;
import java.util.Base64;
import java.util.Collection;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import rip.sleep.module.Module;
import rip.sleep.value.Value;
import rip.sleep.struct.SkinStruct;

public final class FakeEntityPlayer extends EntityOtherPlayerMP {
   private final ResourceLocation c6994;
   private final JsonParser c58297;
   private String c87023;

   public FakeEntityPlayer(GameProfile var1, ResourceLocation var2) {
      super(Minecraft.getMinecraft().theWorld, var1);
      Value.c27574();
      this.c58297 = new JsonParser();
      FakeEntityPlayer var10000 = this;

      label24: {
         try {
            ((Collection)var10000.func_146103_bH().getProperties().asMap().get("textures")).stream().findFirst().map((var1x) -> {
               return this.c58297.parse(new String(Base64.getDecoder().decode(var1x.getValue()))).getAsJsonObject().getAsJsonObject("textures").getAsJsonObject("SKIN");
            }).ifPresent((var1x) -> {
               Module[] var2 = Value.c27574();
               this.c87023 = var1x.has("metadata") ? var1x.getAsJsonObject("metadata").get("model").getAsString() : "default";
            });
         } catch (Throwable var5) {
            if (this.c87023 == null) {
               this.c87023 = "slim";
            }
            break label24;
         }

         if (this.c87023 == null) {
            this.c87023 = "slim";
         }
      }

      this.c6994 = var2;
      this.c6994 = this.c87023.equals("default") ? SkinStruct.c45317 : SkinStruct.c21430;
      this.setCurrentItemOrArmor(0, (ItemStack)null);
   }

   public String c52778() {
      return this.c87023;
   }

   public ResourceLocation c1545() {
      return this.c6994;
   }

   private static Throwable c72589(Throwable var0) {
      return var0;
   }
}
