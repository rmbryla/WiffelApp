package main.wiffelapp.UI.CreatePlayer;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import main.wiffelapp.Model.Player;
import main.wiffelapp.Observers.GameHandler;
import main.wiffelapp.R;
import main.wiffelapp.UI.CreateTeam.CreateTeamActivity;
import main.wiffelapp.UI.IncrementerDecrementer;

public class CreatePlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_create_player);

        final AppCompatActivity self = this;

        findViewById(R.id.create_player_done_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name;
                try {
                    name = ((TextView) findViewById(R.id.create_player_player_name)).getText().toString();
                    if (name.equals("")) {
                        ((TextView) findViewById(R.id.create_player_player_name)).setHintTextColor(Color.RED);
                        return;
                    }
                }
                catch (Exception e) {
                    ((TextView) findViewById(R.id.create_player_player_name)).setHintTextColor(Color.RED);
                    return;
                }

                int number;
                try {
                    number = Integer.parseInt(((TextView) findViewById(R.id.create_player_player_number)).getText().toString());
                } catch (Exception e) {
                    ((TextView) findViewById(R.id.create_player_player_number)).setHintTextColor(Color.RED);
                    return;
                }

                int singles = ((IncrementerDecrementer) findViewById(R.id.create_player_singles_incrementer)).getAmount();
                int doubles = ((IncrementerDecrementer) findViewById(R.id.create_player_doubles_incrementer)).getAmount();
                int triples = ((IncrementerDecrementer) findViewById(R.id.create_player_triples_incrementer)).getAmount();
                int homeRuns = ((IncrementerDecrementer) findViewById(R.id.create_player_home_run_incrementer)).getAmount();
                int grd = ((IncrementerDecrementer) findViewById(R.id.create_player_ground_roll_doubles_incrementer)).getAmount();
                int gs = ((IncrementerDecrementer) findViewById(R.id.create_player_grand_slam_incrementer)).getAmount();
                int squantos = ((IncrementerDecrementer) findViewById(R.id.create_player_squanto_incrementer)).getAmount();
                int outs = ((IncrementerDecrementer) findViewById(R.id.create_player_out_incrementer)).getAmount();
                int rbis = ((IncrementerDecrementer) findViewById(R.id.create_player_rbi_incrementer)).getAmount();
                int hits = singles + doubles + triples + homeRuns + grd + gs + squantos;



                GameHandler.addPlayer(new Player(name, number, hits, singles, doubles,
                                                 triples, homeRuns, gs, grd, squantos, rbis, 0, outs));


                Intent intent = new Intent(self, CreateTeamActivity.class);

                startActivity(intent);
            }
        });

    }
}
