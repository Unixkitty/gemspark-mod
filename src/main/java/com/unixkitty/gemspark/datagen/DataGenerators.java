package com.unixkitty.gemspark.datagen;

import com.unixkitty.gemspark.Gemspark;
import com.unixkitty.gemspark.datagen.loot.ModLootTables;
import com.unixkitty.gemspark.datagen.recipe.CraftingTableRecipes;
import com.unixkitty.gemspark.datagen.recipe.SmeltingRecipes;
import com.unixkitty.gemspark.datagen.recipe.StonecutterRecipes;
import com.unixkitty.gemspark.datagen.tag.ModBlockTags;
import com.unixkitty.gemspark.datagen.tag.ModItemTags;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@SuppressWarnings("unused")
@Mod.EventBusSubscriber(modid = Gemspark.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class DataGenerators
{
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event)
    {
        DataGenerator generator = event.getGenerator();
        ModBlockTags blockTagProvider = new ModBlockTags(generator, event.getExistingFileHelper());
        generator.addProvider(event.includeServer(), blockTagProvider);
        generator.addProvider(event.includeServer(), new ModItemTags(generator, event.getExistingFileHelper(), blockTagProvider));
        generator.addProvider(event.includeServer(), new CraftingTableRecipes(generator));
        generator.addProvider(event.includeServer(), new SmeltingRecipes(generator));
        generator.addProvider(event.includeServer(), new ModLootTables(generator));
        generator.addProvider(event.includeServer(), new StonecutterRecipes(generator));
    }
}
