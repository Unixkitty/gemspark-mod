package com.unixkitty.gemspark.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.unixkitty.gemspark.blockentity.BlockEntityPedestal;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nonnull;
import java.util.Objects;

public class BlockEntityPedestalRender implements BlockEntityRenderer<BlockEntityPedestal>
{
    private ItemEntity itemEntity;
    private final Minecraft minecraft;
    private final ItemRenderer itemRenderer;

    public BlockEntityPedestalRender(BlockEntityRendererProvider.Context context)
    {
        this.itemRenderer = context.getItemRenderer();
        this.minecraft = Minecraft.getInstance();
    }

    @Override
    public void render(@Nonnull BlockEntityPedestal pedestal, float partialTicks, @Nonnull PoseStack poseStack, @Nonnull MultiBufferSource buffer, int light, int overlay)
    {
        if (pedestal.getLevel() == null) return;

        if (!pedestal.getItemHandler().getStackInSlot(0).isEmpty())
        {
            ItemStack storedStack = pedestal.getItemHandler().getStackInSlot(0);

            poseStack.pushPose();

            if (this.itemEntity == null)
            {
                this.itemEntity = new ItemEntity(Objects.requireNonNull(pedestal.getLevel()), pedestal.getBlockPos().getX(), pedestal.getBlockPos().getY() + 1, pedestal.getBlockPos().getZ(), storedStack);
                this.itemEntity.makeFakeItem();
            }

            this.itemEntity.setItem(storedStack);

            if (pedestal.shouldRotate)
            {
                poseStack.translate(0.5f, 1.25f, 0.5f);

                long gametime = pedestal.getLevel().getGameTime();

                poseStack.translate(0, Math.sin((gametime - pedestal.lastChangeTime + partialTicks) / 8) / 16.0, 0);
                poseStack.mulPose(Axis.YP.rotationDegrees((gametime + partialTicks) * 4));
            }
            else
            {
                poseStack.translate(0.5f, 1.125f, 0.5f);
                poseStack.mulPose(Axis.YP.rotationDegrees(pedestal.itemFacingDirection));
            }

            this.itemRenderer.renderStatic(itemEntity.getItem(), ItemDisplayContext.GROUND, light, overlay, poseStack, buffer, minecraft.level, 1);

            poseStack.translate(-0.5f, -1.5f, -0.5f);

            poseStack.popPose();
        }
    }
}
