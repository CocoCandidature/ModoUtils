package fr.colin.modoM.utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import fr.colin.modoM.ModoMessage;

public class Fonctions {


    public static void setConfigNormal() {
        if (ModoMessage.getInstance().getConfig().contains("Prefix")) return;

        ModoMessage.getInstance().getConfig().set("Prefix.Modo", "&4&l[&6&lModération&4&l] &2&o ");
        ModoMessage.getInstance().getConfig().set("Prefix.Annonce", "&4&l[&6&lAnnonce&4&l] &2&o ");
        ModoMessage.getInstance().getConfig().set("Messages.Annonce", "%player% : &b%message%");
        ModoMessage.getInstance().getConfig().set("Messages.Modo", "%player% : &b%message%");
        ModoMessage.getInstance().getConfig().set("Messages.Kicker", "&6 Vous avez été kick pour la raison de %raison%");
        ModoMessage.getInstance().getConfig().set("Messages.Kicking", "&a %kicking% &6a été kick  &6pour %raison%");
        ModoMessage.getInstance().getConfig().set("Messages.Ask", "&a%player% &ba posé une question : &a %question%");
        ModoMessage.getInstance().getConfig().set("Messages.Muteall", "&4Tous le monde a été muté");
        ModoMessage.getInstance().getConfig().set("Messages.Demuteall", "&4Tous le monde a été démuté");
        ModoMessage.getInstance().getConfig().set("Messages.Msgsender", "&3%sender% > %target% : &f%message% ");
        ModoMessage.getInstance().getConfig().set("Messages.Msgrecever", "&3%sender% > %target% : &f%message% ");
        ModoMessage.getInstance().getConfig().set("Messages.Error_No_Perm", "&4Tu n'as pas la permission d'executer cette commande");
        ModoMessage.getInstance().getConfig().set("Messages.Error_Not_Args", " &4Pour executer cette commande il faut un ou plusieur argument ");
        ModoMessage.getInstance().getConfig().set("Messages.Ask_Help", "&cFait /help <message> pour obtenir de l'aide");
        ModoMessage.getInstance().getConfig().set("Messages.Sp_1", " &3 Vous êtes maintenant en socialspy");
        ModoMessage.getInstance().getConfig().set("Messages.Sp_2", " &3 Vous n'êtes plus en socialspy ");
        ModoMessage.getInstance().getConfig().set("Messages.Msg_Help1", " &c faite /msg <player> <message> pour envoyer un message prive");
        ModoMessage.getInstance().getConfig().set("Messages.Msg_Help2", " &c les messages sont clickable afin de préremplir la commande");
        ModoMessage.getInstance().getConfig().set("Messages.Target_Disconnected", "&c Ce joueur est déconnecté");
        ModoMessage.getInstance().getConfig().set("Messages.Reply_Help", " &c/r <Message> <-- répondre à quelqu'un");
        ModoMessage.getInstance().getConfig().set("Messages.Ask_Hover_Message", " &7&o Cliquez pour répondre");
        ModoMessage.getInstance().getConfig().set("Messages.Msg_Hover_Message", " &7&o Cliquez pour répondre à %player%");


        ModoMessage.getInstance().saveConfig();


    }

    public static void createConfig(String fileName) throws IOException {
        File f = new File(ModoMessage.getInstance().getDataFolder() + fileName + ".yml");

        if (!f.exists()) {
            f.mkdir();
            f.createNewFile();


        } else {
        }


    }


    public static FileConfiguration getConfigByName(String fileName) throws IOException {
        File f = new File("/plugins/ModerationPlugin/" + fileName + ".yml");

        if (!f.exists()) {
            f.mkdir();
            f.createNewFile();
        }

        FileConfiguration fc = YamlConfiguration.loadConfiguration(f);

        return fc;
    }


}
