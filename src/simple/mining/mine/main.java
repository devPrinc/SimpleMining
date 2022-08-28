package simple.mining.mine;

import simple.mining.apis.*;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.inventory.*;

public class main implements CommandExecutor {
    public main() {
        super();
    }

    public boolean onCommand(final CommandSender s, final Command cmd, final String lb, final String[] args) {
        if (s instanceof Player) {
            final Player p = (Player) s;
            if (cmd.getName().equalsIgnoreCase("mina")) {
                final Inventory inv = Bukkit.createInventory((InventoryHolder) null, 27, "Mina");
                inv.setItem(11, Create.add(Material.ARMOR_STAND, "§aInformações", new String[]{"§7", "§f §7Evolua seu rank, desbloqueie novas", "§f §7áreas de mineração, ganhe dinheiro", "§f §7keys & completa missões.", ""}));
                inv.setItem(12, Create.add(Material.REDSTONE_TORCH_ON, "§4Mina PvP", new String[]{"§7", "§f §7Esta mina possui o modo §lPVP §aativo", "§f §7junte-se com seu clan e domine a mina.", "", "§aClique aqui para entrar."}));
                inv.setItem(15, Create.add(Material.WOOD_PICKAXE, "§aÁreas de Mineração", new String[]{"§7", "§f §7Acesse um menu onde poderá", "§f §7escolher em qual área deseja minerar.", "", "§aClique aqui para abrir."}));
                p.openInventory(inv);
            }
        }
        return true;
    }
}
