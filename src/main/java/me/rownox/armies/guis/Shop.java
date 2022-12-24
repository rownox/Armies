package me.rownox.armies.guis;

import org.bukkit.Bukkit;
import org.bukkit.Material;
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
        inv = Bukkit.createInventory(null, 9*3, "Shop");

        addItems();

        p.openInventory(inv);
    }

    public void addItems() {
        inv.setItem(10, createGuiItem(Material.BOOK, "Book", "Cost: $5"));
        inv.setItem(11, createGuiItem(Material.BOOK, "Book2", "Cost: $5"));
        inv.setItem(12, createGuiItem(Material.BOOK, "Book3", "Cost: $5"));
        inv.setItem(13, createGuiItem(Material.BOOK, "Book4", "Cost: $5"));
        inv.setItem(14, createGuiItem(Material.BOOK, "Book5", "Cost: $5"));
        inv.setItem(15, createGuiItem(Material.BOOK, "Book6", "Cost: $5"));
    }

    protected ItemStack createGuiItem(final Material material, final String name, final String... lore) {
        final ItemStack item = new ItemStack(material, 1);
        final ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(name);
        meta.setLore(Arrays.asList(lore));
        item.setItemMeta(meta);

        return item;
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (!e.getInventory().equals(inv)) return;

        e.setCancelled(true);

        ItemStack item = e.getCurrentItem();

        if (item == null || item.getType().isAir()) return;

        Player p = (Player) e.getWhoClicked();


        if (item.getType().getData().getName().equals("Book")) {
            p.sendMessage("You bought a book.");
            p.getInventory().addItem(item);
        }
    }

    @EventHandler
    public void onInventoryClick(final InventoryDragEvent e) {
        if (e.getInventory().equals(inv)) {
            e.setCancelled(true);
        }
    }
}
