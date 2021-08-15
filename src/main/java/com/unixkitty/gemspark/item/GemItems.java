package com.unixkitty.gemspark.item;

import com.unixkitty.gemspark.Gemspark;
import com.unixkitty.gemspark.init.ModItems;
import com.unixkitty.gemspark.itemgroup.ModItemGroups;
import com.unixkitty.gemspork.lib.HelperUtil;
import net.minecraft.block.Block;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;

import static net.minecraftforge.common.ToolType.*;

public class GemItems
{
    public static final int TIERS = 5;
    public static final float TIER_FLOOR_BUMP = 0.4f;

    public static final ItemTier TOOL_FLOOR_TIER = ItemTier.IRON;
    public static final ItemTier TOOL_CEIL_TIER = ItemTier.DIAMOND;

    public static final ArmorMaterial ARMOR_FLOOR_TIER = ArmorMaterial.IRON;
    public static final ArmorMaterial ARMOR_CEIL_TIER = ArmorMaterial.DIAMOND;

    public static RegistryObject<Item> registerGemItem(Gem gem)
    {
        return ModItems.ITEMS.register(gem.toString(), () -> new Item(itemProperties(gem)));
    }

    public static RegistryObject<Item> registerAxeItem(Gem gem)
    {
        return ModItems.ITEMS.register(gem + "_" + AXE.getName(), () -> new AxeItem(gem.getToolProperties(), 5.0f, -3.0F, itemProperties(gem)));
    }

    public static RegistryObject<Item> registerSwordItem(Gem gem)
    {
        return ModItems.ITEMS.register(gem + "_sword", () ->
                new SwordItem(gem.getToolProperties(), 3, -2.4F, itemProperties(gem)));
    }

    public static RegistryObject<Item> registerShovelItem(Gem gem)
    {
        return ModItems.ITEMS.register(gem + "_" + SHOVEL.getName(), () ->
                new ShovelItem(gem.getToolProperties(), 1.5f, -3.0F, itemProperties(gem))
        );
    }

    public static RegistryObject<Item> registerPickaxeItem(Gem gem)
    {
        return ModItems.ITEMS.register(gem + "_" + PICKAXE.getName(), () ->
                new PickaxeItem(gem.getToolProperties(), 1, -2.8F, itemProperties(gem))
        );
    }

    public static RegistryObject<Item> registerHoeItem(Gem gem)
    {
        return ModItems.ITEMS.register(gem + "_hoe", () ->
                new HoeItem(gem.getToolProperties(), /*The heck is this parameter?*/-3, 0.0f, itemProperties(gem))
        );
    }

    public static RegistryObject<Item> registerArmorItem(Gem gem, EquipmentSlotType slot)
    {
        return ModItems.ITEMS.register(HelperUtil.armorMaterialString(gem.toString(), slot), () ->
                new ModArmorItem(gem.toString(), gem.getArmorProperties(), slot, itemProperties(gem))
        );
    }

    public static IItemProvider gemItemOrAlternative(Block block)
    {
        for (Gem gem : Gem.values())
        {
            if (HelperUtil.isResource(block.getRegistryName(), gem.toString(), false))
            {
                switch (gem)
                {
                    case DIAMOND:
                        return Items.DIAMOND;
                    case EMERALD:
                        return Items.EMERALD;
                    default:
                        return HelperUtil.itemFromTag(Gemspark.MODID, gem.getItemTag());
                }
            }
        }

        return block;
    }

    public static IItemProvider coloredLampFromDye(DyeColor color, boolean inverted)
    {
        String lampString = (inverted ? "colored_inverted_lamp_" : "colored_lamp_") + color.toString();

        return ForgeRegistries.BLOCKS.getValue(HelperUtil.prefixResource(Gemspark.MODID, lampString));
    }

    private static Item.Properties itemProperties(Gem gem)
    {
        return new Item.Properties().rarity(gem.getRarity()).tab(ModItemGroups.PRIMARY);
    }

}
