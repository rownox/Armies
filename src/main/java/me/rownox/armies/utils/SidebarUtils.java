package me.rownox.armies.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.*;

public class SidebarUtils extends JavaPlugin {

    private static ScoreboardManager scoreboardManager;
    private static Scoreboard scoreboard;

    public static void initScoreboard(Player p) {
        scoreboardManager = Bukkit.getScoreboardManager();
        scoreboard = scoreboardManager.getNewScoreboard();

        Team team = scoreboard.registerNewTeam("Sidebar");

        team.setDisplayName("Armies");

        team.addEntry("Balance");

        Objective objective = scoreboard.registerNewObjective("Sidebar", "dummy");

        objective.setDisplayName("Armies");

        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        Score score1 = objective.getScore("Balance");
        score1.setScore(0);

        p.setScoreboard(scoreboard);
    }
}
