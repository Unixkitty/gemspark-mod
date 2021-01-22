package com.unixkitty.gemspark.datagen.recipe;

import com.unixkitty.gemspark.Gemspark;
import com.unixkitty.gemspark.init.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.SingleItemRecipeBuilder;
import net.minecraft.item.crafting.Ingredient;

import java.util.function.Consumer;

public class StonecutterRecipes extends RecipeProvider
{
    public StonecutterRecipes(DataGenerator generatorIn)
    {
        super(generatorIn);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer)
    {
        SingleItemRecipeBuilder.stonecuttingRecipe(Ingredient.fromItems(ModBlocks.STONE_FLOOR_TILE.get()), Blocks.SMOOTH_STONE)
                .addCriterion("has_item", hasItem(Blocks.SMOOTH_STONE))
                .build(consumer, "smooth_stone_from_stone_floor_tile_stonecutting");

        SingleItemRecipeBuilder.stonecuttingRecipe(Ingredient.fromItems(ModBlocks.STONE_TILES.get()), Blocks.SMOOTH_STONE)
                .addCriterion("has_item", hasItem(Blocks.SMOOTH_STONE))
                .build(consumer, "smooth_stone_from_stone_tiles_stonecutting");

        SingleItemRecipeBuilder.stonecuttingRecipe(Ingredient.fromItems(Blocks.SMOOTH_STONE), ModBlocks.STONE_FLOOR_TILE.get())
                .addCriterion("has_item", hasItem(Blocks.SMOOTH_STONE))
                .build(consumer, "stone_floor_tile_from_smooth_stone_stonecutting");

        SingleItemRecipeBuilder.stonecuttingRecipe(Ingredient.fromItems(Blocks.SMOOTH_STONE), ModBlocks.STONE_TILES.get())
                .addCriterion("has_item", hasItem(Blocks.SMOOTH_STONE))
                .build(consumer, "stone_tiles_from_smooth_stone_stonecutting");
    }

    @Override
    public String getName()
    {
        return Gemspark.MODID + " " + this.getClass().getSimpleName();
    }
}
