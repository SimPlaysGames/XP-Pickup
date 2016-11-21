package tk.simplaysgames.xppickup.listeners.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import tk.simplaysgames.xppickup.Main;

import java.util.ArrayList;
import java.util.List;

import static tk.simplaysgames.xppickup.utils.ConfigValues.RELOAD;

/**
 * Created by SimPlaysGames on 20-Nov-16.
 */
public class TabCompletion implements TabCompleter{
    @Override
    public List<String> onTabComplete (CommandSender sender, Command cmd, String label, String[] args){
        if(args.length == 0){
            List<String> completions = new ArrayList<>();
            completions.add("help");

            if(sender.hasPermission(RELOAD)) {
                completions.add("reload");
            }
            return list;
            }
        }
        return null;
    }
}
