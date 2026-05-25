package com.dizzzlizzz.aerosafezones;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import org.slf4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ASZCommonSetup {
    public static final Logger LOGGER = LogUtils.getLogger();

    @EventBusSubscriber(modid = "aerosafezones")
    public static class EventHandler {
        @SubscribeEvent
        public static void ASZCommonSetup(FMLCommonSetupEvent event){

            Path path = Paths.get("./config/ASZ/SafeZones");
            try {
                // Creates the directory and any non-existent parent directories
                Files.createDirectories(path);
                LOGGER.info("ASZ Directory is ready!");
            } catch (IOException e) {
                LOGGER.info("Failed to create ASZ directory: {}", e.getMessage());
            }

            try {
                File SZFile = new File("./config/ASZ/SafeZones/SafeZones.txt");
                if (SZFile.createNewFile()) {
                    LOGGER.info("ASZ File created: {}", SZFile.getName());
                } else {
                    LOGGER.info("ASZ File already exists.");
                }
            } catch (IOException e) {
                System.out.println("An error occurred.");
                LOGGER.info(String.valueOf(e));
            }
        }}}