package ft.sleep.util.other;

import java.util.UUID;
import net.minecraft.util.ResourceLocation;

public class DefaultPlayerSkin {
   public static ResourceLocation species$ = new ResourceLocation("textures/entity/steve.png");
   public static ResourceLocation monkey$ = new ResourceLocation("textures/entity/alex.png");

   public static ResourceLocation _instead() {
      return species$;
   }

   public static ResourceLocation _directly(UUID neither) {
      return _league((UUID)neither) ? monkey$ : species$;
   }

   public static String _filing(UUID laptops) {
      return _league((UUID)laptops) ? "slim" : "default";
   }

   public static boolean _league(UUID blake) {
      return (((UUID)blake).hashCode() & 1) == 1;
   }
}
