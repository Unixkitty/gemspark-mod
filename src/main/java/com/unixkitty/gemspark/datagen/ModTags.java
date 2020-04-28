package com.unixkitty.gemspark.datagen;

import com.unixkitty.gemspark.item.Gem;
import com.unixkitty.gemspork.item.TagHelper;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.Tag;
import net.minecraftforge.common.Tags;

public class ModTags
{
    public static final String GEMS_PREFIX = Tags.Items.GEMS.getId().getPath();
    public static final String STORAGE_BLOCKS_PREFIX = Tags.Blocks.STORAGE_BLOCKS.getId().getPath();
    public static final String ORES_PREFIX = Tags.Blocks.ORES.getId().getPath();

    public static class Items
    {
        public static final Tag<Item> TANZANITE_BLOCK = TagHelper.forgeItemTag(STORAGE_BLOCKS_PREFIX, Gem.TANZANITE.toString());
        public static final Tag<Item> TOPAZ_BLOCK = TagHelper.forgeItemTag(STORAGE_BLOCKS_PREFIX, Gem.TOPAZ.toString());
        public static final Tag<Item> SAPPHIRE_BLOCK = TagHelper.forgeItemTag(STORAGE_BLOCKS_PREFIX, Gem.SAPPHIRE.toString());
        public static final Tag<Item> PINK_SAPPHIRE_BLOCK = TagHelper.forgeItemTag(STORAGE_BLOCKS_PREFIX, Gem.PINK_SAPPHIRE.toString());
        public static final Tag<Item> RUBY_BLOCK = TagHelper.forgeItemTag(STORAGE_BLOCKS_PREFIX, Gem.RUBY.toString());

        public static final Tag<Item> TANZANITE_ORE = TagHelper.forgeItemTag(ORES_PREFIX, Gem.TANZANITE.toString());
        public static final Tag<Item> TOPAZ_ORE = TagHelper.forgeItemTag(ORES_PREFIX, Gem.TOPAZ.toString());
        public static final Tag<Item> SAPPHIRE_ORE = TagHelper.forgeItemTag(ORES_PREFIX, Gem.SAPPHIRE.toString());
        public static final Tag<Item> PINK_SAPPHIRE_ORE = TagHelper.forgeItemTag(ORES_PREFIX, Gem.PINK_SAPPHIRE.toString());
        public static final Tag<Item> RUBY_ORE = TagHelper.forgeItemTag(ORES_PREFIX, Gem.RUBY.toString());
    }

    public static class Blocks
    {
        public static final Tag<Block> TANZANITE_BLOCK = TagHelper.forgeBlockTag(STORAGE_BLOCKS_PREFIX, Gem.TANZANITE.toString());
        public static final Tag<Block> TOPAZ_BLOCK = TagHelper.forgeBlockTag(STORAGE_BLOCKS_PREFIX, Gem.TOPAZ.toString());
        public static final Tag<Block> SAPPHIRE_BLOCK = TagHelper.forgeBlockTag(STORAGE_BLOCKS_PREFIX, Gem.SAPPHIRE.toString());
        public static final Tag<Block> PINK_SAPPHIRE_BLOCK = TagHelper.forgeBlockTag(STORAGE_BLOCKS_PREFIX, Gem.PINK_SAPPHIRE.toString());
        public static final Tag<Block> RUBY_BLOCK = TagHelper.forgeBlockTag(STORAGE_BLOCKS_PREFIX, Gem.RUBY.toString());

        public static final Tag<Block> TANZANITE_ORE = TagHelper.forgeBlockTag(ORES_PREFIX, Gem.TANZANITE.toString());
        public static final Tag<Block> TOPAZ_ORE = TagHelper.forgeBlockTag(ORES_PREFIX, Gem.TOPAZ.toString());
        public static final Tag<Block> SAPPHIRE_ORE = TagHelper.forgeBlockTag(ORES_PREFIX, Gem.SAPPHIRE.toString());
        public static final Tag<Block> PINK_SAPPHIRE_ORE = TagHelper.forgeBlockTag(ORES_PREFIX, Gem.PINK_SAPPHIRE.toString());
        public static final Tag<Block> RUBY_ORE = TagHelper.forgeBlockTag(ORES_PREFIX, Gem.RUBY.toString());
    }

}
