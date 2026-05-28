package com.dizzzlizzz.aerosafezones;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.neoforge.common.NeoForge;
import org.jetbrains.annotations.NotNull;
import xaero.pac.common.claims.api.IClaimsManagerAPI;
import xaero.pac.common.claims.player.api.IPlayerChunkClaimAPI;
import xaero.pac.common.claims.player.api.IPlayerDimensionClaimsAPI;
import xaero.pac.common.claims.tracker.api.IClaimsManagerListenerAPI;
import xaero.pac.common.claims.tracker.api.IClaimsManagerTrackerAPI;
import xaero.pac.server.LoadDedicatedServer;
import xaero.pac.server.LoadDedicatedServerNeoForge;

import java.util.Map;
import java.util.stream.Stream;

public class SZopac {

    public SZopac (IEventBus modEventBus, ModContainer modContainer){

        modEventBus.addListener(this::commonSetup);


        NeoForge.EVENT_BUS.register(this);
    }
    IClaimsManagerTrackerAPI SZClaimsTracker = new IClaimsManagerTrackerAPI() {
        @Override
        public void register(@NotNull IClaimsManagerListenerAPI iClaimsManagerListenerAPI) {

        }
    };
    public void OpacLoadServer(LoadDedicatedServerNeoForge event){


    }



}
