package seonjae.plugin.example.bukkit;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import seonjae.library.mc.message.MessageAssist;
import seonjae.plugin.example.ExampleMessage;
import seonjae.plugin.example.ExampleSimpleConfig;

public class ExampleKPlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {

        // Example Message
        ExampleMessage.JOIN_USER1.loadConfig(this);
        Bukkit.getPluginManager().registerEvents(new ExampleMessageListener(), this);

        ExampleSimpleConfig config = new ExampleSimpleConfig(getDataFolder(), "config.yml");
        config.load();
        config.save();

        for (String key : config.getKeys()) {
            MessageAssist.console(key + " : " + config.get(key));
        }
        MessageAssist.console("======================");
        MessageAssist.console("asdf : " + config.getAsdf());
        MessageAssist.console("qwer : " + config.getQwer());
        MessageAssist.console("zxcv : " + config.getZxcv());
    }
}

