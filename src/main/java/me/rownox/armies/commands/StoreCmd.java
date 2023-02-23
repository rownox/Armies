package me.rownox.armies.commands;

import me.rownox.armies.utils.LinkUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StoreCmd implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player p) {
            p.sendMessage("");
            p.spigot().sendMessage(LinkUtils.storeLink(ChatColor.AQUA + "[Click Here] " + ChatColor.DARK_AQUA + "to access the server store."));
            p.sendMessage("");
            return true;
        }
        return false;
    }
}
