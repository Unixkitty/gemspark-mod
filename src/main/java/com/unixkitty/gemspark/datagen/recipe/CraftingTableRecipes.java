package com.unixkitty.gemspark.datagen.recipe;

import com.unixkitty.gemspark.Config;
import com.unixkitty.gemspark.Gemspark;
import com.unixkitty.gemspark.init.ModBlocks;
import com.unixkitty.gemspark.init.ModItems;
import com.unixkitty.gemspark.item.Gem;
import com.unixkitty.gemspark.item.GemItems;
import com.unixkitty.gemspark.util.HelperUtil;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

public class CraftingTableRecipes extends RecipeProvider
{
    public CraftingTableRecipes(DataGenerator generator)
    {
        super(generator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer)
    {
        registerSimpleArmorSet(consumer, Gem.TANZANITE.getItemTag());
        registerSimpleArmorSet(consumer, Gem.TOPAZ.getItemTag());
        registerSimpleArmorSet(consumer, Gem.SAPPHIRE.getItemTag());
        registerSimpleArmorSet(consumer, Gem.PINK_SAPPHIRE.getItemTag());
        registerSimpleArmorSet(consumer, Gem.RUBY.getItemTag());

        registerToolSetRecipes(consumer, Gem.TANZANITE.getItemTag());
        registerToolSetRecipes(consumer, Gem.TOPAZ.getItemTag());
        registerToolSetRecipes(consumer, Gem.SAPPHIRE.getItemTag());
        registerToolSetRecipes(consumer, Gem.PINK_SAPPHIRE.getItemTag());
        registerToolSetRecipes(consumer, Gem.RUBY.getItemTag());

        registerCompression(consumer, Gem.TANZANITE.getItemTag());
        registerCompression(consumer, Gem.TOPAZ.getItemTag());
        registerCompression(consumer, Gem.SAPPHIRE.getItemTag());
        registerCompression(consumer, Gem.PINK_SAPPHIRE.getItemTag());
        registerCompression(consumer, Gem.RUBY.getItemTag());

        registerLantern(consumer, Gem.TANZANITE.getItemTag());
        registerLantern(consumer, Gem.TOPAZ.getItemTag());
        registerLantern(consumer, Gem.SAPPHIRE.getItemTag());
        registerLantern(consumer, Gem.PINK_SAPPHIRE.getItemTag());
        registerLantern(consumer, Gem.RUBY.getItemTag());
        registerLantern(consumer, Tags.Items.GEMS_EMERALD);
        registerLantern(consumer, Tags.Items.GEMS_DIAMOND);

        registerUniqueRecipes(consumer);

        registerColoredLamp(consumer, false);
        registerColoredLamp(consumer, true);

        registerLampPostCap(consumer, ModBlocks.LAMP_POST_CAP_OAK.get(), Blocks.OAK_FENCE);
        registerLampPostCap(consumer, ModBlocks.LAMP_POST_CAP_NETHER_BRICK.get(), Blocks.NETHER_BRICK_FENCE);
        registerLampPostCap(consumer, ModBlocks.LAMP_POST_CAP_SPRUCE.get(), Blocks.SPRUCE_FENCE);
        registerLampPostCap(consumer, ModBlocks.LAMP_POST_CAP_BIRCH.get(), Blocks.BIRCH_FENCE);
        registerLampPostCap(consumer, ModBlocks.LAMP_POST_CAP_JUNGLE.get(), Blocks.JUNGLE_FENCE);
        registerLampPostCap(consumer, ModBlocks.LAMP_POST_CAP_ACACIA.get(), Blocks.ACACIA_FENCE);
        registerLampPostCap(consumer, ModBlocks.LAMP_POST_CAP_DARK_OAK.get(), Blocks.DARK_OAK_FENCE);
        registerLampPostCap(consumer, ModBlocks.LAMP_POST_CAP_WARPED.get(), Blocks.WARPED_FENCE);
        registerLampPostCap(consumer, ModBlocks.LAMP_POST_CAP_CRIMSON.get(), Blocks.CRIMSON_FENCE);
    }

    private void registerColoredLamp(Consumer<FinishedRecipe> consumer, boolean inverted)
    {
        ItemLike output;
        Ingredient dustOrTorchIngredient;

        for (DyeColor color : DyeColor.values())
        {
            output = GemItems.coloredLampFromDye(color, inverted);
            dustOrTorchIngredient = (inverted ? Ingredient.of(Blocks.REDSTONE_TORCH) : Ingredient.of(Tags.Items.DUSTS_REDSTONE));

            ShapedRecipeBuilder.shaped(output)
                    .define('g', Tags.Items.DUSTS_GLOWSTONE)
                    .define('P', ItemTags.bind("forge" + ":" + "glass_panes/" + color))
                    .define('R', dustOrTorchIngredient)
                    .pattern("PgP")
                    .pattern("PgP")
                    .pattern("PRP")
                    .unlockedBy("has_item", has(Tags.Items.DUSTS_REDSTONE))
                    .save(consumer);
        }
    }

    private void registerUniqueRecipes(Consumer<FinishedRecipe> consumer)
    {
        //Stone Tiles
        ShapedRecipeBuilder.shaped(ModBlocks.STONE_TILES.get(), 4)
                .define('S', Blocks.SMOOTH_STONE)
                .pattern("SS")
                .pattern("SS")
                .unlockedBy("has_item", has(Blocks.SMOOTH_STONE))
                .save(consumer);

        //Stone Floor Tile
        ShapedRecipeBuilder.shaped(ModBlocks.STONE_FLOOR_TILE.get())
                .define('S', Blocks.SMOOTH_STONE)
                .define('s', Blocks.SMOOTH_STONE_SLAB)
                .pattern("sS")
                .pattern("Ss")
                .unlockedBy("has_item", has(Blocks.SMOOTH_STONE))
                .save(consumer);

        //Rocky Grassy Dirt
        ShapedRecipeBuilder.shaped(ModBlocks.ROCKY_GRASSY_DIRT.get(), 4)
                .define('c', Tags.Items.COBBLESTONE)
                .define('d', Blocks.DIRT)
                .pattern("dd")
                .pattern("cd")
                .unlockedBy("has_item", has(Blocks.DIRT))
                .save(consumer);

        //Rocky Dirt
        ShapedRecipeBuilder.shaped(ModBlocks.ROCKY_DIRT.get(), 4)
                .define('c', Tags.Items.COBBLESTONE)
                .define('d', Blocks.DIRT)
                .pattern("cd")
                .pattern("dc")
                .unlockedBy("has_item", has(Blocks.DIRT))
                .save(consumer);

        //Dark Rocky Dirt
        ShapedRecipeBuilder.shaped(ModBlocks.DARK_ROCKY_DIRT.get(), 4)
                .define('c', Tags.Items.COBBLESTONE)
                .define('d', Blocks.DIRT)
                .pattern("cd")
                .pattern("cc")
                .unlockedBy("has_item", has(Blocks.DIRT))
                .save(consumer);

        //Soul Brazier
        ShapedRecipeBuilder.shaped(ModBlocks.SOUL_BRAZIER.get())
                .define('b', Blocks.IRON_BARS)
                .define('s', ItemTags.SOUL_FIRE_BASE_BLOCKS)
                .define('i', Tags.Items.INGOTS_IRON)
                .pattern("bsb")
                .pattern(" i ")
                .pattern("i i")
                .unlockedBy("has_item", has(Tags.Items.INGOTS_IRON))
                .save(consumer);

        //Brazier
        ShapedRecipeBuilder.shaped(ModBlocks.BRAZIER.get())
                .define('b', Blocks.IRON_BARS)
                .define('c', ItemTags.COALS)
                .define('i', Tags.Items.INGOTS_IRON)
                .pattern("bcb")
                .pattern(" i ")
                .pattern("i i")
                .unlockedBy("has_item", has(Tags.Items.INGOTS_IRON))
                .save(consumer);

        //Tiara
        ShapedRecipeBuilder.shaped(ModItems.TIARA.get())
                .define('t', Gem.TANZANITE.getItemTag())
                .define('c', ModItems.COSMETIC_CLAY.get())
                .define('g', Tags.Items.NUGGETS_GOLD)
                .pattern("ggg")
                .pattern("gcg")
                .pattern("ttt")
                .unlockedBy("has_item", has(ModItems.TANZANITE.get()))
                .save(consumer);

        //Spitfire Cap
        ShapedRecipeBuilder.shaped(ModItems.SPITFIRECAP.get())
                .define('l', Items.LEATHER)
                .define('c', ModItems.COSMETIC_CLAY.get())
                .define('g', Tags.Items.NUGGETS_GOLD)
                .pattern("lll")
                .pattern("lcl")
                .pattern("  g")
                .unlockedBy("has_item", has(ModItems.COSMETIC_CLAY.get()))
                .save(consumer);

        //Pink Ribbon
        ShapedRecipeBuilder.shaped(ModItems.REDBACKRIBBON.get())
                .define('w', Blocks.PINK_WOOL)
                .define('c', ModItems.COSMETIC_CLAY.get())
                .pattern("w w")
                .pattern("wcw")
                .unlockedBy("has_item", has(ModItems.COSMETIC_CLAY.get()))
                .save(consumer);

        //Headphones
        ShapedRecipeBuilder.shaped(ModItems.HEADPHONES.get())
                .define('w', Blocks.WHITE_WOOL)
                .define('c', ModItems.COSMETIC_CLAY.get())
                .define('b', Blocks.BLACK_WOOL)
                .pattern("www")
                .pattern("bcb")
                .unlockedBy("has_item", has(ModItems.COSMETIC_CLAY.get()))
                .save(consumer);

        //Straw Hat
        ShapedRecipeBuilder.shaped(ModItems.FARMER_HAT.get())
                .define('w', Items.WHEAT)
                .define('c', ModItems.COSMETIC_CLAY.get())
                .pattern("www")
                .pattern("wcw")
                .pattern("www")
                .unlockedBy("has_item", has(ModItems.COSMETIC_CLAY.get()))
                .save(consumer);

        //False Halo
        ShapedRecipeBuilder.shaped(ModItems.FALSE_HALO.get())
                .define('g', Tags.Items.INGOTS_GOLD)
                .define('c', ModItems.COSMETIC_CLAY.get())
                .pattern(" g ")
                .pattern("gcg")
                .pattern(" g ")
                .unlockedBy("has_item", has(ModItems.COSMETIC_CLAY.get()))
                .save(consumer);

        //Bunny Ears
        ShapedRecipeBuilder.shaped(ModItems.BUNNYBAND.get())
                .define('w', Blocks.WHITE_WOOL)
                .define('c', ModItems.COSMETIC_CLAY.get())
                .define('r', Items.RABBIT_HIDE)
                .pattern("w w")
                .pattern(" c ")
                .pattern(" r ")
                .unlockedBy("has_item", has(Items.RABBIT_HIDE))
                .save(consumer);

        //Witch Hat
        ShapedRecipeBuilder.shaped(ModItems.WITCH_HAT.get())
                .define('s', Tags.Items.STRING)
                .define('t', Gem.TANZANITE.getItemTag())
                .define('b', Blocks.BLACK_WOOL)
                .define('c', ModItems.COSMETIC_CLAY.get())
                .define('p', Blocks.PURPLE_WOOL)
                .pattern(" st")
                .pattern("bc ")
                .pattern("pp ")
                .unlockedBy("has_item", has(Items.STICK))
                .save(consumer);

        //Cosmetic Clay
        ShapelessRecipeBuilder.shapeless(ModItems.COSMETIC_CLAY.get(), 4)
                .requires(Items.CLAY_BALL)
                .requires(Tags.Items.DYES_RED)
                .requires(Tags.Items.DYES_GREEN)
                .requires(Tags.Items.DYES_BLUE)
                .requires(Gem.TANZANITE.getItemTag())
                .unlockedBy("has_clay", has(Items.CLAY))
                .save(consumer);

        //Red glasses
        ShapedRecipeBuilder.shaped(ModItems.GLASSES_RED.get())
                .define('s', Gem.RUBY.getItemTag())
                .define('P', Tags.Items.GLASS_PANES_COLORLESS)
                .pattern(" s ")
                .pattern("P P")
                .unlockedBy("has_item", has(Gem.RUBY.getItemTag()))
                .save(consumer);

        //Wood Golem
        ShapedRecipeBuilder.shaped(ModBlocks.WOOD_GOLEM_RELIC.get())
                .define('s', Items.STICK)
                .define('p', Blocks.SPRUCE_PLANKS)
                .define('c', ModItems.COSMETIC_CLAY.get())
                .pattern(" p ")
                .pattern("sps")
                .pattern("scs")
                .unlockedBy("has_item", has(ModItems.COSMETIC_CLAY.get()))
                .save(consumer);

        //Quartz Pedestal
        ShapedRecipeBuilder.shaped(ModBlocks.QUARTZ_PEDESTAL.get())
                .define('s', Blocks.QUARTZ_SLAB)
                .define('p', Blocks.QUARTZ_PILLAR)
                .pattern("s")
                .pattern("p")
                .unlockedBy("has_item", has(Tags.Items.GEMS_QUARTZ))
                .save(consumer);

        //Blackstone Pedestal
        ShapedRecipeBuilder.shaped(ModBlocks.BLACKSTONE_PEDESTAL.get())
                .define('s', Blocks.BLACKSTONE_SLAB)
                .define('p', Blocks.POLISHED_BLACKSTONE)
                .pattern("s")
                .pattern("p")
                .unlockedBy("has_item", has(Items.BLACKSTONE))
                .save(consumer);

        //Spectacles
        ShapedRecipeBuilder.shaped(ModItems.SPECTACLES.get())
                .define('s', Gem.SAPPHIRE.getItemTag())
                .define('P', Tags.Items.GLASS_PANES_COLORLESS)
                .pattern(" s ")
                .pattern("P P")
                .unlockedBy("has_item", has(Gem.SAPPHIRE.getItemTag()))
                .save(consumer);

        //Technicolor glasses
        ShapedRecipeBuilder.shaped(ModItems.GLASSES_TECHNICOLOR.get())
                .define('r', Gem.RUBY.getItemTag())
                .define('g', Tags.Items.GEMS_EMERALD)
                .define('b', Gem.SAPPHIRE.getItemTag())
                .define('R', Tags.Items.GLASS_PANES_CYAN)
                .define('L', Tags.Items.GLASS_PANES_YELLOW)
                .pattern("rgb")
                .pattern("R L")
                .unlockedBy("has_item", has(Tags.Items.GEMS_EMERALD))
                .save(consumer);

        //3D glasses
        ShapedRecipeBuilder.shaped(ModItems.GLASSES_3D.get())
                .define('p', Ingredient.of(Items.PAPER))
                .define('R', Tags.Items.GLASS_PANES_BLUE)
                .define('L', Tags.Items.GLASS_PANES_RED)
                .pattern("ppp")
                .pattern("R L")
                .unlockedBy("has_item", has(Tags.Items.GLASS_PANES_BLUE))
                .save(consumer);
    }

    private void registerLantern(Consumer<FinishedRecipe> consumer, Tag.Named<Item> gemIngredient)
    {
        ItemLike output = HelperUtil.itemFromMaterialTag(gemIngredient, Gemspark.MODID, "lantern");

        ShapedRecipeBuilder.shaped(output, Config.GEMLANTERNSFROMCRAFT)
                .define('g', gemIngredient)
                .define('d', Tags.Items.DUSTS_GLOWSTONE)
                .define('G', Tags.Items.GLASS_COLORLESS)
                .pattern("gdg")
                .pattern("dGd")
                .pattern("gdg")
                .unlockedBy("has_item", has(gemIngredient))
                .save(consumer);
    }

    private void registerLampPostCap(Consumer<FinishedRecipe> consumer, Block lampPostCap, Block fence)
    {
        ShapedRecipeBuilder.shaped(lampPostCap)
                .define('i', Tags.Items.NUGGETS_IRON)
                .define('F', fence)
                .pattern("ii ")
                .pattern("iF ")
                .pattern("  i")
                .unlockedBy("has_item", has(fence))
                .save(consumer);
    }

    protected void registerCompression(Consumer<FinishedRecipe> consumer, Tag.Named<Item> ingredient)
    {
        ItemLike output = HelperUtil.itemFromMaterialTag(ingredient, Gemspark.MODID, "block");

        ShapedRecipeBuilder.shaped(output)
                .define('I', Ingredient.of(ingredient))
                .pattern("III")
                .pattern("III")
                .pattern("III")
                .unlockedBy("has_item", has(ingredient))
                .save(consumer);

        //Decompression
        ItemLike output2 = HelperUtil.itemFromTag(Gemspark.MODID, ingredient);
        ShapelessRecipeBuilder.shapeless(output2, 9)
                .unlockedBy("has_item", has(output2))
                .requires(output)
                .save(consumer);
    }

    protected void registerToolSetRecipes(Consumer<FinishedRecipe> consumer, Tag.Named<Item> ingredient)
    {
        CriterionTriggerInstance criterion = has(ingredient);

        Item axe = HelperUtil.itemFromMaterialTag(ingredient, Gemspark.MODID, "axe");
        Item sword = HelperUtil.itemFromMaterialTag(ingredient, Gemspark.MODID, "sword");
        Item shovel = HelperUtil.itemFromMaterialTag(ingredient, Gemspark.MODID, "shovel");
        Item pickaxe = HelperUtil.itemFromMaterialTag(ingredient, Gemspark.MODID, "pickaxe");
        Item hoe = HelperUtil.itemFromMaterialTag(ingredient, Gemspark.MODID, "hoe");

        ShapedRecipeBuilder.shaped(pickaxe)
                .define('S', ingredient)
                .define('T', Tags.Items.RODS_WOODEN)
                .pattern("SSS")
                .pattern(" T ")
                .pattern(" T ")
                .unlockedBy("has_item", criterion)
                .save(consumer);
        ShapedRecipeBuilder.shaped(shovel)
                .define('S', ingredient)
                .define('T', Tags.Items.RODS_WOODEN)
                .pattern("S")
                .pattern("T")
                .pattern("T")
                .unlockedBy("has_item", criterion)
                .save(consumer);
        ShapedRecipeBuilder.shaped(axe)
                .define('S', ingredient)
                .define('T', Tags.Items.RODS_WOODEN)
                .pattern("SS")
                .pattern("TS")
                .pattern("T ")
                .unlockedBy("has_item", criterion)
                .save(consumer);
        ShapedRecipeBuilder.shaped(sword)
                .define('S', ingredient)
                .define('T', Tags.Items.RODS_WOODEN)
                .pattern("S")
                .pattern("S")
                .pattern("T")
                .unlockedBy("has_item", criterion)
                .save(consumer);
        ShapedRecipeBuilder.shaped(hoe)
                .define('S', ingredient)
                .define('T', Tags.Items.RODS_WOODEN)
                .pattern("SS")
                .pattern(" T")
                .pattern(" T")
                .unlockedBy("has_item", criterion)
                .save(consumer);
    }

    protected void registerSimpleArmorSet(Consumer<FinishedRecipe> consumer, Tag.Named<Item> ingredient)
    {
        CriterionTriggerInstance criterion = has(ingredient);

        Item helmet = HelperUtil.armorItemFromMaterialResource(ingredient, EquipmentSlot.HEAD, Gemspark.MODID);
        Item chestplate = HelperUtil.armorItemFromMaterialResource(ingredient, EquipmentSlot.CHEST, Gemspark.MODID);
        Item leggings = HelperUtil.armorItemFromMaterialResource(ingredient, EquipmentSlot.LEGS, Gemspark.MODID);
        Item boots = HelperUtil.armorItemFromMaterialResource(ingredient, EquipmentSlot.FEET, Gemspark.MODID);

        ShapedRecipeBuilder.shaped(helmet)
                .define('S', ingredient)
                .pattern("SSS")
                .pattern("S S")
                .unlockedBy("has_item", criterion)
                .save(consumer);
        ShapedRecipeBuilder.shaped(chestplate)
                .define('S', ingredient)
                .pattern("S S")
                .pattern("SSS")
                .pattern("SSS")
                .unlockedBy("has_item", criterion)
                .save(consumer);
        ShapedRecipeBuilder.shaped(leggings)
                .define('S', ingredient)
                .pattern("SSS")
                .pattern("S S")
                .pattern("S S")
                .unlockedBy("has_item", criterion)
                .save(consumer);
        ShapedRecipeBuilder.shaped(boots)
                .define('S', ingredient)
                .pattern("S S")
                .pattern("S S")
                .unlockedBy("has_item", criterion)
                .save(consumer);
    }

    @Override
    public String getName()
    {
        return Gemspark.MODID + " " + this.getClass().getSimpleName();
    }
}
