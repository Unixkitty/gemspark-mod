package com.unixkitty.gemspark.client.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import com.unixkitty.gemspark.Gemspark;
import com.unixkitty.gemspark.container.ContainerPedestal;
import com.unixkitty.gemspark.init.ModBlocks;
import com.unixkitty.gemspork.lib.HelperUtil;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class PedestalScreen extends ContainerScreen<ContainerPedestal>
{
    private static final ResourceLocation BACKGROUND_TEXTURE = HelperUtil.prefixResource(Gemspark.MODID, "textures/gui/container/pedestal.png");

    public PedestalScreen(final ContainerPedestal container, final PlayerInventory inventory, final ITextComponent title)
    {
        super(container, inventory, title);
    }

    @Override
    public void render(MatrixStack matrixStack, final int mouseX, final int mouseY, final float partialTicks)
    {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.func_230459_a_(matrixStack, mouseX, mouseY); //renderHoveredToolTip
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int mouseX, int mouseY)
    {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        getMinecraft().getTextureManager().bindTexture(BACKGROUND_TEXTURE);

        this.blit(matrixStack, (width - xSize) / 2, (height - ySize) / 2, 0, 0, xSize, ySize);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(MatrixStack matrixStack, int mouseX, int mouseY)
    {
        String s = I18n.format(ModBlocks.QUARTZ_PEDESTAL.get().getTranslationKey());
        this.font.drawString(matrixStack, s, (float) (this.xSize / 2 - this.font.getStringWidth(s) / 2), 6.0F, 0x404040);
        this.font.drawString(matrixStack, I18n.format("container.inventory"), 8.0F, (float) (this.ySize - 96 + 2), 0x404040);
    }
}
