package com.tardisgallifrey.toolmod.Init;

import com.tardisgallifrey.toolmod.enchants.DistanceEnchantment;
import com.tardisgallifrey.toolmod.ToolModMain;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EnchantmentInit {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS =
            DeferredRegister.create(ForgeRegistries.ENCHANTMENTS,
                    ToolModMain.MOD_ID);

    public static final RegistryObject<Enchantment> DISTANCE =
            ENCHANTMENTS.register("distance",
                    DistanceEnchantment::new);
}
