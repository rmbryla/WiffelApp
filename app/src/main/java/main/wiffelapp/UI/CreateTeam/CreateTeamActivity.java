package main.wiffelapp.UI.CreateTeam;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

import main.wiffelapp.Model.Player;
import main.wiffelapp.Observers.GameHandler;
import main.wiffelapp.R;

public class CreateTeamActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_create_team);

        ((TextView) findViewById(R.id.team_name_create_screen)).setText(GameHandler.getCurrentTeamName());

        ArrayList<Player> teamList = GameHandler.getCurrentTeam();

        //TODO delete later
        teamList = new ArrayList<>();
        for (int i = 0; i < 50; i ++) {
            teamList.add(new Player("Player " + i, (int) (Math.random()*100)));
        }

        LinearLayout curentPlayerList = findViewById(R.id.create_batting_order_linear_layout);


        for (Player p : teamList) {
            ConstraintLayout playerView = (ConstraintLayout) getLayoutInflater().inflate(R.layout.player_summary_card, null);
            ((TextView) playerView.findViewById(R.id.player_name_create_team_screen)).setText(p.NAME);
            ((TextView) playerView.findViewById(R.id.player_number_create_team_screen)).setText(Integer.toString( p.PLAYER_NUMBER));
            curentPlayerList.addView(playerView);
        }


        findViewById(R.id.add_player_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // go to new view with screen to make player
            }
        });

    }

}
