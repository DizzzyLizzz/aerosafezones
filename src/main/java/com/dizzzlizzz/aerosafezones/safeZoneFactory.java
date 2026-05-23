package com.dizzzlizzz.aerosafezones;

import net.minecraft.core.BlockPos;

public class safeZoneFactory {



    public safeZoneFactory(String shape, String SafeZoneID){



    }


    public static class circleSafeZone{
        String safeZoneId;
        BlockPos SZCenter;
        int SZradius;
        circleSafeZone(String ID, int centerX, int centerZ, int radius){
            safeZoneId = ID;
            SZCenter = new BlockPos(centerX, 0, centerZ);
            SZradius = radius;
        }
 }
    public static class rectangleSafeZone{
        String szID;
        int SZmaxX, SZminX, SZmaxZ, SZminZ;
        rectangleSafeZone(String safeZoneID, int maxX, int minX, int minZ, int maxZ){
            szID = safeZoneID;
            SZmaxX = maxX;
            SZmaxZ = maxZ;
            SZminX = minX;
            SZminZ = minZ;

        }

    }
}
