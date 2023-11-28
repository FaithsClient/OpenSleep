package rip.sleep.injection.mixins;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin({ItemRenderer.class})
public abstract class MixinItemRenderer {
   @Shadow
   @Final
   private Minecraft field_78455_a;
   @Shadow
   private ItemStack field_78453_b;
}
