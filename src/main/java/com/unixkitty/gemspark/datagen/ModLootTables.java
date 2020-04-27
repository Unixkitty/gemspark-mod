package com.unixkitty.gemspark.datagen;

import com.unixkitty.gemspark.Config;
import com.unixkitty.gemspark.Gemspark;
import com.unixkitty.gemspork.lib.datagen.loot.BlockLootProvider;
import com.unixkitty.gemspark.util.GemItems;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

public class ModLootTables extends BlockLootProvider
{
    public ModLootTables(DataGenerator generator)
    {
        super(Gemspark.MODID, generator);
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
                        genSilkTouchableWithFortune(block1, GemItems.gemItemOrAlternative(block1), false, Config.GEMDROPSFROMLANTERNS)
                );
            }
            if (block.getRegistryName().getPath().matches(".*_ore"))
            {
                registerLoot(block, block1 ->
                        genSilkTouchableWithFortune(block1, GemItems.gemItemOrAlternative(block1), true, Config.GEMDROPSFROMORE)
                );
            }
        }
    }

    @Override
    public String getName()
    {
        return Gemspark.MODNAME + " " + this.getClass().getSimpleName();
    }
}
