package com.unixkitty.gemspark.item;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

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
    public EquipmentSlotType getEquipmentSlot(ItemStack stack)
    {
        return EquipmentSlotType.HEAD;
    }

    @Override
    public boolean canEquip(ItemStack stack, EquipmentSlotType armorType, Entity entity)
    {
        return armorType == this.getEquipmentSlot(stack);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn)
    {
        ItemStack heldStack = playerIn.getHeldItem(handIn);
        ItemStack equippedStack = playerIn.getItemStackFromSlot(getEquipmentSlot(heldStack));

        if (equippedStack.isEmpty())
        {
            playerIn.setItemStackToSlot(getEquipmentSlot(heldStack), heldStack.copy());
            heldStack.setCount(0);
            return ActionResult.func_233538_a_(heldStack, worldIn.isRemote());
        }
        else
        {
            return ActionResult.resultFail(heldStack);
        }
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
        super.addInformation(stack, worldIn, tooltip, flagIn);

        tooltip.add((new TranslationTextComponent("text.gemspark.cosmetic.info").mergeStyle(TextFormatting.DARK_GRAY)));
    }
}
