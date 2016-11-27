package tk.simplaysgames.xppickup.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.ThrownExpBottle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import tk.simplaysgames.xppickup.utils.SoundUtil;
import tk.simplaysgames.xppickup.utils.Util;
import tk.simplaysgames.xppickup.utils.Util.PrintType;

import java.util.Random;

import static tk.simplaysgames.xppickup.utils.ConfigValues.*;

/**
 * Created by SimPlaysGames on 20-Nov-16.
 */
public class XPListener implements Listener{

    @EventHandler(priority= EventPriority.NORMAL)
    public void onThrow (ProjectileLaunchEvent event){
        if(event.getEntity() instanceof ThrownExpBottle){
            ThrownExpBottle bottle = (ThrownExpBottle) event.getEntity();
            if(bottle.getShooter() instanceof Player) {

                Player player = (Player) bottle.getShooter();
                if (player.hasPermission(PICKUPPERM) || player.isOp()) {

                    int experience = (3 + new Random().nextInt(8));
                    player.giveExp(experience);

                    if (COLLECTXPMESSAGE) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', COLLECTXPMSG.replace("{%amount%}", experience + "")));
                    }
                    else {
                        Util.DEBUG("No message set", PrintType.INGAME);
                    }

                    if(COLLECTXPSOUND) {
                            player.playSound(player.getLocation(), SoundUtil.ORB_PICKUP, 1.0f, new Random().nextFloat() * 0.5f + 0.5f);
                    }
                    event.setCancelled(true);
                }
                else {
                    player.sendMessage(ChatColor.RED + "You do not have the permission to do this!");
                }
            }
        }
    }
}
