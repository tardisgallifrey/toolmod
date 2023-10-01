package com.tardisgallifrey.toolmod.items;

import com.tardisgallifrey.toolmod.util.IDamageHandlingArmor;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class FlamingArmorItem extends ArmorItem {
    public FlamingArmorItem(ArmorMaterial p_40386_,
                            EquipmentSlot p_40387_,
                            Properties p_40388_) {
        super(p_40386_, p_40387_, p_40388_);
    }

    @Override
    public void onArmorTick(ItemStack stack,
                            @NotNull Level world,
                            Player player) {

        if (!world.isClientSide()){
               player.addEffect(
                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE,
                            500));
            player.addEffect(
                    new MobEffectInstance(MobEffects.REGENERATION,
                            500));
        }
    }



    public float onDamaged(LivingEntity entity,
                           EquipmentSlot slot,
                           @NotNull DamageSource source,
                           float amount) {
        Entity attacker = source.getEntity();
        if (attacker instanceof LivingEntity){
            attacker.hurt(DamageSource.ON_FIRE,
                    amount / 2);
            attacker.setSecondsOnFire(4);
            return amount / 2;
        } else {
            return amount;
        }
    }
}
