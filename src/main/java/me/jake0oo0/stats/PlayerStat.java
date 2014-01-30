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
package me.jake0oo0.stats;

/**
 * Instance of an OvercastPlayer's stats
 *
 * @author Jake0oo0
 */
public class PlayerStat {
    Double kd;
    Double kk;
    int raindrops;
    int friends;
    int kills;
    int deaths;
    int cores;
    int monuments;
    int wools;

    /**
     * A player's stats
     *
     * @param kd        player's kill to death ratio
     * @param kk        player's kill to kill ratio
     * @param friends   number of friends
     * @param kills     number of kills
     * @param deaths    number of deaths
     * @param cores     number of cores
     * @param monuments number of monuments
     * @param wools     number of wools
     */
    public PlayerStat(Double kd, Double kk, int raindrops, int friends, int kills, int deaths, int cores, int monuments, int wools) {
        this.kd = kd;
        this.kk = kk;
        this.friends = friends;
        this.raindrops = raindrops;
        this.kills = kills;
        this.deaths = deaths;
        this.cores = cores;
        this.monuments = monuments;
        this.wools = wools;
    }

    public Double getKd() {
        return kd;
    }

    public Double getKk() {
        return kk;
    }

    public int getFriends() {
        return friends;
    }

    public int getKills() {
        return kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public int getCores() {
        return cores;
    }

    public int getMonuments() {
        return monuments;
    }

    public int getWools() {
        return wools;
    }

    public int getRaindrops() {
        return raindrops;
    }
}
