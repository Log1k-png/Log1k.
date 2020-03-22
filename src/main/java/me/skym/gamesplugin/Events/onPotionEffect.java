package me.skym.gamesplugin.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityPotionEffectEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import static me.skym.gamesplugin.Events.onIceWall.removeWall;
import static me.skym.gamesplugin.Events.onIceWall.removeWall;

public class onPotionEffect implements Listener {
    @EventHandler
    public void onPotionEffect(EntityPotionEffectEvent e){
        if(e.getEntity() instanceof Player){
            Player p = (Player) e.getEntity();
            PotionEffect tired = new PotionEffect(PotionEffectType.SLOW,100,0,true,false);
            if(!p.getActivePotionEffects().contains(tired)){
                removeWall();
            }
        }
    }
}
