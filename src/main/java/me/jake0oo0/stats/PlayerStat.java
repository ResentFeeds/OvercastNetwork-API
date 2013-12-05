package me.jake0oo0.stats;

public class PlayerStat {
	Double kd;
	Double kk;
	int friends;
	int kills;
	int deaths;
	int cores;
	int monuments;
	int wools;

	public PlayerStat(Double kd, Double kk, int friends, int kills, int deaths, int cores, int monuments, int wools) {
		this.kd = kd;
		this.kk = kk;
		this.friends = friends;
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
}
