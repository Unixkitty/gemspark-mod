package com.unixkitty.gemspark.item;

import com.unixkitty.gemspark.itemgroup.ModItemGroups;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.ChatType;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.OutgoingPlayerChatMessage;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.entity.BlockEntity;

public class DebugItem extends Item
{
    public DebugItem()
    {
        super(new Item.Properties().tab(ModItemGroups.PRIMARY).rarity(Rarity.EPIC).stacksTo(1));
    }

    @Override
    public InteractionResult useOn(UseOnContext context)
    {
        if (!context.getLevel().isClientSide && context.getPlayer() instanceof ServerPlayer && context.getPlayer().canUseGameMasterBlocks())
        {
            ((ServerPlayer) context.getPlayer()).sendChatMessage((OutgoingPlayerChatMessage) Component.literal("Block: " + context.getLevel().getBlockState(context.getClickedPos())), false, ChatType.bind(ChatType.CHAT, context.getPlayer()));
            BlockEntity tileEntity = context.getLevel().getBlockEntity(context.getClickedPos());

            if (tileEntity != null)
            {
                CompoundTag compound = tileEntity.saveWithFullMetadata();

                ((ServerPlayer) context.getPlayer()).sendChatMessage((OutgoingPlayerChatMessage) Component.translatable("commands.data.block.query", tileEntity.getBlockPos().getX(), tileEntity.getBlockPos().getY(), tileEntity.getBlockPos().getZ(), compound.getAsString()), false, ChatType.bind(ChatType.CHAT, context.getPlayer()));
            }
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public boolean isFoil(ItemStack stack)
    {
        return true;
    }
}
