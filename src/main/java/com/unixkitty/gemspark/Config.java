package com.unixkitty.gemspark;

import net.minecraftforge.common.ForgeConfigSpec;

@SuppressWarnings("CanBeFinal")
public class Config
{

    public static ForgeConfigSpec COMMON_CONFIG;
    //public static ForgeConfigSpec CLIENT_CONFIG; This will be needed for client-specific options

    private static final int OREGEN_THRESHOLD = 64;
    private static final int WORLD_HEIGHT = 256;
    private static final int WORLD_DEPTH = -64;
    private static final int WORLD_HEIGHT_NETHER = 128;
    private static final int WORLD_DEPTH_NETHER = 0;
    /* BEGIN ENTRIES */
    public static final String CATEGORY_GENERAL = "general";

    public static ForgeConfigSpec.BooleanValue hurtEntitiesByBraziers;

    public static final String CATEGORY_WORLDGEN = "world_generation";

    public static ForgeConfigSpec.BooleanValue generateOres;

    public static ForgeConfigSpec.BooleanValue generateTanzaniteOre;
    public static ForgeConfigSpec.IntValue tanzaniteVeinSize;
    public static ForgeConfigSpec.IntValue tanzaniteVeinsPerChunk;
    public static ForgeConfigSpec.IntValue tanzaniteMinHeight;
    public static ForgeConfigSpec.IntValue tanzaniteMaxHeight;

    public static ForgeConfigSpec.BooleanValue generateTopazOre;
    public static ForgeConfigSpec.IntValue topazVeinSize;
    public static ForgeConfigSpec.IntValue topazVeinsPerChunk;
    public static ForgeConfigSpec.IntValue topazMinHeight;
    public static ForgeConfigSpec.IntValue topazMaxHeight;

    public static ForgeConfigSpec.BooleanValue generateSapphireOre;
    public static ForgeConfigSpec.IntValue sapphireVeinSize;
    public static ForgeConfigSpec.IntValue sapphireVeinsPerChunk;
    public static ForgeConfigSpec.IntValue sapphireMinHeight;
    public static ForgeConfigSpec.IntValue sapphireMaxHeight;

    public static ForgeConfigSpec.BooleanValue generatePinkSapphireOre;
    public static ForgeConfigSpec.IntValue pinkSapphireVeinSize;
    public static ForgeConfigSpec.IntValue pinkSapphireVeinsPerChunk;
    public static ForgeConfigSpec.IntValue pinkSapphireMinHeight;
    public static ForgeConfigSpec.IntValue pinkSapphireMaxHeight;

    public static ForgeConfigSpec.BooleanValue generateRubyOre;
    public static ForgeConfigSpec.IntValue rubyVeinSize;
    public static ForgeConfigSpec.IntValue rubyVeinsPerChunk;
    public static ForgeConfigSpec.IntValue rubyMinHeight;
    public static ForgeConfigSpec.IntValue rubyMaxHeight;

    public static ForgeConfigSpec.BooleanValue generateDeepslateTanzaniteOre;
    public static ForgeConfigSpec.IntValue deepslateTanzaniteVeinSize;
    public static ForgeConfigSpec.IntValue deepslateTanzaniteVeinsPerChunk;
    public static ForgeConfigSpec.IntValue deepslateTanzaniteMinHeight;
    public static ForgeConfigSpec.IntValue deepslateTanzaniteMaxHeight;

    public static ForgeConfigSpec.BooleanValue generateDeepslateTopazOre;
    public static ForgeConfigSpec.IntValue deepslateTopazVeinSize;
    public static ForgeConfigSpec.IntValue deepslateTopazVeinsPerChunk;
    public static ForgeConfigSpec.IntValue deepslateTopazMinHeight;
    public static ForgeConfigSpec.IntValue deepslateTopazMaxHeight;

    //Deepslate variants
    public static ForgeConfigSpec.BooleanValue generateDeepslateSapphireOre;
    public static ForgeConfigSpec.IntValue deepslateSapphireVeinSize;
    public static ForgeConfigSpec.IntValue deepslateSapphireVeinsPerChunk;
    public static ForgeConfigSpec.IntValue deepslateSapphireMinHeight;
    public static ForgeConfigSpec.IntValue deepslateSapphireMaxHeight;

    public static ForgeConfigSpec.BooleanValue generateDeepslateRubyOre;
    public static ForgeConfigSpec.IntValue deepslateRubyVeinSize;
    public static ForgeConfigSpec.IntValue deepslateRubyVeinsPerChunk;
    public static ForgeConfigSpec.IntValue deepslateRubyMinHeight;
    public static ForgeConfigSpec.IntValue deepslateRubyMaxHeight;

    //public static final String CATEGORY_MISC = "miscellaneous";

    /* END ENTRIES */

    /* Non-configurable */
    public static final int GEMSPARK_BLOCKS_FROM_CRAFT = 8;

    static
    {
        ForgeConfigSpec.Builder commonConfig = new ForgeConfigSpec.Builder();

        {
            commonConfig.comment("General options").push(CATEGORY_GENERAL);
            hurtEntitiesByBraziers = commonConfig.comment("Should entities be hurt when touching braziers added by the mod").define("hurtEntitiesByBraziers", false);
            commonConfig.pop();
        }

        {
            commonConfig.comment("Worldgen").push(CATEGORY_WORLDGEN);
            generateOres = commonConfig.comment("Should the mod register it's worldgen in the first place").define("generateOres", true);

            {
                commonConfig.comment("Pink Sapphire ore (Generates in the Nether)").push("pink_sapphire");
                generatePinkSapphireOre = commonConfig.define("generatePinkSapphireOre", true);
                pinkSapphireVeinSize = commonConfig.defineInRange("pinkSapphireVeinSize", 7, 1, OREGEN_THRESHOLD);
                pinkSapphireVeinsPerChunk = commonConfig.defineInRange("pinkSapphireVeinsPerChunk", 5, 1, OREGEN_THRESHOLD);
                pinkSapphireMinHeight = commonConfig.defineInRange("pinkSapphireMinHeight", WORLD_DEPTH_NETHER, 1, WORLD_HEIGHT_NETHER - 1);
                pinkSapphireMaxHeight = commonConfig.defineInRange("pinkSapphireMaxHeight", WORLD_HEIGHT_NETHER, WORLD_DEPTH_NETHER + 1, WORLD_HEIGHT_NETHER);
                commonConfig.pop();

                commonConfig.comment("Tanzanite ore").push("tanzanite");
                generateTanzaniteOre = commonConfig.define("generateTanzaniteOre", true);
                tanzaniteVeinSize = commonConfig.defineInRange("tanzaniteVeinSize", Gem.UPPER_HIGH.veinSize, 1, OREGEN_THRESHOLD);
                tanzaniteVeinsPerChunk = commonConfig.defineInRange("tanzaniteVeinsPerChunk", Gem.UPPER_HIGH.veinsPerChunk, 1, OREGEN_THRESHOLD);
                tanzaniteMinHeight = commonConfig.defineInRange("tanzaniteMinHeight", Gem.UPPER_HIGH.minHeight, WORLD_DEPTH, WORLD_HEIGHT - 1);
                tanzaniteMaxHeight = commonConfig.defineInRange("tanzaniteMaxHeight", Gem.UPPER_HIGH.maxHeight, WORLD_DEPTH + 1, WORLD_HEIGHT);
                commonConfig.pop();

                commonConfig.comment("Topaz ore").push("topaz");
                generateTopazOre = commonConfig.define("generateTopazOre", true);
                topazVeinSize = commonConfig.defineInRange("topazVeinSize", Gem.UPPER_HIGH.veinSize, 1, OREGEN_THRESHOLD);
                topazVeinsPerChunk = commonConfig.defineInRange("topazVeinsPerChunk", Gem.UPPER_HIGH.veinsPerChunk, 1, OREGEN_THRESHOLD);
                topazMinHeight = commonConfig.defineInRange("topazMinHeight", Gem.UPPER_HIGH.minHeight, WORLD_DEPTH, WORLD_HEIGHT - 1);
                topazMaxHeight = commonConfig.defineInRange("topazMaxHeight", Gem.UPPER_HIGH.maxHeight, WORLD_DEPTH + 1, WORLD_HEIGHT);
                commonConfig.pop();

                commonConfig.comment("Sapphire ore").push("sapphire");
                generateSapphireOre = commonConfig.define("generateSapphireOre", true);
                sapphireVeinSize = commonConfig.defineInRange("sapphireVeinSize", Gem.LOWER_HIGH.veinSize, 1, OREGEN_THRESHOLD);
                sapphireVeinsPerChunk = commonConfig.defineInRange("sapphireVeinsPerChunk", Gem.LOWER_HIGH.veinsPerChunk, 1, OREGEN_THRESHOLD);
                sapphireMinHeight = commonConfig.defineInRange("sapphireMinHeight", Gem.LOWER_HIGH.minHeight, WORLD_DEPTH, WORLD_HEIGHT - 1);
                sapphireMaxHeight = commonConfig.defineInRange("sapphireMaxHeight", Gem.LOWER_HIGH.maxHeight, WORLD_DEPTH + 1, WORLD_HEIGHT);
                commonConfig.pop();

                commonConfig.comment("Ruby ore").push("ruby");
                generateRubyOre = commonConfig.define("generateRubyOre", true);
                rubyVeinSize = commonConfig.defineInRange("rubyVeinSize", Gem.LOWER_HIGH.veinSize, 1, OREGEN_THRESHOLD);
                rubyVeinsPerChunk = commonConfig.defineInRange("rubyVeinsPerChunk", Gem.LOWER_HIGH.veinsPerChunk, 1, OREGEN_THRESHOLD);
                rubyMinHeight = commonConfig.defineInRange("rubyMinHeight", Gem.LOWER_HIGH.minHeight, WORLD_DEPTH, WORLD_HEIGHT - 1);
                rubyMaxHeight = commonConfig.defineInRange("rubyMaxHeight", Gem.LOWER_HIGH.maxHeight, WORLD_DEPTH + 1, WORLD_HEIGHT);
                commonConfig.pop();

                //Deepslate variants
                commonConfig.comment("Deepslate tanzanite ore").push("deepslateTanzanite");
                generateDeepslateTanzaniteOre = commonConfig.define("generateDeepslateTanzaniteOre", true);
                deepslateTanzaniteVeinSize = commonConfig.defineInRange("deepslateTanzaniteVeinSize", Gem.UPPER_LOW.veinSize, 1, OREGEN_THRESHOLD);
                deepslateTanzaniteVeinsPerChunk = commonConfig.defineInRange("deepslateTanzaniteVeinsPerChunk", Gem.UPPER_LOW.veinsPerChunk, 1, OREGEN_THRESHOLD);
                deepslateTanzaniteMinHeight = commonConfig.defineInRange("deepslateTanzaniteMinHeight", Gem.UPPER_LOW.minHeight, WORLD_DEPTH, WORLD_HEIGHT - 1);
                deepslateTanzaniteMaxHeight = commonConfig.defineInRange("deepslateTanzaniteMaxHeight", Gem.UPPER_LOW.maxHeight, WORLD_DEPTH + 1, WORLD_HEIGHT);
                commonConfig.pop();

                commonConfig.comment("Deepslate topaz ore").push("deepslateTopaz");
                generateDeepslateTopazOre = commonConfig.define("generateDeepslateTopazOre", true);
                deepslateTopazVeinSize = commonConfig.defineInRange("deepslateTopazVeinSize", Gem.UPPER_LOW.veinSize, 1, OREGEN_THRESHOLD);
                deepslateTopazVeinsPerChunk = commonConfig.defineInRange("deepslateTopazVeinsPerChunk", Gem.UPPER_LOW.veinsPerChunk, 1, OREGEN_THRESHOLD);
                deepslateTopazMinHeight = commonConfig.defineInRange("deepslateTopazMinHeight", Gem.UPPER_LOW.minHeight, WORLD_DEPTH, WORLD_HEIGHT - 1);
                deepslateTopazMaxHeight = commonConfig.defineInRange("deepslateTopazMaxHeight", Gem.UPPER_LOW.maxHeight, WORLD_DEPTH + 1, WORLD_HEIGHT);
                commonConfig.pop();

                commonConfig.comment("Deepslate sapphire ore").push("deepslateSapphire");
                generateDeepslateSapphireOre = commonConfig.define("generateDeepslateSapphireOre", true);
                deepslateSapphireVeinSize = commonConfig.defineInRange("deepslateSapphireVeinSize", Gem.LOWER_LOW.veinSize, 1, OREGEN_THRESHOLD);
                deepslateSapphireVeinsPerChunk = commonConfig.defineInRange("deepslateSapphireVeinsPerChunk", Gem.LOWER_LOW.veinsPerChunk, 1, OREGEN_THRESHOLD);
                deepslateSapphireMinHeight = commonConfig.defineInRange("deepslateSapphireMinHeight", Gem.LOWER_LOW.minHeight, WORLD_DEPTH, WORLD_HEIGHT - 1);
                deepslateSapphireMaxHeight = commonConfig.defineInRange("deepslateSapphireMaxHeight", Gem.LOWER_LOW.maxHeight, WORLD_DEPTH + 1, WORLD_HEIGHT);
                commonConfig.pop();

                commonConfig.comment("Deepslate ruby ore").push("deepslateRuby");
                generateDeepslateRubyOre = commonConfig.define("generateDeepslateRubyOre", true);
                deepslateRubyVeinSize = commonConfig.defineInRange("deepslateRubyVeinSize", Gem.LOWER_LOW.veinSize, 1, OREGEN_THRESHOLD);
                deepslateRubyVeinsPerChunk = commonConfig.defineInRange("deepslateRubyVeinsPerChunk", Gem.LOWER_LOW.veinsPerChunk, 1, OREGEN_THRESHOLD);
                deepslateRubyMinHeight = commonConfig.defineInRange("deepslateRubyMinHeight", Gem.LOWER_LOW.minHeight, WORLD_DEPTH, WORLD_HEIGHT - 1);
                deepslateRubyMaxHeight = commonConfig.defineInRange("deepslateRubyMaxHeight", Gem.LOWER_LOW.maxHeight, WORLD_DEPTH + 1, WORLD_HEIGHT);
                commonConfig.pop();
            }

            commonConfig.pop();
        }

//        commonConfig.comment("Miscellaneous settings").push(CATEGORY_MISC);

        COMMON_CONFIG = commonConfig.build();
    }

    private enum Gem
    {
        UPPER_HIGH(5, 2, 0, 30),
        UPPER_LOW(12, 3, -40, 0),
        LOWER_HIGH(5, 1, 0, 14),
        LOWER_LOW(10, 4, -64, 0);

        final int veinSize;
        final int veinsPerChunk;
        final int minHeight;
        final int maxHeight;

        Gem(int veinSize, int veinsPerChunk, int minHeight, int maxHeight)
        {
            this.veinSize = veinSize;
            this.veinsPerChunk = veinsPerChunk;
            this.minHeight = minHeight;
            this.maxHeight = maxHeight;
        }
    }
}
