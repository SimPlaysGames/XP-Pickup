package tk.simplaysgames.xppickup;

import net.milkbowl.vault.permission.Permission;
import org.bukkit.plugin.java.JavaPlugin;
import tk.simplaysgames.xppickup.listeners.Commands.XPCommands;
import tk.simplaysgames.xppickup.listeners.XPListener;
import tk.simplaysgames.xppickup.utils.ConfigValues;
import tk.simplaysgames.xppickup.utils.Util;

import java.util.logging.Logger;

import tk.simplaysgames.xppickup.utils.Util.PrintType;

/**
 * Created by SimPlaysGames on 20-Nov-16.
 */
public class Main extends JavaPlugin{
    public Logger logger = this.getLogger();
    public static Permission permission = null;


    @Override
    public void onEnable(){

        //Config
        Util.DEBUG("Trying to save defualt config.", PrintType.CONSOLE);
        this.saveDefaultConfig();

        //Load values
        Util.DEBUG("Configuration values loading.", PrintType.CONSOLE);
        new ConfigValues(this.getConfig());

        //Register listener
        getServer().getPluginManager().registerEvents(new XPListener(), this);

        //Register Commands
        Util.DEBUG("Registering commands.", PrintType.CONSOLE);
        this.getCommand("xppickup").setExecutor(new XPCommands());
    }

    public void onDisable(){

    }

}
















