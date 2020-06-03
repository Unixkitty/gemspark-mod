package com.unixkitty.gemspark.item;

import com.unixkitty.gemspark.init.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class ModArmorItem extends ArmorItem
{
    private final String materialString;

    public ModArmorItem(String materialString, IArmorMaterial material, EquipmentSlotType slot, Properties properties)
    {
        super(material, slot, properties);

        this.materialString = materialString;
    }

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type)
    {
        return ModItems.getArmorTextureString(this.materialString, slot, type);
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player)
    {
        if (!world.isRemote && player.ticksExisted % 90 == 0 && this.getArmorMaterial() == Gem.PINK_SAPPHIRE.getArmorProperties())
        {
            boolean shouldApplyEffect = false;

            for (ItemStack armorStack : player.getArmorInventoryList())
            {
                if ((armorStack.getItem() instanceof ArmorItem && ((ArmorItem) armorStack.getItem()).getArmorMaterial() == Gem.PINK_SAPPHIRE.getArmorProperties()))
                {
                    shouldApplyEffect = true;
                }
                else
                {
                    shouldApplyEffect = false;
                    break;
                }
            }

            if (shouldApplyEffect)
            {
                player.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 100, 0, false, false));
            }
        }
    }
}
