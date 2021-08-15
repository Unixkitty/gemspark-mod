package com.unixkitty.gemspark.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraftforge.common.ToolType;

import net.minecraft.block.AbstractBlock.Properties;

public class BlockDirt extends Block
{
    public BlockDirt(Properties properties)
    {
        super(properties);
    }

    @Override
    public boolean isToolEffective(BlockState state, ToolType tool)
    {
        return tool.equals(ToolType.SHOVEL);
    }
}
