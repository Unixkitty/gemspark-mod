package com.unixkitty.gemspark;

import com.unixkitty.gemspark.compat.CuriosCompat;
import com.unixkitty.gemspark.init.*;
import com.unixkitty.gemspark.worldgen.OreGeneration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Gemspark.MODID)
public class Gemspark
{
    // The MODID value here should match an entry in the META-INF/mods.toml file
    public static final String MODID = "gemspark";
    public static final String MODNAME = "Gemspark";

    private static final Logger LOG = LogManager.getLogger(MODNAME);

    public Gemspark()
    {
        CuriosCompat.init();

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.COMMON_CONFIG);
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        MinecraftForge.EVENT_BUS.register(ModRegistry.class);

        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModBlockEntityTypes.BLOCK_ENTITY_TYPES.register(modEventBus);
        ModContainerTypes.CONTAINER_TYPES.register(modEventBus);

        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, OreGeneration::onBiomeLoading);
        MinecraftForge.EVENT_BUS.addListener(EventPriority.NORMAL, ModEvents::onBlockRightClicked);
    }

    public static Logger log()
    {
        return LOG;
    }
}
