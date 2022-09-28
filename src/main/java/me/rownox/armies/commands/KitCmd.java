package me.rownox.armies.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.rownox.armies.utils.PlayerUtils.KitPlayer;

public class KitCmd implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player p) {
            if(p.hasPermission("armies.kit")){
                if (args.length >= 1 ) {
                    if (Bukkit.getPlayer(args[0]) != null) {
                        Player target = Bukkit.getPlayer(args[0]);
                        KitPlayer(target);
                    }
                }else {
                    KitPlayer(p);
                }
            }
            return true;
        }
        return false;
    }

}
