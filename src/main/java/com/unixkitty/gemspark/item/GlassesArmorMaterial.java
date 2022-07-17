package com.unixkitty.gemspark.item;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.TagKey;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;

public enum GlassesArmorMaterial implements ArmorMaterial
{
    SPECTACLES(Gem.SAPPHIRE.getItemTag()),
    TECHNICOLOR(Tags.Items.GEMS_EMERALD),
    THREE_DEE(Tags.Items.GEMS_DIAMOND),
    RED(Gem.RUBY.getItemTag());

    private final LazyLoadedValue<Ingredient> repairItem;

    GlassesArmorMaterial(TagKey<Item> repairItem)
    {
        this.repairItem = new LazyLoadedValue<>(() -> Ingredient.of(repairItem));
    }

    @Override
    public int getDurabilityForSlot(EquipmentSlot slot)
    {
        return ArmorMaterials.LEATHER.getDurabilityForSlot(slot);
    }

    @Override
    public int getDefenseForSlot(EquipmentSlot slot)
    {
        return ArmorMaterials.LEATHER.getDefenseForSlot(slot);
    }

    @Override
    public int getEnchantmentValue()
    {
        return ArmorMaterials.GOLD.getEnchantmentValue();
    }

    @Override
    public SoundEvent getEquipSound()
    {
        return ArmorMaterials.LEATHER.getEquipSound();
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
        return ArmorMaterials.LEATHER.getToughness();
    }

    @Override
    public float getKnockbackResistance()
    {
        return 0.0f;
    }


}
