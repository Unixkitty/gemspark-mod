package com.unixkitty.gemspark.datagen;

import com.unixkitty.gemspark.Gemspark;
import com.unixkitty.gemspark.datagen.loot.ModBlockLootTables;
import com.unixkitty.gemspark.datagen.model.ModBlockStates;
import com.unixkitty.gemspark.datagen.model.ModItemModels;
import com.unixkitty.gemspark.datagen.recipe.CraftingRecipes;
import com.unixkitty.gemspark.datagen.tag.ModBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@SuppressWarnings("unused")
@Mod.EventBusSubscriber(modid = Gemspark.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators
{
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event)
    {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

//        generator.addProvider(event.includeClient(), new ModBlockModels(packOutput, event.getExistingFileHelper()));
        generator.addProvider(event.includeClient(), new ModBlockStates(packOutput, event.getExistingFileHelper()));
        generator.addProvider(event.includeClient(), new ModItemModels(packOutput, event.getExistingFileHelper()));
//        generator.addProvider(event.includeClient(), new ModLanguageProvider(packOutput, "en_us"));
        generator.addProvider(event.includeServer(), new LootTableProvider(packOutput, Collections.emptySet(),
                List.of(new LootTableProvider.SubProviderEntry(ModBlockLootTables::new, LootContextParamSets.BLOCK))));
        generator.addProvider(event.includeServer(), new CraftingRecipes(packOutput));

        generator.addProvider(event.includeServer(), new ModBlockTags(packOutput, lookupProvider, event.getExistingFileHelper()));
    }
}
