package simple.mining.inicializer;

import simple.mining.mine.*;
import simple.mining.mines.*;
import simple.mining.click.*;
import simple.mining.blocks.*;
import simple.mining.vip.*;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.java.*;
import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.event.*;
import org.bukkit.plugin.*;

public class Core extends JavaPlugin
{
    public static Core plugin;
    protected ConsoleCommandSender system;
    public static Core instance;
    public static Economy economy;

    public Core() {
        super();
    }

    public static Core getInstance() {
        return Core.instance;
    }

    public void onEnable() {
        (Core.plugin = this).saveDefaultConfig();
        this.system = Bukkit.getConsoleSender();
        this.system.sendMessage("§aPlugin §f" + plugin.getName() + " §aenable.");
        Core.instance = this;
        Bukkit.getPluginManager().registerEvents((Listener)new aCoal(), (Plugin)this);
        Bukkit.getPluginManager().registerEvents((Listener)new bIron(), (Plugin)this);
        Bukkit.getPluginManager().registerEvents((Listener)new cGold(), (Plugin)this);
        Bukkit.getPluginManager().registerEvents((Listener)new dDiamond(), (Plugin)this);
        Bukkit.getPluginManager().registerEvents((Listener)new eEmerald(), (Plugin)this);
        Bukkit.getPluginManager().registerEvents((Listener)new fObsidian(), (Plugin)this);
        Bukkit.getPluginManager().registerEvents((Listener)new gIce(), (Plugin)this);
        this.getCommand("mina").setExecutor((CommandExecutor)new main());
        this.getCommand("minas").setExecutor((CommandExecutor)new selector());
        this.getCommand("vip").setExecutor((CommandExecutor)new VIPCommand());
        this.getCommand("buyvip").setExecutor((CommandExecutor)new BUYCommand());
        Bukkit.getPluginManager().registerEvents((Listener)new ClickEvent(), (Plugin)this);
        final RegisteredServiceProvider<Economy> economyProvider = (RegisteredServiceProvider<Economy>)this.getServer().getServicesManager().getRegistration((Class)Economy.class);
        if (economyProvider != null) {
            Core.economy = (Economy)economyProvider.getProvider();
        }
    }

    static {
        Core.economy = null;
    }

    public void onDisable() {
        this.system.sendMessage("§aPlugin §f" + plugin.getName() + "  §adisable.");
    }
}
