package me.rownox.armies;

import me.rownox.armies.events.JoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Armies extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new JoinEvent(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
