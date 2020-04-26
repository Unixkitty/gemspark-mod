package com.unixkitty.gemspark.datagen;

import com.unixkitty.gemspark.Gemspark;
import com.unixkitty.gemspark.datagen.recipe.CraftingTableRecipeProvider;
import com.unixkitty.gemspark.datagen.recipe.SmeltingRecipeProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

//This gets called directly by Forge?
@SuppressWarnings("unused")
@Mod.EventBusSubscriber(modid = Gemspark.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class DataGenerators
{
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event)
    {
        DataGenerator generator = event.getGenerator();
        if (event.includeServer())
        {
            generator.addProvider(new BlockTagProvider(generator));
            generator.addProvider(new ItemTagProvider(generator));
            generator.addProvider(new CraftingTableRecipeProvider(generator));
            generator.addProvider(new SmeltingRecipeProvider(generator));
            generator.addProvider(new ModLootTables(generator));
        }
    }
}
