package me.jake0oo0;

import java.util.List;

/**
 * Created by jake on 12/4/13.
 */
public class TournamentTeam {
	List<OvercastPlayer> players;
	TeamStat stats;

	public TournamentTeam(List<OvercastPlayer> players, TeamStat stats) {
		this.players = players;
		this.stats = stats;
	}
}
