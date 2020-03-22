package me.skym.gamesplugin.Role;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.potion.*;

public class Blade extends Role{

    public Blade() {
        super(Fclass.BLADE, "I have a sword and I run pretty fast" );

    }

    @Override
    public void give(Player player){
        PlayerInventory inventory = player.getInventory();
        inventory.clear();

        ItemStack dague = new ItemStack(Material.GOLDEN_SWORD, 1);
        ItemMeta meta = dague.getItemMeta();
        meta.setDisplayName(ChatColor.YELLOW + "Gold Dagger");
        meta.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
        meta.setUnbreakable(true);
        dague.setItemMeta(meta);

        for (PotionEffect effect : player.getActivePotionEffects()) {
            player.removePotionEffect(effect.getType());
        }
        inventory.setBoots(new ItemStack(Material.GOLDEN_BOOTS));
        inventory.setLeggings(new ItemStack(Material.GOLDEN_LEGGINGS));
        inventory.setChestplate(new ItemStack(Material.GOLDEN_CHESTPLATE));
        inventory.setHelmet(new ItemStack(Material.GOLDEN_HELMET));
        inventory.setItem(0, dague);
        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 0, true, false));


        //player.addPotionEffect(new PotionEffect(PotionEffectType.TYPE, duréee en secondes x20, Puissance));
    }

    @Override
    public void ulti(Player player){

    }
}
