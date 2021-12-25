package de.BucaLaumann.varoplugin.main;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.WorldBorder;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;
//import org.bukkit.scheduler.BukkitTask;

public class JoinListener implements Listener {
	
	HashMap<String, String> hashMap;
	HashMap<String, Boolean> hashMap1;
	HashMap<String, Boolean> hashMap2;
	
	
	//team and gameStates hashMaps
	public JoinListener(HashMap<String, String> teams , HashMap<String, Boolean> gamePhases, HashMap<String, Boolean> joinTimeOver) { 
		
		this.hashMap = teams;
		this.hashMap1 = gamePhases;
		this.hashMap2 = joinTimeOver;
		
		
		System.out.println(hashMap.get("_Squary_"));
	}
	
	//checks if player is outside border
	
	public static boolean isOutsideOfBorder(Player p) {
	        Location loc = p.getLocation();
	        WorldBorder border = p.getWorld().getWorldBorder();
	        double size = border.getSize()/2;
	        Location center = border.getCenter();
	        double x = loc.getX() - center.getX(), z = loc.getZ() - center.getZ();
	        return ((x > size || (-x) > size) || (z > size || (-z) > size));  
	        
	    } 
	 
	FileConfiguration config = Main.getInstance().getConfig();
	
	int sessions = 0;
	
	int taskId;
	int taskId1;
	int taskId2;
	int taskId3;
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		
		UUID player1 = event.getPlayer().getUniqueId();
		
		sessions++;
		
		HashMap<UUID, Integer> recordingSessions = new HashMap<>();
		
		recordingSessions.put(player1, sessions);
		
		if (recordingSessions.get(player1) >= 3) {
			
		event.getPlayer().kickPlayer("§4Du hast die maximale Zahl an Aufnahmen für heute erreicht!");
			
		} 
		
		if (hashMap1.get("firstEpOver") == true) {
		
		hashMap2.put(event.getPlayer().getName().toString(), false);
		
		
		Player player = event.getPlayer();
		
		if(JoinListener.isOutsideOfBorder(event.getPlayer()) == true ) {
			
			
		//	event.getPlayer().teleport(new Location(event.getPlayer().getWorld(), -84, 75, 391));
			
			//Message if player spawned outside  of the worldborder
			
			event.getPlayer().sendMessage("§4Du bist außerhalb der WorldBorder gespawned");
			
			WorldBorder border = player.getWorld().getWorldBorder();
			Location loc = player.getLocation();
			double size = border.getSize()/2;
		    Location center = border.getCenter();
		    double x = loc.getX() - center.getX(), z = loc.getZ() - center.getZ();
		    
		    //check different sides of worldorder
			 if (x > size && (-z) > size) {
	    	
	    		player.sendMessage("x > size && -z > size");
	    		player.teleport(new Location(player.getWorld(),loc.getX() - ((x - size) + 2), player.getWorld().getHighestBlockYAt((int) (loc.getX() + ((x - size) + 2)), (int) ((int) loc.getZ() - ((-z - size) + 2) * -1)), loc.getZ() - ((-z - size) + 2) * -1));
	    		player.sendMessage("§aDu wurdest an den Rand der Border teleportiert!");
	    	
	    	} else if (x > size && z > size) {
	    	
	    		player.sendMessage("x > size && z > size");
	    		player.teleport(new Location( player.getWorld() ,loc.getX() - ((x - size) + 2), player.getWorld().getHighestBlockYAt( (int) (loc.getX() - ((x - size) + 2)), (int) ((int) loc.getZ() - ((z - size) + 2))), loc.getZ() - ((z - size) + 2)));
	    		player.sendMessage("§aDu wurdest an den Rand der Border teleportiert!");
	    	
	    	} else if ((-x) > size && z > size) {
	    	
	    		player.sendMessage("-x > size && z > size");
	    		player.teleport(new Location( player.getWorld(), loc.getX() - ((-x - size) + 2) * -1, player.getWorld().getHighestBlockYAt( (int) (loc.getBlockX() - ((-x - size) + 2) * -1), (int) ((int) loc.getZ() - ((z - size) + 2))), loc.getZ() - ((z - size) + 2)));
	    		player.sendMessage("§aDu wurdest an den Rand der Border teleportiert!");
	    	
	    	} else if ((-x) > size && (-z) > size) {
	    	
	    		player.sendMessage("-x > size && -z > size");
	    		player.teleport(new Location( player.getWorld(), loc.getX() - ((-x - size) + 2) * -1, player.getWorld().getHighestBlockYAt( (int) (loc.getBlockX() - ((-x - size) + 2) * -1), (int) ((int) loc.getZ() - ((-z - size) + 2) * -1)), loc.getZ() - ((-z - size) + 2) * -1));
	    //		Location loc1 = player.getLocation();
	    //		Block block1 = (Block) loc1.add(0, 1, 0).getBlock();
		 //   	Block block2 = (Block) loc1.getBlock();
		    	
		 //   	block1.setType(Material.AIR);
		  //  	block2.setType(Material.AIR);
	    		
	    	//	loc1.add(0, 1, 0).getBlock().setType(Material.AIR);
	    	//	loc1.add(0, 0, 0).getBlock().setType(Material.AIR);
	    	//	loc1.subtract(0, 2, 0).getBlock().setType(Material.GLOWSTONE);
	    		player.sendMessage("§aDu wurdest an den Rand der Border teleportiert!");
	    	
	    	}
	    	else if(x > size) {
		    	
		    	player.sendMessage(" x > size");
		    	player.teleport(new Location(player.getWorld(), loc.getX() - ((x - size) + 2), player.getWorld().getHighestBlockYAt((int) (loc.getX() + ((x - size) + 2)), loc.getBlockZ()), loc.getBlockZ()  ));
		    	player.sendMessage("§aDu wurdest an den Rand der Border teleportiert!");
		    	
		    } else if ((-x) > size) {
		    	
		    	player.sendMessage(" -x > size");
		    	player.teleport(new Location(player.getWorld(), loc.getX() - ((-x - size) + 2) * -1 , player.getWorld().getHighestBlockYAt((int) (loc.getBlockX() - ((-x - size) + 2) * -1) , loc.getBlockZ()), loc.getZ() ));
		    	player.sendMessage("§aDu wurdest an den Rand der Border teleportiert!");
		    	
		    } else if (z > size) {
		    	
		    	player.sendMessage(" z > size");
		    	player.teleport(new Location(player.getWorld(), loc.getX(), player.getWorld().getHighestBlockYAt(loc.getBlockX(),(int) ((int) loc.getZ() - ((z - size) + 2)) ), loc.getZ() - ((z - size) + 2)  ));
		    	player.sendMessage("§aDu wurdest an den Rand der Border teleportiert!");
		    	
		    } else if ((-z) > size) {
		    	
		    	player.sendMessage(" -z > size");
		    	player.teleport(new Location(player.getWorld(), loc.getX(), player.getWorld().getHighestBlockYAt(loc.getBlockX(), (int) ((int) loc.getZ() - ((-z - size) + 2) * -1)), loc.getZ() - ((-z - size) + 2) * -1 ));
		    	player.sendMessage("§aDu wurdest an den Rand der Border teleportiert!");
		    	
		    } /*else if (x > size && (-z) > size) {
		    	
		    	player.sendMessage("x > size && -z > size");
		    	
		    } else if (x > size && z > size) {
		    	
		    	player.sendMessage("x > size && z > size");
		    	
		    } else if ((-x) > size && z > size) {
		    	3
		    	player.sendMessage("-x > size && z > size");
		    	
		    } else if ((-x) > size && (-z) > size) {
		    	
		    	player.sendMessage("-x > size && -z > size");
		    	
		    } */
		   
	//		double wbSize = wb.getSize() / 2;
	//		double wbCenterZ = wb.getCenter().getZ();
	//		double wbCenterX = wb.getCenter().getX();			
	//		Location playerLocation = event.getPlayer().getLocation();
			
	/*		if(playerLocation.getBlockZ() > (wbCenterZ + wbSize)) {
				
				
				double	distancePositiveZ = playerLocation.getBlockZ() - (wbCenterZ + wbSize);
				event.getPlayer().sendMessage("distancepositiveZ" + distancePositiveZ);
				event.getPlayer().teleport(new Location(event.getPlayer().getWorld(), playerLocation.getBlockX(), event.getPlayer().getWorld().getHighestBlockYAt(playerLocation.getBlockX(), playerLocation.getBlockZ() - (int) distancePositiveZ + 2)  , playerLocation.getBlockZ() - (distancePositiveZ + 2)	
						));
				
			} else if (playerLocation.getBlockZ() > (wbCenterZ - wbSize)) {
				
				double	distanceNegativeZ = (wbCenterZ - wbSize) - playerLocation.getBlockZ() ;
				event.getPlayer().sendMessage("distanceNegativeZ" + distanceNegativeZ);
				event.getPlayer().teleport(new Location(event.getPlayer().getWorld(), playerLocation.getBlockX(), event.getPlayer().getWorld().getHighestBlockYAt(playerLocation.getBlockX(), ((int) distanceNegativeZ +2) + playerLocation.getBlockZ() )    , playerLocation.getBlockZ() + (distanceNegativeZ + 2)));

			} else if (playerLocation.getBlockX() > (wbCenterX + wbSize)) {  //X 929 --> X 909
				
				double distancePositiveX = playerLocation.getBlockX() - (wbCenterX + wbSize);
				event.getPlayer().sendMessage("distencePositiveX" + distancePositiveX);
				event.getPlayer().teleport(new Location(event.getPlayer().getWorld(), playerLocation.getBlockX() - (distancePositiveX +2), event.getPlayer().getWorld().getHighestBlockYAt(playerLocation.getBlockX() - (int) distancePositiveX + 2, playerLocation.getBlockZ()), playerLocation.getBlockZ()));
				
			} else if (playerLocation.getBlockX() > (wbCenterX - wbSize)) {
				
				double	distanceNegativeX = (wbCenterX - wbSize) - playerLocation.getBlockX() ;
				event.getPlayer().sendMessage("distanceNegativeX" + distanceNegativeX);
				event.getPlayer().teleport(new Location(event.getPlayer().getWorld(), playerLocation.getBlockX() + (distanceNegativeX + 2), event.getPlayer().getWorld().getHighestBlockYAt(playerLocation.getBlockX(), ((int) distanceNegativeX +2) + playerLocation.getBlockZ() )    , playerLocation.getBlockZ() ));

				
			}
			 
			*/
		} else {
			
		//	event.getPlayer().sendMessage("§cAlles okay dawg");
			
		}
		
	//	Location spawnLocation = event.getPlayer().getLocation();
		
		
		
		
		
		

//	UUID playerUUID = event.getPlayer().getUniqueId();
	
//	boolean timerEnd = false;
	
//	HashMap<UUID, Boolean> playerJoin = new HashMap<UUID, Boolean>();
	
//	playerJoin.put(playerUUID, timerEnd);
//	System.out.println(playerJoin);
		
	/*	Player player = event.getPlayer();
		
		for (Player player1 : event.getPlayer()) {
			
			config.set("gameStarted", false);
			Main.getInstance().saveConfig();
			
		} */
	
//		Location spawnLocation = event.getPlayer().getLocation();
	
		event.setJoinMessage("§e" + event.getPlayer().getName() + " §3hat den Server betreten und ist in §e10 §3Sekunden angreifbar");
		
		//freeze player midair
		taskId2= Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
			
			
			int countdown1= 200;
			
			@Override
			public void run() {
			
				if(countdown1<= 0) {
					
					Bukkit.getScheduler().cancelTask(taskId2);
				//	event.getPlayer().teleport(spawnLocation);
					event.getPlayer().setHealth(20);
					return;
					 
				} 
				if(countdown1== 1) {
					
				//	event.getPlayer().teleport(spawnLocation);
					event.getPlayer().setHealth(20);
					countdown1--;
					return;
					
				}
				
			//	event.getPlayer().teleport(spawnLocation);
				event.getPlayer().setHealth(20);
				countdown1--;
			}
			
			
		}, 0, 0);		
		
	//	event.getPlayer().setWalkSpeed(0);
	
		
		//Join Countdown
		taskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
			
			
			int countdown = 3;
			
			@Override
			public void run() {
			
				if(countdown <= 0) {
					
					
					event.getPlayer().setWalkSpeed((float) 0.2);
					event.getPlayer().sendMessage("§cDu bist nun verwundbar!");
					hashMap2.put(event.getPlayer().getName().toString(), true);
					Bukkit.getScheduler().cancelTask(taskId);
		//			playerJoin.put(playerUUID, true);
					return;
					 
				} 
				if(countdown == 1) {
					
					Bukkit.broadcastMessage("§e" + event.getPlayer().getName() + " §3 ist in §eeiner §3Sekunde angreifbar");
					countdown--;
					return;
					
				}
				
				Bukkit.broadcastMessage("§e" + event.getPlayer().getName() + " §3 ist in §e" + countdown +" §3Sekunden angreifbar");
				countdown--;
			}
			
			
		}, 140, 20);
		
		//Kick Event
		
		
		new BukkitRunnable() {

			@Override
			public void run() {
				
				event.getPlayer().kickPlayer("§cDeine Aufnahmezeit ist vorbei!");
				this.cancel();
				
			}
			
			
		}.runTaskLater(Main.getInstance(), 18000);
		
		
		
		taskId3 = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {

			@Override
			public void run() {
				
				double distance = 50;
				Location center = event.getPlayer().getLocation();
				
				for(Player player : Bukkit.getOnlinePlayers()) {
					
					Location location = player.getLocation();
					
					if (player != event.getPlayer()) {
					
						if(location.distanceSquared(center) <= distance * distance) {
						
							event.getPlayer().sendMessage("§4Achtung §cEin Gegner ist zu nah, um das Spiel zu verlassen! Entferne dich von ihm!");
						
						}
					
					
					}
			//		event.getPlayer().kickPlayer("§4Deine Aufnahmezeit ist vorbei! §cDu wurdest deshalb gekickt.");
			//		event.getPlayer().sendMessage("Aufnahmezeit vorbei");
					Bukkit.getScheduler().cancelTask(taskId3);
					
				}
				
			//	event.getPlayer().kickPlayer("§4Deine Aufnahmezeit ist vorbei! §cDu wurdest deshalb gekickt.");
			//	Bukkit.getScheduler().cancelTask(taskId3);
				
			}
				
			
		}, 600, 20);  //18000 
		
		
		
		
		//Kick Countdown
		new BukkitRunnable() {

			@Override
			public void run() {
				Bukkit.broadcastMessage("§e" + event.getPlayer().getName() + " §3wird in §eeiner §3Minute gekickt");
			}
			
			
		}.runTaskLater(Main.getInstance(), 16800);
		
		
		
		new BukkitRunnable() {

			@Override
			public void run() {
				Bukkit.broadcastMessage("§e" + event.getPlayer().getName() + " §3wird in §e10 §3Sekunden gekickt");
			}
			
			
		}.runTaskLater(Main.getInstance(),17800);
		
		// 3, 2, 1
		
		
		
		taskId1 = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
			
			
			int countdown = 3;
			
			@Override
			public void run() {
			
				if(countdown <= 0) {
					
					Bukkit.broadcastMessage("§e" + event.getPlayer().getName() + " §3wurde gekickt");
					Bukkit.getScheduler().cancelTask(taskId1);
					return;
					 
				} 
				
				if(countdown == 1) {
					
					Bukkit.broadcastMessage("§e" + event.getPlayer().getName() + " §3wird in §eeiner §3Sekunde gekickt");
					countdown--;
					return;
					
				}
			
				Bukkit.broadcastMessage("§e" + event.getPlayer().getName() + " §3wird in §e" + countdown +" §3Sekunden gekickt");
				countdown--;
			}
			
			
		}, 17940, 20);
		
		}
		
	}

}
