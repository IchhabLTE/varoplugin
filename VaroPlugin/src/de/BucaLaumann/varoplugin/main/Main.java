package de.BucaLaumann.varoplugin.main;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.WorldBorder;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import de.BucaLaumann.varoplugin.commands.GetLocation;
//import de.BucaLaumann.varoplugin.commands.HealCommand;
import de.BucaLaumann.varoplugin.commands.StartCommand;

public class Main extends JavaPlugin{
	
	FileConfiguration config = getConfig();
	
	public boolean gameStarted = false;
	
	private static Main plugin;
	
	public static Main getInstance() {
		
		return Main.plugin;
		
	}
		
	
	
	public void onEnable() {
		System.out.println("Enabeled VaroPlugin successfully!");
	
		HashMap<String, String> teams = new HashMap<>();
		//Team 1
		teams.put("_Squary_", "T1ltedNesS");
		teams.put("T1ltedNesS","_Squary_");
		//Team 2
		teams.put("jhw321", "LegendVaedificio");
		teams.put("LegendVaedificio", "jhw321");
		//Team 3
		teams.put("Jumper_007", "Flosi21");
		teams.put("Flosi21", "jumper_007");
		//Team 4
		teams.put("Urus361", "Machdas");
		teams.put("Machdas", "Urus361");
		//Team 5
		teams.put("luckyundleo", "T1ltedsheik");
		teams.put("T1ltedsheik", "luckyandleo");
		//Team 6
		teams.put("Schnabu", "Jakusiii");
		teams.put("Jakusiii", "Schnabu");
		//Team 7
		teams.put("Karotteeae", "xXBasti_5555");
		teams.put("xXBasti_5555", "Karotteeae");
		//Team8
		teams.put("NoHitxDelay", "Shadow_642");
		teams.put("Shadow_642", "NoHitxDelay");
		//Team9
		teams.put("Timolio", "Paluten");
		teams.put("Paluten", "Timolio");
		
		HashMap<String, Boolean> gamePhases = new HashMap<>();
		
		gamePhases.put("gameStarted", false);
		gamePhases.put("firstEpOver", false);
		
		
		HashMap<String, Boolean> joinTimeOver = new HashMap<>();
		
		String[] names = {"_Squary_", "T1ltedNesS", "jhw321", "LegendVaedificio", "jumper_007", "Flosi21", "Urus361",
				"Machdas", "lucakyundleo", "T1ltedsheik", "Schnabu", "Jakusiii", "Karotteeae", "xXBasti_5555", "NoHitxDelay", "Shadow_642", "Timolio"};
		
		for(String i : names) {
			
			joinTimeOver.put(i, false);
			
		}
	
		
		Main.plugin = this;
		
		//register listeners here
		getServer().getPluginManager().registerEvents(new JoinListener(teams,gamePhases,joinTimeOver), this);
		getServer().getPluginManager().registerEvents(new DeathListener(), this);
		getServer().getPluginManager().registerEvents(new BlockBreakListener(gamePhases,joinTimeOver), this);
		getServer().getPluginManager().registerEvents(new CraftRecipeListener(), this);
		getServer().getPluginManager().registerEvents(new LeaveListener(), this);
		getServer().getPluginManager().registerEvents(new PortalCreationListener(), this);
		getServer().getPluginManager().registerEvents(new PlayerDamageListener(teams), this);
		
		//register commands here
		//getCommand("heal").setExecutor(new HealCommand());
		getCommand("start").setExecutor(new StartCommand(gamePhases,joinTimeOver));
		getCommand("location").setExecutor(new GetLocation());
		

		
	}

	public static void main (String[] args) {
		
	}
	
	public boolean isOutsideOfBorder(Player player) {
	
		Location loc = player.getLocation();
        WorldBorder border = player.getWorld().getWorldBorder();
        double size = border.getSize()/2;
        Location center = border.getCenter();
        double x = loc.getX() - center.getX(), z = loc.getZ() - center.getZ();
        return ((x > size || (-x) > size) || (z > size || (-z) > size));
		
	}
	
	public void outsideBorder()  {
		
		if(isOutsideOfBorder(null) == true) {
			
			Bukkit.broadcastMessage("You are outside the border!");			
			
		}
		
	}
	
}

