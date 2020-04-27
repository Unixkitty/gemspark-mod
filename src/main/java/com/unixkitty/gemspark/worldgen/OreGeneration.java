package com.unixkitty.gemspark.worldgen;

import com.unixkitty.gemspark.Config;
import com.unixkitty.gemspark.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGeneration
{
    private static boolean initialized = false;

    public static void init()
    {
        if (initialized) return;
        initialized = true;

        OreFeatureConfig.FillerBlockType fillerBlockType;

        for (Biome biome : ForgeRegistries.BIOMES.getValues())
        {
            if (biome.getCategory() == Biome.Category.THEEND)
            {
                //noinspection UnnecessaryContinue
                continue;
            }
            else if (biome.getCategory() == Biome.Category.NETHER)
            {
                fillerBlockType = OreFeatureConfig.FillerBlockType.NETHERRACK;

                addOre(biome, fillerBlockType,
                        ModBlocks.PINK_SAPPHIRE_ORE.get(),
                        Config.generatePinkSapphireOre.get(),
                        Config.pinkSapphireVeinSize.get(),
                        Config.pinkSapphireVeinsPerChunk.get(),
                        Config.pinkSapphireMinHeight.get(),
                        Config.pinkSapphireMaxHeight.get()
                );
            }
            else
            {
                fillerBlockType = OreFeatureConfig.FillerBlockType.NATURAL_STONE;

                addOre(biome, fillerBlockType,
                        ModBlocks.TANZANITE_ORE.get(),
                        Config.generateTanzaniteOre.get(),
                        Config.tanzaniteVeinSize.get(),
                        Config.tanzaniteVeinsPerChunk.get(),
                        Config.tanzaniteMinHeight.get(),
                        Config.tanzaniteMaxHeight.get()
                );
                addOre(biome, fillerBlockType,
                        ModBlocks.TOPAZ_ORE.get(),
                        Config.generateTopazOre.get(),
                        Config.topazVeinSize.get(),
                        Config.topazVeinsPerChunk.get(),
                        Config.topazMinHeight.get(),
                        Config.topazMaxHeight.get()
                );
                addOre(biome, fillerBlockType,
                        ModBlocks.SAPPHIRE_ORE.get(),
                        Config.generateSapphireOre.get(),
                        Config.sapphireVeinSize.get(),
                        Config.sapphireVeinsPerChunk.get(),
                        Config.sapphireMinHeight.get(),
                        Config.sapphireMaxHeight.get()
                );
                addOre(biome, fillerBlockType,
                        ModBlocks.RUBY_ORE.get(),
                        Config.generateRubyOre.get(),
                        Config.rubyVeinSize.get(),
                        Config.rubyVeinsPerChunk.get(),
                        Config.rubyMinHeight.get(),
                        Config.rubyMaxHeight.get()
                );
            }
        }
    }

    private static void addOre(Biome biome, OreFeatureConfig.FillerBlockType replaceBlock, Block ore, boolean enabled, int veinSize, int timesPerChunk, int minHeight, int maxHeight)
    {
        if (!enabled) return;

        biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(
                replaceBlock,
                ore.getDefaultState(),
                veinSize
                ))
                .withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(timesPerChunk, minHeight, 0, maxHeight)))
        );
    }
}
