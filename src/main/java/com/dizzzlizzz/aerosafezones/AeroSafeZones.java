package com.dizzzlizzz.aerosafezones;


import com.mapter.aeroclaims.claim.Claim;
import com.mapter.aeroclaims.claim.ClaimManager;
import net.minecraft.core.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.event.tick.ServerTickEvent;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;


import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;




import static com.dizzzlizzz.aerosafezones.Config.safeZoneRadiusFromSpawn;
import static com.mapter.aeroclaims.claim.ClaimManager.*;
import static com.mapter.aeroclaims.sublevel.SableShipUtils.isOnShip;


// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(AeroSafeZones.MODID)
public class AeroSafeZones {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "aerosafezones";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();


    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public AeroSafeZones(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);


        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (AeroSafeZones) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);


        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");


    }

    private boolean isWithinRange(BlockPos center, BlockPos target, int range) {
        if (Math.abs(center.getX() - target.getX()) <= range &&
                Math.abs(center.getY() - target.getY()) <= range &&
                Math.abs(center.getZ() - target.getZ()) <= range) {
            return true;
        } else {return false;}
    }
    int tickCounter;
    BlockPos zeroZero = new BlockPos(0, 0, 0);

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void ServerTickEvent(ServerTickEvent.Post event) {

        if (++tickCounter > 20) { // Fires roughly once per second
            // Your logic
            MinecraftServer server = event.getServer();
            tickCounter = 0;

            //checks if player is on ship
            for (ServerPlayer player : server.getPlayerList().getPlayers()) {
                BlockPos playerPos = player.blockPosition();
                ServerLevel serverLevel = (ServerLevel) player.level();
                if(isOnShip(serverLevel, playerPos)){
                    Claim shipClaim = getClaimAt(serverLevel, playerPos);
                    if(shipClaim != null){
                        if(shipClaim.isActive()){
                            if(!isWithinRange(zeroZero, playerPos, safeZoneRadiusFromSpawn.getAsInt() ) ){
                                deactivateClaim(serverLevel, playerPos);
                                LOGGER.info("Deactivated Claim");
                            }
                        }
                    }

                }
            }
        }
    }
}
