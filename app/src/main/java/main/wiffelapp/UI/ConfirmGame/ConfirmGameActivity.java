package main.wiffelapp.UI.ConfirmGame;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import main.wiffelapp.Model.Game;
import main.wiffelapp.Model.Player;
import main.wiffelapp.Observers.GameHandler;
import main.wiffelapp.R;
import main.wiffelapp.UI.AtBat.AtBatActivity;

public class ConfirmGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_confirm_game);

        final AppCompatActivity self = this;

        ArrayList<Player> homeTeamList = GameHandler.getHomeTeam();
        ArrayList<Player> awayTeamList = GameHandler.getAwayTeam();
        String gameName = GameHandler.getGame().getName();
        String homeTeamName = GameHandler.getHomeTeamName();
        String awayTeamName = GameHandler.getAwayTeamName();

        ((EditText) findViewById(R.id.confirm_game_game_name)).setText(gameName);
        ((EditText) findViewById(R.id.confirm_game_away_team_name)).setText(awayTeamName);
        ((EditText) findViewById(R.id.confirm_game_home_team_name)).setText(homeTeamName);

        LinearLayout homeTeamLinearLayout = findViewById(R.id.confirm_game_home_team_linear_layout);
        LinearLayout awayTeamLinearLayout = findViewById(R.id.confirm_game_away_team_linear_layout);

        for (Player p : homeTeamList) {
            ConstraintLayout playerView = (ConstraintLayout) getLayoutInflater().inflate(R.layout.player_summary_card, null);

            ((TextView) playerView.findViewById(R.id.player_summary_card_player_name)).setText(p.NAME);
            ((TextView) playerView.findViewById(R.id.player_summary_card_player_number)).setText(Integer.toString(p.PLAYER_NUMBER));

            homeTeamLinearLayout.addView(playerView);
        }

        for (Player p : awayTeamList) {
            ConstraintLayout playerView = (ConstraintLayout) getLayoutInflater().inflate(R.layout.player_summary_card, null);

            ((TextView) playerView.findViewById(R.id.player_summary_card_player_name)).setText(p.NAME);
            ((TextView) playerView.findViewById(R.id.player_summary_card_player_number)).setText(Integer.toString(p.PLAYER_NUMBER));

            awayTeamLinearLayout.addView(playerView);
        }




        findViewById(R.id.confirm_game_start_game_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Game game = GameHandler.getGame();

                String homeTeamName = ((EditText) findViewById(R.id.confirm_game_home_team_name)).getText().toString();
                if (homeTeamName.equals("")) {
                    ((EditText) findViewById(R.id.confirm_game_home_team_name)).setHintTextColor(Color.RED);
                    return;
                } else game.setHomeName(homeTeamName);
                String awayTeamName = ((EditText) findViewById(R.id.confirm_game_away_team_name)).getText().toString();
                if (awayTeamName.equals("")) {
                    ((EditText) findViewById(R.id.confirm_game_away_team_name)).setHintTextColor(Color.RED);
                    return;
                } else game.setAwayName(awayTeamName);
                String gameName = ((EditText) findViewById(R.id.confirm_game_game_name)).getText().toString();
                if (gameName.equals("")) {
                    ((EditText) findViewById(R.id.confirm_game_game_name)).setHintTextColor(Color.RED);
                    return;
                } else game.setName(gameName);


                GameHandler.startGame();

                Intent intent = new Intent(self, AtBatActivity.class);

                startActivity(intent);
            }
        });

    }
}
