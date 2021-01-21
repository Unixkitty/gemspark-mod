package com.unixkitty.gemspark.init;

import com.unixkitty.gemspark.Gemspark;
import com.unixkitty.gemspark.itemgroup.ModItemGroups;
import com.unixkitty.gemspark.worldgen.OreGeneration;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import java.util.Objects;

import static com.unixkitty.gemspark.block.BlockWoodGolem.POSE;

@SuppressWarnings("unused")
@Mod.EventBusSubscriber(modid = Gemspark.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class ModRegistry
{
    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event)
    {
        // BlockItems for all blocks
        ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block ->
                event.getRegistry().register(new BlockItem(block, new Item.Properties().group(ModItemGroups.PRIMARY)).setRegistryName(Objects.requireNonNull(block.getRegistryName())))
        );
    }

    @SubscribeEvent
    public static void onCommonSetup(final FMLCommonSetupEvent event)
    {
        OreGeneration.register();
    }

    public static void onBlockRightClicked(PlayerInteractEvent.RightClickBlock event)
    {
        if (
                !event.getWorld().isRemote
                        && event.getPlayer() instanceof ServerPlayerEntity
                        && event.getWorld().getBlockState(event.getPos()).getBlock() == ModBlocks.WOOD_GOLEM_RELIC.get()
                        && event.getItemStack().getItem() == Items.STICK
        )
        {
            BlockState state = event.getWorld().getBlockState(event.getPos());

            if (event.getPlayer().isSneaking())
            {
                //Change pose
                event.getWorld().setBlockState(event.getPos(), state.with(POSE, state.get(POSE).cycle()), 3);
            }
            else
            {
                //Rotate
                event.getWorld().setBlockState(event.getPos(), state.with(HorizontalBlock.HORIZONTAL_FACING, state.get(HorizontalBlock.HORIZONTAL_FACING).rotateY()), 3);
            }
        }
    }
}
