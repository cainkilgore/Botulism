package me.cain.botulism;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.inventory.ItemStack;
import com.nijiko.permissions.PermissionHandler;
import com.nijikokun.bukkit.Permissions.Permissions;
import org.bukkit.plugin.Plugin;

public class mainlistener extends PlayerListener
{
	Player player;
	botmain plugin;
	Server server;
	
	public mainlistener(botmain instance)
	{
		this.plugin = instance;
	}

	public void onPlayerInteract(PlayerInteractEvent event) 
	{
		Player player = event.getPlayer();
		  if (player.hasPermission("botulism.protect")) {
			player.sendMessage("You have botulism protection!");
		} else {
		if(event.getMaterial() == Material.PORK || event.getMaterial() == Material.SUGAR || event.getMaterial() == Material.RAW_FISH) {
			if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
				player.damage(Integer.parseInt(plugin.config.getProperty("config.damage").toString()));
				player.sendMessage(ChatColor.RED + " Eating that is bad for you!");
				event.getPlayer().setItemInHand(new ItemStack(0,0));
			}
		}
	}
	}
}