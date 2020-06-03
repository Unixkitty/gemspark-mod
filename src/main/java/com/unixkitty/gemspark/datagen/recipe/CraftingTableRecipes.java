package com.unixkitty.gemspark.datagen.recipe;

import com.unixkitty.gemspark.Config;
import com.unixkitty.gemspark.Gemspark;
import com.unixkitty.gemspark.init.ModBlocks;
import com.unixkitty.gemspark.item.Gem;
import com.unixkitty.gemspark.item.GemItems;
import com.unixkitty.gemspork.lib.HelperUtil;
import com.unixkitty.gemspork.lib.datagen.recipe.CraftingTableRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

public class CraftingTableRecipes extends CraftingTableRecipeProvider
{
    public CraftingTableRecipes(DataGenerator generator)
    {
        super(Gemspark.MODID, generator);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer)
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
    }

    private void registerColoredLamp(Consumer<IFinishedRecipe> consumer, boolean inverted)
    {
        IItemProvider output;
        Ingredient dustOrTorchIngredient;

        for (DyeColor color : DyeColor.values())
        {
            output = GemItems.coloredLampFromDye(color, inverted);
            dustOrTorchIngredient = (inverted ? Ingredient.fromItems(Blocks.REDSTONE_TORCH) : Ingredient.fromTag(Tags.Items.DUSTS_REDSTONE));

            ShapedRecipeBuilder.shapedRecipe(output)
                    .key('g', Tags.Items.DUSTS_GLOWSTONE)
                    .key('P', new ItemTags.Wrapper(new ResourceLocation("forge", "glass_panes/" + color.toString())))
                    .key('R', dustOrTorchIngredient)
                    .patternLine("PgP")
                    .patternLine("PgP")
                    .patternLine("PRP")
                    .addCriterion("has_item", hasItem(Tags.Items.DUSTS_REDSTONE))
                    .build(consumer);
        }
    }

    private void registerUniqueRecipes(Consumer<IFinishedRecipe> consumer)
    {
        //Pedestal
        ShapedRecipeBuilder.shapedRecipe(ModBlocks.QUARTZ_PEDESTAL.get())
                .key('s', Blocks.QUARTZ_SLAB)
                .key('p', Blocks.QUARTZ_PILLAR)
                .patternLine("s")
                .patternLine("p")
                .addCriterion("has_item", hasItem(Tags.Items.GEMS_QUARTZ))
                .build(consumer);
    }

    private void registerLantern(Consumer<IFinishedRecipe> consumer, Tag<Item> gemIngredient)
    {
        IItemProvider output = HelperUtil.itemFromMaterialTag(gemIngredient, Gemspark.MODID, "lantern");

        ShapedRecipeBuilder.shapedRecipe(output, Config.GEMLANTERNSFROMCRAFT)
                .key('g', gemIngredient)
                .key('d', Tags.Items.DUSTS_GLOWSTONE)
                .key('G', Tags.Items.GLASS_COLORLESS)
                .patternLine("gdg")
                .patternLine("dGd")
                .patternLine("gdg")
                .addCriterion("has_item", hasItem(gemIngredient))
                .build(consumer);
    }

    private void registerLampPostCap(Consumer<IFinishedRecipe> consumer, Block lampPostCap, Block fence)
    {
        ShapedRecipeBuilder.shapedRecipe(lampPostCap)
                .key('i', Tags.Items.INGOTS_IRON)
                .key('F', fence)
                .patternLine("ii ")
                .patternLine("iF ")
                .patternLine("  i")
                .addCriterion("has_item", hasItem(fence))
                .build(consumer);
    }
}
