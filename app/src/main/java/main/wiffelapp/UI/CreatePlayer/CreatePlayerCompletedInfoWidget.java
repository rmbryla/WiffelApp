package main.wiffelapp.UI.CreatePlayer;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.TextView;

import main.wiffelapp.R;
import main.wiffelapp.UI.IncrementerDecrementer;

public class CreatePlayerCompletedInfoWidget extends ConstraintLayout {

    TextView infoText;
    IncrementerDecrementer stepper;

    public CreatePlayerCompletedInfoWidget(Context context) {
        super(context);
        View.inflate(context, R.layout.create_player_completed_info_widget, this);
        infoText = findViewById(R.id.completed_info_text);
        stepper = findViewById(R.id.completed_info_stepper);
    }
}
