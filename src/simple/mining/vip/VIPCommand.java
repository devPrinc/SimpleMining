package simple.mining.vip;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import simple.mining.particles.*;
import net.md_5.bungee.api.chat.*;

public class VIPCommand implements CommandExecutor
{
    public VIPCommand() {
        super();
    }

    public boolean onCommand(final CommandSender sender, final Command cmd, final String arg2, final String[] args) {
        if (!cmd.getName().equalsIgnoreCase("vip") || !(sender instanceof Player)) {
            return false;
        }
        final Player p = (Player)sender;
        if (!p.hasPermission("mining.vip")) {
            p.sendMessage("");
            p.sendMessage("§cOPS!");
            p.sendMessage("§cVocê precisa ser §lVIP §cpara acessar esta área. :(");
            p.sendMessage("");
            json(p, "§cClique ", "§c§lAQUI§r", " §cpara adquirir um §lVIP", "§cClique aqui", "/buyvip");
            p.sendMessage("");
            return true;
        }
        p.sendMessage("");
        p.sendMessage("§eSeja bem-vindo à área exclusiva VIP!");
        p.sendMessage("§eObrigado por adquirir VIP no servidor :D");
        p.sendMessage("");
        ParticleEffect.VILLAGER_HAPPY.display(1.0f, 1.0f, 1.0f, 20.0f, 70, p.getLocation(), 16.0);
        p.chat("/warp vip");
        return false;
    }

    public static void json(final Player p, final String text, final String Json, final String text2, final String hover, final String command) {
        final TextComponent msg = new TextComponent(text);
        final TextComponent sjon = new TextComponent(Json);
        final TextComponent msg2 = new TextComponent(text2);
        sjon.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(hover).create()));
        sjon.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, command));
        msg.addExtra((BaseComponent)sjon);
        msg.addExtra((BaseComponent)msg2);
        p.spigot().sendMessage((BaseComponent)msg);
    }
}
