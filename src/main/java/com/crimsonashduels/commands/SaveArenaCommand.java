package com.crimsonashduels.commands;

import com.crimsonashduels.CrimsonAshDuels;
import com.crimsonashduels.ArenaResetManager;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.Location;

import java.util.HashMap;
import java.util.Map;

public class SaveArenaCommand implements CommandExecutor {
    private final CrimsonAshDuels plugin;
    private final Map<Player, Location> corner1Selections = new HashMap<>();
    private final Map<Player, Location> corner2Selections = new HashMap<>();

    public SaveArenaCommand(CrimsonAshDuels plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can save arenas.");
            return true;
        }
        Player player = (Player) sender;

        if (args.length < 1) {
            player.sendMessage("Usage: /savearena <name>");
            return true;
        }

        String arenaName = args[0];
        Location c1 = corner1Selections.get(player);
        Location c2 = corner2Selections.get(player);

        if (c1 == null || c2 == null) {
            player.sendMessage("You must set both corners first using /setcorner1 and /setcorner2.");
            return true;
        }

        ArenaResetManager manager = plugin.getArenaResetManager();
        manager.saveArena(arenaName, c1, c2);
        player.sendMessage("Arena " + arenaName + " saved with defined corners.");
        return true;
    }

    // Helper commands to set corners
    public void setCorner1(Player player) {
        corner1Selections.put(player, player.getLocation());
        player.sendMessage("Corner 1 set at your current location.");
    }

    public void setCorner2(Player player) {
        corner2Selections.put(player, player.getLocation());
        player.sendMessage("Corner 2 set at your current location.");
    }
}
