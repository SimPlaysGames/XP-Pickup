package tk.simplaysgames.xppickup;

import org.apache.commons.lang.ObjectUtils;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import tk.simplaysgames.xppickup.listeners.Commands.TabCompletion;
import tk.simplaysgames.xppickup.listeners.Commands.XPCommands;
import tk.simplaysgames.xppickup.listeners.XPListener;
import tk.simplaysgames.xppickup.utils.ConfigValues;
import tk.simplaysgames.xppickup.utils.Util;

import tk.simplaysgames.xppickup.utils.Util.PrintType;

import java.util.ArrayList;
import java.util.List;

import static tk.simplaysgames.xppickup.utils.ConfigValues.PICKUPPERM;
import static tk.simplaysgames.xppickup.utils.ConfigValues.RELOAD;

/**
 * Created by SimPlaysGames on 20-Nov-16.
 */
public class Main extends JavaPlugin{


    @Override
    public void onEnable(){
        //Config
        Util.DEBUG("Trying to save defualt config.", PrintType.CONSOLE);
        this.saveDefaultConfig();

        //Load values
        Util.DEBUG("Configuration values loading.", PrintType.CONSOLE);
        new ConfigValues(this.getConfig());

        //Register permissions
        Util.DEBUG("Registering permissions", PrintType.CONSOLE);
        registerPermissions();

        //Register listener
        Util.DEBUG("Registering listeners", PrintType.CONSOLE);
        getServer().getPluginManager().registerEvents(new XPListener(), this);

        //Register Commands
        Util.DEBUG("Registering commands.", PrintType.CONSOLE);
        this.getCommand("xppickup").setExecutor(new XPCommands());

        //Register tab complete
        Util.DEBUG("Registering tab completion", PrintType.CONSOLE);
        this.getCommand("xppickup").setTabCompleter(new TabCompletion());
    }

    private void registerPermissions(){
        PluginManager pluginManager = getServer().getPluginManager();

        List<Permission> perms = new ArrayList<>();

        if(!(PICKUPPERM == null || PICKUPPERM == "")){
            perms.add(new Permission(PICKUPPERM));
        }
        else{
            PICKUPPERM = "xp-pickup.pickup";
            perms.add(new Permission("xp-pickup.pickup"));
        }
        if(!(RELOAD == null || RELOAD == "")){
            perms.add(new Permission(RELOAD));
        }
        else{
            RELOAD = "xp-pickup.reload";
            perms.add(new Permission("xp-pickup.reload"));
        }

        for(Permission permission: perms){
            pluginManager.addPermission(permission);
        }
    }
}















