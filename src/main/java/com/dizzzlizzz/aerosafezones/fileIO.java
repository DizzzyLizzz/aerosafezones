package com.dizzzlizzz.aerosafezones;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import org.slf4j.Logger;
import com.mojang.logging.LogUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class fileIO {
    public static final Logger LOGGER = LogUtils.getLogger();



    @EventBusSubscriber(modid = "aerosafezones")
    public static class EventHandler {
        @SubscribeEvent
        public static void ASZCommonSetup(FMLCommonSetupEvent event){

            Path path = Paths.get("./AeroSafeZones/");
            try {
                // Creates the directory and any non-existent parent directories
                Files.createDirectories(path);
                LOGGER.info("Directory is ready!");
            } catch (IOException e) {
                LOGGER.info("Failed to create directory: {}", e.getMessage());
            }

            try {
                File markerFile = new File("./AeroSafeZones/SafeZones.txt");
                if (markerFile.createNewFile()) {
                    LOGGER.info("File created: {}", markerFile.getName());
                } else {
                    LOGGER.info("File already exists.");
                }
            } catch (IOException e) {
                System.out.println("An error occurred.");
                LOGGER.info(String.valueOf(e));
            }
        }}

}
