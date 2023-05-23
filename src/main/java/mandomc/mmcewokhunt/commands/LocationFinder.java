package mandomc.mmcewokhunt.commands;

import mandomc.mmcewokhunt.managers.ChatManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LocationFinder implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;
            Location loc = player.getLocation();

            if(player.hasPermission("mmc.ewokhunt.locationfinder")) {
                Bukkit.broadcastMessage(ChatManager.format("loc.add(new Location(Bukkit.getWorld(\"endor\"), " + loc.getX() + ", " + loc.getY() + ", " + loc.getZ() + ", " + loc.getPitch() + "f, " + loc.getPitch() + "f));"));
            }else{
                player.sendMessage(ChatManager.permission);
            }
        }
        return true;
    }
}
