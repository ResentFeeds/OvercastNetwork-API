package me.jake0oo0.types;

import me.jake0oo0.stats.TeamStat;

import java.util.List;

/**
 * Created by jake on 12/4/13.
 */
public class OvercastTeam {
	String name;
	String url;
	List<OvercastPlayer> players;
	TeamStat stats;

	public OvercastTeam(String name, String url, List<OvercastPlayer> players, TeamStat stats) {
		this.name = name;
		this.url = url;
		this.players = players;
		this.stats = stats;
	}

	public String getName() {
		return name;
	}

	public String getUrl() {
		return url;
	}

	public List<OvercastPlayer> getPlayers() {
		return players;
	}

	public TeamStat getStats() {
		return stats;
	}
}
