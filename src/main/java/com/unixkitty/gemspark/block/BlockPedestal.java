package com.unixkitty.gemspark.block;

import com.unixkitty.gemspark.blockentity.BlockEntityPedestal;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.items.IItemHandlerModifiable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class BlockPedestal extends BaseEntityBlock
{
    //private static final VoxelShape SHAPE = Block.makeCuboidShape(1, 0, 1, 15, 16, 15);
    private static final VoxelShape SHAPE = Stream.of(
                    Block.box(2, 0, 2, 14, 1, 14),
                    Block.box(3, 1, 3, 13, 14, 13),
                    Block.box(2, 14, 2, 14, 15, 14),
                    Block.box(1, 15, 1, 15, 16, 15)
            )
            .reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public BlockPedestal(Properties properties)
    {
        super(properties);
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

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState state)
    {
        return new BlockEntityPedestal(blockPos, state);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack stack, @Nullable BlockGetter worldIn, List<Component> tooltip, TooltipFlag flagIn)
    {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);

        tooltip.add((new TranslatableComponent("text.pedestal.info").withStyle(ChatFormatting.DARK_GRAY)));
        tooltip.add((new TranslatableComponent("text.pedestal.info2").withStyle(ChatFormatting.DARK_GRAY)));
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult rayTraceResult)
    {
        if (!world.isClientSide)
        {
            if (this.getMenuProvider(state, world, pos) != null && player instanceof ServerPlayer)
            {
                BlockEntity tile = world.getBlockEntity(pos);

                if (!(tile instanceof BlockEntityPedestal blockEntity)) return InteractionResult.FAIL;

                IItemHandlerModifiable itemHandler = blockEntity.getItemHandler();
                ItemStack heldItem = player.getItemInHand(hand);

                if (!player.isShiftKeyDown())
                {
                    if (heldItem.isEmpty())
                    {
                        if (itemHandler.getStackInSlot(0).isEmpty())
                        {
                            NetworkHooks.openGui((ServerPlayer) player, blockEntity, pos);
                        }
                        else
                        {
                            player.setItemInHand(hand, itemHandler.extractItem(0, 64, false));
                        }
                    }
                    else if (heldItem.getItem() == Items.STICK)
                    {
                        //Toggle display render rotation using a vanilla stick
                        blockEntity.shouldRotate = !blockEntity.shouldRotate;
                        blockEntity.syncForRender();
                    }
                    else
                    {
                        switch (player.getDirection().getOpposite())
                        {
                            case NORTH -> blockEntity.itemFacingDirection = 180;
                            case WEST -> blockEntity.itemFacingDirection = 270;
                            case SOUTH -> blockEntity.itemFacingDirection = 0;
                            case EAST -> blockEntity.itemFacingDirection = 90;
                        }

                        if (player.isCreative())
                        {
                            itemHandler.insertItem(0, heldItem.copy(), false);
                        }
                        else
                        {
                            player.setItemInHand(hand, itemHandler.insertItem(0, heldItem, false));
                        }
                    }

                    blockEntity.setChanged();
                }
                else
                {
                    NetworkHooks.openGui((ServerPlayer) player, blockEntity, pos);
                }
            }
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public void onRemove(BlockState state, Level worldIn, BlockPos pos, BlockState newState, boolean isMoving)
    {
        if (state.getBlock() != newState.getBlock())
        {
            ItemStack itemStack = ((BlockEntityPedestal) Objects.requireNonNull(worldIn.getBlockEntity(pos))).getItemHandler().getStackInSlot(0);
            if (!itemStack.isEmpty())
            {
                Containers.dropItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), itemStack);
            }
        }
        super.onRemove(state, worldIn, pos, newState, isMoving);
    }
}
