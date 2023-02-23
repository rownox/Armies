package me.rownox.armies.events;

import me.rownox.armies.utils.SidebarUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import static me.rownox.armies.utils.PlayerUtils.KitPlayer;
public class JoinEvent implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();

        if (!p.hasPlayedBefore()) {
            KitPlayer(p);
        }

        SidebarUtils.initScoreboard(p);

        BossBar bossBar = Bukkit.createBossBar(ChatColor.WHITE + "" + ChatColor.BOLD +  "ArmiesX.minehut.gg", BarColor.RED, BarStyle.SEGMENTED_6);
        bossBar.addPlayer(p);
        bossBar.setProgress(1);
    }
}
