package br.com.bahiatecnologia.horizontalnumberpicker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by danielreis on 7/27/16.
 */
public class HorizontalNumberPicker extends LinearLayout {
        private Button nextButton;
        private Button prevButton;
        private TextView tvNumber;

        private int value;
        private int maxValue;
        private int minValue;

        public HorizontalNumberPicker(Context context) {
        super(context);
        initialize(context);
    }

        public HorizontalNumberPicker(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context);
    }

        public HorizontalNumberPicker(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize(context);
    }

    private void initialize(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.horizontal_number_picker, this);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        nextButton = (Button) this.findViewById(R.id.hnp_btn_next);
        prevButton = (Button) this.findViewById(R.id.hnp_btn_prev);
        tvNumber = (TextView) this.findViewById(R.id.hnp_tv_number);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setValue(getValue()+1);
            }
        });

        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setValue(getValue()-1);
            }
        });
    }

    public int getMaxValue() {
        return maxValue;
    }

    public int getMinValue() {
        return minValue;
    }

    public int getValue() {
        return value;
    }

    public void setMaxValue(int value) {
        this.maxValue = value;
        setValue(getValue());
    }

    public void setMinValue(int value){
        this.minValue = value;
        setValue(getValue());
    }

    public void setInitialValue(int value) {
        this.value = value;
        setValue(value);
    }

    private void setValue(int value){
        tvNumber.setText(String.valueOf(value));
        this.value = value;

        if(getValue() == getMinValue())
            prevButton.setEnabled(false);
        else
            prevButton.setEnabled(true);

        if(getValue() == getMaxValue())
            nextButton.setEnabled(false);
        else
            nextButton.setEnabled(true);

    }

}