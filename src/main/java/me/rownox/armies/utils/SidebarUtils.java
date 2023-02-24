package me.rownox.armies.utils;

import me.rownox.armies.Armies;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

public class SidebarUtils {

    private static final ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();

    public static void initScoreboard(Player p) {
        Scoreboard scoreboard = scoreboardManager.getNewScoreboard();

        Team team = scoreboard.registerNewTeam("Sidebar");
        team.setDisplayName("Armies");
        team.addEntry("Balance: ");
        team.addEntry("                              ");
        team.addEntry("");
        team.addEntry("ArmiesX.minehut.gg");

        Objective objective = scoreboard.registerNewObjective("Sidebar", "dummy");
        objective.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Armies Season 1");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        Score score1 = objective.getScore("                              ");
        score1.setScore(3);

        Score score2 = objective.getScore(ChatColor.GREEN + "Balance: " + ChatColor.RED + Armies.getEconomy().getBalance(p));
        score2.setScore(2);

        Score score3 = objective.getScore("");
        score3.setScore(1);

        Score score4 = objective.getScore(ChatColor.WHITE + "ArmiesX.minehut.gg");
        score4.setScore(0);

        p.setScoreboard(scoreboard);
    }
}
