package mandomc.mmcewokhunt.commands;

import mandomc.mmcewokhunt.managers.ChatManager;
import mandomc.mmcewokhunt.managers.GameManager;
import mandomc.mmcewokhunt.managers.GameState;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ForceStart implements CommandExecutor {

    private final GameManager gameManager;

    public ForceStart(GameManager gameManager){
        this.gameManager = gameManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;

            if(player.hasPermission("mmc.ewokhunt.forcestart")){
                if(GameManager.queue.size() > 1){
                    gameManager.setGameState(GameState.ACTIVE);
                }else{
                    player.sendMessage(ChatManager.prefix + "" + ChatManager.format("&cYou need atleast 2 players to force start a game!"));
                }
            }else{
                player.sendMessage(ChatManager.permission);
            }
        }
        return true;
    }
}
