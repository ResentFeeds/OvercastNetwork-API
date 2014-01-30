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

import java.util.List;

/**
 * Instance of an OvercastNetwork tournament, providing
 * required data like the teams, min players, and it's URL
 *
 * @author Jake0oo0
 */
public class OvercastTournament {
    List<TournamentTeam> teams;
    String url;
    int minPlayers;

    /**
     * Tournament instance
     *
     * @param teams      List of partaking teams
     * @param url        tourney url
     * @param minPlayers minimum players per team
     */
    public OvercastTournament(List<TournamentTeam> teams, String url, int minPlayers) {
        this.teams = teams;
        this.url = url;
        this.minPlayers = minPlayers;
    }

    public List<TournamentTeam> getTeams() {
        return teams;
    }

    public String getUrl() {
        return url;
    }

    public int getMinPlayers() {
        return minPlayers;
    }
}
