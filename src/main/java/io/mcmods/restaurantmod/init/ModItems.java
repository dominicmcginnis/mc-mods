package io.mcmods.restaurantmod.init;

import com.idtech.JSONManager;
import com.idtech.PackageManager;
import io.mcmods.restaurantmod.RestaurantMod;

import io.mcmods.restaurantmod.item.QuickItem;
import net.minecraft.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;

/**
 * Holds a list of all our {@link Item}s.
 * Suppliers that create Items are added to the DeferredRegister.
 * The DeferredRegister is then added to our mod event bus in our constructor.
 * When the Item Registry Event is fired by Forge and it is time for the mod to
 * register its Items, our Items are created and registered by the DeferredRegister.
 * The Item Registry Event will always be called after the Block registry is filled.
 * Note: This supports registry overrides.
 *
 * @author Cadiboo
 */
public final class ModItems {

	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, RestaurantMod.MODID);

	// When QuickItem is loaded, it will scan the item directory for all sub
	// classes of QuickItem
	// and create a newInstance of them. This allows us to simply use the
	// initialization block to specify each parameter
	// This invokes the default super constructor of QuickItem and registers
	// it. Therefore, you should almost never
	// need to call the constructor for QuickItem manually.
	static {
		// Loads all of the QuickItems that are in this package
		Set<Class> classes = PackageManager.loadClassesInPackage("io.mcmods.restaurantmod.item");
		for (Class klass : classes) {
			if (QuickItem.class.isAssignableFrom(klass) && QuickItem.class != klass) {
				try {
					QuickItem item = (QuickItem)klass.newInstance();
					ModItems.ITEMS.register(JSONManager.jsonName(item.name), () -> item);
					item.createJSONFile();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	// This is a very simple Item. It has no special properties except for being on our creative tab.
	//public static final RegistryObject<Item> EXAMPLE_CRYSTAL = ITEMS.register("example_crystal", () -> new Item(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)));

}
