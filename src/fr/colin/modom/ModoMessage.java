package fr.colin.modom;


import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;

import fr.colin.modom.commands.Annonce;
import fr.colin.modom.commands.Help;
import fr.colin.modom.commands.Kick;
import fr.colin.modom.commands.M;
import fr.colin.modom.commands.Modo;
import fr.colin.modom.commands.MsgCommand;
import fr.colin.modom.commands.Reply;
import fr.colin.modom.commands.SocialSpy;
import fr.colin.modom.commands.Sp;
import fr.colin.modom.commands.TestCommand;
import fr.colin.modom.utils.Fonctions;
import fr.colin.modom.utils.Utils;


public class ModoMessage extends JavaPlugin implements Listener {
	private static ModoMessage instance;

	public HashMap<Player, Player> getReply() {
		return reply;
	}

	public ArrayList<Player> getSp() {
		return sp;
	}


	private HashMap<Player, Player> reply = new HashMap<>();
	private ArrayList<Player> sp = new ArrayList<>();


	@Override
	public void onEnable() {
		RegisterEvents.re(this);

		instance = this;
		instance.getConfig().options().copyDefaults(true);
		saveConfig();
		Fonctions.setConfigNormal();


		getCommand("msg").setExecutor(new MsgCommand());
		getCommand("modo").setExecutor(new Modo());
		getCommand("annonce").setExecutor(new Annonce());
		getCommand("kick").setExecutor(new Kick());
		getCommand("help").setExecutor(new Help());
		getCommand("sp").setExecutor(new Sp());
		getCommand("r").setExecutor(new Reply());
		getCommand("m").setExecutor(new M());
		getCommand("socialspy").setExecutor(new SocialSpy());
		getCommand("test").setExecutor(new TestCommand());


		Utils.setTeam();

	}

	public static ModoMessage getInstance() {
		return instance;
	}


	public static void openMenu(Player p) {
		if (p.getItemInHand() == null)return;

		Inventory inv = Bukkit.createInventory(null, 9, "§4Menu");
		Inventory i3 = null;

		
		if (p.getItemInHand().getType() == Material.INK_SACK) {

			int i2 = Bukkit.getOnlinePlayers().size();
			
			for (Player pls2 : Bukkit.getOnlinePlayers()) {
				ItemStack sk = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
				SkullMeta skm = (SkullMeta) sk.getItemMeta();
				skm.setOwner(pls2.getName());
				skm.setDisplayName("§r" + pls2.getName());
				sk.setItemMeta(skm);
				int i = inv.firstEmpty();
				if(!(i >= 6)) {
					inv.addItem(sk);
					p.openInventory(inv);
					return;
				}else{
					i3 = Bukkit.createInventory(null,9, "§4Menu 2>");
					i3.addItem(sk);
					p.openInventory(i3);
					Scoreboard board = p.getScoreboard();
					board.registerNewTeam("tateam");
				}
			}
		}
	}
}







