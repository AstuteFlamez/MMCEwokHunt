package mandomc.mmcewokhunt.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class HungerLossEvent implements Listener {

    @EventHandler
    public void onHungerLoss(FoodLevelChangeEvent event){
        event.setCancelled(true);
    }

}
