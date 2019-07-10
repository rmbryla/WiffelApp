package main.wiffelapp.UI.AtBat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import main.wiffelapp.Model.Game;
import main.wiffelapp.Model.Player;
import main.wiffelapp.Observers.GameHandler;
import main.wiffelapp.R;
import main.wiffelapp.UI.GameStats.GameStatsActivity;
import main.wiffelapp.UI.IncrementerDecrementer;

public class AtBatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_at_bat);

        final Game game = GameHandler.getGame();

        Player atBat = GameHandler.getAtBat();

        ((TextView) findViewById(R.id.at_bat_player_name)).setText(atBat.NAME);
        ((TextView) findViewById(R.id.at_bat_player_number)).setText(Integer.toString(atBat.PLAYER_NUMBER));

        Spinner spinner = findViewById(R.id.at_bat_play_spinner);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(getApplicationContext(),
                                                                                    R.array.at_bat_play_select,
                                                                                    android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(arrayAdapter);


        final GridLayout scoreBoard = findViewById(R.id.at_bat_score_board);
        ((TextView) scoreBoard.findViewById(R.id.score_board_home_score)).setText(Integer.toString(game.getHomeScore()));
        ((TextView) scoreBoard.findViewById(R.id.score_board_away_score)).setText(Integer.toString(game.getAwayScore()));
        ((TextView) scoreBoard.findViewById(R.id.score_board_inning)).setText(Integer.toString(game.getCurrInning()));
        ((TextView) scoreBoard.findViewById(R.id.score_board_outs)).setText(Integer.toString(game.getCurrOuts()));


        ((IncrementerDecrementer) findViewById(R.id.at_bat_rbi_incrementer)).setMaxQuantity(4);
        ((IncrementerDecrementer) findViewById(R.id.at_bat_run_incrementer)).setMaxQuantity(4);
        ((IncrementerDecrementer) findViewById(R.id.at_bat_out_incrementer)).setMaxQuantity(3);

        final IncrementerDecrementer rbi_incrementer = findViewById(R.id.at_bat_rbi_incrementer);

        final IncrementerDecrementer run_incrementer = findViewById(R.id.at_bat_run_incrementer);


        run_incrementer.findViewById(R.id.decrement_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button plusButton = run_incrementer.findViewById(R.id.increment_button);
                Button minusButton = run_incrementer.findViewById(R.id.decrement_button);
                int amount = run_incrementer.getAmount();
                if (amount - 1 > run_incrementer.getMinQunatity()) {
                    run_incrementer.getText().setText(Integer.toString(amount - 1));
                }
                else {
                    minusButton.setAlpha(0.3F);
                    minusButton.setClickable(false);
                    run_incrementer.getText().setText(Integer.toString(run_incrementer.getMinQunatity()));
                }

                if (run_incrementer.getAmount() < rbi_incrementer.getAmount()) {
                    findViewById(R.id.at_bat_rbi_incrementer).findViewById(R.id.decrement_button).callOnClick();
                }

                plusButton.setAlpha(1.0F);
                plusButton.setClickable(true);
            }
        });

        (rbi_incrementer.findViewById(R.id.increment_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button plusButton = rbi_incrementer.findViewById(R.id.increment_button);
                Button minusButton = rbi_incrementer.findViewById(R.id.decrement_button);
                int amount = rbi_incrementer.getAmount();
                if (amount + 1 < rbi_incrementer.getMaxQuantity()) {
                    rbi_incrementer.getText().setText(Integer.toString(amount + 1));
                }
                else {
                    plusButton.setAlpha(0.3F);
                    plusButton.setClickable(false);
                    rbi_incrementer.getText().setText(Integer.toString(rbi_incrementer.getMaxQuantity()));
                }

                if (run_incrementer.getAmount() < rbi_incrementer.getAmount()) {
                    findViewById(R.id.at_bat_run_incrementer).findViewById(R.id.increment_button).callOnClick();
                }

                minusButton.setAlpha(1.0F);
                minusButton.setClickable(true);
            }
        });

        ((Spinner) findViewById(R.id.at_bat_play_spinner)).setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                switch (item) {
                    case "Out":
                        ((IncrementerDecrementer) findViewById(R.id.at_bat_out_incrementer)).setAmount(1);
                        ((IncrementerDecrementer) findViewById(R.id.at_bat_run_incrementer)).setAmount(0);
                        ((IncrementerDecrementer) findViewById(R.id.at_bat_rbi_incrementer)).setAmount(0);
                        break;
                    case "Home Run":
                        ((IncrementerDecrementer) findViewById(R.id.at_bat_run_incrementer)).setAmount(1);
                        ((IncrementerDecrementer) findViewById(R.id.at_bat_rbi_incrementer)).setAmount(1);
                        ((IncrementerDecrementer) findViewById(R.id.at_bat_out_incrementer)).setAmount(0);
                        break;
                    case "Grand Slam":
                        ((IncrementerDecrementer) findViewById(R.id.at_bat_run_incrementer)).setAmount(4);
                        ((IncrementerDecrementer) findViewById(R.id.at_bat_rbi_incrementer)).setAmount(4);
                        ((IncrementerDecrementer) findViewById(R.id.at_bat_out_incrementer)).setAmount(0);
                        break;
                    default:
                        ((IncrementerDecrementer) findViewById(R.id.at_bat_run_incrementer)).setAmount(0);
                        ((IncrementerDecrementer) findViewById(R.id.at_bat_rbi_incrementer)).setAmount(0);
                        ((IncrementerDecrementer) findViewById(R.id.at_bat_out_incrementer)).setAmount(0);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });



        findViewById(R.id.at_bat_next_player_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Player curr = GameHandler.getAtBat();
                switch(((Spinner) findViewById(R.id.at_bat_play_spinner)).getSelectedItem().toString()) {
                    case "Single":
                        curr.addSingle();
                        break;
                    case "Double":
                        curr.addDouble();
                        break;
                    case "Triple":
                        curr.addTriple();
                        break;
                    case "Home Run":
                        curr.addHomeRun();
                        break;
                    case "Grand Slam":
                        curr.addGrandSlam();
                        break;
                    case "Ground Roll Double":
                        curr.addGroundRollDouble();
                        break;
                    case "Squanto":
                        curr.addSquanto();
                        break;
                    case "Out":
                        curr.addOut();
                        break;
                    default:
                        return;
                }

                curr.addRbis(((IncrementerDecrementer) findViewById(R.id.at_bat_rbi_incrementer)).getAmount());

                GameHandler.getGame().addOuts(((IncrementerDecrementer) findViewById(R.id.at_bat_out_incrementer)).getAmount());
                GameHandler.getGame().addScore(((IncrementerDecrementer) findViewById(R.id.at_bat_run_incrementer)).getAmount());

                curr = GameHandler.getGame().getNextBatter();

                ((TextView) findViewById(R.id.at_bat_player_name)).setText(curr.NAME);
                ((TextView) findViewById(R.id.at_bat_player_number)).setText(Integer.toString(curr.PLAYER_NUMBER));

                ((IncrementerDecrementer) findViewById(R.id.at_bat_run_incrementer)).setAmount(0);
                ((IncrementerDecrementer) findViewById(R.id.at_bat_rbi_incrementer)).setAmount(0);
                ((IncrementerDecrementer) findViewById(R.id.at_bat_out_incrementer)).setAmount(0);

                int maxOuts = 3 - GameHandler.getGame().getCurrOuts();

                ((IncrementerDecrementer) findViewById(R.id.at_bat_out_incrementer)).setMaxQuantity(maxOuts);


                ((Spinner) findViewById(R.id.at_bat_play_spinner)).setSelection(0);

                ((TextView) scoreBoard.findViewById(R.id.score_board_home_score)).setText(Integer.toString(game.getHomeScore()));
                ((TextView) scoreBoard.findViewById(R.id.score_board_away_score)).setText(Integer.toString(game.getAwayScore()));
                ((TextView) scoreBoard.findViewById(R.id.score_board_inning)).setText(Integer.toString(game.getCurrInning()));
                ((TextView) scoreBoard.findViewById(R.id.score_board_outs)).setText(Integer.toString(game.getCurrOuts()));
            }
        });


        findViewById(R.id.at_bat_skip_batter_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Player curr = GameHandler.getGame().getNextBatter();

                ((TextView) findViewById(R.id.at_bat_player_name)).setText(curr.NAME);
                ((TextView) findViewById(R.id.at_bat_player_number)).setText(Integer.toString(curr.PLAYER_NUMBER));

                ((IncrementerDecrementer) findViewById(R.id.at_bat_run_incrementer)).setAmount(0);
                ((IncrementerDecrementer) findViewById(R.id.at_bat_rbi_incrementer)).setAmount(0);
                ((IncrementerDecrementer) findViewById(R.id.at_bat_out_incrementer)).setAmount(0);

                ((Spinner) findViewById(R.id.at_bat_play_spinner)).setSelection(0);
            }
        });

        final AppCompatActivity self = this;

        findViewById(R.id.at_bat_score_board).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(self, GameStatsActivity.class);

                startActivity(intent);
            }
        });

    }
}