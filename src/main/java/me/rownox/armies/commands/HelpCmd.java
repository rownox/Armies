package me.rownox.armies.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelpCmd implements CommandExecutor {

    String[] message = {"line 1", "line 2", "line 3"};


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player p) {
            for (String line : message) {
                p.sendMessage(line);
            }
            return true;
        }
        return false;
    }
}
