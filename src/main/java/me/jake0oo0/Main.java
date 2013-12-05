package me.jake0oo0;

import me.jake0oo0.parsers.TeamParser;
import me.jake0oo0.types.OvercastPlayer;

public class Main {

	public static void main(String[] args) {
		for (OvercastPlayer player : TeamParser.parseOvercastTeam("https://oc.tc/teams/5296ab1aaf7fb0857900329b").getPlayers()) {
			System.out.println(player.getUsername());
		}
	}
}
