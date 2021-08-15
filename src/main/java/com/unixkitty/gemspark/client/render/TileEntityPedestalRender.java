package com.unixkitty.gemspark.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.unixkitty.gemspark.tileentity.TileEntityPedestal;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.vector.Vector3f;

import javax.annotation.Nonnull;
import java.util.Objects;

public class TileEntityPedestalRender extends TileEntityRenderer<TileEntityPedestal>
{
    private ItemEntity itemEntity;

    public TileEntityPedestalRender(TileEntityRendererDispatcher rendererDispatcherIn)
    {
        super(rendererDispatcherIn);
    }

    @Override
    public void render(@Nonnull TileEntityPedestal pedestal, float partialTicks, MatrixStack matrix, IRenderTypeBuffer buffer, int light, int overlay)
    {
        if (pedestal.getLevel() == null) return;

        if (!pedestal.getItemHandler().getStackInSlot(0).isEmpty())
        {
            ItemStack storedStack = pedestal.getItemHandler().getStackInSlot(0);

            matrix.pushPose();

            if (itemEntity == null)
            {
                itemEntity = new ItemEntity(Objects.requireNonNull(pedestal.getLevel()), pedestal.getBlockPos().getX(), pedestal.getBlockPos().getY() + 1, pedestal.getBlockPos().getZ(), storedStack);
                itemEntity.makeFakeItem();
            }

            itemEntity.setItem(storedStack);

            if (pedestal.shouldRotate)
            {
                matrix.translate(0.5f, 1.25f, 0.5f);

                long gametime = pedestal.getLevel().getGameTime();

                matrix.translate(0, Math.sin((gametime - pedestal.lastChangeTime + partialTicks) / 8) / 16.0, 0);
                matrix.mulPose(Vector3f.YP.rotationDegrees((gametime + partialTicks) * 4));
            }
            else
            {
                matrix.translate(0.5f, 1.125f, 0.5f);
                matrix.mulPose(Vector3f.YP.rotationDegrees(pedestal.itemFacingDirection));
            }

            Minecraft.getInstance().getItemRenderer().renderStatic(itemEntity.getItem(), ItemCameraTransforms.TransformType.GROUND, light, OverlayTexture.NO_OVERLAY, matrix, buffer);

            matrix.translate(-0.5f, -1.5f, -0.5f);

            matrix.popPose();
        }
    }
}
