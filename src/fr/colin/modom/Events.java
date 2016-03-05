package fr.colin.modom;

import fr.colin.modom.utils.Utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;


public class Events implements Listener {


    @EventHandler(priority = EventPriority.HIGHEST)
    public void onJoined(PlayerJoinEvent e) {

        Player p = e.getPlayer();
        e.setJoinMessage("§a" + p.getName() + " s'est connecté");

        Utils.getJoueur().addPlayer(p);

        if (p.hasPermission("modo.tab.helper")) {
            Utils.getHelper().addPlayer(p);
        }
        if (p.hasPermission("modo.tab.modo")) {
            Utils.getModo().addPlayer(p);

        }
    }

    @EventHandler
    public void onQuited(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        e.setQuitMessage("§c" + p.getName() + " s'est déconnecté");

    }

    @EventHandler
    public void command(PlayerCommandPreprocessEvent e) {
        switch (e.getMessage()) {
            case "/pl":
                if (e.getPlayer().hasPermission("modo.cmd.bypass")) {
                    e.setCancelled(false);
                } else {
                    e.setCancelled(true);
                }
            case "/plugins":
                if (e.getPlayer().hasPermission("modo.cmd.bypass")) {
                    e.setCancelled(false);
                } else {
                    e.setCancelled(true);
                }
            case "/?":
                if (e.getPlayer().hasPermission("modo.cmd.bypass")) {
                    e.setCancelled(false);
                } else {
                    e.setCancelled(true);
                }
            case "/ver":
                if (e.getPlayer().hasPermission("modo.cmd.bypass")) {
                    e.setCancelled(false);
                } else {
                    e.setMessage("/pl");

                    e.setCancelled(true);
                }

        }
    }

    Inventory i;
    Inventory i2;

    public void test() {

        ArrayList<Inventory> all = new ArrayList<Inventory>(); // Ici on  crée une Arraylist Qui va contenir des Inventaire
        all.add(i); // On ajoute ton inventaire n°1
        all.add(i2); //On ajoute ton inventaire n°2
        for (Inventory invs : all) { // Ici on dit : pour tout les  inventaire de la Liste All
            invs.setItem(1, new ItemStack(Material.AIR));
        }
    }

    @EventHandler
    public void on(PlayerDeathEvent e){
        Player p = e.getEntity();

        p.setHealth(20);
    }


    public HashMap<Material, Player> tnts = new HashMap<>();
    @EventHandler
    public void pose(PlayerInteractEvent e){
        if(!(e.getAction() == Action.RIGHT_CLICK_BLOCK))
            return;
        if(!(e.getPlayer().getItemInHand().equals(Material.TNT)))
            return;

        tnts.put(e.getPlayer().getItemInHand().getType(), e.getPlayer());

    }

    @EventHandler
    public void ex(EntityExplodeEvent e){
        if(!(e.getEntityType() == EntityType.PRIMED_TNT))
            return;


    }



}
