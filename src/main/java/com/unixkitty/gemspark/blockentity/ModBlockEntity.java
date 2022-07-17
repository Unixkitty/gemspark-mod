package com.unixkitty.gemspark.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;

public abstract class ModBlockEntity extends BlockEntity
{
    public ModBlockEntity(BlockEntityType<?> tileEntityTypeIn, BlockPos blockPos, BlockState blockState)
    {
        super(tileEntityTypeIn, blockPos, blockState);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag)
    {
        super.saveAdditional(pTag);
        writePacketNBT(pTag);
    }

    @Nonnull
    public CompoundTag getUpdateTag()
    {
        CompoundTag tag = new CompoundTag();

        writePacketNBT(tag);

        return tag;
    }

    @Override
    public void load(CompoundTag compound)
    {
        super.load(compound);
        readPacketNBT(compound);
    }

    public abstract void readPacketNBT(CompoundTag compound);

    public abstract void writePacketNBT(CompoundTag compound);

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket()
    {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket packet)
    {
        super.onDataPacket(net, packet);
        readPacketNBT(packet.getTag());
    }
}
