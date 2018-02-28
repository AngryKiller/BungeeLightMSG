package fr.angrykiller.bungeelightmsg;
/*
 * 
 * BungeeLightMSG Plugin by AngryKiller
 * 			Version 1.0 Beta
 * 
 */
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class BungeeLightMSG extends Command {

	public BungeeLightMSG() {
		super("msg");
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		ProxiedPlayer p = (ProxiedPlayer) sender;
		
		String targetName = args[0];
		
		if(args.length > 1){
			if(ProxyServer.getInstance().getPlayer(targetName) == null){
			p.sendMessage(new TextComponent(ChatColor.RED+"Player "+targetName+" isn't connected !"));	
			}else{
				ProxiedPlayer target = ProxyServer.getInstance().getPlayer(targetName);
				
				String message = "";
				for(int i = 1; i != args.length; i++){
					message += args[i]+" ";
				}
				String messagecolored = ChatColor.translateAlternateColorCodes('&', message);
				String senderPrefix = ChatColor.GRAY+"["+ChatColor.RED+"Me"+ChatColor.GRAY+"] "+ChatColor.GOLD+"--> "+ChatColor.GRAY+"["+ChatColor.RED+target.getName()+ChatColor.GRAY+"]"+ChatColor.WHITE+": ";
				String targetPrefix = ChatColor.GRAY+"["+ChatColor.RED+p.getName()+ChatColor.GRAY+"] "+ChatColor.GOLD+"--> "+ChatColor.GRAY+"["+ChatColor.RED+"Me"+ChatColor.GRAY+"]"+ChatColor.WHITE+": ";;
				p.sendMessage(new TextComponent(senderPrefix+ChatColor.WHITE+messagecolored));
				target.sendMessage(new TextComponent(targetPrefix+ChatColor.WHITE+messagecolored));
				
			}
		}else{
			p.sendMessage(new TextComponent(ChatColor.RED+"Please specify a message !")); 
		}
	}

	
}
