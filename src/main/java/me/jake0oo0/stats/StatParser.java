package me.jake0oo0.stats;

import me.jake0oo0.utils.NumberUtils;
import me.jake0oo0.types.OvercastPlayer;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

public class StatParser {

	public PlayerStat parsePlayerStats(String user) {
		String url = "https://oc.tc/" + user;
		Document doc;

		Double kd = 0.0;
		Double kk = 0.0;
		int friends = 0;
		int kills = 0;
		int deaths = 0;
		int cores = 0;
		int monuments = 0;
		int wools = 0;
		try {

			doc = Jsoup.connect(url)
					.userAgent("Mozilla")
					.get();

			kills = Integer.parseInt(doc.select("div[class=span5]").select("h2").first().text().split(" ")[0]);
			deaths = Integer.parseInt(doc.select("div[class=span4]").select("h2").first().text().split(" ")[0]);
			wools = Integer.parseInt(doc.select("div[class=span4]").select("h2").get(1).text().split(" ")[0]);
			cores = Integer.parseInt(doc.select("div[class=span4]").select("h2").get(2).text().split(" ")[0]);
			monuments = Integer.parseInt(doc.select("div[class=span4]").select("h2").get(3).text().split(" ")[0]);
			kd = Double.parseDouble(doc.select("div[class=span3]").select("h2").get(0).text().split(" ")[0]);
			kk = Double.parseDouble(doc.select("div[class=span3]").select("h2").get(1).text().split(" ")[0]);
			return new PlayerStat(kd, kk, friends, kills, deaths, cores, monuments, wools);


		} catch (IOException e) {
			System.out.println("Unable to parse player stats for URL: " + url);
		}
		return new PlayerStat(kd, kk, friends, kills, deaths, cores, monuments, wools);


	}

	public TeamStat parseTournamentTeam(List<OvercastPlayer> players) {
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

	public TeamStat parseOvercastTeam(List<OvercastPlayer> players) {
		return parseTournamentTeam(players);
	}

}
