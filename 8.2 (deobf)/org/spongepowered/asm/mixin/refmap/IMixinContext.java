package org.spongepowered.asm.mixin.refmap;

import org.spongepowered.asm.lib.tree.MethodNode;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;
import org.spongepowered.asm.mixin.transformer.ext.Extensions;

public interface IMixinContext {
   IMixinInfo getMixin();

   Extensions getExtensions();

   String getClassName();

   String getClassRef();

   String getTargetClassRef();

   IReferenceMapper getReferenceMapper();

   boolean getOption(MixinEnvironment.Option var1);

   int getPriority();

   org.spongepowered.asm.mixin.injection.struct.Target getTargetMethod(MethodNode var1);
}
