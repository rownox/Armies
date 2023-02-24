package me.rownox.armies.events;

import net.ess3.api.events.UserBalanceUpdateEvent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class BalanceEvent implements Listener {
    @EventHandler
    public void onBalanceUpdate(UserBalanceUpdateEvent e) {
        Player p = e.getPlayer();

        p.getScoreboard().getTeam("balance").setSuffix(ChatColor.RED.toString() + e.getNewBalance());
    }
}
