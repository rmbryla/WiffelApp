package main.wiffelapp.UI.CreatePlayer;

import android.app.Activity;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import main.wiffelapp.R;
import main.wiffelapp.UI.IncrementerDecrementer;

public class CreatePlayerInfoWidget extends ConstraintLayout {

    private Button doneButton;
    private Spinner categorySelecor;
    private IncrementerDecrementer stepper;
    private LinearLayout allInfo;
    private ArrayAdapter adapter;
    private CreatePlayerActivity activity;

    public CreatePlayerInfoWidget(final Context context, AttributeSet attrs) {
        super(context, attrs, 0);

        View.inflate(context, R.layout.create_player_info_box, this);

        categorySelecor = (Spinner) findViewById(R.id.create_player_info_spinner);

        ArrayList<CharSequence> spinnerItems = new ArrayList<>();

        for (CharSequence item : getResources().getStringArray(R.array.player_info_options)){
            spinnerItems.add(item);
        }

        adapter = new ArrayAdapter(context, android.R.layout.simple_spinner_item, spinnerItems);
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
                adapter.remove(categorySelecor.getSelectedItem());
                adapter.notifyDataSetChanged();

                stepper.setAmount(0);

                if (adapter.isEmpty()) {
                    activity.removeWidget();
                }
            }
        });
    }

    public void setAllInfo(LinearLayout allInfo) {
        this.allInfo = allInfo;
    }

    public void setActivity(CreatePlayerActivity activity) {this.activity = activity;}

}
