package com.unixkitty.gemspark.datagen.recipe;

import com.unixkitty.gemspark.Gemspark;
import com.unixkitty.gemspark.init.ModBlocks;
import com.unixkitty.gemspark.init.ModItems;
import com.unixkitty.gemspark.util.Gem;
import com.unixkitty.gemspark.util.HelperUtil;
import net.minecraft.data.CookingRecipeBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.IItemProvider;

import java.util.function.Consumer;

public class SmeltingRecipeProvider extends RecipeProvider
{
    public SmeltingRecipeProvider(DataGenerator generatorIn)
    {
        super(generatorIn);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer)
    {
        addBasicOreCooking(consumer, ModBlocks.TANZANITE_ORE.get(), ModItems.TANZANITE.get(), Gem.TANZANITE.toString());
        addBasicOreCooking(consumer, ModBlocks.TOPAZ_ORE.get(), ModItems.TOPAZ.get(), Gem.TOPAZ.toString());
        addBasicOreCooking(consumer, ModBlocks.SAPPHIRE_ORE.get(), ModItems.SAPPHIRE.get(), Gem.SAPPHIRE.toString());
        addBasicOreCooking(consumer, ModBlocks.PINK_SAPPHIRE_ORE.get(), ModItems.PINK_SAPPHIRE.get(), Gem.PINK_SAPPHIRE.toString());
        addBasicOreCooking(consumer, ModBlocks.RUBY_ORE.get(), ModItems.RUBY.get(), Gem.RUBY.toString());
    }

    private void addBasicOreCooking(Consumer<IFinishedRecipe> consumer, IItemProvider input, IItemProvider result, String name)
    {
        CookingRecipeBuilder.smeltingRecipe(
                Ingredient.fromItems(input),
                result,
                1.0F,
                200)
                .addCriterion("has_" + name + "_ore", hasItem(input))
                .build(consumer, HelperUtil.prefixResource("smelting/" + name + "_from_smelting"));
    }

    @Override
    public String getName()
    {
        return Gemspark.MODNAME + " " + this.getClass().getSimpleName();
    }
}
