package com.unixkitty.gemspark.tileentity;

import com.unixkitty.gemspark.container.ContainerPedestal;
import com.unixkitty.gemspark.init.ModBlocks;
import com.unixkitty.gemspark.init.ModTileEntityTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.util.Direction;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.server.ServerChunkProvider;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class TileEntityPedestal extends TileEntityMod implements INamedContainerProvider
{
    private static final String INVENTORY_TAG = "inventory";
    private static final String LAST_CHANGE_TIME_TAG = "lastChangeTime";
    private static final String SHOULD_ROTATE_TAG = "shouldRotate";
    private static final String ITEM_FACING_DIRECTION_TAG = "itemFacingDirection";

    protected final ItemStackHandler inventory = new ItemStackHandler(1)
    {
        @Override
        protected void onContentsChanged(int slot)
        {
            super.onContentsChanged(slot);

            TileEntityPedestal.this.syncForRender();

            TileEntityPedestal.this.markDirty();
        }
    };

    private final LazyOptional<ItemStackHandler> inventoryCapabilityExternal = LazyOptional.of(() -> this.inventory);

    public long lastChangeTime;
    public boolean shouldRotate;
    public float itemFacingDirection;

    public TileEntityPedestal()
    {
        super(ModTileEntityTypes.PEDESTAL.get());
    }

    @Override
    public ITextComponent getDisplayName()
    {
        return new TranslationTextComponent(ModBlocks.quartz_pedestal.get().getTranslationKey());
    }

    @Nullable
    @Override
    public Container createMenu(int p_createMenu_1_, PlayerInventory p_createMenu_2_, PlayerEntity p_createMenu_3_)
    {
        return new ContainerPedestal(p_createMenu_1_, p_createMenu_2_, this);
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull final Capability<T> cap, @Nullable final Direction side)
    {
        return cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY ? inventoryCapabilityExternal.cast() : super.getCapability(cap, side);
    }

    @Override
    public void writePacketNBT(CompoundNBT compound)
    {
        compound.put(INVENTORY_TAG, this.inventory.serializeNBT());
        compound.putLong(LAST_CHANGE_TIME_TAG, this.lastChangeTime);
        compound.putBoolean(SHOULD_ROTATE_TAG, this.shouldRotate);
        compound.putFloat(ITEM_FACING_DIRECTION_TAG, this.itemFacingDirection);
    }

    @Override
    public void readPacketNBT(CompoundNBT compound)
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
    public void remove()
    {
        super.remove();
        // We need to invalidate our capability references so that any cached references (by other mods) don't
        // continue to reference our capabilities and try to use them and/or prevent them from being garbage collected
        inventoryCapabilityExternal.invalidate();
    }

    public final IItemHandlerModifiable getItemHandler()
    {
        return inventory;
    }

    @Override
    public AxisAlignedBB getRenderBoundingBox()
    {
        return new AxisAlignedBB(getPos(), getPos().add(1, 2, 1));
    }

    //Thanks Vazkii
    public void syncForRender()
    {
        SUpdateTileEntityPacket packet = this.getUpdatePacket();
        BlockPos pos = this.getPos();

        lastChangeTime = world.getGameTime();

        if (packet != null && this.getWorld() instanceof ServerWorld)
        {
            ((ServerChunkProvider) this.getWorld().getChunkProvider()).chunkManager.getTrackingPlayers(new ChunkPos(pos), false).forEach(e -> e.connection.sendPacket(packet));
        }
    }
}
