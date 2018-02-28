package fr.angrykiller.bungeelightmsg;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import fr.angrykiller.bungeelightmsg.BungeeLightMSG;
public class Main extends Plugin implements Listener {

	
	public void onEnable(){
		this.getProxy().getPluginManager().registerListener(this, this);
		ProxyServer.getInstance().getPluginManager().registerCommand(this, new BungeeLightMSG());
	
	}
	public void onDisable(){
		
	}
}
