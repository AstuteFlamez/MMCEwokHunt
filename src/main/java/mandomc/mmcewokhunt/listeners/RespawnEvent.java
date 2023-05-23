package mandomc.mmcewokhunt.listeners;

import mandomc.mmcewokhunt.MMCEwokHunt;
import mandomc.mmcewokhunt.managers.PlayerManager;
import mandomc.mmcewokhunt.tasks.PlayerRespawnTask;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class RespawnEvent implements Listener {

    private final MMCEwokHunt plugin;

    public RespawnEvent(MMCEwokHunt plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent event){

        Player player = event.getPlayer();

        for(int i = 0; i < PlayerManager.stormtroopers.size(); i++){
            if(PlayerManager.stormtroopers.get(i) == player){
                PlayerManager.stormtroopers.remove(i);
                PlayerManager.ewoks.add(player);
            }
        }
        PlayerManager.giveEwokKit(player);
        player.teleport(new Location(player.getWorld(), -98, 101, 57, 146.1f, 25.5f));

    }

}
