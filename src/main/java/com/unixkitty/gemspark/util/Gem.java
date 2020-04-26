package com.unixkitty.gemspark.util;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Locale;

public enum Gem implements IItemTier, IArmorMaterial
{
    EMERALD(null,
            new ToolProperties(0, 0, 0, 0, 0),
            new ArmorProperties(0, 0, 0, 0, 0, 0)
    ),
    DIAMOND(null,
            new ToolProperties(ItemTier.DIAMOND.getHarvestLevel(), ItemTier.DIAMOND.getMaxUses(), ItemTier.DIAMOND.getEfficiency(), ItemTier.DIAMOND.getAttackDamage(), ItemTier.DIAMOND.getEnchantability()),
            new ArmorProperties(33, 2.0f, 3, 6, 8, 3)
    ),
    TANZANITE(Rarity.COMMON,
            new ToolProperties(ItemTier.IRON.getHarvestLevel(), 755, 7.5f, 2.75f, 32),
            new ArmorProperties(18, 1.0f, 2, 5, 7, 2)
    ),
    TOPAZ(Rarity.COMMON,
            new ToolProperties(ItemTier.IRON.getHarvestLevel(), 905, 9f, 3.5f, 24),
            new ArmorProperties(24, 1.0f, 2, 5, 7, 2)
    ),
    SAPPHIRE(Rarity.UNCOMMON,
            new ToolProperties(ItemTier.IRON.getHarvestLevel(), 1070, 9.75f, 3.875f, 23),
            new ArmorProperties(27, 1.0f, 2, 5, 7, 2)
    ),
    PINK_SAPPHIRE(Rarity.RARE,
            new ToolProperties(ItemTier.DIAMOND.getHarvestLevel(), 1233, 12.0f, 4.0f, 50),
            new ArmorProperties(28, 1.0f, 2, 5, 7, 2)
    ),
    RUBY(Rarity.RARE,
            new ToolProperties(ItemTier.DIAMOND.getHarvestLevel(), 1233, 10.5f, 4.25f, 22),
            new ArmorProperties(29, 1.0f, 2, 5, 7, 2)
    );

    private final Rarity rarity;

    private final ToolProperties tool;
    private final ArmorProperties armor;

    private Item gem = null;

    Gem(Rarity rarity, ToolProperties toolProperties, ArmorProperties armorProperties)
    {
        this.rarity = rarity;

        this.tool = toolProperties;
        this.armor = armorProperties;
    }

    public void setItem(Item item)
    {
        this.gem = item;
    }

    public Item getItem()
    {
        return this == EMERALD ? Items.EMERALD : (this == DIAMOND ? Items.DIAMOND : this.gem);
    }

    private static class ToolProperties
    {
        private final int harvestLevel;
        private final int durability;
        private final float efficiency;
        private final float attackDamage;
        private final int enchantability;

        ToolProperties(int harvestLevel, int durability, float efficiency, float attackDamage, int enchantability)
        {
            this.harvestLevel = harvestLevel;
            this.durability = durability;
            this.efficiency = efficiency;
            this.attackDamage = attackDamage;
            this.enchantability = enchantability;
        }
    }

    private static class ArmorProperties
    {
        //Hardcoded in vanilla
        private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};

        private final int durabilityFactor;
        private final int[] damageReductionAmounts;
        private final float toughness;

        ArmorProperties(int durabilityFactor, float toughness, int feetReduction, int legsReduction, int chestReduction, int headReduction)
        {
            this.durabilityFactor = durabilityFactor;
            this.damageReductionAmounts = new int[]{feetReduction, legsReduction, chestReduction, headReduction};
            this.toughness = toughness;
        }
    }

    public Rarity getRarity()
    {
        return rarity;
    }

    @Override
    public String toString()
    {
        return super.toString().toLowerCase(Locale.US);
    }

    @Override
    public int getMaxUses()
    {
        return tool.durability;
    }

    @Override
    public float getEfficiency()
    {
        return tool.efficiency;
    }

    @Override
    public float getAttackDamage()
    {
        return tool.attackDamage;
    }

    @Override
    public int getHarvestLevel()
    {
        return tool.harvestLevel;
    }

    @Override
    public int getDurability(EquipmentSlotType slotIn)
    {
        return armor.durabilityFactor * ArmorProperties.MAX_DAMAGE_ARRAY[slotIn.getIndex()];
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType slotIn)
    {
        return armor.damageReductionAmounts[slotIn.getIndex()];
    }

    @Override
    public int getEnchantability()
    {
        return tool.enchantability;
    }

    @Override
    public SoundEvent getSoundEvent()
    {
        return SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND;
    }

    @Override
    public Ingredient getRepairMaterial()
    {
        //TODO this should be a forge "tag", aka the old OreDictionary
        return Ingredient.fromItems(gem);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public String getName()
    {
        return toString();
    }

    @Override
    public float getToughness()
    {
        return armor.toughness;
    }
}
