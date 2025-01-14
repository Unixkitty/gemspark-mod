package com.unixkitty.gemspark.compat;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.unixkitty.gemspark.init.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModList;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.SlotTypePreset;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;
import top.theillusivec4.curios.api.client.ICurioRenderer;

public class CuriosCompat
{
    public static final String MODID = CuriosApi.MODID;
    public static boolean isModLoaded = false;

    public static void init()
    {
        isModLoaded = ModList.get().isLoaded(MODID);

        if (!isModLoaded) return;

        InterModComms.sendTo(MODID, SlotTypeMessage.REGISTER_TYPE, () -> SlotTypePreset.HEAD.getMessageBuilder().cosmetic().build());
        InterModComms.sendTo(MODID, SlotTypeMessage.REGISTER_TYPE, () -> SlotTypePreset.CURIO.getMessageBuilder().cosmetic().build());
    }

    public static void registerRenderers()
    {
        if (isModLoaded)
        {
            CuriosRendererRegistry.register(ModItems.SPECTACLES.get(), CurioItemRenderer::new);
            CuriosRendererRegistry.register(ModItems.GLASSES_TECHNICOLOR.get(), CurioItemRenderer::new);
            CuriosRendererRegistry.register(ModItems.GLASSES_3D.get(), CurioItemRenderer::new);
            CuriosRendererRegistry.register(ModItems.GLASSES_RED.get(), CurioItemRenderer::new);
            CuriosRendererRegistry.register(ModItems.WITCH_HAT.get(), CurioItemRenderer::new);
            CuriosRendererRegistry.register(ModItems.BUNNYBAND.get(), CurioItemRenderer::new);
            CuriosRendererRegistry.register(ModItems.FALSE_HALO.get(), CurioItemRenderer::new);
            CuriosRendererRegistry.register(ModItems.FARMER_HAT.get(), CurioItemRenderer::new);
            CuriosRendererRegistry.register(ModItems.HEADPHONES.get(), CurioItemRenderer::new);
            CuriosRendererRegistry.register(ModItems.REDBACKRIBBON.get(), CurioItemRenderer::new);
            CuriosRendererRegistry.register(ModItems.SPITFIRECAP.get(), CurioItemRenderer::new);
            CuriosRendererRegistry.register(ModItems.FUNKY_ALIEN_GLASSES.get(), CurioItemRenderer::new);
            CuriosRendererRegistry.register(ModItems.TANZANITE_TIARA.get(), CurioItemRenderer::new);
            CuriosRendererRegistry.register(ModItems.SILVER_TANZANITE_TIARA.get(), CurioItemRenderer::new);
            CuriosRendererRegistry.register(ModItems.EMERALD_TIARA.get(), CurioItemRenderer::new);
            CuriosRendererRegistry.register(ModItems.SILVER_EMERALD_TIARA.get(), CurioItemRenderer::new);
            CuriosRendererRegistry.register(ModItems.SAPPHIRE_TIARA.get(), CurioItemRenderer::new);
            CuriosRendererRegistry.register(ModItems.SILVER_SAPPHIRE_TIARA.get(), CurioItemRenderer::new);
            CuriosRendererRegistry.register(ModItems.RUBY_CROWN.get(), CurioItemRenderer::new);
            CuriosRendererRegistry.register(ModItems.SILVER_RUBY_CROWN.get(), CurioItemRenderer::new);
            CuriosRendererRegistry.register(ModItems.RGB_CROWN.get(), CurioItemRenderer::new);
            CuriosRendererRegistry.register(ModItems.SILVER_RGB_CROWN.get(), CurioItemRenderer::new);
            CuriosRendererRegistry.register(ModItems.GOAT_HORNS.get(), CurioItemRenderer::new);
        }
    }

    public static class CurioItemRenderer implements ICurioRenderer
    {
        @Override
        public <T extends LivingEntity, M extends EntityModel<T>> void render(ItemStack stack, SlotContext slotContext, PoseStack poseStack, RenderLayerParent<T, M> renderLayerParent, MultiBufferSource renderTypeBuffer, int light, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch)
        {
            if (!stack.isEmpty())
            {
                LivingEntity livingEntity = slotContext.entity();
                Minecraft minecraft = Minecraft.getInstance();

                EntityRenderer<? super LivingEntity> render = minecraft.getEntityRenderDispatcher().getRenderer(livingEntity);

                if (render instanceof LivingEntityRenderer)
                {
                    @SuppressWarnings("unchecked") LivingEntityRenderer<LivingEntity, EntityModel<LivingEntity>> livingRenderer = (LivingEntityRenderer<LivingEntity, EntityModel<LivingEntity>>) render;
                    EntityModel<LivingEntity> model = livingRenderer.getModel();

                    if (model instanceof HumanoidModel)
                    {
                        poseStack.pushPose();

                        //Follow the head
                        ((HumanoidModel<LivingEntity>) model).head.translateAndRotate(poseStack);

                        poseStack.translate(0.0F, -0.05F, -0.3F);

                        poseStack.translate(0D, -0.2F, 0.3F);
                        poseStack.scale(0.625F, 0.625F, 0.625F);
                        poseStack.mulPose(Axis.XP.rotationDegrees(180.0F));
                        poseStack.mulPose(Axis.YP.rotationDegrees(180.0F));

                        minecraft.getItemRenderer().renderStatic(stack, ItemDisplayContext.HEAD, light, OverlayTexture.NO_OVERLAY, poseStack, renderTypeBuffer, minecraft.level, 0);

                        poseStack.popPose();
                    }
                }
            }
        }
    }
}
