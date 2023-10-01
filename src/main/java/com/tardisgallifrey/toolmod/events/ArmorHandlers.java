package com.tardisgallifrey.toolmod.events;

import com.tardisgallifrey.toolmod.util.IDamageHandlingArmor;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ArmorHandlers {

    @SubscribeEvent
    public static void armorAttackHandler(@NotNull LivingDamageEvent event){
        for (ItemStack armor : event.getEntity()
                .getArmorSlots()){
            if (armor.getItem() instanceof IDamageHandlingArmor){
                float newDamage = ((IDamageHandlingArmor)armor.getItem())
                        .onDamaged(event.getEntity(),
                                armor.getEquipmentSlot(),
                                event.getSource(),
                                event.getAmount());
                event.setAmount(newDamage);
            }
        }
    }

}
