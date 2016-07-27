package br.com.bahiatecnologia.horizontalnumberpicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private HorizontalNumberPicker horizontalNumberPicker;
    private Button btnGetValue;
    private TextView tvValueResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        horizontalNumberPicker = (HorizontalNumberPicker) findViewById(R.id.horizontal_number_picker);
        btnGetValue = (Button) findViewById(R.id.btn_get_value);
        tvValueResult = (TextView) findViewById(R.id.tv_value_result);

        horizontalNumberPicker.setInitialValue(10);
        horizontalNumberPicker.setMinValue(0);
        horizontalNumberPicker.setMaxValue(10);

        btnGetValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvValueResult.setText(String.valueOf(horizontalNumberPicker.getValue()));
            }
        });

    }
}
