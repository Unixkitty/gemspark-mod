package com.unixkitty.gemspark.init;

import com.unixkitty.gemspark.Gemspark;
import com.unixkitty.gemspark.util.GemHelper;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.unixkitty.gemspark.util.Gems.*;

@SuppressWarnings("unused")
public final class ModItems
{
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, Gemspark.MODID);

    public static final RegistryObject<Item> tanzanite = GemHelper.registerGemItem(TANZANITE);
    public static final RegistryObject<Item> topaz = GemHelper.registerGemItem(TOPAZ);
    public static final RegistryObject<Item> sapphire = GemHelper.registerGemItem(SAPPHIRE);
    public static final RegistryObject<Item> pink_sapphire = GemHelper.registerGemItem(PINK_SAPPHIRE);
    public static final RegistryObject<Item> ruby = GemHelper.registerGemItem(RUBY);

    public static final RegistryObject<Item> tanzanite_axe = GemHelper.registerAxeItem(TANZANITE);
    public static final RegistryObject<Item> topaz_axe = GemHelper.registerAxeItem(TOPAZ);
    public static final RegistryObject<Item> sapphire_axe = GemHelper.registerAxeItem(SAPPHIRE);
    public static final RegistryObject<Item> pink_sapphire_axe = GemHelper.registerAxeItem(PINK_SAPPHIRE);
    public static final RegistryObject<Item> ruby_axe = GemHelper.registerAxeItem(RUBY);

    public static final RegistryObject<Item> tanzanite_sword = GemHelper.registerSwordItem(TANZANITE);
    public static final RegistryObject<Item> topaz_sword = GemHelper.registerSwordItem(TOPAZ);
    public static final RegistryObject<Item> sapphire_sword = GemHelper.registerSwordItem(SAPPHIRE);
    public static final RegistryObject<Item> pink_sapphire_sword = GemHelper.registerSwordItem(PINK_SAPPHIRE);
    public static final RegistryObject<Item> ruby_sword = GemHelper.registerSwordItem(RUBY);

    public static final RegistryObject<Item> tanzanite_shovel = GemHelper.registerShovelItem(TANZANITE);
    public static final RegistryObject<Item> topaz_shovel = GemHelper.registerShovelItem(TOPAZ);
    public static final RegistryObject<Item> sapphire_shovel = GemHelper.registerShovelItem(SAPPHIRE);
    public static final RegistryObject<Item> pink_sapphire_shovel = GemHelper.registerShovelItem(PINK_SAPPHIRE);
    public static final RegistryObject<Item> ruby_shovel = GemHelper.registerShovelItem(RUBY);

    public static final RegistryObject<Item> tanzanite_pickaxe = GemHelper.registerPickaxeItem(TANZANITE);
    public static final RegistryObject<Item> topaz_pickaxe = GemHelper.registerPickaxeItem(TOPAZ);
    public static final RegistryObject<Item> sapphire_pickaxe = GemHelper.registerPickaxeItem(SAPPHIRE);
    public static final RegistryObject<Item> pink_sapphire_pickaxe = GemHelper.registerPickaxeItem(PINK_SAPPHIRE);
    public static final RegistryObject<Item> ruby_pickaxe = GemHelper.registerPickaxeItem(RUBY);

    public static final RegistryObject<Item> tanzanite_helmet = GemHelper.registerArmorItem(TANZANITE, EquipmentSlotType.HEAD);
    public static final RegistryObject<Item> topaz_helmet = GemHelper.registerArmorItem(TOPAZ, EquipmentSlotType.HEAD);
    public static final RegistryObject<Item> sapphire_helmet = GemHelper.registerArmorItem(SAPPHIRE, EquipmentSlotType.HEAD);
    public static final RegistryObject<Item> pink_sapphire_helmet = GemHelper.registerArmorItem(PINK_SAPPHIRE, EquipmentSlotType.HEAD);
    public static final RegistryObject<Item> ruby_helmet = GemHelper.registerArmorItem(RUBY, EquipmentSlotType.HEAD);

    public static final RegistryObject<Item> tanzanite_chestplate = GemHelper.registerArmorItem(TANZANITE, EquipmentSlotType.CHEST);
    public static final RegistryObject<Item> topaz_chestplate = GemHelper.registerArmorItem(TOPAZ, EquipmentSlotType.CHEST);
    public static final RegistryObject<Item> sapphire_chestplate = GemHelper.registerArmorItem(SAPPHIRE, EquipmentSlotType.CHEST);
    public static final RegistryObject<Item> pink_sapphire_chestplate = GemHelper.registerArmorItem(PINK_SAPPHIRE, EquipmentSlotType.CHEST);
    public static final RegistryObject<Item> ruby_chestplate = GemHelper.registerArmorItem(RUBY, EquipmentSlotType.CHEST);

    public static final RegistryObject<Item> tanzanite_leggings = GemHelper.registerArmorItem(TANZANITE, EquipmentSlotType.LEGS);
    public static final RegistryObject<Item> topaz_leggings = GemHelper.registerArmorItem(TOPAZ, EquipmentSlotType.LEGS);
    public static final RegistryObject<Item> sapphire_leggings = GemHelper.registerArmorItem(SAPPHIRE, EquipmentSlotType.LEGS);
    public static final RegistryObject<Item> pink_sapphire_leggings = GemHelper.registerArmorItem(PINK_SAPPHIRE, EquipmentSlotType.LEGS);
    public static final RegistryObject<Item> ruby_leggings = GemHelper.registerArmorItem(RUBY, EquipmentSlotType.LEGS);

    public static final RegistryObject<Item> tanzanite_boots = GemHelper.registerArmorItem(TANZANITE, EquipmentSlotType.FEET);
    public static final RegistryObject<Item> topaz_boots = GemHelper.registerArmorItem(TOPAZ, EquipmentSlotType.FEET);
    public static final RegistryObject<Item> sapphire_boots = GemHelper.registerArmorItem(SAPPHIRE, EquipmentSlotType.FEET);
    public static final RegistryObject<Item> pink_sapphire_boots = GemHelper.registerArmorItem(PINK_SAPPHIRE, EquipmentSlotType.FEET);
    public static final RegistryObject<Item> ruby_boots = GemHelper.registerArmorItem(RUBY, EquipmentSlotType.FEET);
}
