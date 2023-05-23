package mandomc.mmcewokhunt.managers;

import mandomc.mmcewokhunt.methodSpam.ItemStackCreation;
import mandomc.mmcewokhunt.methodSpam.LuckpermsGroup;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class PlayerManager implements Listener {

    public static ArrayList<Player> ewoks = new ArrayList<>();
    public static ArrayList<Player> stormtroopers = new ArrayList<>();

    public static void giveKits(){
        Collections.shuffle(GameManager.queue);

        if(GameManager.queue.size() == 2){
            giveEwokKit(GameManager.queue.get(0));
            teleportEwok(GameManager.queue.get(0));
            GameManager.queue.get(0).sendMessage(ChatManager.prefix + "" + ChatManager.format("&aYou have been selected as... an &6&lEwok&a!"));
            giveStormtrooperKit(GameManager.queue.get(1));
            teleportStormtrooper(GameManager.queue.get(1));
            GameManager.queue.get(1).sendMessage(ChatManager.prefix + "" + ChatManager.format("&aYou have been selected as... a &f&lStormtrooper&a!"));
        }else{
            for(int i = 0; i < GameManager.queue.size(); i++){
                if(i <= 1){
                    giveEwokKit(GameManager.queue.get(i));
                    teleportEwok(GameManager.queue.get(i));
                    GameManager.queue.get(i).sendMessage(ChatManager.prefix + "" + ChatManager.format("&aYou have been selected as... an &6&lEwok&a!"));
                }else{
                    giveStormtrooperKit(GameManager.queue.get(i));
                    teleportStormtrooper(GameManager.queue.get(i));
                    GameManager.queue.get(i).sendMessage(ChatManager.prefix + "" + ChatManager.format("&aYou have been selected as... a &f&lStormtrooper&a!"));
                }
            }
        }

        GameManager.queue.clear();

    }

    public static void giveEwokKit(Player player){

        player.getInventory().setItem(0, ItemStackCreation.ewokSpear());
        player.getInventory().setItem(1, ItemStackCreation.inactiveHuntersInstinct());
        player.getInventory().setItem(2, ItemStackCreation.ewokHorn());
        player.getInventory().setItem(3, ItemStackCreation.throwablePouch());

        ewoks.add(player);

        player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(16.0);
        player.setHealth(16.0);

        LuckpermsGroup.addGroup(player, "ewok");

    }

    public static void giveStormtrooperKit(Player player){

        player.getInventory().setHelmet(ItemStackCreation.stormtrooperHelmet());
        player.getInventory().setChestplate(ItemStackCreation.stormtrooperChestplate());
        player.getInventory().setLeggings(ItemStackCreation.stormtrooperLeggings());
        player.getInventory().setBoots(ItemStackCreation.stormtrooperBoots());

        Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "shot give " + player.getName() + " e11");

        player.addPotionEffect(new PotionEffect(PotionEffectType.DARKNESS, Integer.MAX_VALUE, 1));

        stormtroopers.add(player);

        player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(40.0);
        player.setHealth(40.0);

        LuckpermsGroup.addGroup(player, "stormtrooper");

    }

    public static void teleportEwok(Player player){

        ArrayList<Location> loc = new ArrayList<>();
        loc.add(new Location(Bukkit.getWorld("endor"), -88, 84, 94, -137.1f, -0.15f));
        loc.add(new Location(Bukkit.getWorld("endor"), -98, 101, 57, 146.1f, 25.5f));

        Random random = new Random();
        int randomIndex = random.nextInt(loc.size());

        player.teleport(loc.get(randomIndex));
    }

    public static void teleportStormtrooper(Player player){

        ArrayList<Location> loc = new ArrayList<>();

        loc.add(new Location(Bukkit.getWorld("endor"), -77.61086442939937, 66.0, 16.908751442635115, -3.1499984f, -3.1499984f));
        loc.add(new Location(Bukkit.getWorld("endor"), -50.494120686782324, 65.0, 99.54510410717636, 16.200056f, 16.200056f));
        loc.add(new Location(Bukkit.getWorld("endor"), -132.77095064422875, 67.0, 128.48840229879735, -5.6998634f, -5.6998634f));
        loc.add(new Location(Bukkit.getWorld("endor"), -109.06814734835731, 66.0, 71.54337256181464, 27.000145f, 27.000145f));
        loc.add(new Location(Bukkit.getWorld("endor"), -146.93019985605122, 66.0, 17.6757959720455, 19.200203f, 19.200203f));
        loc.add(new Location(Bukkit.getWorld("endor"), -172.3229325179901, 70.0, 92.49488853412282, 36.1502f, 36.1502f));
        loc.add(new Location(Bukkit.getWorld("endor"), -171.86162526572176, 75.0, 178.0567763731437, 35.850246f, 35.850246f));
        loc.add(new Location(Bukkit.getWorld("endor"), -115.40037527009947, 65.0, 206.55925444901825, 20.700302f, 20.700302f));
        loc.add(new Location(Bukkit.getWorld("endor"), -71.1331623265993, 69.0, 210.63007376064581, 6.0003057f, 6.0003057f));
        loc.add(new Location(Bukkit.getWorld("endor"), 0.32805673918945755, 70.0, 145.07860879703586, -17.400019f, -17.400019f));
        loc.add(new Location(Bukkit.getWorld("endor"), -24.396418772584724, 72.0, 187.70466767978337, 29.40026f, 29.40026f));
        loc.add(new Location(Bukkit.getWorld("endor"), 25.36962287751891, 73.0, 158.71040235761168, 34.35018f, 34.35018f));
        loc.add(new Location(Bukkit.getWorld("endor"), 24.567953174056576, 75.0, 190.9274687297318, -13.050027f, -13.050027f));
        loc.add(new Location(Bukkit.getWorld("endor"), 41.881869184344225, 76.0, 200.7090927654649, 26.40018f, 26.40018f));
        loc.add(new Location(Bukkit.getWorld("endor"), 4.398921467190506, 72.0, 191.71456773078015, -3.600029f, -3.600029f));
        loc.add(new Location(Bukkit.getWorld("endor"), 39.31811242743766, 67.0, 129.38811230704778, 23.700188f, 23.700188f));
        loc.add(new Location(Bukkit.getWorld("endor"), -1.4617778992555501, 66.0, 112.4564223037872, 26.55018f, 26.55018f));
        loc.add(new Location(Bukkit.getWorld("endor"), -72.11381908791566, 69.0, 211.70838059289676, -11.700017f, -11.700017f));
        loc.add(new Location(Bukkit.getWorld("endor"), -37.40879640858903, 63.0, 84.38287758362985, 26.55018f, 26.55018f));
        loc.add(new Location(Bukkit.getWorld("endor"), -186.24473866856388, 74.0, 209.75798229401232, -1.0500175f, -1.0500175f));
        loc.add(new Location(Bukkit.getWorld("endor"), -79.30000001192093, 64.0, 27.312422063932456, 43.20023f, 43.20023f));
        loc.add(new Location(Bukkit.getWorld("endor"), -188.83578726366096, 67.0, -12.8161902034334, 54.600327f, 54.600327f));
        loc.add(new Location(Bukkit.getWorld("endor"), -161.24756730407725, 73.0, 67.69210468799422, -3.600057f, -3.600057f));
        loc.add(new Location(Bukkit.getWorld("endor"), -194.01048866570258, 71.0, 38.698230976916946, -8.549781f, -8.549781f));
        loc.add(new Location(Bukkit.getWorld("endor"), -152.51643175194747, 65.0, 7.8406167771354, -16.800055f, -16.800055f));
        loc.add(new Location(Bukkit.getWorld("endor"), -156.30000001192093, 80.0, 74.14515165091845, 34.200165f, 34.200165f));
        loc.add(new Location(Bukkit.getWorld("endor"), -113.68202875233149, 65.0, 93.02619085776799, 25.350088f, 25.350088f));
        loc.add(new Location(Bukkit.getWorld("endor"), 12.54863208805999, 65.0, -8.345012996626318, -9.750033f, -9.750033f));
        loc.add(new Location(Bukkit.getWorld("endor"), 52.132261317496194, 63.0, 35.15009882600414, -6.900061f, -6.900061f));

        Random random = new Random();
        int randomIndex = random.nextInt(loc.size());

        player.teleport(loc.get(randomIndex));

    }

}
