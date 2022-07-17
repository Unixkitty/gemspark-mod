package com.unixkitty.gemspark.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public final class TagHelper
{
    public static ResourceLocation modResource(String modId, String type, String name)
    {
        return new ResourceLocation(modId, type + "/" + name);
    }

    public static TagKey<Item> itemTag(String modId, String name)
    {
        return ItemTags.create(HelperUtil.prefixResource(modId, name));
    }

    public static TagKey<Block> blockTag(String modId, String name)
    {
        return BlockTags.create(HelperUtil.prefixResource(modId, name));
    }

    public static TagKey<Block> forgeBlockTag(String type, String name)
    {
        return BlockTags.create(modResource("forge", type, name));
    }

    public static TagKey<Item> forgeItemTag(String type, String name)
    {
        return ItemTags.create(modResource("forge", type, name));
    }
}
