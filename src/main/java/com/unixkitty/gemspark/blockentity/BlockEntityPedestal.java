package com.unixkitty.gemspark.blockentity;

import com.unixkitty.gemspark.container.ContainerPedestal;
import com.unixkitty.gemspark.init.ModBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerChunkCache;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.Nameable;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class BlockEntityPedestal extends ModBlockEntity implements MenuProvider, Nameable
{
    private static final String INVENTORY_TAG = "inventory";
    private static final String LAST_CHANGE_TIME_TAG = "lastChangeTime";
    private static final String SHOULD_ROTATE_TAG = "shouldRotate";
    private static final String ITEM_FACING_DIRECTION_TAG = "itemFacingDirection";

    private final Component name = Component.translatable("text.pedestal.title");

    protected final ItemStackHandler inventory = new ItemStackHandler(1)
    {
        @Override
        protected void onContentsChanged(int slot)
        {
            super.onContentsChanged(slot);

            BlockEntityPedestal.this.syncForRender();

            BlockEntityPedestal.this.setChanged();
        }
    };

    private final LazyOptional<ItemStackHandler> inventoryCapabilityExternal = LazyOptional.of(() -> this.inventory);

    public long lastChangeTime;
    public boolean shouldRotate;
    public float itemFacingDirection;

    public BlockEntityPedestal(BlockPos blockPos, BlockState blockState)
    {
        super(ModBlockEntityTypes.PEDESTAL.get(), blockPos, blockState);
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int p_createMenu_1_, Inventory p_createMenu_2_, Player p_39956_)
    {
        return this.createMenu(p_createMenu_1_, p_createMenu_2_);
    }

    @Nullable
    public AbstractContainerMenu createMenu(int windowId, Inventory inventory)
    {
        return new ContainerPedestal(windowId, inventory, inventory.player.getCommandSenderWorld(), this.getBlockPos());
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull final Capability<T> cap, @Nullable final Direction side)
    {
        return cap == ForgeCapabilities.ITEM_HANDLER ? inventoryCapabilityExternal.cast() : super.getCapability(cap, side);
    }

    @Override
    public void writePacketNBT(CompoundTag compound)
    {
        compound.put(INVENTORY_TAG, this.inventory.serializeNBT());
        compound.putLong(LAST_CHANGE_TIME_TAG, this.lastChangeTime);
        compound.putBoolean(SHOULD_ROTATE_TAG, this.shouldRotate);
        compound.putFloat(ITEM_FACING_DIRECTION_TAG, this.itemFacingDirection);
    }

    @Override
    public void readPacketNBT(CompoundTag compound)
    {
        this.inventory.deserializeNBT(compound.getCompound(INVENTORY_TAG));
        this.lastChangeTime = compound.getLong(LAST_CHANGE_TIME_TAG);
        this.shouldRotate = compound.getBoolean(SHOULD_ROTATE_TAG);
        this.itemFacingDirection = compound.getFloat(ITEM_FACING_DIRECTION_TAG);
    }

    /**
     * Invalidates our tile entity
     */
    @Override
    public void setRemoved()
    {
        super.setRemoved();
        // We need to invalidate our capability references so that any cached references (by other mods) don't
        // continue to reference our capabilities and try to use them and/or prevent them from being garbage collected
        inventoryCapabilityExternal.invalidate();
    }

    public final IItemHandlerModifiable getItemHandler()
    {
        return inventory;
    }

    @Override
    public AABB getRenderBoundingBox()
    {
        return new AABB(getBlockPos(), getBlockPos().offset(1, 2, 1));
    }

    //Thanks Vazkii
    public void syncForRender()
    {
        var packet = this.getUpdatePacket();
        BlockPos pos = this.getBlockPos();

        Level world = this.getLevel();

        //Can happen on first join
        if (world == null)
        {
            this.lastChangeTime = 0;
        }
        else
        {
            this.lastChangeTime = world.getGameTime();
        }

        if (packet != null && world instanceof ServerLevel)
        {
            ((ServerChunkCache) this.getLevel().getChunkSource()).chunkMap.getPlayers(new ChunkPos(pos), false).forEach(e -> e.connection.send(packet));
        }
    }

    @Override
    public Component getName()
    {
        return this.name;
    }

    @Override
    public Component getDisplayName()
    {
        return this.getName();
    }
}
