package mandomc.mmcewokhunt.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){

        Player player = event.getPlayer();

        player.teleport(new Location(Bukkit.getWorld("endor2"), -25.60524039173133, 63.0, -5.747464188295914, -8.700004f, -8.700004f));
    }

}
