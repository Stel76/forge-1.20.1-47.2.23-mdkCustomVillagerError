package net.varia.stgmmod.block;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.varia.stgmmod.SGtMMod;
import net.varia.stgmmod.block.custom.BellberryCropBlock;
import net.varia.stgmmod.block.custom.SaltCropBlock;
import net.varia.stgmmod.block.custom.SoundBlock;
import net.varia.stgmmod.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, SGtMMod.MOD_ID);

    public static final RegistryObject<Block> ADAMANTINE_BLOCK = registerBlock("adamantine_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.METAL)));
    public static final RegistryObject<Block> RAW_ADAMANTINE_BLOCK = registerBlock("raw_adamantine_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).sound(SoundType.STONE)));
    public static final  RegistryObject<Block> ADAMANTINE_ORE = registerBlock("adamantine_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));

    public static final RegistryObject<Block> MITHRAL_BLOCK = registerBlock("mithral_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.METAL)));
    public static final  RegistryObject<Block> MITHRAL_ORE = registerBlock("mithral_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(1, 3)));

    public static final RegistryObject<Block> HORN_BLOCK = registerBlock("horn_block",
            () -> new SoundBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> MARBLE_BLOCK = registerBlock("marble_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> COBBLED_MARBLE = registerBlock("marble_cobble_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> TILED_MARBLE = registerBlock("marble_tile_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> MARBLE_STAIRS = registerBlock("marble_stairs",
            () -> new StairBlock(() -> ModBlocks.MARBLE_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> MARBLE_SLAB = registerBlock("marble_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> MARBLE_BUTTON = registerBlock("marble_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).sound(SoundType.STONE),
                    BlockSetType.IRON, 10, true));
    public static final RegistryObject<Block> MARBLE_PRESSURE_PLATE = registerBlock("marble_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.STONE),
            BlockSetType.IRON));
    public static final RegistryObject<Block> MARBLE_FENCE = registerBlock("marble_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> MARBLE_FENCE_GATE = registerBlock("marble_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.STONE), SoundEvents.CHAIN_PLACE, SoundEvents.CHAIN_BREAK));
    public static final RegistryObject<Block> MARBLE_WALL = registerBlock("marble_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.STONE)));

    public static final RegistryObject<Block> MARBLE_DOOR = registerBlock("marble_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion().sound(SoundType.STONE), BlockSetType.STONE));
    public static final RegistryObject<Block> MARBLE_TRAPDOOR = registerBlock("marble_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.STONE).noOcclusion().sound(SoundType.STONE), BlockSetType.STONE));

        public static final RegistryObject<Block> BELLBERRY_CROP = BLOCKS.register("bellberry_crop",
            () -> new BellberryCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));

    public static final RegistryObject<Block> SALT_CROP = BLOCKS.register("salt_crop",
            () -> new SaltCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));


    public static final RegistryObject<Block> MOONDEW = registerBlock("moondew",
            () -> new FlowerBlock(() -> MobEffects.LUCK, 5,
                    BlockBehaviour.Properties.copy(Blocks.ALLIUM).noOcclusion().noCollission()));
    public static final RegistryObject<Block> POTTED_MOONDEW = BLOCKS.register("potted_moondew",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.MOONDEW,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM).noOcclusion()));



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
