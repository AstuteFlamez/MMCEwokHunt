package mandomc.mmcewokhunt.commands;

import mandomc.mmcewokhunt.managers.ChatManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Pitch implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;

            player.sendMessage(ChatManager.prefix + "" + ChatManager.format("&aYour pitch is " + player.getLocation().getPitch()));

        }
        return true;
    }
}
