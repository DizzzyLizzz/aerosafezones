package com.dizzzlizzz.aerosafezones;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import org.slf4j.Logger;
import xaero.pac.common.claims.api.IClaimsManagerAPI;
import xaero.pac.common.claims.player.api.IPlayerChunkClaimAPI;
import xaero.pac.common.claims.tracker.api.IClaimsManagerListenerAPI;
import xaero.pac.common.server.claims.api.IServerClaimsManagerAPI;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;


//Class to update aeroclaims protection on chunk change
public class protectionUpdater {
    //Get console logger
    public static final Logger LOGGER = LogUtils.getLogger();



    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts

        LOGGER.info("");
    }

}
