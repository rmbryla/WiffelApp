package main.wiffelapp.UI.GameStats;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import main.wiffelapp.Model.Player;
import main.wiffelapp.Observers.GameHandler;
import main.wiffelapp.R;

public class GameStatsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_game_stats_page);


        LinearLayout homeTeamLinearLayout = findViewById(R.id.game_stats_home_team_linear_layout);
        LinearLayout awayTeamLinearLayout = findViewById(R.id.game_stats_away_team_linear_layout);

        ArrayList<Player> homeTeam = GameHandler.getHomeTeam();
        ArrayList<Player> awayTeam = GameHandler.getAwayTeam();

        for (Player p : homeTeam) {
            ConstraintLayout playerView = (ConstraintLayout) getLayoutInflater().inflate(R.layout.player_summary_card, null);

            ((TextView) playerView.findViewById(R.id.player_summary_card_player_name)).setText(p.NAME);
            ((TextView) playerView.findViewById(R.id.player_summary_card_player_number)).setText(Integer.toString(p.PLAYER_NUMBER));

            homeTeamLinearLayout.addView(playerView);
        }

        for (Player p : awayTeam) {
            ConstraintLayout playerView = (ConstraintLayout) getLayoutInflater().inflate(R.layout.player_summary_card, null);

            ((TextView) playerView.findViewById(R.id.player_summary_card_player_name)).setText(p.NAME);
            ((TextView) playerView.findViewById(R.id.player_summary_card_player_number)).setText(Integer.toString(p.PLAYER_NUMBER));

            awayTeamLinearLayout.addView(playerView);
        }

    }
}
