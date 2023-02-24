package me.rownox.armies.commands;

import me.rownox.armies.utils.LinkUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class DiscordCmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        commandSender.sendMessage("");
        commandSender.spigot().sendMessage(LinkUtils.discordInvite(ChatColor.AQUA + "[Click Here] " + ChatColor.DARK_AQUA + "to join the discord"));
        commandSender.sendMessage("");
        return true;
    }
}
