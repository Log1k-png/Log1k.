package me.skym.gamesplugin.Commands;

import me.skym.gamesplugin.Fighter;
import me.skym.gamesplugin.Map;
import me.skym.gamesplugin.Role.Role;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.skym.gamesplugin.GamesPlugin.*;

public class roles implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player)
        {
            Player p = (Player) sender;

            //role list
            if (args[0].equalsIgnoreCase("list")  ) {
                for (Role role : roleList) {
                    p.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + role.getName() + ChatColor.WHITE + " \"" + ChatColor.ITALIC + role.getDescription() + "\"");
                }
            }

            //role choose
            if (args[0].equalsIgnoreCase("choose")) {
                boolean existing = false;
                if (game.isPlaying(p.getDisplayName())){
                    for (Role role : roleList) {
                        if (args[1].equalsIgnoreCase(role.getName())) {
                            existing = true;
                            p.sendMessage(ChatColor.RESET +"You are now a " + ChatColor.GOLD + "" + ChatColor.BOLD + role.getName());
                            game.chooseRole(p.getName(), role);
                        }
                    }
                    if (!existing){
                        p.sendMessage(ChatColor.RESET + "Unknown role, try again");
                    }
                }

                else {
                    p.sendMessage("You have to joined the game before choosing your role");
                }

            }

        }
        return false;
    }


}