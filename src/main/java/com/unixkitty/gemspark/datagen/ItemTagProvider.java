package com.unixkitty.gemspark.datagen;

import com.unixkitty.gemspark.Gemspark;
import com.unixkitty.gemspark.init.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;

import java.nio.file.Path;
import java.util.Set;
import java.util.stream.Collectors;

public class ItemTagProvider extends ItemTagsProvider
{
    private Set<ResourceLocation> filter = null;

    public ItemTagProvider(DataGenerator generatorIn)
    {
        super(generatorIn);
    }

    @Override
    protected void registerTags()
    {
        super.registerTags();

        filter = this.tagToBuilder.keySet().stream().map(Tag::getId).collect(Collectors.toSet());

        copy(Tags.Blocks.ORES, Tags.Items.ORES);
        copy(ModTags.Blocks.TANZANITE_ORE, ModTags.Items.TANZANITE_ORE);
        copy(ModTags.Blocks.TOPAZ_ORE, ModTags.Items.TOPAZ_ORE);
        copy(ModTags.Blocks.SAPPHIRE_ORE, ModTags.Items.SAPPHIRE_ORE);
        copy(ModTags.Blocks.PINK_SAPPHIRE_ORE, ModTags.Items.PINK_SAPPHIRE_ORE);
        copy(ModTags.Blocks.RUBY_ORE, ModTags.Items.RUBY_ORE);

        copy(Tags.Blocks.STORAGE_BLOCKS, Tags.Items.STORAGE_BLOCKS);
        copy(ModTags.Blocks.TANZANITE_BLOCK, ModTags.Items.TANZANITE_BLOCK);
        copy(ModTags.Blocks.TOPAZ_BLOCK, ModTags.Items.TOPAZ_BLOCK);
        copy(ModTags.Blocks.SAPPHIRE_BLOCK, ModTags.Items.SAPPHIRE_BLOCK);
        copy(ModTags.Blocks.PINK_SAPPHIRE_BLOCK, ModTags.Items.PINK_SAPPHIRE_BLOCK);
        copy(ModTags.Blocks.RUBY_BLOCK, ModTags.Items.RUBY_BLOCK);

        /* Block tags copying end */
        getBuilder(Tags.Items.GEMS).add(
                ModTags.Items.TANZANITE,
                ModTags.Items.TOPAZ,
                ModTags.Items.SAPPHIRE,
                ModTags.Items.PINK_SAPPHIRE,
                ModTags.Items.RUBY
        );
        getBuilder(ModTags.Items.TANZANITE).add(ModItems.TANZANITE.get());
        getBuilder(ModTags.Items.TOPAZ).add(ModItems.TOPAZ.get());
        getBuilder(ModTags.Items.SAPPHIRE).add(ModItems.SAPPHIRE.get());
        getBuilder(ModTags.Items.PINK_SAPPHIRE).add(ModItems.PINK_SAPPHIRE.get());
        getBuilder(ModTags.Items.RUBY).add(ModItems.RUBY.get());
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
