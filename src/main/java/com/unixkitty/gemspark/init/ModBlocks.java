package com.unixkitty.gemspark.init;

import com.unixkitty.gemspark.Gemspark;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.unixkitty.gemspark.block.ModBlockType.*;

@SuppressWarnings("unused")
public final class ModBlocks
{
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, Gemspark.MODID);

    public static final RegistryObject<Block> TANZANITE_BLOCK = BLOCK.setup("tanzanite_block");
    public static final RegistryObject<Block> TOPAZ_BLOCK = BLOCK.setup("topaz_block");
    public static final RegistryObject<Block> SAPPHIRE_BLOCK = BLOCK.setup("sapphire_block");
    public static final RegistryObject<Block> PINK_SAPPHIRE_BLOCK = BLOCK.setup("pink_sapphire_block");
    public static final RegistryObject<Block> RUBY_BLOCK = BLOCK.setup("ruby_block");

    public static final RegistryObject<Block> EMERALD_LANTERN = LANTERN.setup("emerald_lantern");
    public static final RegistryObject<Block> DIAMOND_LANTERN = LANTERN.setup("diamond_lantern");
    public static final RegistryObject<Block> TANZANITE_LANTERN = LANTERN.setup("tanzanite_lantern");
    public static final RegistryObject<Block> TOPAZ_LANTERN = LANTERN.setup("topaz_lantern");
    public static final RegistryObject<Block> SAPPHIRE_LANTERN = LANTERN.setup("sapphire_lantern");
    public static final RegistryObject<Block> PINK_SAPPHIRE_LANTERN = LANTERN.setup("pink_sapphire_lantern");
    public static final RegistryObject<Block> RUBY_LANTERN = LANTERN.setup("ruby_lantern");

    public static final RegistryObject<Block> TANZANITE_ORE = ORE.setup("tanzanite_ore");
    public static final RegistryObject<Block> TOPAZ_ORE = ORE.setup("topaz_ore");
    public static final RegistryObject<Block> SAPPHIRE_ORE = ORE.setup("sapphire_ore");
    public static final RegistryObject<Block> PINK_SAPPHIRE_ORE = ORE.setup("pink_sapphire_ore");
    public static final RegistryObject<Block> RUBY_ORE = ORE.setup("ruby_ore");

    public static final RegistryObject<Block> QUARTZ_PEDESTAL = PEDESTAL.setup("quartz_pedestal");

    public static final RegistryObject<Block> COLORED_LAMP_WHITE = REDSTONE_LAMP.setup("colored_lamp_white");
    public static final RegistryObject<Block> COLORED_LAMP_ORANGE = REDSTONE_LAMP.setup("colored_lamp_orange");
    public static final RegistryObject<Block> COLORED_LAMP_MAGENTA = REDSTONE_LAMP.setup("colored_lamp_magenta");
    public static final RegistryObject<Block> COLORED_LAMP_LIGHT_BLUE = REDSTONE_LAMP.setup("colored_lamp_light_blue");
    public static final RegistryObject<Block> COLORED_LAMP_YELLOW = REDSTONE_LAMP.setup("colored_lamp_yellow");
    public static final RegistryObject<Block> COLORED_LAMP_LIME = REDSTONE_LAMP.setup("colored_lamp_lime");
    public static final RegistryObject<Block> COLORED_LAMP_PINK = REDSTONE_LAMP.setup("colored_lamp_pink");
    public static final RegistryObject<Block> COLORED_LAMP_GRAY = REDSTONE_LAMP.setup("colored_lamp_gray");
    public static final RegistryObject<Block> COLORED_LAMP_LIGHT_GRAY = REDSTONE_LAMP.setup("colored_lamp_light_gray");
    public static final RegistryObject<Block> COLORED_LAMP_CYAN = REDSTONE_LAMP.setup("colored_lamp_cyan");
    public static final RegistryObject<Block> COLORED_LAMP_PURPLE = REDSTONE_LAMP.setup("colored_lamp_purple");
    public static final RegistryObject<Block> COLORED_LAMP_BLUE = REDSTONE_LAMP.setup("colored_lamp_blue");
    public static final RegistryObject<Block> COLORED_LAMP_BROWN = REDSTONE_LAMP.setup("colored_lamp_brown");
    public static final RegistryObject<Block> COLORED_LAMP_GREEN = REDSTONE_LAMP.setup("colored_lamp_green");
    public static final RegistryObject<Block> COLORED_LAMP_RED = REDSTONE_LAMP.setup("colored_lamp_red");
    public static final RegistryObject<Block> COLORED_LAMP_BLACK = REDSTONE_LAMP.setup("colored_lamp_black");

    public static final RegistryObject<Block> COLORED_INVERTED_LAMP_WHITE = INVERTED_REDSTONE_LAMP.setup("colored_inverted_lamp_white");
    public static final RegistryObject<Block> COLORED_INVERTED_LAMP_ORANGE = INVERTED_REDSTONE_LAMP.setup("colored_inverted_lamp_orange");
    public static final RegistryObject<Block> COLORED_INVERTED_LAMP_MAGENTA = INVERTED_REDSTONE_LAMP.setup("colored_inverted_lamp_magenta");
    public static final RegistryObject<Block> COLORED_INVERTED_LAMP_LIGHT_BLUE = INVERTED_REDSTONE_LAMP.setup("colored_inverted_lamp_light_blue");
    public static final RegistryObject<Block> COLORED_INVERTED_LAMP_YELLOW = INVERTED_REDSTONE_LAMP.setup("colored_inverted_lamp_yellow");
    public static final RegistryObject<Block> COLORED_INVERTED_LAMP_LIME = INVERTED_REDSTONE_LAMP.setup("colored_inverted_lamp_lime");
    public static final RegistryObject<Block> COLORED_INVERTED_LAMP_PINK = INVERTED_REDSTONE_LAMP.setup("colored_inverted_lamp_pink");
    public static final RegistryObject<Block> COLORED_INVERTED_LAMP_GRAY = INVERTED_REDSTONE_LAMP.setup("colored_inverted_lamp_gray");
    public static final RegistryObject<Block> COLORED_INVERTED_LAMP_LIGHT_GRAY = INVERTED_REDSTONE_LAMP.setup("colored_inverted_lamp_light_gray");
    public static final RegistryObject<Block> COLORED_INVERTED_LAMP_CYAN = INVERTED_REDSTONE_LAMP.setup("colored_inverted_lamp_cyan");
    public static final RegistryObject<Block> COLORED_INVERTED_LAMP_PURPLE = INVERTED_REDSTONE_LAMP.setup("colored_inverted_lamp_purple");
    public static final RegistryObject<Block> COLORED_INVERTED_LAMP_BLUE = INVERTED_REDSTONE_LAMP.setup("colored_inverted_lamp_blue");
    public static final RegistryObject<Block> COLORED_INVERTED_LAMP_BROWN = INVERTED_REDSTONE_LAMP.setup("colored_inverted_lamp_brown");
    public static final RegistryObject<Block> COLORED_INVERTED_LAMP_GREEN = INVERTED_REDSTONE_LAMP.setup("colored_inverted_lamp_green");
    public static final RegistryObject<Block> COLORED_INVERTED_LAMP_RED = INVERTED_REDSTONE_LAMP.setup("colored_inverted_lamp_red");
    public static final RegistryObject<Block> COLORED_INVERTED_LAMP_BLACK = INVERTED_REDSTONE_LAMP.setup("colored_inverted_lamp_black");
}
