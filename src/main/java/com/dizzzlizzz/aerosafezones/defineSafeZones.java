package com.dizzzlizzz.aerosafezones;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.phys.AABB;
import static com.dizzzlizzz.aerosafezones.Config.safeZoneRadiusFromSpawn;

public class defineSafeZones {
    static class safeZone{
        safeZone(){
            BlockPos safeZoneCenter;
            int safeZoneRadius;
            ServerLevel level;
        }}


    public static boolean outsideRadiusCheck(BlockPos POS, int radius) {
        //if the player position of a sublevel is greater than radius, or less than negative radius, on either horizontal, return true
        if(POS.getX() > 0 && (POS.getX() >= radius | POS.getX() <= -radius)){return true;
        } else if (POS.getZ() < 0 && (POS.getZ() >= radius | POS.getZ() <= -radius)){return true;
        }else {return false;}

    }


    public static double distanceToCenter(BlockPos POS, BlockPos Center) {

        double POSx; double POSz; double centerX; double centerZ; double distance;
        POSx = POS.getX(); POSz = POS.getZ(); centerZ = Center.getZ(); centerX = Center.getX();
        distance = Math.sqrt((centerX - POSx) * (centerX - POSx) + (centerZ - POSz) * (centerZ - POSz));
        return distance;

    }


    int radiusMarker = safeZoneRadiusFromSpawn.get();
    BlockPos topCorner = new BlockPos(-radiusMarker,-64,-radiusMarker);
    BlockPos bottomCorner = new BlockPos(radiusMarker, 320, -radiusMarker);
    AABB safeZoneRadius = new AABB(topCorner.getX(),topCorner.getY(),topCorner.getZ(),
            bottomCorner.getX(),bottomCorner.getY(),bottomCorner.getZ());



}
