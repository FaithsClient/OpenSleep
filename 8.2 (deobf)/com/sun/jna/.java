package com.sun.jna;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class  extends  implements Function. {
   public String ;
   public List ;
   public Object[] ;

   public ___/* $FF was: */(String[] SAO46) {
      this(SAO46, false);
   }

   public ___/* $FF was: */(String[] SAO46, boolean SAO46) {
      this((Object[])SAO46, SAO46 ? "--WIDE-STRING--" : Native.());
   }

   public ___/* $FF was: */(String[] SAO46, String SAO46) {
      this((Object[])SAO46, SAO46);
   }

   public ___/* $FF was: */([] SAO46) {
      this(SAO46, "--WIDE-STRING--");
   }

   public ___/* $FF was: */(Object[] SAO46, String SAO46) {
      super((long)((SAO46.length + 1) * Pointer.));
      SAO46. = new ArrayList();
      SAO46. = SAO46;
      SAO46. = SAO46;

      for(int SAO46 = 0; SAO46 < SAO46.length; ++SAO46) {
         Pointer SAO46 = null;
         if (SAO46[SAO46] != null) {
             SAO46 = new (SAO46[SAO46].toString(), SAO46);
            SAO46..add(SAO46);
            SAO46 = SAO46.();
         }

         SAO46.((long)(Pointer. * SAO46), SAO46);
      }

      SAO46.((long)(Pointer. * SAO46.length), (Pointer)null);
   }

   public void read() {
      boolean SAO46 = SAO46. instanceof [];
      boolean SAO46 = "--WIDE-STRING--".equals(SAO46.);

      for(int SAO46 = 0; SAO46 < SAO46..length; ++SAO46) {
         Pointer SAO46 = SAO46.((long)(SAO46 * Pointer.));
         Object SAO46 = null;
         if (SAO46 != null) {
            SAO46 = SAO46 ? SAO46.((long)1268789451 ^ 1268789451L) : SAO46.((long)-1739158961 ^ -1739158961L, SAO46.);
            if (SAO46) {
               SAO46 = new ((String)SAO46);
            }
         }

         SAO46.[SAO46] = SAO46;
      }

   }

   public String toString() {
      boolean SAO46 = "--WIDE-STRING--".equals(SAO46.);
      String SAO46 = SAO46 ? "const wchar_t*[]" : "const char*[]";
      SAO46 = SAO46 + Arrays.asList(SAO46.);
      return SAO46;
   }
}
