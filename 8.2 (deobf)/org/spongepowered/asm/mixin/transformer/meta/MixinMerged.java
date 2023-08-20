package org.spongepowered.asm.mixin.transformer.meta;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@java.lang.annotation.Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MixinMerged {
   String mixin();

   int priority();
}
