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
        // velkomstmelding når noen logger inn på serveren
        event.getPlayer().sendMessage("welcome to the dreamscape of reality");
    }

    public void checkTimeBasedEvents() {
        // Sjekk tid og utfør hendelser basert på tid
        long timeInMillis = Bukkit.getWorld("world").getTime(); // Tid i millisekunder
        int hour = (int) (timeInMillis / 1000) / 3600; // Deler på 1000 for å konvertere til sekunder, deretter på 3600 for å konvertere til timer
        if (hour == 12) { // Hendelse som skjer kl. 12
            // Utfør handling for kl. 12
            Bukkit.broadcastMessage("the golden hour is upon uss");
        } else if (hour == 20) { //Hendelse som skjer kl. 20
            // Utfør handling for kl. 20
            Bukkit.broadcastMessage("the hall of meny has has oppend is door");
        } else if (hour == 14) {
            Bukkit.broadcastMessage("if time was not linjer");
        }
    }
}

//Could not load plugins/original-a_super_amazing_plugin-1.0.0-1.20.>
//org.bukkit.plugin.InvalidPluginException: Unsupported API version 1.20.4