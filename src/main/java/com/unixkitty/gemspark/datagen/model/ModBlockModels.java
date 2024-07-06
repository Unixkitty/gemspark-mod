package com.unixkitty.gemspark.datagen.model;

import com.unixkitty.gemspark.Gemspark;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockModels extends BlockModelProvider
{
    public ModBlockModels(PackOutput output, ExistingFileHelper existingFileHelper)
    {
        super(output, Gemspark.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels()
    {

    }
}
