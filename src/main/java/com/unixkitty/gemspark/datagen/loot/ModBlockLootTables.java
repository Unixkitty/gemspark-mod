package com.unixkitty.gemspark.datagen.loot;

import com.unixkitty.gemspark.block.BlockLampPostCap;
import com.unixkitty.gemspark.init.ModBlocks;
import net.minecraft.data.loot.packs.VanillaBlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.IronBarsBlock;
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
        ModBlocks.BLOCKS.getEntries().forEach(blockRegistryObject ->
        {
            Block block = blockRegistryObject.get();

            if (block instanceof IronBarsBlock || block instanceof BlockLampPostCap)
            {
                this.dropSelf(block);
            }
        });
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
