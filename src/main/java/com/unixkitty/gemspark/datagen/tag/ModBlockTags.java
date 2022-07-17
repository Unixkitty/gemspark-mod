package com.unixkitty.gemspark.datagen.tag;

import com.unixkitty.gemspark.Gemspark;
import com.unixkitty.gemspark.init.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTags extends BlockTagsProvider
{
    public ModBlockTags(DataGenerator generatorIn, ExistingFileHelper existingFileHelper)
    {
        super(generatorIn, Gemspark.MODID, existingFileHelper);
    }

    @Override
    protected void addTags()
    {
        tag(Tags.Blocks.STORAGE_BLOCKS).addTags(
                ModTags.Blocks.TANZANITE_BLOCK,
                ModTags.Blocks.TOPAZ_BLOCK,
                ModTags.Blocks.SAPPHIRE_BLOCK,
                ModTags.Blocks.PINK_SAPPHIRE_BLOCK,
                ModTags.Blocks.RUBY_BLOCK
        );
        tag(ModTags.Blocks.TANZANITE_BLOCK).add(ModBlocks.TANZANITE_BLOCK.get());
        tag(ModTags.Blocks.TOPAZ_BLOCK).add(ModBlocks.TOPAZ_BLOCK.get());
        tag(ModTags.Blocks.SAPPHIRE_BLOCK).add(ModBlocks.SAPPHIRE_BLOCK.get());
        tag(ModTags.Blocks.PINK_SAPPHIRE_BLOCK).add(ModBlocks.PINK_SAPPHIRE_BLOCK.get());
        tag(ModTags.Blocks.RUBY_BLOCK).add(ModBlocks.RUBY_BLOCK.get());

        tag(Tags.Blocks.ORES).addTags(
                ModTags.Blocks.TANZANITE_ORE,
                ModTags.Blocks.TOPAZ_ORE,
                ModTags.Blocks.SAPPHIRE_ORE,
                ModTags.Blocks.PINK_SAPPHIRE_ORE,
                ModTags.Blocks.RUBY_ORE
        );
        tag(ModTags.Blocks.TANZANITE_ORE).add(ModBlocks.TANZANITE_ORE.get(), ModBlocks.DEEPSLATE_TANZANITE_ORE.get());
        tag(ModTags.Blocks.TOPAZ_ORE).add(ModBlocks.TOPAZ_ORE.get(), ModBlocks.DEEPSLATE_TOPAZ_ORE.get());
        tag(ModTags.Blocks.SAPPHIRE_ORE).add(ModBlocks.SAPPHIRE_ORE.get(), ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get());
        tag(ModTags.Blocks.PINK_SAPPHIRE_ORE).add(ModBlocks.PINK_SAPPHIRE_ORE.get());
        tag(ModTags.Blocks.RUBY_ORE).add(ModBlocks.RUBY_ORE.get(), ModBlocks.DEEPSLATE_RUBY_ORE.get());

        tag(BlockTags.STONE_ORE_REPLACEABLES).add(
                ModBlocks.TANZANITE_ORE.get(),
                ModBlocks.TOPAZ_ORE.get(),
                ModBlocks.SAPPHIRE_ORE.get(),
                ModBlocks.RUBY_ORE.get()
        );

        tag(BlockTags.DEEPSLATE_ORE_REPLACEABLES).add(
                ModBlocks.DEEPSLATE_TANZANITE_ORE.get(),
                ModBlocks.DEEPSLATE_TOPAZ_ORE.get(),
                ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(),
                ModBlocks.DEEPSLATE_RUBY_ORE.get()
        );

        tag(BlockTags.CAMPFIRES).add(ModBlocks.BRAZIER.get(), ModBlocks.SOUL_BRAZIER.get());

        tag(BlockTags.IMPERMEABLE).add(
                ModBlocks.EMERALD_GLASS.get(),
                ModBlocks.DIAMOND_GLASS.get(),
                ModBlocks.TANZANITE_GLASS.get(),
                ModBlocks.TOPAZ_GLASS.get(),
                ModBlocks.SAPPHIRE_GLASS.get(),
                ModBlocks.PINK_SAPPHIRE_GLASS.get(),
                ModBlocks.RUBY_GLASS.get(),
                ModBlocks.EMERALD_GLOWING_GLASS.get(),
                ModBlocks.DIAMOND_GLOWING_GLASS.get(),
                ModBlocks.TANZANITE_GLOWING_GLASS.get(),
                ModBlocks.TOPAZ_GLOWING_GLASS.get(),
                ModBlocks.SAPPHIRE_GLOWING_GLASS.get(),
                ModBlocks.PINK_SAPPHIRE_GLOWING_GLASS.get(),
                ModBlocks.RUBY_GLOWING_GLASS.get()
        );

        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                ModBlocks.TANZANITE_BLOCK.get(),
                ModBlocks.TOPAZ_BLOCK.get(),
                ModBlocks.SAPPHIRE_BLOCK.get(),
                ModBlocks.PINK_SAPPHIRE_BLOCK.get(),
                ModBlocks.RUBY_BLOCK.get(),

                ModBlocks.EMERALD_GEMSPARK_BLOCK.get(),
                ModBlocks.DIAMOND_GEMSPARK_BLOCK.get(),
                ModBlocks.TANZANITE_GEMSPARK_BLOCK.get(),
                ModBlocks.TOPAZ_GEMSPARK_BLOCK.get(),
                ModBlocks.SAPPHIRE_GEMSPARK_BLOCK.get(),
                ModBlocks.PINK_SAPPHIRE_GEMSPARK_BLOCK.get(),
                ModBlocks.RUBY_GEMSPARK_BLOCK.get(),

                ModBlocks.TANZANITE_ORE.get(),
                ModBlocks.TOPAZ_ORE.get(),
                ModBlocks.SAPPHIRE_ORE.get(),
                ModBlocks.PINK_SAPPHIRE_ORE.get(),
                ModBlocks.RUBY_ORE.get(),

                ModBlocks.DEEPSLATE_TANZANITE_ORE.get(),
                ModBlocks.DEEPSLATE_TOPAZ_ORE.get(),
                ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(),
                ModBlocks.DEEPSLATE_RUBY_ORE.get(),

                ModBlocks.COLORED_LAMP_WHITE.get(),
                ModBlocks.COLORED_LAMP_ORANGE.get(),
                ModBlocks.COLORED_LAMP_MAGENTA.get(),
                ModBlocks.COLORED_LAMP_LIGHT_BLUE.get(),
                ModBlocks.COLORED_LAMP_YELLOW.get(),
                ModBlocks.COLORED_LAMP_LIME.get(),
                ModBlocks.COLORED_LAMP_PINK.get(),
                ModBlocks.COLORED_LAMP_GRAY.get(),
                ModBlocks.COLORED_LAMP_LIGHT_GRAY.get(),
                ModBlocks.COLORED_LAMP_CYAN.get(),
                ModBlocks.COLORED_LAMP_PURPLE.get(),
                ModBlocks.COLORED_LAMP_BLUE.get(),
                ModBlocks.COLORED_LAMP_BROWN.get(),
                ModBlocks.COLORED_LAMP_GREEN.get(),
                ModBlocks.COLORED_LAMP_RED.get(),
                ModBlocks.COLORED_LAMP_BLACK.get(),

                ModBlocks.COLORED_INVERTED_LAMP_WHITE.get(),
                ModBlocks.COLORED_INVERTED_LAMP_ORANGE.get(),
                ModBlocks.COLORED_INVERTED_LAMP_MAGENTA.get(),
                ModBlocks.COLORED_INVERTED_LAMP_LIGHT_BLUE.get(),
                ModBlocks.COLORED_INVERTED_LAMP_YELLOW.get(),
                ModBlocks.COLORED_INVERTED_LAMP_LIME.get(),
                ModBlocks.COLORED_INVERTED_LAMP_PINK.get(),
                ModBlocks.COLORED_INVERTED_LAMP_GRAY.get(),
                ModBlocks.COLORED_INVERTED_LAMP_LIGHT_GRAY.get(),
                ModBlocks.COLORED_INVERTED_LAMP_CYAN.get(),
                ModBlocks.COLORED_INVERTED_LAMP_PURPLE.get(),
                ModBlocks.COLORED_INVERTED_LAMP_BLUE.get(),
                ModBlocks.COLORED_INVERTED_LAMP_BROWN.get(),
                ModBlocks.COLORED_INVERTED_LAMP_GREEN.get(),
                ModBlocks.COLORED_INVERTED_LAMP_RED.get(),
                ModBlocks.COLORED_INVERTED_LAMP_BLACK.get(),

                ModBlocks.BLACKSTONE_PEDESTAL.get(),
                ModBlocks.QUARTZ_PEDESTAL.get(),

                ModBlocks.SOUL_BRAZIER.get(),
                ModBlocks.BRAZIER.get(),

                ModBlocks.STONE_FLOOR_TILE.get(),
                ModBlocks.STONE_TILES.get(),
                ModBlocks.SMOKED_STONE.get(),
                ModBlocks.SMOKED_STONE_CTM.get(),
                ModBlocks.METAL_FRAMED_STONE.get(),
                ModBlocks.METAL_FRAMED_STONE_CTM.get(),
                ModBlocks.ACCENTUATED_STONE.get(),
                ModBlocks.ACCENTUATED_STONE_CTM.get(),

                ModBlocks.LIGHT_RAINBOW_BRICKS.get(),
                ModBlocks.DARK_RAINBOW_BRICKS.get()
        );

        tag(BlockTags.NEEDS_STONE_TOOL).add(
                ModBlocks.SOUL_BRAZIER.get(),
                ModBlocks.BRAZIER.get()
        );

        tag(BlockTags.NEEDS_IRON_TOOL).add(
                ModBlocks.TANZANITE_BLOCK.get(),
                ModBlocks.TOPAZ_BLOCK.get(),
                ModBlocks.SAPPHIRE_BLOCK.get(),
                ModBlocks.PINK_SAPPHIRE_BLOCK.get(),
                ModBlocks.RUBY_BLOCK.get(),

                ModBlocks.TANZANITE_ORE.get(),
                ModBlocks.TOPAZ_ORE.get(),
                ModBlocks.SAPPHIRE_ORE.get(),
                ModBlocks.PINK_SAPPHIRE_ORE.get(),
                ModBlocks.RUBY_ORE.get(),

                ModBlocks.DEEPSLATE_TANZANITE_ORE.get(),
                ModBlocks.DEEPSLATE_TOPAZ_ORE.get(),
                ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(),
                ModBlocks.DEEPSLATE_RUBY_ORE.get()
        );

        tag(BlockTags.MINEABLE_WITH_AXE).add(
                ModBlocks.LAMP_POST_CAP_OAK.get(),
                ModBlocks.LAMP_POST_CAP_NETHER_BRICK.get(),
                ModBlocks.LAMP_POST_CAP_SPRUCE.get(),
                ModBlocks.LAMP_POST_CAP_BIRCH.get(),
                ModBlocks.LAMP_POST_CAP_JUNGLE.get(),
                ModBlocks.LAMP_POST_CAP_ACACIA.get(),
                ModBlocks.LAMP_POST_CAP_DARK_OAK.get(),
                ModBlocks.LAMP_POST_CAP_WARPED.get(),
                ModBlocks.LAMP_POST_CAP_CRIMSON.get(),
                ModBlocks.WOOD_GOLEM_RELIC.get()
        );

        tag(BlockTags.MINEABLE_WITH_SHOVEL).add(
                ModBlocks.DARK_ROCKY_DIRT.get(),
                ModBlocks.ROCKY_DIRT.get(),
                ModBlocks.ROCKY_GRASSY_DIRT.get()
        );
    }

    @Override
    public String getName()
    {
        return Gemspark.MODNAME + " " + this.getClass().getSimpleName();
    }
}
