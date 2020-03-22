package me.skym.gamesplugin.Role;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.potion.*;

public class Bolt extends Role{

    public Bolt() {
        super(Fclass.BOLT, "Pew Pew Pew" );

    }

    @Override
    public void give(Player player){
        PlayerInventory inventory = player.getInventory();
        inventory.clear();

        ItemStack crossbow = new ItemStack(Material.CROSSBOW, 1);
        ItemMeta meta = crossbow.getItemMeta();
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Pew Pew");
        meta.addEnchant(Enchantment.QUICK_CHARGE, 3, true);
        meta.setUnbreakable(true);
        crossbow.setItemMeta(meta);

        for (PotionEffect effect : player.getActivePotionEffects()) {
            player.removePotionEffect(effect.getType());
        }
        //inventory.setItem(7, new ItemStack(Material.ARROW, 64));
        inventory.setBoots(new ItemStack(Material.LEATHER_BOOTS));
        inventory.setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
        inventory.setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
        inventory.setHelmet(new ItemStack(Material.LEATHER_HELMET));
        inventory.setItem(0, crossbow);
        inventory.setItemInOffHand(new ItemStack(Material.ARROW, 1));


        //player.addPotionEffect(new PotionEffect(PotionEffectType.TYPE, duréee en secondes x20, Puissance));
    }

    @Override
    public void ulti(Player player){

    }
}
