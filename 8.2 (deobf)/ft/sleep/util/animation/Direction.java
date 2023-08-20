package ft.sleep.util.animation;

public enum Direction {
   verse$,
   posted$;

   public static Direction[] obtain$ = new Direction[]{verse$, posted$};

   public Direction _improved() {
      return concrete == verse$ ? posted$ : verse$;
   }
}
