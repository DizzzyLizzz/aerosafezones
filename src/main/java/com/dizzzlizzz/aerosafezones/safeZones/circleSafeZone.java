package com.dizzzlizzz.aerosafezones.safeZones;

import net.minecraft.core.BlockPos;

public class circleSafeZone{
    String safeZoneId;
    BlockPos SZCenter;
    int SZradius;
    circleSafeZone(String ID, int centerX, int centerZ, int radius){
        safeZoneId = ID;
        SZCenter = new BlockPos(centerX, 0, centerZ);
        SZradius = radius;
    }
    public int getRadius(){return this.SZradius;}
    public BlockPos getCenterBlockPos(){return this.SZCenter;}
    public String getID(){return this.safeZoneId;}
}