package com.unixkitty.gemspark.datagen.loot;

import net.minecraft.data.loot.packs.VanillaBlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

public class ModBlockLootTables extends VanillaBlockLoot
{
    private final Set<Block> knownBlocks = new HashSet<>();

    @Override
    protected void generate()
    {

    }

    @Override
    protected void add(@NotNull Block block, LootTable.@NotNull Builder builder)
    {
        super.add(block, builder);

        this.knownBlocks.add(block);
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks()
    {
        return this.knownBlocks;
    }
}
