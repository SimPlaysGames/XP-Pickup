package tk.simplaysgames.xppickup.utils;

import org.bukkit.Bukkit;
import org.bukkit.Sound;

/**
 * Created by SimPlaysGames on 27.11.2016.
 */
public class SoundUtil {
    public static final Sound ORB_PICKUP;

    static{
        if(Bukkit.getServer().getClass().getPackage().getName().contains("1.10") || Bukkit.getServer().getClass().getPackage().getName().contains("1.9")) {
            ORB_PICKUP = Sound.valueOf("ENTITY_EXPERIENCE_ORB_PICKUP");
        }
        else{

            ORB_PICKUP = Sound.valueOf("ORB_PICKUP");
        }
    }
}
