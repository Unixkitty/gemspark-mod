package com.unixkitty.gemspark.datagen;

import com.unixkitty.gemspark.Gemspark;
import com.unixkitty.gemspark.init.ModBlocks;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;

import java.nio.file.Path;
import java.util.Set;
import java.util.stream.Collectors;

@SuppressWarnings("ConstantConditions")
public class BlockTagProvider extends BlockTagsProvider
{
    private Set<ResourceLocation> filter = null;

    public BlockTagProvider(DataGenerator generatorIn)
    {
        super(generatorIn);
    }

    @Override
    protected void registerTags()
    {
        //Predicate<Block> gemspark = g -> Gemspark.MODID.equals(g.getRegistryName().getNamespace());
        super.registerTags();

        filter = this.tagToBuilder.keySet().stream().map(Tag::getId).collect(Collectors.toSet());

        getBuilder(Tags.Blocks.STORAGE_BLOCKS).add(
                ModTags.Blocks.TANZANITE_BLOCK,
                ModTags.Blocks.TOPAZ_BLOCK,
                ModTags.Blocks.SAPPHIRE_BLOCK,
                ModTags.Blocks.PINK_SAPPHIRE_BLOCK,
                ModTags.Blocks.RUBY_BLOCK
        );
        getBuilder(ModTags.Blocks.TANZANITE_BLOCK).add(ModBlocks.TANZANITE_BLOCK.get());
        getBuilder(ModTags.Blocks.TOPAZ_BLOCK).add(ModBlocks.TOPAZ_BLOCK.get());
        getBuilder(ModTags.Blocks.SAPPHIRE_BLOCK).add(ModBlocks.SAPPHIRE_BLOCK.get());
        getBuilder(ModTags.Blocks.PINK_SAPPHIRE_BLOCK).add(ModBlocks.PINK_SAPPHIRE_BLOCK.get());
        getBuilder(ModTags.Blocks.RUBY_BLOCK).add(ModBlocks.RUBY_BLOCK.get());

        getBuilder(Tags.Blocks.ORES).add(
                ModTags.Blocks.TANZANITE_ORE,
                ModTags.Blocks.TOPAZ_ORE,
                ModTags.Blocks.SAPPHIRE_ORE,
                ModTags.Blocks.PINK_SAPPHIRE_ORE,
                ModTags.Blocks.RUBY_ORE
        );
        getBuilder(ModTags.Blocks.TANZANITE_ORE).add(ModBlocks.TANZANITE_ORE.get());
        getBuilder(ModTags.Blocks.TOPAZ_ORE).add(ModBlocks.TOPAZ_ORE.get());
        getBuilder(ModTags.Blocks.SAPPHIRE_ORE).add(ModBlocks.SAPPHIRE_ORE.get());
        getBuilder(ModTags.Blocks.PINK_SAPPHIRE_ORE).add(ModBlocks.PINK_SAPPHIRE_ORE.get());
        getBuilder(ModTags.Blocks.RUBY_ORE).add(ModBlocks.RUBY_ORE.get());
    }

    @Override
    protected Path makePath(ResourceLocation id)
    {
        return filter != null && filter.contains(id) ? null : super.makePath(id); //We don't want to save vanilla tags.
    }

    @Override
    public String getName()
    {
        return Gemspark.MODNAME + " " + this.getClass().getSimpleName();
    }
}
