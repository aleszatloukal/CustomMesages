package me.DRIVEmaxx.CustomMessages;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Events implements Listener {
	
	private Main plugin;

	protected Events(Main instance) {
		this.plugin = instance;
	}
	  
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		String message = this.plugin.getConfig().getString("join").replace("%player%", event.getPlayer().getName()).replace("&", "§");
	    this.plugin.logger.info("[Messages] " + message);
	    event.setJoinMessage(message);
	}

	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event) {
		String message = this.plugin.getConfig().getString("quit").replace("%player%", event.getPlayer().getName());
	    this.plugin.logger.info("[Messages] " + message);
	    event.setQuitMessage(message);
	}

	@EventHandler
	public void onLogin(PlayerLoginEvent event) {
	    String p = event.getPlayer().getName();
	    if (event.getResult().equals(PlayerLoginEvent.Result.KICK_WHITELIST)) {
	      String message = this.plugin.getConfig().getString("whitelist").replace("%player%", event.getPlayer().getName());
	      this.plugin.logger.info("[Messages] Hrac " + p + " neni na white-listu!");
	      event.setKickMessage(message);
	      return;
	    }
	}
}
