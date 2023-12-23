package com.unixkitty.gemspark.block;

import com.unixkitty.gemspark.init.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nonnull;

public class BlockWoodGolem extends HorizontalDirectionalBlock
{
    public static final EnumProperty<Pose> POSE = EnumProperty.create("pose", Pose.class);

    private static final VoxelShape SHAPE = Block.box(4, 0, 4, 12, 16, 12);

    public BlockWoodGolem(Properties builder)
    {
        super(builder);

        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(POSE, Pose.STANDING));
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit)
    {
        if (!world.isClientSide)
        {
            if (player instanceof ServerPlayer && player.isShiftKeyDown() && player.getItemInHand(hand).isEmpty())
            {
                if (player.getInventory().add(new ItemStack(ModBlocks.WOOD_GOLEM_RELIC.get())))
                {
                    world.removeBlock(pos, false);
                }
            }
        }

        return InteractionResult.SUCCESS;
    }

    @Nonnull
    @Override
    public VoxelShape getShape(final BlockState state, final BlockGetter worldIn, final BlockPos pos, final CollisionContext context)
    {
        return SHAPE;
    }

    @Override
    public RenderShape getRenderShape(BlockState state)
    {
        return RenderShape.MODEL;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context)
    {
        return SHAPE;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context)
    {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(POSE, Pose.STANDING);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
    {
        builder.add(FACING, POSE);
    }

    public enum Pose implements StringRepresentable
    {
        STANDING,
        SLUMPED,
        SITTING_SLUMPED;

        public Pose cycle()
        {
            return switch (this)
            {
                case STANDING -> SLUMPED;
                case SLUMPED -> SITTING_SLUMPED;
                case SITTING_SLUMPED -> STANDING;
            };
        }

        @Override
        public String getSerializedName()
        {
            return this.toString().toLowerCase();
        }
    }
}
