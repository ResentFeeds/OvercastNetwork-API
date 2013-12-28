package me.jake0oo0;

import me.jake0oo0.parsers.TournamentParser;
import me.jake0oo0.types.TournamentTeam;

public class Main {

	public static void main(String[] args) {
		for (TournamentTeam tournamentTeam : TournamentParser.getTourneyTeams("https://oc.tc/tournaments/return-of-the-hill")) {
            System.out.println(tournamentTeam.getName());

		}
	}
}
