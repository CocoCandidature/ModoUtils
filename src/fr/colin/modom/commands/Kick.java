package fr.colin.modom.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.colin.modom.utils.Utils;

public class Kick implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (cmd.getName().equals("kick")) {
            if (p.hasPermission("Modo.kc")) {
                if (args.length < 2) {
                    p.sendMessage(Utils.getMessageNotArgs());
                } else {
                    if (Bukkit.getPlayer(args[0]) == null) {
                        p.sendMessage(Utils.getTargetDisconnecte());
                    } else {
                        StringBuilder str = new StringBuilder();
                        for (int i = 1; i < args.length; i++) {
                            str.append(args[i] + " ");
                        }
                        Player pla = Bukkit.getPlayer(args[0]);
                        pla.kickPlayer(Utils.getKickMessageKicker().replace("%raison%", str.toString().replace("&", "§")));
                        Bukkit.broadcastMessage("                                  ");
                        Bukkit.broadcastMessage("                                  ");
                        Bukkit.broadcastMessage("                                  ");
                        Bukkit.broadcastMessage(Utils.getPrefixModo() + Utils.getKickMessageKicking().replace("%kicking%", pla.getName()).replace("%raison%", str.toString().replace("&", "§")));
                        Bukkit.broadcastMessage("                                  ");
                        Bukkit.broadcastMessage("                                  ");
                        Bukkit.broadcastMessage("                                  ");
                    }


                }
                return false;
            }
        }
        return false;
    }
}
