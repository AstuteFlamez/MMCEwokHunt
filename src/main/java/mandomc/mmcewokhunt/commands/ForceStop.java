package mandomc.mmcewokhunt.commands;

import mandomc.mmcewokhunt.managers.ChatManager;
import mandomc.mmcewokhunt.managers.GameManager;
import mandomc.mmcewokhunt.managers.GameState;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ForceStop implements CommandExecutor {

    private final GameManager gameManager;

    public ForceStop(GameManager gameManager){
        this.gameManager = gameManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;

            if(player.hasPermission("mmc.ewokhunt.forcestop")){
                if(gameManager.getGameState() == GameState.ACTIVE){
                    gameManager.setGameState(GameState.WON);
                }else{
                    player.sendMessage(ChatManager.prefix + "" + ChatManager.format("&cThere is no active game!"));
                }
            }else{
                player.sendMessage(ChatManager.permission);
            }
        }
        return true;
    }
}
