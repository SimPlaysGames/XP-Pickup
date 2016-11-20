package tk.simplaysgames.xppickup.utils;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

/**
 * Created by SimPlaysGames on 20-Nov-16.
 */
public class ConfigValues {

    //Options (Booleans)
    public static boolean DEBUGENABLE = true;
    public static boolean COLLECTXPMESSAGE = false;
    public static boolean COLLECTXPSOUND = true;

    //Perms (String)
    public static String PICKUPPERM = "";
    public static String RELOAD = "";

    //Messages (String)
    public static String COLLECTXPMSG = "";
    public static String RELOADMSG = "";

    public ConfigValues (FileConfiguration configuration){

        //Config booleans
        ConfigurationSection options = configuration.getConfigurationSection("configuration");
        DEBUGENABLE = options.getBoolean("debug");

        COLLECTXPMESSAGE = options.getBoolean("collectxpmessage");

        COLLECTXPSOUND = options.getBoolean("collectxpsound");

        //Permissions
        ConfigurationSection permissions = configuration.getConfigurationSection("configuration.permissions");
        for(String keys: permissions.getKeys(true)){
            Util.DEBUG(permissions.getString(keys), Util.PrintType.BOTH);
        }

        PICKUPPERM = configuration.getString("xppickup");
        RELOAD = configuration.getString("reload");

        //Messages
        ConfigurationSection messages = configuration.getConfigurationSection("configuration.messages");
        for(String keys: messages.getKeys(true)){
            Util.DEBUG(permissions.getString(keys), Util.PrintType.BOTH);
        }

        COLLECTXPMSG = messages.getString("collectxpmsg");
        RELOAD = messages.getString("reloadmsg");
    }

}
