package com.unixkitty.gemspark;

import net.minecraftforge.common.ForgeConfigSpec;

@SuppressWarnings("CanBeFinal")
public class Config
{

    public static ForgeConfigSpec COMMON_CONFIG;
    //public static ForgeConfigSpec CLIENT_CONFIG; This will be needed for client-specific options

    //Values over this cause too much lag? Needs testing
    private static final int OREGEN_THRESHOLD = 30;
    private static final int WORLD_HEIGHT = 256;
    private static final int WORLD_HEIGHT_NETHER = 128;
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
                commonConfig.comment("Tanzanite ore").push("tanzanite");
                generateTanzaniteOre = commonConfig.define("generateTanzaniteOre", true);
                tanzaniteVeinSize = commonConfig.defineInRange("tanzaniteVeinSize", 15, 1, OREGEN_THRESHOLD);
                tanzaniteVeinsPerChunk = commonConfig.defineInRange("tanzaniteVeinsPerChunk", 1, 1, OREGEN_THRESHOLD);
                tanzaniteMinHeight = commonConfig.defineInRange("tanzaniteMinHeight", 1, 1, WORLD_HEIGHT - 2);
                tanzaniteMaxHeight = commonConfig.defineInRange("tanzaniteMaxHeight", 28, 1, WORLD_HEIGHT - 1);
                commonConfig.pop();

                commonConfig.comment("Topaz ore").push("topaz");
                generateTopazOre = commonConfig.define("generateTopazOre", true);
                topazVeinSize = commonConfig.defineInRange("topazVeinSize", 13, 1, OREGEN_THRESHOLD);
                topazVeinsPerChunk = commonConfig.defineInRange("topazVeinsPerChunk", 1, 1, OREGEN_THRESHOLD);
                topazMinHeight = commonConfig.defineInRange("topazMinHeight", 1, 1, WORLD_HEIGHT - 2);
                topazMaxHeight = commonConfig.defineInRange("topazMaxHeight", 25, 1, WORLD_HEIGHT - 1);
                commonConfig.pop();

                commonConfig.comment("Sapphire ore").push("sapphire");
                generateSapphireOre = commonConfig.define("generateSapphireOre", true);
                sapphireVeinSize = commonConfig.defineInRange("sapphireVeinSize", 11, 1, OREGEN_THRESHOLD);
                sapphireVeinsPerChunk = commonConfig.defineInRange("sapphireVeinsPerChunk", 1, 1, OREGEN_THRESHOLD);
                sapphireMinHeight = commonConfig.defineInRange("sapphireMinHeight", 1, 1, WORLD_HEIGHT - 2);
                sapphireMaxHeight = commonConfig.defineInRange("sapphireMaxHeight", 22, 1, WORLD_HEIGHT - 1);
                commonConfig.pop();

                commonConfig.comment("Pink Sapphire ore (Generates in the Nether)").push("pink_sapphire");
                generatePinkSapphireOre = commonConfig.define("generatePinkSapphireOre", true);
                pinkSapphireVeinSize = commonConfig.defineInRange("pinkSapphireVeinSize", 7, 1, OREGEN_THRESHOLD);
                pinkSapphireVeinsPerChunk = commonConfig.defineInRange("pinkSapphireVeinsPerChunk", 5, 1, OREGEN_THRESHOLD);
                pinkSapphireMinHeight = commonConfig.defineInRange("pinkSapphireMinHeight", WORLD_HEIGHT_NETHER - (WORLD_HEIGHT_NETHER - 5), 1, WORLD_HEIGHT_NETHER - 2);
                pinkSapphireMaxHeight = commonConfig.defineInRange("pinkSapphireMaxHeight", WORLD_HEIGHT_NETHER - 5, 1, WORLD_HEIGHT_NETHER - 1);
                commonConfig.pop();

                commonConfig.comment("Ruby ore").push("ruby");
                generateRubyOre = commonConfig.define("generateRubyOre", true);
                rubyVeinSize = commonConfig.defineInRange("rubyVeinSize", 8, 1, OREGEN_THRESHOLD);
                rubyVeinsPerChunk = commonConfig.defineInRange("rubyVeinsPerChunk", 1, 1, OREGEN_THRESHOLD);
                rubyMinHeight = commonConfig.defineInRange("rubyMinHeight", 1, 1, WORLD_HEIGHT - 2);
                rubyMaxHeight = commonConfig.defineInRange("rubyMaxHeight", 16, 1, WORLD_HEIGHT - 1);
                commonConfig.pop();
            }

            commonConfig.pop();
        }

//        commonConfig.comment("Miscellaneous settings").push(CATEGORY_MISC);

        COMMON_CONFIG = commonConfig.build();
    }
}
