//package com.dizzzlizzz.aerosafezones.OPACCompat;
//
//import net.minecraft.core.BlockPos;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.server.MinecraftServer;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.level.ChunkPos;
//import org.jetbrains.annotations.NotNull;
//import org.jetbrains.annotations.Nullable;
//import xaero.pac.common.claims.player.api.IPlayerChunkClaimAPI;
//import xaero.pac.common.claims.tracker.api.IClaimsManagerListenerAPI;
//import xaero.pac.common.server.api.OpenPACServerAPI;
//
//import java.util.Objects;
//import java.util.UUID;
//
//import static com.dizzzlizzz.aerosafezones.safeZones.SZUtil.*;
//
//public class SZServerListener implements IClaimsManagerListenerAPI {
//    @Override
//    public void onWholeRegionChange(@NotNull ResourceLocation resourceLocation, int i, int i1) {
//
//    }
//
//    @Override
//    public void onChunkChange(@NotNull ResourceLocation resourceLocation, int i, int i1, @Nullable IPlayerChunkClaimAPI iPlayerChunkClaimAPI) {
//        LOGGER.info("SZ Chunk Change Fired");
//        MinecraftServer SZServer = event.getServer();
//        UUID Pid = Objects.requireNonNull(iPlayerChunkClaimAPI).getPlayerId();
//        Player PlayerOb = SZServer.getPlayerList().getPlayer(Pid);
//        if(Pid != wEMP){
//            ChunkPos claimCPos = new ChunkPos(i,i1);
//            BlockPos chunkCenter = ChunkCenterBlockPos(claimCPos);
//            if(!isInsideSafeZone(chunkCenter)){
//
//                OpenPACServerAPI.get(SZServer).getServerClaimsManager().unclaim(resourceLocation,i,i1);
//
//            }
//        }
//
//    }
//
//    @Override
//    public void onDimensionChange(ResourceLocation resourceLocation) {
//
//    }
//}
