package me.LiamSmith.RoboX;

import java.util.HashMap;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import me.LiamSmith.RoboX.Commands.RoboCommands.Command_robomanage;
import me.LiamSmith.RoboX.Commands.Command_debug;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public class RoboX extends JavaPlugin 
{
    private final SamplePlayerListener playerListener = new SamplePlayerListener(this);
    private final SampleBlockListener blockListener = new SampleBlockListener();
    private final HashMap<Player, Boolean> debugees = new HashMap<Player, Boolean>();
    public static final String COMMAND_PATH = "me.LiamSmith.RoboX";
    public static final String COMMAND_PREFIX = "Command_";

    @Override
    public void onDisable() {
        // TODO: Place any custom disable code here

        // NOTE: All registered events are automatically unregistered when a plugin is disabled

        // EXAMPLE: Custom code, here we just output some info so we can check all is well
        getLogger().info("Goodbye world!");
    }

    @Override
    public void onEnable() {
        // TODO: Place any custom enable code here including the registration of any events

        // Register our events
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(playerListener, this);
        pm.registerEvents(blockListener, this);

        // Register our commands
        getCommand("pos").setExecutor((CommandExecutor) new Command_pos());
        getCommand("robomanage").setExecutor((CommandExecutor) new Command_robomanage());
        getCommand("debug").setExecutor((CommandExecutor) new Command_debug(this));
        
        

        // EXAMPLE: Custom code, here we just output some info so we can check all is well
        PluginDescriptionFile pdfFile = this.getDescription();
        getLogger().info( pdfFile.getName() + " version " + pdfFile.getVersion() + " is enabled!" );
    }

    public boolean isDebugging(final Player player) {
        if (debugees.containsKey(player)) {
            return debugees.get(player);
        } else {
            return false;
        }
    }

    public void setDebugging(final Player player, final boolean value) {
        debugees.put(player, value);
    }

}
