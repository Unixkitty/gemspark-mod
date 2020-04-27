package com.unixkitty.gemspark.util;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Locale;

import static com.unixkitty.gemspark.util.GemItems.GEM_TIERS;

public enum Gem implements IItemTier, IArmorMaterial
{
    EMERALD(Rarity.COMMON, 0, -1),
    DIAMOND(Rarity.COMMON, 0, -1),

    TANZANITE(Rarity.COMMON, 0, -1),
    TOPAZ(Rarity.COMMON, 1, -1),
    SAPPHIRE(Rarity.UNCOMMON, 2, -1),
    PINK_SAPPHIRE(Rarity.RARE, 3, 40),
    RUBY(Rarity.RARE, 4, -1);

    private final Rarity rarity;

    private final ToolProperties tool;
    private final ArmorProperties armor;

    private Item gem = null;

    Gem(Rarity rarity, int tierIndex, int enchantability)
    {
        this.rarity = rarity;

        this.tool = new ToolProperties(tierIndex, enchantability, rarity);
        this.armor = new ArmorProperties(tierIndex);
    }

    private static class ToolProperties
    {
        private static final ItemTier FLOOR_TIER = ItemTier.IRON;
        private static final ItemTier CEILING_TIER = ItemTier.DIAMOND;

        private final int harvestLevel;
        private final int durability;
        private final float efficiency;
        private final float attackDamage;
        private final int enchantability;

        ToolProperties(int tierIndex, int enchantability, Rarity rarity)
        {
            this.harvestLevel = rarity == Rarity.RARE ? CEILING_TIER.getHarvestLevel() : FLOOR_TIER.getHarvestLevel();
            this.durability = GemItems.gemStrength(tierIndex, GEM_TIERS, FLOOR_TIER.getMaxUses(), CEILING_TIER.getMaxUses());
            this.efficiency = GemItems.gemStrength(tierIndex, GEM_TIERS, FLOOR_TIER.getEfficiency(), CEILING_TIER.getEfficiency());
            this.attackDamage = GemItems.gemStrength(tierIndex, GEM_TIERS, FLOOR_TIER.getAttackDamage(), CEILING_TIER.getAttackDamage());
            this.enchantability = enchantability == -1 ? GemItems.gemStrength(tierIndex, GEM_TIERS, FLOOR_TIER.getEnchantability(), CEILING_TIER.getEnchantability()) : enchantability;
        }
    }

    private static class ArmorProperties
    {
        private static final ArmorMaterial FLOOR_TIER = ArmorMaterial.IRON;
        private static final ArmorMaterial CEILING_TIER = ArmorMaterial.DIAMOND;

        private final int tierIndex;
        private final float toughness;

        ArmorProperties(int tierIndex)
        {
            this.tierIndex = tierIndex;
            this.toughness = GemItems.gemStrength(tierIndex, GEM_TIERS, FLOOR_TIER.getToughness(), CEILING_TIER.getToughness());
        }

        private int getDurability(EquipmentSlotType slot)
        {
            return GemItems.gemStrength(tierIndex, GEM_TIERS, FLOOR_TIER.getDurability(slot), CEILING_TIER.getDurability(slot));
        }

        private int getDamageReductionAmount(EquipmentSlotType slot)
        {
            return GemItems.gemStrength(tierIndex, GEM_TIERS, FLOOR_TIER.getDamageReductionAmount(slot), CEILING_TIER.getDamageReductionAmount(slot));
        }
    }

    public Rarity getRarity()
    {
        return rarity;
    }

    public void setItem(Item item)
    {
        this.gem = item;
    }

    public Item getItem()
    {
        return this == EMERALD ? Items.EMERALD : (this == DIAMOND ? Items.DIAMOND : this.gem);
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
    public int getDurability(EquipmentSlotType slot)
    {
//        return armor.durabilityFactor * ArmorProperties.MAX_DAMAGE_ARRAY[slotIn.getIndex()];
        return armor.getDurability(slot);
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType slot)
    {
        return armor.getDamageReductionAmount(slot);
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
