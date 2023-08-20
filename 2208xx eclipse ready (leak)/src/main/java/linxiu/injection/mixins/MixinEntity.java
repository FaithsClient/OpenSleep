/*
 * Copyright (c) 2018 superblaubeere27
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package linxiu.injection.mixins;

import linxiu.api.EventBus;
import linxiu.api.events.misc.StrafeEvent;
import linxiu.api.events.world.EventMove;
import linxiu.api.events.world.SafeWalkEvent;
import linxiu.api.events.world.StepEvent;
import linxiu.injection.interfaces.IEntity;
import linxiu.management.ModuleManager;
import linxiu.module.modules.megawalls.MwHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockWall;
import net.minecraft.block.material.Material;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ReportedException;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

import org.lwjgl.input.Mouse;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public abstract class MixinEntity implements IEntity {
	@Shadow
	public double posX;
	@Shadow
	public double posY;
	@Shadow
	public double posZ;
	@Shadow
	public double motionX;
	@Shadow
	public double motionY;
	@Shadow
	public double motionZ;
	@Shadow
	protected Random rand;
	@Shadow
	protected boolean inPortal;
	@Shadow
	public float rotationYaw;
	@Shadow
	public float rotationPitch;

	@Shadow
	public boolean onGround;

	@Shadow
	private int nextStepDistance;

	@Shadow
	private int fire;

	@Shadow
	private AxisAlignedBB boundingBox;

	@Shadow
	public boolean noClip;
	@Shadow
	public float stepHeight;
	@Shadow
	public boolean isInWeb;
	@Shadow
	public boolean isCollidedHorizontally;
	@Shadow
	public boolean isCollidedVertically;
	@Shadow
	public boolean isCollided;
	@Shadow
	public float distanceWalkedModified;
	@Shadow
	public float distanceWalkedOnStepModified;
	@Shadow
	public int fireResistance;
	@Shadow
	public Entity ridingEntity;
	@Shadow
	public World worldObj;

	public float cameraRotationPitch;
	public float cameraRotationYaw;
	public float prevCameraRotationPitch;
	public float prevCameraRotationYaw;

	@Override
	public int getNextStepDistance() {
		return nextStepDistance;
	}

	@Shadow
	protected abstract void dealFireDamage(int amount);

	@Shadow
	public abstract boolean isWet();

	@Shadow
	public abstract void addEntityCrashInfo(CrashReportCategory category);

	@Shadow
	protected abstract void doBlockCollisions();

	@Shadow
	protected abstract void playStepSound(BlockPos pos, Block blockIn);

	@Shadow
	public abstract AxisAlignedBB getEntityBoundingBox();

	@Shadow
	public float prevRotationYaw;
	@Shadow
	public float prevRotationPitch;

	@Shadow
	public abstract Vec3 getVectorForRotation(float pitch, float yaw);

	@Override
	public void setNextStepDistance(int distance) {
		nextStepDistance = distance;
	}

	@Override
	public int getFire() {
		return fire;
	}

	@Override
	public void setFire(int i) {
		fire = i;
	}

	@Override
	public AxisAlignedBB getBoundingBox() {
		return boundingBox;
	}

	@Inject(method = "moveFlying", at = @At("HEAD"), cancellable = true)
	private void handleRotations(float strafe, float forward, float friction, final CallbackInfo callbackInfo) {
		float yaw = rotationYaw;
		StrafeEvent eventStrafe = new StrafeEvent(strafe, forward, friction, rotationYaw);
		if ((Entity) (Object) this instanceof EntityPlayerSP) {
			EventBus.getInstance().call(eventStrafe);
			strafe = eventStrafe.getStrafe();
			forward = eventStrafe.getForward();
			friction = eventStrafe.getFriction();
			yaw = eventStrafe.getYaw();
		}
		if (eventStrafe.isCancelled())
			callbackInfo.cancel();
	}

	/**
	 * @author
	 * @reason can't inject
	 */
	@Overwrite
	public void setAngles(float yaw, float pitch) {
		float f = rotationPitch;
		float f1 = rotationYaw;
		MwHelper module = (MwHelper) ModuleManager.getModuleByClass(MwHelper.class);
		if (!(module.isEnabled() && MwHelper.elementValue.getSetting("McLook").getValue() && Mouse.isButtonDown(2))) {
			this.rotationYaw = (float) ((double) rotationYaw + (double) yaw * 0.15D);
			this.rotationPitch = (float) ((double) rotationPitch - (double) pitch * 0.15D);
			this.rotationPitch = MathHelper.clamp_float(rotationPitch, -90.0F, 90.0F);
			this.prevRotationPitch += rotationPitch - f;
			this.prevRotationYaw += rotationYaw - f1;
			this.cameraRotationYaw = rotationYaw;
			this.cameraRotationPitch = rotationPitch;
		}
		this.cameraRotationPitch = (float) ((double) cameraRotationPitch - (double) pitch * 0.15D);
		this.cameraRotationPitch = MathHelper.clamp_float(cameraRotationPitch, -90.0F, 90.0F);
		this.cameraRotationYaw = (float) ((double) cameraRotationYaw + (double) yaw * 0.15D);
	}

	@Override
	public float getCameraYaw() {
		return this.cameraRotationYaw;
	}

	@Shadow
	private void resetPositionToBB() {
	}

	@Shadow
	public abstract boolean isSneaking();

	@Shadow
	public abstract boolean isRiding();

	@Shadow
	public abstract void setEntityBoundingBox(AxisAlignedBB bb);

	@Shadow
	public abstract boolean isInWater();

	/**
	 * @author 2121
	 * @reason 123123123
	 */
	@Overwrite
	public void moveEntity(double x, double y, double z) {
        EventMove eventMove = new EventMove(x, y, z);
        EventBus.getInstance().call(eventMove);
		x = eventMove.getX();
		y = eventMove.getY();
		z = eventMove.getZ();
        
        
		if (this.noClip) {
			this.setEntityBoundingBox(this.getEntityBoundingBox().offset(x, y, z));
			this.resetPositionToBB();
		} else {
			this.worldObj.theProfiler.startSection("move");
			double d0 = this.posX;
			double d1 = this.posY;
			double d2 = this.posZ;

			if (this.isInWeb) {
				this.isInWeb = false;
				x *= 0.25D;
				y *= 0.05F;
				z *= 0.25D;
				this.motionX = 0.0D;
				this.motionY = 0.0D;
				this.motionZ = 0.0D;
			}

			double d3 = x;
			double d4 = y;
			double d5 = z;

			boolean ff = this.onGround && this.isSneaking();

			SafeWalkEvent safeWalkEvent = new SafeWalkEvent(ff);
			EventBus.getInstance().call(safeWalkEvent);

			boolean flag = safeWalkEvent.isCancelled();

			if (flag) {
				double d6;

				for (d6 = 0.05D; x != 0.0D && this.worldObj.getCollidingBoundingBoxes((Entity) (Object) this,
						this.getEntityBoundingBox().offset(x, -1.0D, 0.0D)).isEmpty(); d3 = x) {
					if (x < d6 && x >= -d6) {
						x = 0.0D;
					} else if (x > 0.0D) {
						x -= d6;
					} else {
						x += d6;
					}
				}

				for (; z != 0.0D && this.worldObj.getCollidingBoundingBoxes((Entity) (Object) this,
						this.getEntityBoundingBox().offset(0.0D, -1.0D, z)).isEmpty(); d5 = z) {
					if (z < d6 && z >= -d6) {
						z = 0.0D;
					} else if (z > 0.0D) {
						z -= d6;
					} else {
						z += d6;
					}
				}

				for (; x != 0.0D && z != 0.0D && this.worldObj.getCollidingBoundingBoxes((Entity) (Object) this,
						this.getEntityBoundingBox().offset(x, -1.0D, z)).isEmpty(); d5 = z) {
					if (x < d6 && x >= -d6) {
						x = 0.0D;
					} else if (x > 0.0D) {
						x -= d6;
					} else {
						x += d6;
					}

					d3 = x;

					if (z < d6 && z >= -d6) {
						z = 0.0D;
					} else if (z > 0.0D) {
						z -= d6;
					} else {
						z += d6;
					}
				}
			}

			List<AxisAlignedBB> list1 = this.worldObj.getCollidingBoundingBoxes((Entity) (Object) this,
					this.getEntityBoundingBox().addCoord(x, y, z));
			AxisAlignedBB axisalignedbb = this.getEntityBoundingBox();

			for (AxisAlignedBB axisalignedbb1 : list1) {
				y = axisalignedbb1.calculateYOffset(this.getEntityBoundingBox(), y);
			}

			this.setEntityBoundingBox(this.getEntityBoundingBox().offset(0.0D, y, 0.0D));
			boolean flag1 = this.onGround || d4 != y && d4 < 0.0D;

			for (AxisAlignedBB axisalignedbb2 : list1) {
				x = axisalignedbb2.calculateXOffset(this.getEntityBoundingBox(), x);
			}

			this.setEntityBoundingBox(this.getEntityBoundingBox().offset(x, 0.0D, 0.0D));

			for (AxisAlignedBB axisalignedbb13 : list1) {
				z = axisalignedbb13.calculateZOffset(this.getEntityBoundingBox(), z);
			}

			this.setEntityBoundingBox(this.getEntityBoundingBox().offset(0.0D, 0.0D, z));

			StepEvent event = new StepEvent(this.stepHeight, true);
			EventBus.getInstance().call(event);

			if (event.getStepHeight() > 0.0F && flag1 && (d3 != x || d5 != z)) {
				double d11 = x;
				double d7 = y;
				double d8 = z;
				AxisAlignedBB axisalignedbb3 = this.getEntityBoundingBox();
				this.setEntityBoundingBox(axisalignedbb);
				y = event.getStepHeight();
				List<AxisAlignedBB> list = this.worldObj.getCollidingBoundingBoxes((Entity) (Object) this,
						this.getEntityBoundingBox().addCoord(d3, y, d5));
				AxisAlignedBB axisalignedbb4 = this.getEntityBoundingBox();
				AxisAlignedBB axisalignedbb5 = axisalignedbb4.addCoord(d3, 0.0D, d5);
				double d9 = y;

				for (AxisAlignedBB axisalignedbb6 : list) {
					d9 = axisalignedbb6.calculateYOffset(axisalignedbb5, d9);
				}

				axisalignedbb4 = axisalignedbb4.offset(0.0D, d9, 0.0D);
				double d15 = d3;

				for (AxisAlignedBB axisalignedbb7 : list) {
					d15 = axisalignedbb7.calculateXOffset(axisalignedbb4, d15);
				}

				axisalignedbb4 = axisalignedbb4.offset(d15, 0.0D, 0.0D);
				double d16 = d5;

				for (AxisAlignedBB axisalignedbb8 : list) {
					d16 = axisalignedbb8.calculateZOffset(axisalignedbb4, d16);
				}

				axisalignedbb4 = axisalignedbb4.offset(0.0D, 0.0D, d16);
				AxisAlignedBB axisalignedbb14 = this.getEntityBoundingBox();
				double d17 = y;

				for (AxisAlignedBB axisalignedbb9 : list) {
					d17 = axisalignedbb9.calculateYOffset(axisalignedbb14, d17);
				}

				axisalignedbb14 = axisalignedbb14.offset(0.0D, d17, 0.0D);
				double d18 = d3;

				for (AxisAlignedBB axisalignedbb10 : list) {
					d18 = axisalignedbb10.calculateXOffset(axisalignedbb14, d18);
				}

				axisalignedbb14 = axisalignedbb14.offset(d18, 0.0D, 0.0D);
				double d19 = d5;

				for (AxisAlignedBB axisalignedbb11 : list) {
					d19 = axisalignedbb11.calculateZOffset(axisalignedbb14, d19);
				}

				axisalignedbb14 = axisalignedbb14.offset(0.0D, 0.0D, d19);
				double d20 = d15 * d15 + d16 * d16;
				double d10 = d18 * d18 + d19 * d19;

				if (d20 > d10) {
					x = d15;
					z = d16;
					y = -d9;
					this.setEntityBoundingBox(axisalignedbb4);
				} else {
					x = d18;
					z = d19;
					y = -d17;
					this.setEntityBoundingBox(axisalignedbb14);
				}

				for (AxisAlignedBB axisalignedbb12 : list) {
					y = axisalignedbb12.calculateYOffset(this.getEntityBoundingBox(), y);
				}

				this.setEntityBoundingBox(this.getEntityBoundingBox().offset(0.0D, y, 0.0D));

				if (d11 * d11 + d8 * d8 >= x * x + z * z) {
					x = d11;
					y = d7;
					z = d8;
					this.setEntityBoundingBox(axisalignedbb3);
				}

				EventBus.getInstance().call(new StepEvent(this.stepHeight, false));

			}

			this.worldObj.theProfiler.endSection();
			this.worldObj.theProfiler.startSection("rest");
			this.resetPositionToBB();
			this.isCollidedHorizontally = d3 != x || d5 != z;
			this.isCollidedVertically = d4 != y;
			this.onGround = this.isCollidedVertically && d4 < 0.0D;
			this.isCollided = this.isCollidedHorizontally || this.isCollidedVertically;
			int i = MathHelper.floor_double(this.posX);
			int j = MathHelper.floor_double(this.posY - (double) 0.2F);
			int k = MathHelper.floor_double(this.posZ);
			BlockPos blockpos = new BlockPos(i, j, k);
			Block block1 = this.worldObj.getBlockState(blockpos).getBlock();

			if (block1.getMaterial() == Material.air) {
				Block block = this.worldObj.getBlockState(blockpos.down()).getBlock();

				if (block instanceof BlockFence || block instanceof BlockWall || block instanceof BlockFenceGate) {
					block1 = block;
					blockpos = blockpos.down();
				}
			}

			this.updateFallState(y, this.onGround, block1, blockpos);

			if (d3 != x) {
				this.motionX = 0.0D;
			}

			if (d5 != z) {
				this.motionZ = 0.0D;
			}

			if (d4 != y) {
				block1.onLanded(this.worldObj, (Entity) (Object) this);
			}

			if (this.canTriggerWalking() && !flag && this.ridingEntity == null) {
				double d12 = this.posX - d0;
				double d13 = this.posY - d1;
				double d14 = this.posZ - d2;

				if (block1 != Blocks.ladder) {
					d13 = 0.0D;
				}

				if (this.onGround) {
					block1.onEntityCollidedWithBlock(this.worldObj, blockpos, (Entity) (Object) this);
				}

				this.distanceWalkedModified = (float) ((double) this.distanceWalkedModified
						+ (double) MathHelper.sqrt_double(d12 * d12 + d14 * d14) * 0.6D);
				this.distanceWalkedOnStepModified = (float) ((double) this.distanceWalkedOnStepModified
						+ (double) MathHelper.sqrt_double(d12 * d12 + d13 * d13 + d14 * d14) * 0.6D);

				if (this.distanceWalkedOnStepModified > (float) this.nextStepDistance
						&& block1.getMaterial() != Material.air) {
					this.nextStepDistance = (int) this.distanceWalkedOnStepModified + 1;

					if (this.isInWater()) {
						float f = MathHelper.sqrt_double(this.motionX * this.motionX * (double) 0.2F
								+ this.motionY * this.motionY + this.motionZ * this.motionZ * (double) 0.2F) * 0.35F;

						if (f > 1.0F) {
							f = 1.0F;
						}

						this.playSound(this.getSwimSound(), f,
								1.0F + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.4F);
					}

					this.playStepSound(blockpos, block1);
				}
			}

			try {
				this.doBlockCollisions();
			} catch (Throwable throwable) {
				CrashReport crashreport = CrashReport.makeCrashReport(throwable, "Checking entity block collision");
				CrashReportCategory crashreportcategory = crashreport
						.makeCategory("Entity being checked for collision");
				this.addEntityCrashInfo(crashreportcategory);
				throw new ReportedException(crashreport);
			}

			boolean flag2 = this.isWet();

			if (this.worldObj.isFlammableWithin(this.getEntityBoundingBox().contract(0.001D, 0.001D, 0.001D))) {
				this.dealFireDamage(1);

				if (!flag2) {
					++this.fire;

					if (this.fire == 0) {
						this.setFire(8);
					}
				}
			} else if (this.fire <= 0) {
				this.fire = -this.fireResistance;
			}

			if (flag2 && this.fire > 0) {
				this.playSound("random.fizz", 0.7F, 1.6F + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.4F);
				this.fire = -this.fireResistance;
			}

			this.worldObj.theProfiler.endSection();
		}
	}

	@Shadow
	protected abstract boolean canTriggerWalking();

	@Shadow
	public void playSound(String name, float volume, float pitch) {
	}

	@Shadow
	protected abstract String getSwimSound();

	@Shadow
	protected void updateFallState(double y, boolean onGroundIn, Block blockIn, BlockPos pos) {
	}

	@Override
	public float getCameraPitch() {
		return this.cameraRotationPitch;
	}
}
