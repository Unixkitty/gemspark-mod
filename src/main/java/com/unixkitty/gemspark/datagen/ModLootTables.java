package com.unixkitty.gemspark.datagen;

import com.unixkitty.gemspark.Config;
import com.unixkitty.gemspark.Gemspark;
import com.unixkitty.gemspark.datagen.base.ModBlockLootProvider;
import com.unixkitty.gemspark.util.HelperUtil;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

public class ModLootTables extends ModBlockLootProvider
{
    public ModLootTables(DataGenerator generator)
    {
        super(generator);
    }

    /*
        Standard block drops (1 of itself) will get registered automatically if no override will be added
     */
    @Override
    protected void addTables()
    {
        for (Block block : ForgeRegistries.BLOCKS)
        {
            if (!Gemspark.MODID.equals(Objects.requireNonNull(block.getRegistryName()).getNamespace()))
            {
                continue;
            }
            if (block.getRegistryName().getPath().matches(".*_lantern"))
            {
                registerLoot(block, block1 ->
                        genSilkTouchableWithFortune(block1, HelperUtil.gemItemOrAlternative(block1), false, Config.GEMDROPSFROMLANTERNS)
                );
            }
            if (block.getRegistryName().getPath().matches(".*_ore"))
            {
                registerLoot(block, block1 ->
                        genSilkTouchableWithFortune(block1, HelperUtil.gemItemOrAlternative(block1), true, Config.GEMDROPSFROMORE)
                );
            }
        }
    }
}
