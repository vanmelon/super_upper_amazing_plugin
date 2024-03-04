package man.burr.a_super_amazing_plugin;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class TimeBasedEventsPlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getLogger().info("TimeBasedEventsPlugin has been enabled.");
        getServer().getPluginManager().registerEvents(this, this);

        // Start en oppgave for å sjekke tid hver minutt
        Bukkit.getScheduler().runTaskTimer(this, this::checkTimeBasedEvents, 0, 20 * 60); // 20 ticks * 60 seconds
    }

    @Override
    public void onDisable() {
        getLogger().info("TimeBasedEventsPlugin has been disabled.");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        // Her kan du implementere en velkomstmelding eller lignende
        // For eksempel:
        event.getPlayer().sendMessage("welcome to the dreamscape of reality");
    }

    public void checkTimeBasedEvents() {
        // Sjekk tid og utfør hendelser basert på tid
        // Her kan du legge til logikk for timebaserte hendelser
        long timeInMillis = Bukkit.getWorld("world").getTime(); // Tid i millisekunder
        int hour = (int) (timeInMillis / 1000) / 3600; // Deler på 1000 for å konvertere til sekunder, deretter på 3600 for å konvertere til timer
        if (hour == 12) { // Eksempel: Hendelse som skjer kl. 12
            // Utfør handling for kl. 12
            Bukkit.broadcastMessage("the golden hour is upon uss");
        } else if (hour == 20) { // Eksempel: Hendelse som skjer kl. 20
            // Utfør handling for kl. 18
            Bukkit.broadcastMessage("the hall of meny has has oppend is door");
        }
    }
}