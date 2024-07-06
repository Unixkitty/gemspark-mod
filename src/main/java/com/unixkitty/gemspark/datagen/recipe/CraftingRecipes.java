package com.unixkitty.gemspark.datagen.recipe;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class CraftingRecipes extends RecipeProvider
{
    public CraftingRecipes(PackOutput output)
    {
        super(output);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> consumer)
    {
        buildCraftingTableRecipes(consumer);
        buildStonecutterRecipes(consumer);
    }

    private void buildCraftingTableRecipes(@NotNull Consumer<FinishedRecipe> consumer)
    {

    }

    private void buildStonecutterRecipes(@NotNull Consumer<FinishedRecipe> consumer)
    {

    }
}
