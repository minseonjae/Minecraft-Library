package seonjae.plugin.example;

import seonjae.library.mc.config.Config;
import seonjae.library.mc.config.SimpleConfig;

import java.io.File;

public class ExampleConfig {

    private Config config = new Config(null);

    public void load() {
        config.addDefault("a", "a");
        config.addDefault("b", 1);
        config.addDefault("c", true);
        config.addDefault("d", 1.0);

        config.save();

        String a = config.getString("a");
        int b = config.getInt("b");
        boolean c = config.getBoolean("c");
        double d = config.getDouble("d");
    }
    public void save() {
        config.set("a", "b");
        config.set("b", 2);
        config.set("c", false);
        config.set("d", 2.0);

        config.save();
    }
}
