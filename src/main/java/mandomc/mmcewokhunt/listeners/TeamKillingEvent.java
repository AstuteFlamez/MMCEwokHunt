package mandomc.mmcewokhunt.listeners;

import mandomc.mmcewokhunt.managers.PlayerManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class TeamKillingEvent implements Listener {

    @EventHandler
    public void onTeamKill(EntityDamageByEntityEvent event){

        if(event.getEntity() instanceof Player && event.getDamager() instanceof Player){
            Player player = (Player) event.getEntity();
            Player damager = (Player) event.getDamager();

            if(PlayerManager.ewoks.contains(player) && PlayerManager.ewoks.contains(damager)){
                event.setCancelled(true);
            }
            if(PlayerManager.stormtroopers.contains(player) && PlayerManager.stormtroopers.contains(damager)){
                event.setCancelled(true);
            }
        }

    }

}
