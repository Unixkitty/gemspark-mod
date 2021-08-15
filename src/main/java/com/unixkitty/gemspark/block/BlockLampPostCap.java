package com.unixkitty.gemspark.block;

import net.minecraft.block.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.stream.Stream;

import net.minecraft.block.AbstractBlock.Properties;

public class BlockLampPostCap extends HorizontalBlock
{
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_NORTH = makeShape(
            Block.box(5, -1, 21, 11, 5, 27),
            Block.box(6, 0, 5, 10, 4, 21)
    );

    private static final VoxelShape SHAPE_EAST = makeShape(
            Block.box(-11, -1, 5, -5, 5, 11),
            Block.box(-5, 0, 6, 11, 4, 10)
    );

    private static final VoxelShape SHAPE_SOUTH = makeShape(
            Block.box(5, -1, -11, 11, 5, -5),
            Block.box(6, 0, -5, 10, 4, 11)
    );

    private static final VoxelShape SHAPE_WEST = makeShape(
            Block.box(21, -1, 5, 27, 5, 11),
            Block.box(5, 0, 6, 21, 4, 10)
    );

    public BlockLampPostCap(Properties properties)
    {
        super(properties);

        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    /**
     * @deprecated Call via {@link BlockState#getShape(IBlockReader, BlockPos, ISelectionContext)}
     * Implementing/overriding is fine.
     */
    @Nonnull
    @Override
    public VoxelShape getShape(final BlockState state, final IBlockReader worldIn, final BlockPos pos, final ISelectionContext context)
    {
        return this.getShapeFromFace(state);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
    {
        return this.getShapeFromFace(state);
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context)
    {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public void setPlacedBy(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack)
    {
        super.setPlacedBy(world, pos, state, placer, stack);

        if (!world.isClientSide && (placer != null && !placer.isShiftKeyDown()))
        {
            BlockPos offsetPos = pos.relative(state.getValue(FACING), 1);

            if (world.getBlockState(offsetPos).getBlock().is(Blocks.AIR))
            {
                world.removeBlock(pos, false);
                world.setBlock(offsetPos, state, 3);
                state.updateNeighbourShapes(world, pos, 3); //Update old position
            }
        }
    }


    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder)
    {
        builder.add(FACING);
    }

    @Override
    public BlockRenderType getRenderShape(BlockState state)
    {
        return BlockRenderType.MODEL;
    }

    private VoxelShape getShapeFromFace(final BlockState state)
    {
        switch (state.getValue(FACING))
        {
            case EAST:
                return SHAPE_EAST;
            case SOUTH:
                return SHAPE_SOUTH;
            case WEST:
                return SHAPE_WEST;
            default:
                return SHAPE_NORTH;
        }
    }

    private static VoxelShape makeShape(@Nonnull VoxelShape... shapes)
    {
        return Stream.of(shapes).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();
    }
}
