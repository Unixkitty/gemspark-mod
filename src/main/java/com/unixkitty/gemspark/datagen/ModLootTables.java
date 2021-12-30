package com.unixkitty.gemspark.datagen;

import com.unixkitty.gemspark.Config;
import com.unixkitty.gemspark.Gemspark;
import com.unixkitty.gemspark.item.GemItems;
import com.unixkitty.gemspork.lib.datagen.loot.BlockLootProvider;
import net.minecraft.advancements.criterion.EnchantmentPredicate;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.advancements.criterion.MinMaxBounds;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.loot.ConstantRange;
import net.minecraft.loot.ItemLootEntry;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.conditions.MatchTool;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

public class ModLootTables extends BlockLootProvider
{
    /*
        Standard block drops (1 of itself) will get registered automatically if no override will be added
     */
    public ModLootTables(DataGenerator generator)
    {
        super(Gemspark.MODID, generator);

        for (Block block : ForgeRegistries.BLOCKS)
        {
            if (!Gemspark.MODID.equals(Objects.requireNonNull(block.getRegistryName()).getNamespace()))
            {
                continue;
            }
            if (block.getRegistryName().getPath().matches(".*_lantern"))
            {
                registerLoot(block, block1 ->
                        LootTable.lootTable().withPool(
                                LootPool.lootPool().when(
                                        MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.IntBound.atLeast(1))))
                                ).setRolls(
                                        ConstantRange.exactly(1)
                                ).add(
                                        ItemLootEntry.lootTableItem(block1)
                                ))
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
