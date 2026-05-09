package com.dizzzlizzz.aerosafezones;


import net.minecraft.core.BlockPos;
import static com.dizzzlizzz.aerosafezones.Config.safeZoneCenter;
import static com.dizzzlizzz.aerosafezones.Config.safeZoneRadiusFromSpawn;

public class defineSafeZones {



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


