package linxiu.injection.mixins;

import net.minecraft.client.Minecraft;
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

import linxiu.Client;
import linxiu.module.modules.player.Teams;

@SuppressWarnings("rawtypes")
@SideOnly(Side.CLIENT)
@Mixin({ LayerArmorBase.class })
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
	public abstract ItemStack getCurrentArmor(EntityLivingBase entitylivingbase, int i);

	@Shadow
	public abstract ModelBase getArmorModel(int i);

	@Shadow
	protected abstract ModelBase getArmorModelHook(EntityLivingBase entitylivingbase, ItemStack itemstack, int i,
			ModelBase modelbase);

	@Shadow
	protected abstract void setModelPartVisible(ModelBase modelbase, int i);

	@Shadow
	public abstract boolean isSlotForLeggings(int i);

	@Shadow
	public abstract ResourceLocation getArmorResource(Entity entity, ItemStack itemstack, int i, String s);

	@Shadow
	public abstract void renderGlint(EntityLivingBase entitylivingbase, ModelBase modelbase, float f, float f1,
			float f2, float f3, float f4, float f5, float f6);

	@Overwrite
	private void renderLayer(EntityLivingBase p_renderLayer_1_, float p_renderLayer_2_, float p_renderLayer_3_,
			float p_renderLayer_4_, float p_renderLayer_5_, float p_renderLayer_6_, float p_renderLayer_7_,
			float p_renderLayer_8_, int p_renderLayer_9_) {
		ItemStack itemstack = this.getCurrentArmor(p_renderLayer_1_, p_renderLayer_9_);

		if (itemstack != null && itemstack.getItem() instanceof ItemArmor) {
			ItemArmor itemarmor = (ItemArmor) itemstack.getItem();
			ModelBase t = this.getArmorModel(p_renderLayer_9_);

			t.setModelAttributes(this.renderer.getMainModel());
			t.setLivingAnimations(p_renderLayer_1_, p_renderLayer_2_, p_renderLayer_3_, p_renderLayer_4_);
			t = this.getArmorModelHook(p_renderLayer_1_, itemstack, p_renderLayer_9_, t);
			this.setModelPartVisible(t, p_renderLayer_9_);
			boolean flag = this.isSlotForLeggings(p_renderLayer_9_);

			this.renderer.bindTexture(this.getArmorResource(p_renderLayer_1_, itemstack, flag ? 2 : 1, (String) null));
			Teams teams = (Teams) Client.getModuleManager().getModuleByClass(Teams.class);
			alpha = teams.transperentBool(p_renderLayer_1_) ? 0.1F : 1.0f;
			float alpha = teams.transperentBool(p_renderLayer_1_) ? 0.1F : 1.0f;
			int i = itemarmor.getColor(itemstack);

			if (i != -1) {
				float f = (float) (i >> 16 & 255) / 255.0F;
				float f1 = (float) (i >> 8 & 255) / 255.0F;
				float f2 = (float) (i & 255) / 255.0F;

				GlStateManager.color(this.colorR * f, this.colorG * f1, this.colorB * f2, this.alpha);
				GlStateManager.pushMatrix();
				GlStateManager.color(1.0F, 1.0F, 1.0F, alpha);
				GlStateManager.depthMask(false);
				GlStateManager.enableBlend();
				GlStateManager.blendFunc(770, 771);
				GlStateManager.alphaFunc(516, 0.003921569F);
				t.render(p_renderLayer_1_, p_renderLayer_2_, p_renderLayer_3_, p_renderLayer_5_, p_renderLayer_6_,
						p_renderLayer_7_, p_renderLayer_8_);
				GlStateManager.disableBlend();
				GlStateManager.alphaFunc(516, 0.1F);
				GlStateManager.popMatrix();
				GlStateManager.depthMask(true);
				this.renderer.bindTexture(this.getArmorResource(p_renderLayer_1_, itemstack, flag ? 2 : 1, "overlay"));
			}

			 GlStateManager.color(this.colorR, this.colorG, this.colorB, this.alpha);
			if (p_renderLayer_1_.equals(Minecraft.getMinecraft().thePlayer)) {
				t.render(p_renderLayer_1_, p_renderLayer_2_, p_renderLayer_3_, p_renderLayer_5_, p_renderLayer_6_,
						p_renderLayer_7_, p_renderLayer_8_);
			} else {
				t.render(p_renderLayer_1_, p_renderLayer_2_, p_renderLayer_3_, p_renderLayer_5_, p_renderLayer_6_,
						p_renderLayer_7_, p_renderLayer_8_);
			}

			if (itemstack.hasEffect()) {
				this.renderGlint(p_renderLayer_1_, t, p_renderLayer_2_, p_renderLayer_3_, p_renderLayer_4_,
						p_renderLayer_5_, p_renderLayer_6_, p_renderLayer_7_, p_renderLayer_8_);
			}
		}
	}
}
