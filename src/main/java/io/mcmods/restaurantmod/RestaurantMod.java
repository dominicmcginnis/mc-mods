package io.mcmods.restaurantmod;

import com.idtech.JSONManager;
import io.mcmods.restaurantmod.init.ModItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Cadiboo
 */
@Mod(RestaurantMod.MODID)
public final class RestaurantMod {

	public static final String MODID = "restaurantmod";

	public static final Logger LOGGER = LogManager.getLogger(MODID);

	public RestaurantMod() {
		LOGGER.debug("------------------------------------------------------Hello from Example Mod!");

		final ModLoadingContext modLoadingContext = ModLoadingContext.get();
		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		ModItems.ITEMS.register(modEventBus);
	}

}
