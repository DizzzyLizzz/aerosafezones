package com.dizzzlizzz.aerosafezones.safeZones;

import net.minecraft.core.BlockPos;

public class circleSafeZone extends safeZone{
    String safeZoneId;
    BlockPos SZCenterBP;
    int SZCenterX;
    int SZCenterZ;
    int SZradius;
    public circleSafeZone(String ID, int centerX, int centerZ, int radius){
        SZCenterX = centerX;
        SZCenterZ = centerZ;
        safeZoneId = ID;
        SZCenterBP = new BlockPos(centerX, 0, centerZ);
        SZradius = radius;
    }
    public int getRadius(){return this.SZradius;}
    public BlockPos getCenterBlockPos(){return this.SZCenterBP;}
    public String getID(){return this.safeZoneId;}
}