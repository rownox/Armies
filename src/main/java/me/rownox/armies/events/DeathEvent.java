package me.rownox.armies.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.EventListener;

public class DeathEvent implements EventListener {
    public void onDeath(PlayerDeathEvent e){
        Player victim = e.getEntity().getPlayer();
        Player killer = e.getEntity().getKiller();


    }
}
