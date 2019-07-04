package main.wiffelapp.UI.CreatePlayer;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import main.wiffelapp.R;
import main.wiffelapp.UI.IncrementerDecrementer;

public class CreatePlayerInfoWidget extends ConstraintLayout {

    private Button doneButton;
    private Spinner categorySelecor;
    private IncrementerDecrementer stepper;
    private LinearLayout allInfo;

    public CreatePlayerInfoWidget(final Context context, AttributeSet attrs) {
        super(context, attrs, 0);

        View.inflate(context, R.layout.create_player_info_box, this);

        categorySelecor = (Spinner) findViewById(R.id.create_player_info_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context,
                R.array.player_info_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySelecor.setAdapter(adapter);

        doneButton = findViewById(R.id.create_player_info_done);
        stepper = findViewById(R.id.info_incrementer);

        doneButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                CreatePlayerCompletedInfoWidget completedInfo = new CreatePlayerCompletedInfoWidget(context);

                completedInfo.infoText.setText(categorySelecor.getSelectedItem().toString());
                completedInfo.infoText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
                completedInfo.stepper.setAmount(stepper.getAmount());

                allInfo.addView(completedInfo);
            }
        });
    }

    public void setAllInfo(LinearLayout allInfo) {
        this.allInfo = allInfo;
    }
}
