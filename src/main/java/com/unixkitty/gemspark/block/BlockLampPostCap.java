package com.unixkitty.gemspark.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItemUseContext;
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

import javax.annotation.Nonnull;
import java.util.stream.Stream;

public class BlockLampPostCap extends HorizontalBlock
{
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_NORTH = makeShape(
            Block.makeCuboidShape(5, -1, 21, 11, 5, 27),
            Block.makeCuboidShape(6, 0, 5, 10, 4, 21)
    );

    private static final VoxelShape SHAPE_EAST = makeShape(
            Block.makeCuboidShape(-11, -1, 5, -5, 5, 11),
            Block.makeCuboidShape(-5, 0, 6, 11, 4, 10)
    );

    private static final VoxelShape SHAPE_SOUTH = makeShape(
            Block.makeCuboidShape(5, -1, -11, 11, 5, -5),
            Block.makeCuboidShape(6, 0, -5, 10, 4, 11)
    );

    private static final VoxelShape SHAPE_WEST = makeShape(
            Block.makeCuboidShape(21, -1, 5, 27, 5, 11),
            Block.makeCuboidShape(5, 0, 6, 21, 4, 10)
    );

    public BlockLampPostCap(Properties properties)
    {
        super(properties);

        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
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

    public BlockState getStateForPlacement(BlockItemUseContext context)
    {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
    {
        builder.add(FACING);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state)
    {
        return BlockRenderType.MODEL;
    }

    @Override
    public boolean canEntitySpawn(BlockState state, IBlockReader worldIn, BlockPos pos, EntityType<?> type)
    {
        return false;
    }

    private VoxelShape getShapeFromFace(final BlockState state)
    {
        switch (state.get(FACING))
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
        return Stream.of(shapes).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();
    }
}
