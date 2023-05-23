package mandomc.mmcewokhunt.tasks;

import mandomc.mmcewokhunt.managers.ChatManager;
import mandomc.mmcewokhunt.managers.GameManager;
import mandomc.mmcewokhunt.managers.GameState;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class LobbyTask extends BukkitRunnable {

    private final GameManager gameManager;

    public LobbyTask(GameManager gameManager){
        this.gameManager = gameManager;
    }

    BossBar bossBar = Bukkit.createBossBar(ChatManager.format("&a&l" + (6-GameManager.queue.size()) + " Players Needed to Start!"), BarColor.GREEN, BarStyle.SEGMENTED_6);

    @Override
    public void run() {

        if(gameManager.getGameState() == GameState.LOBBY){
            for(Player player : Bukkit.getOnlinePlayers()){
                bossBar.addPlayer(player);
                bossBar.setVisible(true);
            }
            if((6-GameManager.queue.size()) == 1 ){
                bossBar.setTitle(ChatManager.format("&a&l" + (6-GameManager.queue.size()) + " Player Needed to Start!"));
            }else{
                bossBar.setTitle(ChatManager.format("&a&l" + (6-GameManager.queue.size()) + " Players Needed to Start!"));

            }

            bossBar.setProgress((double) GameManager.queue.size()/6);

            if(GameManager.queue.size() >= 6){
                bossBar.setVisible(false);
                bossBar.removeAll();
                gameManager.setGameState(GameState.STARTING);
                cancel();
            }
        }else{
            bossBar.setVisible(false);
            bossBar.removeAll();
            gameManager.setGameState(GameState.STARTING);
            cancel();
        }
    }
}
