package com.unixkitty.gemspark.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.stream.Stream;

public class BlockLampPostCap extends HorizontalDirectionalBlock
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

    @Nonnull
    @Override
    public VoxelShape getShape(final BlockState state, final BlockGetter worldIn, final BlockPos pos, final CollisionContext context)
    {
        return this.getShapeFromFace(state);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context)
    {
        return this.getShapeFromFace(state);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context)
    {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public void setPlacedBy(Level world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack)
    {
        super.setPlacedBy(world, pos, state, placer, stack);

        if (!world.isClientSide && (placer != null && !placer.isShiftKeyDown()))
        {
            BlockPos offsetPos = pos.relative(state.getValue(FACING), 1);

            if (world.getBlockState(offsetPos).getBlock().equals(Blocks.AIR))
            {
                world.removeBlock(pos, false);
                world.setBlock(offsetPos, state, 3);
                state.updateNeighbourShapes(world, pos, 3); //Update old position
            }
        }
    }


    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
    {
        builder.add(FACING);
    }

    @Override
    public RenderShape getRenderShape(BlockState state)
    {
        return RenderShape.MODEL;
    }

    private VoxelShape getShapeFromFace(final BlockState state)
    {
        return switch (state.getValue(FACING))
        {
            case EAST -> SHAPE_EAST;
            case SOUTH -> SHAPE_SOUTH;
            case WEST -> SHAPE_WEST;
            default -> SHAPE_NORTH;
        };
    }

    private static VoxelShape makeShape(@Nonnull VoxelShape... shapes)
    {
        return Stream.of(shapes).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    }
}
