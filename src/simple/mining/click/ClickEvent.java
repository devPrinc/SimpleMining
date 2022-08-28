package simple.mining.click;

import org.bukkit.event.inventory.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.event.*;

public class ClickEvent implements Listener {
    public ClickEvent() {
        super();
    }

    @EventHandler
    public void onClick(final InventoryClickEvent event) {
        final Player p = (Player) event.getWhoClicked();
        if (event.getInventory().getTitle().equals("Minas")) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }
            if (event.getCurrentItem().getType() == Material.AIR) {
                return;
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName() == null) {
                return;
            }
            if (event.getSlot() == 11) {
                if (!p.hasPermission("mining.mine.carvao")) {
                    p.sendMessage("§c");
                    p.sendMessage("§cOps, isto é um §lERRO!");
                    p.sendMessage("§cEntre em contacto com um §7§lSTAFF§c.");
                    p.sendMessage("§c");
                    return;
                }
                p.closeInventory();
                p.chat("/warp minacarvao");
            }
            if (event.getSlot() == 12) {
                if (!p.hasPermission("mining.mine.ferro")) {
                    p.sendMessage("§c");
                    p.sendMessage("§cVocê precisa estar no rank §eFerro");
                    p.sendMessage("§cou superior para acessar esta Mina.");
                    p.sendMessage("§c");
                    return;
                }
                p.closeInventory();
                p.chat("/warp minaferro");
            }
            if (event.getSlot() == 13) {
                if (!p.hasPermission("mining.mine.ouro")) {
                    p.sendMessage("§c");
                    p.sendMessage("§cVocê precisa estar no rank §eOuro");
                    p.sendMessage("§cou superior para acessar esta Mina.");
                    p.sendMessage("§c");
                    return;
                }
                p.closeInventory();
                p.chat("/warp minaouro");
            }
            if (event.getSlot() == 14) {
                if (!p.hasPermission("mining.mine.diamante")) {
                    p.sendMessage("§c");
                    p.sendMessage("§cVocê precisa estar no rank §eDiamante");
                    p.sendMessage("§cou superior para acessar esta Mina.");
                    p.sendMessage("§c");
                    return;
                }
                p.closeInventory();
                p.chat("/warp minadiamante");
            }
            if (event.getSlot() == 15) {
                if (!p.hasPermission("mining.mine.esmeralda")) {
                    p.sendMessage("§c");
                    p.sendMessage("§cVocê precisa estar no rank §eEsmeralda");
                    p.sendMessage("§cou superior para acessar esta Mina.");
                    p.sendMessage("§c");
                    return;
                }
                p.closeInventory();
                p.chat("/warp minaesmeralda");
            }
            if (event.getSlot() == 20) {
                if (!p.hasPermission("mining.mine.obsidian")) {
                    p.sendMessage("§c");
                    p.sendMessage("§cVocê precisa estar no rank §eObsidian");
                    p.sendMessage("§cou superior para acessar esta Mina.");
                    p.sendMessage("§c");
                    return;
                }
                p.closeInventory();
                p.chat("/warp minaobsdian");
                return;
            }
            if (event.getSlot() == 40) {
                p.closeInventory();
                p.chat("/vip");
            }
            if (event.getSlot() == 21) {
                p.sendMessage("§c");
                p.sendMessage("§cEsta área de mineração ainda não foi");
                p.sendMessage("§cliberada aos jogadores, aguarde.");
                p.sendMessage("§c");
            }
        }
        if (event.getInventory().getTitle().equals("Mina")) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) {
                return;
            }
            if (event.getCurrentItem().getType() == Material.AIR) {
                return;
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName() == null) {
                return;
            }
            if (event.getSlot() == 11) {
                p.chat("");
            }
            if (event.getSlot() == 12) {
                p.chat("/warp minapvp");
            }
            if (event.getSlot() == 15) {
                p.chat("/minas");
            };
        }
    }
}