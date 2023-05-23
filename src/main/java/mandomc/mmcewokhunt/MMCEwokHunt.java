package mandomc.mmcewokhunt;

import fr.skytasul.glowingentities.GlowingEntities;
import mandomc.mmcewokhunt.abilities.E11;
import mandomc.mmcewokhunt.abilities.EwokHorn;
import mandomc.mmcewokhunt.abilities.HuntersInstincts;
import mandomc.mmcewokhunt.abilities.Pouch;
import mandomc.mmcewokhunt.commands.*;
import mandomc.mmcewokhunt.listeners.*;
import mandomc.mmcewokhunt.managers.GameManager;
import mandomc.mmcewokhunt.managers.GameState;
import mandomc.mmcewokhunt.managers.PlayerManager;
import mandomc.mmcewokhunt.methodSpam.LuckpermsGroup;
import mandomc.mmcewokhunt.tasks.LobbyTask;
import net.luckperms.api.LuckPerms;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class MMCEwokHunt extends JavaPlugin implements Listener {

    private GlowingEntities glowingEntities;
    private LobbyTask lobbyTask;

    @Override
    public void onEnable() {
        // Plugin startup logic

        this.glowingEntities = new GlowingEntities(this);
        GameManager gameManager = new GameManager(this);

        lobbyTask = new LobbyTask(gameManager);
        lobbyTask.runTaskTimer(this, 0, 20);

        getCommand("joinqueue").setExecutor(new JoinQueue(gameManager));
        getCommand("leavequeue").setExecutor(new LeaveQueue(gameManager));
        getCommand("forcestart").setExecutor(new ForceStart(gameManager));
        getCommand("forcestop").setExecutor(new ForceStop(gameManager));
        getCommand("yaw").setExecutor(new Yaw());
        getCommand("pitch").setExecutor(new Pitch());
        getCommand("locationfinder").setExecutor(new LocationFinder());
        getCommand("test").setExecutor(new Test());

        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new HuntersInstincts(this, glowingEntities), this);
        getServer().getPluginManager().registerEvents(new EwokHorn(), this);
        getServer().getPluginManager().registerEvents(new E11(), this);
        getServer().getPluginManager().registerEvents(new Pouch(), this);
        getServer().getPluginManager().registerEvents(new PlayerManager(), this);
        getServer().getPluginManager().registerEvents(new LeaveEvent(), this);
        getServer().getPluginManager().registerEvents(new JoinEvent(), this);
        getServer().getPluginManager().registerEvents(new DropItemEvent(), this);
        getServer().getPluginManager().registerEvents(new InventoryMoveEvent(), this);
        getServer().getPluginManager().registerEvents(new HungerLossEvent(), this);
        getServer().getPluginManager().registerEvents(new HealthRegainEvent(), this);
        getServer().getPluginManager().registerEvents(new SpearThrowEvent(), this);
        getServer().getPluginManager().registerEvents(new TeamKillingEvent(), this);
        getServer().getPluginManager().registerEvents(new RespawnEvent(this), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        glowingEntities.disable();
    }
}
