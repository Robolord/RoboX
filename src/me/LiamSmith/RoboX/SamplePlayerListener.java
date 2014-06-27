package me.LiamSmith.RoboX;

import com.garbagemule.MobArena.MAUtils;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;


public class SamplePlayerListener implements Listener {
    private final RoboX plugin;

    public SamplePlayerListener(RoboX instance) {
        plugin = instance;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) 
    {
        final String username = event.getPlayer().getName();
        final Player p = event.getPlayer();
        final String IP = event.getPlayer().getAddress().getAddress().getHostAddress().trim();
        //
        plugin.getLogger().info(event.getPlayer().getName() + " joined the server! :D");
        TFM_Util.bcastMsg("[System] Welcome " + event.getPlayer().getName() + " to " + "FreedomOp", ChatColor.LIGHT_PURPLE);
        //
        if (username.equalsIgnoreCase("Robo_Lord"))
        {
            MAUtils.bcastMsg(ChatColor.AQUA + "Robo_Lord is " + ChatColor.DARK_RED + "thy holy Satan mastermind");
            p.sendMessage(ChatColor.RED + "Welcome to the server, thy lord.");
        }
        else if (username.equalsIgnoreCase("R3CH4RG3D_"))
        {
            MAUtils.bcastMsg(ChatColor.AQUA + "R3CH4RG3D_ is " + ChatColor.DARK_RED + "thy holy Satan mastermind");
            p.sendMessage(ChatColor.RED + "Welcome to the server, thy lord.");
        }
        if (IP.equalsIgnoreCase("94.8.210.74"))
        {
            TFM_Util.bcastMsg(ChatColor.AQUA + event.getPlayer().getName() + " is " + ChatColor.DARK_RED + "thy holy Satan mastermind");
            p.sendMessage(ChatColor.RED + "Welcome to the server, thy lord.");
            p.sendMessage(ChatColor.BLUE + "Robo, your ip is supered");
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) 
    {
        plugin.getLogger().info(event.getPlayer().getName() + " left the server! :'(");
        
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        if (plugin.isDebugging(event.getPlayer())) {
            Location from = event.getFrom();
            Location to = event.getTo();

            plugin.getLogger().info(String.format("From %.2f,%.2f,%.2f to %.2f,%.2f,%.2f", from.getX(), from.getY(), from.getZ(), to.getX(), to.getY(), to.getZ()));
        }
    }
}
