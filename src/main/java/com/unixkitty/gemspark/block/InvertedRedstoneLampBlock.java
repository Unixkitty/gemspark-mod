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
        super(Block.Properties.from(Blocks.REDSTONE_LAMP));
        this.setDefaultState(this.getDefaultState().with(LIT, true));
    }

    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context)
    {
        return this.getDefaultState().with(LIT, !context.getWorld().isBlockPowered(context.getPos()));
    }

    @Override
    public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving)
    {
        if (!worldIn.isRemote)
        {
            if ((!state.get(LIT) && worldIn.isBlockPowered(pos)) || (state.get(LIT) && !worldIn.isBlockPowered(pos)))
            {
                worldIn.getPendingBlockTicks().scheduleTick(pos, this, 4);
            }
            else
            {
                //func_235896_a_ -> cycle
                worldIn.setBlockState(pos, state.func_235896_a_(LIT));
            }

        }
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult p_225533_6_)
    {
        if (!worldIn.isRemote)
        {
            Gemspark.log().debug("Inverted Lamp info: [" + state + "], [" + state.getLightValue() + "], [" + state.get(LIT) + "]");
        }

        return ActionResultType.SUCCESS;
    }

    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand)
    {
        if (state.get(LIT) && worldIn.isBlockPowered(pos))
        {
            worldIn.setBlockState(pos, state.func_235896_a_(LIT), 2);
        }

    }
}
