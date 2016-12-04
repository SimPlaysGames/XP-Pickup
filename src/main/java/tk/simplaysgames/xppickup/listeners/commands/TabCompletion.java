package tk.simplaysgames.xppickup.listeners.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static tk.simplaysgames.xppickup.utils.ConfigValues.RELOAD;

/**
 * Created by SimPlaysGames on 20-Nov-16.
 */
public class TabCompletion implements TabCompleter{
    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args){
        //TODO: Fix tab completion
        /*
        if(args.length <= 1){
            List<String> completions = new ArrayList<>();
            completions.add("help");

            if(sender.hasPermission(RELOAD)) {
                completions.add("reload");
            }
            return completions;
        }
        */
        return Collections.emptyList();
    }
}
