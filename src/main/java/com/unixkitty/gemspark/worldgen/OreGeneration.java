package com.unixkitty.gemspark.worldgen;

import com.google.common.base.Suppliers;
import com.unixkitty.gemspark.Config;
import com.unixkitty.gemspark.Gemspark;
import com.unixkitty.gemspark.init.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

public class OreGeneration
{
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, Gemspark.MODID);

    private static final Supplier<List<OreConfiguration.TargetBlockState>> TANZANITE_ORE_PLACEMENT = Suppliers.memoize(() ->
            List.of(
                    OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.TANZANITE_ORE.get().defaultBlockState()),
                    OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_TANZANITE_ORE.get().defaultBlockState())
            )
    );

    private static final Supplier<List<OreConfiguration.TargetBlockState>> TOPAZ_ORE_PLACEMENT = Suppliers.memoize(() ->
            List.of(
                    OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.TOPAZ_ORE.get().defaultBlockState()),
                    OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_TOPAZ_ORE.get().defaultBlockState())
            )
    );

    private static final Supplier<List<OreConfiguration.TargetBlockState>> SAPPHIRE_ORE_PLACEMENT = Suppliers.memoize(() ->
            List.of(
                    OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.SAPPHIRE_ORE.get().defaultBlockState()),
                    OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get().defaultBlockState())
            )
    );

    private static final Supplier<List<OreConfiguration.TargetBlockState>> RUBY_ORE_PLACEMENT = Suppliers.memoize(() ->
            List.of(
                    OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.RUBY_ORE.get().defaultBlockState()),
                    OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_RUBY_ORE.get().defaultBlockState())
            )
    );

    private static final Supplier<List<OreConfiguration.TargetBlockState>> PINK_SAPPHIRE_ORE_PLACEMENT = Suppliers.memoize(() ->
            List.of(
                    OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES, ModBlocks.PINK_SAPPHIRE_ORE.get().defaultBlockState())
            ));

    public static final RegistryObject<ConfiguredFeature<?, ?>> TANZANITE_ORE = configureFeature("ore_tanzanite", TANZANITE_ORE_PLACEMENT, Config.tanzaniteVeinSize);
    public static final RegistryObject<ConfiguredFeature<?, ?>> TOPAZ_ORE = configureFeature("ore_topaz", TOPAZ_ORE_PLACEMENT, Config.topazVeinSize);
    public static final RegistryObject<ConfiguredFeature<?, ?>> SAPPHIRE_ORE = configureFeature("ore_sapphire", SAPPHIRE_ORE_PLACEMENT, Config.sapphireVeinSize);
    public static final RegistryObject<ConfiguredFeature<?, ?>> RUBY_ORE = configureFeature("ore_ruby", RUBY_ORE_PLACEMENT, Config.rubyVeinSize);
    public static final RegistryObject<ConfiguredFeature<?, ?>> PINK_SAPPHIRE_ORE = configureFeature("ore_pink_sapphire", PINK_SAPPHIRE_ORE_PLACEMENT, Config.pinkSapphireVeinSize);

    private static RegistryObject<ConfiguredFeature<?, ?>> configureFeature(String id, Supplier<List<OreConfiguration.TargetBlockState>> placementSupplier, int veinSize)
    {
        return CONFIGURED_FEATURES.register(id, () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(placementSupplier.get(), veinSize)));
    }

    //===========================================
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, Gemspark.MODID);

    public static RegistryObject<PlacedFeature> TANZANITE_ORE_FEATURE = basicOrePlacedFeature("ore_tanzanite", TANZANITE_ORE, Config.tanzaniteVeinsPerChunk, Config.tanzaniteMinHeight, Config.tanzaniteMaxHeight);
    public static RegistryObject<PlacedFeature> TOPAZ_ORE_FEATURE = basicOrePlacedFeature("ore_topaz", TOPAZ_ORE, Config.topazVeinsPerChunk, Config.topazMinHeight, Config.topazMaxHeight);
    public static RegistryObject<PlacedFeature> SAPPHIRE_ORE_FEATURE = basicOrePlacedFeature("ore_sapphire", SAPPHIRE_ORE, Config.sapphireVeinsPerChunk, Config.sapphireMinHeight, Config.sapphireMaxHeight);
    public static RegistryObject<PlacedFeature> RUBY_ORE_FEATURE = basicOrePlacedFeature("ore_ruby", RUBY_ORE, Config.rubyVeinsPerChunk, Config.rubyMinHeight, Config.rubyMaxHeight);
    public static RegistryObject<PlacedFeature> PINK_SAPPHIRE_ORE_FEATURE = basicOrePlacedFeature("ore_pink_sapphire", PINK_SAPPHIRE_ORE, Config.pinkSapphireVeinsPerChunk, Config.pinkSapphireMinHeight, Config.pinkSapphireMaxHeight);

    private static RegistryObject<PlacedFeature> basicOrePlacedFeature(String id, RegistryObject<ConfiguredFeature<?, ?>> configuredFeature, int veinsPerChunk, int minHeight, int maxHeight)
    {
        return PLACED_FEATURES.register(
                id,
                () -> new PlacedFeature(
                        configuredFeature.getHolder().get(), commonOrePlacement(
                            veinsPerChunk,
                            HeightRangePlacement.uniform(
                                VerticalAnchor.absolute(minHeight),
                                VerticalAnchor.absolute(maxHeight)
                            )
                        )
                )
        );
    }

    private static List<PlacementModifier> commonOrePlacement(int count, PlacementModifier placementModifier)
    {
        return List.of(CountPlacement.of(count), InSquarePlacement.spread(), placementModifier, BiomeFilter.biome());
    }

    /*public static Holder<PlacedFeature> DEEPSLATE_TANZANITE_ORE = basicOrePlacedFeature("ore_tanzanite_deep", OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_TANZANITE_ORE.get(), Config.deepslateTanzaniteVeinSize.get(), Config.deepslateTanzaniteVeinsPerChunk.get(), Config.deepslateTanzaniteMinHeight.get(), Config.deepslateTanzaniteMaxHeight.get());
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
    }*/

}
