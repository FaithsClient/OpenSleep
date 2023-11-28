package rip.sleep.injection.mixins;

import java.util.UUID;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import rip.sleep.module.modules.KillAura;
import rip.sleep.Sleep;
import rip.sleep.module.modules.Teams;
import rip.sleep.management.ModuleManager;

@Mixin({LayerHeldItem.class})
public class MixinLayerHeldItem {
   private static final Minecraft mc = Minecraft.getMinecraft();
   @Shadow
   @Final
   private RendererLivingEntity<?> field_177206_a;

   @Overwrite
   public void func_177141_a(EntityLivingBase var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      ItemStack var9 = var1.getHeldItem();
      GlStateManager.pushMatrix();
      if (this.field_177206_a.getMainModel().isChild) {
         float var10 = 0.5F;
         GlStateManager.translate(0.0F, 0.625F, 0.0F);
         GlStateManager.rotate(-20.0F, -1.0F, 0.0F, 0.0F);
         GlStateManager.scale(0.5F, 0.5F, 0.5F);
      }

      Sleep var10000 = Sleep.INSTANCE;
      Sleep.c33759();
      KillAura var17 = (KillAura) ModuleManager.c25475(KillAura.class);
      UUID var11 = var1.getUniqueID();
      EntityPlayer var12 = Minecraft.getMinecraft().theWorld.getPlayerEntityByUUID(var11);
      boolean var13 = false;
      if (var12 != mc.thePlayer && var12.isBlocking()) {
         ((ModelBiped)this.field_177206_a.getMainModel()).postRenderArm(0.0325F);
         GlStateManager.translate(var1.isSneaking() ? -0.58F : -0.48F, 0.2F, -0.2F);
         GlStateManager.rotate(-10000.0F, 137290.0F, -2009900.0F, -2054900.0F);
         var13 = true;
      }

      if (var12 == mc.thePlayer && (var12.isBlocking() || KillAura.c22942())) {
         ((ModelBiped)this.field_177206_a.getMainModel()).postRenderArm(0.0325F);
         GlStateManager.translate(var1.isSneaking() ? -0.58F : -0.48F, 0.2F, -0.2F);
         GlStateManager.rotate(-10000.0F, 137290.0F, -2009900.0F, -2054900.0F);
         var13 = true;
      }

      ((ModelBiped)this.field_177206_a.getMainModel()).postRenderArm(0.0625F);
      GlStateManager.translate(-0.0625F, 0.4375F, 0.0625F);
      if (var1 instanceof EntityPlayer && ((EntityPlayer)var1).fishEntity != null) {
         var9 = new ItemStack(Items.fishing_rod, 0);
      }

      Item var14 = var9.getItem();
      Minecraft var15 = Minecraft.getMinecraft();
      if (var14 instanceof ItemBlock && Block.getBlockFromItem(var14).getRenderType() == 2) {
         GlStateManager.translate(0.0F, 0.1875F, -0.3125F);
         GlStateManager.rotate(10.0F, 1.0F, 0.0F, 0.0F);
         GlStateManager.rotate(10.0F, 0.0F, 1.0F, 0.0F);
         float var16 = 0.32F;
         GlStateManager.scale(-var16, -var16, var16);
      }

      if (var1.isSneaking()) {
         GlStateManager.translate(0.0F, 0.203125F, 0.0F);
      }

      Sleep.c33759();
      Teams var20 = (Teams) ModuleManager.c25475(Teams.class);
      if (!var20.c1732(var1)) {
         var15.getItemRenderer().renderItem(var1, var9, TransformType.THIRD_PERSON);
      }

      GlStateManager.popMatrix();
   }
}
