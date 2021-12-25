package de.BucaLaumann.varoplugin.main;

import java.util.HashMap;

import org.bukkit.BanList.Type;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.scheduler.BukkitRunnable;


public class DeathListener implements Listener  {
	
	
	
	int taskId1;
	
	FileConfiguration config = Main.getInstance().getConfig();

	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event) {
		
	//	WorldBorder border = new WorldBorder();
		double bordersize = 2000;
		double newBorder = bordersize - 50;
		
		new BukkitRunnable() {

			@Override
			public void run() {
				
			//makes worldborder shrink by n blocks everytime a player dies	
				event.getEntity().getPlayer().getWorld().getWorldBorder().setSize(newBorder);
				config.set("WorldBorder", newBorder);
				Main.getInstance().saveConfig();
				Bukkit.broadcastMessage("§4 Die neue Worldborder ist nun §a" + newBorder + " §4Blöcke groß");
				
			}
			
			
		}.runTaskLater(Main.getInstance(), 6000);
		
		
		Player player = event.getEntity().getPlayer();
		
		 for(Player player1 : Bukkit.getOnlinePlayers()) {
			 
			 player1.playSound(player1.getLocation(), Sound.AMBIENCE_THUNDER, 1F, 1F);
			 
		 };
		 
		 if (player.isDead()) {
			 
			 player.getKiller();
			 
		 }
		 
		 	if (player.getKiller() instanceof Player) {
		 		
		 		event.setDeathMessage("§e" + event.getEntity().getPlayer().getName() + " §3 wurde von §e" + player.getKiller().getName() + " §3getötet");
		 		
		 	} event.setDeathMessage("§e" + event.getEntity().getPlayer().getName() + " §3 ist gestorben.");
		 		

		 	
		 	
		 	taskId1 = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
				
				
				
				
				@Override
				public void run() {
				
					player.kickPlayer("§4Du bist gestorben. §cDamit bist du aus §eVaro §causgeschieden");
					Bukkit.getScheduler().cancelTask(taskId1);
					
				}
				
				
			}, 60, 20);
		
		 	
		 	HashMap<String, String> teams = new HashMap<>();
		 	
		 	teams.put("_Squary_", "T1l_");
		
		Bukkit.getBanList(Type.NAME).addBan(event.getEntity().getName(), "§4Du bist gestorben. §cDamit bist du aus §eVaro §causgeschieden", null, null);
		//player.setHealth(10);
		Bukkit.broadcastMessage("§4 DIE WORLDBORDER WIRD IN 5 MINUTEN KLEINER! BEGEBT EUCH IN SICHERHEIT!");
	}
	
	
	
	
}
