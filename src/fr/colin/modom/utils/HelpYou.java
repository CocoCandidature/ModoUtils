package fr.colin.modom.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

/**
 * Created by coco33910 on 17/02/2016.
 * HelpYou
 */
public class HelpYou implements Listener {

    @EventHandler

    public void onClickMenu(InventoryClickEvent e) {
        if (e.getInventory().getName().equalsIgnoreCase("§eSélecteur de jeu")) {
            Player p = (Player) e.getWhoClicked();
            if (e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR)
                return;
            switch (e.getCurrentItem().getType()) {

                case WOOD:
                    p.sendMessage("Tu es au warp Bois");
                    Bukkit.dispatchCommand(p, "warp bois");
                    p.closeInventory();
                    break;

            }
        }
    }
}


