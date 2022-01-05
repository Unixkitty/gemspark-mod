package com.unixkitty.gemspark.init;

import com.unixkitty.gemspark.Gemspark;
import com.unixkitty.gemspark.block.*;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.item.DyeColor;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.ToIntFunction;

@SuppressWarnings("unused")
public final class ModBlocks
{
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Gemspark.MODID);

    public static final RegistryObject<Block> TANZANITE_BLOCK = setup(ModBlockType.GEM_BLOCK, "tanzanite_block");
    public static final RegistryObject<Block> TOPAZ_BLOCK = setup(ModBlockType.GEM_BLOCK, "topaz_block");
    public static final RegistryObject<Block> SAPPHIRE_BLOCK = setup(ModBlockType.GEM_BLOCK, "sapphire_block");
    public static final RegistryObject<Block> PINK_SAPPHIRE_BLOCK = setup(ModBlockType.GEM_BLOCK, "pink_sapphire_block");
    public static final RegistryObject<Block> RUBY_BLOCK = setup(ModBlockType.GEM_BLOCK, "ruby_block");

    public static final RegistryObject<Block> EMERALD_GEMSPARK_BLOCK = setup(ModBlockType.GEMSPARK, "emerald_gemspark_block");
    public static final RegistryObject<Block> DIAMOND_GEMSPARK_BLOCK = setup(ModBlockType.GEMSPARK, "diamond_gemspark_block");
    public static final RegistryObject<Block> TANZANITE_GEMSPARK_BLOCK = setup(ModBlockType.GEMSPARK, "tanzanite_gemspark_block");
    public static final RegistryObject<Block> TOPAZ_GEMSPARK_BLOCK = setup(ModBlockType.GEMSPARK, "topaz_gemspark_block");
    public static final RegistryObject<Block> SAPPHIRE_GEMSPARK_BLOCK = setup(ModBlockType.GEMSPARK, "sapphire_gemspark_block");
    public static final RegistryObject<Block> PINK_SAPPHIRE_GEMSPARK_BLOCK = setup(ModBlockType.GEMSPARK, "pink_sapphire_gemspark_block");
    public static final RegistryObject<Block> RUBY_GEMSPARK_BLOCK = setup(ModBlockType.GEMSPARK, "ruby_gemspark_block");

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
    public static final RegistryObject<Block> BLACKSTONE_PEDESTAL = setup(ModBlockType.PEDESTAL, "blackstone_pedestal");

    public static final RegistryObject<Block> COLORED_LAMP_WHITE = setupRedstoneLamp(DyeColor.WHITE, false);
    public static final RegistryObject<Block> COLORED_LAMP_ORANGE = setupRedstoneLamp(DyeColor.ORANGE, false);
    public static final RegistryObject<Block> COLORED_LAMP_MAGENTA = setupRedstoneLamp(DyeColor.MAGENTA, false);
    public static final RegistryObject<Block> COLORED_LAMP_LIGHT_BLUE = setupRedstoneLamp(DyeColor.LIGHT_BLUE, false);
    public static final RegistryObject<Block> COLORED_LAMP_YELLOW = setupRedstoneLamp(DyeColor.YELLOW, false);
    public static final RegistryObject<Block> COLORED_LAMP_LIME = setupRedstoneLamp(DyeColor.LIME, false);
    public static final RegistryObject<Block> COLORED_LAMP_PINK = setupRedstoneLamp(DyeColor.PINK, false);
    public static final RegistryObject<Block> COLORED_LAMP_GRAY = setupRedstoneLamp(DyeColor.GRAY, false);
    public static final RegistryObject<Block> COLORED_LAMP_LIGHT_GRAY = setupRedstoneLamp(DyeColor.LIGHT_GRAY, false);
    public static final RegistryObject<Block> COLORED_LAMP_CYAN = setupRedstoneLamp(DyeColor.CYAN, false);
    public static final RegistryObject<Block> COLORED_LAMP_PURPLE = setupRedstoneLamp(DyeColor.PURPLE, false);
    public static final RegistryObject<Block> COLORED_LAMP_BLUE = setupRedstoneLamp(DyeColor.BLUE, false);
    public static final RegistryObject<Block> COLORED_LAMP_BROWN = setupRedstoneLamp(DyeColor.BROWN, false);
    public static final RegistryObject<Block> COLORED_LAMP_GREEN = setupRedstoneLamp(DyeColor.GREEN, false);
    public static final RegistryObject<Block> COLORED_LAMP_RED = setupRedstoneLamp(DyeColor.RED, false);
    public static final RegistryObject<Block> COLORED_LAMP_BLACK = setupRedstoneLamp(DyeColor.BLACK, false);

    public static final RegistryObject<Block> COLORED_INVERTED_LAMP_WHITE = setupRedstoneLamp(DyeColor.WHITE, true);
    public static final RegistryObject<Block> COLORED_INVERTED_LAMP_ORANGE = setupRedstoneLamp(DyeColor.ORANGE, true);
    public static final RegistryObject<Block> COLORED_INVERTED_LAMP_MAGENTA = setupRedstoneLamp(DyeColor.MAGENTA, true);
    public static final RegistryObject<Block> COLORED_INVERTED_LAMP_LIGHT_BLUE = setupRedstoneLamp(DyeColor.LIGHT_BLUE, true);
    public static final RegistryObject<Block> COLORED_INVERTED_LAMP_YELLOW = setupRedstoneLamp(DyeColor.YELLOW, true);
    public static final RegistryObject<Block> COLORED_INVERTED_LAMP_LIME = setupRedstoneLamp(DyeColor.LIME, true);
    public static final RegistryObject<Block> COLORED_INVERTED_LAMP_PINK = setupRedstoneLamp(DyeColor.PINK, true);
    public static final RegistryObject<Block> COLORED_INVERTED_LAMP_GRAY = setupRedstoneLamp(DyeColor.GRAY, true);
    public static final RegistryObject<Block> COLORED_INVERTED_LAMP_LIGHT_GRAY = setupRedstoneLamp(DyeColor.LIGHT_GRAY, true);
    public static final RegistryObject<Block> COLORED_INVERTED_LAMP_CYAN = setupRedstoneLamp(DyeColor.CYAN, true);
    public static final RegistryObject<Block> COLORED_INVERTED_LAMP_PURPLE = setupRedstoneLamp(DyeColor.PURPLE, true);
    public static final RegistryObject<Block> COLORED_INVERTED_LAMP_BLUE = setupRedstoneLamp(DyeColor.BLUE, true);
    public static final RegistryObject<Block> COLORED_INVERTED_LAMP_BROWN = setupRedstoneLamp(DyeColor.BROWN, true);
    public static final RegistryObject<Block> COLORED_INVERTED_LAMP_GREEN = setupRedstoneLamp(DyeColor.GREEN, true);
    public static final RegistryObject<Block> COLORED_INVERTED_LAMP_RED = setupRedstoneLamp(DyeColor.RED, true);
    public static final RegistryObject<Block> COLORED_INVERTED_LAMP_BLACK = setupRedstoneLamp(DyeColor.BLACK, true);

    public static final RegistryObject<Block> LAMP_POST_CAP_OAK = setupLampPost("lamp_post_cap_oak", Block.Properties.copy(Blocks.OAK_FENCE));
    public static final RegistryObject<Block> LAMP_POST_CAP_NETHER_BRICK = setupLampPost("lamp_post_cap_nether_brick", Block.Properties.copy(Blocks.NETHER_BRICK_FENCE));
    public static final RegistryObject<Block> LAMP_POST_CAP_SPRUCE = setupLampPost("lamp_post_cap_spruce", Block.Properties.copy(Blocks.SPRUCE_FENCE));
    public static final RegistryObject<Block> LAMP_POST_CAP_BIRCH = setupLampPost("lamp_post_cap_birch", Block.Properties.copy(Blocks.BIRCH_FENCE));
    public static final RegistryObject<Block> LAMP_POST_CAP_JUNGLE = setupLampPost("lamp_post_cap_jungle", Block.Properties.copy(Blocks.JUNGLE_FENCE));
    public static final RegistryObject<Block> LAMP_POST_CAP_ACACIA = setupLampPost("lamp_post_cap_acacia", Block.Properties.copy(Blocks.ACACIA_FENCE));
    public static final RegistryObject<Block> LAMP_POST_CAP_DARK_OAK = setupLampPost("lamp_post_cap_dark_oak", Block.Properties.copy(Blocks.DARK_OAK_FENCE));
    public static final RegistryObject<Block> LAMP_POST_CAP_WARPED = setupLampPost("lamp_post_cap_warped", Block.Properties.copy(Blocks.WARPED_FENCE));
    public static final RegistryObject<Block> LAMP_POST_CAP_CRIMSON = setupLampPost("lamp_post_cap_crimson", Block.Properties.copy(Blocks.CRIMSON_FENCE));

    public static final RegistryObject<Block> WOOD_GOLEM_RELIC = BLOCKS.register("wood_golem_relic", () -> new BlockWoodGolem(Block.Properties.copy(Blocks.SPRUCE_PLANKS).isValidSpawn(ModBlocks::neverAllowSpawn)));

    public static final RegistryObject<Block> BRAZIER = BLOCKS.register("brazier", () -> new BlockBrazier(1, Block.Properties.copy(Blocks.IRON_BARS).lightLevel(getLightValueLit(15)).noOcclusion()));
    public static final RegistryObject<Block> SOUL_BRAZIER = BLOCKS.register("soul_brazier", () -> new BlockBrazier(2, Block.Properties.copy(Blocks.IRON_BARS).lightLevel(getLightValueLit(10)).noOcclusion()));

    public static final RegistryObject<Block> ROCKY_DIRT = BLOCKS.register("rocky_dirt", () -> new BlockDirt(Block.Properties.copy(Blocks.DIRT)));
    public static final RegistryObject<Block> ROCKY_GRASSY_DIRT = BLOCKS.register("rocky_grassy_dirt", () -> new BlockDirt(Block.Properties.copy(Blocks.COARSE_DIRT)));
    public static final RegistryObject<Block> DARK_ROCKY_DIRT = BLOCKS.register("dark_rocky_dirt", () -> new BlockDirt(Block.Properties.copy(Blocks.GRAVEL)));

    public static final RegistryObject<Block> STONE_FLOOR_TILE = BLOCKS.register("stone_floor_tile", () -> new Block(Block.Properties.copy(Blocks.SMOOTH_STONE)));
    public static final RegistryObject<Block> STONE_TILES = BLOCKS.register("stone_tiles", () -> new Block(Block.Properties.copy(Blocks.SMOOTH_STONE)));
    public static final RegistryObject<Block> SMOKED_STONE = BLOCKS.register("smoked_stone", () -> new Block(Block.Properties.copy(Blocks.SMOOTH_STONE)));
    public static final RegistryObject<Block> SMOKED_STONE_CTM = BLOCKS.register("smoked_stone_ctm", () -> new Block(Block.Properties.copy(Blocks.SMOOTH_STONE)));
    public static final RegistryObject<Block> METAL_FRAMED_STONE = BLOCKS.register("metal_framed_stone", () -> new Block(Block.Properties.copy(Blocks.SMOOTH_STONE)));
    public static final RegistryObject<Block> METAL_FRAMED_STONE_CTM = BLOCKS.register("metal_framed_stone_ctm", () -> new Block(Block.Properties.copy(Blocks.SMOOTH_STONE)));
    public static final RegistryObject<Block> ACCENTUATED_STONE = BLOCKS.register("accentuated_stone", () -> new Block(Block.Properties.copy(Blocks.SMOOTH_STONE)));
    public static final RegistryObject<Block> ACCENTUATED_STONE_CTM = BLOCKS.register("accentuated_stone_ctm", () -> new Block(Block.Properties.copy(Blocks.SMOOTH_STONE)));

    private static RegistryObject<Block> setup(ModBlockType blockType, String name)
    {
        switch (blockType)
        {
            case GEM_BLOCK:
                return BLOCKS.register(name, () -> new Block(Block.Properties.copy(Blocks.DIAMOND_BLOCK)));
            case LANTERN:
                return BLOCKS.register(name, () -> new Block(Block.Properties.copy(Blocks.GLOWSTONE)));
            case GEMSPARK:
                return BLOCKS.register(name, () -> new Block(Block.Properties.copy(Blocks.GLOWSTONE).lightLevel(value -> 9)));
            case ORE:
                return BLOCKS.register(name, () -> new Block(Block.Properties.copy(Blocks.DIAMOND_ORE))
                {
                    @Override
                    public int getExpDrop(BlockState state, IWorldReader world, BlockPos pos, int fortune, int silktouch)
                    {
                        return silktouch == 0 ? MathHelper.nextInt(RANDOM, 3, 7) : 0;
                    }
                });
            case PEDESTAL:
                return BLOCKS.register(name, () -> new BlockPedestal(Block.Properties.copy(Blocks.QUARTZ_BLOCK).noOcclusion().isValidSpawn(ModBlocks::neverAllowSpawn)));
            default:
                return null;
        }
    }

    private static RegistryObject<Block> setupRedstoneLamp(DyeColor color, boolean inverted)
    {
        return BLOCKS.register(
                "colored_" + (inverted ? "inverted_" : "") + "lamp_" + color.getName(),
                () -> inverted ? new LampBlock.Inverted(color) : new LampBlock.Normal(color)
        );
    }

    private static RegistryObject<Block> setupLampPost(String name, Block.Properties properties)
    {
        return BLOCKS.register(name, () -> new BlockLampPostCap(properties.isValidSpawn(ModBlocks::neverAllowSpawn)));
    }

    private enum ModBlockType
    {
        GEM_BLOCK,
        LANTERN,
        GEMSPARK,
        ORE,
        PEDESTAL,
        LAMP_POST
    }

    private static Boolean neverAllowSpawn(BlockState state, IBlockReader reader, BlockPos pos, EntityType<?> entity)
    {
        return false;
    }

    private static ToIntFunction<BlockState> getLightValueLit(int lightValue)
    {
        return (state) -> state.getValue(BlockStateProperties.LIT) ? lightValue : 0;
    }
}
