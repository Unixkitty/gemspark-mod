package com.unixkitty.gemspark.item;

import com.unixkitty.gemspark.init.ModItems;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class ModArmorItem extends ArmorItem
{
    private final String materialString;

    public ModArmorItem(String materialString, ArmorMaterial material, EquipmentSlot slot, Properties properties)
    {
        super(material, slot, properties);

        this.materialString = materialString;
    }

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type)
    {
        return ModItems.getArmorTextureString(this.materialString, slot, type);
    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player)
    {
        if (!world.isClientSide && player.tickCount % 90 == 0 && this.getMaterial() == Gem.PINK_SAPPHIRE.getArmorProperties())
        {
            boolean shouldApplyEffect = false;

            for (ItemStack armorStack : player.getArmorSlots())
            {
                if ((armorStack.getItem() instanceof ArmorItem && ((ArmorItem) armorStack.getItem()).getMaterial() == Gem.PINK_SAPPHIRE.getArmorProperties()))
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
                player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 100, 0, false, false));
            }
        }
    }
}
