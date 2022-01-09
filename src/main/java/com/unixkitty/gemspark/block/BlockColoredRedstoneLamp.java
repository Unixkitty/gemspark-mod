package com.unixkitty.gemspark.block;

import net.minecraft.block.*;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.DyeColor;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.Random;

public class BlockColoredRedstoneLamp
{
    private static AbstractBlock.Properties lampProperties(DyeColor color)
    {
        return AbstractBlock.Properties.copy(Blocks.REDSTONE_LAMP).lightLevel(
                (blockState) -> blockState.getValue(BlockStateProperties.LIT) ? color == DyeColor.WHITE ? 15 : color == DyeColor.BLACK ? 7 : 13 : 0
        );
    }

    public static class Normal extends RedstoneLampBlock
    {
        public Normal(DyeColor color)
        {
            super(lampProperties(color));
        }
    }

    public static class Inverted extends RedstoneLampBlock
    {
        public Inverted(DyeColor color)
        {
            super(lampProperties(color));
            this.registerDefaultState(this.defaultBlockState().setValue(LIT, true));
        }

        @Nullable
        public BlockState getStateForPlacement(BlockItemUseContext context)
        {
            return this.defaultBlockState().setValue(LIT, !context.getLevel().hasNeighborSignal(context.getClickedPos()));
        }

        @Override
        public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving)
        {
            if (!worldIn.isClientSide)
            {
                if ((!state.getValue(LIT) && worldIn.hasNeighborSignal(pos)) || (state.getValue(LIT) && !worldIn.hasNeighborSignal(pos)))
                {
                    worldIn.getBlockTicks().scheduleTick(pos, this, 4);
                }
                else
                {
                    //cycle -> cycle
                    worldIn.setBlockAndUpdate(pos, state.cycle(LIT));
                }

            }
        }

        @Override
        public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand)
        {
            if (state.getValue(LIT) && worldIn.hasNeighborSignal(pos))
            {
                worldIn.setBlock(pos, state.cycle(LIT), 2);
            }

        }
    }
}
