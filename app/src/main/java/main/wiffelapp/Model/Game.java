package main.wiffelapp.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Game implements Serializable {
    private String homeName;
    private String awayName;
    private String name;
    private int innings;
    private int currInning;
    private Player atBat;
    private int homeScore;
    private int awayScore;
    private ArrayList<Player> homeTeam;
    private ArrayList<Player>awayTeam;

    public Game() {
        this.homeTeam = new ArrayList<>();
        this.awayTeam = new ArrayList<>();
    }

    public Game(String homeName, String awayName, String name, int innings, int homeScore, int awayScore, ArrayList<Player> homeTeam, ArrayList<Player> awayTeam) {
        this.homeName = homeName;
        this.awayName = awayName;
        this.name = name;
        this.innings = innings;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.currInning = 1;
        this.atBat = (this.awayTeam.isEmpty()) ? null : awayTeam.get(0);
    }


    public void startGame() {
        this.atBat = this.awayTeam.get(0);
    }


    public String getHomeName() {
        return homeName;
    }

    public String getName() {
        return name;
    }

    public String getAwayName() {
        return awayName;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public ArrayList<Player> getHomeTeam() {
        return homeTeam;
    }

    public ArrayList<Player> getAwayTeam() {
        return awayTeam;
    }

    public int getInnings() {
        return innings;
    }

    public Player getAtBat() {
        return atBat;
    }

    public void setHomeName(String homeName) {
        this.homeName = homeName;
    }

    public void setAwayName(String awayName) {
        this.awayName = awayName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }

    public void setHomeTeam(ArrayList<Player> homeTeam) {
        this.homeTeam = homeTeam;
    }

    public void setAwayTeam(ArrayList<Player> awayTeam) {
        this.awayTeam = awayTeam;
    }

    public void addHomePlayer(Player p) {
        this.homeTeam.add(p);
    }

    public void addAwayPlayer(Player p) {
        this.awayTeam.add(p);
    }

    public void setInnings(int innings) {
        this.innings = innings;
    }
}
