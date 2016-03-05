package fr.colin.modom.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.colin.modom.utils.Utils;

public class Modo implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player) sender;
		if(sender instanceof Player){
			if(cmd.getName().equalsIgnoreCase("modo")){
				if(p.hasPermission("Modo.md")){
					if(args.length == 0){
						p.sendMessage(Utils.getMessageNotArgs());
					}else{
						StringBuilder str = new StringBuilder();
						  for(int i = 0; i < args.length; i++){
							  
							  str.append(args[i] + " ");
									 
									 
					}
						  Bukkit.broadcastMessage("                                  ")	;
						  Bukkit.broadcastMessage("                                  ")	;
						  Bukkit.broadcastMessage("                                  ")	;
						  Bukkit.broadcastMessage( Utils.getPrefixModo()  + Utils.getMessageModo().replace("%player%", p.getName()).replace("%message%", str.toString().replace("&", "�")) );
						  Bukkit.broadcastMessage("                                  ")	;
						  Bukkit.broadcastMessage("                                  ")	;
						  Bukkit.broadcastMessage("                                  ")	;
				}
				return true;
			}else{
				p.sendMessage(Utils.getMessageNoPerm());
			}
			
				 }
		return false;
	}
		return false;

}
}

