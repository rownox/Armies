package me.rownox.armies.runnables;

import me.rownox.armies.Armies;
import me.rownox.armies.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class Generator {
    public static void generate(){
        new BukkitRunnable(){
            public void run(){
                Item i = (Bukkit.getWorld("world")).dropItem(new Location(Bukkit.getWorld("world"), 73.5, 10, -72.5), new ItemStack(Material.DIAMOND));
                i.setPickupDelay(20);
                i.setVelocity(new Vector(0, 1, 0));

                for (Player p : Bukkit.getOnlinePlayers()) {
                    ChatUtils.TextSpacer("A diamond has been generated at the Diamond Well", p);
                    p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 1, 1);
                }

            }
        }.runTaskTimer(Armies.getInstance(), 20*60*4,20*60*4);


    }
}
