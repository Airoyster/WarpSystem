package de.airoyster.warpsystem.warp;


import de.airoyster.warpsystem.Main;
import org.bukkit.Location;

public class WarpManager {

    public static Location getWarp(String name){
        return Main.getCfg().getConfiguration().getLocation(name);
    }

    public static Location createWarp(String name , Location location){
        Main.getCfg().set(name, location);
        Main.getCfg().save();

        return location;
    }

    public static void deletWarp(String name){
        Main.getCfg().set(name , null);
        Main.getCfg().save();
    }
}
