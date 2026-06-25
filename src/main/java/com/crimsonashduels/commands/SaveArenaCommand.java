package com.crimsonashduels.commands;

import com.crimsonashduels.CrimsonAshDuels;
import org.bukkit.command.*;

public class SaveArenaCommand implements CommandExecutor {
    private final CrimsonAshDuels plugin;

    public SaveArenaCommand(CrimsonAshDuels plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage("Arena save not implemented yet.");
        return true;
    }
}
