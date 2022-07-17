package com.unixkitty.gemspark.worldgen;

import com.unixkitty.gemspark.Config;
import com.unixkitty.gemspark.init.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.List;

public class OreGeneration
{
    public static Holder<PlacedFeature> PINK_SAPPHIRE_ORE = basicOrePlacedFeature("ore_pink_sapphire", OreFeatures.NETHER_ORE_REPLACEABLES, ModBlocks.PINK_SAPPHIRE_ORE.get(), Config.pinkSapphireVeinSize.get(), Config.pinkSapphireVeinsPerChunk.get(), Config.pinkSapphireMinHeight.get(), Config.pinkSapphireMaxHeight.get());

    public static Holder<PlacedFeature> TANZANITE_ORE = basicOrePlacedFeature("ore_tanzanite", OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.TANZANITE_ORE.get(), Config.tanzaniteVeinSize.get(), Config.tanzaniteVeinsPerChunk.get(), Config.tanzaniteMinHeight.get(), Config.tanzaniteMaxHeight.get());
    public static Holder<PlacedFeature> TOPAZ_ORE = basicOrePlacedFeature("ore_topaz", OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.TOPAZ_ORE.get(), Config.topazVeinSize.get(), Config.topazVeinsPerChunk.get(), Config.topazMinHeight.get(), Config.topazMaxHeight.get());
    public static Holder<PlacedFeature> SAPPHIRE_ORE = basicOrePlacedFeature("ore_sapphire", OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.SAPPHIRE_ORE.get(), Config.sapphireVeinSize.get(), Config.sapphireVeinsPerChunk.get(), Config.sapphireMinHeight.get(), Config.sapphireMaxHeight.get());
    public static Holder<PlacedFeature> RUBY_ORE = basicOrePlacedFeature("ore_ruby", OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.RUBY_ORE.get(), Config.rubyVeinSize.get(), Config.rubyVeinsPerChunk.get(), Config.rubyMinHeight.get(), Config.rubyMaxHeight.get());

    public static Holder<PlacedFeature> DEEPSLATE_TANZANITE_ORE = basicOrePlacedFeature("ore_tanzanite_deep", OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_TANZANITE_ORE.get(), Config.deepslateTanzaniteVeinSize.get(), Config.deepslateTanzaniteVeinsPerChunk.get(), Config.deepslateTanzaniteMinHeight.get(), Config.deepslateTanzaniteMaxHeight.get());
    public static Holder<PlacedFeature> DEEPSLATE_TOPAZ_ORE = basicOrePlacedFeature("ore_topaz_deep", OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_TOPAZ_ORE.get(), Config.deepslateTopazVeinSize.get(), Config.deepslateTopazVeinsPerChunk.get(), Config.deepslateTopazMinHeight.get(), Config.deepslateTopazMaxHeight.get());
    public static Holder<PlacedFeature> DEEPSLATE_SAPPHIRE_ORE = basicOrePlacedFeature("ore_sapphire_deep", OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), Config.deepslateSapphireVeinSize.get(), Config.deepslateSapphireVeinsPerChunk.get(), Config.deepslateSapphireMinHeight.get(), Config.deepslateSapphireMaxHeight.get());
    public static Holder<PlacedFeature> DEEPSLATE_RUBY_ORE = basicOrePlacedFeature("ore_ruby_deep", OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_RUBY_ORE.get(), Config.deepslateRubyVeinSize.get(), Config.deepslateRubyVeinsPerChunk.get(), Config.deepslateRubyMinHeight.get(), Config.deepslateRubyMaxHeight.get());

    public static void onBiomeLoading(BiomeLoadingEvent event)
    {
        if (!Config.generateOres.get()) return;

        if (event.getCategory() == Biome.BiomeCategory.NETHER)
        {
            if (Config.generatePinkSapphireOre.get())
            {
                event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OreGeneration.PINK_SAPPHIRE_ORE);
            }
        }
        else if (event.getCategory() != Biome.BiomeCategory.THEEND)
        {
            if (Config.generateTanzaniteOre.get())
            {
                event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OreGeneration.TANZANITE_ORE);
            }
            if (Config.generateTopazOre.get())
            {
                event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OreGeneration.TOPAZ_ORE);
            }
            if (Config.generateSapphireOre.get())
            {
                event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OreGeneration.SAPPHIRE_ORE);
            }
            if (Config.generateRubyOre.get())
            {
                event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OreGeneration.RUBY_ORE);
            }

            //Deepslate variants
            if (Config.generateDeepslateTanzaniteOre.get())
            {
                event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OreGeneration.DEEPSLATE_TANZANITE_ORE);
            }
            if (Config.generateDeepslateTopazOre.get())
            {
                event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OreGeneration.DEEPSLATE_TOPAZ_ORE);
            }
            if (Config.generateDeepslateSapphireOre.get())
            {
                event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OreGeneration.DEEPSLATE_SAPPHIRE_ORE);
            }
            if (Config.generateDeepslateRubyOre.get())
            {
                event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OreGeneration.DEEPSLATE_RUBY_ORE);
            }
        }
    }

    private static Holder<PlacedFeature> basicOrePlacedFeature(String id, RuleTest replaces, Block oreBlock, int veinSize, int veinsPerChunk, int minHeight, int maxHeight)
    {
        return PlacementUtils.register
                (
                        id,
                        FeatureUtils.register(id, Feature.ORE, new OreConfiguration(replaces, oreBlock.defaultBlockState(), veinSize)),
                        commonOrePlacement
                                (
                                        veinsPerChunk,
                                        HeightRangePlacement.uniform
                                                (
                                                        VerticalAnchor.absolute(minHeight),
                                                        VerticalAnchor.absolute(maxHeight)
                                                )
                                )
                );
    }

    private static List<PlacementModifier> commonOrePlacement(int count, PlacementModifier placementModifier)
    {
        return List.of(CountPlacement.of(count), InSquarePlacement.spread(), placementModifier, BiomeFilter.biome());
    }

}
