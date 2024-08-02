package com.unixkitty.gemspark.client;

import com.google.common.collect.ImmutableList;
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
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.GlassBlock;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.util.List;

@SuppressWarnings("unused")
@Mod.EventBusSubscriber(modid = Gemspark.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class ClientEvents
{
    private static final List<String> EMISSIVES = ImmutableList.of(
            "gemspark:dark_rainbow_bricks#",
            "gemspark:light_rainbow_bricks#",
            "gemspark:diamond_gemspark_block#",
            "gemspark:emerald_gemspark_block#",
            "gemspark:pink_sapphire_gemspark_block#",
            "gemspark:ruby_gemspark_block#",
            "gemspark:tanzanite_gemspark_block#",
            "gemspark:sapphire_gemspark_block#",
            "gemspark:topaz_gemspark_block#",
            "gemspark:false_halo#",
            "gemspark:witch_hat#"
    );

    @SubscribeEvent
    public static void onFMLClientSetupEvent(final FMLClientSetupEvent event)
    {
        event.enqueueWork(() ->
        {
            MenuScreens.register(ModContainerTypes.PEDESTAL.get(), PedestalScreen::new);

            ModBlocks.BLOCKS.getEntries().forEach(blockRegistryObject ->
            {
                if (blockRegistryObject.get() instanceof GlassBlock || blockRegistryObject.get() instanceof IronBarsBlock)
                {
                    //Athena ignores json render type viariable
                    //noinspection deprecation
                    ItemBlockRenderTypes.setRenderLayer(blockRegistryObject.get(), RenderType.cutout());
                }
            });
        });

        CuriosCompat.registerRenderers();
    }

    @SubscribeEvent
    public static void registerModels(EntityRenderersEvent.RegisterRenderers event)
    {
        event.registerBlockEntityRenderer(ModBlockEntityTypes.PEDESTAL.get(), BlockEntityPedestalRender::new);
    }

    @SubscribeEvent
    public static void bakeModels(final ModelEvent.ModifyBakingResult event)
    {
        for (ResourceLocation id : event.getModels().keySet())
        {
            if (EMISSIVES.stream().anyMatch(str -> id.toString().startsWith(str)))
            {
                event.getModels().put(id, new BakedModelShadeLayerFullbright(event.getModels().get(id)));
            }
        }
    }
}
