package com.tardisgallifrey.toolmod.util;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;


//This class is an INTERFACE
//It is expected that one will override
//and/or add to its methods when called
//in other modules
public interface IDamageHandlingArmor {

    //a default framework of a method
    //to override in an instance call
    default float onDamaged(LivingEntity entity,
                            EquipmentSlot slot,
                            DamageSource source,
                            float amount){
        return amount;
    }
}