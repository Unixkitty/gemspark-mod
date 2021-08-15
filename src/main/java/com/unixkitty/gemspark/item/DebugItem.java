package com.unixkitty.gemspark.item;

import com.unixkitty.gemspark.itemgroup.ModItemGroups;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Rarity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class DebugItem extends Item
{
    public DebugItem()
    {
        super(new Item.Properties().tab(ModItemGroups.PRIMARY).rarity(Rarity.EPIC).stacksTo(1));
    }

    @Override
    public ActionResultType useOn(ItemUseContext context)
    {
        if (!context.getLevel().isClientSide && context.getPlayer() instanceof ServerPlayerEntity && context.getPlayer().canUseGameMasterBlocks())
        {
            context.getPlayer().sendMessage(new StringTextComponent("Block: " + context.getLevel().getBlockState(context.getClickedPos())), context.getPlayer().getUUID());

            TileEntity tileEntity = context.getLevel().getBlockEntity(context.getClickedPos());

            if (tileEntity != null)
            {
                CompoundNBT compound = new CompoundNBT();

                tileEntity.save(compound);

                context.getPlayer().sendMessage(new TranslationTextComponent("commands.data.block.query", tileEntity.getBlockPos().getX(), tileEntity.getBlockPos().getY(), tileEntity.getBlockPos().getZ(), compound.getPrettyDisplay()), context.getPlayer().getUUID());
            }
        }

        return ActionResultType.SUCCESS;
    }

    /*//Non-block rightClick
    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand)
    {
        if (!world.isRemote && player.isCreative())
        {
            Gemspark.log().debug("NBT stick says hi!");

            //Code totally not from World Stripper mod
            if (hand == Hand.OFF_HAND)
            {
                final List<String> stripList = new ArrayList<>();

                stripList.add("minecraft:dirt");
                stripList.add("minecraft:grass");
                stripList.add("minecraft:tall_grass");
                stripList.add("minecraft:grass_block");
                stripList.add("minecraft:stone");
                stripList.add("minecraft:diorite");
                stripList.add("minecraft:granite");
                stripList.add("minecraft:andesite");
                stripList.add("minecraft:gravel");
                stripList.add("minecraft:sand");
                stripList.add("minecraft:sandstone");
                stripList.add("minecraft:oak_log");
                stripList.add("minecraft:dark_oak_log");
                stripList.add("minecraft:spruce_log");
                stripList.add("minecraft:birch_log");
                stripList.add("minecraft:jungle_log");
                stripList.add("minecraft:acacia_log");
                stripList.add("minecraft:oak_leaves");
                stripList.add("minecraft:dark_oak_leaves");
                stripList.add("minecraft:spruce_leaves");
                stripList.add("minecraft:birch_leaves");
                stripList.add("minecraft:jungle_leaves");
                stripList.add("minecraft:acacia_leaves");
                stripList.add("minecraft:water");
                stripList.add("minecraft:flowing_water");
                stripList.add("minecraft:lava");
                stripList.add("minecraft:flowing_lava");
                stripList.add("minecraft:netherrack");
                stripList.add("minecraft:end_stone");

                int chunkRadius = 3;

                double chunkClearSizeX = ((16 * chunkRadius) / 2);
                double chunkClearSizeZ = ((16 * chunkRadius) / 2);

                player.sendMessage(new StringTextComponent(TextFormatting.BOLD + "" + TextFormatting.RED + "WARNING! " + TextFormatting.WHITE + "Stripping " + chunkClearSizeX + "x" + chunkClearSizeZ + " chunks..."), player.getUniqueID());
                for (int x = (int) (player.getPosX() - chunkClearSizeX); (double) x <= player.getPosX() + chunkClearSizeX; x++)
                {
                    for (int y = 0; (double) y <= player.getPosY() + 16; ++y)
                    {
                        for (int z = (int) (player.getPosZ() - chunkClearSizeZ); (double) z <= player.serverPosZ + chunkClearSizeZ; z++)
                        {
                            BlockPos targetBlockPos = new BlockPos(x, y, z);
                            BlockState targetBlockState = world.getBlockState(targetBlockPos);
                            Block targetBlock = targetBlockState.getBlock();

                            if (!targetBlock.equals(Blocks.AIR) && !targetBlock.equals(Blocks.BEDROCK) && stripList.contains(targetBlock.getRegistryName().toString()))
                            {
                                world.setBlockState(targetBlockPos, Blocks.AIR.getDefaultState(), 3);
                            }
                        }
                    }
                }
                player.sendMessage(new StringTextComponent("World stripping complete"), player.getUniqueID());
            }
        }

        return ActionResult.resultPass(player.getHeldItem(hand));
    }*/

    /*@Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
        super.addInformation(stack, worldIn, tooltip, flagIn);

        tooltip.add((new TranslationTextComponent("text.nbt_stick.info").mergeStyle(TextFormatting.DARK_GRAY)));
        if (flagIn == ITooltipFlag.TooltipFlags.ADVANCED)
        {
            tooltip.add((new StringTextComponent("Right click on air in off-hand will strip 3x3 chunks around you of filler blocks to view generation features")).mergeStyle(TextFormatting.GRAY));
        }
    }*/

    @Override
    public boolean isFoil(ItemStack stack)
    {
        return true;
    }
}
