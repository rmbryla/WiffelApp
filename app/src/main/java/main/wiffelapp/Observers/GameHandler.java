package main.wiffelapp.Observers;

import android.support.v7.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import main.wiffelapp.Model.Game;
import main.wiffelapp.Model.Player;

public class GameHandler {
    private static Game game;
    public static Game.TeamType addingTo;

    public static void saveGame() {
        try {
            FileOutputStream fos = new FileOutputStream("gameAutoSave.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fos);

            objectOutputStream.writeObject(game);
        } catch (IOException e) {}
    }

    public static boolean loadGame() {
        try {
            FileInputStream fileInputStream = new FileInputStream("gameAutoSave.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            game = (Game) objectInputStream.readObject();
            return true;
        } catch (IOException | ClassNotFoundException e) {
            return false;
        }
    }

    public static String getCurrentTeamName() {
        return (addingTo.equals(Game.TeamType.HOME)) ? game.getHomeName() : game.getAwayName();
    }

    public static void startGame() {
        game.startGame();
    }

    public static Player getAtBat() {
        return game.getAtBat();
    }

    public static void initializeNewGame() {
        game = new Game();
    }

    public static void setHomeName(String homeName) {
        game.setHomeName(homeName);
    }

    public static void setInnings(int innings) {
        game.setInnings(innings);
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

    public static void addHomeScore(int toAdd) {
        game.setHomeScore(game.getHomeScore() + toAdd);
    }

    public static void addAwayScore(int toAdd) {
        game.setAwayScore(game.getAwayScore() + toAdd);
    }

    public static void setHomeTeam(ArrayList<Player> homeTeam) {
        game.setHomeTeam(homeTeam);
    }

    public static void setAwayTeam(ArrayList<Player> awayTeam) {
        game.setAwayTeam(awayTeam);
    }


    public static void addPlayer(Player p) {
        if (addingTo.equals(Game.TeamType.HOME)) {
            game.addHomePlayer(p);
        } else {
            game.addAwayPlayer(p);
        }
    }

    public static ArrayList<Player> getCurrentTeam() {
        return (addingTo.equals(Game.TeamType.HOME)) ? game.getHomeTeam() : game.getAwayTeam();
    }

    public static ArrayList<Player> getHomeTeam() {
        return game.getHomeTeam();
    }

    public static ArrayList<Player> getAwayTeam() {
        return game.getAwayTeam();
    }

    public static Game getGame() {
        return game;
    }

    public static String getHomeTeamName() {
        return game.getHomeName();
    }

    public static String getAwayTeamName() {
        return game.getAwayName();
    }


    public static int getInnings() {
        return game.getInnings();
    }
}
