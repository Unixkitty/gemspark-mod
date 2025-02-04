package com.unixkitty.gemspark.util.item;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;

import javax.annotation.Nonnull;

public class DynamicTieredArmorProperties extends DynamicTierProperties implements ArmorMaterial
{
    private final ArmorMaterial FLOOR_TIER;
    private final ArmorMaterial CEILING_TIER;

    private final String name;

    private final int tierIndex;
    private final int tiersTotal;
    private final float floorBump;

    private final float toughness;
    private final int enchantability;

    private final SoundEvent equipSound;

    public DynamicTieredArmorProperties(String name, int tierIndex, int tiersTotal, int enchantability, float floorBump, ArmorMaterial floorTier, ArmorMaterial ceilingTier, SoundEvent equipSound, TagKey<Item> repairItem)
    {
        super(repairItem);

        this.FLOOR_TIER = floorTier;
        this.CEILING_TIER = ceilingTier;

        this.name = name;

        this.tierIndex = tierIndex;
        this.tiersTotal = tiersTotal;
        this.floorBump = floorBump;

        this.toughness = getTierStrength(tierIndex, tiersTotal, FLOOR_TIER.getToughness(), this.CEILING_TIER.getToughness(), floorBump);
        this.enchantability = calcEnchantability(tierIndex, tiersTotal, floorTier.getEnchantmentValue(), ceilingTier.getEnchantmentValue(), floorBump, enchantability);

        this.equipSound = equipSound;
    }

    /* Interface methods begin */

    @Override
    public int getDurabilityForType(@Nonnull ArmorItem.Type type)
    {
        return (int) getTierStrength(this.tierIndex, this.tiersTotal, this.FLOOR_TIER.getDurabilityForType(type), this.CEILING_TIER.getDurabilityForType(type), this.floorBump);
    }

    @Override
    public int getDefenseForType(@Nonnull ArmorItem.Type type)
    {
        return (int) getTierStrength(this.tierIndex, this.tiersTotal, this.FLOOR_TIER.getDefenseForType(type), this.CEILING_TIER.getDefenseForType(type), this.floorBump);
    }

    @Override
    public int getEnchantmentValue()
    {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound()
    {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient()
    {
        return this.repairItem.get();
    }

    @Override
    public String getName()
    {
        return this.name;
    }

    @Override
    public float getToughness()
    {
        return this.toughness;
    }

    //New "Armor knockback resistance", hardcoding for now since all vanilla tiers have it at 0 anyway
    @Override
    public float getKnockbackResistance()
    {
        return 0.0f;
    }
}

