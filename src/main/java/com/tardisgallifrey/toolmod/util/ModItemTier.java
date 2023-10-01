package com.tardisgallifrey.toolmod.util;

//packages necessary to make this class work
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.util.LazyLoadedValue;
import org.jetbrains.annotations.NotNull;
import java.util.function.Supplier;

//an enum class to describe tool capabilities
public enum ModItemTier implements Tier {

    //These are the enumerations.  You call them
    //in other classes with dot notation.
    //e.g. ModItemTier.PINK
    //doing so causes PINK to run the constructor and
    //fill its abilities.
    //the enumerations are written as an
    //open array separated by commas.
    PINK(3,
            3000,
            10.0F,
            5.0F,
            5, () -> {
        return Ingredient.of(Items.STICK);
    }),
    GODLEVEL(10,
            300,
            100.0F,
            30.0F,
            100, ()->{
        return Ingredient.of(Items.NETHERITE_INGOT);
    });



    private final int level;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    //While this does look like a normal class constructor,
    //it is not.
    //Without a modifier, it defaults to private
    //It is only accessible internal to the class,
    //but each instance of the enumerations above,
    //call on it to set Item values at instantiation.
    ModItemTier(int level, int durability, float miningSpeed, float damage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.level = level;
        this.uses = durability;
        this.speed = miningSpeed;
        this.damage = damage;
        this.enchantmentValue = enchantability;
        this.repairIngredient = new LazyLoadedValue<>(repairIngredient);
    }

    //These are all public so that Tools
    //can be used in the other parts of the game
    public int getUses() {
        return this.uses;
    }

    public float getSpeed() {
        return this.speed;
    }

    public float getAttackDamageBonus() {
        return this.damage;
    }

    public int getLevel() {

        return this.level;
    }

    public int getEnchantmentValue() {

        return this.enchantmentValue;
    }

    public @NotNull Ingredient getRepairIngredient() {

        return this.repairIngredient.get();
    }
}
