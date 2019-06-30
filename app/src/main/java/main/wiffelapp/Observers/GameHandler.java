package main.wiffelapp.Observers;

import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

import main.wiffelapp.Model.Game;
import main.wiffelapp.Model.Player;

public class GameHandler {
    private static Game game;
    private static TeamType currentTeam = TeamType.Home;
    public enum TeamType {
        Home, Away;
    }

    public static void initializeNewGame() {
        game = new Game();
    }

    public static void setHomeName(String homeName) {
        game.setHomeName(homeName);
    }

    public static void setAwayName(String awayName) {
        game.setAwayName(awayName);
    }

    public static void setName(String name) {
        game.setName(name);
    }

    public static void setHomeScore(int homeScore) {
        game.setHomeScore(homeScore);
    }

    public static void setAwayScore(int awayScore) {
        game.setHomeScore(awayScore);
    }

    public static void setHomeTeam(ArrayList<Player> homeTeam) {
        game.setHomeTeam(homeTeam);
    }

    public static void setAwayTeam(ArrayList<Player> awayTeam) {
        game.setAwayTeam(awayTeam);
    }

    public static void setCurrentTeam(TeamType currentTeam) {
        GameHandler.currentTeam = currentTeam;
    }

    public static void addPlayer(Player p) {
        if (currentTeam.equals(TeamType.Home)) {
            game.addHomePlayer(p);
        } else {
            game.addAwayPlayer(p);
        }
    }

    public static ArrayList<Player> getCurrentTeam() {
        return (currentTeam.equals(TeamType.Home) ? game.getHomeTeam() : game.getAwayTeam());
    }

    public static Game getGame() {
        return game;
    }

    public static String getCurrentTeamName() {
        return (currentTeam.equals(TeamType.Home) ? game.getHomeName() : game.getAwayName());
    }
}
