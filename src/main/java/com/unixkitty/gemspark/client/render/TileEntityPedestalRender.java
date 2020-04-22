package com.unixkitty.gemspark.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.unixkitty.gemspark.tileentity.TileEntityPedestal;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;

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
        if (!pedestal.getItemHandler().getStackInSlot(0).isEmpty())
        {
            ItemStack storedStack = pedestal.getItemHandler().getStackInSlot(0);

            matrix.push();

            if (itemEntity == null)
            {
                itemEntity = new ItemEntity(Objects.requireNonNull(pedestal.getWorld()), pedestal.getPos().getX(), pedestal.getPos().getY() + 1, pedestal.getPos().getZ(), storedStack);
                itemEntity.makeFakeItem();
            }

            itemEntity.setItem(storedStack);

            if (pedestal.shouldRotate)
            {
                matrix.translate(0.5f, 1.25f, 0.5f);

                long gametime = pedestal.getWorld().getGameTime();

                matrix.translate(0, Math.sin((gametime - pedestal.lastChangeTime + partialTicks) / 8) / 16.0, 0);
                matrix.rotate(Vector3f.YP.rotationDegrees((gametime + partialTicks) * 4));
            }
            else
            {
                matrix.translate(0.5f, 1.125f, 0.5f);
                //if (partialTicks > 0.9) Gemspark.log().debug("Facing render: " + pedestal.itemFacingDirection);
                matrix.rotate(Vector3f.YP.rotationDegrees(pedestal.itemFacingDirection));
            }

            Minecraft.getInstance().getItemRenderer().renderItem(itemEntity.getItem(), ItemCameraTransforms.TransformType.GROUND, light, OverlayTexture.NO_OVERLAY, matrix, buffer);

            matrix.translate(-0.5f, -1.5f, -0.5f);

            matrix.pop();
        }
    }
}
