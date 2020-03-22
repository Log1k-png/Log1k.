package me.skym.gamesplugin.Role;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public abstract class Role {

    public Role(Fclass name, String description) {
        this.name = name;
        this.description = description;
    }

    public Role(Fclass name) {
        this.name = name;
    }

    public String getName() {
        return name.toString();
    }

    public String getDescription() {
        return description;
    }

    public enum Fclass {
        SHIELD,
        BOLT,
        BLADE,
    }

    private Fclass name;
    private String description;

    public void give(Player player){}
    public void ulti(Player player){}

}

