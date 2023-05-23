package mandomc.mmcewokhunt.methodSpam;

import mandomc.mmcewokhunt.managers.ChatManager;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ItemStackCreation {

    public static ItemStack ewokHorn(){

        ItemStack itemStack = new ItemStack(Material.GOAT_HORN);
        ItemMeta itemMeta = itemStack.getItemMeta();
        assert itemMeta != null;
        itemMeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Ewok Horn");
        ArrayList<String> itemLore = new ArrayList<>();
        itemLore.add(ChatColor.GRAY + "Right click to gain Strength I for 10 seconds!");
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);

        return  itemStack;
    }

    public static ItemStack activeHuntersInstinct(){

        ItemStack itemStack = new ItemStack(Material.GRAY_DYE);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Hunter's Instinct");
        ArrayList<String> itemLore = new ArrayList<>();
        itemLore.add(ChatManager.format("&7Shift to reveal nearby &fStormtroopers&7!"));
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);

        return  itemStack;
    }

    public static ItemStack ewokSpear(){

        ItemStack itemStack = new ItemStack(Material.TRIDENT);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Ewok's Spear");
        ArrayList<String> itemLore = new ArrayList<>();
        itemLore.add(ChatManager.format("&7Use to kill stormtroopers!"));
        itemLore.add(ChatManager.format(""));
        itemLore.add(ChatManager.format("&c&o&lThrowing disabled!"));
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);

        return  itemStack;
    }

    public static ItemStack inactiveHuntersInstinct(){

        ItemStack itemStack = new ItemStack(Material.LIME_DYE);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Hunter's Instinct");
        ArrayList<String> itemLore = new ArrayList<>();
        itemLore.add(ChatManager.format("&7Shift to reveal nearby &fStormtroopers&7!"));
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);

        return  itemStack;
    }

    public static ItemStack throwablePouch(){

        ItemStack itemStack = new ItemStack(Material.SNOWBALL);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Throwable Pouch");
        ArrayList<String> itemLore = new ArrayList<>();
        itemLore.add(ChatManager.format("&7Right click to swarm enemies"));
        itemLore.add(ChatManager.format("&7with Wisties"));
        itemMeta.setLore(itemLore);
        itemStack.setItemMeta(itemMeta);

        return  itemStack;
    }

    public static ItemStack stormtrooperHelmet(){

        ItemStack itemStack = new ItemStack(Material.CHAINMAIL_HELMET);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "Stormtrooper Helmet");
        itemMeta.setUnbreakable(true);
        itemStack.setItemMeta(itemMeta);

        return  itemStack;
    }

    public static ItemStack stormtrooperChestplate(){

        ItemStack itemStack = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "Stormtrooper Chestplate");
        itemMeta.setUnbreakable(true);
        itemStack.setItemMeta(itemMeta);

        return  itemStack;
    }

    public static ItemStack stormtrooperLeggings(){

        ItemStack itemStack = new ItemStack(Material.CHAINMAIL_LEGGINGS);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "Stormtrooper Leggings");
        itemMeta.setUnbreakable(true);
        itemStack.setItemMeta(itemMeta);

        return  itemStack;
    }

    public static ItemStack stormtrooperBoots(){

        ItemStack itemStack = new ItemStack(Material.CHAINMAIL_BOOTS);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "Stormtrooper Boots");
        itemMeta.setUnbreakable(true);
        itemStack.setItemMeta(itemMeta);

        return  itemStack;
    }
}
