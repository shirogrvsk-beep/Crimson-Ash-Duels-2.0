package com.crimsonashduels.commands;

import com.crimsonashduels.CrimsonAshDuels;
import com.crimsonashduels.ArenaResetManager;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.Location;

public class SaveArenaCommand implements CommandExecutor {
    private final CrimsonAshDuels plugin;

    public SaveArenaCommand(CrimsonAshDuels plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can save arenas.");
            return true;
        }
        if (args.length < 1) {
            sender.sendMessage("Usage: /savearena <name>");
            return true;
        }

        Player player = (Player) sender;
        Location loc = player.getLocation();
        ArenaResetManager manager = plugin.getArenaResetManager();

        // For now, use player location as both corners (expand later with wand tool)
        manager.saveArena(args[0], loc, loc);
        player.sendMessage("Arena " + args[0] + " saved.");
        return true;
    }
}
