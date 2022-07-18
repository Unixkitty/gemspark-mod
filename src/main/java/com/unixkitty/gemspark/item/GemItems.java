package com.unixkitty.gemspark.item;

import com.unixkitty.gemspark.Gemspark;
import com.unixkitty.gemspark.init.ModItems;
import com.unixkitty.gemspark.itemgroup.ModItemGroups;
import com.unixkitty.gemspark.util.HelperUtil;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class GemItems
{
    public static final int TIERS = 5;
    public static final float TIER_FLOOR_BUMP = 0.4f;

    public static final Tiers TOOL_FLOOR_TIER = Tiers.IRON;
    public static final Tiers TOOL_CEIL_TIER = Tiers.DIAMOND;

    public static final ArmorMaterials ARMOR_FLOOR_TIER = ArmorMaterials.IRON;
    public static final ArmorMaterials ARMOR_CEIL_TIER = ArmorMaterials.DIAMOND;

    public static RegistryObject<Item> registerGemItem(Gem gem)
    {
        return ModItems.ITEMS.register(gem.toString(), () -> new Item(itemProperties(gem)));
    }

    public static RegistryObject<Item> registerAxeItem(Gem gem)
    {
        return ModItems.ITEMS.register(gem + "_axe", () -> new AxeItem(gem.getToolProperties(), 5.0f, -3.0F, itemProperties(gem)));
    }

    public static RegistryObject<Item> registerSwordItem(Gem gem)
    {
        return ModItems.ITEMS.register(gem + "_sword", () ->
                new SwordItem(gem.getToolProperties(), 3, -2.4F, itemProperties(gem)));
    }

    public static RegistryObject<Item> registerShovelItem(Gem gem)
    {
        return ModItems.ITEMS.register(gem + "_shovel", () ->
                new ShovelItem(gem.getToolProperties(), 1.5f, -3.0F, itemProperties(gem))
        );
    }

    public static RegistryObject<Item> registerPickaxeItem(Gem gem)
    {
        return ModItems.ITEMS.register(gem + "_pickaxe", () ->
                new PickaxeItem(gem.getToolProperties(), 1, -2.8F, itemProperties(gem))
        );
    }

    public static RegistryObject<Item> registerHoeItem(Gem gem)
    {
        return ModItems.ITEMS.register(gem + "_hoe", () ->
                new HoeItem(gem.getToolProperties(), -3, 0.0f, itemProperties(gem))
        );
    }

    public static RegistryObject<Item> registerArmorItem(Gem gem, EquipmentSlot slot)
    {
        return ModItems.ITEMS.register(HelperUtil.armorMaterialString(gem.toString(), slot), () ->
                new ModArmorItem(gem.toString(), gem.getArmorProperties(), slot, itemProperties(gem))
        );
    }

    public static ItemLike gemItemOrAlternative(Block block)
    {
//        ResourceLocation block.getRegistryName() = block.getRegistryName();

        for (Gem gem : Gem.values())
        {
            if (HelperUtil.isResource(block.getRegistryName().getPath().startsWith("deepslate") ? new ResourceLocation(block.getRegistryName().getNamespace(), block.getRegistryName().getPath().replaceFirst("deepslate_", "")) : block.getRegistryName(), gem.toString(), false))
            {
                return switch (gem)
                        {
                            case DIAMOND -> Items.DIAMOND;
                            case EMERALD -> Items.EMERALD;
                            default -> HelperUtil.itemFromTag(Gemspark.MODID, gem.getItemTag());
                        };
            }
        }

        return block;
    }

    public static ItemLike coloredLampFromDye(DyeColor color, boolean inverted)
    {
        String lampString = (inverted ? "colored_inverted_lamp_" : "colored_lamp_") + color.toString();

        return ForgeRegistries.BLOCKS.getValue(HelperUtil.prefixResource(Gemspark.MODID, lampString));
    }

    private static Item.Properties itemProperties(Gem gem)
    {
        return new Item.Properties().rarity(gem.getRarity()).tab(ModItemGroups.PRIMARY);
    }

}
