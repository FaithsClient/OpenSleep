package org.spongepowered.tools.obfuscation;

import java.util.ArrayList;
import java.util.List;
import org.spongepowered.tools.obfuscation.interfaces.IMixinAnnotationProcessor;
import org.spongepowered.tools.obfuscation.interfaces.IObfuscationDataProvider;
import org.spongepowered.tools.obfuscation.interfaces.IObfuscationManager;
import org.spongepowered.tools.obfuscation.interfaces.IReferenceManager;
import org.spongepowered.tools.obfuscation.mapping.IMappingConsumer;
import org.spongepowered.tools.obfuscation.service.ObfuscationServices;

public class ObfuscationManager implements IObfuscationManager {
   private final IMixinAnnotationProcessor ap;
   private final List environments = new ArrayList();
   private final IObfuscationDataProvider obfs;
   private final IReferenceManager refs;
   private final List consumers = new ArrayList();
   private boolean initDone;

   public ObfuscationManager(IMixinAnnotationProcessor ap) {
      this.ap = ap;
      this.obfs = new ObfuscationDataProvider(ap, this.environments);
      this.refs = new ReferenceManager(ap, this.environments);
   }

   public void init() {
      if (!this.initDone) {
         this.initDone = true;
         ObfuscationServices.getInstance().initProviders(this.ap);

         for(ObfuscationType obfType : ObfuscationType.types()) {
            if (obfType.isSupported()) {
               this.environments.add(obfType.createEnvironment());
            }
         }

      }
   }

   public IObfuscationDataProvider getDataProvider() {
      return this.obfs;
   }

   public IReferenceManager getReferenceManager() {
      return this.refs;
   }

   public IMappingConsumer createMappingConsumer() {
      Mappings mappings = new Mappings();
      this.consumers.add(mappings);
      return mappings;
   }

   public List getEnvironments() {
      return this.environments;
   }

   public void writeMappings() {
      for(ObfuscationEnvironment env : this.environments) {
         env.writeMappings(this.consumers);
      }

   }

   public void writeReferences() {
      this.refs.write();
   }
}
