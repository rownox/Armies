package me.rownox.armies.Loops;

import me.rownox.armies.Armies;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class Generator {
    public static void generate(){
        new BukkitRunnable(){
            public void run(){
                Item i = (Bukkit.getWorld("arena")).dropItem(new Location(Bukkit.getWorld("arena"), 73.5, 7, -72.5), new ItemStack(Material.DIAMOND) );
                i.setVelocity(new Vector(0, 0, 0));
                Bukkit.broadcastMessage("A diamond has been generated at the Diamond Well");
            }
        }.runTaskTimer(Armies.getInstance(), 20*60*5,20*60*5);


    }
}
