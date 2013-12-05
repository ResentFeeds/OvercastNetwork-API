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
package me.jake0oo0.types;

import me.jake0oo0.stats.StatParser;
import me.jake0oo0.stats.TeamStat;

import java.util.List;

/**
 * An instance of a OvercastNetwork league
 * partaking in a current tournament.
 * This class only gets players that are
 * actually on the tourney roster
 *
 * @author Jake0oo0
 */
public class TournamentTeam {
	List<OvercastPlayer> players;
	TeamStat stats;

	public TournamentTeam(List<OvercastPlayer> players, TeamStat stats) {
		this.players = players;
		this.stats = stats;
	}

	public void parseStats() {
		this.stats = StatParser.parseOvercastTeam(getPlayers());
	}

	public List<OvercastPlayer> getPlayers() {
		return players;
	}

	public TeamStat getStats() {
		return stats;
	}
}
