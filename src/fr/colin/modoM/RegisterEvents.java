package fr.colin.modoM;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;


public class RegisterEvents {
    public static void re(Plugin pl) {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new Events(), pl);


    }

}
