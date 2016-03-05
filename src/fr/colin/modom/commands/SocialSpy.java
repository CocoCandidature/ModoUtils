package fr.colin.modom.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.colin.modom.ModoMessage;
import fr.colin.modom.utils.Utils;

public class SocialSpy implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;

		if(cmd.getName().equalsIgnoreCase("socialspy")){
			if(p.hasPermission("modo.sp")){
				if(ModoMessage.getInstance().getSp().contains(p)){
					ModoMessage.getInstance().getSp().remove(p);
					p.sendMessage(Utils.getMessageSp2());
				}else{
					ModoMessage.getInstance().getSp().add(p);
					p.sendMessage(Utils.getMessageSp1());
				}
			}
			return false;
		}
		return false;
	}
}
