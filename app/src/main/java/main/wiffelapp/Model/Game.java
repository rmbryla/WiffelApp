package main.wiffelapp.Model;

import java.util.ArrayList;

public class Game {
    private String homeName;
    private String awayName;
    private String name;
    private int homeScore;
    private int awayScore;
    private ArrayList<Player> homeTeam;
    private ArrayList<Player>awayTeam;

    public Game() {
        this.homeTeam = new ArrayList<>();
        this.awayTeam = new ArrayList<>();
    }

    public Game(String name, String homeName, String awayName, int homeScore, int awayScore, ArrayList<Player> homeTeam, ArrayList<Player> awayTeam) {
        this.name = name;
        this.homeName = homeName;
        this.awayName = awayName;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
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
}
