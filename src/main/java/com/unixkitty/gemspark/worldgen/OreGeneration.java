package com.unixkitty.gemspark.worldgen;

import com.unixkitty.gemspark.Config;
import com.unixkitty.gemspark.init.ModBlocks;
import com.unixkitty.gemspork.lib.HelperUtil;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.RuleTest;
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
        Registry<ConfiguredFeature<?, ?>> registry = WorldGenRegistries.CONFIGURED_FEATURE;

        RuleTest fillerBlockType = OreFeatureConfig.FillerBlockType.BASE_STONE_NETHER;

        PINK_SAPPHIRE_ORE = HelperUtil.registerOreFeature(
                fillerBlockType,
                ModBlocks.PINK_SAPPHIRE_ORE.get(),
                Config.pinkSapphireVeinSize.get(),
                Config.pinkSapphireVeinsPerChunk.get(),
                Config.pinkSapphireMinHeight.get(),
                Config.pinkSapphireMaxHeight.get()
        );

        fillerBlockType = OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD;

        TANZANITE_ORE = HelperUtil.registerOreFeature(
                fillerBlockType,
                ModBlocks.TANZANITE_ORE.get(),
                Config.tanzaniteVeinSize.get(),
                Config.tanzaniteVeinsPerChunk.get(),
                Config.tanzaniteMinHeight.get(),
                Config.tanzaniteMaxHeight.get()
        );
        TOPAZ_ORE = HelperUtil.registerOreFeature(
                fillerBlockType,
                ModBlocks.TOPAZ_ORE.get(),
                Config.topazVeinSize.get(),
                Config.topazVeinsPerChunk.get(),
                Config.topazMinHeight.get(),
                Config.topazMaxHeight.get()
        );
        SAPPHIRE_ORE = HelperUtil.registerOreFeature(
                fillerBlockType,
                ModBlocks.SAPPHIRE_ORE.get(),
                Config.sapphireVeinSize.get(),
                Config.sapphireVeinsPerChunk.get(),
                Config.sapphireMinHeight.get(),
                Config.sapphireMaxHeight.get()
        );
        RUBY_ORE = HelperUtil.registerOreFeature(
                fillerBlockType,
                ModBlocks.RUBY_ORE.get(),
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

        if (event.getCategory() == Biome.Category.NETHER)
        {
            if (Config.generatePinkSapphireOre.get())
            {
                event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, OreGeneration.PINK_SAPPHIRE_ORE);
            }
        }
        else if (event.getCategory() != Biome.Category.THEEND)
        {
            if (Config.generateTanzaniteOre.get())
            {
                event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, OreGeneration.TANZANITE_ORE);
            }
            if (Config.generateTopazOre.get())
            {
                event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, OreGeneration.TOPAZ_ORE);
            }
            if (Config.generateSapphireOre.get())
            {
                event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, OreGeneration.SAPPHIRE_ORE);
            }
            if (Config.generateRubyOre.get())
            {
                event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, OreGeneration.RUBY_ORE);
            }
        }
    }

}
