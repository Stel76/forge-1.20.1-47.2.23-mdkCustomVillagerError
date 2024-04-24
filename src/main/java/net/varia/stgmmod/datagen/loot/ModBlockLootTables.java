package net.varia.stgmmod.datagen.loot;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.varia.stgmmod.block.ModBlocks;
import net.varia.stgmmod.block.custom.BellberryCropBlock;
import net.varia.stgmmod.block.custom.SaltCropBlock;
import net.varia.stgmmod.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.ADAMANTINE_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_ADAMANTINE_BLOCK.get());
        this.dropSelf(ModBlocks.MITHRAL_BLOCK.get());
        this.dropSelf(ModBlocks.HORN_BLOCK.get());

        this.add(ModBlocks.ADAMANTINE_ORE.get(),
                block -> createOreDrop(ModBlocks.ADAMANTINE_ORE.get(), ModItems.RAW_ADAMANTINE.get()));
        this.add(ModBlocks.MITHRAL_ORE.get(),
                block -> createOreDrop(ModBlocks.MITHRAL_ORE.get(), ModItems.MITHRAL_DUST.get()));

        this.dropSelf(ModBlocks.MARBLE_BLOCK.get());
        this.dropSelf(ModBlocks.TILED_MARBLE.get());
        this.dropSelf(ModBlocks.COBBLED_MARBLE.get());
        this.dropSelf(ModBlocks.MARBLE_STAIRS.get());
        this.dropSelf(ModBlocks.MARBLE_BUTTON.get());
        this.dropSelf(ModBlocks.MARBLE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.MARBLE_TRAPDOOR.get());
        this.dropSelf(ModBlocks.MARBLE_FENCE.get());
        this.dropSelf(ModBlocks.MARBLE_FENCE_GATE.get());
        this.dropSelf(ModBlocks.MARBLE_WALL.get());


        this.add(ModBlocks.MARBLE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.MARBLE_SLAB.get()));
        this.add(ModBlocks.MARBLE_DOOR.get(),
                block -> createDoorTable(ModBlocks.MARBLE_DOOR.get()));

        LootItemCondition.Builder lootitemcondition$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.BELLBERRY_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BellberryCropBlock.AGE, 5));

        this.add(ModBlocks.BELLBERRY_CROP.get(), createCropDrops(ModBlocks.BELLBERRY_CROP.get(), ModItems.BELLBERRY.get(),
                ModItems.BELLBERRY_SEEDS.get(), lootitemcondition$builder));

        LootItemCondition.Builder lootitemcondition$builder2 = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.SALT_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SaltCropBlock.AGE, 7))
                .or(LootItemBlockStatePropertyCondition
                        .hasBlockStateProperties(ModBlocks.SALT_CROP.get())
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SaltCropBlock.AGE, 8)));

        // LootItemCondition.Builder lootitemcondition$builder2 = LootItemBlockStatePropertyCondition
        //         .hasBlockStateProperties(ModBlocks.CORN_CROP.get())
        //         .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornCropBlock.AGE, 8));

        this.add(ModBlocks.SALT_CROP.get(), createCropDrops(ModBlocks.SALT_CROP.get(), ModItems.SALT_CANE.get(),
                ModItems.SALT_SEEDS.get(), lootitemcondition$builder2));

        this.dropSelf(ModBlocks.MOONDEW.get());
        this.add(ModBlocks.POTTED_MOONDEW.get(), createPotFlowerItemTable(ModBlocks.MOONDEW.get()));




    }

    protected LootTable.Builder createOreDrop(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}