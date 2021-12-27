package com.unixkitty.gemspark.block;

import com.unixkitty.gemspark.Gemspark;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;

import javax.annotation.Nullable;
import java.util.Random;

//Copy of vanilla RedstoneLampBlock, but with inverted logic
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RedstoneLampBlock;
import net.minecraft.world.level.block.RedstoneTorchBlock;
import net.minecraft.world.level.block.state.BlockState;

public class InvertedRedstoneLampBlock extends RedstoneLampBlock
{
    public static final BooleanProperty LIT = RedstoneTorchBlock.LIT;

    public InvertedRedstoneLampBlock()
    {
        super(Block.Properties.copy(Blocks.REDSTONE_LAMP));
        this.registerDefaultState(this.defaultBlockState().setValue(LIT, true));
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context)
    {
        return this.defaultBlockState().setValue(LIT, !context.getLevel().hasNeighborSignal(context.getClickedPos()));
    }

    @Override
    public void neighborChanged(BlockState state, Level worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving)
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
    public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult p_225533_6_)
    {
        if (!worldIn.isClientSide)
        {
            Gemspark.log().debug("Inverted Lamp info: [" + state + "], [" + state.getLightEmission() + "], [" + state.getValue(LIT) + "]");
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public void tick(BlockState state, ServerLevel worldIn, BlockPos pos, Random rand)
    {
        if (state.getValue(LIT) && worldIn.hasNeighborSignal(pos))
        {
            worldIn.setBlock(pos, state.cycle(LIT), 2);
        }

    }
}
