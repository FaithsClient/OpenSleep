package rip.sleep.ui.misc;

import antiLeak.Loader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import rip.sleep.module.modules.UHCCrafts;
import rip.sleep.value.Value;

public class GuiInventoryOverride extends GuiInventory {
   private static ArrayList<UHCCrafts> c82953;
   private static List<List<UHCCrafts>> c92543;
   public int c6660 = 0;
   public static boolean c74590;
   private static final String[] c40603;

   public GuiInventoryOverride(EntityPlayer var1) {
      super(var1);
   }

   public static native void c30456() throws IOException;

   private static Item c62228(String var0) {
      Value.c27574();
      Iterator var2 = Item.itemRegistry.iterator();
      if (var2.hasNext()) {
         Item var3 = (Item)var2.next();
         if (var3.getUnlocalizedName().equalsIgnoreCase(var0)) {
            return var3;
         }
      }

      return null;
   }

   protected native void mouseClicked(int var1, int var2, int var3) throws IOException;

   public native void drawScreen(int var1, int var2, float var3);

   static {
      Loader.registerNativesForClass(4, GuiInventoryOverride.class);
      c31246();
   }

   private static Exception c53299(Exception var0) {
      return var0;
   }

   // $FF: synthetic method
   private static native void c31246();
}
