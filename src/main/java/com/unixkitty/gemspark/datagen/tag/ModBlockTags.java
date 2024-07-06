package com.unixkitty.gemspark.datagen.tag;

import com.unixkitty.gemspark.Gemspark;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModBlockTags extends BlockTagsProvider
{
    public ModBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper)
    {
        super(output, lookupProvider, Gemspark.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider)
    {

    }

    @SafeVarargs
    private void pickaxe(Block block, TagKey<Block>... needsToolTag)
    {
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block);

        if (needsToolTag != null && needsToolTag.length > 0)
        {
            tag(needsToolTag[0]).add(block);
        }
    }
}
