package net.varia.stgmmod.datagen;

import net.varia.stgmmod.SGtMMod;
import net.varia.stgmmod.block.ModBlocks;
import net.varia.stgmmod.block.custom.BellberryCropBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.varia.stgmmod.block.custom.SaltCropBlock;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, SGtMMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.ADAMANTINE_BLOCK);
        blockWithItem(ModBlocks.RAW_ADAMANTINE_BLOCK);
        blockWithItem(ModBlocks.ADAMANTINE_ORE);

        blockWithItem(ModBlocks.MITHRAL_BLOCK);
        blockWithItem(ModBlocks.MITHRAL_ORE);

        blockWithItem(ModBlocks.HORN_BLOCK);

        blockWithItem(ModBlocks.MARBLE_BLOCK);
        blockWithItem(ModBlocks.COBBLED_MARBLE);
        blockWithItem(ModBlocks.TILED_MARBLE);
        stairsBlock(((StairBlock) ModBlocks.MARBLE_STAIRS.get()), blockTexture(ModBlocks.MARBLE_BLOCK.get()));
        slabBlock(((SlabBlock) ModBlocks.MARBLE_SLAB.get()), blockTexture(ModBlocks.MARBLE_BLOCK.get()), blockTexture(ModBlocks.MARBLE_BLOCK.get()));

        buttonBlock(((ButtonBlock) ModBlocks.MARBLE_BUTTON.get()), blockTexture(ModBlocks.MARBLE_BLOCK.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.MARBLE_PRESSURE_PLATE.get()), blockTexture(ModBlocks.MARBLE_BLOCK.get()));

        fenceBlock(((FenceBlock) ModBlocks.MARBLE_FENCE.get()), blockTexture(ModBlocks.MARBLE_BLOCK.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.MARBLE_FENCE_GATE.get()), blockTexture(ModBlocks.MARBLE_BLOCK.get()));
        wallBlock(((WallBlock) ModBlocks.MARBLE_WALL.get()), blockTexture(ModBlocks.MARBLE_BLOCK.get()));

        doorBlockWithRenderType(((DoorBlock) ModBlocks.MARBLE_DOOR.get()), modLoc("block/marble_door_bottom"), modLoc("block/marble_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.MARBLE_TRAPDOOR.get()), modLoc("block/marble_trapdoor"), true, "cutout");

        makeBellberryCrop((CropBlock) ModBlocks.BELLBERRY_CROP.get(), "bellberry_stage", "bellberry_stage");
        makeSaltCrop((CropBlock) ModBlocks.SALT_CROP.get(), "salt_stage_", "salt_stage_");

        simpleBlockWithItem(ModBlocks.MOONDEW.get(), models().cross(blockTexture(ModBlocks.MOONDEW.get()).getPath(),
                blockTexture(ModBlocks.MOONDEW.get())).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.POTTED_MOONDEW.get(), models().singleTexture("potted_catmint", new ResourceLocation("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.MOONDEW.get())).renderType("cutout"));
    }
    public void makeBellberryCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> bellberryStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] bellberryStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((BellberryCropBlock) block).getAgeProperty()),
                new ResourceLocation(SGtMMod.MOD_ID, "block/" + textureName + state.getValue(((BellberryCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    public void makeSaltCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> saltStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] saltStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((SaltCropBlock) block).getAgeProperty()),
                new ResourceLocation(SGtMMod.MOD_ID, "block/" + textureName + state.getValue(((SaltCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

}
