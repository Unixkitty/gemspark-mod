package com.unixkitty.gemspark.util;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

public final class TagHelper
{
    public static ResourceLocation modResource(String modId, String type, String name)
    {
        return new ResourceLocation(modId, type + "/" + name);
    }

    public static Tag.Named<Item> itemTag(String modId, String name)
    {
        return ItemTags.bind(HelperUtil.prefixResource(modId, name).toString());
    }

    public static Tag.Named<Block> blockTag(String modId, String name)
    {
        return BlockTags.bind(HelperUtil.prefixResource(modId, name).toString());
    }

    public static Tag.Named<Block> forgeBlockTag(String type, String name)
    {
        return BlockTags.bind(modResource("forge", type, name).toString());
    }

    public static Tag.Named<Item> forgeItemTag(String type, String name)
    {
        return ItemTags.bind(modResource("forge", type, name).toString());
    }
}
