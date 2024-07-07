package com.unixkitty.gemspark.datagen.recipe;

import com.unixkitty.gemspark.Gemspark;
import com.unixkitty.gemspark.init.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
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
        ModBlocks.BLOCKS.getEntries().forEach(blockRegistryObject ->
        {
            Block block = blockRegistryObject.get();

            if (block instanceof IronBarsBlock)
            {
                String path = blockRegistryObject.getId().getPath();

                Block sourceBlock = Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(Gemspark.MODID, path.replace("_pane", ""))));

                ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, block, 16)
                        .define('G', sourceBlock)
                        .pattern("GGG")
                        .pattern("GGG")
                        .unlockedBy("has_item", has(sourceBlock))
                        .save(consumer, Gemspark.MODID + ":gem_glass_to_" + sourceBlock.asItem());
            }
        });

        registerLampPostCap(consumer, ModBlocks.LAMP_POST_CAP_CHERRY.get(), Blocks.CHERRY_FENCE);
        registerLampPostCap(consumer, ModBlocks.LAMP_POST_CAP_MANGROVE.get(), Blocks.MANGROVE_FENCE);
    }

    private void buildStonecutterRecipes(@NotNull Consumer<FinishedRecipe> consumer)
    {

    }

    private void registerLampPostCap(Consumer<FinishedRecipe> consumer, Block lampPostCap, Block fence)
    {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, lampPostCap)
                .define('i', Tags.Items.NUGGETS_IRON)
                .define('F', fence)
                .pattern("ii ")
                .pattern("iF ")
                .pattern("  i")
                .unlockedBy("has_item", has(fence))
                .save(consumer);
    }
}
