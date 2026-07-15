package com.dizzzlizzz.aerosafezones.safeZones;

import com.sun.jna.StringArray;
import java.util.ArrayList;

public class SZManager {
    String ManagerID;
    ArrayList<String> SZList;
    SZManager(String ManagerID){
        this.ManagerID = ManagerID;
    }
    public void ImportSZ(safeZone SZ){
        SZList.add(SZ.toString());
    }
    public String ExportSZStr(){

    }
}
