package com.unixkitty.gemspark.item;

import com.unixkitty.gemspark.datagen.ModTags;
import com.unixkitty.gemspork.item.DynamicTieredArmorProperties;
import com.unixkitty.gemspork.item.DynamicTieredToolProperties;
import com.unixkitty.gemspork.item.TagHelper;
import com.unixkitty.gemspork.lib.HelperUtil;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;
import net.minecraft.tags.Tag;
import net.minecraft.util.SoundEvents;

import static com.unixkitty.gemspark.item.GemItems.*;

public enum Gem
{
    TANZANITE(0, "tanzanite", Rarity.COMMON, -1),
    TOPAZ(1, "topaz", Rarity.COMMON, -1),
    SAPPHIRE(2, "sapphire", Rarity.UNCOMMON, -1),
    PINK_SAPPHIRE(3, "pink_sapphire", Rarity.RARE, 40),
    RUBY(4, "ruby", Rarity.RARE, -1),
    EMERALD(0, "emerald", Rarity.COMMON, -1),
    DIAMOND(0, "diamond", Rarity.COMMON, -1),
    ;

    private final String name;
    private final Rarity rarity;

    private final Tag<Item> itemTag;

    private final IItemTier toolProperties;
    private final IArmorMaterial armorProperties;

    Gem(int tierIndex, String name, Rarity rarity, int enchantability)
    {
        this.name = name;
        this.rarity = rarity;

        this.itemTag = TagHelper.forgeItemTag(ModTags.GEMS_PREFIX, name);

        this.toolProperties = new DynamicTieredToolProperties(
                tierIndex, TIERS,
                rarity == Rarity.RARE ? TOOL_CEIL_TIER.getHarvestLevel() : TOOL_FLOOR_TIER.getHarvestLevel(),
                enchantability,
                TIER_FLOOR_BUMP,
                TOOL_FLOOR_TIER, TOOL_CEIL_TIER,
                itemTag
        );
        this.armorProperties = new DynamicTieredArmorProperties(
                HelperUtil.materialString(itemTag),
                tierIndex, TIERS,
                enchantability,
                TIER_FLOOR_BUMP,
                ARMOR_FLOOR_TIER, ARMOR_CEIL_TIER,
                SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
                itemTag
        );
    }

    @Override
    public String toString()
    {
        return this.name;
    }

    public Rarity getRarity()
    {
        return rarity;
    }

    public Tag<Item> getItemTag()
    {
        return this.itemTag;
    }

    public IItemTier getToolProperties()
    {
        return this.toolProperties;
    }

    public IArmorMaterial getArmorProperties()
    {
        return this.armorProperties;
    }

}
