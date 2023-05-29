package com.unixkitty.gemspark;

import net.minecraftforge.common.ForgeConfigSpec;

public class Config
{
    public static ForgeConfigSpec COMMON_CONFIG;

    /* BEGIN ENTRIES */
    public static final String CATEGORY_GENERAL = "general";

    public static ForgeConfigSpec.BooleanValue hurtEntitiesByBraziers;

    /* END ENTRIES */

    static
    {
        ForgeConfigSpec.Builder commonConfig = new ForgeConfigSpec.Builder();

        {
            commonConfig.comment("General options").push(CATEGORY_GENERAL);
            hurtEntitiesByBraziers = commonConfig.comment("Should entities be hurt when touching braziers added by the mod").define("hurtEntitiesByBraziers", false);
            commonConfig.pop();
        }

        COMMON_CONFIG = commonConfig.build();
    }
}
