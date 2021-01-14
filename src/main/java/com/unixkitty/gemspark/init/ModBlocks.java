package com.unixkitty.gemspark.init;

import com.unixkitty.gemspark.Config;
import com.unixkitty.gemspark.Gemspark;
import com.unixkitty.gemspark.block.BlockLampPostCap;
import com.unixkitty.gemspark.block.BlockPedestal;
import com.unixkitty.gemspark.block.InvertedRedstoneLampBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.RedstoneLampBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@SuppressWarnings("unused")
public final class ModBlocks
{
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Gemspark.MODID);

    public static final RegistryObject<Block> TANZANITE_BLOCK = setup(ModBlockType.GEM_BLOCK, "tanzanite_block");
    public static final RegistryObject<Block> TOPAZ_BLOCK = setup(ModBlockType.GEM_BLOCK, "topaz_block");
    public static final RegistryObject<Block> SAPPHIRE_BLOCK = setup(ModBlockType.GEM_BLOCK, "sapphire_block");
    public static final RegistryObject<Block> PINK_SAPPHIRE_BLOCK = setup(ModBlockType.GEM_BLOCK, "pink_sapphire_block");
    public static final RegistryObject<Block> RUBY_BLOCK = setup(ModBlockType.GEM_BLOCK, "ruby_block");

    public static final RegistryObject<Block> EMERALD_LANTERN = setup(ModBlockType.LANTERN, "emerald_lantern");
    public static final RegistryObject<Block> DIAMOND_LANTERN = setup(ModBlockType.LANTERN, "diamond_lantern");
    public static final RegistryObject<Block> TANZANITE_LANTERN = setup(ModBlockType.LANTERN, "tanzanite_lantern");
    public static final RegistryObject<Block> TOPAZ_LANTERN = setup(ModBlockType.LANTERN, "topaz_lantern");
    public static final RegistryObject<Block> SAPPHIRE_LANTERN = setup(ModBlockType.LANTERN, "sapphire_lantern");
    public static final RegistryObject<Block> PINK_SAPPHIRE_LANTERN = setup(ModBlockType.LANTERN, "pink_sapphire_lantern");
    public static final RegistryObject<Block> RUBY_LANTERN = setup(ModBlockType.LANTERN, "ruby_lantern");

    public static final RegistryObject<Block> TANZANITE_ORE = setup(ModBlockType.ORE, "tanzanite_ore");
    public static final RegistryObject<Block> TOPAZ_ORE = setup(ModBlockType.ORE, "topaz_ore");
    public static final RegistryObject<Block> SAPPHIRE_ORE = setup(ModBlockType.ORE, "sapphire_ore");
    public static final RegistryObject<Block> PINK_SAPPHIRE_ORE = setup(ModBlockType.ORE, "pink_sapphire_ore");
    public static final RegistryObject<Block> RUBY_ORE = setup(ModBlockType.ORE, "ruby_ore");

    public static final RegistryObject<Block> QUARTZ_PEDESTAL = setup(ModBlockType.PEDESTAL, "quartz_pedestal");

    public static final RegistryObject<Block> COLORED_LAMP_WHITE = setup(ModBlockType.REDSTONE_LAMP, "colored_lamp_white");
    public static final RegistryObject<Block> COLORED_LAMP_ORANGE = setup(ModBlockType.REDSTONE_LAMP, "colored_lamp_orange");
    public static final RegistryObject<Block> COLORED_LAMP_MAGENTA = setup(ModBlockType.REDSTONE_LAMP, "colored_lamp_magenta");
    public static final RegistryObject<Block> COLORED_LAMP_LIGHT_BLUE = setup(ModBlockType.REDSTONE_LAMP, "colored_lamp_light_blue");
    public static final RegistryObject<Block> COLORED_LAMP_YELLOW = setup(ModBlockType.REDSTONE_LAMP, "colored_lamp_yellow");
    public static final RegistryObject<Block> COLORED_LAMP_LIME = setup(ModBlockType.REDSTONE_LAMP, "colored_lamp_lime");
    public static final RegistryObject<Block> COLORED_LAMP_PINK = setup(ModBlockType.REDSTONE_LAMP, "colored_lamp_pink");
    public static final RegistryObject<Block> COLORED_LAMP_GRAY = setup(ModBlockType.REDSTONE_LAMP, "colored_lamp_gray");
    public static final RegistryObject<Block> COLORED_LAMP_LIGHT_GRAY = setup(ModBlockType.REDSTONE_LAMP, "colored_lamp_light_gray");
    public static final RegistryObject<Block> COLORED_LAMP_CYAN = setup(ModBlockType.REDSTONE_LAMP, "colored_lamp_cyan");
    public static final RegistryObject<Block> COLORED_LAMP_PURPLE = setup(ModBlockType.REDSTONE_LAMP, "colored_lamp_purple");
    public static final RegistryObject<Block> COLORED_LAMP_BLUE = setup(ModBlockType.REDSTONE_LAMP, "colored_lamp_blue");
    public static final RegistryObject<Block> COLORED_LAMP_BROWN = setup(ModBlockType.REDSTONE_LAMP, "colored_lamp_brown");
    public static final RegistryObject<Block> COLORED_LAMP_GREEN = setup(ModBlockType.REDSTONE_LAMP, "colored_lamp_green");
    public static final RegistryObject<Block> COLORED_LAMP_RED = setup(ModBlockType.REDSTONE_LAMP, "colored_lamp_red");
    public static final RegistryObject<Block> COLORED_LAMP_BLACK = setup(ModBlockType.REDSTONE_LAMP, "colored_lamp_black");

    public static final RegistryObject<Block> COLORED_INVERTED_LAMP_WHITE = setup(ModBlockType.INVERTED_REDSTONE_LAMP, "colored_inverted_lamp_white");
    public static final RegistryObject<Block> COLORED_INVERTED_LAMP_ORANGE = setup(ModBlockType.INVERTED_REDSTONE_LAMP, "colored_inverted_lamp_orange");
    public static final RegistryObject<Block> COLORED_INVERTED_LAMP_MAGENTA = setup(ModBlockType.INVERTED_REDSTONE_LAMP, "colored_inverted_lamp_magenta");
    public static final RegistryObject<Block> COLORED_INVERTED_LAMP_LIGHT_BLUE = setup(ModBlockType.INVERTED_REDSTONE_LAMP, "colored_inverted_lamp_light_blue");
    public static final RegistryObject<Block> COLORED_INVERTED_LAMP_YELLOW = setup(ModBlockType.INVERTED_REDSTONE_LAMP, "colored_inverted_lamp_yellow");
    public static final RegistryObject<Block> COLORED_INVERTED_LAMP_LIME = setup(ModBlockType.INVERTED_REDSTONE_LAMP, "colored_inverted_lamp_lime");
    public static final RegistryObject<Block> COLORED_INVERTED_LAMP_PINK = setup(ModBlockType.INVERTED_REDSTONE_LAMP, "colored_inverted_lamp_pink");
    public static final RegistryObject<Block> COLORED_INVERTED_LAMP_GRAY = setup(ModBlockType.INVERTED_REDSTONE_LAMP, "colored_inverted_lamp_gray");
    public static final RegistryObject<Block> COLORED_INVERTED_LAMP_LIGHT_GRAY = setup(ModBlockType.INVERTED_REDSTONE_LAMP, "colored_inverted_lamp_light_gray");
    public static final RegistryObject<Block> COLORED_INVERTED_LAMP_CYAN = setup(ModBlockType.INVERTED_REDSTONE_LAMP, "colored_inverted_lamp_cyan");
    public static final RegistryObject<Block> COLORED_INVERTED_LAMP_PURPLE = setup(ModBlockType.INVERTED_REDSTONE_LAMP, "colored_inverted_lamp_purple");
    public static final RegistryObject<Block> COLORED_INVERTED_LAMP_BLUE = setup(ModBlockType.INVERTED_REDSTONE_LAMP, "colored_inverted_lamp_blue");
    public static final RegistryObject<Block> COLORED_INVERTED_LAMP_BROWN = setup(ModBlockType.INVERTED_REDSTONE_LAMP, "colored_inverted_lamp_brown");
    public static final RegistryObject<Block> COLORED_INVERTED_LAMP_GREEN = setup(ModBlockType.INVERTED_REDSTONE_LAMP, "colored_inverted_lamp_green");
    public static final RegistryObject<Block> COLORED_INVERTED_LAMP_RED = setup(ModBlockType.INVERTED_REDSTONE_LAMP, "colored_inverted_lamp_red");
    public static final RegistryObject<Block> COLORED_INVERTED_LAMP_BLACK = setup(ModBlockType.INVERTED_REDSTONE_LAMP, "colored_inverted_lamp_black");

    public static final RegistryObject<Block> LAMP_POST_CAP_OAK = setup("lamp_post_cap_oak", Block.Properties.from(Blocks.OAK_FENCE));
    public static final RegistryObject<Block> LAMP_POST_CAP_NETHER_BRICK = setup("lamp_post_cap_nether_brick", Block.Properties.from(Blocks.NETHER_BRICK_FENCE));
    public static final RegistryObject<Block> LAMP_POST_CAP_SPRUCE = setup("lamp_post_cap_spruce", Block.Properties.from(Blocks.SPRUCE_FENCE));
    public static final RegistryObject<Block> LAMP_POST_CAP_BIRCH = setup("lamp_post_cap_birch", Block.Properties.from(Blocks.BIRCH_FENCE));
    public static final RegistryObject<Block> LAMP_POST_CAP_JUNGLE = setup("lamp_post_cap_jungle", Block.Properties.from(Blocks.JUNGLE_FENCE));
    public static final RegistryObject<Block> LAMP_POST_CAP_ACACIA = setup("lamp_post_cap_acacia", Block.Properties.from(Blocks.ACACIA_FENCE));
    public static final RegistryObject<Block> LAMP_POST_CAP_DARK_OAK = setup("lamp_post_cap_dark_oak", Block.Properties.from(Blocks.DARK_OAK_FENCE));
    public static final RegistryObject<Block> LAMP_POST_CAP_WARPED = setup("lamp_post_cap_warped", Block.Properties.from(Blocks.WARPED_FENCE));
    public static final RegistryObject<Block> LAMP_POST_CAP_CRIMSON = setup("lamp_post_cap_crimson", Block.Properties.from(Blocks.CRIMSON_FENCE));

    private static RegistryObject<Block> setup(ModBlockType blockType, String name)
    {
        switch (blockType)
        {
            case GEM_BLOCK:
                return BLOCKS.register(name, () -> new Block(Block.Properties.from(Blocks.DIAMOND_BLOCK)));
            case LANTERN:
                return BLOCKS.register(name, () -> new Block(Block.Properties.from(Blocks.GLOWSTONE)));
            case ORE:
                return BLOCKS.register(name, () -> new Block(Block.Properties.from(Blocks.DIAMOND_ORE))
                {
                    @Override
                    public int getExpDrop(BlockState state, IWorldReader world, BlockPos pos, int fortune, int silktouch)
                    {
                        return silktouch == 0 ? MathHelper.nextInt(RANDOM, 3, 7) : 0;
                    }
                });
            case PEDESTAL:
                return BLOCKS.register(name, () -> new BlockPedestal(Block.Properties.from(Blocks.QUARTZ_BLOCK).notSolid().setAllowsSpawn(ModBlocks::neverAllowSpawn)));
            case REDSTONE_LAMP:
                return !Config.registerColoredLamps.get() ? null : BLOCKS.register(name, () -> new RedstoneLampBlock(Block.Properties.from(Blocks.REDSTONE_LAMP)));
            case INVERTED_REDSTONE_LAMP:
                return !Config.registerColoredLamps.get() ? null : BLOCKS.register(name, InvertedRedstoneLampBlock::new);
            default:
                return null;
        }
    }

    private static RegistryObject<Block> setup(String name, Block.Properties properties)
    {
        return BLOCKS.register(name, () -> new BlockLampPostCap(properties.setAllowsSpawn(ModBlocks::neverAllowSpawn)));
    }

    private enum ModBlockType
    {
        GEM_BLOCK,
        LANTERN,
        ORE,
        PEDESTAL,
        REDSTONE_LAMP,
        INVERTED_REDSTONE_LAMP,
        LAMP_POST
    }

    private static Boolean neverAllowSpawn(BlockState state, IBlockReader reader, BlockPos pos, EntityType<?> entity)
    {
        return false;
    }
}
