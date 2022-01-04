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
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer)
    {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.STONE_FLOOR_TILE.get()), Blocks.SMOOTH_STONE)
                .unlocks("has_item", has(Blocks.SMOOTH_STONE))
                .save(consumer, "smooth_stone_from_stone_floor_tile_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.STONE_TILES.get()), Blocks.SMOOTH_STONE)
                .unlocks("has_item", has(Blocks.SMOOTH_STONE))
                .save(consumer, "smooth_stone_from_stone_tiles_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.SMOOTH_STONE), ModBlocks.STONE_FLOOR_TILE.get())
                .unlocks("has_item", has(Blocks.SMOOTH_STONE))
                .save(consumer, "stone_floor_tile_from_smooth_stone_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.SMOOTH_STONE), ModBlocks.STONE_TILES.get())
                .unlocks("has_item", has(Blocks.SMOOTH_STONE))
                .save(consumer, "stone_tiles_from_smooth_stone_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.SMOOTH_STONE), ModBlocks.ACCENTUATED_STONE.get())
                .unlocks("has_item", has(Blocks.SMOOTH_STONE))
                .save(consumer, "accentuated_stone_from_smooth_stone_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.ACCENTUATED_STONE.get()), ModBlocks.ACCENTUATED_STONE_CTM.get())
                .unlocks("has_item", has(ModBlocks.ACCENTUATED_STONE.get()))
                .save(consumer, "accentuated_stone_ctm_from_accentuated_stone_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.METAL_FRAMED_STONE.get()), ModBlocks.METAL_FRAMED_STONE_CTM.get())
                .unlocks("has_item", has(ModBlocks.METAL_FRAMED_STONE.get()))
                .save(consumer, "metal_framed_stone_ctm_from_metal_framed_stone_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.SMOKED_STONE.get()), ModBlocks.SMOKED_STONE_CTM.get())
                .unlocks("has_item", has(ModBlocks.SMOKED_STONE.get()))
                .save(consumer, "smoked_stone_ctm_from_smoked_stone_stonecutting");

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.PINK_SAPPHIRE_GEMSPARK_BLOCK.get()), ModBlocks.PINK_SAPPHIRE_LANTERN.get())
                .unlocks("has_item", has(ModBlocks.PINK_SAPPHIRE_GEMSPARK_BLOCK.get()))
                .save(consumer, "pink_sapphire_lantern_from_pink_sapphire_gemspark_block_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.SAPPHIRE_GEMSPARK_BLOCK.get()), ModBlocks.SAPPHIRE_LANTERN.get())
                .unlocks("has_item", has(ModBlocks.SAPPHIRE_GEMSPARK_BLOCK.get()))
                .save(consumer, "sapphire_lantern_from_sapphire_gemspark_block_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.TANZANITE_GEMSPARK_BLOCK.get()), ModBlocks.TANZANITE_LANTERN.get())
                .unlocks("has_item", has(ModBlocks.TANZANITE_GEMSPARK_BLOCK.get()))
                .save(consumer, "tanzanite_lantern_from_tanzanite_gemspark_block_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.TOPAZ_GEMSPARK_BLOCK.get()), ModBlocks.TOPAZ_LANTERN.get())
                .unlocks("has_item", has(ModBlocks.TOPAZ_GEMSPARK_BLOCK.get()))
                .save(consumer, "topaz_lantern_from_topaz_gemspark_block_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.RUBY_GEMSPARK_BLOCK.get()), ModBlocks.RUBY_LANTERN.get())
                .unlocks("has_item", has(ModBlocks.RUBY_GEMSPARK_BLOCK.get()))
                .save(consumer, "ruby_lantern_from_ruby_gemspark_block_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.DIAMOND_GEMSPARK_BLOCK.get()), ModBlocks.DIAMOND_LANTERN.get())
                .unlocks("has_item", has(ModBlocks.DIAMOND_GEMSPARK_BLOCK.get()))
                .save(consumer, "diamond_lantern_from_diamond_gemspark_block_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.EMERALD_GEMSPARK_BLOCK.get()), ModBlocks.EMERALD_LANTERN.get())
                .unlocks("has_item", has(ModBlocks.EMERALD_GEMSPARK_BLOCK.get()))
                .save(consumer, "emerald_lantern_from_emerald_gemspark_block_stonecutting");
    }

    @Override
    public String getName()
    {
        return Gemspark.MODID + " " + this.getClass().getSimpleName();
    }
}
