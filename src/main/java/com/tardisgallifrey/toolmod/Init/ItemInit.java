package com.tardisgallifrey.toolmod.Init;

import com.tardisgallifrey.toolmod.util.ModItemTier;
import com.tardisgallifrey.toolmod.util.ModArmorMaterial;
import com.tardisgallifrey.toolmod.ToolModMain;
import com.tardisgallifrey.toolmod.items.TeleportStaff;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

//This is the Item Init(ialization) class
//There can be one for Blocks and
// ones for other Entities

public class ItemInit {

    //no constructor in this class


    //This registers our ITEMS, deferred
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS,
                    ToolModMain.MOD_ID);


    //This registers our TELEPORT_STAFF object to ITEMS
    public static final RegistryObject<Item> TELEPORT_STAFF = ITEMS.register("teleport_staff",
            () -> new TeleportStaff(new Item.Properties()
                    .tab(ModCreativeTab.instance)
                    .durability(100)));

    public static final RegistryObject<Item> PINK_SWORD =
            ITEMS.register("pink_sword",
            () -> new SwordItem(ModItemTier.PINK,
                    3, -2.4F,
                    new Item.Properties()
                            .tab(ModCreativeTab.instance)));

    public static final RegistryObject<Item> THORS_SWORD =
            ITEMS.register("thors_sword",
                    () -> new SwordItem(ModItemTier.GODLEVEL,
                            1000, -5.5F,
                            new Item.Properties()
                                    .tab(ModCreativeTab.instance)));

    public static final RegistryObject<Item> PINK_PICKAXE =
            ITEMS.register("pink_pickaxe",
            () -> new PickaxeItem(ModItemTier.PINK,
                    1, -1.0F,
                    new Item.Properties()
                            .tab(ModCreativeTab.instance)));

    public static final RegistryObject<Item> PINK_AXE =
            ITEMS.register("pink_axe",
            () -> new AxeItem(ModItemTier.PINK,
                    6, -3.4F, new Item
                    .Properties()
                    .tab(ModCreativeTab.instance)));

    public static final RegistryObject<Item> PINK_SHOVEL = ITEMS.register("pink_shovel",
            () -> new ShovelItem(ModItemTier.PINK,
                    1, -1.0F,
                    new Item.Properties()
                            .tab(ModCreativeTab.instance)));

    public static final RegistryObject<Item> PINK_HOE =
            ITEMS.register("pink_hoe",
            () -> new HoeItem(ModItemTier.PINK,
                    0, -1.0F,
                    new Item.Properties()
                            .tab(ModCreativeTab.instance)));


    //REGISTER OF ARMOR
    public static final RegistryObject<Item> PINK_HELMET =
            ITEMS.register("pink_helmet",
            () -> new ArmorItem(ModArmorMaterial.PINK,
                    EquipmentSlot.HEAD,
                    new Item.Properties()
                            .tab(ModCreativeTab.instance)));

    public static final RegistryObject<Item> PINK_CHESTPLATE =
            ITEMS.register("pink_chestplate",
            () -> new ArmorItem(ModArmorMaterial.PINK,
                    EquipmentSlot.CHEST,
                    new Item.Properties().tab(ModCreativeTab.instance)));

    public static final RegistryObject<Item> PINK_LEGGINGS =
            ITEMS.register("pink_leggings",
            () -> new ArmorItem(ModArmorMaterial.PINK,
                    EquipmentSlot.LEGS,
                    new Item.Properties().tab(ModCreativeTab.instance)));

    public static final RegistryObject<Item> PINK_BOOTS =
            ITEMS.register("pink_boots",
            () -> new ArmorItem(ModArmorMaterial.PINK,
                    EquipmentSlot.FEET,
                    new Item.Properties().tab(ModCreativeTab.instance)));

    //This creates a Creative Mode Tab for all items
    public static class ModCreativeTab extends CreativeModeTab {
        private ModCreativeTab(int index, String label) {
            super(index, label);
        }

        @Override
        public @NotNull ItemStack makeIcon() {

            return new ItemStack(TELEPORT_STAFF.get());
        }

        //This creates an instance of the above
        //creative mode tab
        public static final ModCreativeTab instance =
                new ModCreativeTab(CreativeModeTab
                        .TABS.length, "toolmod");
    }
}
