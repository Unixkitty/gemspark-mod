package com.unixkitty.gemspark.util;

import com.unixkitty.gemspark.Gemspark;
import com.unixkitty.gemspark.init.ModItems;
import com.unixkitty.gemspark.itemgroup.ModItemGroups;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;

public final class GemHelper
{
    public static RegistryObject<Item> registerGemItem(Gems gem)
    {
        return ModItems.ITEMS.register(gem.toString(), () -> new Item(itemProperties(gem)));
    }

    public static RegistryObject<Item> registerAxeItem(Gems gem)
    {
        return ModItems.ITEMS.register(gem + "_axe", () ->
                new AxeItem(gem, 5.0f, -3.1F, itemProperties(gem))
        );
    }

    public static RegistryObject<Item> registerSwordItem(Gems gem)
    {
        return ModItems.ITEMS.register(gem + "_sword", () ->
                new SwordItem(gem, 3, -2.4F, itemProperties(gem))
        );
    }

    public static RegistryObject<Item> registerShovelItem(Gems gem)
    {
        return ModItems.ITEMS.register(gem + "_shovel", () ->
                new ShovelItem(gem, 1.5f, -3.0F, itemProperties(gem))
        );
    }

    public static RegistryObject<Item> registerPickaxeItem(Gems gem)
    {
        return ModItems.ITEMS.register(gem + "_pickaxe", () ->
                new PickaxeItem(gem, 1, -2.8F, itemProperties(gem))
        );
    }

    public static RegistryObject<Item> registerArmorItem(Gems gem, EquipmentSlotType slot)
    {
        return ModItems.ITEMS.register(gem + "_" + armorSlotString(slot), () ->
                new ArmorItem(gem, slot, itemProperties(gem))
                {
                    @Override
                    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type)
                    {
                        return String.format("%s:textures/models/armor/%s_layer_%d%s.png", Gemspark.MODID, gem, (slot == EquipmentSlotType.LEGS ? 2 : 1), type == null ? "" : String.format("_%s", type));
                    }
                }
        );
    }

    private static String armorSlotString(EquipmentSlotType slot)
    {
        switch (slot)
        {
            case FEET:
                return "boots";
            case HEAD:
                return "helmet";
            case LEGS:
                return "leggings";
            case CHEST:
                return "chestplate";
            default:
                return "";
        }
    }

    private static Item.Properties itemProperties(Gems gem)
    {
        return new Item.Properties().rarity(gem.getRarity()).group(ModItemGroups.PRIMARY);
    }
}
