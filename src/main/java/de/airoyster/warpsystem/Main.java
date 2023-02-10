package de.airoyster.warpsystem;

import de.airoyster.warpsystem.commands.Warp_CMD;
import de.airoyster.warpsystem.warp.Config;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    public static String prefix = "§cWarpsystem ";
    public static String noPerms = "§cWarpsystem §4You dont have Permissions for this command!";
    public static String con = ChatColor.RED + "The console can't use the command.";

    private static Config cfg;

    @Override
    public void onEnable() {
        // Plugin startup logic
        cfg = new Config("warps.yml", getDataFolder());
        Bukkit.getConsoleSender().sendMessage("§cWarpsystem activatet!");
        getCommand("warp").setExecutor(new Warp_CMD());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getConsoleSender().sendMessage("§cWarpsystem deactivatet!");
    }

    public static Config getCfg() {
        return cfg;
    }
}
