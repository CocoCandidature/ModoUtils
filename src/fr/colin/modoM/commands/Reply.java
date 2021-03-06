package fr.colin.modoM.commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.colin.modoM.ModoMessage;
import fr.colin.modoM.utils.Utils;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class Reply implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
	
		if(cmd.getName().equalsIgnoreCase("r")){
			if(ModoMessage.reply.containsKey(p)){
				if(args.length < 1){
					p.sendMessage(Utils.getReply_Help() );
					
				}else{
					Player target = ModoMessage.reply.get(p);
					if(target == null){
						p.sendMessage(Utils.getTargetDisconnecte());
					}else{
					 StringBuilder str = new StringBuilder();
					  for(int i = 0; i < args.length; i++){
						  str.append(args[i] + " ");
					  }
					  
					  
					  
					  TextComponent message1 = new TextComponent(Utils.getMessageMsgSender().replace("%sender%", p.getName()).replace("%target%", target.getName()).replace("%message%", str.toString().replace("&", "§")));
					  TextComponent message2 = new TextComponent(Utils.getMessageMsgRecever().replace("%sender%", p.getName()).replace("%target%", target.getName()).replace("%message%", str.toString().replace("&", "§")) );
					  message1.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/msg " + target.getName() + " "));
					  message1.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder( "§7§oClique pour répondre à "  + target.getName() ).create() ) );
					  
					  message2.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/msg " + p.getName() + " ") );
					  message2.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§7§oClique pour répondre à "   + p.getName()).create()));
				
					  p.sendMessage(" ");
					  p.spigot().sendMessage(message1);
					  p.sendMessage(" ");
					  target.sendMessage(" ");
					  target.spigot().sendMessage(message2);
					  target.sendMessage(" ");
					  
					  target.playSound(target.getLocation(), Sound.NOTE_PIANO, 10, 10);
					  p.playSound(p.getLocation(), Sound.NOTE_PIANO, 10, 10);
					  for(Player pla : Bukkit.getOnlinePlayers()){
						  if(ModoMessage.sp.contains(pla)){
							  pla.sendMessage("§c " + p.getName() + " §7 --> §c"+ target.getName() + " : §4 " + str  );
						  }
					  }
					}
				}
			}else{
				p.performCommand("msg");
			}
		return false;
	}
		return false;
	}
}
