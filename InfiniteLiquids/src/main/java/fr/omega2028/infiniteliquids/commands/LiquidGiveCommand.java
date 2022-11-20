package fr.omega2028.infiniteliquids.commands;

import fr.omega2028.infiniteliquids.InfiniteLiquids;
import fr.omega2028.infiniteliquids.utils.ItemUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class LiquidGiveCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command,
                             @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) return false;
        if (args.length < 2) return false;
        if (args[1].equals("water")){
            player.getInventory().addItem(
                    ItemUtils.builder().material(Material.WATER_BUCKET)
                            .lore(List.of(ChatColor.GRAY + "Une source infinie d'" + ChatColor.BLUE + "eau"))
                            .name(ChatColor.BLUE + "" + ChatColor.BOLD + "Eau Infinie")
                            .glow(true)
                            .addNameSpaceKeyString(InfiniteLiquids.getINSTANCE().getInfWaterKey(), "")
                            .build());
        }
        else if (args[1].equals("lava")){
            player.getInventory().addItem(
                    ItemUtils.builder().material(Material.LAVA_BUCKET)
                            .lore(List.of(ChatColor.GRAY + "Une source infinie de " + ChatColor.RED + "lave"))
                            .name(ChatColor.RED + "" + ChatColor.BOLD + "Lave Infinie")
                            .glow(true)
                            .addNameSpaceKeyString(InfiniteLiquids.getINSTANCE().getInfLavaKey(), "")
                            .build());
        }

        return true;
    }
}
