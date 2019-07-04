package main.wiffelapp.UI.AtBat;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Spinner;
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

        //(Spinner) findViewById(R.id.at_bat_play_spinner))

        ((IncrementerDecrementer) findViewById(R.id.at_bat_rbi_incrementer)).setMaxQuantity(4);
        ((IncrementerDecrementer) findViewById(R.id.at_bat_run_incrementer)).setMaxQuantity(4);
        ((IncrementerDecrementer) findViewById(R.id.at_bat_out_incrementer)).setMaxQuantity(3);

    }
}
