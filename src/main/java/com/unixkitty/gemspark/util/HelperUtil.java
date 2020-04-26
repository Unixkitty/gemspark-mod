package com.unixkitty.gemspark.util;

import com.unixkitty.gemspark.Gemspark;
import com.unixkitty.gemspark.init.ModItems;
import com.unixkitty.gemspark.itemgroup.ModItemGroups;
import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tags.Tag;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Nullable;
import java.util.List;

import static net.minecraftforge.common.ToolType.*;

public final class HelperUtil
{
    public static RegistryObject<Item> registerGemItem(Gem gem)
    {
        return ModItems.ITEMS.register(gem.toString(), () -> new Item(itemProperties(gem)));
    }

    public static RegistryObject<Item> registerAxeItem(Gem gem)
    {
        return ModItems.ITEMS.register(gem + "_" + AXE.getName(), () -> new AxeItem(gem, 5.0f, -3.1F, itemProperties(gem)));
    }

    public static RegistryObject<Item> registerSwordItem(Gem gem)
    {
        return ModItems.ITEMS.register(gem + "_sword", () ->
                new SwordItem(gem, 3, -2.4F, itemProperties(gem)));
    }

    public static RegistryObject<Item> registerShovelItem(Gem gem)
    {
        return ModItems.ITEMS.register(gem + "_" + SHOVEL.getName(), () ->
                new ShovelItem(gem, 1.5f, -3.0F, itemProperties(gem))
        );
    }

    public static RegistryObject<Item> registerPickaxeItem(Gem gem)
    {
        return ModItems.ITEMS.register(gem + "_" + PICKAXE.getName(), () ->
                new PickaxeItem(gem, 1, -2.8F, itemProperties(gem))
        );
    }

    public static RegistryObject<Item> registerHoeItem(Gem gem)
    {
        return ModItems.ITEMS.register(gem + "_hoe", () ->
                new HoeItem(gem, 0.0f, itemProperties(gem))
        );
    }

    public static RegistryObject<Item> registerArmorItem(Gem gem, EquipmentSlotType slot)
    {
        return ModItems.ITEMS.register(armorMaterialString(gem.toString(), slot), () ->
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

            //Non-block rightClick
            @Override
            public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn)
            {
                if (!worldIn.isRemote)
                {
                    Gemspark.log().debug("NBT stick says hi!");
                }

                return ActionResult.resultPass(playerIn.getHeldItem(handIn));
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

    /* Registration methods end */

    public static ResourceLocation prefixResource(String path)
    {
        return new ResourceLocation(Gemspark.MODID, path);
    }

    public static boolean isResource(@Nullable ResourceLocation resourceLocation, String resource, boolean exact)
    {
        return resourceLocation != null && (exact ? resourceLocation.getPath().matches(resource) : resourceLocation.getPath().startsWith(resource));
    }

    public static IItemProvider gemItemOrAlternative(Block block)
    {
        for (Gem gem : Gem.values())
        {
            if (isResource(block.getRegistryName(), gem.toString(), false))
            {
                return gem.getItem();
            }
        }

        return block;
    }

    //TODO clean up these methods if possible
    public static IItemProvider coloredLampFromDye(DyeColor color, boolean inverted)
    {
        String lampString = (inverted ? "colored_inverted_lamp_" : "colored_lamp_") + color.toString();

        return ForgeRegistries.BLOCKS.getValue(prefixResource(lampString));
    }

    public static IItemProvider itemFromTag(Tag<Item> ingredient)
    {
        return ForgeRegistries.ITEMS.getValue(prefixResource(materialString(ingredient)));
    }

    public static Item itemFromMaterialTag(Tag<Item> material, String type)
    {
        return ForgeRegistries.ITEMS.getValue(HelperUtil.materialResource(material, type));
    }

    public static Item armorItemFromMaterialResource(Tag<Item> material, EquipmentSlotType slot)
    {
        return ForgeRegistries.ITEMS.getValue(armorResource(material, slot));
    }

    public static ResourceLocation materialResource(Tag<Item> material, String type)
    {
        return prefixResource(materialString(material) + "_" + type);
    }

    public static ResourceLocation armorResource(Tag<Item> material, EquipmentSlotType slot)
    {
        return prefixResource(armorMaterialString(material, slot));
    }

    public static String armorMaterialString(String material, EquipmentSlotType slot)
    {
        return material + "_" + armorSlotString(slot);
    }

    public static String armorMaterialString(Tag<Item> material, EquipmentSlotType slot)
    {
        return materialString(material) + "_" + armorSlotString(slot);
    }

    private static String materialString(Tag<Item> ingredient)
    {
        String material = ingredient.getId().getPath();

        if (material.contains("/"))
        {
            material = StringUtils.reverse(StringUtils.reverse(material).split("/")[0]);
        }

        return material;
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

    private static Item.Properties itemProperties(Gem gem)
    {
        return new Item.Properties().rarity(gem.getRarity()).group(ModItemGroups.PRIMARY);
    }
}
