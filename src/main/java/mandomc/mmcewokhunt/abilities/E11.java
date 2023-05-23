package mandomc.mmcewokhunt.abilities;

import mandomc.mmcewokhunt.managers.ChatManager;
import mandomc.mmcewokhunt.managers.PlayerManager;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;
import java.util.UUID;

public class E11 implements Listener {

    public final HashMap<UUID, Long> cooldown = new HashMap<>();

    @EventHandler
    public void onE11(PlayerInteractEvent event) {

        Player player = event.getPlayer();

        if ((event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) && event.getHand() == EquipmentSlot.HAND && player.getInventory().getItemInMainHand().getType() == Material.DIAMOND_HOE) {
            if (PlayerManager.stormtroopers.contains(player)) {

                if (!cooldown.containsKey(player.getUniqueId())) {
                    cooldown.put(player.getUniqueId(), System.currentTimeMillis());
                    player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, (20 * 25), 1));
                } else {
                    long timeElapsed = System.currentTimeMillis() - cooldown.get(player.getUniqueId());
                    if (timeElapsed >= 30000) {
                        cooldown.remove(player.getUniqueId());
                    } else {
                        player.sendMessage(ChatManager.prefix + "" + ChatManager.format("&aYou can't use your &fflashlight &afor another &c" + ((30000 - timeElapsed) / 1000) + " &asecond/s!"));

                    }
                }
            }
        }
    }
}
