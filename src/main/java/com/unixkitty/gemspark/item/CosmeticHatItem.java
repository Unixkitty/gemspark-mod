package com.unixkitty.gemspark.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class CosmeticHatItem extends Item
{
    public CosmeticHatItem(Properties properties)
    {
        super(properties);
    }

    @Nullable
    @Override
    public EquipmentSlot getEquipmentSlot(ItemStack stack)
    {
        return EquipmentSlot.HEAD;
    }

    @Override
    public boolean canEquip(ItemStack stack, EquipmentSlot armorType, Entity entity)
    {
        return armorType == this.getEquipmentSlot(stack);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn)
    {
        ItemStack heldStack = playerIn.getItemInHand(handIn);
        ItemStack equippedStack = playerIn.getItemBySlot(getEquipmentSlot(heldStack));

        if (equippedStack.isEmpty())
        {
            playerIn.setItemSlot(getEquipmentSlot(heldStack), heldStack.copy());
            heldStack.setCount(0);
            return InteractionResultHolder.sidedSuccess(heldStack, worldIn.isClientSide());
        }
        else
        {
            return InteractionResultHolder.fail(heldStack);
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn)
    {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);

        tooltip.add((new TranslatableComponent("text.gemspark.cosmetic.info").withStyle(ChatFormatting.DARK_GRAY)));
    }
}
