package me.LiamSmith.RoboX.Commands.RoboCommands;

import java.util.List;
import java.util.logging.Logger;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.LiamSmith.RoboX.RoboX;


public class RoboX_Command
{
    public RoboX plugin;
    public static final Logger log = Bukkit.getLogger();
    public static final Server server = Bukkit.getServer();

    public RoboX_Command()
    {
    }

    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        log.severe("Command Error: Command not implemented: " + cmd.getName());
        sender.sendMessage(ChatColor.RED + "Command Error: Command not implemented: " + cmd.getName());
        return false;
    }

    public void setPlugin(RoboX plugin)
    {
        this.plugin = plugin;
    }

    public Player getPlayer(String partialname) throws PlayerNotFoundException
    {
        List<Player> matches = Bukkit.matchPlayer(partialname);
        if (matches.isEmpty())
        {
            throw new PlayerNotFoundException(partialname);
        }
        else
        {
            return matches.get(0);
        }
    }
}
