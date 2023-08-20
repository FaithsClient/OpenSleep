//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.injection.mixins;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin({ItemRenderer.class})
public abstract class MixinItemRenderer {
   @Shadow
   private float prevEquippedProgress;
   @Shadow
   private float equippedProgress;
   @Shadow
   @Final
   private Minecraft mc;
   @Shadow
   private ItemStack itemToRender;

   @Shadow
   protected abstract void rotateArroundXAndY(float var1, float var2);

   @Shadow
   protected abstract void setLightMapFromPlayer(AbstractClientPlayer var1);

   @Shadow
   protected abstract void rotateWithPlayerRotations(EntityPlayerSP var1, float var2);

   @Shadow
   protected abstract void renderItemMap(AbstractClientPlayer var1, float var2, float var3, float var4);

   @Shadow
   protected abstract void performDrinking(AbstractClientPlayer var1, float var2);

   @Shadow
   protected abstract void doBlockTransformations();

   @Shadow
   protected abstract void doBowTransformations(float var1, AbstractClientPlayer var2);

   @Shadow
   protected abstract void doItemUsedTransformations(float var1);

   @Shadow
   public abstract void renderItem(EntityLivingBase var1, ItemStack var2, TransformType var3);

   @Shadow
   protected abstract void renderPlayerArm(AbstractClientPlayer var1, float var2, float var3);
}
