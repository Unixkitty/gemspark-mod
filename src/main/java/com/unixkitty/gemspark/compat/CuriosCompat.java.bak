package com.unixkitty.gemspark.compat;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import com.unixkitty.gemspark.init.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.entity.LivingEntity;
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
        }
    }

    public static class CurioItemRenderer implements ICurioRenderer
    {
        @Override
        public <T extends LivingEntity, M extends EntityModel<T>> void render(ItemStack stack, SlotContext slotContext, PoseStack matrixStack, RenderLayerParent<T, M> renderLayerParent, MultiBufferSource renderTypeBuffer, int light, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch)
        {
            if (!stack.isEmpty())
            {
                matrixStack.pushPose();

                //Follow the head
                if (slotContext.entity().isVisuallySwimming() || slotContext.entity().isFallFlying())
                {
                    matrixStack.mulPose(Vector3f.ZP.rotationDegrees(slotContext.entity().yHeadRot));
                    matrixStack.mulPose(Vector3f.YP.rotationDegrees(netHeadYaw));
                    matrixStack.mulPose(Vector3f.XP.rotationDegrees(-45.0F));
                }
                else
                {
                    if (slotContext.entity().isCrouching())
                    {
                        matrixStack.translate(0.0F, 0.25F, 0.0F);
                    }

                    matrixStack.mulPose(Vector3f.YP.rotationDegrees(netHeadYaw));
                    matrixStack.mulPose(Vector3f.XP.rotationDegrees(headPitch));
                }

                matrixStack.translate(0.0F, -0.05F, -0.3F);

                matrixStack.translate(0D, -(0.2D), 0.3D);
                matrixStack.scale(0.625F, 0.625F, 0.625F);
                matrixStack.mulPose(Vector3f.XP.rotationDegrees(180.0F));
                matrixStack.mulPose(Vector3f.YP.rotationDegrees(180.0F));

                Minecraft.getInstance().getItemRenderer().renderStatic(stack, ItemTransforms.TransformType.HEAD, light, OverlayTexture.NO_OVERLAY, matrixStack, renderTypeBuffer, 1);

                matrixStack.popPose();

            }
        }
    }

    /*public static ICapabilityProvider initCap(ItemStack stack)
    {
        if (!isModLoaded) return null;

        return new SimpleCapProvider<>(CuriosCapability.ITEM, new ICurio()
        {
            @Override
            public ItemStack getStack()
            {
                return stack;
            }

            @Override
            public boolean canRender(String identifier, int index, LivingEntity livingEntity)
            {
                return true;
            }

            @Override
            public void render(String identifier, int index, PoseStack matrixStack, MultiBufferSource renderTypeBuffer, int light, LivingEntity livingEntity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch)
            {
                EntityRenderer<?> renderer = Minecraft.getInstance().getEntityRenderDispatcher().getRenderer(livingEntity);
                if (!(renderer instanceof IEntityRenderer<?, ?>))
                {
                    return;
                }
                EntityModel<?> model = ((IEntityRenderer<?, ?>) renderer).getModel();
                if (!(model instanceof BipedModel<?>))
                {
                    return;
                }

                if (!stack.isEmpty())
                {
                    matrixStack.pushPose();

                    //Follow the head
                    if (livingEntity.isVisuallySwimming() || livingEntity.isFallFlying())
                    {
                        matrixStack.mulPose(Vector3f.ZP.rotationDegrees(livingEntity.yHeadRot));
                        matrixStack.mulPose(Vector3f.YP.rotationDegrees(netHeadYaw));
                        matrixStack.mulPose(Vector3f.XP.rotationDegrees(-45.0F));
                    }
                    else
                    {
                        if (livingEntity.isCrouching())
                        {
                            matrixStack.translate(0.0F, 0.25F, 0.0F);
                        }

                        matrixStack.mulPose(Vector3f.YP.rotationDegrees(netHeadYaw));
                        matrixStack.mulPose(Vector3f.XP.rotationDegrees(headPitch));
                    }

                    matrixStack.translate(0.0F, -0.05F, -0.3F);

                    matrixStack.translate(0D, -(0.2D), 0.3D);
                    matrixStack.scale(0.625F, 0.625F, 0.625F);
                    matrixStack.mulPose(Vector3f.XP.rotationDegrees(180.0F));
                    matrixStack.mulPose(Vector3f.YP.rotationDegrees(180.0F));

                    Minecraft.getInstance().getItemRenderer().renderStatic(stack, ItemTransforms.TransformType.HEAD, light, OverlayTexture.NO_OVERLAY, matrixStack, renderTypeBuffer, 1);

                    matrixStack.popPose();

                }
            }
        });
    }*/
}
