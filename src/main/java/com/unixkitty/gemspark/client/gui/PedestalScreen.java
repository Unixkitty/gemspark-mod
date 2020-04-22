package com.unixkitty.gemspark.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import com.unixkitty.gemspark.Gemspark;
import com.unixkitty.gemspark.container.ContainerPedestal;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class PedestalScreen extends ContainerScreen<ContainerPedestal>
{
    private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation(Gemspark.MODID, "textures/gui/container/pedestal.png");

    public PedestalScreen(final ContainerPedestal container, final PlayerInventory inventory, final ITextComponent title)
    {
        super(container, inventory, title);
    }

    @Override
    public void render(final int mouseX, final int mouseY, final float partialTicks)
    {
        this.renderBackground();
        super.render(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        getMinecraft().getTextureManager().bindTexture(BACKGROUND_TEXTURE);

        this.blit((width - xSize) / 2, (height - ySize) / 2, 0, 0, xSize, ySize);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        super.drawGuiContainerForegroundLayer(mouseX, mouseY);

        String s = this.title.getFormattedText();
        this.font.drawString(s, (float) (this.xSize / 2 - this.font.getStringWidth(s) / 2), 6.0F, 0x404040);
        this.font.drawString(this.playerInventory.getDisplayName().getFormattedText(), 8.0F, (float) (this.ySize - 96 + 2), 0x404040);
    }
}
