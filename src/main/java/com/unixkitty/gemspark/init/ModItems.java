package com.unixkitty.gemspark.init;

import com.unixkitty.gemspark.Gemspark;
import com.unixkitty.gemspark.util.Gem;
import com.unixkitty.gemspark.util.HelperUtil;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@SuppressWarnings("unused")
public final class ModItems
{
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, Gemspark.MODID);

    public static final RegistryObject<Item> nbt_stick = HelperUtil.registerDebugItem();

    public static final RegistryObject<Item> TANZANITE = HelperUtil.registerGemItem(Gem.TANZANITE);
    public static final RegistryObject<Item> TOPAZ = HelperUtil.registerGemItem(Gem.TOPAZ);
    public static final RegistryObject<Item> SAPPHIRE = HelperUtil.registerGemItem(Gem.SAPPHIRE);
    public static final RegistryObject<Item> PINK_SAPPHIRE = HelperUtil.registerGemItem(Gem.PINK_SAPPHIRE);
    public static final RegistryObject<Item> RUBY = HelperUtil.registerGemItem(Gem.RUBY);

    public static final RegistryObject<Item> TANZANITE_AXE = HelperUtil.registerAxeItem(Gem.TANZANITE);
    public static final RegistryObject<Item> TOPAZ_AXE = HelperUtil.registerAxeItem(Gem.TOPAZ);
    public static final RegistryObject<Item> SAPPHIRE_AXE = HelperUtil.registerAxeItem(Gem.SAPPHIRE);
    public static final RegistryObject<Item> PINK_SAPPHIRE_AXE = HelperUtil.registerAxeItem(Gem.PINK_SAPPHIRE);
    public static final RegistryObject<Item> RUBY_AXE = HelperUtil.registerAxeItem(Gem.RUBY);

    public static final RegistryObject<Item> TANZANITE_SWORD = HelperUtil.registerSwordItem(Gem.TANZANITE);
    public static final RegistryObject<Item> TOPAZ_SWORD = HelperUtil.registerSwordItem(Gem.TOPAZ);
    public static final RegistryObject<Item> SAPPHIRE_SWORD = HelperUtil.registerSwordItem(Gem.SAPPHIRE);
    public static final RegistryObject<Item> PINK_SAPPHIRE_SWORD = HelperUtil.registerSwordItem(Gem.PINK_SAPPHIRE);
    public static final RegistryObject<Item> RUBY_SWORD = HelperUtil.registerSwordItem(Gem.RUBY);

    public static final RegistryObject<Item> TANZANITE_SHOVEL = HelperUtil.registerShovelItem(Gem.TANZANITE);
    public static final RegistryObject<Item> TOPAZ_SHOVEL = HelperUtil.registerShovelItem(Gem.TOPAZ);
    public static final RegistryObject<Item> SAPPHIRE_SHOVEL = HelperUtil.registerShovelItem(Gem.SAPPHIRE);
    public static final RegistryObject<Item> PINK_SAPPHIRE_SHOVEL = HelperUtil.registerShovelItem(Gem.PINK_SAPPHIRE);
    public static final RegistryObject<Item> RUBY_SHOVEL = HelperUtil.registerShovelItem(Gem.RUBY);

    public static final RegistryObject<Item> TANZANITE_PICKAXE = HelperUtil.registerPickaxeItem(Gem.TANZANITE);
    public static final RegistryObject<Item> TOPAZ_PICKAXE = HelperUtil.registerPickaxeItem(Gem.TOPAZ);
    public static final RegistryObject<Item> SAPPHIRE_PICKAXE = HelperUtil.registerPickaxeItem(Gem.SAPPHIRE);
    public static final RegistryObject<Item> PINK_SAPPHIRE_PICKAXE = HelperUtil.registerPickaxeItem(Gem.PINK_SAPPHIRE);
    public static final RegistryObject<Item> RUBY_PICKAXE = HelperUtil.registerPickaxeItem(Gem.RUBY);

    public static final RegistryObject<Item> TANZANITE_HOE = HelperUtil.registerHoeItem(Gem.TANZANITE);
    public static final RegistryObject<Item> TOPAZ_HOE = HelperUtil.registerHoeItem(Gem.TOPAZ);
    public static final RegistryObject<Item> SAPPHIRE_HOE = HelperUtil.registerHoeItem(Gem.SAPPHIRE);
    public static final RegistryObject<Item> PINK_SAPPHIRE_HOE = HelperUtil.registerHoeItem(Gem.PINK_SAPPHIRE);
    public static final RegistryObject<Item> RUBY_HOE = HelperUtil.registerHoeItem(Gem.RUBY);

    public static final RegistryObject<Item> TANZANITE_HELMET = HelperUtil.registerArmorItem(Gem.TANZANITE, EquipmentSlotType.HEAD);
    public static final RegistryObject<Item> TOPAZ_HELMET = HelperUtil.registerArmorItem(Gem.TOPAZ, EquipmentSlotType.HEAD);
    public static final RegistryObject<Item> SAPPHIRE_HELMET = HelperUtil.registerArmorItem(Gem.SAPPHIRE, EquipmentSlotType.HEAD);
    public static final RegistryObject<Item> PINK_SAPPHIRE_HELMET = HelperUtil.registerArmorItem(Gem.PINK_SAPPHIRE, EquipmentSlotType.HEAD);
    public static final RegistryObject<Item> RUBY_HELMET = HelperUtil.registerArmorItem(Gem.RUBY, EquipmentSlotType.HEAD);

    public static final RegistryObject<Item> TANZANITE_CHESTPLATE = HelperUtil.registerArmorItem(Gem.TANZANITE, EquipmentSlotType.CHEST);
    public static final RegistryObject<Item> TOPAZ_CHESTPLATE = HelperUtil.registerArmorItem(Gem.TOPAZ, EquipmentSlotType.CHEST);
    public static final RegistryObject<Item> SAPPHIRE_CHESTPLATE = HelperUtil.registerArmorItem(Gem.SAPPHIRE, EquipmentSlotType.CHEST);
    public static final RegistryObject<Item> PINK_SAPPHIRE_CHESTPLATE = HelperUtil.registerArmorItem(Gem.PINK_SAPPHIRE, EquipmentSlotType.CHEST);
    public static final RegistryObject<Item> RUBY_CHESTPLATE = HelperUtil.registerArmorItem(Gem.RUBY, EquipmentSlotType.CHEST);

    public static final RegistryObject<Item> TANZANITE_LEGGINGS = HelperUtil.registerArmorItem(Gem.TANZANITE, EquipmentSlotType.LEGS);
    public static final RegistryObject<Item> TOPAZ_LEGGINGS = HelperUtil.registerArmorItem(Gem.TOPAZ, EquipmentSlotType.LEGS);
    public static final RegistryObject<Item> SAPPHIRE_LEGGINGS = HelperUtil.registerArmorItem(Gem.SAPPHIRE, EquipmentSlotType.LEGS);
    public static final RegistryObject<Item> PINK_SAPPHIRE_LEGGINGS = HelperUtil.registerArmorItem(Gem.PINK_SAPPHIRE, EquipmentSlotType.LEGS);
    public static final RegistryObject<Item> RUBY_LEGGINGS = HelperUtil.registerArmorItem(Gem.RUBY, EquipmentSlotType.LEGS);

    public static final RegistryObject<Item> TANZANITE_BOOTS = HelperUtil.registerArmorItem(Gem.TANZANITE, EquipmentSlotType.FEET);
    public static final RegistryObject<Item> TOPAZ_BOOTS = HelperUtil.registerArmorItem(Gem.TOPAZ, EquipmentSlotType.FEET);
    public static final RegistryObject<Item> SAPPHIRE_BOOTS = HelperUtil.registerArmorItem(Gem.SAPPHIRE, EquipmentSlotType.FEET);
    public static final RegistryObject<Item> PINK_SAPPHIRE_BOOTS = HelperUtil.registerArmorItem(Gem.PINK_SAPPHIRE, EquipmentSlotType.FEET);
    public static final RegistryObject<Item> RUBY_BOOTS = HelperUtil.registerArmorItem(Gem.RUBY, EquipmentSlotType.FEET);
}
