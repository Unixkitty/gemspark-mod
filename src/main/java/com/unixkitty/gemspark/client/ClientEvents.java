package com.unixkitty.gemspark.client;

import com.unixkitty.gemspark.Gemspark;
import com.unixkitty.gemspark.client.gui.PedestalScreen;
import com.unixkitty.gemspark.client.render.TileEntityPedestalRender;
import com.unixkitty.gemspark.init.ModBlocks;
import com.unixkitty.gemspark.init.ModContainerTypes;
import com.unixkitty.gemspark.init.ModTileEntityTypes;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.client.registry.ClientRegistry;
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
        // ScreenManager.registerFactory is not safe to call during parallel mod loading so we queue it to run later
        DeferredWorkQueue.runLater(() -> ScreenManager.register(ModContainerTypes.PEDESTAL.get(), PedestalScreen::new));

        RenderTypeLookup.setRenderLayer(ModBlocks.BRAZIER.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SOUL_BRAZIER.get(), RenderType.cutout());

        RenderTypeLookup.setRenderLayer(ModBlocks.EMERALD_GLASS.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.DIAMOND_GLASS.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.TANZANITE_GLASS.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.TOPAZ_GLASS.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SAPPHIRE_GLASS.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.PINK_SAPPHIRE_GLASS.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.RUBY_GLASS.get(), RenderType.cutout());

        RenderTypeLookup.setRenderLayer(ModBlocks.EMERALD_GLOWING_GLASS.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.DIAMOND_GLOWING_GLASS.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.TANZANITE_GLOWING_GLASS.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.TOPAZ_GLOWING_GLASS.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SAPPHIRE_GLOWING_GLASS.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.PINK_SAPPHIRE_GLOWING_GLASS.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.RUBY_GLOWING_GLASS.get(), RenderType.cutout());
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event)
    {
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.PEDESTAL.get(), TileEntityPedestalRender::new);
    }

}
