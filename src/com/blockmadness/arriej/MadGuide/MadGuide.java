package com.blockmadness.arriej.MadGuide;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.FileConfigurationOptions;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class MadGuide
  extends JavaPlugin
  implements CommandExecutor
{
  public void onEnable()
  {
    loadConfiguration();
  }
  
  public void loadConfiguration()
  {
    getConfig().options().copyDefaults(true);
    saveConfig();
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args)
  {
    String[] rankList = { "quartz", "redstone", "lapis", "diamond", "ender"};
    for (String rank : rankList) {
      if (cmdLabel.equalsIgnoreCase(rank)) {
        if ((sender instanceof Player))
        {
          if (args.length == 0)
          {
            Player player = (Player)sender;
            for (String line : getConfig().getStringList(rank)) {
              player.sendMessage(addColor(line));
            }
          }
          else
          {
            return false;
          }
        }
        else {
          getServer().getLogger().info("[MadGuide] Ask K_Cin if you want this plugin to work from console.");
        }
      }
    }
    return true;
  }
 
  	public String addColor(String text) {
    	  		 String output = text.replace("&0", ChatColor.BLACK + "");
    	  		 output = output.replace("&1", ChatColor.DARK_BLUE + "");
    	  		 output = output.replace("&2", ChatColor.DARK_GREEN + "");
    	  		 output = output.replace("&3", ChatColor.DARK_AQUA + "");
    	  		 output = output.replace("&4", ChatColor.DARK_RED + "");
    	  		 output = output.replace("&5", ChatColor.DARK_PURPLE + "");
    	  		 output = output.replace("&6", ChatColor.GOLD + "");
    	  		 output = output.replace("&7", ChatColor.GRAY + "");
    	  		 output = output.replace("&8", ChatColor.DARK_GRAY + "");
    	  		 output = output.replace("&9", ChatColor.BLUE + "");
    	  		 output = output.replace("&a", ChatColor.GREEN + "");
    	  		 output = output.replace("&b", ChatColor.AQUA + "");
    	  		 output = output.replace("&c", ChatColor.RED + "");
    	  		 output = output.replace("&d", ChatColor.LIGHT_PURPLE + "");
    	  		 output = output.replace("&e", ChatColor.YELLOW + "");
    	  		 output = output.replace("&f", ChatColor.WHITE + "");
    	  		 output = output.replace("&l", ChatColor.BOLD + "");
    	  		 output = output.replace("&m", ChatColor.STRIKETHROUGH + "");
    	  		 output = output.replace("&n", ChatColor.UNDERLINE + "");
    	  		 output = output.replace("&o", ChatColor.ITALIC + "");
    	  		 output = output.replace("&r", ChatColor.RESET + "");

    	  		 return output;
  	}
}