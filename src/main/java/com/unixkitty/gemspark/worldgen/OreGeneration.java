package com.unixkitty.gemspark.worldgen;

import com.unixkitty.gemspark.Config;
import com.unixkitty.gemspark.init.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class OreGeneration
{
    protected static ConfiguredFeature<?, ?> PINK_SAPPHIRE_ORE;
    protected static ConfiguredFeature<?, ?> TANZANITE_ORE;
    protected static ConfiguredFeature<?, ?> TOPAZ_ORE;
    protected static ConfiguredFeature<?, ?> SAPPHIRE_ORE;
    protected static ConfiguredFeature<?, ?> RUBY_ORE;

    public static void register()
    {
        Registry<ConfiguredFeature<?, ?>> registry = BuiltinRegistries.CONFIGURED_FEATURE;

        RuleTest fillerBlockType = OreConfiguration.Predicates.NETHER_ORE_REPLACEABLES;

        PINK_SAPPHIRE_ORE = registerOreFeature(
                fillerBlockType,
                ModBlocks.PINK_SAPPHIRE_ORE.get().defaultBlockState(),
                Config.pinkSapphireVeinSize.get(),
                Config.pinkSapphireVeinsPerChunk.get(),
                Config.pinkSapphireMinHeight.get(),
                Config.pinkSapphireMaxHeight.get()
        );

        fillerBlockType = OreConfiguration.Predicates.NATURAL_STONE;

        TANZANITE_ORE = registerOreFeature(
                fillerBlockType,
                ModBlocks.TANZANITE_ORE.get().defaultBlockState(),
                Config.tanzaniteVeinSize.get(),
                Config.tanzaniteVeinsPerChunk.get(),
                Config.tanzaniteMinHeight.get(),
                Config.tanzaniteMaxHeight.get()
        );
        TOPAZ_ORE = registerOreFeature(
                fillerBlockType,
                ModBlocks.TOPAZ_ORE.get().defaultBlockState(),
                Config.topazVeinSize.get(),
                Config.topazVeinsPerChunk.get(),
                Config.topazMinHeight.get(),
                Config.topazMaxHeight.get()
        );
        SAPPHIRE_ORE = registerOreFeature(
                fillerBlockType,
                ModBlocks.SAPPHIRE_ORE.get().defaultBlockState(),
                Config.sapphireVeinSize.get(),
                Config.sapphireVeinsPerChunk.get(),
                Config.sapphireMinHeight.get(),
                Config.sapphireMaxHeight.get()
        );
        RUBY_ORE = registerOreFeature(
                fillerBlockType,
                ModBlocks.RUBY_ORE.get().defaultBlockState(),
                Config.rubyVeinSize.get(),
                Config.rubyVeinsPerChunk.get(),
                Config.rubyMinHeight.get(),
                Config.rubyMaxHeight.get()
        );

        Registry.register(registry, "ore_pink_sapphire", PINK_SAPPHIRE_ORE);
        Registry.register(registry, "ore_tanzanite", TANZANITE_ORE);
        Registry.register(registry, "ore_topaz", TOPAZ_ORE);
        Registry.register(registry, "ore_sapphire", SAPPHIRE_ORE);
        Registry.register(registry, "ore_ruby", RUBY_ORE);
    }

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
        }
    }

    private static ConfiguredFeature<?, ?> registerOreFeature(RuleTest replaceBlock, BlockState oreBlockState, int veinSize, int timesPerChunk, int minHeight, int maxHeight)
    {
        return Feature.ORE.configured(
                new OreConfiguration(
                        replaceBlock,
                        oreBlockState,
                        veinSize
                )
        ).rangeUniform(
                VerticalAnchor.aboveBottom(minHeight),
                VerticalAnchor.belowTop(maxHeight)
        ).squared().count(timesPerChunk);
    }

}
