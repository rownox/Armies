package me.rownox.armies.utils;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;

public final class LinkUtils {
    public static TextComponent discordInvite(String name) {
        TextComponent msg = new TextComponent(ChatColor.BOLD + "" + ChatColor.YELLOW + name);
        msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§fDiscord Server").create()));
        msg.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://discord.gg/kCK5ScUrnd"));

        return msg;
    }
}
