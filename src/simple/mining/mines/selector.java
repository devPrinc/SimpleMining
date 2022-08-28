package simple.mining.mines;

import simple.mining.apis.*;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.inventory.*;

public class selector implements CommandExecutor
{
    public selector() {
        super();
    }

    public boolean onCommand(final CommandSender s, final Command cmd, final String lb, final String[] args) {
        if (s instanceof Player) {
            final Player p = (Player)s;
            if (cmd.getName().equalsIgnoreCase("minas")) {
                final Inventory inv = Bukkit.createInventory((InventoryHolder) null, 45, "Minas");
                inv.setItem(11, Create.add(Material.COAL_ORE, "§aMina Carvão", new String[]{"§f §7Esta mina está disponível para", "§f §eCarvãoV/IV/III/II/I", "", "§aClique para ir minerar."}));
                if (p.hasPermission("mining.mine.ferro")) {
                    inv.setItem(12, Create.add(Material.IRON_ORE, "§aMina Ferro", new String[]{"§f §7Esta mina está disponível para", "§f §eFerroV/IV/III/II/I", "", "§aClique para ir minerar."}));
                } else {
                    inv.setItem(12, Create.add(Material.WEB, "§cMina Bloqueada", new String[]{"§7", "§f §cMina bloqueada, evolua seu Rank", "§f §cpara desbloquear esta área.", "§7"}));
                }
                if (p.hasPermission("mining.mine.ouro")) {
                    inv.setItem(13, Create.add(Material.GOLD_ORE, "§aMina Ouro", new String[]{"§f §7Esta mina está disponível para", "§f §eOuroV/IV/III/II/I", "", "§aClique para ir minerar."}));
                } else {
                    inv.setItem(13, Create.add(Material.WEB, "§cMina Bloqueada", new String[]{"§7", "§f §cMina bloqueada, evolua seu Rank", "§f §cpara desbloquear esta área.", "§7"}));
                }
                if (p.hasPermission("mining.mine.diamante")) {
                    inv.setItem(14, Create.add(Material.DIAMOND_ORE, "§aMina Diamante", new String[]{"§f §7Esta mina está disponível para", "§f §eDiamanteV/IV/III/II/I", "", "§aClique para ir minerar."}));
                } else {
                    inv.setItem(14, Create.add(Material.WEB, "§cMina Bloqueada", new String[]{"§7", "§f §cMina bloqueada, evolua seu Rank", "§f §cpara desbloquear esta área.", "§7"}));
                }
                if (p.hasPermission("mining.mine.esmeralda")) {
                    inv.setItem(15, Create.add(Material.EMERALD_ORE, "§aMina Esmeralda", new String[]{"§f §7Esta mina está disponível para", "§f §eEsmeraldaV/IV/III/II/I", "", "§aClique para ir minerar."}));
                } else {
                    inv.setItem(15, Create.add(Material.WEB, "§cMina Bloqueada", new String[]{"§7", "§f §cMina bloqueada, evolua seu Rank", "§f §cpara desbloquear esta área.", "§7"}));
                }
                if (p.hasPermission("mining.mine.obsidian")) {
                    inv.setItem(20, Create.add(Material.OBSIDIAN, "§aMina Obsidian", new String[]{"§f §7Esta mina está disponível para", "§f §eObsidianV/IV/III/II/I", "", "§aClique para ir minerar."}));
                } else {
                    inv.setItem(20, Create.add(Material.WEB, "§cMina Bloqueada", new String[]{"§7", "§f §cMina bloqueada, evolua seu Rank", "§f §cpara desbloquear esta área.", "§7"}));
                }
                inv.setItem(21, Create.add(Material.WEB, "§cMina desconhecida.", new String[]{"§7", "§f §cEsta mina será liberada", "§f §cem breve.", "§7"}));
                if (p.hasPermission("mining.vip")) {
                    inv.setItem(40, Create.add(Material.PACKED_ICE, "§6Mina VIP", new String[] { "§f §aVocê possui um §6§lVIP §apor tanto", "§f §atêm acesso a esta área de mineração.", "", "§aClique para ir minerar." }));
                }
                else {
                    inv.setItem(40, Create.add(Material.PACKED_ICE, "§6Mina VIP", new String[] { "§7", "§f §cMina bloqueada, você não", "§f §cpossui nenhum pacote §lVIP", "§7", "§f §cAdquira um acessando:", "§f §6loja.seuservidor.com", "§7" }));
                }
                p.openInventory(inv);
            }
        }
        return true;
    }
}