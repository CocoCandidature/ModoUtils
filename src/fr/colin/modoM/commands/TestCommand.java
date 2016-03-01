package fr.colin.modoM.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

import java.util.ArrayList;

/**
 * Created by coco33910 on 19/02/2016.
 * TestCommand
 */
public class TestCommand implements CommandExecutor {

    private static TestCommand ourInstance = new TestCommand();

    public static TestCommand getInstance() {
        return ourInstance;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(command.getName().equals("test")) {
            Player p = (Player) commandSender;
            p.sendMessage("monde : " + p.getWorld().getName());


      
        }

        return false;
    }
}
