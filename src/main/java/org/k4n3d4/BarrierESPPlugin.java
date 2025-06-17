package org.k4n3d4;

import org.rusherhack.client.api.RusherHackAPI;
import org.rusherhack.client.api.plugin.Plugin;

public class BarrierESPPlugin extends Plugin {
	
	public static long minecraftInitTime = 0L;
	public static BarrierESPPlugin INSTANCE;
	
	@Override
	public void onLoad() {
		INSTANCE = this;

		final BarrierESPModule barrierESPModule = new BarrierESPModule();
		RusherHackAPI.getModuleManager().registerFeature(barrierESPModule);

		this.getLogger().info("Loading Barrier ESP plugin");
	}

	@Override
	public void onUnload() {
		this.getLogger().info("Barrier ESP plugin unloaded!");
	}
	
}