package com.unixkitty.gemspark.datagen;

import com.unixkitty.gemspark.Gemspark;
import com.unixkitty.gemspark.util.Gem;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;

public class ModTags
{
    public static final String GEMS_PREFIX = Tags.Items.GEMS.getId().getPath();
    public static final String STORAGE_BLOCKS_PREFIX = Tags.Blocks.STORAGE_BLOCKS.getId().getPath();
    public static final String ORES_PREFIX = Tags.Blocks.ORES.getId().getPath();

    public static class Items
    {
        public static final Tag<Item> TANZANITE = forgeTag(GEMS_PREFIX, Gem.TANZANITE.toString());
        public static final Tag<Item> TOPAZ = forgeTag(GEMS_PREFIX, Gem.TOPAZ.toString());
        public static final Tag<Item> SAPPHIRE = forgeTag(GEMS_PREFIX, Gem.SAPPHIRE.toString());
        public static final Tag<Item> PINK_SAPPHIRE = forgeTag(GEMS_PREFIX, Gem.PINK_SAPPHIRE.toString());
        public static final Tag<Item> RUBY = forgeTag(GEMS_PREFIX, Gem.RUBY.toString());

        public static final Tag<Item> TANZANITE_BLOCK = forgeTag(STORAGE_BLOCKS_PREFIX, Gem.TANZANITE.toString());
        public static final Tag<Item> TOPAZ_BLOCK = forgeTag(STORAGE_BLOCKS_PREFIX, Gem.TOPAZ.toString());
        public static final Tag<Item> SAPPHIRE_BLOCK = forgeTag(STORAGE_BLOCKS_PREFIX, Gem.SAPPHIRE.toString());
        public static final Tag<Item> PINK_SAPPHIRE_BLOCK = forgeTag(STORAGE_BLOCKS_PREFIX, Gem.PINK_SAPPHIRE.toString());
        public static final Tag<Item> RUBY_BLOCK = forgeTag(STORAGE_BLOCKS_PREFIX, Gem.RUBY.toString());

        public static final Tag<Item> TANZANITE_ORE = forgeTag(ORES_PREFIX, Gem.TANZANITE.toString());
        public static final Tag<Item> TOPAZ_ORE = forgeTag(ORES_PREFIX, Gem.TOPAZ.toString());
        public static final Tag<Item> SAPPHIRE_ORE = forgeTag(ORES_PREFIX, Gem.SAPPHIRE.toString());
        public static final Tag<Item> PINK_SAPPHIRE_ORE = forgeTag(ORES_PREFIX, Gem.PINK_SAPPHIRE.toString());
        public static final Tag<Item> RUBY_ORE = forgeTag(ORES_PREFIX, Gem.RUBY.toString());

        private static Tag<Item> tag(String name)
        {
            return new ItemTags.Wrapper(new ResourceLocation(Gemspark.MODID, name));
        }

        private static Tag<Item> forgeTag(String type, String name)
        {
            return new ItemTags.Wrapper(forgeResource(type, name));
        }
    }

    public static class Blocks
    {
        public static final Tag<Block> TANZANITE_BLOCK = forgeTag(STORAGE_BLOCKS_PREFIX, Gem.TANZANITE.toString());
        public static final Tag<Block> TOPAZ_BLOCK = forgeTag(STORAGE_BLOCKS_PREFIX, Gem.TOPAZ.toString());
        public static final Tag<Block> SAPPHIRE_BLOCK = forgeTag(STORAGE_BLOCKS_PREFIX, Gem.SAPPHIRE.toString());
        public static final Tag<Block> PINK_SAPPHIRE_BLOCK = forgeTag(STORAGE_BLOCKS_PREFIX, Gem.PINK_SAPPHIRE.toString());
        public static final Tag<Block> RUBY_BLOCK = forgeTag(STORAGE_BLOCKS_PREFIX, Gem.RUBY.toString());

        public static final Tag<Block> TANZANITE_ORE = forgeTag(ORES_PREFIX, Gem.TANZANITE.toString());
        public static final Tag<Block> TOPAZ_ORE = forgeTag(ORES_PREFIX, Gem.TOPAZ.toString());
        public static final Tag<Block> SAPPHIRE_ORE = forgeTag(ORES_PREFIX, Gem.SAPPHIRE.toString());
        public static final Tag<Block> PINK_SAPPHIRE_ORE = forgeTag(ORES_PREFIX, Gem.PINK_SAPPHIRE.toString());
        public static final Tag<Block> RUBY_ORE = forgeTag(ORES_PREFIX, Gem.RUBY.toString());

        private static Tag<Block> tag(String name)
        {
            return new BlockTags.Wrapper(new ResourceLocation(Gemspark.MODID, name));
        }

        private static Tag<Block> forgeTag(String type, String name)
        {
            return new BlockTags.Wrapper(forgeResource(type, name));
        }
    }

    private static ResourceLocation forgeResource(String type, String name)
    {
        return new ResourceLocation("forge", type + "/" + name);
    }
}
