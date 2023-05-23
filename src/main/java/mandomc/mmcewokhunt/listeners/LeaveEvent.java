package mandomc.mmcewokhunt.listeners;

import mandomc.mmcewokhunt.managers.GameManager;
import mandomc.mmcewokhunt.managers.PlayerManager;
import mandomc.mmcewokhunt.methodSpam.LuckpermsGroup;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.potion.PotionEffect;

public class LeaveEvent implements Listener {

    @EventHandler
    public void onLeave(PlayerQuitEvent event){

        Player player = event.getPlayer();

        GameManager.queue.remove(player);
        PlayerManager.stormtroopers.remove(player);
        PlayerManager.ewoks.remove(player);

        player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20.0);
        player.setHealth(20.0);
        player.getInventory().clear();
        LuckpermsGroup.addGroup(player, "default");
        for(PotionEffect effect:player.getActivePotionEffects()){
            player.removePotionEffect(effect.getType());
        }

    }

}
