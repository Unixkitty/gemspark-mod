package com.unixkitty.gemspark.block;

import com.unixkitty.gemspark.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class BlockWoodGolem extends HorizontalBlock
{
    public static final EnumProperty<Pose> POSE = EnumProperty.create("pose", Pose.class);

    private static final VoxelShape SHAPE = Block.makeCuboidShape(1, 0, 1, 14, 16, 14);

    public BlockWoodGolem(Properties builder)
    {
        super(builder);

        this.setDefaultState(this.stateContainer.getBaseState().with(HORIZONTAL_FACING, Direction.NORTH).with(POSE, Pose.STANDING));
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit)
    {
        if (!world.isRemote)
        {
            if (player instanceof ServerPlayerEntity && player.isSneaking() && player.getHeldItem(hand).isEmpty())
            {
                if (player.inventory.addItemStackToInventory(new ItemStack(ModBlocks.WOOD_GOLEM_RELIC.get())))
                {
                    world.removeBlock(pos, false);
                }
            }
        }

        return ActionResultType.SUCCESS;
    }

    /**
     * @deprecated Call via {@link BlockState#getShape(IBlockReader, BlockPos, ISelectionContext)}
     * Implementing/overriding is fine.
     */
    @Nonnull
    @Override
    public VoxelShape getShape(final BlockState state, final IBlockReader worldIn, final BlockPos pos, final ISelectionContext context)
    {
        return SHAPE;
    }

    @Override
    public BlockRenderType getRenderType(BlockState state)
    {
        return BlockRenderType.MODEL;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
    {
        return SHAPE;
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context)
    {
        return this.getDefaultState().with(HORIZONTAL_FACING, context.getPlacementHorizontalFacing().getOpposite()).with(POSE, Pose.STANDING);
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
    {
        builder.add(HORIZONTAL_FACING, POSE);
    }

    public enum Pose implements IStringSerializable
    {
        STANDING,
        SLUMPED,
        SITTING_SLUMPED;

        public Pose cycle()
        {
            switch (this)
            {
                case STANDING:
                    return SLUMPED;
                case SLUMPED:
                    return SITTING_SLUMPED;
                case SITTING_SLUMPED:
                    return STANDING;
                default:
                    throw new IllegalStateException("Illegal state cycling operation for " + this);
            }
        }

        @Override
        public String getString()
        {
            return this.toString().toLowerCase();
        }
    }
}
