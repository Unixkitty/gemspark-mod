package com.unixkitty.gemspark.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.unixkitty.gemspark.Gemspark;
import com.unixkitty.gemspark.container.ContainerPedestal;
import com.unixkitty.gemspark.util.HelperUtil;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class PedestalScreen extends AbstractContainerScreen<ContainerPedestal>
{
    private static final ResourceLocation BACKGROUND_TEXTURE = HelperUtil.prefixResource(Gemspark.MODID, "textures/gui/container/pedestal.png");

    public PedestalScreen(final ContainerPedestal container, final Inventory inventory, final Component title)
    {
        super(container, inventory, title);
    }

    @Override
    protected void init()
    {
        super.init();

        this.titleLabelX = (this.imageWidth - this.font.width(this.title)) / 2;
    }

    @Override
    public void render(PoseStack matrixStack, final int mouseX, final int mouseY, final float partialTicks)
    {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderTooltip(matrixStack, mouseX, mouseY);
    }

    @Override
    protected void renderBg(PoseStack matrixStack, float partialTicks, int mouseX, int mouseY)
    {
        RenderSystem.setShaderTexture(0, BACKGROUND_TEXTURE);
        this.blit(matrixStack, (width - imageWidth) / 2, (height - imageHeight) / 2, 0, 0, imageWidth, imageHeight);
    }
}
