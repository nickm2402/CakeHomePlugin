package de.lycake.CakeHomePlugin;

import java.util.HashMap;
import java.util.logging.Logger;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class CakeHomePlugin extends JavaPlugin{
	private Logger log;
	private HomeCommandExecutor cmdExecutor_;
	
	private HashMap<Player, Location> homes_;
	
	public CakeHomePlugin(){
		homes_ = new HashMap<Player, Location>();
	}

	/**
	 * Will be executed at plugin start
	 */
	@Override
	public void onEnable(){
		//Plugin Manager
		PluginManager pm = getServer().getPluginManager();
		
		//Logger
		log = Logger.getLogger("Minecraft");
		log.info("CakeHomePlugin loaded");
		
		//Commands
		cmdExecutor_ = new HomeCommandExecutor(this);
		getCommand("home").setExecutor(cmdExecutor_);
		
		//Load homes
		homes_ = new HashMap<Player, Location>();
		homes_ = HomeUtils.loadHomes();
	}
	
	/**
	 * Will be executed at plugin shutdown
	 */
	@Override
	public void onDisable(){
		
	}
	
	public HashMap<Player, Location> getHomes(){
		return homes_;
	}
}
