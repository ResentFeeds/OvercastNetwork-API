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
 * Created by jake on 12/28/13.
 */
public class TournamentParser {
    public static List<TournamentTeam> getTourneyTeams(String url, boolean parseStats) throws IOException {
        List<TournamentTeam> tournamentTeams = new ArrayList<TournamentTeam>();
        Document doc;
        doc = Jsoup.connect(url)
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
            List<OvercastPlayer> players = TeamParser.getPlayerObjectList(links.get(i).attr("title"));
            tournamentTeams.add(new TournamentTeam(name, players, parseStats ? StatParser.parseTournamentTeam(players) : null));
            n++;
        }
        return tournamentTeams;
    }
}
