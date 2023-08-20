package com.sun.jna;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.IdentityHashMap;

public class  {
   public ReferenceQueue  = new ReferenceQueue();
   public IdentityHashMap  = new IdentityHashMap();

   public synchronized void _/* $FF was: */(Object SAO46,  SAO46) {
      SAO46.();
      Reference SAO46 = new WeakReference(SAO46, SAO46.);
      SAO46..put(SAO46, SAO46);
   }

   public synchronized void ___/* $FF was: */() {
      for(Reference SAO46 = SAO46..poll(); SAO46 != null; SAO46 = SAO46..poll()) {
         SAO46..remove(SAO46);
      }

   }
}
