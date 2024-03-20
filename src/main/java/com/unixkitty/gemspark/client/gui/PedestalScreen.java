package com.unixkitty.gemspark.client.gui;

import com.unixkitty.gemspark.Gemspark;
import com.unixkitty.gemspark.container.ContainerPedestal;
import com.unixkitty.gemspark.util.HelperUtil;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

import javax.annotation.Nonnull;

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
    public void render(@Nonnull GuiGraphics guiGraphics, int pMouseX, int pMouseY, float pPartialTick)
    {
        this.renderBackground(guiGraphics);
        super.render(guiGraphics, pMouseX, pMouseY, pPartialTick);
        this.renderTooltip(guiGraphics, pMouseX, pMouseY);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float pPartialTick, int pMouseX, int pMouseY)
    {
        guiGraphics.blit(BACKGROUND_TEXTURE, (width - imageWidth) / 2, (height - imageHeight) / 2, 0, 0, imageWidth, imageHeight);
    }
}
