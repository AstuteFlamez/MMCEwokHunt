package mandomc.mmcewokhunt.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryMoveEvent implements Listener {

    @EventHandler
    public void onInventoryMove(InventoryClickEvent event){

        if(event.getWhoClicked() instanceof Player){
            Player player = (Player) event.getWhoClicked();

            if(!player.hasPermission("mmc.ewokhunt.bypass")){
               event.setCancelled(true);
            }
        }
    }
}
