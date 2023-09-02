package it.craftopoly.co_ranks;

import it.craftopoly.co_ranks.listener.ChatEvent;
import it.craftopoly.co_ranks.listener.JoinEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class CO_Ranks extends JavaPlugin {

    private static CO_Ranks plugin;
    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        saveDefaultConfig();
        Bukkit.getServer().getPluginManager().registerEvents(new ChatEvent(),this);
        Bukkit.getServer().getPluginManager().registerEvents(new JoinEvent(),this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static CO_Ranks getInstance()
    {
        return plugin;
    }
}
