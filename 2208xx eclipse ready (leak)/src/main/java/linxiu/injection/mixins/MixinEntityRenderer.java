package linxiu.injection.mixins;

import com.google.common.base.Predicates;
import com.google.gson.JsonSyntaxException;
import linxiu.api.EventBus;
import linxiu.api.events.rendering.EventRender3D;
import linxiu.injection.interfaces.IEntity;
import linxiu.injection.interfaces.IEntityRenderer;
import linxiu.management.ModuleManager;
import linxiu.module.modules.ghost.Hitbox;
import linxiu.module.modules.ghost.Reach;
import linxiu.module.modules.megawalls.AntiDisplayFucker;
import linxiu.module.modules.megawalls.BlockHitbox;
import linxiu.module.modules.megawalls.MwHelper;
import linxiu.module.modules.render.ViewClip;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBed;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.*;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.shader.ShaderGroup;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraft.util.*;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;
import net.minecraftforge.client.ForgeHooksClient;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Project;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.IOException;
import java.nio.FloatBuffer;
import java.util.List;

@Mixin(EntityRenderer.class)
public abstract class MixinEntityRenderer implements IEntityRenderer {
	@Shadow
	private float fogColor2;
	@Shadow
	private float fogColor1;
	@Shadow
	public static int shaderCount;

	@Shadow
	public ItemRenderer itemRenderer;
	@Shadow
	private static Logger logger;
	@Shadow
	private final float thirdPersonDistance = 4.0F;
	@Shadow
	private final float thirdPersonDistanceTemp = 4.0F;
	@Shadow
	private int rendererUpdateCount;
	@Shadow
	private final FloatBuffer fogColorBuffer = GLAllocation.createDirectFloatBuffer(16);
	@Shadow
	private boolean cloudFog;
	@Shadow
	private int debugViewDirection = 0;
	@Shadow
	private boolean debugView = false;
	@Shadow
	private double cameraZoom = 1.0D;
	@Shadow
	private double cameraYaw;
	@Shadow
	private double cameraPitch;
	@Shadow
	private Minecraft mc;
	@Shadow
	private Entity pointedEntity;
	@Shadow
	private int shaderIndex;
	@Shadow
	private boolean useShader;
	@Shadow
	private ShaderGroup theShaderGroup;
	@Shadow
	private IResourceManager resourceManager;
	@Shadow
	private float fogColorRed;
	@Shadow
	private float fogColorGreen;
	@Shadow
	private float fogColorBlue;
	@Shadow
	private float farPlaneDistance;
	@Shadow
	private float fovModifierHandPrev;
	@Shadow
	private float bossColorModifier;
	@Shadow
	private float fovModifierHand;
	@Shadow
	private float bossColorModifierPrev;

	@Shadow
	protected abstract void loadShader(ResourceLocation resourceLocationIn);

	@Shadow
	protected abstract void disableLightmap();

	@Shadow
	protected abstract void enableLightmap();

	@Shadow
	protected abstract FloatBuffer setFogColorBuffer(float red, float green, float blue, float alpha);

	public void runSetupCameraTransform(float partialTicks, int pass) {
		this.setupCameraTransform(partialTicks, pass);
	}

	@Shadow
	protected abstract float getFOVModifier(float partialTicks, boolean useFOVSetting);

	@Shadow
	protected abstract void hurtCameraEffect(float partialTicks);

	@Shadow
	protected abstract void setupViewBobbing(float partialTicks);

	@Shadow
	protected abstract float getNightVisionBrightness(EntityLivingBase entitylivingbaseIn, float partialTicks);

	public void removeEntities(List<Entity> list) {
		if (ModuleManager.getModuleByClass(BlockHitbox.class).isEnabled())
			list.removeIf(BlockHitbox::shouldHitThrough);
	}

	/**
	 * @author
	 * @reason can't inject
	 */
	@Overwrite
	public void getMouseOver(float p_getMouseOver_1_) {
		Entity entity = this.mc.getRenderViewEntity();
		if (entity != null && this.mc.theWorld != null) {
			this.mc.mcProfiler.startSection("pick");
			this.mc.pointedEntity = null;
			double d0 = ModuleManager.getModuleByName("Reach").isEnabled() ? Reach.getReach()
					: (double) this.mc.playerController.getBlockReachDistance();
			this.mc.objectMouseOver = entity.rayTrace(
					ModuleManager.getModuleByName("Reach").isEnabled() ? Reach.getReach() : d0, p_getMouseOver_1_);
			double d1 = d0;
			Vec3 vec3 = entity.getPositionEyes(p_getMouseOver_1_);
			boolean flag = false;
			if (this.mc.playerController.extendedReach()) {
				d0 = 6.0D;
				d1 = 6.0D;
			} else if (d0 > 3.0D) {
				flag = true;
			}

			if (this.mc.objectMouseOver != null) {
				d1 = this.mc.objectMouseOver.hitVec.distanceTo(vec3);
			}

			if (ModuleManager.getModuleByName("Reach").isEnabled()) {
				d1 = Reach.getReach();
				MovingObjectPosition vec31 = entity.rayTrace(d1, p_getMouseOver_1_);
				if (vec31 != null) {
					d1 = vec31.hitVec.distanceTo(vec3);
				}
			}

			Vec3 var24 = entity.getLook(p_getMouseOver_1_);
			Vec3 vec32 = vec3.addVector(var24.xCoord * d0, var24.yCoord * d0, var24.zCoord * d0);
			this.pointedEntity = null;
			Vec3 vec33 = null;
			float f = 1.0F;
			List list = this.mc.theWorld.getEntitiesInAABBexcluding(
					entity, entity.getEntityBoundingBox()
							.addCoord(var24.xCoord * d0, var24.yCoord * d0, var24.zCoord * d0).expand(f, f, f),
					Predicates.and(EntitySelectors.NOT_SPECTATING, (p_apply_1_) -> {
						return p_apply_1_.canBeCollidedWith();
					}));
			double d2 = d1;
			removeEntities(list);
			for (int j = 0; j < list.size(); ++j) {
				Entity entity1 = (Entity) list.get(j);
				float f1 = entity1.getCollisionBorderSize();
				double kms = Hitbox.exp(entity1);
				AxisAlignedBB axisalignedbb = entity1.getEntityBoundingBox().expand(f1, f1, f1).expand(kms,
						Hitbox.vertical.getValue() ? kms : 0, kms);
				MovingObjectPosition movingobjectposition = axisalignedbb.calculateIntercept(vec3, vec32);
				if (axisalignedbb.isVecInside(vec3)) {
					if (d2 >= 0.0D) {
						this.pointedEntity = entity1;
						vec33 = movingobjectposition == null ? vec3 : movingobjectposition.hitVec;
						d2 = 0.0D;
					}
				} else if (movingobjectposition != null) {
					double d3 = vec3.distanceTo(movingobjectposition.hitVec);
					if (d3 < d2 || d2 == 0.0D) {
						if (entity1 == entity.ridingEntity) {
							if (d2 == 0.0D) {
								this.pointedEntity = entity1;
								vec33 = movingobjectposition.hitVec;
							}
						} else {
							this.pointedEntity = entity1;
							vec33 = movingobjectposition.hitVec;
							d2 = d3;
						}
					}
				}
			}

			if (this.pointedEntity != null && flag && vec3.distanceTo(
					vec33) > (ModuleManager.getModuleByName("Reach").isEnabled() ? Reach.getReach() : 3.0D)) {
				this.pointedEntity = null;
				this.mc.objectMouseOver = new MovingObjectPosition(MovingObjectType.MISS, vec33, null,
						new BlockPos(vec33));
			}

			if (this.pointedEntity != null && (d2 < d1 || this.mc.objectMouseOver == null)) {
				this.mc.objectMouseOver = new MovingObjectPosition(this.pointedEntity, vec33);
				if (this.pointedEntity instanceof EntityLivingBase || this.pointedEntity instanceof EntityItemFrame) {
					this.mc.pointedEntity = this.pointedEntity;
				}
			}

			this.mc.mcProfiler.endSection();
		}

	}

	/**
	 * @author
	 * @reason can't inject
	 */
	@Overwrite
	public void setupCameraTransform(float partialTicks, int pass) {
		this.farPlaneDistance = (float) (this.mc.gameSettings.renderDistanceChunks * 16);
		GlStateManager.matrixMode(5889);
		GlStateManager.loadIdentity();
		float f = 0.07F;

		if (this.mc.gameSettings.anaglyph) {
			GlStateManager.translate((float) (-(pass * 2 - 1)) * f, 0.0F, 0.0F);
		}

		if (this.cameraZoom != 1.0D) {
			GlStateManager.translate((float) this.cameraYaw, (float) (-this.cameraPitch), 0.0F);
			GlStateManager.scale(this.cameraZoom, this.cameraZoom, 1.0D);
		}

		Project.gluPerspective(this.getFOVModifier(partialTicks, true),
				(float) this.mc.displayWidth / (float) this.mc.displayHeight, 0.05F,
				this.farPlaneDistance * MathHelper.SQRT_2);
		GlStateManager.matrixMode(5888);
		GlStateManager.loadIdentity();

		if (this.mc.gameSettings.anaglyph) {
			GlStateManager.translate((float) (pass * 2 - 1) * 0.1F, 0.0F, 0.0F);
		}

		this.hurtCameraEffect(partialTicks);

		if (this.mc.gameSettings.viewBobbing) {
			this.setupViewBobbing(partialTicks);
		}

		float f1 = this.mc.thePlayer.prevTimeInPortal
				+ (this.mc.thePlayer.timeInPortal - this.mc.thePlayer.prevTimeInPortal) * partialTicks;

		if (f1 > 0.0F) {
			int i = 20;

			if (this.mc.thePlayer.isPotionActive(Potion.confusion)) {
				i = 7;
			}

			float f2 = 5.0F / (f1 * f1 + 5.0F) - f1 * 0.04F;
			f2 = f2 * f2;
			GlStateManager.rotate(((float) this.rendererUpdateCount + partialTicks) * (float) i, 0.0F, 1.0F, 1.0F);
			if (ModuleManager.getModuleByClass(AntiDisplayFucker.class).isEnabled()) {
				GlStateManager.scale(1.0F, 1.0F, 1.0F);
			} else {
				GlStateManager.scale(1.0F / f2, 1.0F, 1.0F);
			}
			GlStateManager.rotate(-((float) this.rendererUpdateCount + partialTicks) * (float) i, 0.0F, 1.0F, 1.0F);
		}

		this.orientCamera(partialTicks);

		if (this.debugView) {
			switch (this.debugViewDirection) {
			case 0:
				GlStateManager.rotate(90.0F, 0.0F, 1.0F, 0.0F);
				break;
			case 1:
				GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
				break;
			case 2:
				GlStateManager.rotate(-90.0F, 0.0F, 1.0F, 0.0F);
				break;
			case 3:
				GlStateManager.rotate(90.0F, 1.0F, 0.0F, 0.0F);
				break;
			case 4:
				GlStateManager.rotate(-90.0F, 1.0F, 0.0F, 0.0F);
			}
		}
	}

	/**
	 * @author
	 * @reason can't inject
	 */
	@Overwrite
	private void setupFog(int startCoords, float partialTicks) {
		if (startCoords != -1) {
			GlStateManager.disableFog();
			return;
		}
		boolean fogStandard = false;
		Entity entity = this.mc.getRenderViewEntity();
		boolean flag = false;

		if (entity instanceof EntityPlayer) {
			flag = ((EntityPlayer) entity).capabilities.isCreativeMode;
		}

		GL11.glFog(GL11.GL_FOG_COLOR,
				this.setFogColorBuffer(this.fogColorRed, this.fogColorGreen, this.fogColorBlue, 1.0F));
		GL11.glNormal3f(0.0F, -1.0F, 0.0F);
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		Block block = ActiveRenderInfo.getBlockAtEntityViewpoint(this.mc.theWorld, entity, partialTicks);
		float f = -1.0F;

		f = ForgeHooksClient.getFogDensity((EntityRenderer) ((Object) this), entity, block, partialTicks, 0.1F);

		if (f >= 0.0F) {
			GlStateManager.setFogDensity(f);
		} else if (entity instanceof EntityLivingBase
				&& ModuleManager.getModuleByClass(AntiDisplayFucker.class).isEnabled()) {
			float f2 = this.farPlaneDistance;
			GlStateManager.setFog(9729);
			if (startCoords == -1) {
				GlStateManager.setFogStart(0.0F);
				GlStateManager.setFogEnd(f2);
			} else {
				GlStateManager.setFogStart(f2 * 0.75F);
				GlStateManager.setFogEnd(f2);
			}
		} else if (entity instanceof EntityLivingBase && ((EntityLivingBase) entity).isPotionActive(Potion.blindness)) {
			float f4 = 5.0F;
			int i = ((EntityLivingBase) entity).getActivePotionEffect(Potion.blindness).getDuration();

			if (i < 20) {
				f4 = 5.0F + (this.farPlaneDistance - 5.0F) * (1.0F - (float) i / 20.0F);
			}

			GlStateManager.setFog(9729);

			if (startCoords == -1) {
				GlStateManager.setFogStart(0.0F);
				GlStateManager.setFogEnd(f4 * 0.8F);
			} else {
				GlStateManager.setFogStart(f4 * 0.25F);
				GlStateManager.setFogEnd(f4);
			}
		} else if (this.cloudFog) {
			GlStateManager.setFog(2048);
			GlStateManager.setFogDensity(0.1F);
		} else if (block.getMaterial() == Material.water) {
			GlStateManager.setFog(2048);
			float f1 = 0.02F;
			if (entity instanceof EntityLivingBase
					&& ((EntityLivingBase) entity).isPotionActive(Potion.waterBreathing)) {
				GlStateManager.setFogDensity(0.01F);
			} else {
				float f2 = 0.1F - (float) EnchantmentHelper.getRespiration(entity) * 0.03F;
				GlStateManager.setFogDensity(f2 < 0.0F ? f1 : (0.0F > f2 ? f2 : 0.0F));
			}
		} else if (block.getMaterial() == Material.lava) {
			GlStateManager.setFog(2048);
			GlStateManager.setFogDensity(2.0F);
		} else {
			float f3 = this.farPlaneDistance;
			fogStandard = true;
			GlStateManager.disableFog();
			GlStateManager.setFog(9729);
			if (startCoords == -1) {
				GlStateManager.setFogStart(0.0F);
				GlStateManager.setFogEnd(f3);
			} else {
				GlStateManager.setFogStart(f3 * 0.0F);
				GlStateManager.setFogEnd(f3);
			}
			if (this.mc.theWorld.provider.doesXZShowFog((int) entity.posX, (int) entity.posZ)) {
				GlStateManager.setFogStart(f3 * 0.05F);
				GlStateManager.setFogEnd(f3);
			}

			ForgeHooksClient.onFogRender((EntityRenderer) ((Object) this), entity, block, partialTicks, startCoords, f);
		}

		GlStateManager.enableColorMaterial();
		GlStateManager.enableFog();
		GlStateManager.colorMaterial(1028, 4608);
	}

	public void loadShader2(ResourceLocation resourceLocationIn) {
		if (OpenGlHelper.isFramebufferEnabled()) {
			try {
				this.theShaderGroup = new ShaderGroup(this.mc.getTextureManager(), this.resourceManager,
						this.mc.getFramebuffer(), resourceLocationIn);
				this.theShaderGroup.createBindFramebuffers(this.mc.displayWidth, this.mc.displayHeight);
				this.useShader = true;
			} catch (IOException ioexception) {
				logger.warn("Failed to load shader: " + resourceLocationIn, ioexception);
				this.shaderIndex = shaderCount;
				this.useShader = false;
			} catch (JsonSyntaxException jsonsyntaxexception) {
				logger.warn("Failed to load shader: " + resourceLocationIn, jsonsyntaxexception);
				this.shaderIndex = shaderCount;
				this.useShader = false;
			}
		}
	}

	@Inject(method = "renderWorldPass", at = @At(value = "FIELD", target = "Lnet/minecraft/client/renderer/EntityRenderer;renderHand:Z", shift = At.Shift.BEFORE))
	private void renderWorldPass(int pass, float partialTicks, long finishTimeNano, CallbackInfo callbackInfo) {
		EventRender3D eventRender = new EventRender3D(partialTicks);
		EventBus.getInstance().call(eventRender);
	}

	/**
	 * @author
	 * @reason can't inject
	 */
	@Overwrite
	private void renderHand(float p_renderHand_1_, int p_renderHand_2_) {
		if (!debugView) {
			GlStateManager.matrixMode(5889);
			GlStateManager.loadIdentity();
			float f = 0.07F;
			if (mc.gameSettings.anaglyph)
				GlStateManager.translate((float) (-(p_renderHand_2_ * 2 - 1)) * f, 0.0F, 0.0F);
			Project.gluPerspective(getFOVModifier(p_renderHand_1_, false),
					(float) mc.displayWidth / (float) mc.displayHeight, 0.05F, farPlaneDistance * 2.0F);
			GlStateManager.matrixMode(5888);
			GlStateManager.loadIdentity();
			if (mc.gameSettings.anaglyph)
				GlStateManager.translate((float) (p_renderHand_2_ * 2 - 1) * 0.1F, 0.0F, 0.0F);
			GlStateManager.pushMatrix();
			hurtCameraEffect(p_renderHand_1_);
			if (mc.gameSettings.viewBobbing)
				setupViewBobbing(p_renderHand_1_);
			boolean flag = (mc.getRenderViewEntity() instanceof EntityLivingBase)
					&& ((EntityLivingBase) mc.getRenderViewEntity()).isPlayerSleeping();
			if (mc.gameSettings.thirdPersonView == 0 && !flag && !mc.gameSettings.hideGUI
					&& !mc.playerController.isSpectator()) {
				enableLightmap();
				itemRenderer.renderItemInFirstPerson(p_renderHand_1_);
				disableLightmap();
			}
			GlStateManager.popMatrix();
			if (mc.gameSettings.thirdPersonView == 0 && !flag) {
				itemRenderer.renderOverlays(p_renderHand_1_);
				hurtCameraEffect(p_renderHand_1_);
			}
			if (mc.gameSettings.viewBobbing)
				setupViewBobbing(p_renderHand_1_);
		}
		attemptSwing();
	}

	private void attemptSwing() {
		if (this.mc.thePlayer.getItemInUseCount() > 0) {
			boolean mouseDown = this.mc.gameSettings.keyBindAttack.isKeyDown()
					&& this.mc.gameSettings.keyBindUseItem.isKeyDown();

			if (mouseDown && this.mc.objectMouseOver != null
					&& this.mc.objectMouseOver.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
				this.swingItem(this.mc.thePlayer);
			}
		}
	}

	public void swingItem(EntityPlayerSP entityplayersp) {
		int swingAnimationEnd = entityplayersp.isPotionActive(Potion.digSpeed)
				? 6 - (1 + entityplayersp.getActivePotionEffect(Potion.digSpeed).getAmplifier())
				: (entityplayersp.isPotionActive(Potion.digSlowdown)
						? 6 + (1 + entityplayersp.getActivePotionEffect(Potion.digSlowdown).getAmplifier()) * 2
						: 6);
		if (!entityplayersp.isSwingInProgress || entityplayersp.swingProgressInt >= swingAnimationEnd / 2
				|| entityplayersp.swingProgressInt < 0) {
			entityplayersp.swingProgressInt = -1;
			entityplayersp.isSwingInProgress = true;
		}

	}

	public void runorientCamera(float partialTicks) {
		this.orientCamera(partialTicks);
	}

	/**
	 * @author
	 * @reason can't inject
	 */
	@Overwrite
	private void orientCamera(float partialTicks) {
		Entity entity = this.mc.getRenderViewEntity();
		float f = entity.getEyeHeight();
		double d0 = entity.prevPosX + (entity.posX - entity.prevPosX) * (double) partialTicks;
		double d1 = entity.prevPosY + (entity.posY - entity.prevPosY) * (double) partialTicks + (double) f;
		double d2 = entity.prevPosZ + (entity.posZ - entity.prevPosZ) * (double) partialTicks;
		MwHelper module = (MwHelper) ModuleManager.getModuleByClass(MwHelper.class);
		if (entity instanceof EntityLivingBase && ((EntityLivingBase) entity).isPlayerSleeping()) {
			f = (float) ((double) f + 1.0D);
			GlStateManager.translate(0.0F, 0.3F, 0.0F);
			if (!this.mc.gameSettings.debugCamEnable) {
				BlockPos blockpos = new BlockPos(entity);
				IBlockState iblockstate = this.mc.theWorld.getBlockState(blockpos);
				Block block = iblockstate.getBlock();
				if (block == Blocks.bed) {
					int j = iblockstate.getValue(BlockBed.FACING).getHorizontalIndex();
					GlStateManager.rotate((float) (j * 90), 0.0F, 1.0F, 0.0F);
				}
				GlStateManager.rotate(
						entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * partialTicks + 180.0F,
						0.0F, -1.0F, 0.0F);
				GlStateManager.rotate(
						entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * partialTicks,
						-1.0F, 0.0F, 0.0F);
			}
		} else if (this.mc.gameSettings.thirdPersonView > 0) {
			double d3 = this.thirdPersonDistanceTemp
					+ (this.thirdPersonDistance - this.thirdPersonDistanceTemp) * partialTicks;

			if (this.mc.gameSettings.debugCamEnable) {
				GlStateManager.translate(0.0F, 0.0F, -ViewClip.N.getValue().floatValue());
			} else {
				float f1 = entity.rotationYaw;
				float f2 = entity.rotationPitch;
				if (this.mc.gameSettings.thirdPersonView == 2) {
					f2 += 180.0F;
				}
				double d4 = (double) (-MathHelper.sin(f1 / 180.0F * (float) Math.PI)
						* MathHelper.cos(f2 / 180.0F * (float) Math.PI)) * d3;
				double d5 = (double) (MathHelper.cos(f1 / 180.0F * (float) Math.PI)
						* MathHelper.cos(f2 / 180.0F * (float) Math.PI)) * d3;
				double d6 = (double) (-MathHelper.sin(f2 / 180.0F * (float) Math.PI)) * d3;

				for (int i = 0; i < 8; ++i) {
					float f3 = (float) ((i & 1) * 2 - 1);
					float f4 = (float) ((i >> 1 & 1) * 2 - 1);
					float f5 = (float) ((i >> 2 & 1) * 2 - 1);
					f3 = f3 * 0.1F;
					f4 = f4 * 0.1F;
					f5 = f5 * 0.1F;
					MovingObjectPosition movingobjectposition = this.mc.theWorld
							.rayTraceBlocks(new Vec3(d0 + (double) f3, d1 + (double) f4, d2 + (double) f5), new Vec3(
									d0 - d4 + (double) f3 + (double) f5, d1 - d6 + (double) f4, d2 - d5 + (double) f5));
					if (movingobjectposition != null) {
						double d7 = movingobjectposition.hitVec.distanceTo(new Vec3(d0, d1, d2));
						if ((d7 < d3) && (!ModuleManager.getModuleByClass(ViewClip.class).isEnabled())) {
							d3 = d7;
						}
					}

				}
				if (this.mc.gameSettings.thirdPersonView == 2) {
					GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
				}
				GlStateManager.rotate(entity.rotationPitch - f2, 1.0F, 0.0F, 0.0F);
				GlStateManager.rotate(entity.rotationYaw - f1, 0.0F, 1.0F, 0.0F);
				GlStateManager.translate(0.0F, 0.0F, -ViewClip.N.getValue().floatValue());
				GlStateManager.rotate(f1 - entity.rotationYaw, 0.0F, 1.0F, 0.0F);
				GlStateManager.rotate(f2 - entity.rotationPitch, 1.0F, 0.0F, 0.0F);
			}
		} else

		{
			GlStateManager.translate(0.0F, 0.0F, -0.1F);
		}
		if (!this.mc.gameSettings.debugCamEnable) {
			if (module.isEnabled() && MwHelper.elementValue.getSetting("McLook").getValue() && Mouse.isButtonDown(2)) {
				GlStateManager.rotate(((IEntity) entity).getCameraPitch(), 1.0F, 0.0F, 0.0F);
			} else {
				GlStateManager.rotate(
						entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * partialTicks,
						1.0F, 0.0F, 0.0F);
			}
			if (entity instanceof EntityAnimal) {
				EntityAnimal entityanimal = (EntityAnimal) entity;
				GlStateManager.rotate(entityanimal.prevRotationYawHead
						+ (entityanimal.rotationYawHead - entityanimal.prevRotationYawHead) * partialTicks + 180.0F,
						0.0F, 1.0F, 0.0F);
			} else {
				if (module.isEnabled() && MwHelper.elementValue.getSetting("McLook").getValue()
						&& Mouse.isButtonDown(2)) {
					GlStateManager.rotate(((IEntity) entity).getCameraYaw() + 180.0F, 0.0F, 1.0F, 0.0F);
				} else {
					GlStateManager.rotate(entity.prevRotationYaw
							+ (entity.rotationYaw - entity.prevRotationYaw) * partialTicks + 180.0F, 0.0F, 1.0F, 0.0F);
				}
			}
		}
		GlStateManager.translate(0.0F, -f, 0.0F);
		d0 = entity.prevPosX + (entity.posX - entity.prevPosX) * (double) partialTicks;
		d1 = entity.prevPosY + (entity.posY - entity.prevPosY) * (double) partialTicks + (double) f;
		d2 = entity.prevPosZ + (entity.posZ - entity.prevPosZ) * (double) partialTicks;
		this.cloudFog = this.mc.renderGlobal.hasCloudFog(d0, d1, d2, partialTicks);
	}

	/**
	 * @author
	 * @reason can't inject
	 */
	@Overwrite
	private void updateFogColor(float partialTicks) {
		World world = this.mc.theWorld;
		Entity entity = this.mc.getRenderViewEntity();
		float f = 0.25F + 0.75F * (float) this.mc.gameSettings.renderDistanceChunks / 32.0F;
		f = 1.0F - (float) Math.pow(f, 0.25D);
		Vec3 vec3 = world.getSkyColor(this.mc.getRenderViewEntity(), partialTicks);
		float f1 = (float) vec3.xCoord;
		float f2 = (float) vec3.yCoord;
		float f3 = (float) vec3.zCoord;
		Vec3 vec31 = world.getFogColor(partialTicks);
		this.fogColorRed = (float) vec31.xCoord;
		this.fogColorGreen = (float) vec31.yCoord;
		this.fogColorBlue = (float) vec31.zCoord;

		if (this.mc.gameSettings.renderDistanceChunks >= 4) {
			double d0 = -1.0D;
			Vec3 vec32 = MathHelper.sin(world.getCelestialAngleRadians(partialTicks)) > 0.0F ? new Vec3(d0, 0.0D, 0.0D)
					: new Vec3(1.0D, 0.0D, 0.0D);
			float f5 = (float) entity.getLook(partialTicks).dotProduct(vec32);

			if (f5 < 0.0F) {
				f5 = 0.0F;
			}

			if (f5 > 0.0F) {
				float[] afloat = world.provider.calcSunriseSunsetColors(world.getCelestialAngle(partialTicks),
						partialTicks);

				if (afloat != null) {
					f5 = f5 * afloat[3];
					this.fogColorRed = this.fogColorRed * (1.0F - f5) + afloat[0] * f5;
					this.fogColorGreen = this.fogColorGreen * (1.0F - f5) + afloat[1] * f5;
					this.fogColorBlue = this.fogColorBlue * (1.0F - f5) + afloat[2] * f5;
				}
			}
		}

		this.fogColorRed += (f1 - this.fogColorRed) * f;
		this.fogColorGreen += (f2 - this.fogColorGreen) * f;
		this.fogColorBlue += (f3 - this.fogColorBlue) * f;
		float f8 = world.getRainStrength(partialTicks);

		if (f8 > 0.0F) {
			float f4 = 1.0F - f8 * 0.5F;
			float f10 = 1.0F - f8 * 0.4F;
			this.fogColorRed *= f4;
			this.fogColorGreen *= f4;
			this.fogColorBlue *= f10;
		}

		float f9 = world.getThunderStrength(partialTicks);

		if (f9 > 0.0F) {
			float f11 = 1.0F - f9 * 0.5F;
			this.fogColorRed *= f11;
			this.fogColorGreen *= f11;
			this.fogColorBlue *= f11;
		}

		Block block = ActiveRenderInfo.getBlockAtEntityViewpoint(this.mc.theWorld, entity, partialTicks);

		if (this.cloudFog) {
			Vec3 vec33 = world.getCloudColour(partialTicks);
			this.fogColorRed = (float) vec33.xCoord;
			this.fogColorGreen = (float) vec33.yCoord;
			this.fogColorBlue = (float) vec33.zCoord;
		} else if (block.getMaterial() == Material.water) {
			float f12 = (float) EnchantmentHelper.getRespiration(entity) * 0.2F;

			if (entity instanceof EntityLivingBase
					&& ((EntityLivingBase) entity).isPotionActive(Potion.waterBreathing)) {
				f12 = f12 * 0.3F + 0.6F;
			}

			this.fogColorRed = 0.02F + f12;
			this.fogColorGreen = 0.02F + f12;
			this.fogColorBlue = 0.2F + f12;
		} else if (block.getMaterial() == Material.lava) {
			this.fogColorRed = 0.6F;
			this.fogColorGreen = 0.1F;
			this.fogColorBlue = 0.0F;
		}

		float f13 = this.fogColor2 + (this.fogColor1 - this.fogColor2) * partialTicks;
		this.fogColorRed *= f13;
		this.fogColorGreen *= f13;
		this.fogColorBlue *= f13;
		double d1 = (entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double) partialTicks)
				* world.provider.getVoidFogYFactor();
		if (ModuleManager.getModuleByClass(AntiDisplayFucker.class).isEnabled()) {
			d1 = 1.0;
		} else if (entity instanceof EntityLivingBase && ((EntityLivingBase) entity).isPotionActive(Potion.blindness)) {
			int i = ((EntityLivingBase) entity).getActivePotionEffect(Potion.blindness).getDuration();

			if (i < 20) {
				d1 *= 1.0F - (float) i / 20.0F;
			} else {
				d1 = 0.0D;
			}
		}

		if (d1 < 1.0D) {
			if (d1 < 0.0D) {
				d1 = 0.0D;
			}

			d1 = d1 * d1;
			this.fogColorRed = (float) ((double) this.fogColorRed * d1);
			this.fogColorGreen = (float) ((double) this.fogColorGreen * d1);
			this.fogColorBlue = (float) ((double) this.fogColorBlue * d1);
		}

		if (this.bossColorModifier > 0.0F) {
			float f14 = this.bossColorModifierPrev
					+ (this.bossColorModifier - this.bossColorModifierPrev) * partialTicks;
			this.fogColorRed = this.fogColorRed * (1.0F - f14) + this.fogColorRed * 0.7F * f14;
			this.fogColorGreen = this.fogColorGreen * (1.0F - f14) + this.fogColorGreen * 0.6F * f14;
			this.fogColorBlue = this.fogColorBlue * (1.0F - f14) + this.fogColorBlue * 0.6F * f14;
		}

		if (entity instanceof EntityLivingBase && ((EntityLivingBase) entity).isPotionActive(Potion.nightVision)) {
			float f15 = this.getNightVisionBrightness((EntityLivingBase) entity, partialTicks);
			float f6 = 1.0F / this.fogColorRed;

			if (f6 > 1.0F / this.fogColorGreen) {
				f6 = 1.0F / this.fogColorGreen;
			}

			if (f6 > 1.0F / this.fogColorBlue) {
				f6 = 1.0F / this.fogColorBlue;
			}

			this.fogColorRed = this.fogColorRed * (1.0F - f15) + this.fogColorRed * f6 * f15;
			this.fogColorGreen = this.fogColorGreen * (1.0F - f15) + this.fogColorGreen * f6 * f15;
			this.fogColorBlue = this.fogColorBlue * (1.0F - f15) + this.fogColorBlue * f6 * f15;
		}

		if (this.mc.gameSettings.anaglyph) {
			float f16 = (this.fogColorRed * 30.0F + this.fogColorGreen * 59.0F + this.fogColorBlue * 11.0F) / 100.0F;
			float f17 = (this.fogColorRed * 30.0F + this.fogColorGreen * 70.0F) / 100.0F;
			float f7 = (this.fogColorRed * 30.0F + this.fogColorBlue * 70.0F) / 100.0F;
			this.fogColorRed = f16;
			this.fogColorGreen = f17;
			this.fogColorBlue = f7;
		}

		net.minecraftforge.client.event.EntityViewRenderEvent.FogColors event = new net.minecraftforge.client.event.EntityViewRenderEvent.FogColors(
				(EntityRenderer) ((Object) this), entity, block, partialTicks, this.fogColorRed, this.fogColorGreen,
				this.fogColorBlue);
		net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event);

		this.fogColorRed = event.red;
		this.fogColorGreen = event.green;
		this.fogColorBlue = event.blue;

		GlStateManager.clearColor(this.fogColorRed, this.fogColorGreen, this.fogColorBlue, 0.0F);
	}

	/**
	 * @author
	 * @reason can't inject
	 */
	@Overwrite
	private void updateFovModifierHand() {
		float f = 1.0F;

		if (this.mc.getRenderViewEntity() instanceof AbstractClientPlayer) {
			AbstractClientPlayer abstractclientplayer = (AbstractClientPlayer) this.mc.getRenderViewEntity();
			f = abstractclientplayer.getFovModifier();
		}

		this.fovModifierHandPrev = this.fovModifierHand;
		this.fovModifierHand += (f - this.fovModifierHand) * 0.5F;

		if (this.fovModifierHand > 1.5F) {
			this.fovModifierHand = 1.5F;
		}

		if (this.fovModifierHand < 0.1F) {
			this.fovModifierHand = 0.1F;
		}
	}
}
