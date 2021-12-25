package de.BucaLaumann.varoplugin.main;


import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener{
		
HashMap<String, Boolean> hashMap;
HashMap<String, Boolean> hashMap1;
	
	public BlockBreakListener(HashMap<String, Boolean> gamePhases, HashMap<String, Boolean> joinTimeOver) { 
		
		this.hashMap = gamePhases;
		this.hashMap1 = joinTimeOver;
	}
	
	@EventHandler
	
	public void onPlace(BlockBreakEvent event) {
		
		
		if(hashMap.get("gameStarted") == true)	 {
			
			event.setCancelled(false);
			Bukkit.broadcastMessage("§aBlockBreakEvent not cancelled!");
			
			
		} else if(hashMap.get("gameStarted") == false) {
				
			if(hashMap.get("firstEpOver") == true) {
			
			if (hashMap1.get(event.getPlayer().getName().toString()) == false) {
				
				event.setCancelled(true);
				Bukkit.broadcastMessage("§cBlockBreakEvent cancelled!");
				
			} else if (hashMap1.get(event.getPlayer().getName().toString()) == true) {
				
				event.setCancelled(false);
				Bukkit.broadcastMessage("§aBlockBreakEvent not cancelled!");
				
			}
		}	
			
			/* 		if (hashMap1.containsKey(event.getPlayer().getName().toString())) {
			
			if (hashMap1.get(event.getPlayer().getName().toString()) == false) {
				
				event.setCancelled(true);
				Bukkit.broadcastMessage("§cBlockBreakEvent cancelled!");
				
			} else if (hashMap1.get(event.getPlayer().getName().toString()) == true) {
				
				event.setCancelled(false);
				Bukkit.broadcastMessage("§aBlockBreakEvent not cancelled!");
				
			}*/
			
			
			
		}
		
		
		
	}
	
	
		
}

