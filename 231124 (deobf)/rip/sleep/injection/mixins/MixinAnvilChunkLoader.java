package rip.sleep.injection.mixins;

import java.io.DataInputStream;
import java.io.IOException;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.chunk.storage.AnvilChunkLoader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin({AnvilChunkLoader.class})
public class MixinAnvilChunkLoader {
   @Redirect(
      method = {"loadChunk__Async"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/nbt/CompressedStreamTools;read(Ljava/io/DataInputStream;)Lnet/minecraft/nbt/NBTTagCompound;"
)
   )
   private NBTTagCompound patcher$closeStream(DataInputStream var1) throws IOException {
      NBTTagCompound var2 = CompressedStreamTools.read(var1);
      var1.close();
      return var2;
   }
}
