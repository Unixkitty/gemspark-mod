package com.unixkitty.gemspark.compat;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.unixkitty.gemspark.item.SimpleCapProvider;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModList;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.CuriosCapability;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.SlotTypePreset;
import top.theillusivec4.curios.api.type.capability.ICurio;

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


    public static ICapabilityProvider initCap(ItemStack stack)
    {
        if (!isModLoaded) return null;

        return new SimpleCapProvider<>(CuriosCapability.ITEM, new ICurio()
        {
            @Override
            public boolean canRender(String identifier, int index, LivingEntity livingEntity)
            {
                return true;
            }

            @Override
            public void render(String identifier, int index, MatrixStack matrixStack, IRenderTypeBuffer renderTypeBuffer, int light, LivingEntity livingEntity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch)
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

                    Minecraft.getInstance().getItemRenderer().renderStatic(stack, ItemCameraTransforms.TransformType.HEAD, light, OverlayTexture.NO_OVERLAY, matrixStack, renderTypeBuffer);

                    matrixStack.popPose();

                }
            }
        });
    }
}
