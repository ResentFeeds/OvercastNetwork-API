package me.jake0oo0.stats;

/**
 * Created by jake on 12/4/13.
 */
public class TeamStat {
	Double kd;
	Double kk;
	int kills;
	int deaths;
	int cores;
	int monuments;
	int wools;

	public TeamStat(Double kd, Double kk, int kills, int deaths, int cores, int monuments, int wools) {
		this.kd = kd;
		this.kk = kk;
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
}
