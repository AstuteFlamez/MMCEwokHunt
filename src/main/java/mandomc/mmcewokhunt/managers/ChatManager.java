package mandomc.mmcewokhunt.managers;

import org.bukkit.ChatColor;

public class ChatManager {

    public static String format(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static String permission = ChatManager.prefix + "" + format("&cThe force is not with you...");
    public static String prefix = format("&6&lEwok Hunt » &r");
}