package me.rownox.armies.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import static me.rownox.armies.utils.PlayerUtils.KitPlayer;
public class JoinEvent implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        if (!player.hasPlayedBefore()) {
            player.teleport(new Location(Bukkit.getWorld("world"),0,6,0,0,0));
            KitPlayer(player);

        }
    }
}
