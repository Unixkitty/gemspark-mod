package com.unixkitty.gemspark.item;

import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.Property;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;

public class DebugItem extends Item
{
    public DebugItem()
    {
        super(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC));
    }

    @Override
    public boolean isFoil(@Nonnull ItemStack pStack)
    {
        return true;
    }

    @Override
    public boolean canAttackBlock(@Nonnull BlockState pState, Level pLevel, @Nonnull BlockPos pPos, @Nonnull Player pPlayer)
    {
        if (!pLevel.isClientSide)
        {
            this.handleInteraction(pPlayer, pState, pLevel, pPos, false, pPlayer.getItemInHand(InteractionHand.MAIN_HAND));
        }

        return false;
    }

    @Nonnull
    public InteractionResult useOn(UseOnContext pContext)
    {
        Player player = pContext.getPlayer();
        Level level = pContext.getLevel();
        if (!level.isClientSide && player != null)
        {
            BlockPos blockpos = pContext.getClickedPos();
            if (!this.handleInteraction(player, level.getBlockState(blockpos), level, blockpos, !player.isCrouching(), pContext.getItemInHand()))
            {
                return InteractionResult.FAIL;
            }
        }

        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    private boolean handleInteraction(Player pPlayer, BlockState pStateClicked, LevelAccessor pAccessor, BlockPos pPos, boolean pShouldCycleState, ItemStack pDebugStack)
    {
        Block block = pStateClicked.getBlock();
        StateDefinition<Block, BlockState> statedefinition = block.getStateDefinition();
        Collection<Property<?>> collection = statedefinition.getProperties();
        String s = BuiltInRegistries.BLOCK.getKey(block).toString();
        if (collection.isEmpty())
        {
            message(pPlayer, Component.translatable(Items.DEBUG_STICK.getDescriptionId() + ".empty", s));
            return false;
        }
        else
        {
            CompoundTag compoundtag = pDebugStack.getOrCreateTagElement("DebugProperty");
            String s1 = compoundtag.getString(s);
            Property<?> property = statedefinition.getProperty(s1);
            if (pShouldCycleState)
            {
                if (property == null)
                {
                    property = collection.iterator().next();
                }

                BlockState blockstate = cycleState(pStateClicked, property, pPlayer.isSecondaryUseActive());
                pAccessor.setBlock(pPos, blockstate, 18);
                message(pPlayer, Component.translatable(Items.DEBUG_STICK.getDescriptionId() + ".update", property.getName(), getNameHelper(blockstate, property)));
            }
            else
            {
                property = getRelative(collection, property, pPlayer.isSecondaryUseActive());
                String s2 = property.getName();
                compoundtag.putString(s, s2);
                message(pPlayer, Component.translatable(Items.DEBUG_STICK.getDescriptionId() + ".select", s2, getNameHelper(pStateClicked, property)));
            }

            return true;
        }
    }

    private static <T extends Comparable<T>> BlockState cycleState(BlockState pState, Property<T> pProperty, boolean pBackwards)
    {
        return pState.setValue(pProperty, getRelative(pProperty.getPossibleValues(), pState.getValue(pProperty), pBackwards));
    }

    private static <T> T getRelative(Iterable<T> pAllowedValues, @Nullable T pCurrentValue, boolean pBackwards)
    {
        return pBackwards ? Util.findPreviousInIterable(pAllowedValues, pCurrentValue) : Util.findNextInIterable(pAllowedValues, pCurrentValue);
    }

    private static void message(Player pPlayer, Component pMessageComponent)
    {
        ((ServerPlayer) pPlayer).sendSystemMessage(pMessageComponent, true);
    }

    private static <T extends Comparable<T>> String getNameHelper(BlockState pState, Property<T> pProperty)
    {
        return pProperty.getName(pState.getValue(pProperty));
    }
}
