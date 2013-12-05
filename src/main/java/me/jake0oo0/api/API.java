/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2013 Jake0oo0
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package me.jake0oo0.api;

import me.jake0oo0.parsers.StatParser;
import me.jake0oo0.parsers.TeamParser;
import me.jake0oo0.stats.TeamStat;
import me.jake0oo0.types.OvercastPlayer;
import me.jake0oo0.types.OvercastTeam;
import me.jake0oo0.types.OvercastTournament;
import me.jake0oo0.types.TournamentTeam;

/**
 * API class for the Overcast API
 *
 * @author Jake0oo0
 */
public class API {

	/**
	 * Get an instance of an OvercastNetwork player
	 *
	 * @param user username
	 * @return OvercastPlayer object from params
	 */
	public OvercastPlayer getPlayer(String user) {
		OvercastPlayer player = new OvercastPlayer(user, null);
		player.parseStats();
		return player;

	}

	/**
	 * Get a player from a URL
	 *
	 * @param url player's profile url
	 * @return OvercastPlayer from url
	 */
	public OvercastPlayer getPlayerByUrl(String url) {
		String user = url.split("https://oc.tc/")[1];
		return getPlayer(user);
	}

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
	 * @return ouput OvercastTeam
	 */
	public OvercastTeam getOvercastTeam(String url) {
		//TODO
		return null;
	}

	/**
	 * Get an instance of an OvercastTournament
	 *
	 * @param url tourney url
	 * @return an OvercastTournament from the url
	 */
	public OvercastTournament getTournament(String url) {
		//TODO
		return null;
	}
}
