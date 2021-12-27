package com.unixkitty.gemspark.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.Tag;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Nullable;

//TODO clean up these methods if possible
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

    public static ItemLike itemFromTag(String resourceDomain, Tag.Named<Item> ingredient)
    {
        return ForgeRegistries.ITEMS.getValue(prefixResource(resourceDomain, materialString(ingredient)));
    }

    public static Item itemFromMaterialTag(Tag.Named<Item> material, String resourceDomain, String type)
    {
        return ForgeRegistries.ITEMS.getValue(HelperUtil.materialResource(material, resourceDomain, type));
    }

    public static Item armorItemFromMaterialResource(Tag.Named<Item> material, EquipmentSlot slot, String resourceDomain)
    {
        return ForgeRegistries.ITEMS.getValue(armorResource(material, slot, resourceDomain));
    }

    public static ResourceLocation materialResource(Tag.Named<Item> material, String resourceDomain, String type)
    {
        return prefixResource(resourceDomain, materialString(material) + "_" + type);
    }

    public static ResourceLocation armorResource(Tag.Named<Item> material, EquipmentSlot slot, String resourceDomain)
    {
        return prefixResource(resourceDomain, armorMaterialString(material, slot));
    }

    public static String armorMaterialString(String material, EquipmentSlot slot)
    {
        return material + "_" + armorSlotString(slot);
    }

    public static String armorMaterialString(Tag.Named<Item> material, EquipmentSlot slot)
    {
        return materialString(material) + "_" + armorSlotString(slot);
    }

    public static String materialString(Tag.Named<Item> ingredient)
    {
        String material = ingredient.getName().getPath();

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

