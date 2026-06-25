package com.crimsonashduels.commands;

import com.crimsonashduels.CrimsonAshDuels;
import com.crimsonashduels.ArenaResetManager;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class RestoreArenaCommand implements CommandExecutor {
    private final CrimsonAshDuels plugin;

    public RestoreArenaCommand(CrimsonAshDuels plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can restore arenas.");
            return true;
        }
        if (args.length < 1) {
            sender.sendMessage("Usage: /restorearena <name>");
            return true;
        }

        Player player = (Player) sender;
        ArenaResetManager manager = plugin.getArenaResetManager();
        manager.restoreArena(args[0], player.getLocation());
        player.sendMessage("Arena " + args[0] + " restored at your location.");
        return true;
    }
}
