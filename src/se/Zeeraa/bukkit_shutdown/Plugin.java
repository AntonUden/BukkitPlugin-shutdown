package se.Zeeraa.bukkit_shutdown;

import java.io.File;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

public class Plugin extends JavaPlugin {

	public void onEnable() {
		getDataFolder().mkdirs();
		getFile();
		File f = new File(getDataFolder().toPath() + File.separator + "shutdown.txt");
		if(f.exists()) {
			f.delete();
		}
		BukkitScheduler scheduler = getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
            	getFile();
				File f = new File(getDataFolder().toPath() + File.separator + "shutdown.txt");
        		if(f.exists()) {
        			getServer().shutdown();
        			f.delete();
        		}
            }
        }, 0L, 20L);
	}
	
	public void onDisable() {
		getFile();
		File f = new File(getDataFolder().toPath() + File.separator + "shutdown.txt");
		if(f.exists()) {
			f.delete();
		}
	}
}