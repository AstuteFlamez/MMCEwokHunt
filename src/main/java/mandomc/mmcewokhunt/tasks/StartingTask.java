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

public class StartingTask extends BukkitRunnable {

    private final GameManager gameManager;

    public StartingTask(GameManager gameManager){
        this.gameManager = gameManager;
    }

    private int timeLeft = 60;

    BossBar bossBar = Bukkit.createBossBar(ChatManager.format("&a&lGame Starting!"), BarColor.GREEN, BarStyle.SOLID);

    @Override
    public void run() {
        timeLeft--;
        for(Player player : Bukkit.getOnlinePlayers()){
            bossBar.addPlayer(player);
            bossBar.setVisible(true);
        }
        bossBar.setProgress((double) timeLeft/(60));

        if(GameManager.queue.size() < 6){
            Bukkit.broadcastMessage(ChatManager.prefix + "" + ChatManager.format("&aNot enough players!"));
            bossBar.setVisible(false);
            bossBar.removeAll();
            gameManager.setGameState(GameState.LOBBY);
            cancel();
        }

        if(timeLeft <= 5 && timeLeft > 0){
            Bukkit.broadcastMessage(ChatManager.prefix + "" + ChatManager.format("&aGame starting in " + timeLeft + ".."));
        }else if(timeLeft <= 0 || gameManager.getGameState() != GameState.STARTING){
            Bukkit.broadcastMessage(ChatManager.prefix + "" + ChatManager.format("&aGame starting!"));
            timeLeft = 60;
            bossBar.setVisible(false);
            bossBar.removeAll();
            gameManager.setGameState(GameState.ACTIVE);
            cancel();
        }
    }
}