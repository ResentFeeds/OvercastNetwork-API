package me.jake0oo0.types;

import me.jake0oo0.stats.PlayerStat;
import me.jake0oo0.stats.StatParser;

public class OvercastPlayer {
	String username;
	PlayerStat stats;

	public OvercastPlayer(String username, PlayerStat stats) {
		this.username = username;
		this.stats = stats;
	}

	public void parseStats() {
		this.stats = StatParser.parsePlayerStats(getUsername());
	}

	public String getUsername() {
		return username;
	}

	public PlayerStat getStats() {
		return stats;
	}
}
