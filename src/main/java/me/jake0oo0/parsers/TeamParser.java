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
package me.jake0oo0.parsers;

import me.jake0oo0.types.OvercastPlayer;
import me.jake0oo0.types.TournamentTeam;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for handling parsing of team objects
 *
 * @author Jake0oo0
 */
public class TeamParser {

	public static TournamentTeam parseTournamentTeam(String tourneyUrl, String teamName) {

		Document doc;
		try {
			doc = Jsoup.connect(tourneyUrl)
					.userAgent("Mozilla")
					.get();
			List<String> teamNames = new ArrayList<String>();
			Elements names = doc.select("a[href]");
			for (Element name : names) {
				if (name.attr("href").startsWith("/teams/")) {
					teamNames.add(name.text());
				}
			}

			Elements links = doc.select("td[title]");
			int n = 0;

			for (int i = 0; i < links.size(); i += 2) {
				String name = teamNames.get(n);
				if (name.equals(teamName)) {
					List<OvercastPlayer> players = getPlayerObjectList(links.get(i).attr("title"));
					return new TournamentTeam(players, StatParser.parseTournamentTeam(players));
				}

				n++;
			}
		} catch (IOException e) {
			System.out.println("Error parsing tournament team: " + teamName);
		}
		return null;
	}

	public static List<String> parsePlayers(String s) {
		String[] arr = s.replace(", and ", ", ").replaceAll(" and ", ", ").split(", ");
		List<String> strings = new ArrayList<String>();
		for (String string : arr) {
			strings.add(string);
		}

		return strings;
	}

	public static List<OvercastPlayer> getPlayerObjectList(String s) {
		List<String> strings = parsePlayers(s);
		List<OvercastPlayer> players = new ArrayList<OvercastPlayer>();
		for (String p : strings) {
			players.add(new OvercastPlayer(p, StatParser.parsePlayerStats(p)));
		}
		return players;
	}
}
