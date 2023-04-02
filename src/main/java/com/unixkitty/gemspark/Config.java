package com.unixkitty.gemspark;

import net.minecraftforge.common.ForgeConfigSpec;

public class Config
{
    public static ForgeConfigSpec COMMON_CONFIG;
    //public static ForgeConfigSpec CLIENT_CONFIG; This will be needed for client-specific options

    private static final int WORLD_DEPTH = -64;
    private static final int WORLD_HEIGHT_NETHER = 128;
    private static final int WORLD_DEPTH_NETHER = 0;
    /* BEGIN ENTRIES */
    public static final String CATEGORY_GENERAL = "general";

    public static ForgeConfigSpec.BooleanValue hurtEntitiesByBraziers;

//    public static ForgeConfigSpec.BooleanValue generateOres;

    //    public static ForgeConfigSpec.BooleanValue generateTanzaniteOre;
    public static int tanzaniteVeinSize = Gem.UPPER_HIGH.veinSize;
    public static int tanzaniteVeinsPerChunk = Gem.UPPER_HIGH.veinsPerChunk;
    public static int tanzaniteMinHeight = Gem.UPPER_LOW.minHeight;
    public static int tanzaniteMaxHeight = Gem.UPPER_HIGH.maxHeight;

    //    public static ForgeConfigSpec.BooleanValue generateTopazOre;
    public static int topazVeinSize = Gem.UPPER_HIGH.veinSize;
    public static int topazVeinsPerChunk = Gem.UPPER_HIGH.veinsPerChunk;
    public static int topazMinHeight = Gem.UPPER_LOW.minHeight;
    public static int topazMaxHeight = Gem.UPPER_HIGH.maxHeight;

    //    public static ForgeConfigSpec.BooleanValue generateSapphireOre;
    public static int sapphireVeinSize = Gem.LOWER_HIGH.veinSize;
    public static int sapphireVeinsPerChunk = Gem.LOWER_HIGH.veinsPerChunk;
    public static int sapphireMinHeight = Gem.LOWER_LOW.minHeight;
    public static int sapphireMaxHeight = Gem.LOWER_HIGH.maxHeight;

    //    public static ForgeConfigSpec.BooleanValue generateRubyOre;
    public static int rubyVeinSize = Gem.LOWER_HIGH.veinSize;
    public static int rubyVeinsPerChunk = Gem.LOWER_HIGH.veinsPerChunk;
    public static int rubyMinHeight = Gem.LOWER_LOW.minHeight;
    public static int rubyMaxHeight = Gem.LOWER_HIGH.maxHeight;

    //    public static ForgeConfigSpec.BooleanValue generatePinkSapphireOre;
    public static int pinkSapphireVeinSize = 7;
    public static int pinkSapphireVeinsPerChunk = 5;
    public static int pinkSapphireMinHeight = WORLD_DEPTH_NETHER;
    public static int pinkSapphireMaxHeight = WORLD_HEIGHT_NETHER;

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
//        commonConfig.comment("Miscellaneous settings").push(CATEGORY_MISC);

        COMMON_CONFIG = commonConfig.build();
    }

    private enum Gem
    {
        UPPER_HIGH(5, 2, 0, 30),
        UPPER_LOW(12, 3, -40, 0),
        LOWER_HIGH(5, 1, 0, 14),
        LOWER_LOW(10, 4, WORLD_DEPTH, 0);

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
