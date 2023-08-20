package ft.sleep.module;

public enum ModuleType {
   updates$,
   ignored$,
   Movement,
   Player,
   Combat;

   public static ModuleType[] wearing$ = new ModuleType[]{updates$, ignored$, Movement, Player, Combat};
}
