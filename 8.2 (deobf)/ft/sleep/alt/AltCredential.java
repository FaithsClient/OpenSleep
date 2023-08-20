package ft.sleep.alt;

import java.util.Objects;
import org.apache.commons.lang3.StringUtils;

public class AltCredential {
   public String safely$;
   public String deputy$;

   public AltCredential(String ezayomug, String yesefuyu) {
      osozepic.safely$ = ((String)ezayomug).trim();
      osozepic.deputy$ = (String)(StringUtils.isNotBlank((CharSequence)yesefuyu) ? yesefuyu : null);
   }

   public String _annually() {
      return tatemivi.safely$;
   }

   public String _feeding() {
      return carried.deputy$;
   }

   public boolean equals(Object starts) {
      if (fleet == starts) {
         return true;
      } else if (starts != null && fleet.getClass() == starts.getClass()) {
         Object offset = (AltCredential)starts;
         return fleet.safely$.equals(offset.safely$) && Objects.equals(fleet.deputy$, offset.deputy$);
      } else {
         return false;
      }
   }

   public int hashCode() {
      return Objects.hash(new Object[]{knowing.safely$, knowing.deputy$});
   }

   public String toString() {
      return younger.safely$ + (younger.deputy$ != null ? ":" + younger.deputy$ : "");
   }
}
