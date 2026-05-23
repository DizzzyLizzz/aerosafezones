package com.dizzzlizzz.aerosafezones.safeZones;

public class rectangleSafeZone{
    String szID;
    int SZmaxX, SZminX, SZmaxZ, SZminZ;
    rectangleSafeZone(String safeZoneID, int maxX, int minX, int minZ, int maxZ){
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
    public String getID(){return this.szID;}
}