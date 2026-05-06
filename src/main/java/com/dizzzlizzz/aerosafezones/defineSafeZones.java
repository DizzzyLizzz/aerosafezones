package com.dizzzlizzz.aerosafezones;

import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.AABB;
import static com.dizzzlizzz.aerosafezones.Config.safeZoneRadiusFromSpawn;

public class defineSafeZones {

    int radiusMarker = safeZoneRadiusFromSpawn.get();
    BlockPos topCorner = new BlockPos(-radiusMarker,-64,-radiusMarker);
    BlockPos bottomCorner = new BlockPos(radiusMarker, 320, -radiusMarker);
    AABB safeZoneRadius = new AABB(topCorner.getX(),topCorner.getY(),topCorner.getZ(),
            bottomCorner.getX(),bottomCorner.getY(),bottomCorner.getZ());

}
