package main.wiffelapp.Model;

public class Game {
    private String homeName;
    private String awayName;
    private String name;
    private int homeScore;
    private int awayScore;
    Player[] homeTeam;
    Player[] awayTeam;

    public Game() {
    }

    public Game(String name, String homeName, String awayName, int homeScore, int awayScore, Player[] homeTeam, Player[] awayTeam) {
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

    public Player[] getHomeTeam() {
        return homeTeam;
    }

    public Player[] getAwayTeam() {
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

    public void setHomeTeam(Player[] homeTeam) {
        this.homeTeam = homeTeam;
    }

    public void setAwayTeam(Player[] awayTeam) {
        this.awayTeam = awayTeam;
    }
}
