package com.unixkitty.gemspark.datagen.tag;

import com.unixkitty.gemspark.Gemspark;
import com.unixkitty.gemspark.compat.CuriosCompat;
import com.unixkitty.gemspark.init.ModItems;
import com.unixkitty.gemspark.item.Gem;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemTags extends ItemTagsProvider
{
    public ModItemTags(DataGenerator generatorIn, ExistingFileHelper existingFileHelper, ModBlockTags blockTagProvider)
    {
        super(generatorIn, blockTagProvider, Gemspark.MODID, existingFileHelper);
    }

    @Override
    protected void addTags()
    {
        copy(Tags.Blocks.ORES, Tags.Items.ORES);
        copy(ModTags.Blocks.TANZANITE_ORE, ModTags.Items.TANZANITE_ORE);
        copy(ModTags.Blocks.TOPAZ_ORE, ModTags.Items.TOPAZ_ORE);
        copy(ModTags.Blocks.SAPPHIRE_ORE, ModTags.Items.SAPPHIRE_ORE);
        copy(ModTags.Blocks.PINK_SAPPHIRE_ORE, ModTags.Items.PINK_SAPPHIRE_ORE);
        copy(ModTags.Blocks.RUBY_ORE, ModTags.Items.RUBY_ORE);

        copy(Tags.Blocks.STORAGE_BLOCKS, Tags.Items.STORAGE_BLOCKS);
        copy(ModTags.Blocks.TANZANITE_BLOCK, ModTags.Items.TANZANITE_BLOCK);
        copy(ModTags.Blocks.TOPAZ_BLOCK, ModTags.Items.TOPAZ_BLOCK);
        copy(ModTags.Blocks.SAPPHIRE_BLOCK, ModTags.Items.SAPPHIRE_BLOCK);
        copy(ModTags.Blocks.PINK_SAPPHIRE_BLOCK, ModTags.Items.PINK_SAPPHIRE_BLOCK);
        copy(ModTags.Blocks.RUBY_BLOCK, ModTags.Items.RUBY_BLOCK);

        /* Block tags copying end */
        tag(Tags.Items.GEMS).addTags(
                Gem.TANZANITE.getItemTag(),
                Gem.TOPAZ.getItemTag(),
                Gem.SAPPHIRE.getItemTag(),
                Gem.PINK_SAPPHIRE.getItemTag(),
                Gem.RUBY.getItemTag()
        );
        tag(Gem.TANZANITE.getItemTag()).add(ModItems.TANZANITE.get());
        tag(Gem.TOPAZ.getItemTag()).add(ModItems.TOPAZ.get());
        tag(Gem.SAPPHIRE.getItemTag()).add(ModItems.SAPPHIRE.get());
        tag(Gem.PINK_SAPPHIRE.getItemTag()).add(ModItems.PINK_SAPPHIRE.get());
        tag(Gem.RUBY.getItemTag()).add(ModItems.RUBY.get());

        tag(accessory("head")).add(
                ModItems.SPITFIRECAP.get(),
                ModItems.WITCH_HAT.get(),
                ModItems.BUNNYBAND.get(),
                ModItems.FALSE_HALO.get(),
                ModItems.FARMER_HAT.get(),
                ModItems.HEADPHONES.get(),
                ModItems.TANZANITE_TIARA.get(),
                ModItems.SILVER_TANZANITE_TIARA.get(),
                ModItems.EMERALD_TIARA.get(),
                ModItems.SILVER_EMERALD_TIARA.get(),
                ModItems.SAPPHIRE_TIARA.get(),
                ModItems.SILVER_SAPPHIRE_TIARA.get(),
                ModItems.RUBY_CROWN.get(),
                ModItems.SILVER_RUBY_CROWN.get(),
                ModItems.RGB_CROWN.get(),
                ModItems.SILVER_RGB_CROWN.get()
        );

        tag(accessory("curio")).add(
                ModItems.SPECTACLES.get(),
                ModItems.GLASSES_TECHNICOLOR.get(),
                ModItems.GLASSES_3D.get(),
                ModItems.GLASSES_RED.get(),
                ModItems.FUNKY_ALIEN_GLASSES.get(),
                ModItems.REDBACKRIBBON.get()
        );
    }

    private static TagKey<Item> accessory(String name)
    {
        return ItemTags.create(new ResourceLocation(CuriosCompat.MODID, name));
    }

    @Override
    public String getName()
    {
        return Gemspark.MODNAME + " " + this.getClass().getSimpleName();
    }
}
