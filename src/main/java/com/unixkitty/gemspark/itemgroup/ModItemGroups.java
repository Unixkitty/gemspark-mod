package com.unixkitty.gemspark.itemgroup;

import com.unixkitty.gemspark.Gemspark;
import com.unixkitty.gemspark.init.ModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

public class ModItemGroups
{
    public static final CreativeModeTab PRIMARY = new GemsparkTab(Gemspark.MODID, () -> new ItemStack(ModItems.PINK_SAPPHIRE.get()));

    public static class GemsparkTab extends CreativeModeTab
    {
        private final Supplier<ItemStack> iconSupplier;

        public GemsparkTab(final String name, final Supplier<ItemStack> iconSupplier)
        {
            super(name);

            this.iconSupplier = iconSupplier;
        }

        @Override
        public ItemStack makeIcon()
        {
            return iconSupplier.get();
        }
    }

}