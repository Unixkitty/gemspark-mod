package com.unixkitty.gemspark.client;

import com.unixkitty.gemspark.Gemspark;
import com.unixkitty.gemspark.client.gui.PedestalScreen;
import com.unixkitty.gemspark.client.render.BlockEntityPedestalRender;
import com.unixkitty.gemspark.compat.CuriosCompat;
import com.unixkitty.gemspark.init.ModBlockEntityTypes;
import com.unixkitty.gemspark.init.ModBlocks;
import com.unixkitty.gemspark.init.ModContainerTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@SuppressWarnings("unused")
@Mod.EventBusSubscriber(modid = Gemspark.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class ClientEvents
{
    /**
     * We need to register our renderers on the client because rendering code does not exist on the server
     * and trying to use it on a dedicated server will crash the game.
     * <p>
     * This method will be called by Forge when it is time for the mod to do its client-side setup
     * This method will always be called after the Registry events.
     * This means that all Blocks, Items, TileEntityTypes, etc. will all have been registered already
     */
    @SubscribeEvent
    public static void onFMLClientSetupEvent(final FMLClientSetupEvent event)
    {
        // Register ContainerType Screens
        // ScreenManager.registerFactory is not safe to call during parallel mod loading, so we queue it to run later
        event.enqueueWork(() ->
        {
            MenuScreens.register(ModContainerTypes.PEDESTAL.get(), PedestalScreen::new);
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.BRAZIER.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.SOUL_BRAZIER.get(), RenderType.cutout());

        });

        CuriosCompat.registerRenderers();
    }

    @SubscribeEvent
    public static void registerModels(EntityRenderersEvent.RegisterRenderers event)
    {
        event.registerBlockEntityRenderer(ModBlockEntityTypes.PEDESTAL.get(), BlockEntityPedestalRender::new);
    }

}
