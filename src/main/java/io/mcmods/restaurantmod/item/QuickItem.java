package io.mcmods.restaurantmod.item;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import io.mcmods.restaurantmod.RestaurantMod;
import io.mcmods.restaurantmod.init.ModItemGroups;
import io.mcmods.restaurantmod.init.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import org.apache.commons.io.FileUtils;

import com.idtech.JSONManager;
import com.idtech.PackageManager;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class QuickItem extends Item {

	public static enum ItemType {
		Generated, HandHeld;
	}
	public String name = "Undefined";
	protected String texture = "undefined";
	protected ItemType type = ItemType.Generated;

	protected World world;
	protected PlayerEntity player;
	protected Hand hand;

	/**
	 * Creates a new QuickItem and adds it to the registry. (Note: You probably
	 * shouldn't be calling this directly)
	 */

	protected QuickItem() {
		super((new Item.Properties().group((ModItemGroups.MOD_ITEM_GROUP))));
	}

	/**
	 * Creates a new QuickItem and adds it to the registry. (Note: You probably
	 * shouldn't be calling this directly)
	 */
	protected QuickItem(Item.Properties properties) {
		super(properties.group((ModItemGroups.MOD_ITEM_GROUP)));
	}

	public String getMyName() {
		return this.name;
	}


	/**
	 * This method is called each time the item is right clicked. Prior to being
	 * called, player, world, and hand are all updated.
	 */
	protected void onRightClick() {
	}


	/**
	 * This method creates the JSON Files necessary for the Minecraft mod. If
	 * you want to use your own custom JSON files @Override this method.
	 */
	public void createJSONFile() {
		File f = Paths.get(".").resolve(JSONManager.assetsDir + "/models/item/" + JSONManager.jsonName(name) + ".json")
				.toFile();

		if (f.exists()) {
			return;
		}

		StringBuilder builder = new StringBuilder();

		builder.append("{");
		builder.append("\"parent\": \"item/" + type.toString().toLowerCase() + "\",");
		builder.append("\"textures\": {");
		builder.append("   \"layer0\": \"" + RestaurantMod.MODID + ":items/" + texture + "\"");
		builder.append("}");
		builder.append("}");

		try {
			FileUtils.writeStringToFile(f, builder.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
