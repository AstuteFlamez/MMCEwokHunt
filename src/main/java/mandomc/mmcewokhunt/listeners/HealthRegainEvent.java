package mandomc.mmcewokhunt.listeners;

import mandomc.mmcewokhunt.managers.PlayerManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityRegainHealthEvent;

public class HealthRegainEvent implements Listener {

    @EventHandler
    public void onHealthRegain(EntityRegainHealthEvent event){

        if(event.getEntity() instanceof Player){
            Player player = (Player) event.getEntity();

            if(PlayerManager.stormtroopers.contains(player)){
                event.setCancelled(true);
            }
        }
    }
}
