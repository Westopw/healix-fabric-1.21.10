package com.westblox.healix.item;

import com.westblox.healix.Healix;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {

    //name moet lowercase zonder spaties zijn
    public static final Item PILL_CAPSULE = registerItem("pill_capsule", setting -> new Item(setting));

    //maakt item en item ID aan in registry
    public static Item registerItem(String name, Function<Item.Settings, Item> function){
        return Registry.register(Registries.ITEM, Identifier.of(Healix.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Healix.MOD_ID, name)))));
    }

    //deze method wordt door main classstop aangehaald bij initialize
    public static void registerModItems(){
        Healix.LOGGER.info("Registering Mod Items for " + Healix.MOD_ID);

        //voeg een entry / item toe aan itemgroup
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(PILL_CAPSULE);
        });
    }

}
