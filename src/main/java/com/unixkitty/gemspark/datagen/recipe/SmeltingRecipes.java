package com.unixkitty.gemspark.datagen.recipe;

import com.unixkitty.gemspark.Gemspark;
import com.unixkitty.gemspark.init.ModBlocks;
import com.unixkitty.gemspark.init.ModItems;
import com.unixkitty.gemspark.item.Gem;
import com.unixkitty.gemspark.util.HelperUtil;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;

import java.util.function.Consumer;

public class SmeltingRecipes extends RecipeProvider
{
    public SmeltingRecipes(DataGenerator generatorIn)
    {
        super(generatorIn);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer)
    {
        addBasicOreCooking(consumer, ModBlocks.TANZANITE_ORE.get(), ModItems.TANZANITE.get(), Gem.TANZANITE.toString());
        addBasicOreCooking(consumer, ModBlocks.TOPAZ_ORE.get(), ModItems.TOPAZ.get(), Gem.TOPAZ.toString());
        addBasicOreCooking(consumer, ModBlocks.SAPPHIRE_ORE.get(), ModItems.SAPPHIRE.get(), Gem.SAPPHIRE.toString());
        addBasicOreCooking(consumer, ModBlocks.PINK_SAPPHIRE_ORE.get(), ModItems.PINK_SAPPHIRE.get(), Gem.PINK_SAPPHIRE.toString());
        addBasicOreCooking(consumer, ModBlocks.RUBY_ORE.get(), ModItems.RUBY.get(), Gem.RUBY.toString());

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Blocks.SMOOTH_STONE), ModBlocks.SMOKED_STONE.get(), 0.1F, 200).unlockedBy("has_item", has(Blocks.SMOOTH_STONE)).save(consumer);
    }

    protected void addBasicOreCooking(Consumer<FinishedRecipe> consumer, ItemLike input, ItemLike result, String name)
    {
        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(input),
                        result,
                        1.0F,
                        200)
                .unlockedBy("has_" + name + "_ore", has(input))
                .save(consumer, HelperUtil.prefixResource(Gemspark.MODID, "smelting/" + name + "_from_smelting"));
    }

    @Override
    public String getName()
    {
        return Gemspark.MODID + " " + this.getClass().getSimpleName();
    }
}
