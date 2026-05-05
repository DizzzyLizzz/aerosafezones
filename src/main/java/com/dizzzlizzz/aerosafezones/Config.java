package com.dizzzlizzz.aerosafezones;

import net.neoforged.neoforge.common.ModConfigSpec;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Neo's config APIs
public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();




    public static final ModConfigSpec.IntValue safeZoneRadiusFromSpawn = BUILDER
            .comment("how far in a square do you want the safe zone to be from spawn (0,0)? -1 to disable")
            .defineInRange("safeZoneRadiusFromSpawn", 500, -1, Integer.MAX_VALUE);

    static final ModConfigSpec SPEC = BUILDER.build();


}
