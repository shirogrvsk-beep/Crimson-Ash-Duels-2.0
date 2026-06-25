package com.crimsonashduels.commands;

import com.crimsonashduels.*;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;

public class DuelAcceptCommand implements CommandExecutor {
    private final MatchManager matchManager;
    private final DuelManager duelManager;

    public DuelAcceptCommand(MatchManager matchManager, DuelManager duelManager) {
        this.matchManager = matchManager;
        this.duelManager = duelManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can accept duels.");
            return true;
        }

        Player target = (Player) sender;
        String challengerName = duelManager.getPendingTarget(target);
        if (challengerName == null) {
            target.sendMessage("You have no pending duel requests.");
            return true;
        }

        Player challenger = Bukkit.getPlayer(challengerName);
        if (challenger == null) {
            target.sendMessage("Challenger not found.");
            return true;
        }

        Arena arena = Arena.fromConfig(Bukkit.getPluginManager()
                .getPlugin("CrimsonAshDuels").getConfig().getConfigurationSection("arenas.arena1"));

        arena.teleportPlayers(challenger, target);
        matchManager.startMatch(challenger, target, arena, duelManager.getLastKit(challenger));

        target.sendMessage("You accepted the duel against " + challenger.getName() + "!");
        challenger.sendMessage(target.getName() + " accepted your duel! Teleporting to arena...");
        return true;
    }
}
