package com.crimsonashduels.commands;

import com.crimsonashduels.CrimsonAshDuels;
import org.bukkit.command.*;

public class RestoreArenaCommand implements CommandExecutor {
    private final CrimsonAshDuels plugin;

    public RestoreArenaCommand(CrimsonAshDuels plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage("Arena restore not implemented yet.");
        return true;
    }
}
