package net.varia.stgmmod.datagen;

import net.varia.stgmmod.SGtMMod;
import net.varia.stgmmod.block.ModBlocks;
import net.varia.stgmmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.LinkedHashMap;

public class ModItemModelProvider extends ItemModelProvider {
    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, SGtMMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.ADAMANTINE_INGOT);
        simpleItem(ModItems.RAW_ADAMANTINE);

        simpleItem(ModItems.MITHRAL_DUST);
        simpleItem(ModItems.MITHRAL_CLUSTER);
        simpleItem(ModItems.MITHRAL_INGOT);
        simpleItem(ModItems.IMBUED_STRING);
        simpleItem(ModItems.IMBUED_LAPIS);

        trimmedArmorItem(ModItems.MITHRAL_HELMET);
        trimmedArmorItem(ModItems.MITHRAL_CHESTPLATE);
        trimmedArmorItem(ModItems.MITHRAL_LEGGINGS);
        trimmedArmorItem(ModItems.MITHRAL_BOOTS);

        simpleItem(ModItems.DWARVEN_STEEL_INGOT);
        trimmedArmorItem(ModItems.DWARVEN_STEEL_HELMET);
        trimmedArmorItem(ModItems.DWARVEN_STEEL_CHESTPLATE);
        trimmedArmorItem(ModItems.DWARVEN_STEEL_LEGGINGS);
        trimmedArmorItem(ModItems.DWARVEN_STEEL_BOOTS);
        handheldItem(ModItems.DWARVEN_STEEL_SWORD);
        handheldItem(ModItems.DWARVEN_STEEL_PICKAXE);
        handheldItem(ModItems.DWARVEN_STEEL_AXE);
        handheldItem(ModItems.DWARVEN_STEEL_SHOVEL);
        handheldItem(ModItems.DWARVEN_STEEL_HOE);

        simpleItem(ModItems.METAL_DETECTOR);
        simpleItem(ModItems.INFERNAL_COAL);
        simpleItem(ModItems.OWLBEAR_STEAK);
        simpleItem(ModItems.RAW_OWLBEAR);
        simpleItem(ModItems.OWLBEAR_STEW);
        simpleItem(ModItems.BELLBERRY);
        simpleItem(ModItems.BELLBERRY_SEEDS);
        simpleItem(ModItems.SALT_CANE);
        simpleItem(ModItems.SALT_SEEDS);
        simpleItem(ModItems.SALT);
        simpleItem(ModItems.SALTED_PORKCHOP);
        simpleItem(ModItems.PORK_CRACKLING);
        simpleItem(ModItems.CHEESE);
        simpleItem(ModItems.BLUE_CHEESE);
        simpleItem(ModItems.GOAT_CHEESE);
        simpleItem(ModItems.CREAM_CHEESE);

        simpleBlockItem(ModBlocks.MARBLE_DOOR);

        fenceItem(ModBlocks.MARBLE_FENCE, ModBlocks.MARBLE_BLOCK);
        buttonItem(ModBlocks.MARBLE_BUTTON, ModBlocks.MARBLE_BLOCK);
        wallItem(ModBlocks.MARBLE_WALL, ModBlocks.MARBLE_BLOCK);

        evenSimplerBlockItem(ModBlocks.MARBLE_BUTTON);
        evenSimplerBlockItem(ModBlocks.MARBLE_STAIRS);
        evenSimplerBlockItem(ModBlocks.MARBLE_SLAB);
        evenSimplerBlockItem(ModBlocks.MARBLE_PRESSURE_PLATE);
        evenSimplerBlockItem(ModBlocks.MARBLE_FENCE_GATE);

        trapdoorItem(ModBlocks.MARBLE_TRAPDOOR);

        handheldItem(ModItems.ADAMANTINE_SWORD);
        handheldItem(ModItems.ADAMANTINE_PICKAXE);
        handheldItem(ModItems.ADAMANTINE_AXE);
        handheldItem(ModItems.ADAMANTINE_SHOVEL);
        handheldItem(ModItems.ADAMANTINE_HOE);

        trimmedArmorItem(ModItems.ADAMANTINE_HELMET);
        trimmedArmorItem(ModItems.ADAMANTINE_CHESTPLATE);
        trimmedArmorItem(ModItems.ADAMANTINE_LEGGINGS);
        trimmedArmorItem(ModItems.ADAMANTINE_BOOTS);


        simpleBlockItemBlockTexture(ModBlocks.MOONDEW);
    }

    // Shoutout to El_Redstoniano for making this
    private void trimmedArmorItem(RegistryObject<Item> itemRegistryObject) {
        final String MOD_ID = SGtMMod.MOD_ID; // Change this to your mod id

        if(itemRegistryObject.get() instanceof ArmorItem armorItem) {
            trimMaterials.entrySet().forEach(entry -> {

                ResourceKey<TrimMaterial> trimMaterial = entry.getKey();
                float trimValue = entry.getValue();

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = "item/" + armorItem;
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = new ResourceLocation(MOD_ID, armorItemPath);
                ResourceLocation trimResLoc = new ResourceLocation(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = new ResourceLocation(MOD_ID, currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc)
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemRegistryObject.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                new ResourceLocation(MOD_ID,
                                        "item/" + itemRegistryObject.getId().getPath()));
            });
        }
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(SGtMMod.MOD_ID,"item/" + item.getId().getPath()));
    }

    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(SGtMMod.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(SGtMMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(SGtMMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  new ResourceLocation(SGtMMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(SGtMMod.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(SGtMMod.MOD_ID,"item/" + item.getId().getPath()));
    }
    private ItemModelBuilder simpleBlockItemBlockTexture(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(SGtMMod.MOD_ID,"block/" + item.getId().getPath()));
    }
}