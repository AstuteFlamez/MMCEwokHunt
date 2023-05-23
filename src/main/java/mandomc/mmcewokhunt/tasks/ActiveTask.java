package mandomc.mmcewokhunt.tasks;

import mandomc.mmcewokhunt.managers.ChatManager;
import mandomc.mmcewokhunt.managers.GameManager;
import mandomc.mmcewokhunt.managers.GameState;
import mandomc.mmcewokhunt.managers.PlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ActiveTask extends BukkitRunnable {

    private final GameManager gameManager;

    public ActiveTask(GameManager gameManager){
        this.gameManager = gameManager;
    }

    private int minutesLeft = 6;
    private int secondsLeft = 60;
    private int timeLeft = 7*60;

    BossBar bossBar = Bukkit.createBossBar(ChatManager.format("&f&lTime Remaining: " + (minutesLeft + 1) + ":00"), BarColor.RED, BarStyle.SOLID);

    @Override
    public void run() {
        secondsLeft--;
        timeLeft--;
        for(Player player : Bukkit.getOnlinePlayers()){
            bossBar.addPlayer(player);
            bossBar.setVisible(true);
            player.setGameMode(GameMode.SURVIVAL);
        }

        if(secondsLeft >= 1 && secondsLeft <= 9){
            bossBar.setTitle(ChatManager.format("&f&lTime Remaining: " + minutesLeft + ":0" + secondsLeft));
        }else if(secondsLeft == 0){
            minutesLeft--;
            secondsLeft = 60;
            bossBar.setTitle(ChatManager.format("&f&lTime Remaining: " + minutesLeft + ":00"));
        }else{
            bossBar.setTitle(ChatManager.format("&f&lTime Remaining: " + minutesLeft + ":" + secondsLeft));
        }

        bossBar.setProgress((double) timeLeft/(7*60));

        if(timeLeft <= 5 && timeLeft > 0){
            Bukkit.broadcastMessage(ChatManager.prefix + "" + ChatManager.format("&f&lStormtroopers &awin in " + timeLeft + "..."));
        }else if(timeLeft <= 0 || PlayerManager.stormtroopers.size() == 0  || PlayerManager.ewoks.size() == 0 || gameManager.getGameState() != GameState.ACTIVE){
            timeLeft = 7*60;
            bossBar.setVisible(false);
            bossBar.removeAll();
            gameManager.setGameState(GameState.WON);
            cancel();
        }
    }
}
