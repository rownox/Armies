package me.rownox.armies.guis;

import me.rownox.armies.Armies;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class Shop implements Listener {

    private final Inventory inv;

    public Shop(Player p) {
        Armies.getInstance().getServer().getPluginManager().registerEvents(this, Armies.getInstance());

        inv = Bukkit.createInventory(null, 9*3, "Shop");
        addItems();
        p.openInventory(inv);
    }

    public void addItems() {
        inv.setItem(10, createGuiItem(Material.BOOK, "Book", "Cost: $5", 5));
        inv.setItem(11, createGuiItem(Material.BOOK, "Book2", "Cost: $10", 10));
        inv.setItem(12, createGuiItem(Material.BOOK, "Book3", "Cost: $15", 15));
        inv.setItem(13, createGuiItem(Material.BOOK, "Book4", "Cost: $5", 5));
        inv.setItem(14, createGuiItem(Material.BOOK, "Book5", "Cost: $5", 5));
        inv.setItem(15, createGuiItem(Material.BOOK, "Book6", "Cost: $5", 5));
    }

    protected ItemStack createGuiItem(final Material material, final String name, final String lore, int amount) {
        final ItemStack item = new ItemStack(material, amount);
        final ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(name);
        meta.setLore(Arrays.asList(lore));
        item.setItemMeta(meta);

        return item;
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getInventory().equals(inv)) {
            e.setCancelled(true);

            ItemStack item = e.getCurrentItem();
            if (item == null || item.getType().isAir()) return;
            Player p = (Player) e.getWhoClicked();

            if (!Armies.getEconomy().has(p, item.getAmount())) {
                p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
                p.sendMessage(ChatColor.RED + "You do not have enough money.");
                return;
            }
            Armies.getEconomy().withdrawPlayer(p, item.getAmount());
            p.sendMessage(ChatColor.GREEN + "You purchased " + item.getItemMeta().getDisplayName() + " for" + ChatColor.GREEN + "$" + item.getAmount());
            p.getInventory().addItem(item);
            p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
        }
    }

    @EventHandler
    public void onInventoryClick(final InventoryDragEvent e) {
        if (e.getInventory().equals(inv)) {
            e.setCancelled(true);
        }
    }
}
