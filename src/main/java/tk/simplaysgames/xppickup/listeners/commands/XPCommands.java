package tk.simplaysgames.xppickup.listeners.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tk.simplaysgames.xppickup.Main;
import tk.simplaysgames.xppickup.utils.ConfigValues;
import tk.simplaysgames.xppickup.utils.Util;

import static tk.simplaysgames.xppickup.utils.ConfigValues.RELOAD;

/**
 * Created by SimPlaysGames on 20-Nov-16.
 */
public class XPCommands implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if(!(sender.hasPermission(RELOAD))){
            sender.sendMessage(Util.PREFIX + "&c You do not have permission to use this command.");
            return true;
        }
        if(args.length >= 1){
            String cd = args[0].toLowerCase();

            switch (cd) {
                case "help":
                    this.help(sender);
                    return true;
                case "reload":
                    this.configReload();
                    sender.sendMessage(Util.PREFIX + "Config reloaded.");
                    return true;
                default:
                    this.help(sender);
                    return true;
            }
        }
        else{
            this.help(sender);
            return true;
        }
    }

    public void configReload(){
        Main.getPlugin(Main.class).reloadConfig();
        new ConfigValues(Main.getPlugin(Main.class).getConfig());
    }

    public void help(CommandSender sender){
        sender.sendMessage(Util.PREFIX + "Help - Page 1 of 1");
        sender.sendMessage(Util.PREFIX + "/xppickup §6help <page> §7- Displays the help menu");
        sender.sendMessage(Util.PREFIX + "/xppickup §6reload §7- Reloads all config values");
    }
}
