package main.wiffelapp.UI.AtBat;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import main.wiffelapp.Model.Player;
import main.wiffelapp.Observers.GameHandler;
import main.wiffelapp.R;
import main.wiffelapp.UI.IncrementerDecrementer;

public class AtBatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_at_bat);

        Player atBat = GameHandler.getAtBat();

        ((TextView) findViewById(R.id.at_bat_player_name)).setText(atBat.NAME);
        ((TextView) findViewById(R.id.at_bat_player_number)).setText(Integer.toString(atBat.PLAYER_NUMBER));

        Spinner spinner = findViewById(R.id.at_bat_play_spinner);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(getApplicationContext(),
                                                                                    R.array.at_bat_play_select,
                                                                                    android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(arrayAdapter);

        ((IncrementerDecrementer) findViewById(R.id.at_bat_rbi_incrementer)).setMaxQuantity(4);
        ((IncrementerDecrementer) findViewById(R.id.at_bat_run_incrementer)).setMaxQuantity(4);
        ((IncrementerDecrementer) findViewById(R.id.at_bat_out_incrementer)).setMaxQuantity(3);

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
                    case "SQUANTO":
                        curr.addSquanto();
                        break;
                    case "Out":
                        curr.addOut();
                        break;
                    default:
                        return;
                }

                curr.addRbis(((IncrementerDecrementer) findViewById(R.id.at_bat_run_incrementer)).getAmount());


                curr = GameHandler.getGame().getNextBatter();

                ((TextView) findViewById(R.id.at_bat_player_name)).setText(curr.NAME);
                ((TextView) findViewById(R.id.at_bat_player_number)).setText(Integer.toString(curr.PLAYER_NUMBER));

                ((IncrementerDecrementer) findViewById(R.id.at_bat_run_incrementer)).setAmount(0);
                ((IncrementerDecrementer) findViewById(R.id.at_bat_rbi_incrementer)).setAmount(0);
                ((IncrementerDecrementer) findViewById(R.id.at_bat_out_incrementer)).setAmount(0);
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
            }
        });

    }
}