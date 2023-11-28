package rip.sleep.management;

import rip.sleep.command.*;
import rip.sleep.command.commands.*;
import rip.sleep.event.EventBus;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.json.JSONException;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.ChatSendEvent;
import rip.sleep.interfaces.IManager;
import rip.sleep.module.Module;
import rip.sleep.util.ChatUtilA;
import rip.sleep.value.Value;

public class CommandManager implements IManager {
   private List<Command> c33075;

   public void c32199() {
      this.c33075 = new ArrayList();
      this.c33075.add(new Command("test", new String[]{"test"}, "", "testing") {
         public String c23111(String[] var1) {
            Value.c27574();
            Iterator var3 = CommandManager.this.c33075.iterator();
            if (var3.hasNext()) {
               Command var4 = (Command)var3.next();
            }

            return null;
         }
      });
      this.c33075.add(new HelpCommand());
      this.c33075.add(new QQCommand());
      this.c33075.add(new UsernameCommand());
      this.c33075.add(new TitleCommand());
      this.c33075.add(new SquandCommand());
      this.c33075.add(new ClientNameCommand());
      this.c33075.add(new ToggleCommand());
      this.c33075.add(new BindCommand());
      this.c33075.add(new TargetCommand());
      this.c33075.add(new VClipCommand());
      this.c33075.add(new ChangeSkinCommand());
      this.c33075.add(new FriendCommand());
      this.c33075.add(new CheatsCommand());
      this.c33075.add(new HiddenCommand());
      this.c33075.add(new SetNameCommand());
      this.c33075.add(new ConfigCommand());
      EventBus.getInstance().register(this);
   }

   public List<Command> c50778() {
      return this.c33075;
   }

   public Optional<Command> c24941(String var1) {
      return this.c33075.stream().filter((var1x) -> {
         Value.c27574();
         boolean var3 = false;
         String[] var4 = var1x.c29280();
         int var5 = var4.length;
         int var6 = 0;
         if (var6 < var5) {
            String var7 = var4[var6];
            if (var7.equalsIgnoreCase(var1)) {
               var3 = true;
            }

            ++var6;
         }

         return var1x.getName().equalsIgnoreCase(var1) || var3;
      }).findFirst();
   }

   public void c84056(Command var1) {
      this.c33075.add(var1);
   }

   @EventTarget
   private void c30206(ChatSendEvent var1) {
      Module[] var2 = Value.c27574();
      if (var1.c49307().length() > 1 && var1.c49307().startsWith(".")) {
         var1.c8253(true);
         String[] var3 = var1.c49307().trim().substring(1).split(" ");
         Optional var4 = this.c24941(var3[0]);
         if (var4.isPresent()) {
            String var5 = ((Command)var4.get()).c23111((String[])Arrays.copyOfRange(var3, 1, var3.length));
            if (var5 != null && !var5.isEmpty()) {
               ChatUtilA.c34080(var5);
            }
         }

         ChatUtilA.c34080(String.format("Command not found Try '%shelp'", "."));
      }

   }

   private static JSONException c89335(JSONException var0) {
      return var0;
   }
}
