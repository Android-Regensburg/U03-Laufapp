package de.ur.mi.android.laufapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    private TextView distanceResult;
    private TextView paceResult;
    private TextView caloriesResult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUI();
        showResults();
    }

    private void initUI() {
        setContentView(R.layout.activity_result);
        distanceResult = findViewById(R.id.distanceResultView);
        paceResult = findViewById(R.id.paceResultView);
        caloriesResult = findViewById(R.id.caloriesResultView);
    }

    private void showResults() {
        StatsHelper helper = new StatsHelper();
        Bundle extra = getIntent().getExtras();
        helper.setDistance(extra.getDouble(StartActivity.DISTANCE_KEY));
        helper.setTime(extra.getDouble(StartActivity.TIME_KEY));
        helper.setBreakTime(extra.getDouble(StartActivity.BREAK_KEY));
        distanceResult.setText(String.valueOf(extra.getDouble(StartActivity.DISTANCE_KEY)));
        caloriesResult.setText(String.valueOf(helper.getBurnedKilocalories()));
        int minutes = (int) helper.getPace();
        int seconds = (int) ((helper.getPace() - minutes) * 60);
        paceResult.setText(minutes + ":" + seconds);
    }
}
