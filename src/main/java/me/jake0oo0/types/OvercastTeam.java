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

import me.jake0oo0.parsers.StatParser;
import me.jake0oo0.stats.TeamStat;

import java.util.List;

/**
 * An OvercastNetwork league team,
 * not necessarily competing in a tournament
 *
 * @author Jake0oo0
 */
public class OvercastTeam {
	String name;
	String url;
	List<OvercastPlayer> players;
	TeamStat stats;

	/**
	 * OvercastNetwork league team instance
	 *
	 * @param name name of team
	 * @param url url of team
	 * @param players list of team players
	 * @param stats team stats
	 */
	public OvercastTeam(String name, String url, List<OvercastPlayer> players, TeamStat stats) {
		this.name = name;
		this.url = url;
		this.players = players;
		this.stats = stats;
	}

	public void parseStats() {
		this.stats = StatParser.parseOvercastTeam(getPlayers());
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
