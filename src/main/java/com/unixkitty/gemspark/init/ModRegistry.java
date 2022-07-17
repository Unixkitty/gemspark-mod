package com.unixkitty.gemspark.init;

import com.unixkitty.gemspark.Gemspark;
import com.unixkitty.gemspark.itemgroup.ModItemGroups;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

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
                event.getRegistry().register(new BlockItem(block, new Item.Properties().tab(ModItemGroups.PRIMARY)).setRegistryName(Objects.requireNonNull(block.getRegistryName())))
        );
    }
}
