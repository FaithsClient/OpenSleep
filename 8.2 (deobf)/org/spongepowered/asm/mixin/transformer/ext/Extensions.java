package org.spongepowered.asm.mixin.transformer.ext;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.transformer.MixinTransformer;

public final class Extensions {
   private final MixinTransformer transformer;
   private final List extensions = new ArrayList();
   private final Map extensionMap = new HashMap();
   private final List generators = new ArrayList();
   private final List generatorsView;
   private final Map generatorMap;
   private List activeExtensions;

   public Extensions(MixinTransformer transformer) {
      this.generatorsView = Collections.unmodifiableList(this.generators);
      this.generatorMap = new HashMap();
      this.activeExtensions = Collections.emptyList();
      this.transformer = transformer;
   }

   public MixinTransformer getTransformer() {
      return this.transformer;
   }

   public void add(IExtension extension) {
      this.extensions.add(extension);
      this.extensionMap.put(extension.getClass(), extension);
   }

   public List getExtensions() {
      return Collections.unmodifiableList(this.extensions);
   }

   public List getActiveExtensions() {
      return this.activeExtensions;
   }

   public IExtension getExtension(Class extensionClass) {
      return (IExtension)lookup(extensionClass, this.extensionMap, this.extensions);
   }

   public void select(MixinEnvironment environment) {
      Builder activeExtensions = ImmutableList.builder();

      for(IExtension extension : this.extensions) {
         if (extension.checkActive(environment)) {
            activeExtensions.add(extension);
         }
      }

      this.activeExtensions = activeExtensions.build();
   }

   public void preApply(ITargetClassContext context) {
      for(IExtension extension : this.activeExtensions) {
         extension.preApply(context);
      }

   }

   public void postApply(ITargetClassContext context) {
      for(IExtension extension : this.activeExtensions) {
         extension.postApply(context);
      }

   }

   public void export(MixinEnvironment env, String name, boolean force, byte[] bytes) {
      for(IExtension extension : this.activeExtensions) {
         extension.export(env, name, force, bytes);
      }

   }

   public void add(IClassGenerator generator) {
      this.generators.add(generator);
      this.generatorMap.put(generator.getClass(), generator);
   }

   public List getGenerators() {
      return this.generatorsView;
   }

   public IClassGenerator getGenerator(Class generatorClass) {
      return (IClassGenerator)lookup(generatorClass, this.generatorMap, this.generators);
   }

   private static Object lookup(Class extensionClass, Map map, List list) {
      Object extension = (T)map.get(extensionClass);
      if (extension == null) {
         for(Object classGenerator : list) {
            if (extensionClass.isAssignableFrom(classGenerator.getClass())) {
               extension = classGenerator;
               break;
            }
         }

         if (extension == null) {
            throw new IllegalArgumentException("Extension for <" + extensionClass.getName() + "> could not be found");
         }

         map.put(extensionClass, extension);
      }

      return extension;
   }
}
