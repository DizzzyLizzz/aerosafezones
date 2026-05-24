package com.dizzzlizzz.aerosafezones.safeZones;

import net.minecraft.core.BlockPos;

import java.awt.*;

public class rectangleSafeZone{
    String szID;
    int SZmaxX, SZminX, SZmaxZ, SZminZ;
    public rectangleSafeZone(String safeZoneID, int maxX, int minX, int minZ, int maxZ){
        szID = safeZoneID;
        SZmaxX = maxX;
        SZmaxZ = maxZ;
        SZminX = minX;
        SZminZ = minZ;
    }
    public int getMaxX(){return this.SZmaxX;}
    public int getMinX(){return this.SZminX;}
    public int getMaxZ(){return this.SZmaxZ;}
    public int getMinZ(){return this.SZminZ;}
    public Point centerPoint(){
        Point cornerNW = new Point(getMaxX(),getMaxZ());
        Point cornerSE = new Point(getMinX(),getMinZ());
        return new Point((cornerSE.x + cornerNW.x)/2,(cornerSE.y + cornerNW.y)/2);
    }
    public BlockPos getCenterBP(){
        Point center= this.centerPoint();
        return new BlockPos(center.x,0,center.y);
        }
    public String getID(){return this.szID;}
}