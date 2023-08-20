package org.spongepowered.asm.mixin.injection.invoke.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.analysis.Analyzer;
import org.spongepowered.asm.lib.tree.analysis.AnalyzerException;
import org.spongepowered.asm.lib.tree.analysis.BasicInterpreter;
import org.spongepowered.asm.lib.tree.analysis.BasicValue;
import org.spongepowered.asm.lib.tree.analysis.Frame;
import org.spongepowered.asm.lib.tree.analysis.Interpreter;

public class InsnFinder {
   private static final Logger logger = LogManager.getLogger("mixin");

   public AbstractInsnNode findPopInsn(org.spongepowered.asm.mixin.injection.struct.Target target, AbstractInsnNode node) {
      try {
         (new InsnFinder.PopAnalyzer(node)).analyze(target.classNode.name, target.method);
      } catch (AnalyzerException var4) {
         if (var4.getCause() instanceof InsnFinder.AnalysisResultException) {
            return ((InsnFinder.AnalysisResultException)var4.getCause()).getResult();
         }

         logger.catching(var4);
      }

      return null;
   }

   static class AnalysisResultException extends RuntimeException {
      private static final long serialVersionUID = 1L;
      private AbstractInsnNode result;

      public AnalysisResultException(AbstractInsnNode popNode) {
         this.result = popNode;
      }

      public AbstractInsnNode getResult() {
         return this.result;
      }
   }

   static enum AnalyzerState {
      SEARCH,
      ANALYSE,
      COMPLETE;
   }

   static class PopAnalyzer extends Analyzer {
      protected final AbstractInsnNode node;

      public PopAnalyzer(AbstractInsnNode node) {
         super(new BasicInterpreter());
         this.node = node;
      }

      protected Frame newFrame(int locals, int stack) {
         return new InsnFinder.PopAnalyzer.PopFrame(locals, stack);
      }

      class PopFrame extends Frame {
         private AbstractInsnNode current;
         private InsnFinder.AnalyzerState state = InsnFinder.AnalyzerState.SEARCH;
         private int depth = 0;

         public PopFrame(int locals, int stack) {
            super(locals, stack);
         }

         public void execute(AbstractInsnNode insn, Interpreter interpreter) throws AnalyzerException {
            this.current = insn;
            super.execute(insn, interpreter);
         }

         public void push(BasicValue value) throws IndexOutOfBoundsException {
            if (this.current == PopAnalyzer.this.node && this.state == InsnFinder.AnalyzerState.SEARCH) {
               this.state = InsnFinder.AnalyzerState.ANALYSE;
               ++this.depth;
            } else if (this.state == InsnFinder.AnalyzerState.ANALYSE) {
               ++this.depth;
            }

            super.push(value);
         }

         public BasicValue pop() throws IndexOutOfBoundsException {
            if (this.state == InsnFinder.AnalyzerState.ANALYSE && --this.depth == 0) {
               this.state = InsnFinder.AnalyzerState.COMPLETE;
               throw new InsnFinder.AnalysisResultException(this.current);
            } else {
               return (BasicValue)super.pop();
            }
         }
      }
   }
}
