package com.unixkitty.gemspark.item;

import com.unixkitty.gemspark.util.HelperUtil;
import com.unixkitty.gemspark.util.TagHelper;
import com.unixkitty.gemspark.util.item.DynamicTieredArmorProperties;
import com.unixkitty.gemspark.util.item.DynamicTieredToolProperties;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Tier;
import net.minecraftforge.common.Tags;

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

    private final TagKey<Item> itemTag;

    private final Tier toolProperties;
    private final ArmorMaterial armorProperties;

    Gem(int tierIndex, String name, Rarity rarity, int enchantability)
    {
        this.name = name;
        this.rarity = rarity;

        this.itemTag = TagHelper.forgeItemTag(Tags.Items.GEMS.location().getPath(), name);

        this.toolProperties = new DynamicTieredToolProperties(
                tierIndex, TIERS,
                rarity == Rarity.RARE ? TOOL_CEIL_TIER.getLevel() : TOOL_FLOOR_TIER.getLevel(),
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
                SoundEvents.ARMOR_EQUIP_DIAMOND,
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

    public TagKey<Item> getItemTag()
    {
        return this.itemTag;
    }

    public Tier getToolProperties()
    {
        return this.toolProperties;
    }

    public ArmorMaterial getArmorProperties()
    {
        return this.armorProperties;
    }

}
