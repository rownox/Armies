package me.rownox.armies.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelpCmd implements CommandExecutor {

    String[] message = {
            "/tpa (username) - Teleport to other players",
            "/shop - Open the in-game shop",
            "/bal - Check your balance",
    "/sell - Sell an item in your hand",
    "/spawn - Teleport to the spawn",
    "/sethome (name) - Set your home",
    "/home (name) - Teleport to your home",
    "/homes - See a list of your homes"
    "/pay - Give money to another player"};


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
