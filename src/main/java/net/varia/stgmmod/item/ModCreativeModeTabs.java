package net.varia.stgmmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.varia.stgmmod.SGtMMod;
import net.varia.stgmmod.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SGtMMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> SGTM_TAB = CREATIVE_MODE_TABS.register("sgtm_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ADAMANTINE_INGOT.get()))
                    .title(Component.translatable("creativetab.sgtm_tab"))
                    .displayItems((itemDisplayParameters, output) -> {

                        output.accept(ModBlocks.ADAMANTINE_BLOCK.get());
                        output.accept(ModBlocks.RAW_ADAMANTINE_BLOCK.get());
                        output.accept(ModBlocks.ADAMANTINE_ORE.get());
                        output.accept(ModItems.ADAMANTINE_INGOT.get());
                        output.accept(ModItems.RAW_ADAMANTINE.get());
                        output.accept(ModItems.ADAMANTINE_AXE.get());
                        output.accept(ModItems.ADAMANTINE_SWORD.get());
                        output.accept(ModItems.ADAMANTINE_PICKAXE.get());
                        output.accept(ModItems.ADAMANTINE_SHOVEL.get());
                        output.accept(ModItems.ADAMANTINE_HOE.get());
                        output.accept(ModItems.ADAMANTINE_HELMET.get());
                        output.accept(ModItems.ADAMANTINE_CHESTPLATE.get());
                        output.accept(ModItems.ADAMANTINE_LEGGINGS.get());
                        output.accept(ModItems.ADAMANTINE_BOOTS.get());

                        output.accept(ModBlocks.MITHRAL_ORE.get());
                        output.accept(ModBlocks.MITHRAL_BLOCK.get());
                        output.accept(ModItems.MITHRAL_DUST.get());
                        output.accept(ModItems.MITHRAL_CLUSTER.get());
                        output.accept(ModItems.MITHRAL_INGOT.get());
                        output.accept(ModItems.MITHRAL_HELMET.get());
                        output.accept(ModItems.MITHRAL_CHESTPLATE.get());
                        output.accept(ModItems.MITHRAL_LEGGINGS.get());
                        output.accept(ModItems.MITHRAL_BOOTS.get());

                        output.accept(ModItems.DWARVEN_STEEL_INGOT.get());
                        output.accept(ModItems.DWARVEN_STEEL_AXE.get());
                        output.accept(ModItems.DWARVEN_STEEL_SWORD.get());
                        output.accept(ModItems.DWARVEN_STEEL_PICKAXE.get());
                        output.accept(ModItems.DWARVEN_STEEL_SHOVEL.get());
                        output.accept(ModItems.DWARVEN_STEEL_HOE.get());
                        output.accept(ModItems.DWARVEN_STEEL_HELMET.get());
                        output.accept(ModItems.DWARVEN_STEEL_CHESTPLATE.get());
                        output.accept(ModItems.DWARVEN_STEEL_LEGGINGS.get());
                        output.accept(ModItems.DWARVEN_STEEL_BOOTS.get());

                        output.accept(ModBlocks.HORN_BLOCK.get());

                        output.accept(ModBlocks.MARBLE_BLOCK.get());
                        output.accept(ModBlocks.COBBLED_MARBLE.get());
                        output.accept(ModBlocks.TILED_MARBLE.get());
                        output.accept(ModBlocks.MARBLE_STAIRS.get());
                        output.accept(ModBlocks.MARBLE_SLAB.get());
                        output.accept(ModBlocks.MARBLE_BUTTON.get());
                        output.accept(ModBlocks.MARBLE_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.MARBLE_FENCE.get());
                        output.accept(ModBlocks.MARBLE_FENCE_GATE.get());
                        output.accept(ModBlocks.MARBLE_WALL.get());
                        output.accept(ModBlocks.MARBLE_DOOR.get());
                        output.accept(ModBlocks.MARBLE_TRAPDOOR.get());

                        output.accept(ModItems.IMBUED_STRING.get());
                        output.accept(ModItems.IMBUED_LAPIS.get());

                        output.accept(ModItems.INFERNAL_COAL.get());
                        output.accept(ModItems.METAL_DETECTOR.get());
                        output.accept(ModItems.BASIC_STAFF.get());

                        output.accept(ModItems.RAW_OWLBEAR.get());
                        output.accept(ModItems.OWLBEAR_STEAK.get());
                        output.accept(ModItems.OWLBEAR_STEW.get());

                        output.accept(ModItems.BELLBERRY.get());
                        output.accept(ModItems.BELLBERRY_SEEDS.get());

                        output.accept(ModItems.SALT_CANE.get());
                        output.accept(ModItems.SALT_SEEDS.get());
                        output.accept(ModItems.SALT.get());

                        output.accept(ModBlocks.MOONDEW.get());

                        output.accept(ModItems.CHEESE.get());
                        output.accept(ModItems.BLUE_CHEESE.get());
                        output.accept(ModItems.GOAT_CHEESE.get());
                        output.accept(ModItems.CREAM_CHEESE.get());

                        output.accept(ModItems.SALTED_PORKCHOP.get());
                        output.accept(ModItems.PORK_CRACKLING.get());

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
