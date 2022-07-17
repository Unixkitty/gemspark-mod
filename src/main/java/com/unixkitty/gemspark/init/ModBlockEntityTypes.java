package com.unixkitty.gemspark.init;

import com.unixkitty.gemspark.Gemspark;
import com.unixkitty.gemspark.blockentity.BlockEntityPedestal;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Objects;

public final class ModBlockEntityTypes
{
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, Gemspark.MODID);

    public static final RegistryObject<BlockEntityType<BlockEntityPedestal>> PEDESTAL = BLOCK_ENTITY_TYPES.register(
            "quartz_pedestal",
            () -> BlockEntityType.Builder.of(
                    BlockEntityPedestal::new,
                    Objects.requireNonNull(ModBlocks.QUARTZ_PEDESTAL).get(),
                    Objects.requireNonNull(ModBlocks.BLACKSTONE_PEDESTAL).get()
            ).build(null)
    );
}
