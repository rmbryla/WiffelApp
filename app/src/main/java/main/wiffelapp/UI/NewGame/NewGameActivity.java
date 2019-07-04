package main.wiffelapp.UI.NewGame;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import main.wiffelapp.Model.Game;
import main.wiffelapp.Model.Player;
import main.wiffelapp.Observers.GameHandler;
import main.wiffelapp.R;
import main.wiffelapp.UI.ConfirmGame.ConfirmGameActivity;
import main.wiffelapp.UI.CreateTeam.CreateTeamActivity;
import main.wiffelapp.UI.IncrementerDecrementer;

public class NewGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final AppCompatActivity self = this;

        setContentView(R.layout.activity_new_game);

        try {
            ((EditText) findViewById(R.id.new_game_game_name_input)).setText(GameHandler.getGame().getName());
        } catch (Exception e) {}

        try {
            String homeTeamName = GameHandler.getHomeTeamName();
            ((TextView) findViewById(R.id.home_team_name_input)).setText(homeTeamName);
        } catch (Exception e) {}

        try {
            String awayTeamName = GameHandler.getAwayTeamName();
            ((TextView) findViewById(R.id.away_team_name_input)).setText(awayTeamName);
        } catch (Exception e) {}

        try {
            int innings = GameHandler.getInnings();
            ((IncrementerDecrementer) findViewById(R.id.new_game_innings_incrementer)).setAmount(innings);
        } catch (Exception e) {}


        findViewById(R.id.create_home_team_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GameHandler.setCurrentTeam(GameHandler.TeamType.Home);
                CharSequence teamName = ((TextView) findViewById(R.id.home_team_name_input)).getText();

                try {
                    GameHandler.getCurrentTeam();
                } catch (Exception e) {
                    GameHandler.initializeNewGame();
                }

                GameHandler.setInnings(((IncrementerDecrementer) findViewById(R.id.new_game_innings_incrementer)).getAmount());

                GameHandler.setName(((TextView) findViewById(R.id.new_game_game_name_input)).getText().toString());

                GameHandler.setHomeName(teamName.toString());

                Intent intent = new Intent(self, CreateTeamActivity.class);

                startActivity(intent);
            }
        });

        findViewById(R.id.create_away_team_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GameHandler.setCurrentTeam(GameHandler.TeamType.Away);
                CharSequence teamName = ((TextView) findViewById(R.id.away_team_name_input)).getText();

                try {
                    GameHandler.getCurrentTeam();
                } catch (Exception e) {
                    GameHandler.initializeNewGame();
                }

                GameHandler.setInnings(((IncrementerDecrementer) findViewById(R.id.new_game_innings_incrementer)).getAmount());

                GameHandler.setName(((TextView) findViewById(R.id.new_game_game_name_input)).getText().toString());

                GameHandler.setAwayName(teamName.toString());

                Intent intent = new Intent(self, CreateTeamActivity.class);

                startActivity(intent);
            }
        });


        findViewById(R.id.new_game_make_finished_game_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO implement submitting a game to database
            }
        });

        findViewById(R.id.new_game_start_game_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GameHandler.setName(((TextView) findViewById(R.id.new_game_game_name_input)).getText().toString());
                GameHandler.setInnings(((IncrementerDecrementer) findViewById(R.id.new_game_innings_incrementer)).getAmount());

                Intent intent = new Intent(self, ConfirmGameActivity.class);

                startActivity(intent);
            }
        });
    }
}
