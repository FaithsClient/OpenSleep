//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.util.fake;

import java.util.UUID;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.network.EnumPacketDirection;

public class FakeNetHandlerPlayClient extends NetHandlerPlayClient {
   public NetworkPlayerInfo tissue$;

   public FakeNetHandlerPlayClient(Minecraft struck) {
      super((Minecraft)struck, ((Minecraft)struck).currentScreen, new FakeNetworkManager(EnumPacketDirection.CLIENTBOUND), ((Minecraft)struck).getSession().getProfile());
      mario.tissue$ = new NetworkPlayerInfo(((Minecraft)struck).getSession().getProfile());
   }

   public NetworkPlayerInfo getPlayerInfo(UUID var1) {
      return ucipicet.tissue$;
   }

   public NetworkPlayerInfo getPlayerInfo(String var1) {
      return billing.tissue$;
   }
}
