package com.dizzzlizzz.aerosafezones;

import com.dizzzlizzz.aerosafezones.safeZones.circleSafeZone;
import com.dizzzlizzz.aerosafezones.safeZones.rectangleSafeZone;
import net.minecraft.core.BlockPos;

import java.awt.*;
import java.util.ArrayList;

public class safeZoneFactory {
    String factoryID;
    ArrayList<String> registeredSafeZones;
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

    public void registerSafeZone(rectangleSafeZone SZ){
        String SZStr = SZ.toString();
        registeredSafeZones.add(SZStr);
    }
    public void registerSafeZone(circleSafeZone SZ){
        String SZStr = SZ.toString();
        registeredSafeZones.add(SZStr);
    }

}
