package main.wiffelapp.UI.GameSelect;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import main.wiffelapp.R;
import main.wiffelapp.UI.signIn.SignInActivity;

public class GameSelectActivity extends AppCompatActivity {

    public GameSelectActivity() {
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_select);

        LinearLayout linearLayout = findViewById(R.id.game_linear_layout);

        for (int i = 0; i < 40; i++) {
            TextView textView = new TextView(getApplicationContext());
            textView.setText("Game: " + i);
            textView.setTextSize(20);
            textView.setPadding(0,5,0,5);
            linearLayout.addView(textView);
        }

        final AppCompatActivity self = this;


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);
    }
}