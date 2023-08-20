package org.spongepowered.tools.obfuscation;

import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic.Kind;
import org.spongepowered.asm.mixin.Mixin;

public abstract class MixinObfuscationProcessor extends AbstractProcessor {
   protected AnnotatedMixins mixins;

   public synchronized void init(ProcessingEnvironment processingEnv) {
      super.init(processingEnv);
      this.mixins = AnnotatedMixins.getMixinsForEnvironment(processingEnv);
   }

   protected void processMixins(RoundEnvironment roundEnv) {
      this.mixins.onPassStarted();

      for(Element elem : roundEnv.getElementsAnnotatedWith(Mixin.class)) {
         if (elem.getKind() != ElementKind.CLASS && elem.getKind() != ElementKind.INTERFACE) {
            this.mixins.printMessage(Kind.ERROR, "Found an @Mixin annotation on an element which is not a class or interface", elem);
         } else {
            this.mixins.registerMixin((TypeElement)elem);
         }
      }

   }

   protected void postProcess(RoundEnvironment roundEnv) {
      this.mixins.onPassCompleted(roundEnv);
   }

   public SourceVersion getSupportedSourceVersion() {
      try {
         return SourceVersion.valueOf("RELEASE_8");
      } catch (IllegalArgumentException var2) {
         return super.getSupportedSourceVersion();
      }
   }

   public Set getSupportedOptions() {
      return SupportedOptions.getAllOptions();
   }
}
