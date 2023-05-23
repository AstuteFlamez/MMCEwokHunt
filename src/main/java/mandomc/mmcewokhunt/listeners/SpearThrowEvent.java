package mandomc.mmcewokhunt.listeners;

import org.bukkit.entity.Player;
import org.bukkit.entity.Trident;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;

public class SpearThrowEvent implements Listener {

    @EventHandler
    public void onThrow(ProjectileLaunchEvent event){
        if(!(event.getEntity() instanceof Trident)) return;
        if(!(event.getEntity().getShooter() instanceof Player)) return;

        event.setCancelled(true);


    }

}
