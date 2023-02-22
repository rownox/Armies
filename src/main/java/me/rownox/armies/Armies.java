package me.rownox.armies;

import me.rownox.armies.Loops.Generator;
import me.rownox.armies.commands.DiscordCmd;
import me.rownox.armies.commands.KitCmd;
import me.rownox.armies.commands.ShopCmd;
import me.rownox.armies.events.JoinEvent;
import me.rownox.armies.guis.Shop;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Armies extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new JoinEvent(), this);
        this.getCommand("kit").setExecutor(new KitCmd());
        this.getCommand("shop").setExecutor(new ShopCmd());
        this.getCommand("discord").setExecutor(new DiscordCmd());
        Generator.generate();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public static Armies getInstance() {
        return (Armies) Bukkit.getPluginManager().getPlugin("Armies");
    }

}
