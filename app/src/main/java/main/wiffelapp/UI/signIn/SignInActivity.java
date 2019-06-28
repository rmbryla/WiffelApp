package main.wiffelapp.UI.signIn;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import main.wiffelapp.R;
import main.wiffelapp.UI.GameSelect.GameSelectActivity;

public class SignInActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        Button login = findViewById(R.id.login_button);
        final AppCompatActivity self = this;
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(self, GameSelectActivity.class);
                startActivity(intent);
            }
        });
    }
}
