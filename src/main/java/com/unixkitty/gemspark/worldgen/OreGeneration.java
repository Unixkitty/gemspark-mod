package com.unixkitty.gemspark.worldgen;

import com.unixkitty.gemspark.Config;
import com.unixkitty.gemspark.init.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.List;

public class OreGeneration
{
    private static final String ore_pink_sapphire_id = "ore_pink_sapphire";
    private static final String ore_tanzanite_id = "ore_tanzanite";
    private static final String ore_topaz_id = "ore_topaz";
    private static final String ore_sapphire_id = "ore_sapphire";
    private static final String ore_ruby_id = "ore_ruby";

    public static Holder<ConfiguredFeature<OreConfiguration, ?>> PINK_SAPPHIRE_ORE_FEATURE = FeatureUtils.register(
            ore_pink_sapphire_id,
            Feature.ORE,
            new OreConfiguration(
                    OreFeatures.NETHER_ORE_REPLACEABLES,
                    ModBlocks.PINK_SAPPHIRE_ORE.get().defaultBlockState(),
                    Config.pinkSapphireVeinSize.get()
            )
    );
    public static Holder<ConfiguredFeature<OreConfiguration, ?>> TANZANITE_ORE_FEATURE = FeatureUtils.register(
            ore_tanzanite_id,
            Feature.ORE,
            new OreConfiguration(
                    OreFeatures.STONE_ORE_REPLACEABLES,
                    ModBlocks.TANZANITE_ORE.get().defaultBlockState(),
                    Config.tanzaniteVeinSize.get()
            )
    );
    public static Holder<ConfiguredFeature<OreConfiguration, ?>> TOPAZ_ORE_FEATURE = FeatureUtils.register(
            ore_topaz_id,
            Feature.ORE,
            new OreConfiguration(
                    OreFeatures.STONE_ORE_REPLACEABLES,
                    ModBlocks.TOPAZ_ORE.get().defaultBlockState(),
                    Config.topazVeinSize.get()
            )
    );
    public static Holder<ConfiguredFeature<OreConfiguration, ?>> SAPPHIRE_ORE_FEATURE = FeatureUtils.register(
            ore_sapphire_id,
            Feature.ORE,
            new OreConfiguration(
                    OreFeatures.STONE_ORE_REPLACEABLES,
                    ModBlocks.SAPPHIRE_ORE.get().defaultBlockState(),
                    Config.sapphireVeinSize.get()
            )
    );
    public static Holder<ConfiguredFeature<OreConfiguration, ?>> RUBY_ORE_FEATURE = FeatureUtils.register(
            ore_ruby_id,
            Feature.ORE,
            new OreConfiguration(
                    OreFeatures.STONE_ORE_REPLACEABLES,
                    ModBlocks.RUBY_ORE.get().defaultBlockState(),
                    Config.rubyVeinSize.get()
            )
    );

    public static Holder<PlacedFeature> PINK_SAPPHIRE_ORE_PLACED_FEATURE = PlacementUtils.register(
            ore_pink_sapphire_id,
            PINK_SAPPHIRE_ORE_FEATURE,
            commonOrePlacement(
                    Config.pinkSapphireVeinsPerChunk.get(),
                    HeightRangePlacement.uniform(
                            VerticalAnchor.absolute(Config.pinkSapphireMinHeight.get()),
                            VerticalAnchor.absolute(Config.pinkSapphireMaxHeight.get())
                    )
            )
    );
    public static Holder<PlacedFeature> TANZANITE_ORE_PLACED_FEATURE = PlacementUtils.register(
            ore_tanzanite_id,
            TANZANITE_ORE_FEATURE,
            commonOrePlacement(
                    Config.tanzaniteVeinsPerChunk.get(),
                    HeightRangePlacement.uniform(
                            VerticalAnchor.absolute(Config.tanzaniteMinHeight.get()),
                            VerticalAnchor.absolute(Config.tanzaniteMaxHeight.get())
                    )
            )
    );
    public static Holder<PlacedFeature> TOPAZ_ORE_PLACED_FEATURE = PlacementUtils.register(
            ore_topaz_id,
            TOPAZ_ORE_FEATURE,
            commonOrePlacement(
                    Config.topazVeinsPerChunk.get(),
                    HeightRangePlacement.uniform(
                            VerticalAnchor.absolute(Config.topazMinHeight.get()),
                            VerticalAnchor.absolute(Config.topazMaxHeight.get())
                    )
            )
    );
    public static Holder<PlacedFeature> SAPPHIRE_ORE_PLACED_FEATURE = PlacementUtils.register(
            ore_sapphire_id,
            SAPPHIRE_ORE_FEATURE,
            commonOrePlacement(
                    Config.sapphireVeinsPerChunk.get(),
                    HeightRangePlacement.uniform(
                            VerticalAnchor.absolute(Config.sapphireMinHeight.get()),
                            VerticalAnchor.absolute(Config.sapphireMaxHeight.get())
                    )
            )
    );
    public static Holder<PlacedFeature> RUBY_ORE_PLACED_FEATURE = PlacementUtils.register(
            ore_ruby_id,
            RUBY_ORE_FEATURE,
            commonOrePlacement(
                    Config.rubyVeinsPerChunk.get(),
                    HeightRangePlacement.uniform(
                            VerticalAnchor.absolute(Config.rubyMinHeight.get()),
                            VerticalAnchor.absolute(Config.rubyMaxHeight.get())
                    )
            )
    );

    public static void onBiomeLoading(BiomeLoadingEvent event)
    {
        if (!Config.generateOres.get()) return;

        if (event.getCategory() == Biome.BiomeCategory.NETHER)
        {
            if (Config.generatePinkSapphireOre.get())
            {
                event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OreGeneration.PINK_SAPPHIRE_ORE_PLACED_FEATURE);
            }
        }
        else if (event.getCategory() != Biome.BiomeCategory.THEEND)
        {
            if (Config.generateTanzaniteOre.get())
            {
                event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OreGeneration.TANZANITE_ORE_PLACED_FEATURE);
            }
            if (Config.generateTopazOre.get())
            {
                event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OreGeneration.TOPAZ_ORE_PLACED_FEATURE);
            }
            if (Config.generateSapphireOre.get())
            {
                event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OreGeneration.SAPPHIRE_ORE_PLACED_FEATURE);
            }
            if (Config.generateRubyOre.get())
            {
                event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OreGeneration.RUBY_ORE_PLACED_FEATURE);
            }
        }
    }

    private static List<PlacementModifier> commonOrePlacement(int count, PlacementModifier placementModifier)
    {
        return List.of(CountPlacement.of(count), InSquarePlacement.spread(), placementModifier, BiomeFilter.biome());
    }

}
