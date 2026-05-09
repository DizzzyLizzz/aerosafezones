package com.dizzzlizzz.aerosafezones;

import com.mojang.logging.LogUtils;
import org.slf4j.Logger;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import xaero.pac.client.claims.tracker.result.api.IClaimsManagerClaimResultListenerAPI;
import xaero.pac.common.claims.player.api.IPlayerChunkClaimAPI;
import xaero.pac.common.claims.tracker.api.IClaimsManagerListenerAPI;

import static com.dizzzlizzz.aerosafezones.Config.safeZoneCenter;
import static com.dizzzlizzz.aerosafezones.Config.safeZoneRadiusFromSpawn;

public class defineSafeZones {
    public static final Logger LOGGER = LogUtils.getLogger();

    public static double distanceToCenter(BlockPos POS, BlockPos Center) {

        double POSx; double POSz; double centerX; double centerZ; double distance;
        POSx = POS.getX(); POSz = POS.getZ(); centerZ = Center.getZ(); centerX = Center.getX();
        distance = Math.sqrt((centerX - POSx) * (centerX - POSx) + (centerZ - POSz) * (centerZ - POSz));
        return distance;

    }

    public static BlockPos ChunkPosToBlockPOS(int chunkint1, int chunkint2){
        int i1 = (chunkint1 * 16)+8; int i2 = (chunkint2 * 16)+8;
        BlockPos chunkPosAsBlockPos = new BlockPos(i1, 0, i2);
        LOGGER.info("ChunkCenter is: {}", chunkPosAsBlockPos);
        return chunkPosAsBlockPos;
    };

    public static boolean isInsideSafeZone(BlockPos shipPOS){
      int radiusMarker = safeZoneRadiusFromSpawn.get();
      int xPOS = safeZoneCenter.get().getFirst(); int zPOS = safeZoneCenter.get().get(1);
      BlockPos safeZoneCenter = new BlockPos(xPOS, 0, zPOS);
        if (distanceToCenter(shipPOS, safeZoneCenter) > radiusMarker)
            return false;
        else
            return true;
        }
    }


