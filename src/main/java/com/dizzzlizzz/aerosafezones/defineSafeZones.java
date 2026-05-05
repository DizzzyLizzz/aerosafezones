package com.dizzzlizzz.aerosafezones;

import com.mojang.logging.LogUtils;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import org.slf4j.Logger;
import xaero.pac.common.server.api.OpenPACServerAPI;
import xaero.pac.common.server.claims.api.IServerClaimsManagerAPI;
import xaero.pac.common.server.parties.party.api.IPartyManagerAPI;


import javax.annotation.Nonnull;

import static com.google.gson.internal.bind.TypeAdapters.UUID;


//get logger

//public class verifyClaim {
//    public static final Logger LOGGER = LogUtils.getLogger();
//
//
//
//  boolean isInClaim(String[] playerUUID, int blockPosX, int blockPosZ){
//
//        if(playerUUID != null) {
//
//
//
//        }
//
//  }
//
//}
