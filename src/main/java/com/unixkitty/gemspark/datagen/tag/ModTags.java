package com.unixkitty.gemspark.datagen.tag;

import com.unixkitty.gemspark.item.Gem;
import com.unixkitty.gemspark.util.TagHelper;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;

public class ModTags
{
    public static final String GEMS_PREFIX = Tags.Items.GEMS.getName().getPath();
    public static final String STORAGE_BLOCKS_PREFIX = Tags.Blocks.STORAGE_BLOCKS.getName().getPath();
    public static final String ORES_PREFIX = Tags.Blocks.ORES.getName().getPath();

    public static class Items
    {
        public static final Tag.Named<Item> TANZANITE_BLOCK = TagHelper.forgeItemTag(STORAGE_BLOCKS_PREFIX, Gem.TANZANITE.toString());
        public static final Tag.Named<Item> TOPAZ_BLOCK = TagHelper.forgeItemTag(STORAGE_BLOCKS_PREFIX, Gem.TOPAZ.toString());
        public static final Tag.Named<Item> SAPPHIRE_BLOCK = TagHelper.forgeItemTag(STORAGE_BLOCKS_PREFIX, Gem.SAPPHIRE.toString());
        public static final Tag.Named<Item> PINK_SAPPHIRE_BLOCK = TagHelper.forgeItemTag(STORAGE_BLOCKS_PREFIX, Gem.PINK_SAPPHIRE.toString());
        public static final Tag.Named<Item> RUBY_BLOCK = TagHelper.forgeItemTag(STORAGE_BLOCKS_PREFIX, Gem.RUBY.toString());

        public static final Tag.Named<Item> TANZANITE_ORE = TagHelper.forgeItemTag(ORES_PREFIX, Gem.TANZANITE.toString());
        public static final Tag.Named<Item> TOPAZ_ORE = TagHelper.forgeItemTag(ORES_PREFIX, Gem.TOPAZ.toString());
        public static final Tag.Named<Item> SAPPHIRE_ORE = TagHelper.forgeItemTag(ORES_PREFIX, Gem.SAPPHIRE.toString());
        public static final Tag.Named<Item> PINK_SAPPHIRE_ORE = TagHelper.forgeItemTag(ORES_PREFIX, Gem.PINK_SAPPHIRE.toString());
        public static final Tag.Named<Item> RUBY_ORE = TagHelper.forgeItemTag(ORES_PREFIX, Gem.RUBY.toString());
    }

    public static class Blocks
    {
        public static final Tag.Named<Block> TANZANITE_BLOCK = TagHelper.forgeBlockTag(STORAGE_BLOCKS_PREFIX, Gem.TANZANITE.toString());
        public static final Tag.Named<Block> TOPAZ_BLOCK = TagHelper.forgeBlockTag(STORAGE_BLOCKS_PREFIX, Gem.TOPAZ.toString());
        public static final Tag.Named<Block> SAPPHIRE_BLOCK = TagHelper.forgeBlockTag(STORAGE_BLOCKS_PREFIX, Gem.SAPPHIRE.toString());
        public static final Tag.Named<Block> PINK_SAPPHIRE_BLOCK = TagHelper.forgeBlockTag(STORAGE_BLOCKS_PREFIX, Gem.PINK_SAPPHIRE.toString());
        public static final Tag.Named<Block> RUBY_BLOCK = TagHelper.forgeBlockTag(STORAGE_BLOCKS_PREFIX, Gem.RUBY.toString());

        public static final Tag.Named<Block> TANZANITE_ORE = TagHelper.forgeBlockTag(ORES_PREFIX, Gem.TANZANITE.toString());
        public static final Tag.Named<Block> TOPAZ_ORE = TagHelper.forgeBlockTag(ORES_PREFIX, Gem.TOPAZ.toString());
        public static final Tag.Named<Block> SAPPHIRE_ORE = TagHelper.forgeBlockTag(ORES_PREFIX, Gem.SAPPHIRE.toString());
        public static final Tag.Named<Block> PINK_SAPPHIRE_ORE = TagHelper.forgeBlockTag(ORES_PREFIX, Gem.PINK_SAPPHIRE.toString());
        public static final Tag.Named<Block> RUBY_ORE = TagHelper.forgeBlockTag(ORES_PREFIX, Gem.RUBY.toString());
    }

}
