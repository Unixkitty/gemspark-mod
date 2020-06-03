package com.unixkitty.gemspark.item;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.Tag;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.Tags;

public enum GlassesArmorMaterial implements IArmorMaterial
{
    SPECTACLES(Gem.SAPPHIRE.getItemTag()),
    TECHNICOLOR(Tags.Items.GEMS_EMERALD),
    THREE_DEE(Tags.Items.GEMS_DIAMOND),
    ;

    private final Ingredient repairItem;

    GlassesArmorMaterial(Tag<Item> repairItem)
    {
        this.repairItem = Ingredient.fromTag(repairItem);
    }

    @Override
    public int getDurability(EquipmentSlotType slot)
    {
        return ArmorMaterial.LEATHER.getDurability(slot);
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType slot)
    {
        return ArmorMaterial.LEATHER.getDamageReductionAmount(slot);
    }

    @Override
    public int getEnchantability()
    {
        return ArmorMaterial.GOLD.getEnchantability();
    }

    @Override
    public SoundEvent getSoundEvent()
    {
        return ArmorMaterial.LEATHER.getSoundEvent();
    }

    @Override
    public Ingredient getRepairMaterial()
    {
        return this.repairItem;
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
}
