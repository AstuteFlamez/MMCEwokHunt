package mandomc.mmcewokhunt.tasks;

import mandomc.mmcewokhunt.managers.PlayerManager;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Random;

public class PlayerRespawnTask extends BukkitRunnable {

    private Player player;

    public PlayerRespawnTask(Player player){
        this.player = player;
    }


    @Override
    public void run() {
        for(int i = 0; i < PlayerManager.ewoks.size(); i++){
            if(PlayerManager.ewoks.get(i) == player){
                PlayerManager.giveEwokKit(player);
                teleportPlayer(player);
                cancel();
            }
        }
        for(int i = 0; i < PlayerManager.stormtroopers.size(); i++){
            if(PlayerManager.stormtroopers.get(i) == player){
                PlayerManager.stormtroopers.remove(i);
                PlayerManager.ewoks.add(player);
                PlayerManager.giveEwokKit(player);
                teleportPlayer(player);
                cancel();
            }
        }
        cancel();
    }

    public void teleportPlayer(Player player){

        ArrayList<Location> loc = new ArrayList<>();
        loc.add(new Location(player.getWorld(), -88, 84, 94, -137.1f, -0.15f));
        loc.add(new Location(player.getWorld(), -98, 101, 57, 146.1f, 25.5f));

        Random random = new Random();
        int randomIndex = random.nextInt(loc.size());

        player.teleport(loc.get(randomIndex));
    }
}
