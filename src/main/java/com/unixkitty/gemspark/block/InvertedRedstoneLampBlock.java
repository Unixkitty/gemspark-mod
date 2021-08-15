package com.unixkitty.gemspark.block;

import com.unixkitty.gemspark.Gemspark;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.Random;

//Copy of vanilla RedstoneLampBlock, but with inverted logic
public class InvertedRedstoneLampBlock extends RedstoneLampBlock
{
    public static final BooleanProperty LIT = RedstoneTorchBlock.LIT;

    public InvertedRedstoneLampBlock()
    {
        super(Block.Properties.copy(Blocks.REDSTONE_LAMP));
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
    public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult p_225533_6_)
    {
        if (!worldIn.isClientSide)
        {
            Gemspark.log().debug("Inverted Lamp info: [" + state + "], [" + state.getLightEmission() + "], [" + state.getValue(LIT) + "]");
        }

        return ActionResultType.SUCCESS;
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
