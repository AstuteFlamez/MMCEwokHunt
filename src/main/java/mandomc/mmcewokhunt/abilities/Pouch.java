package mandomc.mmcewokhunt.abilities;

import mandomc.mmcewokhunt.managers.ChatManager;
import mandomc.mmcewokhunt.managers.PlayerManager;
import mandomc.mmcewokhunt.methodSpam.ItemStackCreation;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import xyz.xenondevs.particle.ParticleBuilder;
import xyz.xenondevs.particle.ParticleEffect;

import java.util.HashMap;
import java.util.UUID;

public class Pouch implements Listener {

    public final HashMap<UUID, Long> cooldown = new HashMap<>();

    @EventHandler
    public void onPouchThrow(PlayerInteractEvent event) {

        Player player = event.getPlayer();

        if ((event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) && event.getHand() == EquipmentSlot.HAND && player.getInventory().getItemInMainHand().getType() == Material.SNOWBALL) {
            if (PlayerManager.ewoks.contains(player)) {

                if (!cooldown.containsKey(player.getUniqueId())) {
                    cooldown.put(player.getUniqueId(), System.currentTimeMillis());
                    player.getInventory().addItem(ItemStackCreation.throwablePouch());
                } else {
                    event.setCancelled(true);
                    long timeElapsed = System.currentTimeMillis() - cooldown.get(player.getUniqueId());
                    if (timeElapsed >= 10000) {
                        cooldown.remove(player.getUniqueId());
                    } else {
                        player.sendMessage(ChatManager.prefix + "" + ChatManager.format("&aYou can't use your &6throwable &apouch for another &c" + ((10000 - timeElapsed) / 1000) + " &asecond/s!"));

                    }
                }
            }
        }
    }

    @EventHandler
    public void onHit(ProjectileHitEvent event){

        if(event.getEntity() instanceof Snowball) {

            if(event.getHitBlock() != null){
                Location blockLoc = event.getHitBlock().getLocation();
                pouchHit(blockLoc);

            }else if(event.getHitEntity() != null){
                Location entityLoc = event.getHitEntity().getLocation();
                pouchHit(entityLoc);

            }
        }
    }

    private void pouchHit(Location loc) {
        for(Entity entity : loc.getWorld().getNearbyEntities(loc, 2, 2 , 2)){
            if(entity instanceof LivingEntity){
                LivingEntity livingEntity = (LivingEntity) entity;
                livingEntity.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 20*6, 1));
            }
        }
        int amount = 50;
        while(amount>0){
            amount--;
            new ParticleBuilder(ParticleEffect.END_ROD, loc)
                    .setOffsetX(((float) (Math.random()*2-1)))
                    .setOffsetY(((float) Math.random()+1))
                    .setOffsetZ(((float) (Math.random()*2-1)))
                    .setSpeed(0.1f)
                    .display();
        }
    }
}
