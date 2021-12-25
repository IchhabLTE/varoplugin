package de.BucaLaumann.varoplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			player.setHealth(20);
			player.setFoodLevel(20);
			player.sendMessage("§a You were healed");
			
		} else {
			
			sender.sendMessage("Only players are allowed to use this command!");
			
		}
		
		return false;
	}
}
