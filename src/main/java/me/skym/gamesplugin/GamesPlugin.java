package me.skym.gamesplugin;

import me.skym.gamesplugin.Commands.games;
import me.skym.gamesplugin.Commands.maps;
import me.skym.gamesplugin.Commands.roles;

import me.skym.gamesplugin.Events.onDeath;
import me.skym.gamesplugin.Events.onIceWall;
import me.skym.gamesplugin.Events.onPotionEffect;
import me.skym.gamesplugin.Events.onFoodLevelChange;
import me.skym.gamesplugin.Events.onDroppedItem;
import me.skym.gamesplugin.Events.onRightClick;
import me.skym.gamesplugin.Events.onPickUpItem;
import me.skym.gamesplugin.Events.onShootBow;
import me.skym.gamesplugin.Events.onEntityDeath;
import me.skym.gamesplugin.Events.onExpChange;

import me.skym.gamesplugin.Role.Blade;
import me.skym.gamesplugin.Role.Bolt;
import me.skym.gamesplugin.Role.Role;
import me.skym.gamesplugin.Role.Shield;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class GamesPlugin extends JavaPlugin implements Listener {
    public static ArrayList<Map> maplist = new ArrayList<>();
    public static Game game = new Game();
    public static ArrayList<Role> roleList= new ArrayList<>();

    //me donne pas d'ordre PD

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new onDeath(), this);
        getServer().getPluginManager().registerEvents(new onIceWall(),this);
        getServer().getPluginManager().registerEvents(new onPotionEffect(),this);
        getServer().getPluginManager().registerEvents(new onFoodLevelChange(), this);
        getServer().getPluginManager().registerEvents(new onDroppedItem(), this);
        getServer().getPluginManager().registerEvents(new onRightClick(), this);
        getServer().getPluginManager().registerEvents(new onPickUpItem(), this);
        getServer().getPluginManager().registerEvents(new onShootBow(), this);
        getServer().getPluginManager().registerEvents(new onEntityDeath(), this);
        getServer().getPluginManager().registerEvents(new onExpChange(), this);
        getCommand("game").setExecutor(new games());
        getCommand("map").setExecutor(new maps());
        getCommand("role").setExecutor(new roles());
        roleList.add(new Shield());
        roleList.add(new Bolt());
        roleList.add(new Blade());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
