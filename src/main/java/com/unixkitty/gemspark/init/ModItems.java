package com.unixkitty.gemspark.init;

import com.unixkitty.gemspark.Gemspark;
import com.unixkitty.gemspark.util.HelperUtil;
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

    public static final RegistryObject<Item> nbt_stick = HelperUtil.registerDebugItem();

    public static final RegistryObject<Item> tanzanite = HelperUtil.registerGemItem(TANZANITE);
    public static final RegistryObject<Item> topaz = HelperUtil.registerGemItem(TOPAZ);
    public static final RegistryObject<Item> sapphire = HelperUtil.registerGemItem(SAPPHIRE);
    public static final RegistryObject<Item> pink_sapphire = HelperUtil.registerGemItem(PINK_SAPPHIRE);
    public static final RegistryObject<Item> ruby = HelperUtil.registerGemItem(RUBY);

    public static final RegistryObject<Item> tanzanite_axe = HelperUtil.registerAxeItem(TANZANITE);
    public static final RegistryObject<Item> topaz_axe = HelperUtil.registerAxeItem(TOPAZ);
    public static final RegistryObject<Item> sapphire_axe = HelperUtil.registerAxeItem(SAPPHIRE);
    public static final RegistryObject<Item> pink_sapphire_axe = HelperUtil.registerAxeItem(PINK_SAPPHIRE);
    public static final RegistryObject<Item> ruby_axe = HelperUtil.registerAxeItem(RUBY);

    public static final RegistryObject<Item> tanzanite_sword = HelperUtil.registerSwordItem(TANZANITE);
    public static final RegistryObject<Item> topaz_sword = HelperUtil.registerSwordItem(TOPAZ);
    public static final RegistryObject<Item> sapphire_sword = HelperUtil.registerSwordItem(SAPPHIRE);
    public static final RegistryObject<Item> pink_sapphire_sword = HelperUtil.registerSwordItem(PINK_SAPPHIRE);
    public static final RegistryObject<Item> ruby_sword = HelperUtil.registerSwordItem(RUBY);

    public static final RegistryObject<Item> tanzanite_shovel = HelperUtil.registerShovelItem(TANZANITE);
    public static final RegistryObject<Item> topaz_shovel = HelperUtil.registerShovelItem(TOPAZ);
    public static final RegistryObject<Item> sapphire_shovel = HelperUtil.registerShovelItem(SAPPHIRE);
    public static final RegistryObject<Item> pink_sapphire_shovel = HelperUtil.registerShovelItem(PINK_SAPPHIRE);
    public static final RegistryObject<Item> ruby_shovel = HelperUtil.registerShovelItem(RUBY);

    public static final RegistryObject<Item> tanzanite_pickaxe = HelperUtil.registerPickaxeItem(TANZANITE);
    public static final RegistryObject<Item> topaz_pickaxe = HelperUtil.registerPickaxeItem(TOPAZ);
    public static final RegistryObject<Item> sapphire_pickaxe = HelperUtil.registerPickaxeItem(SAPPHIRE);
    public static final RegistryObject<Item> pink_sapphire_pickaxe = HelperUtil.registerPickaxeItem(PINK_SAPPHIRE);
    public static final RegistryObject<Item> ruby_pickaxe = HelperUtil.registerPickaxeItem(RUBY);

    public static final RegistryObject<Item> tanzanite_helmet = HelperUtil.registerArmorItem(TANZANITE, EquipmentSlotType.HEAD);
    public static final RegistryObject<Item> topaz_helmet = HelperUtil.registerArmorItem(TOPAZ, EquipmentSlotType.HEAD);
    public static final RegistryObject<Item> sapphire_helmet = HelperUtil.registerArmorItem(SAPPHIRE, EquipmentSlotType.HEAD);
    public static final RegistryObject<Item> pink_sapphire_helmet = HelperUtil.registerArmorItem(PINK_SAPPHIRE, EquipmentSlotType.HEAD);
    public static final RegistryObject<Item> ruby_helmet = HelperUtil.registerArmorItem(RUBY, EquipmentSlotType.HEAD);

    public static final RegistryObject<Item> tanzanite_chestplate = HelperUtil.registerArmorItem(TANZANITE, EquipmentSlotType.CHEST);
    public static final RegistryObject<Item> topaz_chestplate = HelperUtil.registerArmorItem(TOPAZ, EquipmentSlotType.CHEST);
    public static final RegistryObject<Item> sapphire_chestplate = HelperUtil.registerArmorItem(SAPPHIRE, EquipmentSlotType.CHEST);
    public static final RegistryObject<Item> pink_sapphire_chestplate = HelperUtil.registerArmorItem(PINK_SAPPHIRE, EquipmentSlotType.CHEST);
    public static final RegistryObject<Item> ruby_chestplate = HelperUtil.registerArmorItem(RUBY, EquipmentSlotType.CHEST);

    public static final RegistryObject<Item> tanzanite_leggings = HelperUtil.registerArmorItem(TANZANITE, EquipmentSlotType.LEGS);
    public static final RegistryObject<Item> topaz_leggings = HelperUtil.registerArmorItem(TOPAZ, EquipmentSlotType.LEGS);
    public static final RegistryObject<Item> sapphire_leggings = HelperUtil.registerArmorItem(SAPPHIRE, EquipmentSlotType.LEGS);
    public static final RegistryObject<Item> pink_sapphire_leggings = HelperUtil.registerArmorItem(PINK_SAPPHIRE, EquipmentSlotType.LEGS);
    public static final RegistryObject<Item> ruby_leggings = HelperUtil.registerArmorItem(RUBY, EquipmentSlotType.LEGS);

    public static final RegistryObject<Item> tanzanite_boots = HelperUtil.registerArmorItem(TANZANITE, EquipmentSlotType.FEET);
    public static final RegistryObject<Item> topaz_boots = HelperUtil.registerArmorItem(TOPAZ, EquipmentSlotType.FEET);
    public static final RegistryObject<Item> sapphire_boots = HelperUtil.registerArmorItem(SAPPHIRE, EquipmentSlotType.FEET);
    public static final RegistryObject<Item> pink_sapphire_boots = HelperUtil.registerArmorItem(PINK_SAPPHIRE, EquipmentSlotType.FEET);
    public static final RegistryObject<Item> ruby_boots = HelperUtil.registerArmorItem(RUBY, EquipmentSlotType.FEET);
}
