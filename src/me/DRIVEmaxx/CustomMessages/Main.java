package me.DRIVEmaxx.CustomMessages;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	Logger logger = Logger.getLogger("Minecraft");
	
	public void onEnable() {
		saveDefaultConfig();
		PluginDescriptionFile pdfFile = getDescription();
		this.logger.info(pdfFile.getName() + " Version " + pdfFile.getVersion() + " has been enabled.");
	    getServer().getPluginManager().registerEvents(new Events(this), this);
	}

	public void onDisable() {
	    PluginDescriptionFile pdfFile = getDescription();
	    this.logger.info(pdfFile.getName() + " has Been Disabled!");
	}
	
}
