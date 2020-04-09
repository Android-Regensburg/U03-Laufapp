package de.ur.mi.android.laufapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.core.app.NavUtils;


public class ResultActivity extends Activity {

    private TextView resultPace, resultKCal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultPace = (TextView) findViewById(R.id.text_result_pace);
        resultKCal = (TextView) findViewById(R.id.text_result_kcal);

        getExtras();
    }

    private void getExtras() {
        int km = getIntent().getExtras().getInt(Constants.KEY_KM);
        int time = getIntent().getExtras().getInt(Constants.KEY_TIME);
        int pauses = getIntent().getExtras().getInt(Constants.KEY_PAUSES);

        calculateResult(km, time, pauses);
    }

    private void calculateResult(int km, int time, int pauses) {

        Calculator calc = new Calculator();

        calc.setValues(km, time, pauses);

        String pace = formatPace(calc.calculatePace());
        resultPace.setText(pace + " " + getText(R.string.text_result_pace_suffix));
        resultKCal.setText(calc.calculateKcal() + " " + getText(R.string.text_result_kcal_suffix));
    }

    private String formatPace(double pace) {
        int min = (int) pace;
        pace -= min;
        int sec = (int) (60*pace);
        return min+":"+sec;
    }

    // back-button functionality
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
