package me.jake0oo0.types;

import me.jake0oo0.stats.PlayerStat;

public class OvercastPlayer {
	String username;
	PlayerStat stats;

	public OvercastPlayer(String username, PlayerStat stats) {
		this.username = username;
		this.stats = stats;
	}

	public String getUsername() {
		return username;
	}

	public PlayerStat getStats() {
		return stats;
	}
}
