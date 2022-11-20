package fr.omega2028.infiniteliquids.utils;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemUtils {
    public static ItemBuilder builder(){
        return new ItemBuilder();
    }
    public static class ItemBuilder {
        Material material;
        String name;
        List<String> lore;
        Map<Enchantment, Integer> enchantments = new HashMap<>();
        boolean glow;
        int customModelData;

        Map<NamespacedKey, String> keysAndValuesString = new HashMap<>();

        public ItemBuilder material(Material material){
            this.material = material;
            return this;
        }

        public ItemBuilder name(String name){
            this.name = name;
            return this;
        }

        public ItemBuilder lore(List<String> lore){
            this.lore = lore;
            return this;
        }

        public ItemBuilder addEnchantment(Enchantment enchantment, int level){
            enchantments.put(enchantment, Math.max(level, 0));
            return this;
        }

        public ItemBuilder glow(boolean glow){
            this.glow = glow;
            return this;
        }

        public ItemBuilder customModelData(int customModelData){
            this.customModelData = customModelData;
            return this;
        }

        public ItemBuilder addNameSpaceKeyString(NamespacedKey key, String assosiatedValue){
            keysAndValuesString.put(key, assosiatedValue);
            return this;
        }

        public ItemStack build(){
            ItemStack it;
            ItemMeta itM;

            if (material == null) material = Material.AIR;
            it = new ItemStack(material);
            itM = it.getItemMeta();
            if (name != null) itM.setDisplayName(name);
            if (lore != null) itM.setLore(lore);
            for (Enchantment enchantment : enchantments.keySet()){
                itM.addEnchant(enchantment, enchantments.get(enchantment), true);
            }
            if (glow) {
                itM.addEnchant(Enchantment.ARROW_FIRE, 1, false);
                itM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            }
            if (customModelData != 0) itM.setCustomModelData(customModelData);
            PersistentDataContainer itContainer = itM.getPersistentDataContainer();
            for (NamespacedKey key: keysAndValuesString.keySet()){
                itContainer.set(key, PersistentDataType.STRING, keysAndValuesString.get(key));
            }
            it.setItemMeta(itM);
            return it;
        }
    }

    public static ItemStack makeItem(Material material, String name) {
        ItemStack it = new ItemStack(material);
        ItemMeta itM = it.getItemMeta();
        itM.setDisplayName(name);
        it.setItemMeta(itM);
        return it;
    }
}
