package fr.omega2028.infiniteliquids.listeners;

import fr.omega2028.infiniteliquids.InfiniteLiquids;
import fr.omega2028.infiniteliquids.utils.ItemUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.util.List;

public class OnPlayerClickListener implements Listener {
    @EventHandler
    public void onPlayerClick(PlayerInteractEvent event){
        Player player = event.getPlayer();
        ItemStack bucket = player.getInventory().getItemInMainHand();
        if (bucket.getItemMeta().getPersistentDataContainer().has(InfiniteLiquids.getINSTANCE().getInfWaterKey(), PersistentDataType.STRING)){
            player.getInventory().setItemInMainHand(
                    ItemUtils.builder().material(Material.WATER_BUCKET)
                            .lore(List.of(ChatColor.GRAY + "Une source infinie d'" + ChatColor.BLUE + "eau"))
                            .name(ChatColor.BLUE + "" + ChatColor.BOLD + "Eau Infinie")
                            .glow(true)
                            .addNameSpaceKeyString(InfiniteLiquids.getINSTANCE().getInfWaterKey(), "")
                            .build());
        }
        else if (bucket.getItemMeta().getPersistentDataContainer().has(InfiniteLiquids.getINSTANCE().getInfLavaKey(), PersistentDataType.STRING)){
            player.getInventory().setItemInMainHand(
                    ItemUtils.builder().material(Material.LAVA_BUCKET)
                            .lore(List.of(ChatColor.GRAY + "Une source infinie de " + ChatColor.RED + "lave"))
                            .name(ChatColor.RED + "" + ChatColor.BOLD + "Lave Infinie")
                            .glow(true)
                            .addNameSpaceKeyString(InfiniteLiquids.getINSTANCE().getInfLavaKey(), "")
                            .build());
        }
    }
}
