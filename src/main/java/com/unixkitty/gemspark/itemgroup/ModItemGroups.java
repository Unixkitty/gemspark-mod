package com.unixkitty.gemspark.itemgroup;

import com.unixkitty.gemspark.Gemspark;
import com.unixkitty.gemspark.init.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import java.util.function.Supplier;

public class ModItemGroups
{
    public static final ItemGroup PRIMARY = new GemsparkTab(Gemspark.MODID, () -> new ItemStack(ModItems.pink_sapphire.get()));

    public static class GemsparkTab extends ItemGroup
    {
        private final Supplier<ItemStack> iconSupplier;

        public GemsparkTab(final String name, final Supplier<ItemStack> iconSupplier)
        {
            super(name);

            this.iconSupplier = iconSupplier;
        }

        @Override
        public ItemStack createIcon()
        {
            return iconSupplier.get();
        }
    }

}