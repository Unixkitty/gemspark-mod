package com.unixkitty.gemspark.init;

import com.unixkitty.gemspark.Gemspark;
import com.unixkitty.gemspark.block.BlockBrazier;
import com.unixkitty.gemspark.block.BlockWoodGolem;
import com.unixkitty.gemspark.item.Gem;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.unixkitty.gemspark.block.BlockWoodGolem.POSE;

@SuppressWarnings("unused")
@Mod.EventBusSubscriber(modid = Gemspark.MODID)
public class ModEvents
{
    @SubscribeEvent
    public static void onLivingHurt(final LivingHurtEvent event)
    {
        if (!event.getEntity().level().isClientSide
                && event.getEntity() instanceof ServerPlayer player
                && event.getSource().is(DamageTypeTags.IS_FIRE))
        {
            boolean shouldApplyEffect = false;

            for (ItemStack armorStack : player.getArmorSlots())
            {
                if ((armorStack.getItem() instanceof ArmorItem && ((ArmorItem) armorStack.getItem()).getMaterial() == Gem.PINK_SAPPHIRE.getArmorProperties()))
                {
                    shouldApplyEffect = true;
                }
                else
                {
                    shouldApplyEffect = false;
                    break;
                }
            }

            if (shouldApplyEffect)
            {
                event.setAmount(event.getAmount() * 0.5F);
            }
        }
    }

    @SubscribeEvent
    public static void onBlockRightClicked(PlayerInteractEvent.RightClickBlock event)
    {
        if (!event.getLevel().isClientSide)
        {
            //Wood golem stuff
            if (
                    event.getEntity() instanceof ServerPlayer
                            && event.getLevel().getBlockState(event.getPos()).getBlock() instanceof BlockWoodGolem
                            && event.getItemStack().getItem() == Items.STICK
            )
            {
                BlockState state = event.getLevel().getBlockState(event.getPos());

                if (event.getEntity().isShiftKeyDown())
                {
                    //Change pose
                    event.getLevel().setBlock(event.getPos(), state.setValue(POSE, state.getValue(POSE).cycle()), 3);
                }
                else
                {
                    //Rotate
                    event.getLevel().setBlock(event.getPos(), state.setValue(HorizontalDirectionalBlock.FACING, state.getValue(HorizontalDirectionalBlock.FACING).getClockWise()), 3);
                }
            }

            //Put out brazier with shovel
            if (event.getLevel().getBlockState(event.getPos()).getBlock() instanceof BlockBrazier && event.getItemStack().getItem() instanceof ShovelItem)
            {
                Level world = event.getLevel();
                Player playerentity = event.getEntity();
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
