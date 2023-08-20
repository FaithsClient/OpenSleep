package linxiu.injection.mixins;

import linxiu.Client;
import linxiu.api.EventBus;
import linxiu.api.events.rendering.RLEEvent;
import linxiu.injection.interfaces.IEntityLivingBase;
import linxiu.injection.interfaces.IRendererLivingEntity;
import linxiu.management.ModuleManager;
import linxiu.module.modules.combat.KillAura;
import linxiu.module.modules.megawalls.Nuker;
import linxiu.module.modules.movement.Scaffold;
import linxiu.module.modules.player.Teams;
import linxiu.module.modules.render.Nametags;
import linxiu.module.modules.uhc.BowAimBot;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraftforge.client.event.RenderLivingEvent.Post;
import net.minecraftforge.client.event.RenderLivingEvent.Pre;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.Event;

import java.util.Objects;

import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(RendererLivingEntity.class)
public abstract class MixinRendererLivingEntity<T extends EntityLivingBase> extends MixinRender
		implements IRendererLivingEntity {

	@Inject(method = "canRenderName", at = @At("HEAD"), cancellable = true)
	private <T extends EntityLivingBase> void canRenderName(T entity,
			CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
		if (ModuleManager.getModuleByClass(Nametags.class).isEnabled())
			callbackInfoReturnable.setReturnValue(entity == Minecraft.getMinecraft().thePlayer);
	}

	@Shadow
	protected boolean renderOutlines = false;
	@Shadow
	protected ModelBase mainModel;
	@Shadow
	@Final
	private static Logger logger;

	@Shadow
	protected abstract float interpolateRotation(float par1, float par2, float par3);

	@Shadow
	protected abstract float getSwingProgress(T livingBase, float partialTickTime);

	@Shadow
	protected abstract void renderLivingAt(T entityLivingBaseIn, double x, double y, double z);

	@Shadow
	protected abstract void rotateCorpse(T bat, float p_77043_2_, float p_77043_3_, float partialTicks);

	@Shadow
	protected abstract float handleRotationFloat(T livingBase, float partialTicks);

	@Shadow
	protected abstract void preRenderCallback(T entitylivingbaseIn, float partialTickTime);

	@Shadow
	protected abstract boolean setScoreTeamColor(EntityLivingBase entityLivingBaseIn);

	@Shadow
	protected abstract void unsetScoreTeamColor();

	@Shadow
	protected abstract void renderLayers(T entitylivingbaseIn, float p_177093_2_, float p_177093_3_, float partialTicks,
			float p_177093_5_, float p_177093_6_, float p_177093_7_, float p_177093_8_);

	@Shadow
	protected abstract boolean setDoRenderBrightness(T entityLivingBaseIn, float partialTicks);

	@Shadow
	protected abstract void unsetBrightness();

	public void doRenderModel(Object entitylivingbaseIn, float a, float b, float c, float d, float e,
			float scaleFactor) {
		this.renderModel((T) entitylivingbaseIn, a, b, c, d, e, scaleFactor);
	}

	public void doRenderLayers(Object entitylivingbaseIn, float a, float b, float partialTicks, float d, float e,
			float f, float g) {
		this.renderLayers((T) entitylivingbaseIn, a, b, partialTicks, d, e, f, g);
	}

	@Overwrite
	protected void renderModel(T entitylivingbaseIn, float p_77036_2_, float p_77036_3_, float p_77036_4_,
			float p_77036_5_, float p_77036_6_, float p_77036_7_) {
		boolean flag = !entitylivingbaseIn.isInvisible();
		boolean flag1 = !flag && !entitylivingbaseIn.isInvisibleToPlayer(Minecraft.getMinecraft().thePlayer);
		if (flag || flag1) {
			if (!this.bindEntityTexture(entitylivingbaseIn)) {
				return;
			}

			Teams teams = (Teams) Client.INSTANCE.getModuleManager().getModuleByClass(Teams.class);

			if (flag1 || teams.transperentBool(entitylivingbaseIn)) {
				GlStateManager.pushMatrix();
				GlStateManager.color(1.0F, 1.0F, 1.0F, 0.15F);
				GlStateManager.depthMask(false);
				GlStateManager.enableBlend();
				GlStateManager.blendFunc(770, 771);
				GlStateManager.alphaFunc(516, 0.003921569F);
			}

			this.mainModel.render(entitylivingbaseIn, p_77036_2_, p_77036_3_, p_77036_4_, p_77036_5_, p_77036_6_,
					p_77036_7_);

			if (flag1 || teams.transperentBool(entitylivingbaseIn)) {
				GlStateManager.disableBlend();
				GlStateManager.alphaFunc(516, 0.1F);
				GlStateManager.popMatrix();
				GlStateManager.depthMask(true);
			}
		}
	}

	/**
	 * @author
	 * @reason can't inject
	 */
	@Overwrite
	public void doRender(T entity, double x, double y, double z, float entityYaw, float partialTicks) {
		boolean shouldSit;
		if (MinecraftForge.EVENT_BUS.post((Event) new Pre(entity, (RendererLivingEntity) (Object) this, x, y, z))) {
			return;
		}
		GlStateManager.pushMatrix();
		GlStateManager.disableCull();
		this.mainModel.swingProgress = this.getSwingProgress(entity, partialTicks);
		this.mainModel.isRiding = shouldSit = entity.isRiding() && entity.ridingEntity != null
				&& entity.ridingEntity.shouldRiderSit();
		this.mainModel.isChild = entity.isChild();

		try {
			float f = this.interpolateRotation(entity.prevRenderYawOffset, entity.renderYawOffset, partialTicks);
			float f1 = this.interpolateRotation(entity.prevRotationYawHead, entity.rotationYawHead, partialTicks);
			float f8 = entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * partialTicks;
			float f2 = f1 - f;
			if (shouldSit && entity.ridingEntity instanceof EntityLivingBase) {
				float f3;
				EntityLivingBase entitylivingbase = (EntityLivingBase) entity.ridingEntity;
				f = this.interpolateRotation(entitylivingbase.prevRenderYawOffset, entitylivingbase.renderYawOffset,
						partialTicks);
				if ((f3 = MathHelper.wrapAngleTo180_float(f2 = f1 - f)) < -85.0f) {
					f3 = -85.0f;
				}
				if (f3 >= 85.0f) {
					f3 = 85.0f;
				}
				f = f1 - f3;
				if (f3 * f3 > 2500.0f) {
					f += f3 * 0.2f;
				}
			}

			KillAura aura = (KillAura) ModuleManager.getModuleByClass(KillAura.class);
			if (aura.isEnabled()) {
				if (!Objects.equals(aura.rotateMode.getValue(), "None") && KillAura.target != null) {
					if (Objects.equals(aura.rotateMode.getValue(), "Zenith") || Objects.equals(aura.rotateMode.getValue(), "Zeriy")) {
						if (entity instanceof EntityPlayerSP) {
							float YAW = entity.rotationYawHead;
							float PITCH = ((IEntityLivingBase) entity).getrotationPitchHead();
							float PREVYAW = entity.prevRotationYawHead;
							float PREVPITCH = ((IEntityLivingBase) entity).getprevRotationPitchHead();
							float targetBody = f1 - f;
							if (Objects.equals(aura.renderMode.getValue(), "Astolfo")) {
								if (aura.isVisibleFOV(aura.target, 100)) {
									f = this.interpolateRotation(PREVYAW, YAW, partialTicks);
								}
							} else if (!aura.HeadValue.getValue()) {
								f = this.interpolateRotation(PREVYAW, YAW, partialTicks);
							}

							if (Objects.equals(KillAura.renderMode.getValue(), "Zenith")) {
								float renderYaw = this.interpolateRotation(PREVYAW, YAW, partialTicks) - f;
								float renderPitch = this.interpolateRotation(PREVPITCH, PITCH, partialTicks);
								f2 = renderYaw;
								f8 = renderPitch;
							} else {
								float renderYaw = this.interpolateRotation(PREVYAW, YAW, partialTicks) - f;
								float renderPitch = this.interpolateRotation(PREVPITCH, PITCH, partialTicks);
								f2 = renderYaw;
								f8 = renderPitch;
							}
						}
					}
				}
			}

			if (aura.isEnabled()) {
				if (!Objects.equals(aura.rotateMode.getValue(), "None") && KillAura.target != null) {
					if (Objects.equals(aura.rotateMode.getValue(), "Smart") && aura.isVisibleFOV(aura.target, 100)
							&& KillAura.target != null) {
						if (entity instanceof EntityPlayerSP) {
							float YAW = entity.rotationYawHead;
							float PITCH = ((IEntityLivingBase) entity).getrotationPitchHead();
							float PREVYAW = entity.prevRotationYawHead;
							float PREVPITCH = ((IEntityLivingBase) entity).getprevRotationPitchHead();
							float targetBody = f1 - f;
							if (!aura.HeadValue.getValue()) {
								f = this.interpolateRotation(PREVYAW, YAW, partialTicks);
							}
							float renderYaw = this.interpolateRotation(PREVYAW, YAW, partialTicks) - f;
							float renderPitch = this.interpolateRotation(PREVPITCH, PITCH, partialTicks);
							f2 = renderYaw;
							f8 = renderPitch;
						}
					}
				}
			}

			if (ModuleManager.getModuleByClass(Nuker.class).isEnabled()) {
				if (entity instanceof EntityPlayerSP) {
					float YAW = entity.rotationYawHead;
					float PITCH = ((IEntityLivingBase) entity).getrotationPitchHead();
					float PREVYAW = entity.prevRotationYawHead;
					float PREVPITCH = ((IEntityLivingBase) entity).getprevRotationPitchHead();
					f = this.interpolateRotation(PREVYAW, YAW, partialTicks);
					float renderYaw = this.interpolateRotation(PREVYAW, YAW, partialTicks) - f;
					float renderPitch = this.interpolateRotation(PREVPITCH, PITCH, partialTicks);
					f2 = renderYaw;
					f8 = renderPitch;
				}
			}

			if (ModuleManager.getModuleByClass(Scaffold.class).isEnabled()) {
				if (entity instanceof EntityPlayerSP) {
					float YAW = entity.rotationYawHead;
					float PITCH = ((IEntityLivingBase) entity).getrotationPitchHead();
					float PREVYAW = entity.prevRotationYawHead;
					float PREVPITCH = ((IEntityLivingBase) entity).getprevRotationPitchHead();
					f = this.interpolateRotation(PREVYAW, YAW, partialTicks);
					float renderYaw = this.interpolateRotation(PREVYAW, YAW, partialTicks) - f;
					float renderPitch = this.interpolateRotation(PREVPITCH, PITCH, partialTicks);
					f2 = renderYaw;
					f8 = renderPitch;
				}
			}

			BowAimBot bowAimBot = (BowAimBot) ModuleManager.getModuleByClass(BowAimBot.class);
			if (bowAimBot.isEnabled()) {
				if (entity instanceof EntityPlayerSP) {
					float YAW = entity.rotationYawHead;
					float PITCH = ((IEntityLivingBase) entity).getrotationPitchHead();
					float PREVYAW = entity.prevRotationYawHead;
					float PREVPITCH = ((IEntityLivingBase) entity).getprevRotationPitchHead();
					if (bowAimBot.isUsing(Minecraft.getMinecraft().thePlayer)) {
						f = this.interpolateRotation(PREVYAW, YAW, partialTicks);
					}
					float renderYaw = this.interpolateRotation(PREVYAW, YAW, partialTicks) - f;
					float renderPitch = this.interpolateRotation(PREVPITCH, PITCH, partialTicks);
					if (bowAimBot.isUsing(Minecraft.getMinecraft().thePlayer)) {
						f2 = renderYaw;
						f8 = renderPitch;
					}
				}
			}

			renderLivingAt(entity, x, y, z);
			float f7 = this.handleRotationFloat(entity, partialTicks);
			float f4 = 0.0625F;
			float f5 = entity.prevLimbSwingAmount
					+ (entity.limbSwingAmount - entity.prevLimbSwingAmount) * partialTicks;
			float f6 = entity.limbSwing - entity.limbSwingAmount * (1.0F - partialTicks);
			boolean flag = this.setDoRenderBrightness(entity, partialTicks);

			rotateCorpse(entity, f7, f, partialTicks);
			GlStateManager.enableRescaleNormal();
			GlStateManager.scale(-1.0F, -1.0F, 1.0F);
			preRenderCallback(entity, partialTicks);
			GlStateManager.translate(0.0F, -1.5078125F, 0.0F);

			if (entity instanceof EntityPlayer) {
				RLEEvent rleEvent = new RLEEvent(entity, f6, f5, f7, f2, f8, f, 0.0625F, partialTicks);
				EventBus.getInstance().call(rleEvent);
				if (rleEvent.isCancelled())
					return;
			}

			if (entity.isChild())
				f6 *= 3.0F;

			if (f5 > 1.0F)
				f5 = 1.0F;

			GlStateManager.enableAlpha();
			this.mainModel.setLivingAnimations(entity, f6, f5, partialTicks);
			this.mainModel.setRotationAngles(f6, f5, f7, f2, f8, 0.0625F, entity);

			if (this.renderOutlines) {
				boolean flag1 = setScoreTeamColor(entity);
				renderModel(entity, f6, f5, f7, f2, f8, 0.0625F);

				if (flag1)
					unsetScoreTeamColor();
			} else {
				renderModel(entity, f6, f5, f7, f2, f8, 0.0625F);
				if (flag)
					unsetBrightness();

				GlStateManager.depthMask(true);

				if (!(entity instanceof EntityPlayer) || !((EntityPlayer) entity).isSpectator()) {
					renderLayers(entity, f6, f5, partialTicks, f7, f2, f8, 0.0625F);
				}
			}

			GlStateManager.disableRescaleNormal();

		} catch (

		Exception exception) {
			logger.error("Couldn't render entity", exception);
		}

		GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
		GlStateManager.enableTexture2D();
		GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
		GlStateManager.enableCull();
		GlStateManager.popMatrix();

		if (entity instanceof EntityPlayer) {
			RLEEvent rleEvent = new RLEEvent(entity);
			EventBus.getInstance().call(rleEvent);
		}

		if (!this.renderOutlines) {
			super.doRender(entity, x, y, z, entityYaw, partialTicks);
		}
		MinecraftForge.EVENT_BUS.post((Event) new Post(entity, (RendererLivingEntity) (Object) this, x, y, z));
	}

}
