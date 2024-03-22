package man.burr.a_super_amazing_plugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class loginEffectsPlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getLogger().info("loginEffectsPlugin has been enabled.");
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        getLogger().info("loginEffectsPlugin has been disabled.");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        sendRainbowMessage(player, "————————————————————\n Welcome to the dreamscape of reality! \n————————————————————");
    }

    public void sendRainbowMessage(Player player, String message) {
        int length = message.length();
        ChatColor[] colors = {
                ChatColor.RED, ChatColor.GOLD, ChatColor.YELLOW, ChatColor.GREEN,
                ChatColor.BLUE, ChatColor.DARK_BLUE, ChatColor.DARK_PURPLE
        };

        for (int i = 0; i < length; i++) {
            char c = message.charAt(i);
            if (c == '\n') { // Hvis det er en linjeskift, send meldingen som en ny melding
                player.sendMessage("");
            } else if (c == ' ') {
                player.sendMessage(ChatColor.RESET + " ");
            } else {
                player.sendMessage(colors[i % colors.length] + String.valueOf(c));
            }
            try {
                Thread.sleep(100); // Juster denne verdien etter ønsket hastighet
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
