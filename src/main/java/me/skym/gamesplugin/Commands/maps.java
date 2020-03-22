package me.skym.gamesplugin.Commands;
import me.skym.gamesplugin.Map;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import static me.skym.gamesplugin.GamesPlugin.maplist;

public class maps implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;

            //map create *mapname*
            if (args[0].equalsIgnoreCase("create")) {
                String mapname = args[1];
                if (mapname != null) {
                    maplist.add(new Map(mapname));
                    p.sendMessage(ChatColor.BLUE + mapname + ChatColor.WHITE + " has been added to the map list.");
                }
            }

            //map delete *mapname*
            if (args[0].equalsIgnoreCase("delete")) {
                String mapname = args[1];
                boolean mapfound = false;
                for(Map map : maplist){
                    if(map.getName().equalsIgnoreCase(mapname)){
                        mapfound = true;
                    }
                }

                maplist.removeIf(mapremoved -> mapremoved.getName().equalsIgnoreCase(mapname));

                if (!mapfound){
                    p.sendMessage(ChatColor.BLUE + mapname + ChatColor.WHITE + " is not a map in the list.");
                }
                else {
                    p.sendMessage(ChatColor.BLUE + mapname + ChatColor.WHITE + " has been removed from the map list.");
                }
            }

            //map addspawn *mapname*
            else if (args[0].equalsIgnoreCase("addspawn")) {
                String mapname = args[1];
                boolean mapfound = false;
                for(Map map : maplist){
                    if(map.getName().equalsIgnoreCase(mapname)){
                        mapfound = true;
                        map.addSpawn(p.getLocation());
                        p.sendMessage(ChatColor.WHITE + "spawn added to the map " + ChatColor.BLUE + mapname + ChatColor.WHITE + ". total : " + map.numberOfSpawn());
                    }
                }
                if (!mapfound){
                    p.sendMessage(ChatColor.BLUE + mapname + ChatColor.WHITE + " is not a map in the list.");
                }
            }

            //map list
            else if (args[0].equalsIgnoreCase("list")) {
                int numberOfSpawn = 0;

                if (maplist.isEmpty()){
                    p.sendMessage("the map list is empty.");
                }
                else {
                    p.sendMessage("Map list : ");
                    for(Map map : maplist){
                        numberOfSpawn = map.numberOfSpawn();
                        p.sendMessage(ChatColor.BLUE + map.getName() + ChatColor.WHITE + " (" + numberOfSpawn + " spawn)");
                    }
                }
            }

        }
        return false;
    }
}
