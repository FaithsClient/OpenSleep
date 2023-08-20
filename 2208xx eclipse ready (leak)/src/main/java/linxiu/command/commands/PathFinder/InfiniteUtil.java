package linxiu.command.commands.PathFinder;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

import java.util.ArrayList;

public class InfiniteUtil {
    public static ArrayList<EntityLivingBase> targets = new ArrayList();
    public static ArrayList<EntityLivingBase> blackList = new ArrayList();
    private static boolean disableAura = false;
    private static boolean reachExploit = false;
    private static int timercap = 15;
    private static double range = 7.0;
    private static boolean headsnap = false;
    private static double chargerange = 8.0;
    private static double packetTPRange = 10.0;

    public static boolean hasEntity(Entity en) {
        if (en == null) {
            return false;
        }
        if (!targets.isEmpty()) {
            for (EntityLivingBase en1 : targets) {
                if (en1 == null || !en1.isEntityEqual(en)) continue;
                return true;
            }
        }
        return false;
    }

    public static boolean blackEntity(Entity en) {
        if (en == null) {
            return false;
        }
        if (!blackList.isEmpty()) {
            for (EntityLivingBase en1 : blackList) {
                if (en1 == null || !en1.isEntityEqual(en)) continue;
                return true;
            }
        }
        return false;
    }

    public static boolean getDisableAura() {
        return disableAura;
    }

    public static void setDisableAura(boolean disableAura) {
        InfiniteUtil.disableAura = disableAura;
    }

    public static boolean isReachExploit() {
        return reachExploit;
    }

    public static void setReachExploit(boolean reachExploit) {
        InfiniteUtil.reachExploit = reachExploit;
    }

    public static double getPacketTPRange() {
        return packetTPRange;
    }

    public static void setPacketTPRange(double packetTPRange) {
        InfiniteUtil.packetTPRange = packetTPRange;
    }

    public static double getRange() {
        return range;
    }

    public static void setRange(double value) {
        range = value;
    }

    public static boolean getHeadsnap() {
        return headsnap;
    }

    public static int getAPS() {
        return timercap;
    }

    public static void setTimer(int set) {
        timercap = set;
    }

    public static void setHeadSnap(boolean selected) {
        headsnap = selected;
    }

    public static double getChargeRange() {
        return chargerange;
    }

    public static void setChargeRange(double chargerange) {
        InfiniteUtil.chargerange = chargerange;
    }

    public static double[] getRotationToEntity(Entity entity) {
        double pX = Minecraft.getMinecraft().thePlayer.posX;
        double pY = Minecraft.getMinecraft().thePlayer.posY + (double) Minecraft.getMinecraft().thePlayer.getEyeHeight();
        double pZ = Minecraft.getMinecraft().thePlayer.posZ;
        double eX = entity.posX;
        double eY = entity.posY + (double) (entity.height / 2.0f);
        double eZ = entity.posZ;
        double dX = pX - eX;
        double dY = pY - eY;
        double dZ = pZ - eZ;
        double dH = Math.sqrt(Math.pow(dX, 2.0) + Math.pow(dZ, 2.0));
        double yaw = Math.toDegrees(Math.atan2(dZ, dX)) + 90.0;
        double pitch = Math.toDegrees(Math.atan2(dH, dY));
        return new double[]{yaw, 90.0 - pitch};
    }

    public static double angleDifference(double a2, double b) {
        return ((a2 - b) % 360.0 + 540.0) % 360.0 - 180.0;
    }

    public static EntityLivingBase getClosestEntity(float range) {
        EntityLivingBase closestEntity = null;
        float mindistance = range;
        Minecraft.getMinecraft();
        for (Object o : Minecraft.getMinecraft().theWorld.loadedEntityList) {
            EntityLivingBase en = null;
            if (!InfiniteUtil.isNotItem(o) || o instanceof EntityPlayerSP) continue;
            Minecraft.getMinecraft();
            if (Minecraft.getMinecraft().thePlayer.getDistanceToEntity(en) >= mindistance) continue;
            Minecraft.getMinecraft();
            mindistance = Minecraft.getMinecraft().thePlayer.getDistanceToEntity(en);
            closestEntity = en;
        }
        return closestEntity;
    }

    public static boolean isNotItem(Object o) {
        return o instanceof EntityLivingBase;
    }
}

