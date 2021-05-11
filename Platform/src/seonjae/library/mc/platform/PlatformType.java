package seonjae.library.mc.platform;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PlatformType {
    BUNGEE(0), BUKKIT(1), SPIGOT(2);

    private int id;
}
