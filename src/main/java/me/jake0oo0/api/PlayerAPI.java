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
package me.jake0oo0.api;

import me.jake0oo0.types.OvercastPlayer;
import me.jake0oo0.utils.ParseException;

import java.io.IOException;

/**
 * Class for managing the retrieval of player objects
 *
 * @author Jake0oo0
 */
public class PlayerAPI {
    /**
     * Get an instance of an OvercastNetwork player
     *
     * @param user username
     * @return OvercastPlayer object from params
     */
    public static OvercastPlayer getPlayer(String user, boolean parseStats) throws ParseException, IOException {
        OvercastPlayer player = new OvercastPlayer(user, null);
        if (parseStats) {
            player.parseStats();
        }
        return player;
    }

    /**
     * Get a player from a URL
     *
     * @param url player's profile url
     * @return OvercastPlayer from url
     */
    public static OvercastPlayer getPlayerByUrl(String url, boolean parseStats) throws ParseException, IOException {
        String user = url.split("https://oc.tc/")[1];
        return getPlayer(user, parseStats);
    }
}
