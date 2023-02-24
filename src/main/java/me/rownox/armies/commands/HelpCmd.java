package me.rownox.armies.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class HelpCmd implements CommandExecutor {

    private final String[] message = {
            "/tpa (username) - Teleport to other players",
            "/shop - Open the in-game shop",
            "/bal - Check your balance",
    "/sell - Sell an item in your hand",
    "/spawn - Teleport to the spawn",
    "/sethome (name) - Set your home",
    "/home (name) - Teleport to your home",
    "/homes - See a list of your homes",
    "/pay - Give money to another player"};


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        for (String line : message) {
            sender.sendMessage(line);
        }
        return true;
    }
}
