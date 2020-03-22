package me.skym.gamesplugin.Role;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.potion.*;


public class Shield extends Role{

    public Shield() {
        super(Fclass.SHIELD, "I have an axe and that's enough to fuck you up (and an armor)" );

    }

    @Override
    public void give(Player player){
        PlayerInventory inventory = player.getInventory();
        inventory.clear();

        ItemStack hache = new ItemStack(Material.IRON_AXE, 1);
        ItemMeta meta = hache.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA + "Stormbreaker");
        meta.setUnbreakable(true);
        hache.setItemMeta(meta);

        for (PotionEffect effect : player.getActivePotionEffects()) {
            player.removePotionEffect(effect.getType());
        }
        inventory.setItemInOffHand(new ItemStack(Material.SHIELD));
        inventory.setBoots(new ItemStack(Material.CHAINMAIL_BOOTS));
        inventory.setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
        inventory.setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
        inventory.setHelmet(new ItemStack(Material.CHAINMAIL_HELMET));
        inventory.setItem(0, hache);
        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, Integer.MAX_VALUE, 0, true, false));
        player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 0, true, false));
        player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, Integer.MAX_VALUE, 1, true, false));
        player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 8, 20, true, false));

        //player.addPotionEffect(new PotionEffect(PotionEffectType.TYPE, duréee en secondes x20, Puissance));
    }

    @Override
    public void ulti(Player player){

    }

}
