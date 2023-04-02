package com.unixkitty.gemspark.datagen.loot;

import com.unixkitty.gemspark.Gemspark;
import com.unixkitty.gemspark.item.GemItems;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ModBlockLootTables extends BlockLoot
{
    private final Set<Block> knownBlocks = new HashSet<>();

    @Override
    protected void addTables()
    {
        for (Block block : ForgeRegistries.BLOCKS)
        {
            if (!Gemspark.MODID.equals(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block)).getNamespace()))
            {
                continue;
            }
            if (ForgeRegistries.BLOCKS.getKey(block).getPath().matches(".*_lantern"))
            {
                this.add(block, block1 ->
                        createSilkTouchDispatchTable(block1, applyExplosionDecay(block1, LootItem.lootTableItem(GemItems.gemItemOrAlternative(block1)).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)))))
                );
            }
            else if (ForgeRegistries.BLOCKS.getKey(block).getPath().matches(".*_ore"))
            {
                this.add(block, block1 -> createOreDrop(block1, GemItems.gemItemOrAlternative(block1).asItem()));
            }
            else
            {
                this.add(block, BlockLoot::createSingleItemTable);
            }
        }
    }

    @Override
    protected void add(Block block, LootTable.Builder builder)
    {
        super.add(block, builder);

        knownBlocks.add(block);
    }

    @Override
    protected Iterable<Block> getKnownBlocks()
    {
        return this.knownBlocks;
    }
}
