package fr.colin.modom.utils;

import fr.colin.modom.ModoMessage;

import org.bukkit.Bukkit;
import org.bukkit.scoreboard.Team;

public class Utils {

	private static String PrefixAnnonce = ModoMessage.getInstance().getConfig().getString("Prefix.Annonce").replace("&", "§");
	private static  String PrefixModo = ModoMessage.getInstance().getConfig().getString("Prefix.Modo").replace("&", "§");
	private static String KickMessageKicker = ModoMessage.getInstance().getConfig().getString("Messages.Kicker").replace("&", "§");
	private static String KickMessageKicking = ModoMessage.getInstance().getConfig().getString("Messages.Kicking").replace("&", "§");
	private static String MessageModo = ModoMessage.getInstance().getConfig().getString("Messages.Modo").replace("&", "§");
	private static String MessageAnnonce = ModoMessage.getInstance().getConfig().getString("Messages.Annonce").replace("&", "§");
	private static String MessageMuteAll = ModoMessage.getInstance().getConfig().getString("Messages.Muteall").replace("&", "§");
	private static String MessageDeMuteAll = ModoMessage.getInstance().getConfig().getString("Messages.Demuteall").replace("&", "§");
	private static String MessageAsk = ModoMessage.getInstance().getConfig().getString("Messages.Ask").replace("&", "§");
	private static String MessageHelpAsk = ModoMessage.getInstance().getConfig().getString("Messages.Ask_Help").replace("&", "§");
	private static String MessageMsgSender = ModoMessage.getInstance().getConfig().getString("Messages.Msgsender").replace("&", "§");
	private static String MessageMsgRecever = ModoMessage.getInstance().getConfig().getString("Messages.Msgrecever").replace("&", "§");
	private static String MessageNoPerm = ModoMessage.getInstance().getConfig().getString("Messages.Error_No_Perm").replace("&", "§");
	private static String MessageNotArgs = ModoMessage.getInstance().getConfig().getString("Messages.Error_Not_Args").replace("&", "§");
	private static String MessageSp1 = ModoMessage.getInstance().getConfig().getString("Messages.Sp_1").replace("&", "§");
	private static String MessageSp2 = ModoMessage.getInstance().getConfig().getString("Messages.Sp_2").replace("&", "§");
	private static String MessageMsgHelp1 = ModoMessage.getInstance().getConfig().getString("Messages.Msg_Help1").replace("&", "§");
	private static String MessageMsgHelp2 = ModoMessage.getInstance().getConfig().getString("Messages.Msg_Help2").replace("&", "§");
	private static String TargetDisconnecte = ModoMessage.getInstance().getConfig().getString("Messages.Target_Disconnected").replace("&", "§");
	private static String Reply_Help = ModoMessage.getInstance().getConfig().getString("Messages.Reply_Help").replace("&", "§");
	private static String Ask_Hover_Message = ModoMessage.getInstance().getConfig().getString("Messages.Ask_Hover_Message").replace("&", "§");
	private static String Msg_Hover_Message = ModoMessage.getInstance().getConfig().getString("Messages.Msg_Hover_Message").replace("&", "§");


	private static Team helper = Bukkit.getScoreboardManager().getMainScoreboard().getTeam("helper")
			, modo = Bukkit.getScoreboardManager().getMainScoreboard().getTeam("modo")
			, dev =  Bukkit.getScoreboardManager().getMainScoreboard().getTeam("dev")
			, admin = Bukkit.getScoreboardManager().getMainScoreboard().getTeam("admin")
			, joueur = Bukkit.getScoreboardManager().getMainScoreboard().getTeam("joueur")
			;

	public static void setTeam(){

		if(admin == null){
			helper = Bukkit.getScoreboardManager().getMainScoreboard().registerNewTeam("helper");
			modo = Bukkit.getScoreboardManager().getMainScoreboard().registerNewTeam("modo");
			dev = Bukkit.getScoreboardManager().getMainScoreboard().registerNewTeam("dev");
			admin = Bukkit.getScoreboardManager().getMainScoreboard().registerNewTeam("admin");
			joueur = Bukkit.getScoreboardManager().getMainScoreboard().registerNewTeam("joueur");

			helper.setPrefix("§4§2Helper > ");
			modo.setPrefix("§3§6Modo > ");
			dev.setPrefix("§2§fRetraité > ");
			admin.setPrefix("§1§4Admin > ");
			joueur.setPrefix("§7");
		}else{

			helper.setPrefix("§4§2Helper > ");
			modo.setPrefix("§3§6Modo > ");
			dev.setPrefix("§2§fRetraité > ");
			admin.setPrefix("§1§4Admin > ");
			joueur.setPrefix("§7");
		}
	}
	
	public static String getPrefixAnnonce() {
		String str = PrefixAnnonce;
		if(str == null){
			str = "§4§l[§6§lAnnonce§4§l] §2§o ";
		}else{
			str = PrefixAnnonce;
		}
		return str;
	}

	public static String getPrefixModo() {
		String str = PrefixModo;
		if(str == null){
			str = "§4§l[§6§lModération§4§l] §2§o ";
		}else{
			str = PrefixModo;
		}
		return str;
	}

	public static String getKickMessageKicker() {
		String str = KickMessageKicker;
		if(str == null){
			str = "§6 Vous avez été kick pour la raison de %raison%";
		}else{
			str = KickMessageKicker;
		}
		return str;
	}

	public static String getKickMessageKicking() {
		String str = KickMessageKicking;
		 
		if(str == null){
			str = "§a %kicking% a été kick  §6pour %raison%";
		}else{
			str = KickMessageKicking;
		}		
		return str;
	}

	public static String getMessageModo() {
		String str =  MessageModo;
		if(str == null){
			str = "%player% : §b%message%";
			
		}else{
			str = MessageModo;
		}
		return str;
	}

	public static String getMessageAnnonce() {
		String str =  MessageAnnonce;
		if(str == null){
			str = "%player% : §b%message%";
			
		}else{
			str = MessageAnnonce;
		}
		return str;
		
	}

	public static String getMessageMuteAll() {
		String str =  MessageMuteAll;
		if(str == null){
			str = "§4Tous le monde a été muté";
			
		}else{
			str = MessageMuteAll;
		}
		return str;
	}

	public static String getMessageDeMuteAll() {
		String str =  MessageDeMuteAll;
		if(str == null){
			str = "§4Tous le monde a été démuté";
			
		}else{
			str = MessageDeMuteAll;
		}
		return str;
	}

	public static String getMessageAsk() {
		String str =  MessageAsk;
		if(str == null){
			str = "§a%player% §ba posé une question : §a %question%";
			
		}else{
			str = MessageAsk;
		}
		return str;
	}

	public static String getMessageHelpAsk() {
		String str =  MessageHelpAsk;
		if(str == null){
			str = "§cFait /help <message> pour obtenir de l'aide";
			
		}else{
			str = MessageHelpAsk;
		}
		return str;
	}

	public static String getMessageMsgSender() {
		String str =  MessageMsgSender;
		if(str == null){
			str = "§3%sender% > %target% : %message% ";
			
		}else{
			str = MessageMsgSender;
		}
		return str;
	}

	public static String getMessageMsgRecever() {
		String str =  MessageMsgRecever;
		if(str == null){
			str = "§3%sender% > %target% : %message% ";
			
		}else{
			str = MessageMsgRecever;
		}
		return str;
	}

	public static String getMessageNoPerm() {
		String str =  MessageNoPerm;
		if(str == null){
			str = "§4Tu n'as pas la permission d'executer cette commande";
			
		}else{
			str = MessageNoPerm;
		}
		return str;
	}

	public static String getMessageNotArgs() {
		String str =  MessageNotArgs;
		if(str == null){
			str = "§4Pour executer cette commande il faut un ou plusieur argument ";
			
		}else{
			str = MessageNotArgs;
		}
		return str;
	}

	public static String getMessageSp1() {
		String str = MessageSp1;
		if(str == null){
			str = "§3 Vous êtes maintenant en socialspy";
			
		}else{
			str = MessageSp1;
		}
		return str;
	}

	public static String getMessageSp2() {
		String str =  MessageSp2;
		if(str == null){
			str = "§3 Vous n'êtes plus en socialspy";
			
		}else{
			str = MessageSp2;
		}
		return str;
	}

	public static String getMessageMsgHelp1() {
		String str =  MessageMsgHelp1;
		if(str == null){
			str = "§c faite /msg <player> <message> pour envoyer un message privé";
			
		}else{
			str = MessageMsgHelp1;
		}
		return str;
	}

	public static String getMessageMsgHelp2() {
		String str =  MessageMsgHelp2;
		if(str == null){
			str = "§c les messages sont clickable afin de pé§remplir la commande";
			
		}else{
			str = MessageMsgHelp2;
		}
		return str;
	}

	public static String getTargetDisconnecte() {
		String str =  TargetDisconnecte;
		if(str == null){
			str = "§c Ce joueur est déconnecté";
			
		}else{
			str = TargetDisconnecte;
		}
		return str;
	} 

	public static String getReply_Help() {
		String str =  Reply_Help;
		if(str == null){
			str = "§c/r <Message> <-- répondre § quelqu'un";
			
		}else{
			str = Reply_Help;
		}
		return str;
	}

	public static String getAsk_Hover_Message() {
		String str =  Ask_Hover_Message;
		if(str == null){
			str = "§7§o Cliquez pour r§pondre";
			
		}else{
			str = Ask_Hover_Message;
		}
		return str;
	}

	public static String getMsg_Hover_Message() {
		String str =  Msg_Hover_Message;
		if(str == null){
			str = "§7§o Cliquez pour r§pondre § %player%";
			
		}else{
			str = Msg_Hover_Message;
		}
		return str;	
	}
	



	public static Team getHelper() {
		return helper;
	}

	public static Team getModo() {
		return modo;
	}

	public static Team getDev() {
		return dev;
	}

	public static Team getAdmin() {
		return admin;
	}

	public static Team getJoueur() {
		return joueur;
	}
}
