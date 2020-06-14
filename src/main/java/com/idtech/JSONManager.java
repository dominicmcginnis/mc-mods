package com.idtech;

import java.util.Set;

import io.mcmods.restaurantmod.RestaurantMod;
import io.mcmods.restaurantmod.init.ModItemGroups;
import io.mcmods.restaurantmod.init.ModItems;
import io.mcmods.restaurantmod.item.QuickItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

public class JSONManager {
	
	public static final String assetsDir = "../src/main/resources/assets/" + RestaurantMod.MODID;
	public static final String dataDir = "../src/main/resources/data/" + RestaurantMod.MODID;


	public static String jsonName(String s) {
		StringBuilder b = new StringBuilder(s.length());
		for (char c : s.toCharArray())
			b.append(Character.isAlphabetic(c) ? Character.toLowerCase(c) : c);
		return b.toString();
	}
	
	public static String safeString(String s){
		StringBuilder b = new StringBuilder(s.length());
		for(char c : s.toCharArray())
			b.append(Character.isAlphabetic(c) ? c : '_');
		return b.toString();
	}

}
