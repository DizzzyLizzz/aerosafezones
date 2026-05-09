package com.dizzzlizzz.aerosafezones;


import com.mojang.logging.LogUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartedEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xaero.pac.client.claims.tracker.result.IClaimsManagerClaimResultTracker;
import xaero.pac.client.claims.tracker.result.api.IClaimsManagerClaimResultTrackerAPI;
import xaero.pac.common.claims.player.api.IPlayerChunkClaimAPI;
import xaero.pac.common.claims.tracker.api.IClaimsManagerListenerAPI;
import xaero.pac.common.event.api.OPACServerAddonRegisterEvent;
import xaero.pac.common.server.api.OpenPACServerAPI;
import xaero.pac.common.server.claims.api.IServerClaimsManagerAPI;
import org.slf4j.Logger;
import static com.dizzzlizzz.aerosafezones.defineSafeZones.ChunkPosToBlockPOS;
import static com.dizzzlizzz.aerosafezones.defineSafeZones.isInsideSafeZone;

public class OPACcompat {


    public OPACcompat(IEventBus modEventBus, ModContainer modContainer) {

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::ServerStartedEvent);
        modEventBus.addListener(this::OPACServerAddonRegisterEvent);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (AeroSafeZones) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);


        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
    @SubscribeEvent
    private void ServerStartedEvent(ServerStartedEvent event){

    }



    public static final Logger LOGGER = LogUtils.getLogger();
    @SubscribeEvent
    private void OPACServerAddonRegisterEvent(OPACServerAddonRegisterEvent event){

        MinecraftServer server = event.getServer();

        IServerClaimsManagerAPI SZSClaims = OpenPACServerAPI.get(server).getServerClaimsManager();


        xaero.pac.common.claims.tracker.api.IClaimsManagerListenerAPI SZCListener = new SZSCListener();
        SZSClaims.getTracker().register(SZCListener);
    }


}
