package com.crimsonashduels;

import com.crimsonashduels.commands.*;
import org.bukkit.plugin.java.JavaPlugin;

public class CrimsonAshDuels extends JavaPlugin {
    private MatchManager matchManager;
    private StatsManager statsManager;
    private DuelManager duelManager;
    private KitManager kitManager;
    private ArenaResetManager arenaResetManager;

    @Override
    public void onEnable() {
        getLogger().info("Crimson Ash Duels enabled!");

        matchManager = new MatchManager();
        statsManager = new StatsManager();
        duelManager = new DuelManager();
        kitManager = new KitManager();
        arenaResetManager = new ArenaResetManager(this);

        getCommand("duel").setExecutor(new DuelCommand(duelManager));
        getCommand("duelaccept").setExecutor(new DuelAcceptCommand(matchManager, duelManager));
        getCommand("savearena").setExecutor(new SaveArenaCommand(this));
        getCommand("restorearena").setExecutor(new RestoreArenaCommand(this));
    }

    @Override
    public void onDisable() {
        getLogger().info("Crimson Ash Duels disabled!");
    }

    public MatchManager getMatchManager() { return matchManager; }
    public StatsManager getStatsManager() { return statsManager; }
    public DuelManager getDuelManager() { return duelManager; }
    public KitManager getKitManager() { return kitManager; }
    public ArenaResetManager getArenaResetManager() { return arenaResetManager; }
}
