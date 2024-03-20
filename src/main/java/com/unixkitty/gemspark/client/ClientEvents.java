package com.unixkitty.gemspark.client;

import com.unixkitty.gemspark.Gemspark;
import com.unixkitty.gemspark.client.gui.PedestalScreen;
import com.unixkitty.gemspark.client.render.BlockEntityPedestalRender;
import com.unixkitty.gemspark.compat.CuriosCompat;
import com.unixkitty.gemspark.init.ModBlockEntityTypes;
import com.unixkitty.gemspark.init.ModContainerTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@SuppressWarnings("unused")
@Mod.EventBusSubscriber(modid = Gemspark.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class ClientEvents
{
    @SubscribeEvent
    public static void onFMLClientSetupEvent(final FMLClientSetupEvent event)
    {
        event.enqueueWork(() -> MenuScreens.register(ModContainerTypes.PEDESTAL.get(), PedestalScreen::new));

        CuriosCompat.registerRenderers();
    }

    @SubscribeEvent
    public static void registerModels(EntityRenderersEvent.RegisterRenderers event)
    {
        event.registerBlockEntityRenderer(ModBlockEntityTypes.PEDESTAL.get(), BlockEntityPedestalRender::new);
    }

}
