package com.unixkitty.gemspark.item;

import com.unixkitty.gemspark.itemgroup.ModItemGroups;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Rarity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class DebugItem extends Item
{
    public DebugItem()
    {
        super(new Item.Properties().tab(ModItemGroups.PRIMARY).rarity(Rarity.EPIC).stacksTo(1));
    }

    @Override
    public ActionResultType useOn(ItemUseContext context)
    {
        if (!context.getLevel().isClientSide && context.getPlayer() instanceof ServerPlayerEntity && context.getPlayer().canUseGameMasterBlocks())
        {
            context.getPlayer().sendMessage(new StringTextComponent("Block: " + context.getLevel().getBlockState(context.getClickedPos())), context.getPlayer().getUUID());

            TileEntity tileEntity = context.getLevel().getBlockEntity(context.getClickedPos());

            if (tileEntity != null)
            {
                CompoundNBT compound = new CompoundNBT();

                tileEntity.save(compound);

                context.getPlayer().sendMessage(new TranslationTextComponent("commands.data.block.query", tileEntity.getBlockPos().getX(), tileEntity.getBlockPos().getY(), tileEntity.getBlockPos().getZ(), compound.getPrettyDisplay()), context.getPlayer().getUUID());
            }
        }

        return ActionResultType.SUCCESS;
    }

    @Override
    public boolean isFoil(ItemStack stack)
    {
        return true;
    }
}
