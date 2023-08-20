/*
 * Decompiled with CFR 0_132.
 */
package linxiu.module.modules.uhc;

import com.google.common.collect.Lists;
import linxiu.api.EventHandler;
import linxiu.api.events.rendering.EventRender3D;
import linxiu.api.events.world.EventPacketReceive;
import linxiu.api.events.world.EventTick;
import linxiu.api.value.Numbers;
import linxiu.api.value.Option;
import linxiu.module.Module;
import linxiu.module.ModuleType;
import linxiu.utils.PacketUtils;
import linxiu.utils.render.ColorUtils;
import linxiu.utils.render.RenderUtils;
import linxiu.utils.timer.Timer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockOre;
import net.minecraft.block.BlockRedstoneOre;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.server.S22PacketMultiBlockChange;
import net.minecraft.network.play.server.S22PacketMultiBlockChange.BlockUpdateData;
import net.minecraft.network.play.server.S23PacketBlockChange;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class Xray extends Module {
	public static boolean isEnabled;
	public static List<Integer> blockIdList = Lists.newArrayList(10, 11, 8, 9, 14, 15, 16, 21, 41, 42, 46, 48, 52, 56,
			57, 61, 62, 73, 74, 84, 89, 103, 116, 117, 118, 120, 129, 133, 137, 145, 152, 153, 154);
	public static List<BlockPos> blockPosList = new CopyOnWriteArrayList<>();
	public Map<BlockPos, Block> blockDataList = new HashMap<BlockPos, Block>();
	private final Timer timer = new Timer();
	public static int alpha;
	public static Numbers<Number> opacity = new Numbers<Number>("Opacity", 160.0, 0.0, 255.0, 5.0);
	public static Numbers<Number> range = new Numbers<Number>("Range", 50.0D, 0.0D, 500.0D, 1.0D);
	public static Numbers<Number> delay = new Numbers<Number>("Delay", 10.0, 0.5, 30.0, 0.5);
	private static final Numbers<Double> extremeRange = new Numbers<Double>("extremeRange", 4.0D, 0.0D, 8.0D, 1.0D);

	public static Option update = new Option("Update", true), coal = new Option("Coal", true),
			iron = new Option("iron", true), gold = new Option("gold", true),
			lapisLazuli = new Option("lapisLazuli", true), diamond = new Option("diamond", true),
			redStone = new Option("redStone", true), emerald = new Option("emerald", false),
			tracer = new Option("tracer", false), cave = new Option("cave", false), esp = new Option("esp", true),
			uhc = new Option("uhc", true);
	public static Option extreme = new Option("extreme", true);
	Thread updater;
	List<Integer> KEY_IDS = Lists.newArrayList(10, 11, 8, 9, 14, 15, 16, 21, 41, 42, 46, 48, 52, 56, 57, 61, 62, 73, 74,
			84, 89, 103, 116, 117, 118, 120, 129, 133, 137, 145, 152, 153, 154);
	private int jiazaitiao;
	Block[] _extreme_var0 = new Block[] { Blocks.diamond_ore, Blocks.gold_ore, };

	public Xray() {
		super("Xray", new String[] { "Xray" }, ModuleType.Legit);
	}

	@Override
	public void onEnable() {
		onToggle(true);
		try {
			for (Object key_id : this.KEY_IDS) {
				Integer o = (Integer) key_id;
				blockIdList.add(o);
			}
		} catch (Exception var3) {
			var3.printStackTrace();
		}
		if (extreme.getValue() && mc.thePlayer.posY <= 25.0) {
			this.doExtreme();
		}
		int posX = (int) mc.thePlayer.posX;
		int posY = (int) mc.thePlayer.posY;
		int posZ = (int) mc.thePlayer.posZ;
		mc.renderGlobal.markBlockRangeForRenderUpdate(posX - 900, posY - 900, posZ - 900, posX + 900, posY + 900,
				posZ + 900);
	}

	@Override
	public void onDisable() {
		onToggle(false);
		try {
			this.updater.interrupt();
			this.updater = null;
		} catch (Exception ex) {
		}
		blockDataList.clear();
		timer.reset();
	}

	private void onToggle(boolean enabled) {
		blockDataList.clear();
		blockIdList.clear();
		blockPosList.clear();
		mc.renderGlobal.loadRenderers();
		isEnabled = enabled;
	}

	@EventHandler
	public void onEventRE(EventPacketReceive e) {
		if (EventPacketReceive.getPacket() instanceof S23PacketBlockChange) {
			S23PacketBlockChange packet = (S23PacketBlockChange) EventPacketReceive.getPacket();
			BlockPos position = packet.getBlockPosition();
			IBlockState blockState = packet.getBlockState();
			Block block = blockState.getBlock();
			if (block instanceof BlockOre || block instanceof BlockRedstoneOre) {
				if (!Xray.blockPosList.contains(position)) {
					blockPosList.add(position);
					this.blockDataList.put(position, block);
				}
			}
		}
		if (EventPacketReceive.getPacket() instanceof S22PacketMultiBlockChange) {
			S22PacketMultiBlockChange packet = (S22PacketMultiBlockChange) EventPacketReceive.getPacket();
			for (BlockUpdateData changedBlock : packet.getChangedBlocks()) {
				BlockPos pos = changedBlock.getPos();
				Block block = changedBlock.getBlockState().getBlock();
				if (block instanceof BlockOre || block instanceof BlockRedstoneOre) {
					if (!Xray.blockPosList.contains(pos)) {
						blockPosList.add(pos);
						this.blockDataList.put(pos, block);
					}
				}
			}
		}
	}

	@EventHandler
	public void onEventRE(EventTick e) {
		if (alpha != opacity.getValue().intValue()) {
			alpha = opacity.getValue().intValue();
		} else if (update.getValue()) {
			if (timer.delay(1000 * delay.getValue().doubleValue())) {
				if (extreme.getValue().booleanValue() && mc.thePlayer.posY <= 25.0) {
					this.doExtreme();
				}
				timer.reset();
			}
		}
	}

	public void doExtreme() {
		int var1 = ((Number) extremeRange.getValue()).intValue();
		for (int var2 = -var1; var2 < var1; ++var2) {
			for (int var3 = var1; var3 > -var1; --var3) {
				for (int var4 = -var1; var4 < var1; ++var4) {
					if (mc.thePlayer.getDistanceSq(mc.thePlayer.posX + var2, mc.thePlayer.posY + var3,
							mc.thePlayer.posZ + var4) <= 24.0) {
						Block[] var10;
						Block var8 = mc.theWorld.getBlockState(new BlockPos(mc.thePlayer.posX + var2,
								mc.thePlayer.posY + var3, mc.thePlayer.posZ + var4)).getBlock();
						boolean var9 = false;
						Block[] blockArray = var10 = this._extreme_var0;
						int n = var10.length;
						int n2 = 0;
						while (n2 < n) {
							Block var13 = blockArray[n2];
							if (var8.equals(var13)) {
								var9 = true;
								break;
							}
							++n2;
						}
						var9 = var9 && (var8.getBlockHardness(mc.theWorld, BlockPos.ORIGIN) != -1.0F
								|| mc.playerController.isInCreativeMode());
						boolean dont = false;
						for (BlockPos pos : blockPosList) {
							if ((mc.thePlayer.posX + var2) == pos.getX() && (mc.thePlayer.posY + var3) == pos.getY()
									&& (mc.thePlayer.posZ + var4) == (double) pos.getZ()) {
								dont = true;
								break;
							}
						}
						BlockPos pos = new BlockPos(mc.thePlayer.posX + var2, mc.thePlayer.posY + var3,
								mc.thePlayer.posZ + var4);
						if (var9 && !dont) {
							PacketUtils.sendPacket(new C07PacketPlayerDigging(
									C07PacketPlayerDigging.Action.ABORT_DESTROY_BLOCK, pos, EnumFacing.UP));
							if (!blockPosList.contains(pos)) {
								blockPosList.add(pos);
							}
						}
					}
				}
			}
		}
	}

	public double getDistance(double x, double z) {
		double d0 = mc.thePlayer.posX - x;
		double d2 = mc.thePlayer.posZ - z;
		return MathHelper.sqrt_double(d0 * d0 + d2 * d2);
	}

	@EventHandler
	public void onRender3D(EventRender3D e) {
		if (esp.getValue()) {
			for (BlockPos pos : blockPosList) {
				if (getDistance(pos.getX(), pos.getZ()) <= range.getValue().doubleValue()) {
					Block block = mc.theWorld.getBlockState(pos).getBlock();

					if (block == Blocks.diamond_ore && diamond.getValue()) {
						render3D(pos, 0, 255, 255);
					} else if (block == Blocks.iron_ore && iron.getValue()) {
						render3D(pos, 225, 225, 225);
					} else if (block == Blocks.lapis_ore && lapisLazuli.getValue()) {
						render3D(pos, 0, 0, 255);
					} else if (block == Blocks.redstone_ore && redStone.getValue()) {
						render3D(pos, 255, 0, 0);
					} else if (block == Blocks.coal_ore && coal.getValue()) {
						render3D(pos, 0, 30, 30);
					} else if (block == Blocks.emerald_ore && emerald.getValue()) {
						render3D(pos, 0, 255, 0);
					} else if (block == Blocks.gold_ore && gold.getValue()) {
						render3D(pos, 255, 255, 0);
					}
				}
			}
		}
	}

	private static class XRayBlock {
		private final double x;
		private final double y;
		private final double z;
		private final Block block;

		public XRayBlock(double x, double y, double z, Block block) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.block = block;
		}

		public double getX() {
			return this.x;
		}

		public double getY() {
			return this.y;
		}

		public double getZ() {
			return this.z;
		}

		public Block getBlock() {
			return this.block;
		}

		public boolean samePos(BlockPos blockPos) {
			return (int) this.x == blockPos.getX() && (int) this.y == blockPos.getY()
					&& this.z == (double) blockPos.getZ();
		}
	}

	public static boolean showESP() {
		return esp.getValue();
	}

	public static int getDistance() {
		return range.getValue().intValue();
	}

	private void render3D(BlockPos pos, int red, int green, int blue) {
		if (esp.getValue()) {
			RenderUtils.drawSolidBlockESP(pos, ColorUtils.getColor(red, green, blue));
		}

		if (tracer.getValue()) {
			RenderUtils.drawLine(pos, ColorUtils.getColor(red, green, blue));
		}
	}
}