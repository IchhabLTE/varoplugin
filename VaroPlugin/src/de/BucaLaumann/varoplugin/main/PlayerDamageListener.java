package de.BucaLaumann.varoplugin.main;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PlayerDamageListener implements Listener{
	
	HashMap<String, String> hashMap;

	public PlayerDamageListener(HashMap<String, String> hashMap) { 
		
		this.hashMap = hashMap;
	//	System.out.println(hashMap.get("_Squary_"));
	}
	
	public void onDamage(EntityDamageByEntityEvent event) {
		
		Player player = (Player) event.getEntity();
		Bukkit.broadcastMessage("Player name: " + player);
		
		Player attacker = (Player) event.getDamager();
		Bukkit.broadcastMessage("Attacekr name: " + attacker);
		
		Bukkit.broadcastMessage("§aListener funktioniert");
		

		
	}
}
