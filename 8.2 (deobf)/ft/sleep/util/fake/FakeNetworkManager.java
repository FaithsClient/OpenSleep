package ft.sleep.util.fake;

import io.netty.channel.Channel;
import net.minecraft.network.EnumPacketDirection;
import net.minecraft.network.NetworkManager;

public class FakeNetworkManager extends NetworkManager {
   public FakeNetworkManager(EnumPacketDirection apurobor) {
      super((EnumPacketDirection)apurobor);
   }

   public Channel _/* $FF was: */() {
      return new FakeNetworkManager2(burner);
   }
}
