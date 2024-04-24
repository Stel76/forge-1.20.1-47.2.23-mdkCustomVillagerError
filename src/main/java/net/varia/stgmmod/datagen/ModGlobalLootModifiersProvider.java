package net.varia.stgmmod.datagen;

import net.varia.stgmmod.SGtMMod;
import net.varia.stgmmod.item.ModItems;
import net.varia.stgmmod.loot.AddItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;
import net.varia.stgmmod.loot.AddSusSandItemModifier;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, SGtMMod.MOD_ID);
    }

    @Override
    protected void start() {
        add("raw_adamantine_from_deepslate_diamond_ore", new AddItemModifier(new LootItemCondition[] {
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DEEPSLATE_DIAMOND_ORE).build(),
                LootItemRandomChanceCondition.randomChance(0.05f).build()}, ModItems.RAW_ADAMANTINE.get()));

        add("mithral_ingot_from_iron_golem", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("entities/iron_golem")).build() }, ModItems.MITHRAL_INGOT.get()));

        add("metal_detector_from_jungle_temples", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/jungle_temple")).build() }, ModItems.METAL_DETECTOR.get()));

        add("metal_detector_from_suspicious_sand", new AddSusSandItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("archaeology/desert_pyramid")).build() }, ModItems.METAL_DETECTOR.get()));


    }
}