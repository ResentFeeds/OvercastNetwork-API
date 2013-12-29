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

import me.jake0oo0.stats.PlayerStat;
import me.jake0oo0.stats.TeamStat;
import me.jake0oo0.utils.NumberUtils;
import me.jake0oo0.types.OvercastPlayer;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

/**
 * Stat parser, parses team and player stats
 *
 * @author Jake0oo0
 */
public class StatParser {

	/**
	 * Parse the profile of the user param
	 *
	 * @param user the user to parse
	 * @return a PlayerStat with the player's stats
	 */
	public static PlayerStat parsePlayerStats(String user) {
		String url = "https://oc.tc/" + user;
		Document doc;

		Double kd = 0.0;
		Double kk = 0.0;
		int friends = 0;
		int kills = 0;
        int raindrops = 0;
		int deaths = 0;
		int cores = 0;
		int monuments = 0;
		int wools = 0;
		try {

			doc = Jsoup.connect(url)
                    .timeout(0)
					.userAgent("Mozilla")
					.get();


			kills = Integer.parseInt(doc.select("div[class=span5]").select("h2").first().text().split(" ")[0]);
			deaths = Integer.parseInt(doc.select("div[class=span4]").select("h2").first().text().split(" ")[0]);
			wools = Integer.parseInt(doc.select("div[class=span4]").select("h2").get(1).text().split(" ")[0]);
			cores = Integer.parseInt(doc.select("div[class=span4]").select("h2").get(2).text().split(" ")[0]);
			monuments = Integer.parseInt(doc.select("div[class=span4]").select("h2").get(3).text().split(" ")[0]);
			kd = Double.parseDouble(doc.select("div[class=span3]").select("h2").get(0).text().split(" ")[0]);
			kk = Double.parseDouble(doc.select("div[class=span3]").select("h2").get(1).text().split(" ")[0]);
            //raindrops = Integer.parseInt(doc.select("div[class=span3]").select("h2").get(5).text().split(" ")[0]);

            return new PlayerStat(kd, kk, raindrops, friends, kills, deaths, cores, monuments, wools);


		} catch (IOException e) {
			System.out.println("Unable to parse player stats for URL: " + url);
            e.printStackTrace();
		}
		return new PlayerStat(kd, kk, raindrops, friends, kills, deaths, cores, monuments, wools);


	}

	/**
	 * Parse a tournament team
	 *
	 * @param players Input team players
	 * @return a TeamStat with all player stats calculated
	 */
	public static TeamStat parseTournamentTeam(List<OvercastPlayer> players) {
		Double kd = 0.0;
		Double kk = 0.0;
		int kills = 0;
		int deaths = 0;
		int cores = 0;
		int monuments = 0;
		int wools = 0;

		for (OvercastPlayer p : players) {
			PlayerStat stats = p.getStats();
			kills += stats.getKills();
			deaths += stats.getDeaths();
			cores += stats.getCores();
			monuments += stats.getMonuments();
			wools += stats.getWools();
			kd += stats.getKd();
			kk += stats.getKk();
		}

		if (players.size() > 0) {
			kd /= players.size();
			kd = NumberUtils.round(kd, 3);

			kk /= players.size();
			kk = NumberUtils.round(kk, 3);
		}

		return new TeamStat(kd, kk, kills, deaths, cores, monuments, wools);

	}

	public static TeamStat parseOvercastTeam(List<OvercastPlayer> players) {
		return parseTournamentTeam(players);
	}

}
