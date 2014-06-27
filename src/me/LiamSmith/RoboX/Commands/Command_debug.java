package me.LiamSmith.RoboX.Commands;

import me.LiamSmith.RoboX.RoboX;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_debug implements CommandExecutor 
{
    private final RoboX plugin;

    public Command_debug(RoboX plugin) 
    {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] split) 
    {
        if (sender instanceof Player) 
        {
            Player player = (Player) sender;
            plugin.setDebugging(player, !plugin.isDebugging(player));
            return true;
        } 
        else 
        {
            return false;
        }
    }
}
