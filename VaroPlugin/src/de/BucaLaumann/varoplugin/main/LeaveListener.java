package de.BucaLaumann.varoplugin.main;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveListener implements Listener{

	
	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent event) {
		
		event.setQuitMessage("§e" + event.getPlayer().getName() + " §3 hat den Server verlassen");
		
	}
	
}
