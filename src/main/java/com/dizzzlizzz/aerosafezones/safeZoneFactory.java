package com.dizzzlizzz.aerosafezones;

import com.dizzzlizzz.aerosafezones.safeZones.circleSafeZone;
import com.dizzzlizzz.aerosafezones.safeZones.rectangleSafeZone;
import com.dizzzlizzz.aerosafezones.safeZones.safeZone;
import net.minecraft.core.BlockPos;

import java.awt.*;
import java.util.ArrayList;

public class safeZoneFactory {
    String factoryID;
    ArrayList<safeZone> registeredSafeZones;
    public safeZoneFactory(String SZFactoryName){
    }

    public int newCircleSZ(String name, int centerZ, int centerX, int radius){
        circleSafeZone SZ = new circleSafeZone(name, centerX, centerZ, radius);
        registerSafeZone(SZ);
        return 0;
    }

    public int newRectangleSZ(String safeZoneID, int maxX, int minX, int minZ, int maxZ){
        rectangleSafeZone SZ = new rectangleSafeZone(safeZoneID, maxX,maxZ,minX,minZ);
        registerSafeZone(SZ);
        return 0;
    }
    public static String getFactoryID(safeZoneFactory SZF){return SZF.factoryID;    }

    public void registerSafeZone(safeZone SZ){
//        String SZStr = SZ.toString();
        registeredSafeZones.add(SZ);
    }
    public void unregisterSafeZone(safeZone SZ){
        registeredSafeZones.remove(SZ);
    }
}
