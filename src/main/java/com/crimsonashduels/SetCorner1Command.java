package com.crimsonashduels.commands;

import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class SetCorner1Command implements CommandExecutor {
    private final SaveArenaCommand saveArenaCommand;

    public SetCorner1Command(SaveArenaCommand saveArenaCommand) {
        this.saveArenaCommand = saveArenaCommand;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can set corners.");
            return true;
        }
        Player player = (Player) sender;
        saveArenaCommand.setCorner1(player);
        return true;
    }
}
