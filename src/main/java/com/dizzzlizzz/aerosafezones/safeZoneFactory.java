package com.dizzzlizzz.aerosafezones;

import com.dizzzlizzz.aerosafezones.safeZones.circleSafeZone;
import com.dizzzlizzz.aerosafezones.safeZones.rectangleSafeZone;
import net.minecraft.core.BlockPos;

import java.awt.*;

public class safeZoneFactory {



    public circleSafeZone newCircleSZ(String name, int centerZ, int centerX, int radius){
        return new circleSafeZone(name, centerX, centerZ, radius);
    }

    public rectangleSafeZone newRectangleSZ(String safeZoneID, int maxX, int minX, int minZ, int maxZ){
        return new rectangleSafeZone(safeZoneID, maxX,maxZ,minX,minZ);

    }


}
