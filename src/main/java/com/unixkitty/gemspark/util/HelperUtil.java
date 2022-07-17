package com.unixkitty.gemspark.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Nullable;

public final class HelperUtil
{
    public static ResourceLocation prefixResource(String domain, String path)
    {
        return new ResourceLocation(domain, path);
    }

    public static boolean isResource(@Nullable ResourceLocation resourceLocation, String resource, boolean exact)
    {
        return resourceLocation != null && (exact ? resourceLocation.getPath().matches(resource) : resourceLocation.getPath().startsWith(resource));
    }

    public static ItemLike itemFromTag(String resourceDomain, TagKey<Item> ingredient)
    {

        return ForgeRegistries.ITEMS.getValue(prefixResource(resourceDomain, materialString(ingredient)));
    }

    public static Item itemFromMaterialTag(TagKey<Item> material, String resourceDomain, String type)
    {
        return ForgeRegistries.ITEMS.getValue(HelperUtil.materialResource(material, resourceDomain, type));
    }

    public static Item armorItemFromMaterialResource(TagKey<Item> material, EquipmentSlot slot, String resourceDomain)
    {
        return ForgeRegistries.ITEMS.getValue(armorResource(material, slot, resourceDomain));
    }

    public static ResourceLocation materialResource(TagKey<Item> material, String resourceDomain, String type)
    {
        return prefixResource(resourceDomain, materialString(material) + "_" + type);
    }

    public static ResourceLocation armorResource(TagKey<Item> material, EquipmentSlot slot, String resourceDomain)
    {
        return prefixResource(resourceDomain, armorMaterialString(material, slot));
    }

    public static String armorMaterialString(String material, EquipmentSlot slot)
    {
        return material + "_" + armorSlotString(slot);
    }

    public static String armorMaterialString(TagKey<Item> material, EquipmentSlot slot)
    {
        return materialString(material) + "_" + armorSlotString(slot);
    }

    public static String materialString(TagKey<Item> ingredient)
    {
        String material = ingredient.location().getPath();

        if (material.contains("/"))
        {
            material = StringUtils.reverse(StringUtils.reverse(material).split("/")[0]);
        }

        return material;
    }

    public static String armorSlotString(EquipmentSlot slot)
    {
        return switch (slot)
                {
                    case FEET -> "boots";
                    case HEAD -> "helmet";
                    case LEGS -> "leggings";
                    case CHEST -> "chestplate";
                    default -> "";
                };
    }
}

