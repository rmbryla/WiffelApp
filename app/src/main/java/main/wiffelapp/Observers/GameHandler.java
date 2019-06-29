package main.wiffelapp.Observers;

import android.support.v7.app.AppCompatActivity;

import main.wiffelapp.Model.Game;
import main.wiffelapp.Model.Player;

public class GameHandler {
    private static Game game;

    public void initializeNewGame() {
        game = new Game();
    }

    public void setHomeName(String homeName) {
        game.setHomeName(homeName);
    }

    public void setAwayName(String awayName) {
        game.setAwayName(awayName);
    }

    public void setName(String name) {
        game.setName(name);
    }

    public void setHomeScore(int homeScore) {
        game.setHomeScore(homeScore);
    }

    public void setAwayScore(int awayScore) {
        game.setHomeScore(awayScore);
    }

    public void setHomeTeam(Player[] homeTeam) {
        game.setHomeTeam(homeTeam);
    }

    public void setAwayTeam(Player[] awayTeam) {
        game.setAwayTeam(awayTeam);
    }
}
