package fr.colin.modoM.commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.colin.modoM.utils.Utils;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class Help implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
	
		if(cmd.getName().equalsIgnoreCase("help")){
			if(args.length < 1){
				p.sendMessage(Utils.getMessageNotArgs()); 
			}else{
				 StringBuilder str = new StringBuilder();
				  for(int i = 0; i < args.length; i++){
					  str.append(args[i] + " ");
				  }
				  
				  for(Player pla : Bukkit.getOnlinePlayers()){
					  if(pla.hasPermission("modo.ask")){
						  TextComponent e = new TextComponent( Utils.getPrefixModo() + Utils.getMessageAsk().replace("%player%", p.getName()).replace("%question%", str.toString()) );
						  e.setClickEvent(new ClickEvent(net.md_5.bungee.api.chat.ClickEvent.Action.SUGGEST_COMMAND, "/msg " + p.getName() + " "));
						  e.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(Utils.getAsk_Hover_Message()).create()));
						  pla.sendMessage( " ");
						  pla.spigot().sendMessage( e ); //new TextComponent("§4[§6Modération§4§l] §2§o " + p.getName() + "  §c a posé une question  :  §b" + e)); 
						  pla.sendMessage( " ");
						  pla.playSound(pla.getLocation(), Sound.LEVEL_UP, 1000, 1000);
					  }
				  }
		return false;
	}

}
		return false;
	}
	
	
	
}
