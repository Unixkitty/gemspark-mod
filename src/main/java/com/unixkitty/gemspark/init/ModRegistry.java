package com.unixkitty.gemspark.init;

import com.unixkitty.gemspark.Gemspark;
import com.unixkitty.gemspark.itemgroup.ModItemGroups;
import com.unixkitty.gemspark.worldgen.OreGeneration;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import java.util.Objects;

@SuppressWarnings("unused")
@Mod.EventBusSubscriber(modid = Gemspark.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class ModRegistry
{
    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event)
    {
        // BlockItems for all blocks
        ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block ->
                event.getRegistry().register(new BlockItem(block, new Item.Properties().group(ModItemGroups.PRIMARY)).setRegistryName(Objects.requireNonNull(block.getRegistryName())))
        );
    }

    @SubscribeEvent
    public static void onCommonSetup(final FMLCommonSetupEvent event)
    {
        OreGeneration.register();
    }
}
