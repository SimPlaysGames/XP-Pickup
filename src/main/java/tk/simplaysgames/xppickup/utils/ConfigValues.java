package tk.simplaysgames.xppickup.utils;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

/**
 * Created by SimPlaysGames on 20-Nov-16.
 */
public class ConfigValues {

    //Options (Booleans)
    public static boolean DEBUGENABLE = false;
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
        Util.DEBUG("Loading boolean sets", Util.PrintType.BOTH);
        ConfigurationSection options = configuration.getConfigurationSection("configuration");
        DEBUGENABLE = options.getBoolean("debug");

        COLLECTXPMESSAGE = options.getBoolean("collectxpmessage");

        COLLECTXPSOUND = options.getBoolean("collectxpsound");

        //Permissions
        Util.DEBUG("Loading permission sets", Util.PrintType.BOTH);
        ConfigurationSection permissions = configuration.getConfigurationSection("configuration.permissions");
        for(String keys: permissions.getKeys(true)){
            Util.DEBUG(permissions.getString(keys), Util.PrintType.BOTH);
        }

        PICKUPPERM = permissions.getString("xppickup");
        RELOAD = permissions.getString("reload");

        //Messages
        Util.DEBUG("Loading message sets", Util.PrintType.BOTH);
        ConfigurationSection messages = configuration.getConfigurationSection("configuration.messages");
        for(String keys: messages.getKeys(true)){
            Util.DEBUG(messages.getString(keys), Util.PrintType.BOTH);
        }

        COLLECTXPMSG = messages.getString("collectxpmsg");
        RELOADMSG = messages.getString("reloadmsg");
        Util.DEBUG("", Util.PrintType.BOTH);
        Util.DEBUG("", Util.PrintType.BOTH);
        Util.DEBUG("", Util.PrintType.BOTH);
        Util.DEBUG("Values", Util.PrintType.BOTH);
        Util.DEBUG("Pickup perm: " + PICKUPPERM, Util.PrintType.BOTH);
        Util.DEBUG("Reload perm: " + RELOAD, Util.PrintType.BOTH);
        Util.DEBUG("Collect XP Message: " + COLLECTXPMSG, Util.PrintType.BOTH);
        Util.DEBUG("Reload message: " + RELOADMSG, Util.PrintType.BOTH);
    }
}
