package main.wiffelapp.UI.GameSelect;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

import main.wiffelapp.Model.Game;
import main.wiffelapp.Model.Player;
import main.wiffelapp.R;
import main.wiffelapp.UI.NewGame.NewGameActivity;
import main.wiffelapp.UI.signIn.SignInActivity;

public class GameSelectActivity extends AppCompatActivity {

    public GameSelectActivity() {
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_select);

        LinearLayout linearLayout = findViewById(R.id.game_linear_layout);

        ArrayList<Game> games = makeGames();

        for (Game game : games) {
            ConstraintLayout gameView = (ConstraintLayout) getLayoutInflater().inflate(R.layout.game_card, null);
            ((TextView) gameView.getViewById(R.id.game_name)).setText(game.getName());
            ((TextView) gameView.getViewById(R.id.home_team_name)).setText(game.getHomeName());
            ((TextView) gameView.getViewById(R.id.away_team_name)).setText(game.getAwayName());
            ((TextView) gameView.getViewById(R.id.home_team_score)).setText(Integer.toString(game.getHomeScore()));
            ((TextView) gameView.getViewById(R.id.away_team_score)).setText(Integer.toString(game.getAwayScore()));
            linearLayout.addView(gameView);
        }

        final AppCompatActivity self = this;

        Button newGameButton = findViewById(R.id.new_game_button);

        newGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(self, NewGameActivity.class);

                startActivity(intent);
            }
        });


    }

    private ArrayList<Game> makeGames(){
        ArrayList<Game> games = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            games.add(new Game("Game: " + Integer.toString(i), "Home", "Away", (int) (Math.random()*20), (int) (Math.random()*20), new Player[0], new Player[0]));
        }
        return games;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);
    }
}