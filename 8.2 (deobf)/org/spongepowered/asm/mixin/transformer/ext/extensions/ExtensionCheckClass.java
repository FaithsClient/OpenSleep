package org.spongepowered.asm.mixin.transformer.ext.extensions;

import org.spongepowered.asm.lib.util.CheckClassAdapter;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.throwables.MixinException;
import org.spongepowered.asm.mixin.transformer.ext.IExtension;
import org.spongepowered.asm.mixin.transformer.ext.ITargetClassContext;
import org.spongepowered.asm.transformers.MixinClassWriter;

public class ExtensionCheckClass implements IExtension {
   public boolean checkActive(MixinEnvironment environment) {
      return environment.getOption(MixinEnvironment.Option.DEBUG_VERIFY);
   }

   public void preApply(ITargetClassContext context) {
   }

   public void postApply(ITargetClassContext context) {
      try {
         context.getClassNode().accept(new CheckClassAdapter(new MixinClassWriter(2)));
      } catch (RuntimeException var3) {
         throw new ExtensionCheckClass.ValidationFailedException(var3.getMessage(), var3);
      }
   }

   public void export(MixinEnvironment env, String name, boolean force, byte[] bytes) {
   }

   public static class ValidationFailedException extends MixinException {
      private static final long serialVersionUID = 1L;

      public ValidationFailedException(String message, Throwable cause) {
         super(message, cause);
      }

      public ValidationFailedException(String message) {
         super(message);
      }

      public ValidationFailedException(Throwable cause) {
         super(cause);
      }
   }
}
