package man.burr.a_super_amazing_plugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class SuperUpperAmazingPlugin extends JavaPlugin {
    private static final Logger logger = Logger.getLogger("Minecraft");

    @Override
    public void onEnable() {
        getLogger().info("My first plugin has started!!! Hello!!!");
    }

    @Override
    public void onDisable() {
        getLogger().info("My first plugin has stopped!!! Bye!!!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("hello")) {
            sender.sendMessage("Hello, world!");
            return true;
        }
        return false;
    }
}
