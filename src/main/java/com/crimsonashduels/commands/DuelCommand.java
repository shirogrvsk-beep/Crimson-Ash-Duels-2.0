package com.crimsonashduels.commands;

import com.crimsonashduels.DuelManager;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;

public class DuelCommand implements CommandExecutor {
    private final DuelManager duelManager;

    public DuelCommand(DuelManager duelManager) {
        this.duelManager = duelManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can send duel requests.");
            return true;
        }
        if (args.length < 1) {
            sender.sendMessage("Usage: /duel <player>");
            return true;
        }

        Player challenger = (Player) sender;
        Player target = Bukkit.getPlayer(args[0]);
        if (target == null) {
            challenger.sendMessage("Player not found.");
            return true;
        }

        duelManager.sendDuelRequest(challenger, target.getName(), "default");
        challenger.sendMessage("You challenged " + target.getName() + " to a duel!");
        target.sendMessage(challenger.getName() + " has challenged you! Type /duelaccept to fight.");
        return true;
    }
}
