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
import me.jake0oo0.stats.PlayerStat;
import me.jake0oo0.utils.ParseException;

import java.io.IOException;

/**
 * Instance of an OvercastNetwork player, saves stats and username
 *
 * @author Jake0oo0
 */
public class OvercastPlayer {
    String username;
    PlayerStat stats;

    /**
     * OvercastNetwork player instance
     *
     * @param username player's username
     * @param stats    player's stats
     */
    public OvercastPlayer(String username, PlayerStat stats) {
        this.username = username;
        this.stats = stats;
    }

    public OvercastPlayer(String username) throws ParseException, IOException {
        this.username = username;
        parseStats();
    }

    public void parseStats() throws ParseException, IOException {
        this.stats = StatParser.parsePlayerStats(getUsername());
    }

    public String getUsername() {
        return username;
    }

    public PlayerStat getStats() throws ParseException, IOException {
        if (this.stats == null) {
            parseStats();
        }
        return stats;
    }
}
