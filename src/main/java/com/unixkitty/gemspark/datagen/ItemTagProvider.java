package com.unixkitty.gemspark.datagen;

import com.unixkitty.gemspark.Gemspark;
import com.unixkitty.gemspark.init.ModItems;
import com.unixkitty.gemspark.item.Gem;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class ItemTagProvider extends ItemTagsProvider
{
    private Set<ResourceLocation> filter = null;

    public ItemTagProvider(DataGenerator generatorIn, BlockTagProvider blockTagProvider)
    {
        super(generatorIn, blockTagProvider);
    }

    @Override
    protected void registerTags()
    {
        super.registerTags();

        filter = new HashSet<>(this.tagToBuilder.keySet());

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
        getOrCreateBuilder(Tags.Items.GEMS).addTags(
                Gem.TANZANITE.getItemTag(),
                Gem.TOPAZ.getItemTag(),
                Gem.SAPPHIRE.getItemTag(),
                Gem.PINK_SAPPHIRE.getItemTag(),
                Gem.RUBY.getItemTag()
        );
        getOrCreateBuilder(Gem.TANZANITE.getItemTag()).add(ModItems.TANZANITE.get());
        getOrCreateBuilder(Gem.TOPAZ.getItemTag()).add(ModItems.TOPAZ.get());
        getOrCreateBuilder(Gem.SAPPHIRE.getItemTag()).add(ModItems.SAPPHIRE.get());
        getOrCreateBuilder(Gem.PINK_SAPPHIRE.getItemTag()).add(ModItems.PINK_SAPPHIRE.get());
        getOrCreateBuilder(Gem.RUBY.getItemTag()).add(ModItems.RUBY.get());
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
