package me.skym.gamesplugin.Events;

import me.skym.gamesplugin.Fighter;
import me.skym.gamesplugin.Map;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.entity.*;
import org.bukkit.event.entity.EntityDeathEvent;


import java.util.concurrent.ThreadLocalRandom;

public class onEntityDeath implements Listener {

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event)
    {
        event.getEntity().getKiller().setExp(event.getEntity().getKiller().getExp()+1f/3f);
    }
}
