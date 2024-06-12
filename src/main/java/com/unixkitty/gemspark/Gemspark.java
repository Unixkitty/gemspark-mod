package com.unixkitty.gemspark;

import com.unixkitty.gemspark.compat.CuriosCompat;
import com.unixkitty.gemspark.init.ModBlockEntityTypes;
import com.unixkitty.gemspark.init.ModBlocks;
import com.unixkitty.gemspark.init.ModContainerTypes;
import com.unixkitty.gemspark.init.ModItems;
import com.unixkitty.gemspark.item.ModCreativeTab;
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

        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModCreativeTab.CREATIVE_TABS.register(modEventBus);

        ModBlockEntityTypes.BLOCK_ENTITY_TYPES.register(modEventBus);
        ModContainerTypes.CONTAINER_TYPES.register(modEventBus);

//        MinecraftForge.EVENT_BUS.addListener(EventPriority.NORMAL, ModEvents::onBlockRightClicked);
//        modEventBus.addListener(ModEvents::onLivingHurt);
    }

    public static Logger log()
    {
        return LOG;
    }
}
