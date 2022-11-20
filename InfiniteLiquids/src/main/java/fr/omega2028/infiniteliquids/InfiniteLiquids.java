package fr.omega2028.infiniteliquids;

import fr.omega2028.infiniteliquids.commands.LiquidGiveCommand;
import fr.omega2028.infiniteliquids.commands.LiquidGiveCommandCompleter;
import fr.omega2028.infiniteliquids.listeners.OnPlayerClickListener;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

public final class InfiniteLiquids extends JavaPlugin {

    private static InfiniteLiquids INSTANCE;
    private NamespacedKey InfWaterKey;
    private NamespacedKey InfLavaKey;
    @Override
    public void onEnable() {
        // Plugin startup logic
        INSTANCE = this;
        InfWaterKey = new NamespacedKey(INSTANCE, "inf-water");
        InfLavaKey = new NamespacedKey(INSTANCE, "inf-lava");
        getCommand("infliquid").setExecutor(new LiquidGiveCommand());
        getCommand("infliquid").setTabCompleter(new LiquidGiveCommandCompleter());
        getServer().getPluginManager().registerEvents(new OnPlayerClickListener(), INSTANCE);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static InfiniteLiquids getINSTANCE() {
        return INSTANCE;
    }

    public NamespacedKey getInfWaterKey() {
        return InfWaterKey;
    }

    public NamespacedKey getInfLavaKey() {
        return InfLavaKey;
    }
}
