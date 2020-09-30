package com.unixkitty.gemspark.datagen;

import com.unixkitty.gemspark.item.Gem;
import com.unixkitty.gemspork.item.TagHelper;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import net.minecraftforge.common.Tags;

public class ModTags
{
    public static final String GEMS_PREFIX = Tags.Items.GEMS.getName().getPath();
    public static final String STORAGE_BLOCKS_PREFIX = Tags.Blocks.STORAGE_BLOCKS.getName().getPath();
    public static final String ORES_PREFIX = Tags.Blocks.ORES.getName().getPath();

    public static class Items
    {
        public static final ITag.INamedTag<Item> TANZANITE_BLOCK = TagHelper.forgeItemTag(STORAGE_BLOCKS_PREFIX, Gem.TANZANITE.toString());
        public static final ITag.INamedTag<Item> TOPAZ_BLOCK = TagHelper.forgeItemTag(STORAGE_BLOCKS_PREFIX, Gem.TOPAZ.toString());
        public static final ITag.INamedTag<Item> SAPPHIRE_BLOCK = TagHelper.forgeItemTag(STORAGE_BLOCKS_PREFIX, Gem.SAPPHIRE.toString());
        public static final ITag.INamedTag<Item> PINK_SAPPHIRE_BLOCK = TagHelper.forgeItemTag(STORAGE_BLOCKS_PREFIX, Gem.PINK_SAPPHIRE.toString());
        public static final ITag.INamedTag<Item> RUBY_BLOCK = TagHelper.forgeItemTag(STORAGE_BLOCKS_PREFIX, Gem.RUBY.toString());

        public static final ITag.INamedTag<Item> TANZANITE_ORE = TagHelper.forgeItemTag(ORES_PREFIX, Gem.TANZANITE.toString());
        public static final ITag.INamedTag<Item> TOPAZ_ORE = TagHelper.forgeItemTag(ORES_PREFIX, Gem.TOPAZ.toString());
        public static final ITag.INamedTag<Item> SAPPHIRE_ORE = TagHelper.forgeItemTag(ORES_PREFIX, Gem.SAPPHIRE.toString());
        public static final ITag.INamedTag<Item> PINK_SAPPHIRE_ORE = TagHelper.forgeItemTag(ORES_PREFIX, Gem.PINK_SAPPHIRE.toString());
        public static final ITag.INamedTag<Item> RUBY_ORE = TagHelper.forgeItemTag(ORES_PREFIX, Gem.RUBY.toString());
    }

    public static class Blocks
    {
        public static final ITag.INamedTag<Block> TANZANITE_BLOCK = TagHelper.forgeBlockTag(STORAGE_BLOCKS_PREFIX, Gem.TANZANITE.toString());
        public static final ITag.INamedTag<Block> TOPAZ_BLOCK = TagHelper.forgeBlockTag(STORAGE_BLOCKS_PREFIX, Gem.TOPAZ.toString());
        public static final ITag.INamedTag<Block> SAPPHIRE_BLOCK = TagHelper.forgeBlockTag(STORAGE_BLOCKS_PREFIX, Gem.SAPPHIRE.toString());
        public static final ITag.INamedTag<Block> PINK_SAPPHIRE_BLOCK = TagHelper.forgeBlockTag(STORAGE_BLOCKS_PREFIX, Gem.PINK_SAPPHIRE.toString());
        public static final ITag.INamedTag<Block> RUBY_BLOCK = TagHelper.forgeBlockTag(STORAGE_BLOCKS_PREFIX, Gem.RUBY.toString());

        public static final ITag.INamedTag<Block> TANZANITE_ORE = TagHelper.forgeBlockTag(ORES_PREFIX, Gem.TANZANITE.toString());
        public static final ITag.INamedTag<Block> TOPAZ_ORE = TagHelper.forgeBlockTag(ORES_PREFIX, Gem.TOPAZ.toString());
        public static final ITag.INamedTag<Block> SAPPHIRE_ORE = TagHelper.forgeBlockTag(ORES_PREFIX, Gem.SAPPHIRE.toString());
        public static final ITag.INamedTag<Block> PINK_SAPPHIRE_ORE = TagHelper.forgeBlockTag(ORES_PREFIX, Gem.PINK_SAPPHIRE.toString());
        public static final ITag.INamedTag<Block> RUBY_ORE = TagHelper.forgeBlockTag(ORES_PREFIX, Gem.RUBY.toString());
    }

}
