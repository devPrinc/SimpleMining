package simple.mining.vip;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class BUYCommand implements CommandExecutor
{
    public BUYCommand() {
        super();
    }

    public boolean onCommand(final CommandSender sender, final Command cmd, final String arg2, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("buyvip") && sender instanceof Player) {
            final Player p = (Player)sender;
            sender.sendMessage("");
            sender.sendMessage("§a§lADQUIRA JÁ SEU VIP! §a:D!");
            sender.sendMessage("");
            sender.sendMessage("§eNossa loja: §floja.seuservidor.com");
            sender.sendMessage("");
            ((Player)sender).playSound(((Player)sender).getLocation(), Sound.ORB_PICKUP, 6.0f, 9.0f);
        }
        return false;
    }
}
