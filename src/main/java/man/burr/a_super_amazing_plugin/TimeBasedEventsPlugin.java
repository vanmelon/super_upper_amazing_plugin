package man.burr.a_super_amazing_plugin;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
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
        event.getPlayer().sendMessage("Welcome to the dreamscape of reality!");

        // Spill en lyd når noen logger seg inn
        event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);

        // Vis partikler når noen logger seg inn
        Location location = event.getPlayer().getLocation();
        location.getWorld().spawnParticle(Particle.EXPLOSION_LARGE, location, 1);
    }

    public void checkTimeBasedEvents() {
        // Sjekk tid og utfør hendelser basert på tid
        long timeInTicks = Bukkit.getWorld("world").getTime(); // Tid i ticks
        int hour = (int) (timeInTicks / 1000) / 72; // Deler på 1000 for å konvertere til sekunder, deretter på 72 for å konvertere til timer (1 time = 72 000 ticks i Minecraft)
        if (hour == 12) { // Hendelse som skjer kl. 12
            // Utfør handling for kl. 12
            Bukkit.broadcastMessage("The golden hour is upon us!");
        } else if (hour == 20) { //Hendelse som skjer kl. 20
            // Utfør handling for kl. 20
            Bukkit.broadcastMessage("The hall of many has opened its doors!");
        } else if (hour == 14) {
            Bukkit.broadcastMessage("Time has been altered!");
        }
    }
}
