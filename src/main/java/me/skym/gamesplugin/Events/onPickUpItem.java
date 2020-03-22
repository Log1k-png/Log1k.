package me.skym.gamesplugin.Events;

import me.skym.gamesplugin.Fighter;
import me.skym.gamesplugin.Map;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;


import java.util.concurrent.ThreadLocalRandom;

import static me.skym.gamesplugin.GamesPlugin.game;
import static me.skym.gamesplugin.GamesPlugin.game;

public class onPickUpItem implements Listener {

    @EventHandler
    public void onPickUpItem(PlayerPickupItemEvent event)
    {
        if(game.isLive()) {
            event.setCancelled(true);
        }
    }
}
