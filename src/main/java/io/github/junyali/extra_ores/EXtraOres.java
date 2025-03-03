package io.github.junyali.extra_ores;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.github.junyali.extra_ores.item.ModItems;
import io.github.junyali.extra_ores.block.ModBlocks;
import io.github.junyali.extra_ores.generation.ModGeneration;

public class EXtraOres implements ModInitializer {
	public static final String MOD_ID = "extra-ores";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Mod started!");
		ModItems.initialize();
		ModBlocks.initialize();
		ModGeneration.initialize();
	}
}