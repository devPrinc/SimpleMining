package simple.mining.blocks;

import simple.mining.apis.ActionBar;
import simple.mining.inicializer.*;

import org.bukkit.event.block.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.block.*;
import org.bukkit.event.*;

public class cGold implements Listener {
    public cGold() {
        super();
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void blocks(final BlockBreakEvent event) {
        if (!event.isCancelled()) {
            final Player player = event.getPlayer();
            final Block bloco = event.getBlock();
            if (player.getWorld().getName().equalsIgnoreCase("Minas") && bloco.getType() == Material.GOLD_ORE) {
                bloco.setType(Material.AIR);
                    Core.economy.depositPlayer((OfflinePlayer) player, 35D); /* sem multiplicador */
                    ActionBar.sendActionBarMessage(player, "§e§lMINERAÇÃO §7§l▏ §fForam adicionados §a+$35 §fem sua conta. §c[Sem Bônus]");
                }
                if (player.hasPermission("bonus.vip")) {
                    Core.economy.depositPlayer((OfflinePlayer) player, 38D); /* com multiplicador */
                    ActionBar.sendActionBarMessage(player, "§e§lMINERAÇÃO §7§l▏ §fForam adicionados §a+$38 §fem sua conta. §7[Bônus de 1.1x]");
                }
                if (player.hasPermission("bonus.vip+")) {
                    Core.economy.depositPlayer((OfflinePlayer) player, 40D); /* com multiplicador */
                    ActionBar.sendActionBarMessage(player, "§e§lMINERAÇÃO §7§l▏ §fForam adicionados §a+$40 §fem sua conta. §7[Bônus de 1.5x]");
                }
                if (player.hasPermission("bonus.mvp")) {
                    Core.economy.depositPlayer((OfflinePlayer) player, 55D); /* com multiplicador */
                    ActionBar.sendActionBarMessage(player, "§e§lMINERAÇÃO §7§l▏ §fForam adicionados §a+$55 §fem sua conta. §7[Bônus de 1.9x]");
                }
                if (player.hasPermission("bonus.mvp+")) {
                    Core.economy.depositPlayer((OfflinePlayer) player, 58D); /* com multiplicador */
                    ActionBar.sendActionBarMessage(player, "§e§lMINERAÇÃO §7§l▏ §fForam adicionados §a+$58 §fem sua conta. §7[Bônus de 2.0x]");
                }
            }
        }
    }
