package main.wiffelapp.UI.CreatePlayer;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.HashMap;

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
        final LinearLayout allInfo = (LinearLayout) findViewById(R.id.create_player_info);

        ((CreatePlayerInfoWidget) findViewById(R.id.create_player_current_info)).setAllInfo(allInfo);
        ((CreatePlayerInfoWidget) findViewById(R.id.create_player_current_info)).setActivity(this);

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

                createPlayer(name, number, allInfo);

                Intent intent = new Intent(self, CreateTeamActivity.class);

                startActivity(intent);
            }
        });

    }

    private void createPlayer(String name, int number, LinearLayout allInfo){
        HashMap<String, Integer> infoValueMap = new HashMap<>();

        for(CharSequence category : getResources().getStringArray(R.array.player_info_options)){
            infoValueMap.put(category.toString(), 0);
        }

        for(int i = 1 ; i < allInfo.getChildCount() ; i++){
            CreatePlayerCompletedInfoWidget info = (CreatePlayerCompletedInfoWidget) allInfo.getChildAt(i);
            infoValueMap.put(info.infoText.getText().toString(), info.stepper.getAmount());
        }

        GameHandler.addPlayer(new Player(name, number, infoValueMap.get("Singles"), infoValueMap.get("Doubles"),
                infoValueMap.get("Triples"), infoValueMap.get("Home Runs"), infoValueMap.get("Grand Slams"), infoValueMap.get("Ground Roll Doubles"),
                infoValueMap.get("SQUANTO"), infoValueMap.get("RBIs"), 0, infoValueMap.get("Outs")));
    }

    public void removeWidget(){
        ((CreatePlayerInfoWidget) findViewById(R.id.create_player_current_info)).setVisibility(View.GONE);
    }
}
