package me.rownox.armies.utils;

import org.bukkit.entity.Player;

public class ChatUtils {

    public static void TextSpacer(String text, Player p){
        p.sendMessage("");
        p.sendMessage(text);
        p.sendMessage("");
    }
}
