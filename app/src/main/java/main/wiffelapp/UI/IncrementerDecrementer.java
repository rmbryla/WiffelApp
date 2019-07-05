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
    int maxQuantity = Integer.MAX_VALUE;

    public IncrementerDecrementer(Context context, AttributeSet attrs) {
        super(context, attrs, 0);

        View.inflate(context, R.layout.incrementer_decrementer, this);

        plusButton = findViewById(R.id.increment_button);
        minusButton = findViewById(R.id.decrement_button);
        text =findViewById(R.id.incremental_value);

        int amount = getAmount();
        if (amount - 1 < minQunatity) {
            minusButton.setAlpha(0.3F);
            minusButton.setClickable(false);
        }

        if (amount + 1 > maxQuantity) {
            plusButton.setAlpha(0.3F);
            plusButton.setClickable(false);
        }

        plusButton.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int amount = getAmount();
                        if (amount + 1 < maxQuantity) {
                            text.setText(Integer.toString(amount + 1));
                        }
                        else {
                            plusButton.setAlpha(0.3F);
                            plusButton.setClickable(false);
                            text.setText(Integer.toString(maxQuantity));
                        }

                        minusButton.setAlpha(1.0F);
                        minusButton.setClickable(true);
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

                        plusButton.setAlpha(1.0F);
                        plusButton.setClickable(true);
                    }
                }
        );
    }

    public int getAmount(){
        return Integer.parseInt(text.getText().toString());
    }

    public void setMaxQuantity(int maxQuantity) {
        if (maxQuantity < minQunatity) return;
        this.maxQuantity = maxQuantity;
    }

    public void setAmount(int amount) {

        if (amount <= maxQuantity && amount >= minQunatity) {
            text.setText(Integer.toString(amount));
        }

        if (amount == minQunatity) {
            minusButton.setAlpha(0.3F);
            minusButton.setClickable(false);
        }

        if (amount < maxQuantity) {
            plusButton.setAlpha(1.0F);
            plusButton.setClickable(true);
        }

        if (amount == maxQuantity) {
            plusButton.setAlpha(0.3F);
            plusButton.setClickable(false);
        }

        if (amount > minQunatity) {
            minusButton.setAlpha(1.0F);
            minusButton.setClickable(true);
        }

    }
}
