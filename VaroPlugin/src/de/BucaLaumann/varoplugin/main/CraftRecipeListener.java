package de.BucaLaumann.varoplugin.main;

import java.util.Iterator;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;

public class CraftRecipeListener implements Listener {


	
	public static void remove() {
		
	/*	remove(PotionType.STRENGTH);
		remove(PotionType.INVISIBILITY);
		remove(PotionType.POISON);
		remove(PotionType.INSTANT_DAMAGE); */
		remove(Material.EYE_OF_ENDER);
		remove(Material.GOLDEN_APPLE);
		remove(Material.FISHING_ROD);
		remove(Material.BREWING_STAND);
		remove(Material.BREWING_STAND_ITEM);
	
	}
	
	public static void remove(Material material) {
		
		Iterator<Recipe> it = Bukkit.getServer().recipeIterator();
		Recipe recipe;
		
		while(it.hasNext()) {
			
			recipe = it.next();
			
			if(recipe != null && recipe.getResult().getType() == material) {
				
				it.remove();
				
			}
		}
		
	}
	
	@EventHandler 
	
	public void craftItem(PrepareItemCraftEvent event) {
		
		Material itemType = event.getRecipe().getResult().getType();	
		@SuppressWarnings("deprecation")
		Byte itemData = event.getRecipe().getResult().getData().getData();
		
		if(itemType == Material.EYE_OF_ENDER || (itemType == Material.GOLDEN_APPLE && itemData == 1 ) || itemType == Material.FISHING_ROD || itemType == Material.BREWING_STAND || itemType == Material.BREWING_STAND_ITEM) {
			
			event.getInventory().setResult(new ItemStack(Material.AIR));
			
			for(HumanEntity he : event.getViewers()) {
				
				if(he instanceof Player) {
					
					((Player)he).sendMessage("§4Du darfst dieses Item nicht craften");
					
				}
				
			}
			
		}
		
		
	}
	
}
