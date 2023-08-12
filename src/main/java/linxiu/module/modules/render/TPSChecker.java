package linxiu.module.modules.render;

import linxiu.Client;
import linxiu.api.EventHandler;
import linxiu.api.events.rendering.EventRender2D;
import linxiu.api.events.world.EventPacketReceive;
import linxiu.module.Module;
import linxiu.module.ModuleType;
import linxiu.utils.PlayerUtils;
import linxiu.utils.timer.TimeHelper;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.play.server.S02PacketChat;
import net.minecraft.network.play.server.S03PacketTimeUpdate;
import net.minecraft.network.play.server.S3APacketTabComplete;
import net.minecraft.util.ResourceLocation;

import java.awt.*;
import java.util.ArrayList;

public class TPSChecker extends Module {
    
	public TPSChecker() {
		super("TPSChecker", new String[] { "TPSChecker" }, ModuleType.Render);
	}

    private static final ArrayList<Long> times = new ArrayList<Long>();
    private final TimeHelper tpsTimer = new TimeHelper();
    public static TimeHelper laggTimer = new TimeHelper();
    public float lastTPS = 20.0f;
    public long keepAliveTime = 0, curPing;
    public boolean receivedPacket = false;
	
	@EventHandler
	public void onRPacket(EventPacketReceive event) {
		if (!(EventPacketReceive.getPacket() instanceof S02PacketChat)) {
            laggTimer.reset();
        }

        if (EventPacketReceive.getPacket() instanceof S03PacketTimeUpdate) {
            times.add(Math.max(1000, tpsTimer.elapsed()));
            long timesAdded = 0;
            if (times.size() > 5) {
                times.remove(0);
            }
            for (long l : times) {
                timesAdded += l;
            }
            long roundedTps = timesAdded / times.size();
            lastTPS = (float) ((20.0 / roundedTps) * 1000.0);
            tpsTimer.reset();
        }

        if (System.currentTimeMillis() - keepAliveTime > 3000) {
            curPing = -1;
            receivedPacket = true;
        }

        if (EventPacketReceive.getPacket() instanceof S3APacketTabComplete) {
            S3APacketTabComplete packet = (S3APacketTabComplete) EventPacketReceive.getPacket();
            if (packet.func_149630_c().length > 500) {
                PlayerUtils.tellPlayer("Received a large packet, cancelled for preventing client crash.");
                event.setCancelled(true);
            } else if (packet.func_149630_c().length == 0) {
                curPing = System.currentTimeMillis() - keepAliveTime;
                receivedPacket = true;
            }
        }
	}
	
    public int getPing(EntityPlayer player) {
        NetworkPlayerInfo playerInfo = mc.getNetHandler().getPlayerInfo(player.getGameProfile().getId());

        if (playerInfo == null) return -1;

        return playerInfo.getResponseTime();
    }
	
	@EventHandler
	public void Render3d(EventRender2D event) {
		EntityLivingBase ent = this.mc.thePlayer;
		ScaledResolution sr = new ScaledResolution(mc);

		double tps = Math.round(lastTPS * 10) / 10d;
		if (getPing(mc.thePlayer) > 330) {
			GlStateManager.pushMatrix();
			GlStateManager.enableBlend();
			mc.getTextureManager().bindTexture(new ResourceLocation("sleep/R-C.png"));
			int size = 80;
			Color c = HUD.getCustomColor();
			GlStateManager.color(c.getRed() * .003921569F, c.getGreen() * .003921569F, c.getBlue() * .003921569F);
			Gui.drawModalRectWithCustomSizedTexture(sr.getScaledWidth() / 2 - 38, sr.getScaledHeight() / 2 - 180, 0, 0,
					size, size, size, size);
			mc.fontRendererObj.drawStringWithShadow("Lagging Time...", sr.getScaledWidth() / 2 - 30,
					sr.getScaledHeight() / 2 - 100, -1);
			GlStateManager.resetColor();
			GlStateManager.disableBlend();
			GlStateManager.popMatrix();
		}
	}
}
