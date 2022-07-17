package com.unixkitty.gemspark.item;

import com.unixkitty.gemspark.itemgroup.ModItemGroups;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
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
            context.getPlayer().sendMessage(new TextComponent("Block: " + context.getLevel().getBlockState(context.getClickedPos())), context.getPlayer().getUUID());

            BlockEntity tileEntity = context.getLevel().getBlockEntity(context.getClickedPos());

            if (tileEntity != null)
            {
                CompoundTag compound = tileEntity.saveWithFullMetadata();

                context.getPlayer().sendMessage(new TranslatableComponent("commands.data.block.query", tileEntity.getBlockPos().getX(), tileEntity.getBlockPos().getY(), tileEntity.getBlockPos().getZ(), compound.getAsString()), context.getPlayer().getUUID());
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
