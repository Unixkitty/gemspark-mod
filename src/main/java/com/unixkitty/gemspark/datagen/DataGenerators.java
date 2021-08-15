package com.unixkitty.gemspark.datagen;

import com.unixkitty.gemspark.Gemspark;
import com.unixkitty.gemspark.datagen.recipe.CraftingTableRecipes;
import com.unixkitty.gemspark.datagen.recipe.SmeltingRecipes;
import com.unixkitty.gemspark.datagen.recipe.StonecutterRecipes;
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
            ModBlockTags blockTagProvider = new ModBlockTags(generator, event.getExistingFileHelper());
            generator.addProvider(blockTagProvider);
            generator.addProvider(new ModItemTags(generator, event.getExistingFileHelper(), blockTagProvider));
            generator.addProvider(new CraftingTableRecipes(generator));
            generator.addProvider(new SmeltingRecipes(generator));
            generator.addProvider(new ModLootTables(generator));
            generator.addProvider(new StonecutterRecipes(generator));
        }
    }
}
