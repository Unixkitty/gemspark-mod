package com.unixkitty.gemspark.block;

import com.unixkitty.gemspark.Config;
import com.unixkitty.gemspark.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.RedstoneLampBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.fml.RegistryObject;

public enum ModBlockType
{
    BLOCK,
    LANTERN,
    ORE,
    PEDESTAL,
    REDSTONE_LAMP,
    INVERTED_REDSTONE_LAMP;

    public RegistryObject<Block> setup(String name)
    {
        switch (this)
        {
            case BLOCK:
                return ModBlocks.BLOCKS.register(name, () -> new Block(Block.Properties.from(Blocks.DIAMOND_BLOCK)));
            case LANTERN:
                return ModBlocks.BLOCKS.register(name, () -> new Block(Block.Properties.from(Blocks.GLOWSTONE)));
            case ORE:
                return ModBlocks.BLOCKS.register(name, () -> new Block(Block.Properties.from(Blocks.DIAMOND_ORE))
                {
                    @Override
                    public int getExpDrop(BlockState state, IWorldReader world, BlockPos pos, int fortune, int silktouch)
                    {
                        return silktouch == 0 ? MathHelper.nextInt(RANDOM, 3, 7) : 0;
                    }
                });
            case PEDESTAL:
                return ModBlocks.BLOCKS.register(name, () -> new BlockPedestal(Block.Properties.from(Blocks.QUARTZ_BLOCK).notSolid()));
            case REDSTONE_LAMP:
                return !Config.registerColoredLamps.get() ? null : ModBlocks.BLOCKS.register(name, () -> new RedstoneLampBlock(Block.Properties.from(Blocks.REDSTONE_LAMP)));
            case INVERTED_REDSTONE_LAMP:
                return !Config.registerColoredLamps.get() ? null : ModBlocks.BLOCKS.register(name, InvertedRedstoneLampBlock::new);
            default:
                return null;
        }
    }
}
