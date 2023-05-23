package mandomc.mmcewokhunt.commands;

import mandomc.mmcewokhunt.managers.ChatManager;
import mandomc.mmcewokhunt.managers.GameManager;
import mandomc.mmcewokhunt.managers.GameState;
import mandomc.mmcewokhunt.methodSpam.LuckpermsGroup;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class JoinQueue implements CommandExecutor {

    private final GameManager gameManager;

    public JoinQueue(GameManager gameManager){
        this.gameManager = gameManager;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;

            if(gameManager.getGameState() == GameState.LOBBY || gameManager.getGameState() == GameState.STARTING){
                if(!GameManager.queue.contains(player)){
                    if(GameManager.queue.size()<=20){
                        GameManager.queue.add(player);
                        player.sendMessage(ChatManager.prefix + "" + ChatManager.format("&aYou have joined the queue!"));
                        LuckpermsGroup.addGroup(player, "queue");
                    }else{
                        player.sendMessage(ChatManager.prefix + "" + ChatManager.format("&cSorry, the queue is full!"));
                    }
                }else{
                    player.sendMessage(ChatManager.prefix + "" + ChatManager.format("&cYou are already in the queue!!"));
                }
            }else{
                player.sendMessage(ChatManager.prefix + "" + ChatManager.format("&cSorry, the queue is not open!"));
            }
        }
        return true;
    }
}
