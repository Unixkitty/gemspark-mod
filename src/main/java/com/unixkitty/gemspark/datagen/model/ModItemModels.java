package com.unixkitty.gemspark.datagen.model;

import com.unixkitty.gemspark.Gemspark;
import com.unixkitty.gemspark.init.ModBlocks;
import com.unixkitty.gemspark.init.ModItems;
import com.unixkitty.gemspark.item.CosmeticHatItem;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TieredItem;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModels extends ItemModelProvider
{

    public ModItemModels(PackOutput output, ExistingFileHelper existingFileHelper)
    {
        super(output, Gemspark.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels()
    {
        ModItems.ITEMS.getEntries().forEach(itemRegistryObject ->
        {
            Item item = itemRegistryObject.get();

            if (item instanceof BlockItem)
            {
                String name = item.toString().toLowerCase();

                if (name.contains("_glowing_"))
                {
                    name = name.replace("glowing_", "");
                }
                else if (name.contains("inverted"))
                {
                    name = name.replace("inverted_", "") + "_on";
                }
                else if (name.contains("colored_lamp"))
                {
                    name += "_off";
                }
                else if (name.equals(ModBlocks.WOOD_GOLEM_RELIC.getId().getPath()))
                {
                    name = "woodgolem_pose_standing";
                }
                else if (name.contains("_ctm"))
                {
                    name = name.replace("_ctm", "");
                }

                if (name.contains("glass_pane"))
                {
                    ResourceLocation resourceLocation = modLoc(name.replace("_pane", ""));

                    getBuilder(itemRegistryObject.getId().toString())
                            .parent(new ModelFile.UncheckedModelFile("item/generated"))
                            .texture("layer0", new ResourceLocation(resourceLocation.getNamespace(), "block/" + resourceLocation.getPath()));
                }
                else
                {
                    withExistingParent(itemRegistryObject.getId().getPath(), modLoc("block/" + name));
                }
            }
            else if (item instanceof TieredItem)
            {
                ResourceLocation resourceLocation = itemRegistryObject.getId();

                getBuilder(resourceLocation.toString())
                        .parent(new ModelFile.UncheckedModelFile("item/handheld"))
                        .texture("layer0", new ResourceLocation(resourceLocation.getNamespace(), "item/" + resourceLocation.getPath()));
            }
            else if (!(item instanceof CosmeticHatItem))
            {
                basicItem(item);
            }
        });
    }
}
