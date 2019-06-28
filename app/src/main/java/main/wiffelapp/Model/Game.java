package main.wiffelapp.Model;

public class Game {
    private String homeName;
    private String awayName;
    private int homeScore;
    private int awayScore;
    Player[] homeTeam;
    Player[] awayTeam;

    public Game(String homeName, String awayName, int homeScore, int awayScore, Player[] homeTeam, Player[] awayTeam) {
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

    public String getAwayName() {
        return awayName;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public Player[] getHomeTeam() {
        return homeTeam;
    }

    public Player[] getAwayTeam() {
        return awayTeam;
    }
}
