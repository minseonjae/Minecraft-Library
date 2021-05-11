package seonjae.plugin.example.bukkit;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import seonjae.plugin.example.ExampleMessage;

public class ExampleMessageListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        ExampleMessage.JOIN_CONSOLE1.console(e.getPlayer().getName());
        ExampleMessage.JOIN_CONSOLE2.console();
        ExampleMessage.JOIN_BROADCAST1.broadcast(e.getPlayer().getName());
        ExampleMessage.JOIN_BROADCAST2.broadcast();
        ExampleMessage.JOIN_USER1.user(e.getPlayer(), e.getPlayer().getName());
        ExampleMessage.JOIN_USER2.user(e.getPlayer());
    }
}
