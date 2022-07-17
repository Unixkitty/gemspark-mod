package com.unixkitty.gemspark.init;

import com.unixkitty.gemspark.Gemspark;
import com.unixkitty.gemspark.container.ContainerPedestal;
import net.minecraft.core.BlockPos;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModContainerTypes
{
    public static final DeferredRegister<MenuType<?>> CONTAINER_TYPES = DeferredRegister.create(ForgeRegistries.CONTAINERS, Gemspark.MODID);

    public static final RegistryObject<MenuType<ContainerPedestal>> PEDESTAL = CONTAINER_TYPES.register("quartz_pedestal", () ->
            IForgeMenuType.create(((windowId, inv, data) ->
            {
                BlockPos pos = data.readBlockPos();
                Level world = inv.player.getCommandSenderWorld();

                return new ContainerPedestal(windowId, inv, world, pos);
            }))
    );
}
