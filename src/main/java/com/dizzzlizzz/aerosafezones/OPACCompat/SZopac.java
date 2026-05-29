package com.dizzzlizzz.aerosafezones.OPACCompat;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ChunkPos;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.neoforge.common.NeoForge;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xaero.pac.client.event.api.OPACClientAddonRegisterEvent;
import xaero.pac.common.claims.player.api.IPlayerChunkClaimAPI;
import xaero.pac.common.claims.tracker.api.IClaimsManagerListenerAPI;
import xaero.pac.common.claims.tracker.api.IClaimsManagerTrackerAPI;
import xaero.pac.common.claims.tracker.api.IClaimsManagerTrackerRegisterAPI;
import xaero.pac.common.event.api.OPACServerAddonRegisterEvent;
import xaero.pac.common.server.api.OpenPACServerAPI;

import java.util.Objects;
import java.util.UUID;

import static com.dizzzlizzz.aerosafezones.safeZones.SZUtil.*;

public class SZopac {

    public SZopac (IEventBus modEventBus, ModContainer modContainer){

        modEventBus.addListener(this::OpacClientRegister);
        modEventBus.addListener(this::OpacServerRegister);

        NeoForge.EVENT_BUS.register(this);
    }

//    IClaimsManagerTrackerAPI SZClaimsTracker = new IClaimsManagerTrackerAPI() {
//        @Override
//        public void register(@NotNull IClaimsManagerListenerAPI iClaimsManagerListenerAPI) {
//
//        }
//    };

    public void OpacServerRegister(OPACServerAddonRegisterEvent event){
        IClaimsManagerTrackerRegisterAPI SZServerTracker = event.getClaimsManagerTrackerAPI();
        IClaimsManagerListenerAPI SZServeListener = new IClaimsManagerListenerAPI() {
            UUID wEMP = new UUID(0,0);
            @Override
            public void onWholeRegionChange(@NotNull ResourceLocation resourceLocation, int i, int i1) {

            }

            @Override
            public void onChunkChange(@NotNull ResourceLocation resourceLocation, int i, int i1, @Nullable IPlayerChunkClaimAPI iPlayerChunkClaimAPI) {
                LOGGER.info("SZ Chunk Change Fired");
                MinecraftServer SZServer = event.getServer();
                UUID Pid = Objects.requireNonNull(iPlayerChunkClaimAPI).getPlayerId();
                if(Pid != wEMP){
                    ChunkPos claimCPos = new ChunkPos(i,i1);
                    BlockPos chunkCenter = ChunkCenterBlockPos(claimCPos);
                    if(!isInsideSafeZone(chunkCenter)){

                        OpenPACServerAPI.get(SZServer).getServerClaimsManager().unclaim(resourceLocation,i,i1);

                    }
                }

            }

            @Override
            public void onDimensionChange(ResourceLocation resourceLocation) {

            }
        };
        SZServerTracker.register(SZServeListener);

    }

    public void OpacClientRegister(OPACClientAddonRegisterEvent event){
        IClaimsManagerTrackerRegisterAPI SZClientTracker = event.getClaimsManagerTrackerAPI();
        IClaimsManagerListenerAPI SZListener = new IClaimsManagerListenerAPI() {
            @Override
            public void onWholeRegionChange(@NotNull ResourceLocation resourceLocation, int i, int i1) {

            }
            @Override
            public void onChunkChange(@NotNull ResourceLocation resourceLocation, int i, int i1, @Nullable IPlayerChunkClaimAPI iPlayerChunkClaimAPI) {


            }
            @Override
            public void onDimensionChange(ResourceLocation resourceLocation) {

            }
        };
        SZClientTracker.register(SZListener);
    }





}
