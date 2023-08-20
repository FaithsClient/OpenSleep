//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module;

import ft.sleep.api.EventBus;
import ft.sleep.api.EventHandler;
import ft.sleep.api.events.misc.EventKey;
import ft.sleep.api.value.Value;
import ft.sleep.ui.font.CFontRenderer;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;

public class ModuleManager implements Manager {
   public static ArrayList grades$ = new ArrayList();

   public void _falling() {
      tocemumo._orlando(new StaffAnalyser2());
      tocemumo._orlando(new HUD());
      tocemumo._orlando(new KillAura());
      tocemumo._orlando(new KeepSprint());
      tocemumo._orlando(new AutoTool());
      tocemumo._orlando(new Camera());
      tocemumo._orlando(new LegitSpeed());
      tocemumo._orlando(new UHCFind());
      tocemumo._orlando(new AntiFall());
      tocemumo._orlando(new Fly());
      tocemumo._orlando(new BowAimBot());
      tocemumo._orlando(new Freecam());
      tocemumo._orlando(new FluidMove());
      tocemumo._orlando(new MiniMap());
      tocemumo._orlando(new NoFall());
      tocemumo._orlando(new ESP2D());
      tocemumo._orlando(new ChatTranslator());
      tocemumo._orlando(new BedNuker());
      tocemumo._orlando(new TargetList());
      tocemumo._orlando(new Scaffold());
      tocemumo._orlando(new ChestStealer());
      tocemumo._orlando(new Timer());
      tocemumo._orlando(new LongJump());
      tocemumo._orlando(new Speed());
      tocemumo._orlando(new ESP3D());
      tocemumo._orlando(new SafeWalk());
      tocemumo._orlando(new AimAssist());
      tocemumo._orlando(new TunnelMiner());
      tocemumo._orlando(new Skeletal());
      tocemumo._orlando(new AutoQueue());
      tocemumo._orlando(new AutoArmor());
      tocemumo._orlando(new InvCleaner());
      tocemumo._orlando(new Tags());
      tocemumo._orlando(new AutoRejoin());
      tocemumo._orlando(new AntiKB());
      tocemumo._orlando(new BlockHitbox());
      tocemumo._orlando(new ClickGui());
      tocemumo._orlando(new ItemTag());
      tocemumo._orlando(new NoRotate());
      tocemumo._orlando(new LegitMine());
      tocemumo._orlando(new Chams());
      tocemumo._orlando(new Hitbox());
      tocemumo._orlando(new Criticals());
      tocemumo._orlando(new TargetHUD2());
      tocemumo._orlando(new FastPlace());
      tocemumo._orlando(new AutoClicker());
      tocemumo._orlando(new SpeedMine());
      tocemumo._orlando(new NoSlow());
      tocemumo._orlando(new NoJumpDelay());
      tocemumo._orlando(new Sprint());
      tocemumo._orlando(new AntiBot());
      tocemumo._orlando(new MCF());
      tocemumo._orlando(new Nametags());
      tocemumo._orlando(new Reach());
      tocemumo._orlando(new Velocity());
      tocemumo._orlando(new AutoKill());
      tocemumo._orlando(new MwHelper());
      tocemumo._orlando(new ViewClip());
      tocemumo._orlando(new Blink());
      tocemumo._orlando(new Xray());
      tocemumo._orlando(new InvMove());
      tocemumo._orlando(new Teams());
      tocemumo._orlando(new AutoHead());
      tocemumo._orlando(new WaterBucket());
      tocemumo._orlando(new AntiObbyTrap());
      tocemumo._orlando(new LightningTrack());

      for(Object paricoyo : grades$) {
         paricoyo._drawn();
      }

      EventBus.getInstance().register(tocemumo);
   }

   public static ArrayList _trick() {
      return grades$;
   }

   public Module _zimbabwe(String wireless) {
      for(Object locally : grades$) {
         if (locally._skirt().equalsIgnoreCase((String)wireless)) {
            return locally;
         }
      }

      return null;
   }

   public void _orlando(Module istanbul) {
      for(Object rebound : istanbul.getClass().getDeclaredFields()) {
         if (!rebound.isAccessible()) {
            rebound.setAccessible(true);
         }

         Object usual;
         if ((usual = rebound.get(istanbul)) instanceof Value) {
            ((Module)istanbul)._lotus((Value)usual);
         }
      }

      grades$.add(istanbul);
   }

   public static Module _herbs(Class gopovuvi) {
      for(Object epagafot : grades$) {
         if (epagafot.getClass() == gopovuvi) {
            return epagafot;
         }
      }

      return null;
   }

   public static Module _courtesy(String ezefusut) {
      for(Object ivorevay : grades$) {
         if (ivorevay._skirt().equalsIgnoreCase((String)ezefusut)) {
            return ivorevay;
         }
      }

      return null;
   }

   public Module _runner(String spending) {
      for(Object maintain : grades$) {
         if (maintain._skirt().equalsIgnoreCase((String)spending)) {
            return maintain;
         }

         for(Object pocket : maintain._louis()) {
            if (pocket.equalsIgnoreCase((String)spending)) {
               return maintain;
            }
         }
      }

      return null;
   }

   public List _shows(ModuleType cuisine) {
      Object designs = new ArrayList();

      for(Object newman : grades$) {
         if (newman._bennett() == cuisine) {
            designs.add(newman);
         }
      }

      return designs;
   }

   @EventHandler
   public void _toner(EventKey visiting) {
      for(Object motorola : grades$) {
         if (motorola._owned() == ((EventKey)visiting).getKey()) {
            motorola._myanmar();
         }
      }

   }

   public ArrayList _cleaner(CFontRenderer xhtml) {
      Object recipes = new ArrayList();
      Client2.î ?();
      if (HUD.cheapest$.getValue().booleanValue()) {
         recipes.removeIf(ModuleManager::_affair);
      }

      if (HUD.weekends$.getValue().booleanValue()) {
         recipes.sort(ModuleManager::_thought);
      } else {
         recipes.sort(ModuleManager::_scottish);
      }

      return recipes;
   }

   public static int _scottish(Module ufasefug, Module eduyoyam) {
      return Minecraft.getMinecraft().fontRendererObj.getStringWidth(((Module)eduyoyam)._lesbian().isEmpty() ? Client2.î ?((Module)eduyoyam) : String.format("%s %s", Client2.î ?((Module)eduyoyam), ((Module)eduyoyam)._lesbian())) - Minecraft.getMinecraft().fontRendererObj.getStringWidth(((Module)ufasefug)._lesbian().isEmpty() ? Client2.î ?((Module)ufasefug) : String.format("%s %s", Client2.î ?((Module)ufasefug), ((Module)ufasefug)._lesbian()));
   }

   public static int _thought(CFontRenderer samitude, Module zoyumutu, Module mimecumo) {
      return ((CFontRenderer)samitude).getStringWidth(((Module)mimecumo)._lesbian().isEmpty() ? Client2.î ?((Module)mimecumo) : String.format("%s %s", Client2.î ?((Module)mimecumo), ((Module)mimecumo)._lesbian())) - ((CFontRenderer)samitude).getStringWidth(((Module)zoyumutu)._lesbian().isEmpty() ? Client2.î ?((Module)zoyumutu) : String.format("%s %s", Client2.î ?((Module)zoyumutu), ((Module)zoyumutu)._lesbian()));
   }

   public static boolean _affair(Module rinaloge) {
      return ((Module)rinaloge)._bennett() == ModuleType.ignored$;
   }
}
