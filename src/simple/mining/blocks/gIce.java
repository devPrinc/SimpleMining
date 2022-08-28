package simple.mining.blocks;

import simple.mining.apis.ActionBar;
import simple.mining.inicializer.*;

import org.bukkit.event.block.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.block.*;
import org.bukkit.event.*;

public class gIce implements Listener {
    public gIce() {
        super();
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void blocks(final BlockBreakEvent event) {
        if (!event.isCancelled()) {
            final Player player = event.getPlayer();
            final Block bloco = event.getBlock();
            if (player.getWorld().getName().equalsIgnoreCase("Minas") && bloco.getType() == Material.PACKED_ICE) {
                bloco.setType(Material.AIR);
                    Core.economy.depositPlayer((OfflinePlayer) player, 85D); /* sem multiplicador */
                    ActionBar.sendActionBarMessage(player, "§e§lMINERAÇÃO §7§l▏ §fForam adicionados §a+$85 §fem sua conta. §c[Sem Bônus]");
                }
                if (player.hasPermission("bonus.vip")) {
                    Core.economy.depositPlayer((OfflinePlayer) player, 88D); /* com multiplicador */
                    ActionBar.sendActionBarMessage(player, "§e§lMINERAÇÃO §7§l▏ §fForam adicionados §a+$88 §fem sua conta. §7[Bônus de 1.1x]");
                }
                if (player.hasPermission("bonus.vip+")) {
                    Core.economy.depositPlayer((OfflinePlayer) player, 90D); /* com multiplicador */
                    ActionBar.sendActionBarMessage(player, "§e§lMINERAÇÃO §7§l▏ §fForam adicionados §a+$90 §fem sua conta. §7[Bônus de 1.5x]");
                }
                if (player.hasPermission("bonus.mvp")) {
                    Core.economy.depositPlayer((OfflinePlayer) player, 95D); /* com multiplicador */
                    ActionBar.sendActionBarMessage(player, "§e§lMINERAÇÃO §7§l▏ §fForam adicionados §a+$95 §fem sua conta. §7[Bônus de 1.9x]");
                }
                if (player.hasPermission("bonus.mvp+")) {
                    Core.economy.depositPlayer((OfflinePlayer) player, 98D); /* com multiplicador */
                    ActionBar.sendActionBarMessage(player, "§e§lMINERAÇÃO §7§l▏ §fForam adicionados §a+$98 §fem sua conta. §7[Bônus de 2.0x]");
                }
            }
        }
    }