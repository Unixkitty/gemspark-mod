package com.unixkitty.gemspark.init;

import com.unixkitty.gemspark.Gemspark;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.unixkitty.gemspark.block.EnumType.*;

@SuppressWarnings("unused")
public final class ModBlocks
{
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, Gemspark.MODID);

    public static final RegistryObject<Block> tanzanite_block = BLOCK.setup("tanzanite_block");
    public static final RegistryObject<Block> topaz_block = BLOCK.setup("topaz_block");
    public static final RegistryObject<Block> sapphire_block = BLOCK.setup("sapphire_block");
    public static final RegistryObject<Block> pink_sapphire_block = BLOCK.setup("pink_sapphire_block");
    public static final RegistryObject<Block> ruby_block = BLOCK.setup("ruby_block");

    public static final RegistryObject<Block> emerald_lantern = LANTERN.setup("emerald_lantern");
    public static final RegistryObject<Block> diamond_lantern = LANTERN.setup("diamond_lantern");
    public static final RegistryObject<Block> tanzanite_lantern = LANTERN.setup("tanzanite_lantern");
    public static final RegistryObject<Block> topaz_lantern = LANTERN.setup("topaz_lantern");
    public static final RegistryObject<Block> sapphire_lantern = LANTERN.setup("sapphire_lantern");
    public static final RegistryObject<Block> pink_sapphire_lantern = LANTERN.setup("pink_sapphire_lantern");
    public static final RegistryObject<Block> ruby_lantern = LANTERN.setup("ruby_lantern");

    public static final RegistryObject<Block> tanzanite_ore = ORE.setup("tanzanite_ore");
    public static final RegistryObject<Block> topaz_ore = ORE.setup("topaz_ore");
    public static final RegistryObject<Block> sapphire_ore = ORE.setup("sapphire_ore");
    public static final RegistryObject<Block> ruby_ore = ORE.setup("ruby_ore");

    public static final RegistryObject<Block> quartz_pedestal = PEDESTAL.setup("quartz_pedestal");

    public static final RegistryObject<Block> colored_lamp_white = REDSTONE_LAMP.setup("colored_lamp_white");
    public static final RegistryObject<Block> colored_lamp_orange = REDSTONE_LAMP.setup("colored_lamp_orange");
    public static final RegistryObject<Block> colored_lamp_magenta = REDSTONE_LAMP.setup("colored_lamp_magenta");
    public static final RegistryObject<Block> colored_lamp_light_blue = REDSTONE_LAMP.setup("colored_lamp_light_blue");
    public static final RegistryObject<Block> colored_lamp_yellow = REDSTONE_LAMP.setup("colored_lamp_yellow");
    public static final RegistryObject<Block> colored_lamp_lime = REDSTONE_LAMP.setup("colored_lamp_lime");
    public static final RegistryObject<Block> colored_lamp_pink = REDSTONE_LAMP.setup("colored_lamp_pink");
    public static final RegistryObject<Block> colored_lamp_gray = REDSTONE_LAMP.setup("colored_lamp_gray");
    public static final RegistryObject<Block> colored_lamp_light_gray = REDSTONE_LAMP.setup("colored_lamp_light_gray");
    public static final RegistryObject<Block> colored_lamp_cyan = REDSTONE_LAMP.setup("colored_lamp_cyan");
    public static final RegistryObject<Block> colored_lamp_purple = REDSTONE_LAMP.setup("colored_lamp_purple");
    public static final RegistryObject<Block> colored_lamp_blue = REDSTONE_LAMP.setup("colored_lamp_blue");
    public static final RegistryObject<Block> colored_lamp_brown = REDSTONE_LAMP.setup("colored_lamp_brown");
    public static final RegistryObject<Block> colored_lamp_green = REDSTONE_LAMP.setup("colored_lamp_green");
    public static final RegistryObject<Block> colored_lamp_red = REDSTONE_LAMP.setup("colored_lamp_red");
    public static final RegistryObject<Block> colored_lamp_black = REDSTONE_LAMP.setup("colored_lamp_black");

    public static final RegistryObject<Block> colored_inverted_lamp_white = INVERTED_REDSTONE_LAMP.setup("colored_inverted_lamp_white");
    public static final RegistryObject<Block> colored_inverted_lamp_orange = INVERTED_REDSTONE_LAMP.setup("colored_inverted_lamp_orange");
    public static final RegistryObject<Block> colored_inverted_lamp_magenta = INVERTED_REDSTONE_LAMP.setup("colored_inverted_lamp_magenta");
    public static final RegistryObject<Block> colored_inverted_lamp_light_blue = INVERTED_REDSTONE_LAMP.setup("colored_inverted_lamp_light_blue");
    public static final RegistryObject<Block> colored_inverted_lamp_yellow = INVERTED_REDSTONE_LAMP.setup("colored_inverted_lamp_yellow");
    public static final RegistryObject<Block> colored_inverted_lamp_lime = INVERTED_REDSTONE_LAMP.setup("colored_inverted_lamp_lime");
    public static final RegistryObject<Block> colored_inverted_lamp_pink = INVERTED_REDSTONE_LAMP.setup("colored_inverted_lamp_pink");
    public static final RegistryObject<Block> colored_inverted_lamp_gray = INVERTED_REDSTONE_LAMP.setup("colored_inverted_lamp_gray");
    public static final RegistryObject<Block> colored_inverted_lamp_light_gray = INVERTED_REDSTONE_LAMP.setup("colored_inverted_lamp_light_gray");
    public static final RegistryObject<Block> colored_inverted_lamp_cyan = INVERTED_REDSTONE_LAMP.setup("colored_inverted_lamp_cyan");
    public static final RegistryObject<Block> colored_inverted_lamp_purple = INVERTED_REDSTONE_LAMP.setup("colored_inverted_lamp_purple");
    public static final RegistryObject<Block> colored_inverted_lamp_blue = INVERTED_REDSTONE_LAMP.setup("colored_inverted_lamp_blue");
    public static final RegistryObject<Block> colored_inverted_lamp_brown = INVERTED_REDSTONE_LAMP.setup("colored_inverted_lamp_brown");
    public static final RegistryObject<Block> colored_inverted_lamp_green = INVERTED_REDSTONE_LAMP.setup("colored_inverted_lamp_green");
    public static final RegistryObject<Block> colored_inverted_lamp_red = INVERTED_REDSTONE_LAMP.setup("colored_inverted_lamp_red");
    public static final RegistryObject<Block> colored_inverted_lamp_black = INVERTED_REDSTONE_LAMP.setup("colored_inverted_lamp_black");
}
