package mandomc.mmcewokhunt.managers;

import mandomc.mmcewokhunt.MMCEwokHunt;
import mandomc.mmcewokhunt.methodSpam.LuckpermsGroup;
import mandomc.mmcewokhunt.tasks.ActiveTask;
import mandomc.mmcewokhunt.tasks.LobbyTask;
import mandomc.mmcewokhunt.tasks.StartingTask;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

import java.util.ArrayList;

public class GameManager {

    private final MMCEwokHunt plugin;
    private final PlayerManager playerManager;

    private GameState gameState = GameState.LOBBY;

    public static ArrayList<Player> queue = new ArrayList<>();

    public GameManager(MMCEwokHunt plugin){
        this.plugin = plugin;
        this.playerManager = new PlayerManager();
    }

    public void setGameState(GameState gameState){
        if(this.gameState == gameState)return;

        this.gameState = gameState;

        switch(gameState){
            case STARTING:
                StartingTask startingTask = new StartingTask(this);
                startingTask.runTaskTimer(plugin, 0, 20);
                break;
            case ACTIVE:
                getPlayerManager().giveKits();
                ActiveTask activeTask = new ActiveTask(this);
                activeTask.runTaskTimer(plugin, 0, 20);
                break;
            case WON:
                for(Player player : Bukkit.getOnlinePlayers()){
                    if(PlayerManager.stormtroopers.size() == 0){
                        player.sendTitle(ChatManager.format("&6&lThe Ewoks"), ChatManager.format("&6&lPrevail Against the Empire!"), 10, 80, 10);
                    }else{
                        player.sendTitle(ChatManager.format("&f&lThe Stormtroopers"), ChatManager.format("&f&lSurvive the Night!"), 10, 80, 10);
                    }
                }
                setGameState(GameState.RESTARTING);
                break;
            case RESTARTING:
                for (Player player : Bukkit.getOnlinePlayers()){
                    player.teleport(new Location(Bukkit.getWorld("endor2"), -25.60524039173133, 63.0, -5.747464188295914, -8.700004f, -8.700004f));player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20.0);
                    player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20.0);
                    player.setHealth(20.0);
                    player.getInventory().clear();
                    LuckpermsGroup.addGroup(player, "default");
                    for(PotionEffect effect:player.getActivePotionEffects()){
                        player.removePotionEffect(effect.getType());
                    }
                }
                PlayerManager.ewoks.clear();
                PlayerManager.stormtroopers.clear();
                LobbyTask lobbyTask = new LobbyTask(this);
                lobbyTask.runTaskTimer(plugin, 0, 20);
                setGameState(GameState.LOBBY);
                break;
        }
    }

    public PlayerManager getPlayerManager(){
        return playerManager;
    }

    public GameState getGameState(){return gameState;}

}
