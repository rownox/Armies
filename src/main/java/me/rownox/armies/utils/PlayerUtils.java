package me.rownox.armies.utils;

import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.awt.*;

public class PlayerUtils {
    public static void KitPlayer(Player p){

        PlayerInventory inv = p.getInventory();

        ItemStack sapling = new ItemStack(Material.OAK_SAPLING);
        ItemStack seed = new ItemStack(Material.WHEAT_SEEDS);
        ItemStack water = new ItemStack(Material.WATER_BUCKET);
        ItemStack shoes = new ItemStack(Material.LEATHER_BOOTS);
        ItemStack pants = new ItemStack(Material.LEATHER_LEGGINGS);
        ItemStack shirt = new ItemStack(Material.LEATHER_CHESTPLATE);
        ItemStack hat = new ItemStack(Material.LEATHER_HELMET);

        inv.addItem(sapling);
        inv.addItem(seed);
        inv.addItem(water);
        inv.setBoots(shoes);
        inv.setLeggings(pants);
        inv.setChestplate(shirt);
        inv.setHelmet(hat);


        

    }

}
