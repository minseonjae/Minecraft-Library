package seonjae.library.mc.platform;

import lombok.Getter;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Platform {

    private PlatformType type;

    @Getter
    private boolean setup = false;

    private boolean isClass(String path) {
        try {
            Class.forName(path);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void setup() {
        if (!setup) {
            try {
                if (isClass("net.md_5.bungee.BungeeCord")) type = PlatformType.BUNGEE;
                else if (isClass("org.bukkit.Bukkit")) type = isClass("org.bukkit.Server.Spigot") ? PlatformType.SPIGOT : PlatformType.BUKKIT;
                if (type != null) setup = true;
                else throw new Exception("Could not setup!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public PlatformType getType() {
        if (type == null) setup();
        return type;
    }
}
