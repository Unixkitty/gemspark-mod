package com.unixkitty.gemspark.datagen.recipe;

import com.unixkitty.gemspark.Config;
import com.unixkitty.gemspark.Gemspark;
import com.unixkitty.gemspark.init.ModBlocks;
import com.unixkitty.gemspark.item.Gem;
import com.unixkitty.gemspark.item.GemItems;
import com.unixkitty.gemspork.lib.HelperUtil;
import com.unixkitty.gemspork.lib.datagen.recipe.CraftingTableRecipeProvider;
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
        //These should go into modern blocks mod
        //RecipeManager.addShapedOreRecipe(new ItemStack(Blocks.CLAY, 4), "sds", "dbd", "sds", 'd', "dirt", 's', "sand", 'b', FluidUtil.getFilledBucket(new FluidStack(FluidRegistry.WATER, Fluid.BUCKET_VOLUME)));
        //RecipeManager.addShapedOreRecipe(new ItemStack(Blocks.CLAY, 4), "dsd", "sbs", "dsd", 'd', "dirt", 's', "sand", 'b', Items.POTIONITEM);

        //Pedestal
        IItemProvider output = ModBlocks.QUARTZ_PEDESTAL.get();

        ShapedRecipeBuilder.shapedRecipe(output)
                .key('s', Blocks.QUARTZ_SLAB)
                .key('p', Blocks.QUARTZ_PILLAR)
                .patternLine("s")
                .patternLine("p")
                .addCriterion("has_item", hasItem(Tags.Items.STORAGE_BLOCKS_QUARTZ))
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
}
