package main.wiffelapp.customviews.IncrementerDecrementer;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;

import main.wiffelapp.R;

public class incrementer_decrementer extends View {

    public incrementer_decrementer(Context context) {
        super(context);
    }

    public incrementer_decrementer(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(attrs);
    }

    public incrementer_decrementer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(attrs);
    }

    public incrementer_decrementer(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        init(attrs);
    }


    private void init(AttributeSet attrs) {
        TypedArray a=getContext().obtainStyledAttributes(
                attrs,
                R.styleable.incrementer_decrementer);

        a.recycle();
    }
}
