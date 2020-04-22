package com.unixkitty.gemspark.init;

import com.unixkitty.gemspark.Gemspark;
import com.unixkitty.gemspark.container.ContainerPedestal;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModContainerTypes
{
    public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = new DeferredRegister<>(ForgeRegistries.CONTAINERS, Gemspark.MODID);

    public static final RegistryObject<ContainerType<ContainerPedestal>> PEDESTAL = CONTAINER_TYPES.register("quartz_pedestal", () ->
            IForgeContainerType.create(ContainerPedestal::new)
    );
}
