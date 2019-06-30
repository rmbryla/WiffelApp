package main.wiffelapp.UI;


import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import main.wiffelapp.R;


public class IncrementerDecrementer extends LinearLayout {

    Button plusButton;
    Button minusButton;
    EditText text;
    int minQunatity = 0;

    public IncrementerDecrementer(Context context, AttributeSet attrs) {
        super(context, attrs, 0);

        View.inflate(context, R.layout.incrementer_decrementer, this);

        plusButton = findViewById(R.id.increment_button);
        minusButton = findViewById(R.id.decrement_button);
        text =findViewById(R.id.incremental_value);

        plusButton.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int amount = getAmount();
                        text.setText(Integer.toString(amount + 1));

                        if(!minusButton.isClickable()){
                            minusButton.setAlpha(1.0F);
                            minusButton.setClickable(true);
                        }
                    }
                }
        );

        minusButton.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int amount = getAmount();
                        if(amount - 1 > minQunatity) {
                            text.setText(Integer.toString(amount - 1));
                        }
                        else{
                            minusButton.setAlpha(0.3F);
                            minusButton.setClickable(false);
                            text.setText(Integer.toString(minQunatity));
                        }
                    }
                }
        );
    }

    public int getAmount(){
        return Integer.parseInt(text.getText().toString());
    }
}
