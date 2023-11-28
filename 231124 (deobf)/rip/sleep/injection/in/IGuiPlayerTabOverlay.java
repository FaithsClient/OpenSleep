package rip.sleep.injection.in;

import com.google.common.collect.Ordering;
import net.minecraft.client.network.NetworkPlayerInfo;

public interface IGuiPlayerTabOverlay {
   Ordering<NetworkPlayerInfo> getField();
}
