package com.unixkitty.gemspark.init;

import com.unixkitty.gemspark.block.BlockBrazier;
import com.unixkitty.gemspark.block.BlockWoodGolem;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.item.ShovelItem;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import static com.unixkitty.gemspark.block.BlockWoodGolem.POSE;

public class ModEvents
{
    public static void onBlockRightClicked(PlayerInteractEvent.RightClickBlock event)
    {
        if (!event.getWorld().isClientSide)
        {
            //Wood golem stuff
            if (
                    event.getPlayer() instanceof ServerPlayerEntity
                            && event.getWorld().getBlockState(event.getPos()).getBlock() instanceof BlockWoodGolem
                            && event.getItemStack().getItem() == Items.STICK
            )
            {
                BlockState state = event.getWorld().getBlockState(event.getPos());

                if (event.getPlayer().isShiftKeyDown())
                {
                    //Change pose
                    event.getWorld().setBlock(event.getPos(), state.setValue(POSE, state.getValue(POSE).cycle()), 3);
                }
                else
                {
                    //Rotate
                    event.getWorld().setBlock(event.getPos(), state.setValue(HorizontalBlock.FACING, state.getValue(HorizontalBlock.FACING).getClockWise()), 3);
                }
            }

            //Put out brazier with shovel
            if (event.getWorld().getBlockState(event.getPos()).getBlock() instanceof BlockBrazier && event.getItemStack().getItem() instanceof ShovelItem)
            {
                World world = event.getWorld();
                PlayerEntity playerentity = event.getPlayer();
                BlockPos blockpos = event.getPos();
                BlockState blockstate = world.getBlockState(blockpos);
                BlockState blockstate2 = null;

                if (blockstate.getValue(BlockBrazier.LIT))
                {
                    if (!world.isClientSide())
                    {
                        world.levelEvent(null, 1009, blockpos, 0);
                    }

                    blockstate2 = blockstate.setValue(BlockBrazier.LIT, false);
                }

                if (blockstate2 != null)
                {
                    if (!world.isClientSide)
                    {
                        world.setBlock(blockpos, blockstate2, 11);
                        if (playerentity != null)
                        {
                            event.getItemStack().hurtAndBreak(1, playerentity, (player) -> {
                                player.broadcastBreakEvent(event.getHand());
                            });
                        }
                    }
                }
            }
        }
    }
}
