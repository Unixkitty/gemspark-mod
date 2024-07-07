package com.unixkitty.gemspark.init;

import com.unixkitty.gemspark.Gemspark;
import com.unixkitty.gemspark.block.*;
import net.minecraft.core.BlockPos;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;
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

    public static final RegistryObject<Block> EMERALD_GLASS = setup(ModBlockType.GLASS, "emerald_glass");
    public static final RegistryObject<Block> DIAMOND_GLASS = setup(ModBlockType.GLASS, "diamond_glass");
    public static final RegistryObject<Block> TANZANITE_GLASS = setup(ModBlockType.GLASS, "tanzanite_glass");
    public static final RegistryObject<Block> TOPAZ_GLASS = setup(ModBlockType.GLASS, "topaz_glass");
    public static final RegistryObject<Block> SAPPHIRE_GLASS = setup(ModBlockType.GLASS, "sapphire_glass");
    public static final RegistryObject<Block> PINK_SAPPHIRE_GLASS = setup(ModBlockType.GLASS, "pink_sapphire_glass");
    public static final RegistryObject<Block> RUBY_GLASS = setup(ModBlockType.GLASS, "ruby_glass");

    public static final RegistryObject<Block> EMERALD_GLASS_PANE = setup(ModBlockType.GLASS_PANE, "emerald_glass_pane");
    public static final RegistryObject<Block> DIAMOND_GLASS_PANE = setup(ModBlockType.GLASS_PANE, "diamond_glass_pane");
    public static final RegistryObject<Block> TANZANITE_GLASS_PANE = setup(ModBlockType.GLASS_PANE, "tanzanite_glass_pane");
    public static final RegistryObject<Block> TOPAZ_GLASS_PANE = setup(ModBlockType.GLASS_PANE, "topaz_glass_pane");
    public static final RegistryObject<Block> SAPPHIRE_GLASS_PANE = setup(ModBlockType.GLASS_PANE, "sapphire_glass_pane");
    public static final RegistryObject<Block> PINK_SAPPHIRE_GLASS_PANE = setup(ModBlockType.GLASS_PANE, "pink_sapphire_glass_pane");
    public static final RegistryObject<Block> RUBY_GLASS_PANE = setup(ModBlockType.GLASS_PANE, "ruby_glass_pane");

    public static final RegistryObject<Block> EMERALD_GLOWING_GLASS = setup(ModBlockType.GLOWING_GLASS, "emerald_glowing_glass");
    public static final RegistryObject<Block> DIAMOND_GLOWING_GLASS = setup(ModBlockType.GLOWING_GLASS, "diamond_glowing_glass");
    public static final RegistryObject<Block> TANZANITE_GLOWING_GLASS = setup(ModBlockType.GLOWING_GLASS, "tanzanite_glowing_glass");
    public static final RegistryObject<Block> TOPAZ_GLOWING_GLASS = setup(ModBlockType.GLOWING_GLASS, "topaz_glowing_glass");
    public static final RegistryObject<Block> SAPPHIRE_GLOWING_GLASS = setup(ModBlockType.GLOWING_GLASS, "sapphire_glowing_glass");
    public static final RegistryObject<Block> PINK_SAPPHIRE_GLOWING_GLASS = setup(ModBlockType.GLOWING_GLASS, "pink_sapphire_glowing_glass");
    public static final RegistryObject<Block> RUBY_GLOWING_GLASS = setup(ModBlockType.GLOWING_GLASS, "ruby_glowing_glass");

    public static final RegistryObject<Block> EMERALD_GLOWING_GLASS_PANE = setup(ModBlockType.GLOWING_GLASS_PANE, "emerald_glowing_glass_pane");
    public static final RegistryObject<Block> DIAMOND_GLOWING_GLASS_PANE = setup(ModBlockType.GLOWING_GLASS_PANE, "diamond_glowing_glass_pane");
    public static final RegistryObject<Block> TANZANITE_GLOWING_GLASS_PANE = setup(ModBlockType.GLOWING_GLASS_PANE, "tanzanite_glowing_glass_pane");
    public static final RegistryObject<Block> TOPAZ_GLOWING_GLASS_PANE = setup(ModBlockType.GLOWING_GLASS_PANE, "topaz_glowing_glass_pane");
    public static final RegistryObject<Block> SAPPHIRE_GLOWING_GLASS_PANE = setup(ModBlockType.GLOWING_GLASS_PANE, "sapphire_glowing_glass_pane");
    public static final RegistryObject<Block> PINK_SAPPHIRE_GLOWING_GLASS_PANE = setup(ModBlockType.GLOWING_GLASS_PANE, "pink_sapphire_glowing_glass_pane");
    public static final RegistryObject<Block> RUBY_GLOWING_GLASS_PANE = setup(ModBlockType.GLOWING_GLASS_PANE, "ruby_glowing_glass_pane");

    public static final RegistryObject<Block> TANZANITE_ORE = setup(ModBlockType.ORE, "tanzanite_ore");
    public static final RegistryObject<Block> TOPAZ_ORE = setup(ModBlockType.ORE, "topaz_ore");
    public static final RegistryObject<Block> SAPPHIRE_ORE = setup(ModBlockType.ORE, "sapphire_ore");
    public static final RegistryObject<Block> PINK_SAPPHIRE_ORE = setup(ModBlockType.ORE, "pink_sapphire_ore");
    public static final RegistryObject<Block> RUBY_ORE = setup(ModBlockType.ORE, "ruby_ore");

    public static final RegistryObject<Block> DEEPSLATE_TANZANITE_ORE = setup(ModBlockType.DEEPSLATE_ORE, "deepslate_tanzanite_ore");
    public static final RegistryObject<Block> DEEPSLATE_TOPAZ_ORE = setup(ModBlockType.DEEPSLATE_ORE, "deepslate_topaz_ore");
    public static final RegistryObject<Block> DEEPSLATE_SAPPHIRE_ORE = setup(ModBlockType.DEEPSLATE_ORE, "deepslate_sapphire_ore");
    public static final RegistryObject<Block> DEEPSLATE_RUBY_ORE = setup(ModBlockType.DEEPSLATE_ORE, "deepslate_ruby_ore");

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
    public static final RegistryObject<Block> LAMP_POST_CAP_CHERRY = setupLampPost("lamp_post_cap_cherry", Block.Properties.copy(Blocks.CHERRY_FENCE));
    public static final RegistryObject<Block> LAMP_POST_CAP_MANGROVE = setupLampPost("lamp_post_cap_mangrove", Block.Properties.copy(Blocks.MANGROVE_FENCE));

    public static final RegistryObject<Block> WOOD_GOLEM_RELIC = register("wood_golem_relic", () -> new BlockWoodGolem(Block.Properties.copy(Blocks.SPRUCE_PLANKS).isValidSpawn(ModBlocks::neverAllowSpawn)));

    public static final RegistryObject<Block> BRAZIER = register("brazier", () -> new BlockBrazier(1, Block.Properties.copy(Blocks.IRON_BARS).lightLevel(getLightValueLit(15)).noOcclusion()));
    public static final RegistryObject<Block> SOUL_BRAZIER = register("soul_brazier", () -> new BlockBrazier(2, Block.Properties.copy(Blocks.IRON_BARS).lightLevel(getLightValueLit(10)).noOcclusion()));

    public static final RegistryObject<Block> ROCKY_DIRT = register("rocky_dirt", () -> new Block(Block.Properties.copy(Blocks.DIRT)));
    public static final RegistryObject<Block> ROCKY_GRASSY_DIRT = register("rocky_grassy_dirt", () -> new Block(Block.Properties.copy(Blocks.COARSE_DIRT)));
    public static final RegistryObject<Block> DARK_ROCKY_DIRT = register("dark_rocky_dirt", () -> new Block(Block.Properties.copy(Blocks.GRAVEL)));

    public static final RegistryObject<Block> STONE_FLOOR_TILE = register("stone_floor_tile", () -> new Block(Block.Properties.copy(Blocks.SMOOTH_STONE)));
    public static final RegistryObject<Block> STONE_TILES = register("stone_tiles", () -> new Block(Block.Properties.copy(Blocks.SMOOTH_STONE)));
    public static final RegistryObject<Block> SMOKED_STONE = register("smoked_stone", () -> new Block(Block.Properties.copy(Blocks.SMOOTH_STONE)));
    public static final RegistryObject<Block> SMOKED_STONE_CTM = register("smoked_stone_ctm", () -> new Block(Block.Properties.copy(Blocks.SMOOTH_STONE)));
    public static final RegistryObject<Block> METAL_FRAMED_STONE = register("metal_framed_stone", () -> new Block(Block.Properties.copy(Blocks.SMOOTH_STONE)));
    public static final RegistryObject<Block> METAL_FRAMED_STONE_CTM = register("metal_framed_stone_ctm", () -> new Block(Block.Properties.copy(Blocks.SMOOTH_STONE)));
    public static final RegistryObject<Block> ACCENTUATED_STONE = register("accentuated_stone", () -> new Block(Block.Properties.copy(Blocks.SMOOTH_STONE)));
    public static final RegistryObject<Block> ACCENTUATED_STONE_CTM = register("accentuated_stone_ctm", () -> new Block(Block.Properties.copy(Blocks.SMOOTH_STONE)));

    public static final RegistryObject<Block> LIGHT_RAINBOW_BRICKS = register("light_rainbow_bricks", () -> new Block(Block.Properties.copy(Blocks.BRICKS)));
    public static final RegistryObject<Block> DARK_RAINBOW_BRICKS = register("dark_rainbow_bricks", () -> new Block(Block.Properties.copy(Blocks.BRICKS)));

    private static RegistryObject<Block> setup(ModBlockType blockType, String name)
    {
        return switch (blockType)
        {
            case GEM_BLOCK -> register(name, () -> new Block(Block.Properties.copy(Blocks.DIAMOND_BLOCK)));
            case LANTERN -> register(name, () -> new Block(Block.Properties.copy(Blocks.GLOWSTONE)));
            case GLASS -> register(name, () -> new GlassBlock(gemGlassProperties(name)));
            case GLOWING_GLASS ->
                    register(name, () -> new GlassBlock(gemGlassProperties(name).lightLevel(level -> 12)));
            case GLASS_PANE -> register(name, () -> new IronBarsBlock(gemGlassProperties(name)));
            case GLOWING_GLASS_PANE ->
                    register(name, () -> new IronBarsBlock(gemGlassProperties(name).lightLevel(level -> 12)));
            case GEMSPARK ->
                    register(name, () -> new Block(Block.Properties.copy(Blocks.GLOWSTONE).lightLevel(value -> 9).requiresCorrectToolForDrops()));
            case ORE ->
                    register(name, () -> new DropExperienceBlock(Block.Properties.copy(Blocks.DIAMOND_ORE), UniformInt.of(3, 7)));
            case DEEPSLATE_ORE ->
                    register(name, () -> new DropExperienceBlock(Block.Properties.copy(Blocks.DEEPSLATE_DIAMOND_ORE), UniformInt.of(3, 7)));
            case PEDESTAL ->
                    register(name, () -> new BlockPedestal(Block.Properties.copy(Blocks.QUARTZ_BLOCK).noOcclusion().isValidSpawn(ModBlocks::neverAllowSpawn)));
            case REDSTONE_LAMP ->
                    register(name, () -> new RedstoneLampBlock(Block.Properties.copy(Blocks.REDSTONE_LAMP)));
            case INVERTED_REDSTONE_LAMP -> register(name, BlockColoredRedstoneLamp::new);
        };
    }

    private static RegistryObject<Block> register(String name, Supplier<? extends Block> supplier)
    {
        RegistryObject<Block> block = BLOCKS.register(name, supplier);
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }

    private static RegistryObject<Block> setupLampPost(String name, Block.Properties properties)
    {
        return register(name, () -> new BlockLampPostCap(properties.isValidSpawn(ModBlocks::neverAllowSpawn)));
    }

    private static Block.Properties gemGlassProperties(String name)
    {
        return Block.Properties.of()
                .requiresCorrectToolForDrops()
                .sound(SoundType.METAL)
                .sound(SoundType.GLASS)
                .noOcclusion()
                .isValidSpawn(ModBlocks::neverAllowSpawn)
                .isRedstoneConductor(ModBlocks::never)
                .isSuffocating(ModBlocks::never)
                .isViewBlocking(ModBlocks::never)
                .strength((name.contains("diamond") || name.contains("ruby")) ? 3.0F : 1.5F, name.contains("diamond") ? 1200F : name.contains("ruby") ? 800F : 600F);
    }

    private enum ModBlockType
    {
        GEM_BLOCK,
        LANTERN,
        GLASS,
        GLOWING_GLASS,
        GLASS_PANE,
        GLOWING_GLASS_PANE,
        GEMSPARK,
        ORE,
        DEEPSLATE_ORE,
        PEDESTAL,
        REDSTONE_LAMP,
        INVERTED_REDSTONE_LAMP
    }

    //Mojank pls
    private static Boolean neverAllowSpawn(BlockState state, BlockGetter reader, BlockPos pos, EntityType<?> entity)
    {
        return false;
    }

    //Mojank pls
    private static boolean never(BlockState state, BlockGetter reader, BlockPos pos)
    {
        return false;
    }

    private static ToIntFunction<BlockState> getLightValueLit(int lightValue)
    {
        return (state) -> state.getValue(BlockStateProperties.LIT) ? lightValue : 0;
    }
}
