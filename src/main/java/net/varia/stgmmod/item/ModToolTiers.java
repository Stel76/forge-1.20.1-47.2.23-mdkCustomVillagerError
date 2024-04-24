package net.varia.stgmmod.item;

import net.varia.stgmmod.SGtMMod;
import net.varia.stgmmod.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier ADAMANTINE = TierSortingRegistry.registerTier(
            new ForgeTier(5, 1500, 5f, 4f, 25,
                    ModTags.Blocks.NEEDS_ADAMANTINE_TOOL, () -> Ingredient.of(ModItems.ADAMANTINE_INGOT.get())),
            new ResourceLocation(SGtMMod.MOD_ID, "adamantine"), List.of(Tiers.NETHERITE), List.of());

}