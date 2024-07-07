package com.unixkitty.gemspark.datagen.model;

import com.unixkitty.gemspark.Gemspark;
import com.unixkitty.gemspark.init.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStates extends BlockStateProvider
{
    public ModBlockStates(PackOutput output, ExistingFileHelper existingFileHelper)
    {
        super(output, Gemspark.MODID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels()
    {
        ModBlocks.BLOCKS.getEntries().forEach(blockRegistryObject ->
        {
            String path = blockRegistryObject.getId().getPath();

            if (
                    !path.endsWith("_glowing_glass")
                            && !path.endsWith("_pedestal")
                            && !path.startsWith("colored_lamp")
                            && !path.startsWith("colored_inverted")
                            && !path.startsWith("lamp_post_cap")
                            && !path.endsWith("brazier")
                            && blockRegistryObject != ModBlocks.WOOD_GOLEM_RELIC
            )
            {
                Block block = blockRegistryObject.get();
                String name = block.asItem().toString().toLowerCase();

                if (name.contains("_ctm"))
                {
                    name = name.replace("_ctm", "");

                    this.simpleBlock(block, models().cubeAll(name, modLoc("block/" + name)));
                }
                else if (block instanceof IronBarsBlock ironBarsBlock)
                {
                    if (name.contains("glowing"))
                    {
                        name = name.replace("_glowing", "");
                    }

                    paneBlockWithRenderType(ironBarsBlock, modLoc("block/" + name.replace("_pane", "")), modLoc("block/" + name + "_top"), "cutout");
                }
                else
                {
                    this.simpleBlock(block);
                }
            }
        });
    }
}
