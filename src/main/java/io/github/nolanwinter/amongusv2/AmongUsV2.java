package io.github.nolanwinter.amongusv2;

import org.bukkit.plugin.java.JavaPlugin;

public class AmongUsV2 extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Starting AMUG");
        Globals.game = new AUGame();
        this.getCommand("addplayer").setExecutor(new PlayerHandleCmds());
        this.getCommand("removeplayer").setExecutor(new PlayerHandleCmds());
        this.getCommand("setskin").setExecutor(new PlayerHandleCmds());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
