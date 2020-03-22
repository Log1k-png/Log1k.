package me.skym.gamesplugin;

import me.skym.gamesplugin.Role.Blade;
import me.skym.gamesplugin.Role.Role;
import org.bukkit.entity.Player;

public class Fighter {


    Player player;
    String name;
    Role role;
    int charges;

    public Fighter(Player player) {
        this.player = player;
        this.name = player.getDisplayName();
        this.role = new Blade();
        charges = 0;
    }

    public Player getPlayer() {
        return player;
    }

    public String getName() {
        return name;
    }

    public Role getRole() {
        return role;
    }

    public int getCharges() {
        return charges;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setCharges(int charges) {
        this.charges = charges;
    }
}
