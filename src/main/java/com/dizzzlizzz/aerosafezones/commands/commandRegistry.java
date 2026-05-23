package com.dizzzlizzz.aerosafezones.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.logging.LogUtils;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import org.slf4j.Logger;

public class commandRegistry {

    public static final Logger LOGGER = LogUtils.getLogger();



    public commandRegistry(IEventBus EventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        EventBus.addListener(this::onRegisterCommands);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (SquareMapShapes) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);
    }

    public void onRegisterCommands(RegisterCommandsEvent event){

        commandRegistry.register(event.getDispatcher());


    }

    public static void register(CommandDispatcher<CommandSourceStack> commandDispatcher){
        commandDispatcher.register(Commands.literal("SafeZones")
                        .requires(commandSourceStack -> commandSourceStack.hasPermission(4))
                        .then(Commands.literal("Create")
                                .then(Commands.argument("centerX", IntegerArgumentType.integer())
                                        .then(Commands.argument("centerZ", IntegerArgumentType.integer())
                                                .then(Commands.argument("radius", IntegerArgumentType.integer())
                                                        .executes(() -> )))))


        );//closing brace for register

    }

}


