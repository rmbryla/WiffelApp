package main.wiffelapp.UI.GameStats;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridLayout;
import android.widget.GridView;
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
            ConstraintLayout playerView = makePlayerDetailsCard(p, R.layout.player_details_card);

            homeTeamLinearLayout.addView(playerView);
        }

        for (Player p : awayTeam) {
            ConstraintLayout playerView = makePlayerDetailsCard(p, R.layout.player_details_card);

            awayTeamLinearLayout.addView(playerView);
        }

    }



    private ConstraintLayout makePlayerDetailsCard(Player p, int id) {
        ConstraintLayout playerView = (ConstraintLayout) getLayoutInflater().inflate(id, null);
        playerView.setPadding(16, 8, 0, 8);

        ((TextView) playerView.findViewById(R.id.player_details_player_name_text)).setText(p.NAME);
        ((TextView) playerView.findViewById(R.id.player_details_player_number_text)).setText(Integer.toString(p.PLAYER_NUMBER));
        ((TextView) playerView.findViewById(R.id.player_details_singles_text)).setText("S : " + p.getSingles());
        ((TextView) playerView.findViewById(R.id.player_details_doubles_text)).setText("D : " + p.getDoubles());
        ((TextView) playerView.findViewById(R.id.player_details_triples_text)).setText("T : " + p.getTriples());
        ((TextView) playerView.findViewById(R.id.player_details_home_runs_text)).setText("HR : " + p.getHomeRuns());
        ((TextView) playerView.findViewById(R.id.player_details_grand_slams_text)).setText("GS : " + p.getGrandSlams());
        ((TextView) playerView.findViewById(R.id.player_details_ground_roll_doubles_text)).setText("GRD : " + p.getGroundRollDoubles());
        ((TextView) playerView.findViewById(R.id.player_details_squantos_text)).setText("SQ : " + p.getSquantos());
        ((TextView) playerView.findViewById(R.id.player_details_outs_text)).setText("O : " + p.getOuts());
        ((TextView) playerView.findViewById(R.id.player_details_rbis_text)).setText("RBIs : " + p.getRbis());

        return playerView;

    }

}
