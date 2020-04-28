package com.unixkitty.gemspark.datagen.recipe;

import com.unixkitty.gemspark.Gemspark;
import com.unixkitty.gemspark.init.ModBlocks;
import com.unixkitty.gemspark.init.ModItems;
import com.unixkitty.gemspark.item.Gem;
import com.unixkitty.gemspork.lib.datagen.recipe.SmeltingRecipeProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;

import java.util.function.Consumer;

public class SmeltingRecipes extends SmeltingRecipeProvider
{
    public SmeltingRecipes(DataGenerator generatorIn)
    {
        super(Gemspark.MODID, generatorIn);
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

}
