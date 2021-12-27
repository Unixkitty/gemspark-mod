package com.unixkitty.gemspark.util.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.tags.Tag;
import net.minecraft.util.LazyLoadedValue;

public abstract class DynamicTierProperties
{
    protected final LazyLoadedValue<Ingredient> repairItem;

    public DynamicTierProperties(Tag<Item> repairItem)
    {
        this.repairItem = new LazyLoadedValue<>(() -> Ingredient.of(repairItem));
    }

    protected static int calcEnchantability(int tierIndex, int tiersTotal, int floor, int ceiling, float floorBump, int enchantability)
    {
        return enchantability == -1 ? getTierStrengthAsInt(tierIndex, tiersTotal, floor, ceiling, floorBump) : enchantability;
    }

    protected static int getTierStrengthAsInt(int tierIndex, int tiersTotal, float floor, float ceil, float floorBump)
    {
        return (int) getTierStrength(tierIndex, tiersTotal, floor, ceil, floorBump);
    }

    protected static float getTierStrength(int tierIndex, int tiersTotal, float floor, float ceil, float floorBump)
    {
        final float FLOOR_BUMP_MIN = 0.1f;
        final float FLOOR_BUMB_MAX = 0.9f;

        floorBump = floor + (ceil - floor) * (floorBump <= 0f ? FLOOR_BUMP_MIN : (floorBump >= 1f ? FLOOR_BUMB_MAX : floorBump));

        return floorBump + (ceil - floorBump) * ((float) tierIndex / tiersTotal);
    }
}

