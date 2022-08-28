package simple.mining.apis;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class ActionBar {
    private static final Map<Player, BukkitTask> PENDING_MESSAGES = new HashMap<Player, BukkitTask>();

    public static void sendActionBarMessage(Player bukkitPlayer, String message) {
        ActionBar.sendRawActionBarMessage(bukkitPlayer, "{\"text\": \"" + message + "\"}");
    }

    public static void sendRawActionBarMessage(Player bukkitPlayer, String rawMessage) {
        CraftPlayer player = (CraftPlayer)((Object)bukkitPlayer);
        IChatBaseComponent chatBaseComponent = IChatBaseComponent.ChatSerializer.a(rawMessage);
        PacketPlayOutChat packetPlayOutChat = new PacketPlayOutChat(chatBaseComponent, (byte) 2);
        player.getHandle().playerConnection.sendPacket(packetPlayOutChat);
    }

    public static void sendActionBarMessage(final Player bukkitPlayer, final String message, final int duration, Plugin plugin) {
        ActionBar.cancelPendingMessages(bukkitPlayer);
        BukkitTask messageTask = new BukkitRunnable(){
            private int count = 0;

            public void run() {
                if (this.count >= duration - 3) {
                    this.cancel();
                }
                ActionBar.sendActionBarMessage(bukkitPlayer, message);
                ++this.count;
            }
        }.runTaskTimer(plugin, 0L, 20L);
        PENDING_MESSAGES.put(bukkitPlayer, messageTask);
    }

    private static void cancelPendingMessages(Player bukkitPlayer) {
        if (PENDING_MESSAGES.containsKey(bukkitPlayer)) {
            PENDING_MESSAGES.get(bukkitPlayer).cancel();
        }
    }
}