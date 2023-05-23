package mandomc.mmcewokhunt.commands;

import mandomc.mmcewokhunt.managers.PlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Test implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;

            player.sendMessage("ewoks: " + PlayerManager.ewoks.size());
            player.sendMessage("stormtroopers: " + PlayerManager.stormtroopers.size());

            for(int i = 0; i < PlayerManager.ewoks.size(); i++){
                player.sendMessage("ewok " + i + PlayerManager.ewoks.get(i).getName());
            }
            for(int i = 0; i < PlayerManager.stormtroopers.size(); i++){
                player.sendMessage("stormtrooper " + i + PlayerManager.stormtroopers.get(i).getName());
            }

        }

        return true;
    }
}
