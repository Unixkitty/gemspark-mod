package com.unixkitty.gemspark.item;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ITag;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.Tags;

public enum ModSimpleArmorMaterial implements IArmorMaterial
{
    CROWN(Tags.Items.INGOTS_GOLD),
    SILVER_CROWN(Tags.Items.INGOTS_IRON),
    RGB_CROWN(Tags.Items.INGOTS_GOLD),
    SILVER_RGB_CROWN(Tags.Items.INGOTS_IRON);

    private final LazyValue<Ingredient> repairItem;

    ModSimpleArmorMaterial(ITag<Item> repairItem)
    {
        this.repairItem = new LazyValue<>(() -> Ingredient.of(repairItem));
    }

    @Override
    public int getDurabilityForSlot(EquipmentSlotType slot)
    {
        return ArmorMaterial.LEATHER.getDurabilityForSlot(slot);
    }

    @Override
    public int getDefenseForSlot(EquipmentSlotType slot)
    {
        return ArmorMaterial.LEATHER.getDefenseForSlot(slot);
    }

    @Override
    public int getEnchantmentValue()
    {
        return ArmorMaterial.GOLD.getEnchantmentValue();
    }

    @Override
    public SoundEvent getEquipSound()
    {
        return ArmorMaterial.LEATHER.getEquipSound();
    }

    @Override
    public Ingredient getRepairIngredient()
    {
        return this.repairItem.get();
    }

    @Override
    public String getName()
    {
        return this.toString();
    }

    @Override
    public float getToughness()
    {
        return ArmorMaterial.LEATHER.getToughness();
    }

    @Override
    public float getKnockbackResistance()
    {
        return 0.0f;
    }


}
