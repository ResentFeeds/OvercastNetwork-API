package me.jake0oo0.types;

import java.util.List;

public class OvercastTournament {
	List<TournamentTeam> teams;
	String url;
	int minPlayers;

	public OvercastTournament(List<TournamentTeam> teams, String url, int minPlayers) {
		this.teams = teams;
		this.url = url;
		this.minPlayers = minPlayers;
	}

	public List<TournamentTeam> getTeams() {
		return teams;
	}

	public String getUrl() {
		return url;
	}

	public int getMinPlayers() {
		return minPlayers;
	}
}
