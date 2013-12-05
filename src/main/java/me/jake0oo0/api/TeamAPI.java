package me.jake0oo0.api;

import me.jake0oo0.parsers.StatParser;
import me.jake0oo0.parsers.TeamParser;
import me.jake0oo0.stats.TeamStat;
import me.jake0oo0.types.OvercastTeam;
import me.jake0oo0.types.TournamentTeam;

/**
 * Class for managing the retrieval of team stats
 *
 * @author Jake0oo0
 */
public class TeamAPI {

	/**
	 * Get the stats of an Overcast team
	 *
	 * @param team input OvercastTeam
	 * @return TeamStat's of input team
	 */
	public TeamStat getOvercastTeamStats(OvercastTeam team) {
		return StatParser.parseOvercastTeam(team.getPlayers());
	}

	/**
	 * Get the stats of a tournament team
	 *
	 * @param team input TournamentTeam
	 * @return team's stats
	 */
	public TeamStat getTourneyTeamStats(TournamentTeam team) {
		return StatParser.parseTournamentTeam(team.getPlayers());
	}

	/**
	 * Get a tourney team from the tourney url and name
	 *
	 * @param url tourney url
	 * @param name team name
	 * @return TournamentTeam created from params
	 */
	public TournamentTeam getTourneyTeam(String url, String name) {
		return TeamParser.parseTournamentTeam(url, name);
	}

	/**
	 * Retrieve stats of an OvercastTeam
	 *
	 * @param url team url
	 * @return output OvercastTeam
	 */
	public OvercastTeam getOvercastTeam(String url) {
		return TeamParser.parseOvercastTeam(url);
	}
}
