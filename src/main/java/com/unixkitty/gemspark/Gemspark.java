package com.unixkitty.gemspark;

import com.unixkitty.gemspark.init.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Gemspark.MODID)
public class Gemspark
{
    public static final String MODID = "gemspark";
    public static final String MODNAME = "Gemspark";

    private static final Logger LOG = LogManager.getLogger(MODNAME);

    public Gemspark()
    {
        //TODO for config
        //final ModLoadingContext modLoadingContext = ModLoadingContext.get();
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        MinecraftForge.EVENT_BUS.register(ModRegistry.class);

        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModTileEntityTypes.TILE_ENTITY_TYPES.register(modEventBus);
        ModContainerTypes.CONTAINER_TYPES.register(modEventBus);
    }

    public static Logger log()
    {
        return LOG;
    }
}
