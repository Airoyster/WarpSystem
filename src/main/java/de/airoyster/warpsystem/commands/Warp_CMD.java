package de.airoyster.warpsystem.commands;

import de.airoyster.warpsystem.Main;
import de.airoyster.warpsystem.warp.WarpManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Warp_CMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage(Main.con);
            return false;
        }
        Player p = (Player) sender;
        if (args.length == 1){
            if (WarpManager.getWarp(args[0]) != null){
                p.teleport(WarpManager.getWarp(args[0]));
                p.sendMessage(Main.prefix + "§e" + "You have been teleported to the Warp: §6§l " + args[0]);
            } else {
                p.sendMessage(Main.prefix + "§cThis warp does not exist!");
            }
        } else if (args.length == 2) {
            if (!p.hasPermission("system.warpmanage")){
                p.sendMessage(Main.noPerms);
                return false;
            }
            if (args[0].equalsIgnoreCase("add")){
                if (WarpManager.getWarp(args[1]) == null){
                    WarpManager.createWarp(args[1] , p.getLocation());
                    p.sendMessage(Main.prefix + "§aYou have createt this Warp: " + args[1] + " erstellt!");
                } else {
                    p.sendMessage(Main.prefix + "§c" + "That warp already exists!");
                }
            } else if (args[0].equalsIgnoreCase("delete")) {
                if (WarpManager.getWarp(args[1]) != null){
                    WarpManager.deletWarp(args[1]);
                    p.sendMessage(Main.prefix + "§aYou have deletet this Warp: " + args[1] + " gelöscht!");
                } else {
                    p.sendMessage(Main.prefix + "§c" + "This warp does not exist");
                }

            }
        } else {
            p.sendMessage(Main.prefix + "§c" + "This warp does not exist!");
        }
        return false;
    }
}