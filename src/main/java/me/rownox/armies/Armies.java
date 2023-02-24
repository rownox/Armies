package me.rownox.armies;

import com.earth2me.essentials.Essentials;
import me.rownox.armies.commands.DiscordCmd;
import me.rownox.armies.commands.HelpCmd;
import me.rownox.armies.commands.KitCmd;
import me.rownox.armies.commands.ShopCmd;
import me.rownox.armies.events.BalanceEvent;
import me.rownox.armies.events.JoinEvent;
import me.rownox.armies.utils.Generator;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class Armies extends JavaPlugin {

    private static final Logger log = Logger.getLogger("Minecraft");
    private static Economy economy = null;
    private static Essentials essentials;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new JoinEvent(), this);
        getServer().getPluginManager().registerEvents(new BalanceEvent(), this);

        this.getCommand("kit").setExecutor(new KitCmd());
        this.getCommand("shop").setExecutor(new ShopCmd());
        this.getCommand("discord").setExecutor(new DiscordCmd());
        this.getCommand("help").setExecutor(new HelpCmd());
        new Generator();

        if (!setupEconomy() ) {
            log.severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        setupEssentials();

    }

    @Override
    public void onDisable() {
        log.info(String.format("[%s] Disabled Version %s", getDescription().getName(), getDescription().getVersion()));
    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        economy = rsp.getProvider();
        return economy != null;
    }

    private void setupEssentials() {
        Plugin essentialsPlg = Bukkit.getPluginManager().getPlugin("Essentials");

        if (essentials.isEnabled() && (essentials instanceof Essentials)) {
            essentials = (Essentials) essentialsPlg;
        } else {
            // Disable the plugin
            Bukkit.getPluginManager().disablePlugin(this);
        }

    }

    public static Economy getEconomy() {
        return economy;
    }

    public static Armies getInstance() {
        return (Armies) Bukkit.getPluginManager().getPlugin("Armies");
    }

}
