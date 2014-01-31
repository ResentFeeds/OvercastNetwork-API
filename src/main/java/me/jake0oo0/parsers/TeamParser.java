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

import me.jake0oo0.stats.TeamStat;
import me.jake0oo0.types.OvercastPlayer;
import me.jake0oo0.types.OvercastTeam;
import me.jake0oo0.types.TournamentTeam;
import me.jake0oo0.utils.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class for handling parsing of team objects
 *
 * @author Jake0oo0
 */
public class TeamParser {
    public static TournamentTeam parseTournamentTeam(String tourneyUrl, String teamName, boolean parseStats) throws ParseException {
        System.out.println("derp");
        Document doc;
        try {
            doc = Jsoup.connect(tourneyUrl)
                    .userAgent("Mozilla")
                    .get();
            List<String> teamNames = new ArrayList<String>();
            Elements names = doc.select("a[href]");
            for (Element name : names) {
                if (name.attr("href").startsWith("/teams/")) {
                    System.out.println("Team found: " + name.text());
                    teamNames.add(name.text());
                }
            }

            Elements links = doc.select("td[title]");
            int n = 0;

            for (int i = 0; i < links.size(); i += 2) {
                String name = teamNames.get(n);
                if (name.equals(teamName)) {
                    List<OvercastPlayer> players = getPlayerObjectList(links.get(i).attr("title"));
                    return new TournamentTeam(name, players, parseStats ? StatParser.parseTournamentTeam(players) : null);
                }

                n++;
            }
        } catch (IOException e) {
            throw new ParseException("Error parsing team: " + teamName);
        }
        return null;
    }

    public static List<String> parsePlayers(String s) {
        String[] arr = s.replace(", and ", ", ").replaceAll(" and ", ", ").split(", ");
        List<String> strings = new ArrayList<String>();
        Collections.addAll(strings, arr);

        return strings;
    }

    /**
     * Gets a player list, players' stats are null
     *
     * @param string string to parse
     * @return a list of overcast players parsed from the string
     */
    public static List<OvercastPlayer> getPlayerObjectList(String string) {
        List<String> strings = parsePlayers(string);
        List<OvercastPlayer> players = new ArrayList<OvercastPlayer>();
        for (String p : strings) {
            players.add(new OvercastPlayer(p, null));
        }
        return players;
    }

    /**
     * Creates an overcast team from the url
     *
     * @param url url of the player
     * @return OvercastTeam parsed
     */
    public static OvercastTeam parseOvercastTeam(String url, boolean parseStats) throws ParseException {
        Document doc;
        TeamStat stats = null;
        String name;
        List<OvercastPlayer> players = new ArrayList<OvercastPlayer>();

        try {
            doc = Jsoup.connect(url)
                    .userAgent("Mozilla")
                    .get();

            Elements title = doc.select("h1");
            name = title.first().text();
            Elements texts = doc.select("div[class]");

            if (parseStats) {
                for (Element text : texts) {
                    if (text.text().startsWith("Stats")) {
                        stats = parseTeamStatsString(text.text());
                        break;
                    }
                }
            }

            Elements playerElements = doc.select("tr").select("td").select("a");
            for (Element playerElement : playerElements) {
                players.add(new OvercastPlayer(playerElement.text()));
            }
        } catch (IOException e) {
            throw new ParseException("Error parsing OvercastTeam: " + url);
        }
        return new OvercastTeam(name, url, players, stats);
    }

    public static TeamStat parseTeamStatsString(String string) {
        String work = string;

        work = work.replace("Stats ", "").replace("Wools", "").replace("Cores", "").replace("Monuments", "")
                .replace("KK ratio", "").replace("KD ratio", "").replace("Kills", "").replace("Deaths", "").replace("  ", " ").trim();

        String[] arr = work.split(" ");

        int wools = Integer.parseInt(arr[0]);
        int cores = Integer.parseInt(arr[1]);
        int monuments = Integer.parseInt(arr[2]);
        Double kk = Double.parseDouble(arr[3]);
        Double kd = Double.parseDouble(arr[4]);
        int kills = Integer.parseInt(arr[5]);
        int deaths = Integer.parseInt(arr[6]);

        return new TeamStat(kd, kk, kills, deaths, cores, monuments, wools);
    }
}
