package com.unixkitty.gemspark.init;

import com.unixkitty.gemspark.Config;
import com.unixkitty.gemspark.Gemspark;
import com.unixkitty.gemspark.block.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RedstoneLampBlock;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraftforge.fmllegacy.RegistryObject;
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

    public static final RegistryObject<Block> ROCKY_DIRT = BLOCKS.register("rocky_dirt", () -> new Block(Block.Properties.copy(Blocks.DIRT)));
    public static final RegistryObject<Block> ROCKY_GRASSY_DIRT = BLOCKS.register("rocky_grassy_dirt", () -> new Block(Block.Properties.copy(Blocks.COARSE_DIRT)));
    public static final RegistryObject<Block> DARK_ROCKY_DIRT = BLOCKS.register("dark_rocky_dirt", () -> new Block(Block.Properties.copy(Blocks.GRAVEL)));

    public static final RegistryObject<Block> STONE_FLOOR_TILE = BLOCKS.register("stone_floor_tile", () -> new Block(Block.Properties.copy(Blocks.SMOOTH_STONE)));
    public static final RegistryObject<Block> STONE_TILES = BLOCKS.register("stone_tiles", () -> new Block(Block.Properties.copy(Blocks.SMOOTH_STONE)));

    private static RegistryObject<Block> setup(ModBlockType blockType, String name)
    {
        return switch (blockType)
                {
                    case GEM_BLOCK -> BLOCKS.register(name, () -> new Block(Block.Properties.copy(Blocks.DIAMOND_BLOCK)));
                    case LANTERN -> BLOCKS.register(name, () -> new Block(Block.Properties.copy(Blocks.GLOWSTONE)));
                    case ORE -> BLOCKS.register(name, () -> new Block(Block.Properties.copy(Blocks.DIAMOND_ORE))
                    {
                        @Override
                        public int getExpDrop(BlockState state, LevelReader world, BlockPos pos, int fortune, int silktouch)
                        {
                            return silktouch == 0 ? Mth.nextInt(RANDOM, 3, 7) : 0;
                        }
                    });
                    case PEDESTAL -> BLOCKS.register(name, () -> new BlockPedestal(Block.Properties.copy(Blocks.QUARTZ_BLOCK).noOcclusion().isValidSpawn(ModBlocks::neverAllowSpawn)));
                    case REDSTONE_LAMP -> !Config.registerColoredLamps.get() ? null : BLOCKS.register(name, () -> new RedstoneLampBlock(Block.Properties.copy(Blocks.REDSTONE_LAMP)));
                    case INVERTED_REDSTONE_LAMP -> !Config.registerColoredLamps.get() ? null : BLOCKS.register(name, InvertedRedstoneLampBlock::new);
                    default -> null;
                };
    }

    private static RegistryObject<Block> setupLampPost(String name, Block.Properties properties)
    {
        return BLOCKS.register(name, () -> new BlockLampPostCap(properties.isValidSpawn(ModBlocks::neverAllowSpawn)));
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

    private static Boolean neverAllowSpawn(BlockState state, BlockGetter reader, BlockPos pos, EntityType<?> entity)
    {
        return false;
    }

    private static ToIntFunction<BlockState> getLightValueLit(int lightValue)
    {
        return (state) -> state.getValue(BlockStateProperties.LIT) ? lightValue : 0;
    }
}
