package io.github.quatcraft.FixNameColorPlugin;


import org.bukkit.Server;
import org.bukkit.event.*;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Team;

public class FixNameColorPlugin extends JavaPlugin implements Listener {

    public FixNameColorPlugin() {

    }

    Server s;
    public void onEnable() {
        s = getServer();

        s.getPluginManager().registerEvents(this,this);
    }

    public void onDisable() {

    }

    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerChat(AsyncPlayerChatEvent e) {
        try {
            if (e.getPlayer() != null) {
                Team team = e.getPlayer().getScoreboard().getPlayerTeam(e.getPlayer());
                String prefix = team.getPrefix();
                String suffix = team.getSuffix();
                e.setFormat("<" + prefix + "%1$s" + suffix + "> %2$s");
            }
        } catch (Exception iGuessTheyreNotOnATeam) {
            ; //I'm a good programmer!
        }
    }
}