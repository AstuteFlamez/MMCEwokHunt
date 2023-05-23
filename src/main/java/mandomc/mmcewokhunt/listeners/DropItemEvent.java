package mandomc.mmcewokhunt.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

public class DropItemEvent implements Listener {

    @EventHandler
    public void onDrop(PlayerDropItemEvent event){

        Player player = event.getPlayer();

        if(!player.hasPermission("mmc.ewokhunt.bypass")){
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onDeathDrop(PlayerDeathEvent event){

        event.getDrops().clear();

    }
}
