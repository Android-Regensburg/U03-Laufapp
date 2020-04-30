package de.ur.mi.android.laufapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class StartActivity extends Activity {

    public static final String DISTANCE_KEY = "DISTANCE";
    public static final String TIME_KEY = "TIME";
    public static final String BREAK_KEY = "BREAK";

    private EditText distanceInput;
    private EditText timeInput;
    private EditText breakInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUI();
    }

    private void initUI() {
        setContentView(R.layout.activity_main);
        distanceInput = findViewById(R.id.distanceInput);
        timeInput = findViewById(R.id.timeInput);
        breakInput = findViewById(R.id.breakInput);
        Button button = findViewById(R.id.statsButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onResultButtonClicked();
            }
        });
    }

    private void onResultButtonClicked() {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra(DISTANCE_KEY, Double.parseDouble(distanceInput.getText().toString()));
        intent.putExtra(TIME_KEY, Double.parseDouble(timeInput.getText().toString()));
        intent.putExtra(BREAK_KEY, Double.parseDouble(breakInput.getText().toString()));
        startActivity(intent);
    }

}
