package com.unixkitty.gemspark.datagen.recipe;

import com.unixkitty.gemspark.Gemspark;
import com.unixkitty.gemspark.init.ModBlocks;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SingleItemRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Consumer;

public class StonecutterRecipes extends RecipeProvider
{
    public StonecutterRecipes(DataGenerator generatorIn)
    {
        super(generatorIn);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer)
    {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.STONE_FLOOR_TILE.get()), Blocks.SMOOTH_STONE)
                .unlockedBy("has_item", has(Blocks.SMOOTH_STONE))
                .save(consumer, "smooth_stone_from_stone_floor_tile_stonecutting");

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.STONE_TILES.get()), Blocks.SMOOTH_STONE)
                .unlockedBy("has_item", has(Blocks.SMOOTH_STONE))
                .save(consumer, "smooth_stone_from_stone_tiles_stonecutting");

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.SMOOTH_STONE), ModBlocks.STONE_FLOOR_TILE.get())
                .unlockedBy("has_item", has(Blocks.SMOOTH_STONE))
                .save(consumer, "stone_floor_tile_from_smooth_stone_stonecutting");

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.SMOOTH_STONE), ModBlocks.STONE_TILES.get())
                .unlockedBy("has_item", has(Blocks.SMOOTH_STONE))
                .save(consumer, "stone_tiles_from_smooth_stone_stonecutting");
    }

    @Override
    public String getName()
    {
        return Gemspark.MODID + " " + this.getClass().getSimpleName();
    }
}
