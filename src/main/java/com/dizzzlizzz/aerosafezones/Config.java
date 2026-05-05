package com.dizzzlizzz.aerosafezones;

import net.neoforged.neoforge.common.ModConfigSpec;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Neo's config APIs
public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();



    public static final ModConfigSpec.IntValue safeZoneCheckSpeed = BUILDER
            .comment("How often (in ticks [20 ticks = 1 second]) to check for safe zones (-1 disables the check)")
            .defineInRange("safeZoneCheckSpeed", 20, -1, Integer.MAX_VALUE);

    public static final ModConfigSpec.ConfigValue<String> safeZoneID1 = BUILDER
            .comment("What OPAC Claim to make safe zone 1")
            .define("safeZone1", "null");

    public static final ModConfigSpec.ConfigValue<String> safeZoneID2 = BUILDER
            .comment("What OPAC Claim to make safe zone 1")
            .define("safeZone2", "null");


    static final ModConfigSpec SPEC = BUILDER.build();


}
