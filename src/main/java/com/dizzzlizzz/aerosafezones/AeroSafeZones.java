package com.dizzzlizzz.aerosafezones;


import com.mapter.aeroclaims.claim.Claim;
import dev.ryanhcode.sable.Sable;
import dev.ryanhcode.sable.companion.SableCompanion;
import dev.ryanhcode.sable.companion.math.BoundingBox3d;
import dev.ryanhcode.sable.companion.math.Pose3d;
import dev.ryanhcode.sable.companion.math.Pose3dc;
import dev.ryanhcode.sable.sublevel.SubLevel;
import dev.ryanhcode.sable.sublevel.plot.LevelPlot;
import net.minecraft.core.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.tick.ServerTickEvent;

import org.joml.Vector3d;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;


import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;


import java.util.Arrays;

import static com.mapter.aeroclaims.claim.ClaimManager.*;
import static com.mapter.aeroclaims.sublevel.SableShipUtils.getShipAt;
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
                Math.abs(center.getZ() - target.getZ()) <= range) {
            return true;
        } else {return false;}
    }
    int tickCounter;
    BlockPos zeroZero = new BlockPos(1, 64, 1);

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerTick(ServerTickEvent.Post event) {

        if (++tickCounter > 20) { // Fires roughly once per second
            // Your logic
            MinecraftServer server = event.getServer();
            int radiusMarker = 500;
            tickCounter = 0;


            for (ServerPlayer player : server.getPlayerList().getPlayers()) {
                BlockPos playerPos = player.getOnPos();
                ServerLevel serverLevel = (ServerLevel) player.level();
                //checks if player is on ship
                if(isOnShip(serverLevel, playerPos)) {
                    SubLevel playerShip = getShipAt(serverLevel, playerPos);
                    //is ship if not null, trigger the claim check
                    if(playerShip != null){
                        Claim playerClaim = getClaimAt(serverLevel, playerPos);
                        //if claim is not null, assigned claim to playerClaim
                        if (playerClaim != null) {
                            Claim shipClaim = getClaimAt(serverLevel, playerPos);
                            //if claim is not null, find center as BlockPos
                            if (shipClaim != null) {
                                BlockPos claimCenter = shipClaim.getCenter();
                                //if claim is active and is not within radiusMarker, disable claim
                                if (shipClaim.isActive()){
                                    LOGGER.info("s");
                                    if(!isWithinRange(zeroZero, playerPos, radiusMarker)) {
                                        deactivateClaim(serverLevel, claimCenter);
                                        String shipCenterStr = Arrays.toString(claimCenter.toString().split(","));
                                        LOGGER.info("Deactivated Claim at " +  shipCenterStr);
                                    }
                                }
                            }
                        }
                    }

                }
            }
        }
    }
}
