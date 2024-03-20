package com.unixkitty.gemspark.item;

import com.unixkitty.gemspark.Gemspark;
import com.unixkitty.gemspark.init.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTab
{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Gemspark.MODID);

    public static final RegistryObject<CreativeModeTab> TAB = CREATIVE_TABS.register(Gemspark.MODID, () ->
                    CreativeModeTab.builder()
                            .title(Component.translatable("itemGroup.gemspark"))
                            .icon(() -> new ItemStack(ModItems.PINK_SAPPHIRE.get()))
                            .displayItems((pParameters, pOutput) ->
                                    ForgeRegistries.ITEMS.getEntries().forEach(entry -> {
                                        if (entry.getKey().location().getNamespace().equals(Gemspark.MODID))
                                        {
                                            pOutput.accept(entry.getValue());
//                                    ModItems.ITEMS.getEntries().forEach(itemRegistryObject -> pOutput.accept(itemRegistryObject.get()));
                                        }
                                    }))
                            .build()
    );
}