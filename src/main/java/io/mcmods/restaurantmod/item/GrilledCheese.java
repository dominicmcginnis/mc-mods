package io.mcmods.restaurantmod.item;

import net.minecraft.item.Food;
import net.minecraft.item.Item;

public class GrilledCheese extends QuickItem {
    private static int healthAmount = 3;
    private static float saturation = 0.2f;
    {
        name = "Grilled_Cheese";
        texture = "grilled_cheese";
        type = ItemType.HandHeld;
    }
    public GrilledCheese() {
        super((new Item.Properties().food( (new Food.Builder()).hunger(healthAmount).saturation(saturation).build())));
    }

}

