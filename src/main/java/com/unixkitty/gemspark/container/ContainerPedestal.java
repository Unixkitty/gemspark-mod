package com.unixkitty.gemspark.container;

import com.unixkitty.gemspark.init.ModBlocks;
import com.unixkitty.gemspark.init.ModContainerTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.SlotItemHandler;

import javax.annotation.Nonnull;
import java.util.Objects;

import static com.unixkitty.gemspark.client.gui.ModGuiHandler.*;

public class ContainerPedestal extends AbstractContainerMenu
{
    private final ContainerLevelAccess canInteractWithCallable;

    public ContainerPedestal(final int windowId, final Inventory playerInventory, final Level world, final BlockPos pos)
    {
        super(ModContainerTypes.PEDESTAL.get(), windowId);
        this.canInteractWithCallable = ContainerLevelAccess.create(world, pos);

        final BlockEntity blockEntity = world.getBlockEntity(pos);

        final int PEDESTAL_SLOT_X = 80;
        final int PEDESTAL_SLOT_Y = 35;

        final int PLAYER_INVENTORY_X_POS = 8;
        final int PLAYER_INVENTORY_Y_POS = 84;

        final int HOTBAR_X_POS = 8;
        final int HOTBAR_Y_POS = 142;

        if (blockEntity != null)
        {
            blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(IItemHandler ->
                    this.addSlot(new SlotItemHandler(IItemHandler, 0, PEDESTAL_SLOT_X, PEDESTAL_SLOT_Y))
            );
        }

        // Main player inventory
        for (int row = 0; row < PLAYER_INVENTORY_ROW_COUNT; row++)
        {
            for (int column = 0; column < PLAYER_INVENTORY_COLUMN_COUNT; column++)
            {
                this.addSlot(new Slot(playerInventory,
                        PLAYER_INVENTORY_COLUMN_COUNT + row * PLAYER_INVENTORY_COLUMN_COUNT + column,
                        PLAYER_INVENTORY_X_POS + column * SLOT_X_SPACING,
                        PLAYER_INVENTORY_Y_POS + row * SLOT_Y_SPACING
                ));
            }
        }

        //Player hotbar
        for (int slotNumber = 0; slotNumber < PLAYER_HOTBAR_SLOT_COUNT; slotNumber++)
        {
            this.addSlot(new Slot(playerInventory, slotNumber, HOTBAR_X_POS + SLOT_X_SPACING * slotNumber, HOTBAR_Y_POS));
        }
    }

    /**
     * Handle when the stack in slot {@code index} is shift-clicked.
     * Normally this moves the stack between the player inventory and the other inventory(s).
     *
     * @param player the player passed in
     * @param index  the index passed in
     * @return the {@link ItemStack}
     */
    @Nonnull
    @Override
    public ItemStack quickMoveStack(final Player player, final int index)
    {
        ItemStack returnStack = ItemStack.EMPTY;
        final Slot slot = this.slots.get(index);
        if (slot.hasItem())
        {
            final ItemStack slotStack = slot.getItem();
            returnStack = slotStack.copy();

            final int containerSlots = this.slots.size() - player.getInventory().items.size();
            if (index < containerSlots)
            {
                if (!moveItemStackTo(slotStack, containerSlots, this.slots.size(), true))
                {
                    return ItemStack.EMPTY;
                }
            }
            else if (!moveItemStackTo(slotStack, 0, containerSlots, false))
            {
                return ItemStack.EMPTY;
            }
            if (slotStack.getCount() == 0)
            {
                slot.set(ItemStack.EMPTY);
            }
            else
            {
                slot.setChanged();
            }
            if (slotStack.getCount() == returnStack.getCount())
            {
                return ItemStack.EMPTY;
            }
            slot.onTake(player, slotStack);
        }
        return returnStack;
    }

    @Override
    public boolean stillValid(@Nonnull final Player player)
    {
        return stillValid(canInteractWithCallable, player, Objects.requireNonNull(ModBlocks.QUARTZ_PEDESTAL).get())
                || stillValid(canInteractWithCallable, player, Objects.requireNonNull(ModBlocks.BLACKSTONE_PEDESTAL).get());
    }
}
