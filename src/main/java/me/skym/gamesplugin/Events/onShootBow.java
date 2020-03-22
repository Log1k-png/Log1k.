package me.skym.gamesplugin.Events;

import me.skym.gamesplugin.Fighter;
import me.skym.gamesplugin.Map;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.Material;

import static me.skym.gamesplugin.GamesPlugin.game;

public class onShootBow implements Listener {

    @EventHandler
    public void onShootBow(EntityShootBowEvent event)
    {
        if(game.isLive() & event.getEntityType().equals(EntityType.PLAYER)) {

            event.getEntity().getEquipment().setItemInOffHand(new ItemStack(Material.ARROW, 1));
            //COmmit
        }
    }

}
