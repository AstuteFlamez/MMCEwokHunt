package mandomc.mmcewokhunt.abilities;

import fr.skytasul.glowingentities.GlowingEntities;
import mandomc.mmcewokhunt.MMCEwokHunt;
import mandomc.mmcewokhunt.managers.ChatManager;
import mandomc.mmcewokhunt.managers.PlayerManager;
import mandomc.mmcewokhunt.methodSpam.ItemStackCreation;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class HuntersInstincts implements Listener {

    public final HashMap<UUID, Long> cooldown = new HashMap<>();

    private final MMCEwokHunt plugin;
    private final GlowingEntities glowingEntities;
    private final Set<Entity> highlightedEntities = new HashSet<>();

    public HuntersInstincts(MMCEwokHunt plugin, GlowingEntities glowingEntities){
        this.plugin = plugin;
        this.glowingEntities = glowingEntities;
    }

    @EventHandler
    public void onHuntersInstinct(PlayerToggleSneakEvent event) throws ReflectiveOperationException {

        Player player = event.getPlayer();

        if(event.isSneaking() && (player.getInventory().getItemInMainHand().getType() == Material.GRAY_DYE || player.getInventory().getItemInMainHand().getType() == Material.LIME_DYE)){
            if(PlayerManager.ewoks.contains(player)){

                if (!cooldown.containsKey(player.getUniqueId())) {
                    player.sendMessage(ChatManager.prefix + "" + ChatManager.format("&aYou used &cHunter's Instincts!"));
                    cooldown.put(player.getUniqueId(), System.currentTimeMillis());
                    Set<Entity> nearbyEntities = getEntitiesWithinRadius(player);

                    player.getInventory().setItem(1, ItemStackCreation.activeHuntersInstinct());
                    for(Entity entity : nearbyEntities){
                        glowingEntities.setGlowing(entity, player, ChatColor.YELLOW);
                        highlightedEntities.add(entity);
                    }

                    new BukkitRunnable(){
                        @Override
                        public void run(){
                            for(Entity entity : highlightedEntities){
                                try {
                                    glowingEntities.unsetGlowing(entity, player);
                                    player.getInventory().setItem(1, ItemStackCreation.inactiveHuntersInstinct());
                                } catch (ReflectiveOperationException e) {
                                    e.printStackTrace();
                                }
                            }
                            highlightedEntities.clear();
                        }
                    }.runTaskLater(plugin, 200);
                } else {
                    long timeElapsed = System.currentTimeMillis() - cooldown.get(player.getUniqueId());
                    if (timeElapsed >= 20000) {
                        cooldown.remove(player.getUniqueId());
                    } else {
                        player.sendMessage(ChatManager.prefix + "" + ChatManager.format("&aYou can't use &cHunter's Instincts &afor another &c" + ((20000 - timeElapsed) / 1000) + " &asecond/s!"));
                    }
                }
            }
        }

    }

    private Set<Entity> getEntitiesWithinRadius(Player player){
        Set<Entity> nearbyEntities = new HashSet<>(player.getNearbyEntities(30, 30, 30));
        nearbyEntities.remove(player);
        return nearbyEntities;
    }
}
