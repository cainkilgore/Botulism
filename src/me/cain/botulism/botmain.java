package me.cain.botulism;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.Event.Priority;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.config.Configuration;

public class botmain extends JavaPlugin
{
	private final mainlistener TheListener = new mainlistener(this);	
	Player player;
	public Configuration config;
	Logger log = Logger.getLogger("Minecraft");
	String pluginname = "Botulism";

	public void onDisable() 
	{
		log.info("[" + pluginname + "] " + pluginname + " has been disabled.");
	}

	public void onEnable() 
	{
		config = this.getConfiguration();
			PluginManager pm = getServer().getPluginManager();
		log.info("[" + pluginname + "] " + pluginname + " has been enabled.");
		log.info("[" + pluginname + "] Created by CainFoool");
		pm.registerEvent(Event.Type.PLAYER_INTERACT, new mainlistener(this), Priority.Normal, this);
		ConfigFile();
		config.load();
		ConfigurationCheck();
	}
	
	public void ConfigurationCheck() 
	{
		if(config.getProperty("config.damage") == null)
		{
		     config.setProperty("config.damage", 5);
		     config.save();
		}
	}
	
	 private void ConfigFile() {
		  
		  String file = this.getDataFolder().toString()+"/config.yml";
		  
		  File yml = new File(file);
		  
		  if (!yml.exists()) {
		   new File(this.getDataFolder().toString()).mkdir();
		   
		   try {
		    yml.createNewFile();
		   } catch (IOException e) {
		    e.printStackTrace();
		   }
		  }
		 }
}
		
// Created by CainFoool