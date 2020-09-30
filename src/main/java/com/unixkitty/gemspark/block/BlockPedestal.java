package com.unixkitty.gemspark.block;

import com.unixkitty.gemspark.init.ModTileEntityTypes;
import com.unixkitty.gemspark.tileentity.TileEntityPedestal;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.ContainerBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.items.IItemHandlerModifiable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class BlockPedestal extends ContainerBlock
{
    //private static final VoxelShape SHAPE = Block.makeCuboidShape(1, 0, 1, 15, 16, 15);
    private static final VoxelShape SHAPE = Stream.of(
            Block.makeCuboidShape(2, 0, 2, 14, 1, 14),
            Block.makeCuboidShape(3, 1, 3, 13, 14, 13),
            Block.makeCuboidShape(2, 14, 2, 14, 15, 14),
            Block.makeCuboidShape(1, 15, 1, 15, 16, 15)
    )
            .reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    public BlockPedestal(Properties properties)
    {
        super(properties);
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

    @Nullable
    @Override
    public TileEntity createNewTileEntity(IBlockReader worldIn)
    {
        return ModTileEntityTypes.PEDESTAL.get().create();
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
        super.addInformation(stack, worldIn, tooltip, flagIn);

        tooltip.add((new TranslationTextComponent("text.pedestal.info").mergeStyle(TextFormatting.DARK_GRAY)));
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult rayTraceResult)
    {
        if (!world.isRemote)
        {
            if (this.getContainer(state, world, pos) != null && player instanceof ServerPlayerEntity)
            {
                TileEntity tile = world.getTileEntity(pos);

                if (!(tile instanceof TileEntityPedestal)) return ActionResultType.FAIL;

                TileEntityPedestal tileEntity = (TileEntityPedestal) tile;

                IItemHandlerModifiable itemHandler = tileEntity.getItemHandler();
                ItemStack heldItem = player.getHeldItem(hand);

                if (!player.isSneaking())
                {
                    if (heldItem.isEmpty())
                    {
                        if (itemHandler.getStackInSlot(0).isEmpty())
                        {
                            return ActionResultType.FAIL;
                        }
                        else
                        {
                            player.setHeldItem(hand, itemHandler.extractItem(0, 64, false));
                        }
                    }
                    else if (heldItem.getItem() == Items.STICK)
                    {
                        //Toggle display render rotation using a vanilla stick
                        tileEntity.shouldRotate = !tileEntity.shouldRotate;
                        tileEntity.syncForRender();
                    }
                    else
                    {
                        switch (player.getHorizontalFacing().getOpposite())
                        {
                            case NORTH:
                                tileEntity.itemFacingDirection = 180;
                                break;
                            case WEST:
                                tileEntity.itemFacingDirection = 270;
                                break;
                            case SOUTH:
                                tileEntity.itemFacingDirection = 0;
                                break;
                            case EAST:
                                tileEntity.itemFacingDirection = 90;
                                break;
                        }

                        if (player.isCreative())
                        {
                            itemHandler.insertItem(0, heldItem.copy(), false);
                        }
                        else
                        {
                            player.setHeldItem(hand, itemHandler.insertItem(0, heldItem, false));
                        }
                    }

                    tileEntity.markDirty();
                }
                else
                {
                    NetworkHooks.openGui((ServerPlayerEntity) player, tileEntity, pos);
                }
            }
        }

        return ActionResultType.SUCCESS;
    }

    @Override
    public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving)
    {
        if (state.getBlock() != newState.getBlock())
        {
            ItemStack itemStack = ((TileEntityPedestal) Objects.requireNonNull(worldIn.getTileEntity(pos))).getItemHandler().getStackInSlot(0);
            if (!itemStack.isEmpty())
            {
                InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), itemStack);
            }
        }
        super.onReplaced(state, worldIn, pos, newState, isMoving);
    }
}
