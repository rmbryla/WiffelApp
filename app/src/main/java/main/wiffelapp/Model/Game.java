package main.wiffelapp.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Game implements Serializable {
    public enum TeamType {
        HOME, AWAY
    }
    private TeamType battingTeam;
    private String homeName;
    private String awayName;
    private String name;
    private int innings;
    private int currInning;
    private int currOuts;
    private Player atBat;
    private int currHomeBatterIndex;
    private int currAwayBatterIndex;
    private int homeScore;
    private int awayScore;
    private ArrayList<Player> homeTeam;
    private ArrayList<Player>awayTeam;

    public Game() {
        this.homeTeam = new ArrayList<>();
        this.awayTeam = new ArrayList<>();
        this.currInning = 1;
        this.currAwayBatterIndex = 0;
        this.currHomeBatterIndex = 0;
        this.battingTeam = TeamType.AWAY;
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
        this.currAwayBatterIndex = 0;
        this.currHomeBatterIndex = 0;
        this.battingTeam = TeamType.AWAY;
    }

    public Player getNextBatter() {
        return (this.battingTeam.equals(TeamType.HOME)) ? getNextHomeBatter() : getNextAwayBatter();
    }

    public Player getNextHomeBatter() {
        this.currHomeBatterIndex += 1;
        this.currHomeBatterIndex = this.currHomeBatterIndex % homeTeam.size();
        this.atBat = this.homeTeam.get(this.currHomeBatterIndex);
        return homeTeam.get(currHomeBatterIndex);
    }

    public Player getNextAwayBatter() {
        this.currAwayBatterIndex += 1;
        this.currAwayBatterIndex = this.currAwayBatterIndex % awayTeam.size();
        this.atBat = this.awayTeam.get(this.currAwayBatterIndex);
        return awayTeam.get(currAwayBatterIndex);
    }

    public void startGame() {
        this.atBat = this.awayTeam.get(0);
    }

    public void addScore(int toAdd) {
        if (this.battingTeam.equals(TeamType.HOME)) this.homeScore += toAdd;
        else this.awayScore += toAdd;
    }

    public void addOuts(int outs) {
        this.currOuts += outs;
        if (outs >= 3) {
            //TODO switch inning and batting team
        }
    }

    public ArrayList<Player> getBattingTeam() {
        return (this.battingTeam.equals(TeamType.HOME)) ? homeTeam : awayTeam;
    }

    public TeamType getBattingTeamType() {
        return battingTeam;
    }

    public int getCurrOuts() {
        return currOuts;
    }

    public int getCurrInning() {
        return currInning;
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
