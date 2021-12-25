package de.BucaLaumann.varoplugin.commands;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import de.BucaLaumann.varoplugin.main.Main;

public class StartCommand implements CommandExecutor{
	
	FileConfiguration config = Main.getInstance().getConfig();	
	
	HashMap<String, Boolean> hashMap;
	HashMap<String, Boolean> hashMap1;
	
	public StartCommand(HashMap<String, Boolean> gamePhases, HashMap<String, Boolean> joinTimeOver) { 
		
		this.hashMap = gamePhases;
		this.hashMap1 = joinTimeOver;
	}

	
	int taskId;
	int taskId1;
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		
	
		if(sender instanceof Player && sender.isOp()) {
			
			World world = Bukkit.getWorld(label);
			world.setTime(500);
			
			for (Player player : Bukkit.getOnlinePlayers()) {
			
			//Location P1T1	
			Location locP1T1 = new Location(player.getWorld(), -92, 73, 401);				
			String P1T1 = "_Squary_";
			
			if(player.getName().equalsIgnoreCase(P1T1)) {
				player.teleport(locP1T1);
			}
			
			//Location P2T1
			Location locP2T1 = new Location(player.getWorld(), -92, 73, 401);				
			String P2T1 = "Ethama05";
			
			if(player.getName().equalsIgnoreCase(P2T1)) {
				player.teleport(locP2T1);
			}
			
			//Location P1T2
			Location locP1T2 = new Location(player.getWorld(), -92, 73, 401);				
			String P1T2 = "";
			
			if(player.getName().equalsIgnoreCase(P1T2)) {
				player.teleport(locP1T2);
			}
			
			//Location P2T2
			Location locP2T2 = new Location(player.getWorld(), -92, 73, 401);				
			String P2T2 = "";
			
			if(player.getName().equalsIgnoreCase(P2T2)) {
				player.teleport(locP2T2);
			}
			
			//Location P1T3
			Location locP1T3 = new Location(player.getWorld(), -92, 73, 401);				
			String P1T3 = "";
			
			if(player.getName().equalsIgnoreCase(P1T3)) {
				player.teleport(locP1T3);
			}
			
			//Location P2T3	
			Location locP2T3 = new Location(player.getWorld(), -92, 73, 401);				
			String P2T3 = "";
			
			if(player.getName().equalsIgnoreCase(P2T3)) {
				player.teleport(locP2T3);
			}
			
			//Location P1T4	
			Location locP1T4 = new Location(player.getWorld(), -92, 73, 401);				
			String P1T4 = "";
			
			if(player.getName().equalsIgnoreCase(P1T4)) {
				player.teleport(locP1T4);
			}
			
			//Location P2T4	
			Location locP2T4 = new Location(player.getWorld(), -92, 73, 401);				
			String P2T4 = "";
			
			if(player.getName().equalsIgnoreCase(P2T4)) {
				player.teleport(locP2T4);
			}
			
			//Location P1T5	
			Location locP1T5 = new Location(player.getWorld(), -92, 73, 401);				
			String P1T5 = "";
			
			if(player.getName().equalsIgnoreCase(P1T5)) {
				player.teleport(locP1T5);
			}
			
			//Location P2T5	
			Location locP2T5 = new Location(player.getWorld(), -92, 73, 401);				
			String P2T5 = "";
			
			if(player.getName().equalsIgnoreCase(P2T5)) {
				player.teleport(locP2T5);
			}
			
			//Location P1T6	
			Location locP1T6 = new Location(player.getWorld(), -92, 73, 401);				
			String P1T6 = "";
			
			if(player.getName().equalsIgnoreCase(P1T6)) {
				player.teleport(locP1T6);
			}
			
			//Location P2T6	
			Location locP2T6 = new Location(player.getWorld(), -92, 73, 401);				
			String P2T6 = "";
			
			if(player.getName().equalsIgnoreCase(P2T6)) {
				player.teleport(locP2T6);
			}
			
			//Location P1T7	
			Location locP1T7 = new Location(player.getWorld(), -92, 73, 401);				
			String P1T7 = "";
			
			if(player.getName().equalsIgnoreCase(P1T7)) {
				player.teleport(locP1T7);
			}
			
			//Location P2T7	
			Location locP2T7 = new Location(player.getWorld(), -92, 73, 401);				
			String P2T7 = "";
			
			if(player.getName().equalsIgnoreCase(P2T7)) {
				player.teleport(locP2T7);
			}
			
			//Location P1T8
			Location locP1T8 = new Location(player.getWorld(), -92, 73, 401);				
			String P1T8 = "";
			
			if(player.getName().equalsIgnoreCase(P1T8)) {
				player.teleport(locP1T8);
			}
			
			//Location P2T8	
			Location locP2T8 = new Location(player.getWorld(), -92, 73, 401);				
			String P2T8 = "";
			
			if(player.getName().equalsIgnoreCase(P2T8)) {
				player.teleport(locP2T8);
			}
			
			//Location P1T9
			Location locP1T9 = new Location(player.getWorld(), -92, 73, 401);				
			String P1T9 = "";
			
			if(player.getName().equalsIgnoreCase(P1T9)) {
				player.teleport(locP1T9);
			}
			
			//Location P2T9	
			Location locP2T9 = new Location(player.getWorld(), -92, 73, 401);				
			String P2T9 = "";
			
			if(player.getName().equalsIgnoreCase(P2T9)) {
				player.teleport(locP2T9);
			}
			
			//Location P1T10	
			Location locP1T10 = new Location(player.getWorld(), -92, 73, 401);				
			String P1T10 = "";
			
			if(player.getName().equalsIgnoreCase(P1T10)) {
				player.teleport(locP1T10);
			}
			
			//Location P2T10	
			Location locP2T10 = new Location(player.getWorld(), -92, 73, 401);				
			String P2T10 = "";
			
			if(player.getName().equalsIgnoreCase(P2T10)) {
				player.teleport(locP2T10);
			}
			
			//Location P1T11
			Location locP1T11 = new Location(player.getWorld(), -92, 73, 401);				
			String P1T11 = "";
			
			if(player.getName().equalsIgnoreCase(P1T11)) {
				player.teleport(locP1T11);
			}
			
			//Location P2T11	
			Location locP2T11 = new Location(player.getWorld(), -92, 73, 401);				
			String P2T11 = "";
			
			if(player.getName().equalsIgnoreCase(P2T11)) {
				player.teleport(locP2T11);
			}
			
			//Location P1T12	
			Location locP1T12 = new Location(player.getWorld(), -92, 73, 401);				
			String P1T12 = "";
			
			if(player.getName().equalsIgnoreCase(P1T12)) {
				player.teleport(locP1T12);
			}
			
			//Location P2T12
			Location locP2T12 = new Location(player.getWorld(), -92, 73, 401);				
			String P2T12 = "";
			
			if(player.getName().equalsIgnoreCase(P2T12)) {
				player.teleport(locP2T12);
			}
			
			player.sendMessage("§3Du befindest dich nun in deiner Startposition"); 
			
			} 
			
			
			
			
		Bukkit.broadcastMessage("§eVaro beginnt in 1 Minute");
		
		// Startet in 30 Sekunden
		
		new BukkitRunnable() {

			@Override
			public void run() {
				Bukkit.broadcastMessage("§eVaro beginnt in 30 Sekunden");
			}
			
			
		}.runTaskLater(Main.getInstance(), 600);
		
		//Startet in 20 Sekunden
		
		new BukkitRunnable() {

			@Override
			public void run() {
				Bukkit.broadcastMessage("§eVaro beginnt in 20 Sekunden");
			}
			
			
		}.runTaskLater(Main.getInstance(), 800);
		
		//startet in 15 Sekunden
		
		new BukkitRunnable() {

			@Override
			public void run() {
				Bukkit.broadcastMessage("§eVaro beginnt in 15 Sekunden");
			}
			
			
		}.runTaskLater(Main.getInstance(), 900);
		
		//Startet in 10 Sekunden
		
		new BukkitRunnable() {

			@Override
			public void run() {
				Bukkit.broadcastMessage("§eVaro beginnt in 10 Sekunden");
			}
			
			
		}.runTaskLater(Main.getInstance(), 1000);
		
		
		//Startet in 5,4,3,2,1
		
		taskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
			
			
			int countdown = 5;
			
			@Override
			public void run() {
			
				if(countdown <= 0) {
					
					Bukkit.broadcastMessage("§aMögen die Spiele beginnen!");
					hashMap.put("gameStarted", true);
					Bukkit.getScheduler().cancelTask(taskId);
					return;
					 
				} 
				if(countdown == 1) {
					
					Bukkit.broadcastMessage("§eVaro beginnt in 1 Sekunde");
					countdown--;
					return;
					
				}
				
				Bukkit.broadcastMessage("§eVaro beginnt in " + countdown + " Sekunden");
				countdown--;
			}
			
			
		}, 1100, 20);
		
		//Players get kicked in on minute
		
		for (Player player : Bukkit.getOnlinePlayers()) {
			
			//Player is getting kicked in one minute
			new BukkitRunnable() {

				@Override
				public void run() {
					Bukkit.broadcastMessage("§e" + player.getName() + " §3wird in §eeiner §3Minute gekickt");
				}
				
				
			}.runTaskLater(Main.getInstance(), 16800);
			
			
			//Player is getting kicked in 30 seconds
			new BukkitRunnable() {

				@Override
				public void run() {
					Bukkit.broadcastMessage("§e" + player.getName() + " §3wird in §e30 §3Sekunden gekickt");
				}
				
				
			}.runTaskLater(Main.getInstance(),17400);
			
			//player is getting kicked in 10 seconds
			new BukkitRunnable() {

				@Override
				public void run() {
					Bukkit.broadcastMessage("§e" + player.getName() + " §3wird in §e10 §3Sekunden gekickt");
				}
				
				
			}.runTaskLater(Main.getInstance(),17800);
			
			//3, 2, 1
			taskId1 = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
				
				
				int countdown = 3;
				
				@Override
				public void run() {
				
					if(countdown <= 0) {
						
						Bukkit.broadcastMessage("§e" + player.getName() + " §3wurde gekickt");
						player.kickPlayer("§4Deine Aufnahmezeit ist vorbei! §cDu wurdest deshalb gekickt.");
					//	hashMap.put("firstEpOver", true);
						config.getBoolean("firstEpOver");
						config.set("firstEpOver", true);
						hashMap.put("firstEpOver", true);
						hashMap.put("gameStarted", true);
						
						Bukkit.getScheduler().cancelTask(taskId1);
						return;
						 
					} 
					
					if(countdown == 1) {
						
						Bukkit.broadcastMessage("§e" + player.getName() + " §3wird in §eeiner §3Sekunde gekickt");
						countdown--;
						return;
						
					}
				
					Bukkit.broadcastMessage("§e" + player.getName() + " §3wird in §e" + countdown +" §3Sekunden gekickt");
					countdown--;
				}
				
				
			}, 1300, 20);  //17940
			
		}
		
		//for loop ende
		
		}
		sender.sendMessage("§cFehlende Berechtigung!");
		return false;
	}

}
