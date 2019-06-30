package main.wiffelapp.UI.CreatePlayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import main.wiffelapp.Model.Player;
import main.wiffelapp.Observers.GameHandler;
import main.wiffelapp.R;
import main.wiffelapp.UI.CreateTeam.CreateTeamActivity;

public class CreatePlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_create_player);

        final AppCompatActivity self = this;

        findViewById(R.id.create_player_done_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = ((TextView) findViewById(R.id.create_player_player_name)).getText().toString();
                int number = Integer.parseInt(((TextView) findViewById(R.id.create_player_player_number)).getText().toString());

                GameHandler.addPlayer(new Player(name, number));

                Intent intent = new Intent(self, CreateTeamActivity.class);

                startActivity(intent);
            }
        });

    }
}
