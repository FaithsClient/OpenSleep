//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.injection.mixins;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.client.renderer.entity.layers.LayerArmorBase;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@SideOnly(Side.CLIENT)
@Mixin({LayerArmorBase.class})
public abstract class MixinLayerArmorBase implements LayerRenderer {
   @Shadow
   private RendererLivingEntity renderer;
   @Shadow
   private float alpha;
   @Shadow
   private float colorR = 1.0F;
   @Shadow
   private float colorG = 1.0F;
   @Shadow
   private float colorB = 1.0F;
   @Shadow
   private boolean skipRenderGlint;

   @Shadow
   public abstract ItemStack getCurrentArmor(EntityLivingBase var1, int var2);

   @Shadow
   public abstract ModelBase getArmorModel(int var1);

   @Shadow
   protected abstract ModelBase getArmorModelHook(EntityLivingBase var1, ItemStack var2, int var3, ModelBase var4);

   @Shadow
   protected abstract void setModelPartVisible(ModelBase var1, int var2);

   @Shadow
   public abstract boolean isSlotForLeggings(int var1);

   @Shadow
   public abstract ResourceLocation getArmorResource(Entity var1, ItemStack var2, int var3, String var4);

   @Shadow
   public abstract void renderGlint(EntityLivingBase var1, ModelBase var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9);

   @Overwrite
   private void renderLayer(EntityLivingBase p_renderLayer_1_, float p_renderLayer_2_, float p_renderLayer_3_, float p_renderLayer_4_, float p_renderLayer_5_, float p_renderLayer_6_, float p_renderLayer_7_, float p_renderLayer_8_, int p_renderLayer_9_) {
      ItemStack itemstack = this.getCurrentArmor(p_renderLayer_1_, p_renderLayer_9_);
      if (itemstack != null && itemstack.getItem() instanceof ItemArmor) {
         ItemArmor itemarmor = (ItemArmor)itemstack.getItem();
         ModelBase t = this.getArmorModel(p_renderLayer_9_);
         t.setModelAttributes(this.renderer.getMainModel());
         t.setLivingAnimations(p_renderLayer_1_, p_renderLayer_2_, p_renderLayer_3_, p_renderLayer_4_);
         t = this.getArmorModelHook(p_renderLayer_1_, itemstack, p_renderLayer_9_, t);
         this.setModelPartVisible(t, p_renderLayer_9_);
         boolean flag = this.isSlotForLeggings(p_renderLayer_9_);
         this.renderer.bindTexture(this.getArmorResource(p_renderLayer_1_, itemstack, flag ? 2 : 1, (String)null));
         int i = itemarmor.getColor(itemstack);
         �?.�?();
          teams = ().�?(.class);
         this.alpha = teams.(p_renderLayer_1_) ? 0.1F : 1.0F;
         if (i != -1) {
            float f = (float)(i >> 16 & 255) / 255.0F;
            float f1 = (float)(i >> 8 & 255) / 255.0F;
            float f2 = (float)(i & 255) / 255.0F;
            GlStateManager.color(this.colorR * f, this.colorG * f1, this.colorB * f2, this.alpha);
            t.render(p_renderLayer_1_, p_renderLayer_2_, p_renderLayer_3_, p_renderLayer_5_, p_renderLayer_6_, p_renderLayer_7_, p_renderLayer_8_);
            this.renderer.bindTexture(this.getArmorResource(p_renderLayer_1_, itemstack, flag ? 2 : 1, "overlay"));
         }

         GlStateManager.color(this.colorR, this.colorG, this.colorB, this.alpha);
         t.render(p_renderLayer_1_, p_renderLayer_2_, p_renderLayer_3_, p_renderLayer_5_, p_renderLayer_6_, p_renderLayer_7_, p_renderLayer_8_);
         if (!this.skipRenderGlint && itemstack.hasEffect()) {
            this.renderGlint(p_renderLayer_1_, t, p_renderLayer_2_, p_renderLayer_3_, p_renderLayer_4_, p_renderLayer_5_, p_renderLayer_6_, p_renderLayer_7_, p_renderLayer_8_);
         }
      }

   }
}
