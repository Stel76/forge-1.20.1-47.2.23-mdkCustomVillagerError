package net.varia.stgmmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.varia.stgmmod.SGtMMod;
import net.varia.stgmmod.block.ModBlocks;
import net.varia.stgmmod.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, SGtMMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES)
                .add(ModBlocks.ADAMANTINE_ORE.get()).addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.ADAMANTINE_BLOCK.get(),
                        ModBlocks.RAW_ADAMANTINE_BLOCK.get(),
                        ModBlocks.ADAMANTINE_ORE.get(),
                        ModBlocks.HORN_BLOCK.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.HORN_BLOCK.get());
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.ADAMANTINE_BLOCK.get());

        this.tag(BlockTags.FENCES)
                .add(ModBlocks.MARBLE_FENCE.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.MARBLE_FENCE_GATE.get());
        this.tag(BlockTags.WALLS)
                .add(ModBlocks.MARBLE_WALL.get());
    }
}
