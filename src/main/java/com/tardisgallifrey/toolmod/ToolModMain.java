package com.tardisgallifrey.toolmod;

import com.tardisgallifrey.toolmod.Init.EnchantmentInit;
import com.tardisgallifrey.toolmod.Init.ItemInit;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;



//This is the project for tools and armor
//Both are created in a similar manner

@Mod(ToolModMain.MOD_ID)
public class ToolModMain {
    public static final String MOD_ID = "toolmod";

    public ToolModMain() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::setup);
        ItemInit.ITEMS.register(modEventBus);
        EnchantmentInit.ENCHANTMENTS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    //call setup method with param of
    //event of type FMLCommonSetupEvent
    private void setup(final FMLCommonSetupEvent event) {

    }
}
