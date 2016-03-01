package fr.colin.modoM.commands;

		import org.bukkit.command.Command;
		import org.bukkit.command.CommandExecutor;
		import org.bukkit.command.CommandSender;
		import org.bukkit.entity.Player;

		import fr.colin.modoM.ModoMessage;
		import fr.colin.modoM.utils.Utils;

public class SocialSpy implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;

		if(cmd.getName().equalsIgnoreCase("socialspy")){
			if(p.hasPermission("modo.sp")){
				if(ModoMessage.sp.contains(p)){
					ModoMessage.sp.remove(p);
					p.sendMessage(Utils.getMessageSp2());
				}else{
					ModoMessage.sp.add(p);
					p.sendMessage(Utils.getMessageSp1());
				}
			}
			return false;
		}
		return false;
	}
}
