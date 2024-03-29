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
	
	private HashMap<String, double[]> homes_;
	
	public CakeHomePlugin(){
		homes_ = new HashMap<String, double[]>();
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
		homes_ = new HashMap<String, double[]>();
		homes_ = HomeUtils.loadHomes();
	}
	
	/**
	 * Will be executed at plugin shutdown
	 */
	@Override
	public void onDisable(){
		
	}
	
	public HashMap<String, double[]> getHomes(){
		return homes_;
	}
}
