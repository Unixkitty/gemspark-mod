package com.unixkitty.gemspark.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class ModBlockEntity extends BlockEntity
{
    public ModBlockEntity(BlockEntityType<?> tileEntityTypeIn, BlockPos blockPos, BlockState blockState)
    {
        super(tileEntityTypeIn, blockPos, blockState);
    }

    /**
     * Read saved data from disk into the tile.
     */
    @Override
    public void load(CompoundTag compound)
    {
        super.load(compound);
        readPacketNBT(compound);
    }

    /**
     * Write data from the tile into a compound tag for saving to disk.
     */
    @Nonnull
    @Override
    public CompoundTag save(final CompoundTag compound)
    {
        CompoundTag result = super.save(compound);
        writePacketNBT(result);
        return result;
    }

    /**
     * Get an NBT compound to sync to the client with SPacketChunkData, used for initial loading of the
     * chunk or when many blocks change at once.
     * This compound comes back to you client-side in {@link #handleUpdateTag}
     * The default implementation ({@link BlockEntity#handleUpdateTag}) calls #writeInternal)
     * which doesn't save any of our extra data, so we override it to call {@link #write} instead
     */
    @Nonnull
    public CompoundTag getUpdateTag()
    {
        return this.save(new CompoundTag());
    }

    public abstract void readPacketNBT(CompoundTag compound);

    public abstract void writePacketNBT(CompoundTag compound);

    @Nullable
    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket()
    {
        CompoundTag compound = new CompoundTag();
        writePacketNBT(compound);
        return new ClientboundBlockEntityDataPacket(worldPosition, -999, compound);
    }

    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket packet)
    {
        super.onDataPacket(net, packet);
        readPacketNBT(packet.getTag());
    }
}
