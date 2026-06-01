package com.dizzzlizzz.aerosafezones.safeZones;

import com.mojang.logging.LogUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import org.slf4j.Logger;

import static com.dizzzlizzz.aerosafezones.Config.safeZoneCenter;
import static com.dizzzlizzz.aerosafezones.Config.safeZoneRadiusFromSpawn;

public class SZUtil {

    public static final Logger LOGGER = LogUtils.getLogger();
    public static BlockPos ChunkCenterBlockPos(ChunkPos chunkPos){

        return new BlockPos(chunkPos.getMiddleBlockX(), 0, chunkPos.getMiddleBlockZ());
    }

    public static boolean isActive(safeZone SZ){
        return SZ.active;
    }
    public static void toggleActive(safeZone SZ){
        if (SZ.active) SZ.active = false;
        else SZ.active = true;
    }

    public static double distanceToCenter(BlockPos POS, BlockPos Center) {

        double POSx; double POSz; double centerX; double centerZ; double distance;
        POSx = POS.getX(); POSz = POS.getZ(); centerZ = Center.getZ(); centerX = Center.getX();
        distance = Math.sqrt((centerX - POSx) * (centerX - POSx) + (centerZ - POSz) * (centerZ - POSz));
        return distance;

    }

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
