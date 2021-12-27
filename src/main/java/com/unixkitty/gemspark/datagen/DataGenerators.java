package com.unixkitty.gemspark.datagen;

import com.unixkitty.gemspark.Gemspark;
import com.unixkitty.gemspark.datagen.loot.ModLootTables;
import com.unixkitty.gemspark.datagen.recipe.CraftingTableRecipes;
import com.unixkitty.gemspark.datagen.recipe.SmeltingRecipes;
import com.unixkitty.gemspark.datagen.recipe.StonecutterRecipes;
import com.unixkitty.gemspark.datagen.tag.ModBlockTags;
import com.unixkitty.gemspark.datagen.tag.ModItemTags;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

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
