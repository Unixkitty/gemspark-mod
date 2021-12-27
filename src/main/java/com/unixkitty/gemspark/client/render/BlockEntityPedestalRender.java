package com.unixkitty.gemspark.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import com.unixkitty.gemspark.blockentity.BlockEntityPedestal;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nonnull;
import java.util.Objects;

public class BlockEntityPedestalRender implements BlockEntityRenderer<BlockEntityPedestal>
{
    private ItemEntity itemEntity;

    public BlockEntityPedestalRender(BlockEntityRendererProvider.Context context)
    {

    }

    @Override
    public void render(@Nonnull BlockEntityPedestal pedestal, float partialTicks, PoseStack matrix, MultiBufferSource buffer, int light, int overlay)
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

            Minecraft.getInstance().getItemRenderer().renderStatic(itemEntity.getItem(), ItemTransforms.TransformType.GROUND, light, overlay, matrix, buffer, 1);

            matrix.translate(-0.5f, -1.5f, -0.5f);

            matrix.popPose();
        }
    }
}
