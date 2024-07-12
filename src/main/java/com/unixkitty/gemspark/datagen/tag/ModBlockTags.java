package com.unixkitty.gemspark.datagen.tag;

import com.unixkitty.gemspark.Gemspark;
import com.unixkitty.gemspark.init.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GlassBlock;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraftforge.common.Tags;
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
        ModBlocks.BLOCKS.getEntries().forEach(blockRegistryObject ->
        {
            Block block = blockRegistryObject.get();

            if (block instanceof IronBarsBlock)
            {
                tag(Tags.Blocks.GLASS_PANES).add(block);
            }
            else if (block instanceof GlassBlock)
            {
                tag(Tags.Blocks.GLASS).add(block);
            }

            if (blockRegistryObject.getId().getPath().contains("_glass"))
            {
                tag(BlockTags.IMPERMEABLE).add(block);
            }
        });
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
