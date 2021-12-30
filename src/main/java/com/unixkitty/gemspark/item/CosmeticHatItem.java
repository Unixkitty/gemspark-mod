package com.unixkitty.gemspark.item;

import com.unixkitty.gemspark.compat.CuriosCompat;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

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
    public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn)
    {
        ItemStack heldStack = playerIn.getItemInHand(handIn);
        ItemStack equippedStack = playerIn.getItemBySlot(getEquipmentSlot(heldStack));

        if (equippedStack.isEmpty())
        {
            playerIn.setItemSlot(getEquipmentSlot(heldStack), heldStack.copy());
            heldStack.setCount(0);
            return ActionResult.sidedSuccess(heldStack, worldIn.isClientSide());
        }
        else
        {
            return ActionResult.fail(heldStack);
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);

        tooltip.add((new TranslationTextComponent("text.gemspark.cosmetic.info").withStyle(TextFormatting.GRAY)));
    }

    @Nullable
    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundNBT nbt)
    {
        return CuriosCompat.initCap(stack);
    }
}
