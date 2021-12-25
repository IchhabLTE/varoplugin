package de.BucaLaumann.varoplugin.main;

import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.potion.PotionType;

public class InventoryOpenListener implements Listener{

	public void onInventoryOpen(InventoryOpenEvent event) {
		
		Inventory inv = event.getInventory();
		
		PotionType[] potions = {PotionType.STRENGTH, PotionType.FIRE_RESISTANCE, PotionType.INSTANT_DAMAGE,
				PotionType.POISON, PotionType.REGEN, PotionType.SLOWNESS, PotionType.SPEED, PotionType.WEAKNESS};
		
	
			
			
		
	}
	
	
}
