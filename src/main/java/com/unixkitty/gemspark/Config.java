package com.unixkitty.gemspark;

import net.minecraftforge.common.ForgeConfigSpec;

@SuppressWarnings("CanBeFinal")
public class Config
{

    public static ForgeConfigSpec COMMON_CONFIG;
    //public static ForgeConfigSpec CLIENT_CONFIG; This will be needed for client-specific options

    /* BEGIN ENTRIES */
    public static final String CATEGORY_REGISTRATION = "registration";

    public static ForgeConfigSpec.BooleanValue registerColoredLamps;

    //public static final String CATEGORY_WORLDGEN = "worldgen";

    //public static final String CATEGORY_MISC = "miscellaneous";

    /* END ENTRIES */

    /* Non-configurable */
    public static final int GEMLANTERNSFROMCRAFT = 2;
    public static final int GEMDROPSFROMLANTERNS = 2;
    public static final int GEMDROPSFROMORE = 1;

    static
    {
        ForgeConfigSpec.Builder commonConfig = new ForgeConfigSpec.Builder();

        commonConfig.comment("Registration settings").push(CATEGORY_REGISTRATION);

        registerColoredLamps = commonConfig.comment("Register colored lamps").define("registerColoredLamps", true);

        commonConfig.pop();

//        commonConfig.comment("Worldgen").push(CATEGORY_WORLDGEN);

//        gemDropsFromOre = commonConfig.comment("How many gems drop before fortune is applied to drops").defineInRange("gemDropsFromOre", 1, 1, 64);

//        commonConfig.pop();

//        commonConfig.comment("Miscellaneous settings").push(CATEGORY_MISC);

        COMMON_CONFIG = commonConfig.build();
    }
}
