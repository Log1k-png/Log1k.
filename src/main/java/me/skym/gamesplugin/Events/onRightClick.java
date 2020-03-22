package me.skym.gamesplugin.Events;

import me.skym.gamesplugin.Fighter;
import me.skym.gamesplugin.Map;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;




import java.util.concurrent.ThreadLocalRandom;

import static me.skym.gamesplugin.GamesPlugin.game;
import static me.skym.gamesplugin.GamesPlugin.game;

public class onRightClick implements Listener {

    @EventHandler
    public void onRightClick(PlayerInteractEvent event)
    {
        if(game.isLive()) {
            if(event.getPlayer().isSneaking()){
                event.getPlayer().sendMessage("ULTI");
                game.getRole(event.getPlayer().getDisplayName()).ulti(event.getPlayer());
            }
        }
    }
}

