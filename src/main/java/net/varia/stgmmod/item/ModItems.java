package net.varia.stgmmod.item;

import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.varia.stgmmod.SGtMMod;
import net.varia.stgmmod.block.ModBlocks;
import net.varia.stgmmod.item.custom.FuelItem;
import net.varia.stgmmod.item.custom.MetalDetectorItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SGtMMod.MOD_ID);

    public static final RegistryObject<Item> ADAMANTINE_INGOT = ITEMS.register("adamantine_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_ADAMANTINE = ITEMS.register("raw_adamantine",
            () ->new Item(new Item.Properties()));

    public static final RegistryObject<Item> MITHRAL_DUST = ITEMS.register("mithral_dust",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MITHRAL_CLUSTER = ITEMS.register("mithral_cluster",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MITHRAL_INGOT = ITEMS.register("mithral_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> IMBUED_STRING = ITEMS.register("imbued_string",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> IMBUED_LAPIS = ITEMS.register("imbued_lapis",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> MITHRAL_HELMET = ITEMS.register("mithral_helmet",
            () -> new ArmorItem(ModArmorMaterials.MITHRAL_INGOT, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> MITHRAL_CHESTPLATE = ITEMS.register("mithral_chestplate",
            () -> new ArmorItem(ModArmorMaterials.MITHRAL_INGOT, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> MITHRAL_LEGGINGS = ITEMS.register("mithral_leggings",
            () -> new ArmorItem(ModArmorMaterials.MITHRAL_INGOT, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> MITHRAL_BOOTS = ITEMS.register("mithral_boots",
            () -> new ArmorItem(ModArmorMaterials.MITHRAL_INGOT, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> DWARVEN_STEEL_INGOT = ITEMS.register("dwarven_steel_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DWARVEN_STEEL_HELMET = ITEMS.register("dwarven_steel_helmet",
            () -> new ArmorItem(ModArmorMaterials.DWARVEN_STEEL_INGOT, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> DWARVEN_STEEL_CHESTPLATE = ITEMS.register("dwarven_steel_chestplate",
            () -> new ArmorItem(ModArmorMaterials.DWARVEN_STEEL_INGOT, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> DWARVEN_STEEL_LEGGINGS = ITEMS.register("dwarven_steel_leggings",
            () -> new ArmorItem(ModArmorMaterials.DWARVEN_STEEL_INGOT, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> DWARVEN_STEEL_BOOTS = ITEMS.register("dwarven_steel_boots",
            () -> new ArmorItem(ModArmorMaterials.DWARVEN_STEEL_INGOT, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> DWARVEN_STEEL_SWORD = ITEMS.register("dwarven_steel_sword",
            () -> new SwordItem(ModToolTiers.ADAMANTINE, 4, 2, new Item.Properties()));
    public static final RegistryObject<Item> DWARVEN_STEEL_PICKAXE = ITEMS.register("dwarven_steel_pickaxe",
            () -> new PickaxeItem(ModToolTiers.ADAMANTINE, 1, 1, new Item.Properties()));
    public static final RegistryObject<Item> DWARVEN_STEEL_AXE = ITEMS.register("dwarven_steel_axe",
            () -> new AxeItem(ModToolTiers.ADAMANTINE, 7, 1, new Item.Properties()));
    public static final RegistryObject<Item> DWARVEN_STEEL_SHOVEL = ITEMS.register("dwarven_steel_shovel",
            () -> new ShovelItem(ModToolTiers.ADAMANTINE, 0, 0, new Item.Properties()));
    public static final RegistryObject<Item> DWARVEN_STEEL_HOE = ITEMS.register("dwarven_steel_hoe",
            () -> new HoeItem(ModToolTiers.ADAMANTINE, 0, 0, new Item.Properties()));

    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () ->new MetalDetectorItem(new Item.Properties().durability(50)));
    public static final RegistryObject<Item> BASIC_STAFF = ITEMS.register("basic_staff",
            () ->new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> RAW_OWLBEAR = ITEMS.register("raw_owlbear",
            () ->new Item(new Item.Properties()));
    public static final RegistryObject<Item> OWLBEAR_STEAK = ITEMS.register("owlbear_steak",
            () ->new Item(new Item.Properties().food(ModFoods.OWLBEAR_STEAK)));
    public static final RegistryObject<Item> OWLBEAR_STEW = ITEMS.register("owlbear_stew",
            () ->new Item(new Item.Properties().food(ModFoods.OWLBEAR_STEW)));

    public static final RegistryObject<Item> BELLBERRY = ITEMS.register("bellberry",
            () ->new Item(new Item.Properties().food(ModFoods.BELLBERRY)));
    public static final RegistryObject<Item> BELLBERRY_SEEDS = ITEMS.register("bellberry_seeds",
            () -> new ItemNameBlockItem(ModBlocks.BELLBERRY_CROP.get(), new Item.Properties()));

    public static final RegistryObject<Item> SALT_CANE = ITEMS.register("salt_cane",
            () ->new Item(new Item.Properties().food(ModFoods.SALT_CANE)));
    public static final RegistryObject<Item> SALT_SEEDS = ITEMS.register("salt_seeds",
            () -> new ItemNameBlockItem(ModBlocks.SALT_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> SALT = ITEMS.register("salt",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SALTED_PORKCHOP = ITEMS.register("salted_porkchop",
            () ->new Item(new Item.Properties().food(ModFoods.SALTED_PORKCHOP)));
    public static final RegistryObject<Item> PORK_CRACKLING = ITEMS.register("pork_crackling",
            () ->new Item(new Item.Properties().food(ModFoods.PORK_CRACKLING)));
    public static final RegistryObject<Item> CHEESE = ITEMS.register("cheese",
            () ->new Item(new Item.Properties().food(ModFoods.CHEESE)));
    public static final RegistryObject<Item> BLUE_CHEESE = ITEMS.register("blue_cheese",
            () ->new Item(new Item.Properties().food(ModFoods.BLUE_CHEESE)));
    public static final RegistryObject<Item> GOAT_CHEESE = ITEMS.register("goat_cheese",
            () ->new Item(new Item.Properties().food(ModFoods.GOAT_CHEESE)));
    public static final RegistryObject<Item> CREAM_CHEESE = ITEMS.register("cream_cheese",
            () ->new Item(new Item.Properties().food(ModFoods.CREAM_CHEESE)));

    public static final RegistryObject<Item> ADAMANTINE_SWORD = ITEMS.register("adamantine_sword",
            () -> new SwordItem(ModToolTiers.ADAMANTINE, 4, 2, new Item.Properties()));
    public static final RegistryObject<Item> ADAMANTINE_PICKAXE = ITEMS.register("adamantine_pickaxe",
            () -> new PickaxeItem(ModToolTiers.ADAMANTINE, 1, 1, new Item.Properties()));
    public static final RegistryObject<Item> ADAMANTINE_AXE = ITEMS.register("adamantine_axe",
            () -> new AxeItem(ModToolTiers.ADAMANTINE, 7, 1, new Item.Properties()));
    public static final RegistryObject<Item> ADAMANTINE_SHOVEL = ITEMS.register("adamantine_shovel",
            () -> new ShovelItem(ModToolTiers.ADAMANTINE, 0, 0, new Item.Properties()));
    public static final RegistryObject<Item> ADAMANTINE_HOE = ITEMS.register("adamantine_hoe",
            () -> new HoeItem(ModToolTiers.ADAMANTINE, 0, 0, new Item.Properties()));

    public static final RegistryObject<Item> ADAMANTINE_HELMET = ITEMS.register("adamantine_helmet",
            () -> new ArmorItem(ModArmorMaterials.ADAMANTINE_INGOT, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> ADAMANTINE_CHESTPLATE = ITEMS.register("adamantine_chestplate",
            () -> new ArmorItem(ModArmorMaterials.ADAMANTINE_INGOT, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> ADAMANTINE_LEGGINGS = ITEMS.register("adamantine_leggings",
            () -> new ArmorItem(ModArmorMaterials.ADAMANTINE_INGOT, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> ADAMANTINE_BOOTS = ITEMS.register("adamantine_boots",
            () -> new ArmorItem(ModArmorMaterials.ADAMANTINE_INGOT, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> INFERNAL_COAL = ITEMS.register("infernal_coal",
            () ->new FuelItem(new Item.Properties(), 30000));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
