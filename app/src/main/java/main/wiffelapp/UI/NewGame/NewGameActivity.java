package main.wiffelapp.UI.NewGame;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import main.wiffelapp.Model.Game;
import main.wiffelapp.Observers.GameHandler;
import main.wiffelapp.R;
import main.wiffelapp.UI.CreateTeam.CreateTeamActivity;

public class NewGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final AppCompatActivity self = this;

        setContentView(R.layout.activity_new_game);

        findViewById(R.id.create_home_team_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GameHandler.setCurrentTeam(GameHandler.TeamType.Home);
                CharSequence teamName = ((TextView) findViewById(R.id.home_team_name_input)).getText();
                GameHandler.initializeNewGame();

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
                GameHandler.initializeNewGame();

                GameHandler.setAwayName(teamName.toString());

                Intent intent = new Intent(self, CreateTeamActivity.class);

                startActivity(intent);
            }
        });
    }
}