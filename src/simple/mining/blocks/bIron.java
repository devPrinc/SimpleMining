package simple.mining.blocks;

import simple.mining.apis.ActionBar;
import simple.mining.inicializer.*;

import org.bukkit.event.block.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.block.*;
import org.bukkit.event.*;

public class bIron implements Listener {
    public bIron() {
        super();
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void blocks(final BlockBreakEvent event) {
        if (!event.isCancelled()) {
            final Player player = event.getPlayer();
            final Block bloco = event.getBlock();
            if (player.getWorld().getName().equalsIgnoreCase("Minas") && bloco.getType() == Material.IRON_ORE) {
                bloco.setType(Material.AIR);
                    Core.economy.depositPlayer((OfflinePlayer) player, 25D); /* sem multiplicador */
                    ActionBar.sendActionBarMessage(player, "§e§lMINERAÇÃO §7§l▏ §fForam adicionados §a+$25 §fem sua conta. §c[Sem Bônus]");
                }
                if (player.hasPermission("bonus.vip")) {
                    Core.economy.depositPlayer((OfflinePlayer) player, 28D); /* com multiplicador */
                    ActionBar.sendActionBarMessage(player, "§e§lMINERAÇÃO §7§l▏ §fForam adicionados §a+$28 §fem sua conta. §7[Bônus de 1.1x]");
                }
                if (player.hasPermission("bonus.vip+")) {
                    Core.economy.depositPlayer((OfflinePlayer) player, 30D); /* com multiplicador */
                    ActionBar.sendActionBarMessage(player, "§e§lMINERAÇÃO §7§l▏ §fForam adicionados §a+$30 §fem sua conta. §7[Bônus de 1.5x]");
                }
                if (player.hasPermission("bonus.mvp")) {
                    Core.economy.depositPlayer((OfflinePlayer) player, 35D); /* com multiplicador */
                    ActionBar.sendActionBarMessage(player, "§e§lMINERAÇÃO §7§l▏ §fForam adicionados §a+$35 §fem sua conta. §7[Bônus de 1.9x]");
                }
                if (player.hasPermission("bonus.mvp+")) {
                    Core.economy.depositPlayer((OfflinePlayer) player, 38D); /* com multiplicador */
                    ActionBar.sendActionBarMessage(player, "§e§lMINERAÇÃO §7§l▏ §fForam adicionados §a+$38 §fem sua conta. §7[Bônus de 2.0x]");
                }
            }
        }
    }
