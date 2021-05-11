package seonjae.library.mc.message;

import lombok.Getter;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import seonjae.library.mc.config.Config;
import seonjae.library.mc.message.platform.PlatformAdapter;
import seonjae.library.mc.message.platform.bukkit.BukkitAdapter;
import seonjae.library.mc.message.platform.bungee.BungeeAdapter;
import seonjae.library.mc.message.platform.spigot.SpigotAdapter;
import seonjae.library.mc.platform.Platform;
import seonjae.library.mc.platform.PlatformType;

@UtilityClass
public class MessageAssist {

    private PlatformAdapter platformAdapter = null;

    @Getter
    private boolean setup = false;

    private void setup() {
        if (Platform.getType().equals(PlatformType.BUNGEE)) platformAdapter = new BungeeAdapter();
        else if (Platform.getType().equals(PlatformType.BUKKIT)) platformAdapter = new BukkitAdapter();
        else if (Platform.getType().equals(PlatformType.SPIGOT)) platformAdapter = new SpigotAdapter();
    }

    public PlatformAdapter getPlatformAdapter() {
        if (platformAdapter == null) setup();
        return platformAdapter;
    }

    public void console(Object message) {
        getPlatformAdapter().console(message);
    }
    public void user(Object sender, Object message) {
        getPlatformAdapter().user(sender, message);
    }
    public void broadcast(Object message) {
        getPlatformAdapter().broadcast(message);
    }

    public String replaceColor(Object message) {
        return getPlatformAdapter().replaceColor(message);
    }

    @SneakyThrows(Exception.class)
    public void loadConfig(SimpleMessage simpleMessage, Object plugin) {
        Config config = new Config(getPlatformAdapter().getDataFoloder(plugin), "message-config.yml").load();

        MessageMap messageMap = new MessageMap(simpleMessage);

        messageMap.forEach((key, value) -> config.addDefault(key, value));

        config.save();

        config.getKeys().forEach(key -> messageMap.put(key, config.getString(key)));
    }
}
