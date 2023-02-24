package me.rownox.armies.utils;

import org.bukkit.entity.Player;

public final class ChatUtils {
    public static void TextSpacer(String text, Player p){
        p.sendMessage("\n" + text + "\n");
    }
}
