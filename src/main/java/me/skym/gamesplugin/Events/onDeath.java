package me.skym.gamesplugin.Events;

import me.skym.gamesplugin.Fighter;
import me.skym.gamesplugin.Map;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.concurrent.ThreadLocalRandom;

import static me.skym.gamesplugin.GamesPlugin.game;

public class onDeath implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent e){
        if(game.isLive()){
            Map map = game.getMap();
            for (Fighter fighter : game.getFighters()) {
                int rand = ThreadLocalRandom.current().nextInt(0, map.numberOfSpawn());
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "spawnpoint " + fighter.getName() + " " + map.getSpawnAt(rand).getBlockX() + " " + map.getSpawnAt(rand).getBlockY() + " " + map.getSpawnAt(rand).getBlockZ());
            }
        }
    }
}
