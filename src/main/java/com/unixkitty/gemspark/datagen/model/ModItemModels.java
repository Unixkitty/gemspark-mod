package com.unixkitty.gemspark.datagen.model;

import com.unixkitty.gemspark.Gemspark;
import com.unixkitty.gemspark.init.ModBlocks;
import com.unixkitty.gemspark.init.ModItems;
import com.unixkitty.gemspark.item.CosmeticHatItem;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.client.model.generators.ItemModelProvider;
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

                withExistingParent(itemRegistryObject.getId().getPath(), modLoc("block/" + name));
            }
            else if (itemRegistryObject == ModItems.DEBUG_STICK)
            {
                withExistingParent(itemRegistryObject.getId().getPath(), mcLoc("item/" + Items.STICK.toString().toLowerCase()));
            }
            else if (!(item instanceof CosmeticHatItem))
            {
                basicItem(item);
            }
        });
    }
}
