package com.unixkitty.gemspark.util;

import com.unixkitty.gemspark.Gemspark;
import com.unixkitty.gemspark.init.ModItems;
import com.unixkitty.gemspark.itemgroup.ModItemGroups;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.RegistryObject;

import javax.annotation.Nullable;
import java.util.List;

public final class HelperUtil
{
    public static RegistryObject<Item> registerGemItem(Gems gem)
    {
        return ModItems.ITEMS.register(gem.toString(), () -> new Item(itemProperties(gem)));
    }

    public static RegistryObject<Item> registerAxeItem(Gems gem)
    {
        return ModItems.ITEMS.register(gem + "_axe", () ->
                new AxeItem(gem, 5.0f, -3.1F, itemProperties(gem))
        );
    }

    public static RegistryObject<Item> registerSwordItem(Gems gem)
    {
        return ModItems.ITEMS.register(gem + "_sword", () ->
                new SwordItem(gem, 3, -2.4F, itemProperties(gem)));
    }

    public static RegistryObject<Item> registerShovelItem(Gems gem)
    {
        return ModItems.ITEMS.register(gem + "_shovel", () ->
                new ShovelItem(gem, 1.5f, -3.0F, itemProperties(gem))
        );
    }

    public static RegistryObject<Item> registerPickaxeItem(Gems gem)
    {
        return ModItems.ITEMS.register(gem + "_pickaxe", () ->
                new PickaxeItem(gem, 1, -2.8F, itemProperties(gem))
        );
    }

    public static RegistryObject<Item> registerArmorItem(Gems gem, EquipmentSlotType slot)
    {
        return ModItems.ITEMS.register(gem + "_" + armorSlotString(slot), () ->
                new ArmorItem(gem, slot, itemProperties(gem))
                {
                    @Override
                    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type)
                    {
                        return String.format("%s:textures/models/armor/%s_layer_%d%s.png", Gemspark.MODID, gem, (slot == EquipmentSlotType.LEGS ? 2 : 1), type == null ? "" : String.format("_%s", type));
                    }
                }
        );
    }

    public static RegistryObject<Item> registerDebugItem()
    {
        return ModItems.ITEMS.register("nbt_stick", () -> new Item(new Item.Properties().group(ModItemGroups.PRIMARY).rarity(Rarity.EPIC).maxStackSize(1))
        {
            @Override
            public ActionResultType onItemUse(ItemUseContext context)
            {
                if (!context.getWorld().isRemote && context.getPlayer() instanceof ServerPlayerEntity && context.getPlayer().canUseCommandBlock())
                {
                    context.getPlayer().sendMessage(new StringTextComponent("Block: " + context.getWorld().getBlockState(context.getPos())));

                    TileEntity tileEntity = context.getWorld().getTileEntity(context.getPos());

                    if (tileEntity != null)
                    {
                        CompoundNBT compound = new CompoundNBT();

                        tileEntity.write(compound);

                        context.getPlayer().sendMessage(new TranslationTextComponent("commands.data.block.query", tileEntity.getPos().getX(), tileEntity.getPos().getY(), tileEntity.getPos().getZ(), compound.toFormattedComponent()));
                    }
                }

                return ActionResultType.SUCCESS;
            }

            @Override
            public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
            {
                super.addInformation(stack, worldIn, tooltip, flagIn);

                tooltip.add((new TranslationTextComponent("text.nbt_stick.info").applyTextStyle(TextFormatting.DARK_GRAY)));
            }

            @Override
            public boolean hasEffect(ItemStack stack)
            {
                return true;
            }
        });
    }

    private static String armorSlotString(EquipmentSlotType slot)
    {
        switch (slot)
        {
            case FEET:
                return "boots";
            case HEAD:
                return "helmet";
            case LEGS:
                return "leggings";
            case CHEST:
                return "chestplate";
            default:
                return "";
        }
    }

    private static Item.Properties itemProperties(Gems gem)
    {
        return new Item.Properties().rarity(gem.getRarity()).group(ModItemGroups.PRIMARY);
    }
}
