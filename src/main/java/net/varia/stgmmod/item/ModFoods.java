package net.varia.stgmmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties OWLBEAR_STEAK = new FoodProperties.Builder().nutrition(4).meat()
            .saturationMod(1.6f).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 300), 1f).build();
    public static final FoodProperties OWLBEAR_STEW = new FoodProperties.Builder().nutrition(10).meat()
            .saturationMod(1.4f).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 900), 1f).build();
    public static final FoodProperties BELLBERRY = new FoodProperties.Builder().nutrition(4).fast()
            .saturationMod(0.6f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600), 1f).build();
    public static final FoodProperties SALT_CANE = new FoodProperties.Builder().nutrition(4).fast()
            .saturationMod(0.6f).effect(() -> new MobEffectInstance(MobEffects.POISON, 200), 0.3f).build();
    public static final FoodProperties SALTED_PORKCHOP = new FoodProperties.Builder().nutrition(3).meat()
            .saturationMod(0.6f).build();
    public static final FoodProperties PORK_CRACKLING = new FoodProperties.Builder().nutrition(8).meat()
            .saturationMod(1.6f).build();

    public static final FoodProperties CHEESE = new FoodProperties.Builder().nutrition(4).fast()
            .saturationMod(0.6f).build();
    public static final FoodProperties BLUE_CHEESE = new FoodProperties.Builder().nutrition(4).fast()
            .saturationMod(0.6f).effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 1200), 1f).build();
    public static final FoodProperties GOAT_CHEESE = new FoodProperties.Builder().nutrition(4).fast()
            .saturationMod(0.6f).effect(() -> new MobEffectInstance(MobEffects.JUMP, 1200), 1f).build();
    public static final FoodProperties CREAM_CHEESE = new FoodProperties.Builder().nutrition(4).fast()
            .saturationMod(0.6f).effect(() -> new MobEffectInstance(MobEffects.INVISIBILITY, 1200), 1f).build();


}