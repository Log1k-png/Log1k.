package me.skym.gamesplugin.Commands;

import me.skym.gamesplugin.Fighter;
import me.skym.gamesplugin.Map;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.concurrent.ThreadLocalRandom;

import static me.skym.gamesplugin.GamesPlugin.game;
import static me.skym.gamesplugin.GamesPlugin.maplist;

public class games implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;

            // /game start
            if(args[0].equalsIgnoreCase("start")) {
                if(game.isLive()){
                    p.sendMessage("The game has already started");
                }
                else if(game.getMap()==null) {
                    p.sendMessage("The game need a map to be playable");
                }
                else if(game.getMap().numberOfSpawn() == 0) {
                    p.sendMessage("The map need to have at least one spawn to be playable");
                }
                else if(game.getFighters().size() < 1) {
                    p.sendMessage("There is not enough people to start the game");
                }
                else {
                    Map map = game.getMap();
                    // the game start
                    game.setStatus(true);
                    p.sendMessage(ChatColor.WHITE + "A game is starting !");
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "gamerule keepInventory true");

                    // Setting randomly player's spawnpoint
                    for (Fighter fighter : game.getFighters()) {
                        int rand = ThreadLocalRandom.current().nextInt(0, map.numberOfSpawn());
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "spawnpoint " + fighter.getName() + " " + map.getSpawnAt(rand).getBlockX() + " " + map.getSpawnAt(rand).getBlockY() + " " + map.getSpawnAt(rand).getBlockZ());
                    }

                    // Tp randomly player at spawns
                    for (Fighter fighter : game.getFighters()) {
                        int rand = ThreadLocalRandom.current().nextInt(0, game.getMap().numberOfSpawn());
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tp " + fighter.getName() + " " + map.getSpawnAt(rand).getBlockX() + " " + map.getSpawnAt(rand).getBlockY() + " " + map.getSpawnAt(rand).getBlockZ());
                    }

                    // Give stuff
                    for (Fighter fighter : game.getFighters()) {
                        fighter.getRole().give(fighter.getPlayer());
                        fighter.getPlayer().sendMessage("Giving stuff...");
                        fighter.getPlayer().setExhaustion(0);
                    }

                    //set survival mod
                    for (Fighter fighter : game.getFighters()) {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "gamemode survival " + fighter.getName());

                    }
                }

            }

            // /game setmap <mapName>
            if(args[0].equalsIgnoreCase("setmap")) {
                for(Map map : maplist) {
                    if (map.getName().equalsIgnoreCase(args[1]) & !game.isLive()) {
                        game.setMap(map);
                        p.sendMessage("The game is set on the map " + ChatColor.BLUE + args[1]);
                    }
                }
            }

            // /game stop
            if(args[0].equalsIgnoreCase("stop")) {
                if (game.isLive()){
                            // the game stop
                            game.setStatus(false);
                            p.sendMessage(ChatColor.WHITE + "A game is stopping...");
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "gamerule keepInventory false");
                }
            }

            // /game join
            if(args[0].equalsIgnoreCase("join")) {
                if(game.isPlaying(p.getDisplayName())){
                    p.sendMessage("You are already in the game");
                }
                else {
                    game.addPlayer(new Fighter(p));
                    p.sendMessage(ChatColor.WHITE + "You joined the game.");
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        if (!player.equals(p))
                            player.sendMessage(ChatColor.GREEN + p.getDisplayName() + ChatColor.RESET + " joined the game");
                    }
                }
            }

            // /game leave
            if(args[0].equalsIgnoreCase("leave")) {
                if(!game.isPlaying(p.getDisplayName())){
                    p.sendMessage("You are not in the game");
                }
                else {
                    game.removePlayer(p.getDisplayName());
                    p.sendMessage(ChatColor.WHITE + "You left the game.");
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        if (!player.equals(p))
                            player.sendMessage(ChatColor.GREEN + p.getDisplayName() + ChatColor.RESET + " left the game");
                    }
                }
            }


            // /game playerlist
            if(args[0].equalsIgnoreCase("playerlist")) {
                if (game.getFighters().isEmpty()){
                    p.sendMessage("There is no player in this game.");
                }

                else {
                    p.sendMessage("Player in the game : ");
                    for(Fighter fighter : game.getFighters()){
                        p.sendMessage(ChatColor.DARK_GREEN + fighter.getName() + ChatColor.RESET +" : "+ ChatColor.GOLD + "" + ChatColor.BOLD + game.getRole(fighter.getName()).getName());
                    }
                }
            }

        }
        return false;
    }
}

