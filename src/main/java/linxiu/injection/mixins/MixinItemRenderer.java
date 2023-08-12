/*
 * FDPClient Hacked Client
 * A free open source mixin-based injection hacked client for Minecraft using Minecraft Forge by LiquidBounce.
 * https://github.com/UnlegitMC/FDPClient/
 */
package linxiu.injection.mixins;

import linxiu.management.ModuleManager;
import linxiu.module.modules.combat.KillAura;
import linxiu.module.modules.render.Animations;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemMap;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ItemRenderer.class)
public abstract class MixinItemRenderer {
	@Shadow
	private float prevEquippedProgress;

	@Shadow
	private float equippedProgress;

	@Shadow
	@Final
	private Minecraft mc;

	@Shadow
	protected abstract void rotateArroundXAndY(float angle, float angleY);

	@Shadow
	protected abstract void setLightMapFromPlayer(AbstractClientPlayer clientPlayer);

	@Shadow
	protected abstract void rotateWithPlayerRotations(EntityPlayerSP entityPlayerSP, float partialTicks);

	@Shadow
	private ItemStack itemToRender;

	@Shadow
	protected abstract void renderItemMap(AbstractClientPlayer clientPlayer, float pitch, float equipmentProgress,
			float swingProgress);

	@Shadow
	protected abstract void performDrinking(AbstractClientPlayer clientPlayer, float partialTicks);

	@Shadow
	protected abstract void doBlockTransformations();

	@Shadow
	protected abstract void doBowTransformations(float partialTicks, AbstractClientPlayer clientPlayer);

	@Shadow
	protected abstract void doItemUsedTransformations(float swingProgress);

	@Shadow
	public abstract void renderItem(EntityLivingBase entityIn, ItemStack heldStack,
			ItemCameraTransforms.TransformType transform);

	@Shadow
	protected abstract void renderPlayerArm(AbstractClientPlayer clientPlayer, float equipProgress,
			float swingProgress);

	/**
	 * @author Liuli
	 * @reason can't inject
	 */
	@Overwrite
	private void transformFirstPersonItem(float equipProgress, float swingProgress) {
		doItemRenderGLTranslate();
		GlStateManager.translate(0.0F, equipProgress * -0.6F, 0.0F);
		GlStateManager.rotate(45.0F, 0.0F, 1.0F, 0.0F);
		float f = MathHelper.sin(swingProgress * swingProgress * 3.1415927F);
		float f1 = MathHelper.sin(MathHelper.sqrt_float(swingProgress) * 3.1415927F);
		GlStateManager.rotate(f * -20.0F, 0.0F, 1.0F, 0.0F);
		GlStateManager.rotate(f1 * -20.0F, 0.0F, 0.0F, 1.0F);
		GlStateManager.rotate(f1 * -80.0F, 1.0F, 0.0F, 0.0F);
		doItemRenderGLScale();
	}

	private void doItemRenderGLTranslate() {
		GlStateManager.translate(0.56F, -0.52F, -0.71999997F);
	}

	private void doItemRenderGLScale() {
		GlStateManager.scale(0.4f, 0.4f, 0.4f);
	}

	private void sigmaOld(float f) {
		doItemRenderGLTranslate();
		GlStateManager.translate(0.0F, f * -0.6F, 0.0F);
		GlStateManager.rotate(45.0F, 0.0F, 1.0F, 0.0F);
		GlStateManager.rotate(0F, 0.0F, 1.0F, 0.2F);
		GlStateManager.rotate(0F, 0.2F, 0.1F, 1.0F);
		GlStateManager.rotate(0F, 1.3F, 0.1F, 0.2F);
		doItemRenderGLScale();
	}

	// methods in LiquidBounce b73 Animation-No-Cross
	private void avatar(float swingProgress) {
		doItemRenderGLTranslate();
		GlStateManager.translate(0.0F, 0.0F, 0.0F);
		GlStateManager.rotate(45.0F, 0.0F, 1.0F, 0.0F);
		float f = MathHelper.sin(swingProgress * swingProgress * 3.1415927F);
		float f2 = MathHelper.sin(MathHelper.sqrt_float(swingProgress) * 3.1415927F);
		GlStateManager.rotate(f * -20.0F, 0.0F, 1.0F, 0.0F);
		GlStateManager.rotate(f2 * -20.0F, 0.0F, 0.0F, 1.0F);
		GlStateManager.rotate(f2 * -40.0F, 1.0F, 0.0F, 0.0F);
		doItemRenderGLScale();
	}

	private void slide(float var9) {
		doItemRenderGLTranslate();
		GlStateManager.translate(0.0F, 0.0F, 0.0F);
		GlStateManager.rotate(45.0F, 0.0F, 1.0F, 0.0F);
		float var11 = MathHelper.sin(var9 * var9 * 3.1415927F);
		float var12 = MathHelper.sin(MathHelper.sqrt_float(var9) * 3.1415927F);
		GlStateManager.rotate(var11 * 0.0F, 0.0F, 1.0F, 0.0F);
		GlStateManager.rotate(var12 * 0.0F, 0.0F, 0.0F, 1.0F);
		GlStateManager.rotate(var12 * -40.0F, 1.0F, 0.0F, 0.0F);
		doItemRenderGLScale();
	}

	private void rotateSword(float f1) {
		genCustom(0.0F, 0.0F);
		doBlockTransformations();
		GlStateManager.translate(-0.5F, 0.2F, 0.0F);
		GlStateManager.rotate(MathHelper.sqrt_float(f1) * 10.0F * 40.0F, 1.0F, -0.0F, 2.0F);
	}

	private void genCustom(float p_178096_1_, float p_178096_2_) {
		GlStateManager.translate(0.56F, -0.52F, -0.71999997F);
		GlStateManager.translate(0.0F, p_178096_1_ * -0.6F, 0.0F);
		GlStateManager.rotate(45.0F, 0.0F, 1.0F, 0.0F);
		float var3 = MathHelper.sin(p_178096_2_ * p_178096_2_ * 3.1415927F);
		float var4 = MathHelper.sin(MathHelper.sqrt_float(p_178096_2_) * 3.1415927F);
		GlStateManager.rotate(var3 * -34.0F, 0.0F, 1.0F, 0.2F);
		GlStateManager.rotate(var4 * -20.7F, 0.2F, 0.1F, 1.0F);
		GlStateManager.rotate(var4 * -68.6F, 1.3F, 0.1F, 0.2F);
		GlStateManager.scale(0.4F, 0.4F, 0.4F);
	}

	private void jello(float var12) {
		doItemRenderGLTranslate();
		GlStateManager.rotate(48.57F, 0.0F, 0.24F, 0.14F);
		float var13 = MathHelper.sin(var12 * var12 * 3.1415927F);
		float var14 = MathHelper.sin(MathHelper.sqrt_float(var12) * 3.1415927F);
		GlStateManager.rotate(var13 * -35.0F, 0.0F, 0.0F, 0.0F);
		GlStateManager.rotate(var14 * 0.0F, 0.0F, 0.0F, 0.0F);
		GlStateManager.rotate(var14 * 20.0F, 1.0F, 1.0F, 1.0F);
		doItemRenderGLScale();
	}

	private void continuity(float var10) {
		doItemRenderGLTranslate();
		GlStateManager.translate(0.0F, 0.0F, 0.0F);
		GlStateManager.rotate(45.0F, 0.0F, 1.0F, 0.0F);
		float var12 = -MathHelper.sin(var10 * var10 * 3.1415927F);
		float var13 = MathHelper.cos(MathHelper.sqrt_float(var10) * 3.1415927F);
		float var14 = MathHelper.abs(MathHelper.sqrt_float((float) 0.1) * 3.1415927F);
		GlStateManager.rotate(var12 * var14 * 30.0F, 0.0F, 1.0F, 0.0F);
		GlStateManager.rotate(var13 * 0.0F, 0.0F, 0.0F, 1.0F);
		GlStateManager.rotate(var13 * 20.0F, 1.0F, 0.0F, 0.0F);
		doItemRenderGLScale();
	}

	public void sigmaNew(float var22, float var23) {
		doItemRenderGLTranslate();
		GlStateManager.rotate(45.0F, 0.0F, 1.0F, 0.0F);
		float var24 = MathHelper.sin(var23 * MathHelper.sqrt_float(var22) * 3.1415927F);
		float var25 = MathHelper.abs(MathHelper.sqrt_double(var22) * 3.1415927F);
		GlStateManager.rotate(var24 * 20.0F * var25, 0.0F, 1.0F, 1.0F);
		doItemRenderGLScale();
	}

	private void etb(float equipProgress, float swingProgress) {
		doItemRenderGLTranslate();
		GlStateManager.translate(0.0F, equipProgress * -0.6F, 0.0F);
		GlStateManager.rotate(45.0F, 0.0F, 1.0F, 0.0F);
		float var3 = MathHelper.sin(swingProgress * swingProgress * 3.1415927F);
		float var4 = MathHelper.sin(MathHelper.sqrt_float(swingProgress) * 3.1415927F);
		GlStateManager.rotate(var3 * -34.0F, 0.0F, 1.0F, 0.2F);
		GlStateManager.rotate(var4 * -20.7F, 0.2F, 0.1F, 1.0F);
		GlStateManager.rotate(var4 * -68.6F, 1.3F, 0.1F, 0.2F);
		doItemRenderGLScale();
	}

	private void push(float idc) {
		doItemRenderGLTranslate();
		GlStateManager.translate(0.0F, (float) 0.1 * -0.6F, 0.0F);
		GlStateManager.rotate(45.0F, 0.0F, 1.0F, 0.0F);
		float var3 = MathHelper.sin(idc * idc * 3.1415927F);
		float var4 = MathHelper.sin(MathHelper.sqrt_float(idc) * 3.1415927F);
		GlStateManager.rotate(var3 * -10.0F, 1.0F, 1.0F, 1.0F);
		GlStateManager.rotate(var4 * -10.0F, 1.0F, 1.0F, 1.0F);
		GlStateManager.rotate(var4 * -10.0F, 1.0F, 1.0F, 1.0F);
		doItemRenderGLScale();
	}

	/**
	 * @author
	 * @reason can't inject
	 */
	@Overwrite
	public void renderItemInFirstPerson(float partialTicks) {

		float f = 1.0F
				- (this.prevEquippedProgress + (this.equippedProgress - this.prevEquippedProgress) * partialTicks);
		AbstractClientPlayer abstractclientplayer = this.mc.thePlayer;
		float f1 = abstractclientplayer.getSwingProgress(partialTicks);
		float f2 = abstractclientplayer.prevRotationPitch
				+ (abstractclientplayer.rotationPitch - abstractclientplayer.prevRotationPitch) * partialTicks;
		float f3 = abstractclientplayer.prevRotationYaw
				+ (abstractclientplayer.rotationYaw - abstractclientplayer.prevRotationYaw) * partialTicks;
		this.rotateArroundXAndY(f2, f3);
		this.setLightMapFromPlayer(abstractclientplayer);
		this.rotateWithPlayerRotations((EntityPlayerSP) abstractclientplayer, partialTicks);
		GlStateManager.enableRescaleNormal();
		GlStateManager.pushMatrix();

		final boolean auraBlock = KillAura.autoBlockValue.getValue() && KillAura.target != null;

		Animations am = (Animations) ModuleManager.getModuleByClass(Animations.class);
		if (this.itemToRender != null) {
			if (this.itemToRender.getItem() instanceof ItemMap) {
				this.renderItemMap(abstractclientplayer, f2, f, f1);
			} else if (abstractclientplayer.getItemInUseCount() > 0 || KillAura.blocking) {
				EnumAction enumaction = this.itemToRender.getItemUseAction();

				if (auraBlock) {
					enumaction = EnumAction.BLOCK;
				}

				float var15 = MathHelper.sin(f1 * f1 * 3.1415927F);
				switch (enumaction) {
				case NONE:
					this.transformFirstPersonItem(f, 0.0F);
					break;

				case EAT:
				case DRINK:
					this.performDrinking(abstractclientplayer, partialTicks);
					this.transformFirstPersonItem(f, am.isEnabled() ? f1 : 0.0F);
					break;

				case BLOCK:
					if (ModuleManager.getModuleByClass(Animations.class).isEnabled()) {
						GL11.glTranslated(am.posX.getValue().doubleValue(), am.posY.getValue().doubleValue(), am.posZ.getValue().doubleValue());
						switch (am.modeValue.getValue()) {
						case "Stella":
							this.transformFirstPersonItem(-0.1F, f1);
							GlStateManager.translate(-0.5F, 0.4F, -0.2F);
							GlStateManager.rotate(32, 0, 1, 0);
							GlStateManager.rotate(-70, 1, 0, 0);
							GlStateManager.rotate(40, 0, 1, 0);
							break;
						case "Fathum":
							GlStateManager.translate(0, 0.18F, 0);
							this.transformFirstPersonItem(f / 2.0F, f1);
							this.doBlockTransformations();
							break;
						case "Swing":
							GlStateManager.translate(0, 0.02F, 0);
							this.transformFirstPersonItem(f / 2.0f, f1);
							this.doBlockTransformations();
							break;
						case "Vanilla":
							this.transformFirstPersonItem(f, 0.0f);
							this.doBlockTransformations();
							break;
						case "Old":
							this.transformFirstPersonItem(f, f1);
							this.doBlockTransformations();
							break;
						case "Smooth":
							this.transformFirstPersonItem(f1 / 5, f1);
							GlStateManager.translate(0, 0.2, 0);
							GlStateManager.rotate(-var15, 4, -0.8F, -1F);
							this.doBlockTransformations();
							break;
						case "Exhi":
							this.transformFirstPersonItem(f / 2, 0);
							GlStateManager.rotate(-var15 * 40.0F / 2.0F, var15 / 2.0F, -0.0F, 9.0F);
							GlStateManager.rotate(-var15 * 30.0F, 1.0F, var15 / 2.0F, -0.0F);
							this.doBlockTransformations();
							GL11.glTranslatef(-0.05F, this.mc.thePlayer.isSneaking() ? -0.2F : 0.0F, 0.1F);
							break;
						case "Exhi2":
							this.transformFirstPersonItem(f / 2, f1);
							var15 = MathHelper.sin(MathHelper.sqrt_float(f1) * 3.1415927F);
							GlStateManager.rotate(var15 * 30.0F, -var15, -0.0F, 9.0F);
							GlStateManager.rotate(var15 * 40.0F, 1.0F, -var15, -0.0F);
							this.doBlockTransformations();
							GL11.glTranslatef(-0.05F, this.mc.thePlayer.isSneaking() ? -0.2F : 0.0F, 0.1F);
							break;
						case "Shred":
							this.transformFirstPersonItem(f / 2, f1);
							var15 = MathHelper.sin(f1 * f1 * 3.1415927F);

							GlStateManager.rotate(var15 * 30.0F / 2.0F, -var15, -0.0F, 9.0F);
							GlStateManager.rotate(var15 * 40.0F, 1.0F, -var15 / 2.0F, -0.0F);
							this.doBlockTransformations();
							GL11.glTranslatef(-0.05F, this.mc.thePlayer.isSneaking() ? -0.2F : 0.0F, 0.1F);
							break;
						case "Sigma":
							this.transformFirstPersonItem(f * 0.5f, 0);
							GlStateManager.rotate(-var15 * 55 / 2.0F, -8.0F, -0.0F, 9.0F);
							GlStateManager.rotate(-var15 * 45, 1.0F, var15 / 2, -0.0F);
							this.doBlockTransformations();
							GL11.glTranslated(1.2, 0.3, 0.5);
							GL11.glTranslatef(-1, this.mc.thePlayer.isSneaking() ? -0.1F : -0.2F, 0.2F);
							break;
						}
					} else {
						this.transformFirstPersonItem(f, 0.0F);
						this.doBlockTransformations();
					}
					break;

				case BOW:
					this.transformFirstPersonItem(f, 0.0F);
					this.doBowTransformations(partialTicks, abstractclientplayer);
				}
			} else {
				this.doItemUsedTransformations(f1);
				this.transformFirstPersonItem(f, f1);
			}
			this.renderItem(abstractclientplayer, this.itemToRender, ItemCameraTransforms.TransformType.FIRST_PERSON);
		} else if (!abstractclientplayer.isInvisible()) {
			this.renderPlayerArm(abstractclientplayer, f, f1);
		}
		GlStateManager.popMatrix();
		GlStateManager.disableRescaleNormal();
		RenderHelper.disableStandardItemLighting();
	}
}
